package server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import stream.ServerClientConnectionStream;
import user.UserInformation;

public class ChatRoomServerFrame extends JFrame
{

    /**
     * @author CSJ
     */
    private static final long serialVersionUID = 1L;
    private Map<String, ServerClientConnectionStream> userMap;
    private Set<UserInformation> userSet;
    private ServerSocket serverSocket;
    private JButton start;
    private JLabel welcome;
    private JTextArea hintInfo;
    private JTextArea onlineUserInfo;
    private JTextArea startInfoTextArea;

    public ChatRoomServerFrame()
    {
        super();
        userMap = new HashMap<String, ServerClientConnectionStream>();
        userSet = new HashSet<UserInformation>();
        welcome = new JLabel("��������");
        hintInfo = new JTextArea("��ǰ״̬��������δ������\n");
        startInfoTextArea = new JTextArea();
        startInfoTextArea.setEditable(false);
        hintInfo.setEditable(false);
        onlineUserInfo = new JTextArea();
        onlineUserInfo.setEditable(false);
        createFrame();
        addEventHandler();
    }

    private void createFrame()
    {
        start = new JButton("����������");
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JScrollPane hintPanel = new JScrollPane(hintInfo);
        JScrollPane onlineUserInfoPanel = new JScrollPane(onlineUserInfo);
        JScrollPane startInfoScrollPanel = new JScrollPane(startInfoTextArea);
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(welcome);
        JPanel southPanel = new JPanel();
        southPanel.add(start);
        jTabbedPane.add("״̬", hintPanel);
        jTabbedPane.add("��������", startInfoScrollPanel);
        jTabbedPane.add("�����û�����", onlineUserInfoPanel);
        setSize(400, 600);
        setVisible(true);
        add(welcomePanel, BorderLayout.NORTH);
        add(jTabbedPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int height = getHeight();
        int width = getWidth();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        setLocation(screenWidth - width / 2, screenHeight - height / 2);
    }

    public void addEventHandler()
    {
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                try
                {
                    serverSocket = new ServerSocket(9000);
                    new Thread(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            startServer();
                        }
                    }).start();
                    JOptionPane.showMessageDialog(null, "��������������");
                } catch (IOException e)
                {
                    JOptionPane.showMessageDialog(null, "��������������");
                    e.printStackTrace();
                }
            }
        });

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int t = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���������", "ȷ���˳�", JOptionPane.OK_CANCEL_OPTION);
                if (t == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
                }
            }
        });
    }

    private void startServer()
    {
        while (true)
        {
            try
            {
                System.out.println("��ʼ�����ͻ�������...");
                startInfoTextArea.append("��ʼ�����ͻ�������...\n");
                printServerInfo();
                Socket socket = serverSocket.accept();
                startInfoTextArea.append("�Ѵӿͻ���IP��" + socket.getInetAddress().getHostAddress() + ",�˿ں�(TCP)��"
                        + socket.getPort() + "���յ�����...\n");
                new Thread(new ChatRoomServerThread(new ServerClientConnectionStream(socket), userSet, userMap,
                        hintInfo, startInfoTextArea, onlineUserInfo)).start();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } // while
    }

    private void printServerInfo()
    {
        hintInfo.setText("��ǰ״̬����ʼ�����ͻ�������...");
        try
        {
            hintInfo.append("\n���������ƣ�" + InetAddress.getLocalHost().getHostName());
            hintInfo.append("\n������IP��ַ��" + InetAddress.getLocalHost().getHostAddress());
            hintInfo.append("\n�����˿ڣ�9000");
            hintInfo.append("\n��ǰ����������" + userMap.size());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
