package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import readThread.ReadMessageFromClientThread;
import user.UserInformation;
import stream.ClientToClientConnectionStream;
import tools.MyMap;

public class ChatRoomClientFrame extends JFrame implements ActionListener
{

    /**
     * @author CSJ
     */
    private static final long serialVersionUID = 1L;
    private JTextArea chatTextArea;
    private JButton send;
    private JTextField inputField;
    private JLabel currentUserNameTitleLabel;
    private JTextArea userInfoListArea;
    private SimpleDateFormat simpleDateFormat;
    private UserInformation myUserInfo;
    private UserInformation toUserInfo;
    private JLabel userSignatureLable;
    private BufferedReader reader;
    private ClientToClientConnectionStream userDataCS;
    private ReadMessageFromClientThread readMessageFromClientThread;
    private Thread readMessageThread;
    private MyMap isOpenMap;
    private JPanel userInfoPanel;

    // ���� �˻� IP
    public ChatRoomClientFrame(UserInformation toUserInfo, UserInformation myUserInfo, MyMap isOpenMap)
            throws HeadlessException
    {
        super("������" + toUserInfo.getName() + "(" + toUserInfo.getAccount() + ")" + "������...");
        this.toUserInfo = toUserInfo;
        this.myUserInfo = myUserInfo;
        this.isOpenMap = isOpenMap;
        DatagramSocket dataSocket = null;
        try
        {
            dataSocket = new DatagramSocket();

        } catch (SocketException e)
        {
            e.printStackTrace();
        }
        try
        {
            userDataCS = new ClientToClientConnectionStream(dataSocket, InetAddress.getByName(toUserInfo.getIP()),
                    toUserInfo.getPort());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        userDataCS.send("%TEST%");
        simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
        simpleDateFormat.applyPattern("yyyy��MM��dd��HHʱmm��ss��");
        createFrame();
        addEventHandler();
    }

    private void createFrame()
    {
        chatTextArea = new JTextArea(25, 60);
        chatTextArea.setEditable(false);
        userInfoListArea = new JTextArea();
        userInfoListArea.setEditable(false);
        JScrollPane centerScrollPane = new JScrollPane(chatTextArea);
        send = new JButton("����");
        inputField = new JTextField(35);
        currentUserNameTitleLabel = new JLabel(toUserInfo.getName() + "(" + toUserInfo.getAccount() + ")");
        currentUserNameTitleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 25));
        Random random = new Random();
        userInfoPanel = new JPanel(new GridLayout(2, 2, 5, 6));
        userInfoPanel.add(currentUserNameTitleLabel);
        try
        {
            reader = new BufferedReader(
                    new FileReader(new File(new File("").getAbsolutePath() + File.separator + "res" + File.separator
                            + "signatures" + File.separator + "signature-" + (random.nextInt(8) + 1) + ".txt")));
            userSignatureLable = new JLabel(reader.readLine());
            userInfoPanel.add(userSignatureLable);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        userInfoListArea.setText("IP��ַ��" + toUserInfo.getIP() + "\n�˿ں�(UDP)��" + toUserInfo.getPort() + "\n�ǳƣ�"
                + toUserInfo.getName() + "\n�˻���" + toUserInfo.getAccount());
        ImageIcon portraItImage = new ImageIcon(
                getClass().getResource("\\pictures\\portrait-" + toUserInfo.getUserPortraitNum() + ".jpg"));

        portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel portraItImageLable = new JLabel(portraItImage);
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        northPanel.add(portraItImageLable, BorderLayout.NORTH);
        JPanel southPanel = new JPanel();
        northPanel.add(userInfoPanel);
        southPanel.add(inputField);
        southPanel.add(send);
        JScrollPane listScrollPane = new JScrollPane(userInfoListArea);
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(new JLabel("�Է���Ϣ�б�"), BorderLayout.NORTH);
        eastPanel.add(listScrollPane, BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);
        add(centerScrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String message = inputField.getText();
        if (message == null || message.trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "���ܷ��Ϳ���Ϣ��");
        } else
        {
            String time = simpleDateFormat.format(new Date());
            if (userDataCS != null)
            {
                userDataCS.send(myUserInfo.getName() + "-" + myUserInfo.getAccount() + "-"
                        + myUserInfo.getUserPortraitNum() + "-" + myUserInfo.getRecenIP() + "-"
                        + myUserInfo.getRecentPort() + "-" + "(" + time + ")\n" + message);
                chatTextArea.append("��" + "(" + time + ")\n" + message + "\n");
                inputField.setText("");
            }
        }
    }

    private void addEventHandler()
    {
        inputField.addActionListener(this);
        send.addActionListener(this);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int t = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���������", "ȷ���˳�", JOptionPane.OK_CANCEL_OPTION);
                if (t == JOptionPane.OK_OPTION)
                {
                    userDataCS.send("I_HAVE_EXIT_THE_WINDOW");
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e1)
                    {
                        e1.printStackTrace();
                    }
                    readMessageThread.interrupt();
                    readMessageFromClientThread.stopMe();
                    isOpenMap.replace(toUserInfo.getAccount(), false);

                    System.out.println("isOpenMap.replace(toUserInfo.getAccount()?" + toUserInfo.getAccount() + "--��"
                            + isOpenMap.getValue(toUserInfo.getAccount()));
                    System.out.println("�����Ѿ��رգ�");
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        });
    }

    public ChatRoomClientFrame showMe()
    {
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        readMessageFromClientThread = new ReadMessageFromClientThread(userDataCS, chatTextArea, toUserInfo);
        readMessageThread = new Thread(readMessageFromClientThread);
        readMessageThread.start();
        return this;
    }

    public JTextArea getChatTextArea()
    {
        return chatTextArea;
    }

    public void setChatTextArea(JTextArea chatTextArea)
    {
        this.chatTextArea = chatTextArea;
    }

    public ClientToClientConnectionStream getUserDataCS()
    {
        return userDataCS;
    }

    public void setUserDataCS(ClientToClientConnectionStream userDataCS)
    {
        this.userDataCS = userDataCS;
    }
}