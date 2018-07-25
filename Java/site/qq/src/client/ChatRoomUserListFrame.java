package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import readThread.ReadMessageFromServerThread;
import stream.ClientToClientConnectionStream;
import stream.ServerClientConnectionStream;
import user.UserInformation;
import tools.MyMap;

@SuppressWarnings("unused")
public class ChatRoomUserListFrame extends JFrame
{

    /**
     * @author CSJ
     */
    private static final long serialVersionUID = 2L;
    private MyMap isOnlineMap;
    private MyMap isOpenMap;
    private ServerClientConnectionStream userCS;
    private JList<String> currentOnlineUserList;
    private Map<String, String> userInfoMap;
    private DatagramSocket dataSocket;
    private UserInformation userInfo;
    private ReadMessageFromServerThread readMessageFromServerThread;
    private Thread readMessagehread;
    private ChatRoomClientFrame chatRoomClientFrame;
    private Map<String, ChatRoomClientFrame> chatRoomMap = new HashMap<String, ChatRoomClientFrame>();

    public ChatRoomUserListFrame(ServerClientConnectionStream userCS, UserInformation userInfo) throws HeadlessException
    {
        super("MYQQ�����V1.0");
        this.userCS = userCS;
        this.userInfo = userInfo;
        initData();
        createFrame();
        addEventHandler();
        autoListening();
    }

    private void initData()
    {
        isOnlineMap = new MyMap();
        isOpenMap = new MyMap();
        userInfoMap=new HashMap<String, String>();
        try
        {
            dataSocket = new DatagramSocket(userInfo.getPort());
        } catch (SocketException e)
        {
            e.printStackTrace();
        }
    }

    private void createFrame()
    {
        currentOnlineUserList = new JList<String>();
        currentOnlineUserList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /*ImageIcon portraItImage = new ImageIcon(
                getClass().getResource("\\pictures\\portrait-" + userInfo.getUserPortraitNum() + ".jpg"));*/
        //portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        //JLabel portraItImageLable = new JLabel(portraItImage);
        JScrollPane listScrollPane = new JScrollPane(currentOnlineUserList);
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        //northPanel.add(portraItImageLable, BorderLayout.NORTH);
        JPanel userInfoPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        JLabel userInfoLable = new JLabel(hour < 6 ? "�賿�ã�" + userInfo.getName()
                : (hour < 12 ? "����ã�" : (hour < 18 ? "����ã�" : "���Ϻã�")) + userInfo.getName());
        userInfoPanel.add(userInfoLable);
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getInstance();
        simpleDateFormat.applyPattern("yyyy��MM��dd��    E");
        JLabel userTimeLable = new JLabel(simpleDateFormat.format(new Date()));
        userInfoPanel.add(userTimeLable);
        northPanel.add(userInfoPanel);
        centerPanel.add(new JLabel("�����û��б�"), BorderLayout.CENTER);
        centerPanel.add(listScrollPane, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = getWidth();
        int screenWidth = screenSize.width / 2;
        setLocation(screenWidth - width / 2, 0);
        setResizable(false);
    }

    public void autoListening()
    {
        final ClientToClientConnectionStream userDataSoketCS = new ClientToClientConnectionStream(dataSocket);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    String string = userDataSoketCS.read();
                    System.out.println("�Զ�������ȡ����" + string + "�˿ںţ�" + userDataSoketCS.getUserReceivePacket().getPort());
                    if (!"%TEST%".equals(string) && !"I_HAVE_EXIT_THE_WINDOW".equals(string))
                    {
                        String tString[] = string.split("-");
                        if (isOpenMap.getValue(tString[1]) == true)
                        {
                            chatRoomMap.get(tString[1]).getUserDataCS()
                                    .setHostAddress(userDataSoketCS.getUserReceivePacket().getAddress());
                            chatRoomMap.get(tString[1]).getUserDataCS()
                                    .setPort(userDataSoketCS.getUserReceivePacket().getPort());
                            chatRoomMap.get(tString[1]).getUserDataCS().send("%TEST%");
                            chatRoomMap.get(tString[1]).getChatTextArea().append(string + "\n");

                        } else
                        {
                            int t = JOptionPane.showConfirmDialog(null, tString[0] + "��������һ����Ϣ���Ƿ���գ�", "ȷ��",
                                    JOptionPane.YES_NO_OPTION);
                            if (t == JOptionPane.YES_OPTION)
                            {
                                UserInformation toUserInfo = new UserInformation(tString[0], tString[1],
                                        userDataSoketCS.getUserReceivePacket().getAddress().getHostAddress(),
                                        userDataSoketCS.getUserReceivePacket().getPort(), Integer.parseInt(tString[2]),
                                        tString[3], Integer.parseInt(tString[4]));
                                chatRoomClientFrame = new ChatRoomClientFrame(toUserInfo, userInfo, isOpenMap).showMe();
                                StringBuffer tMessage = new StringBuffer();
                                tMessage.append(tString[0]);
                                tMessage.append(tString[5]);
                                chatRoomClientFrame.getChatTextArea().append(tMessage + "\n");
                                isOpenMap.replace(tString[1], true);
                                chatRoomMap.put(tString[1], chatRoomClientFrame);
                            }
                        }
                    }

                }
            }

        }).start();
    }

    private void addEventHandler()
    {
        currentOnlineUserList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (!e.getValueIsAdjusting())
                {
                    String tString = (String) currentOnlineUserList.getSelectedValue();
                    if (tString != null)
                    {
                        String t[] = tString.split("��");
                        String[] string = t[1].split("��");
                        // ����-�˺�-IP-�˿�
                        if (string[0].equals(userInfo.getAccount()))
                        {
                            JOptionPane.showMessageDialog(null, "����ѡ���Լ���");
                        } else
                        {
                            String tempUserInfo[]= userInfoMap.get(string[0]).split("-");
                            UserInformation toUserInfo = new UserInformation(tempUserInfo[3], tempUserInfo[2], tempUserInfo[0],
                                    Integer.parseInt(tempUserInfo[1]), Integer.parseInt(tempUserInfo[4]), tempUserInfo[0],
                                    Integer.parseInt(tempUserInfo[1]));
                            chatRoomClientFrame = new ChatRoomClientFrame(toUserInfo, userInfo, isOpenMap);
                            chatRoomClientFrame.showMe();
                            chatRoomMap.put(tempUserInfo[1], chatRoomClientFrame);
                            isOpenMap.replace(tempUserInfo[1], true);
                        }
                    }
                }

            }
        });

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int t = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳��ͻ�����\n��ܰ��ʾ���˳���ͬʱ�ر��������촰��", "ȷ���˳�",
                        JOptionPane.OK_CANCEL_OPTION);
                if (t == JOptionPane.OK_OPTION)
                {
                    readMessagehread.interrupt();
                    readMessageFromServerThread.stopMe();
                    userCS.send("%EXIT%:" + userInfo.getAccount());
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e1)
                    {
                        e1.printStackTrace();
                    }
                    userCS.send("%EXIT%:" + userInfo.getAccount());
                    try
                    {
                        Thread.sleep(100);
                    } catch (InterruptedException e1)
                    {
                        e1.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
    }

    public void showMe()
    {
        setSize(340, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        readMessageFromServerThread = new ReadMessageFromServerThread(userCS,  userInfoMap, currentOnlineUserList,
                isOnlineMap, isOpenMap);
        readMessagehread = new Thread(readMessageFromServerThread);
        readMessagehread.start();
    }
}
