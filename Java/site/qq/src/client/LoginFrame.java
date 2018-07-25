package client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import stream.ServerClientConnectionStream;
import user.UserInformation;

@SuppressWarnings("unused")
public class LoginFrame extends JFrame
{

    /**
     * @author CSJ
     */
    private static final long serialVersionUID = 1L;
    private final int SERVER_PORT = 9000;
    private ServerClientConnectionStream userCS;
    private String userName;
    private int userPort;
    private JLabel register;
    private JLabel findPassword;
    private JCheckBox remPassword;
    private JCheckBox autoLogin;
    private String message;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JPanel jPanel_1;
    private JPanel jPanel_2;
    private JPanel jPanel_3;
    private JButton login;
    private Socket socket;
    private InetAddress SERVER_INETADRESS;
    private InetAddress LOCAL_INETADRESS;
    private UserInformation userInfo;

    public LoginFrame() throws HeadlessException
    {
        initData();
        createFrame();
        addHandlerEvent();
    }

    @SuppressWarnings("resource")
    private void initData()
    {
        userInfo = new UserInformation();
        try
        {
            DatagramSocket d = new DatagramSocket();
            userPort = d.getLocalPort();
            d.close();
            SERVER_INETADRESS = InetAddress.getLocalHost();
            LOCAL_INETADRESS = InetAddress.getLocalHost();
            socket = new Socket(SERVER_INETADRESS, SERVER_PORT, LOCAL_INETADRESS, new DatagramSocket().getLocalPort());
            userCS = new ServerClientConnectionStream(socket);
        } catch (UnknownHostException e)
        {
            System.out.println("�Ҳ��� host ���κ� IP ��ַ!");
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("�����׽���ʱ���� I/O ����!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void createFrame()
    {
        setTitle("��½");
        Random random = new Random();
        //ImageIcon image1 = new ImageIcon(getClass().getResource("\\pictures\\qq.png"));
        //JLabel imageLable = new JLabel(image1);
        int num = (random.nextInt(38) + 1);
        userInfo.setUserPortraitNum(num);
        //ImageIcon portraItImage = new ImageIcon(getClass().getResource("\\pictures\\portrait-" + num + ".jpg"));
        //portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        //JLabel portraItImageLable = new JLabel(portraItImage);
        JPanel mainLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        accountField = new JTextField(15);
        login = new JButton("��ȫ��¼");
        login.setBackground(new Color(30, 144, 255));
        login.setForeground(Color.white);
        login.setPreferredSize(new Dimension(170, 30));
        passwordField = new JPasswordField(15);
        JPanel jPanel_0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JPanel passRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JPanel accPassHintPanel = new JPanel(new GridLayout(3, 15, 0, 0));
        register = new JLabel("ע���˺�");
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.setForeground(Color.BLUE);
        findPassword = new JLabel("�һ�����");
        findPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        findPassword.setForeground(Color.BLUE);
        remPassword = new JCheckBox("��ס����");
        autoLogin = new JCheckBox("�Զ���¼");
        accRes.add(accountField);
        accRes.add(register);
        passRes.add(passwordField);
        passRes.add(findPassword);
        accPassHintPanel.add(accRes);
        accPassHintPanel.add(passRes);
        jPanel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        jPanel_2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 1));
        jPanel_3 = new JPanel();
        //jPanel_0.add(imageLable);
        jPanel_3.add(login);
        jPanel_2.add(remPassword);
        jPanel_2.add(autoLogin);
        accPassHintPanel.add(jPanel_2);
        mainLayout.add(jPanel_0);
        //jPanel_1.add(portraItImageLable);
        jPanel_1.add(accPassHintPanel);
        mainLayout.add(jPanel_1);
        mainLayout.add(jPanel_3);
        add(mainLayout);
        setVisible(true);
        setSize(445, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int height = getHeight();
        int width = getWidth();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        setLocation(screenWidth - width / 2, screenHeight - height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void addHandlerEvent()
    {
        login.addActionListener(new ActionListener()
        {
            // ��־ IP �˿ں� ���� �˺� ����
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                System.out.println("�ѿ�ʼ����������͵�¼����...");
                try
                {
                    userCS.send("%LOGIN%:" + InetAddress.getLocalHost().getHostAddress() + ":" + userPort + ":" + ""
                            + ":" + accountField.getText() + ":" + String.valueOf(passwordField.getPassword()).trim()
                            + ":" + userInfo.getUserPortraitNum());
                } catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }

                System.out.println("�ȴ����������ص�¼���...");
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        while (true)
                        {
                            message = userCS.read();
                            if ("LOGIN_FIAL".equals(message))
                            {
                                JOptionPane.showMessageDialog(null, "������ͬ���˺ţ�����������");
                                accountField.setText("");
                                passwordField.setText("");
                            } else if ("NAME_IS_NULL".equals(message))
                            {
                                // setVisible(false);
                                dispose();
                                userName = JOptionPane.showInputDialog(null, "�����Լ�������ְ�");
                                try
                                {
                                    // ��־ IP �˿ں� ���� �˺� ����
                                    userCS.send("%LOGIN%:" + InetAddress.getLocalHost().getHostAddress() + ":"
                                            + userPort + ":" + userName + ":" + accountField.getText() + ":"
                                            + String.valueOf(passwordField.getPassword()).trim() + ":"
                                            + userInfo.getUserPortraitNum());
                                    userInfo.setIP(InetAddress.getLocalHost().getHostAddress());
                                    userInfo.setRecenIP(InetAddress.getLocalHost().getHostAddress());
                                    userInfo.setRecentPort(userPort);
                                    System.out.println("������������·�������Ϣ...");
                                } catch (UnknownHostException e)
                                {
                                    e.printStackTrace();
                                }
                            } else if ("LOGIN_SUCESSFULLY".equals(message))
                            {
                                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                userInfo.setAccount(accountField.getText());
                                userInfo.setName(userName);
                                userInfo.setPort(userPort);
                                LoginProcess loginProcess = new LoginProcess(userInfo.getUserPortraitNum());
                                try
                                {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                loginProcess.dispose();
                                new ChatRoomUserListFrame(userCS, userInfo).showMe();
                                JOptionPane.showMessageDialog(null, "��¼�ɹ���");
                            }
                        }
                    }
                }).start();
            }
        });

        register.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null, "��������δ���ţ�");
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
        });
        findPassword.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseClicked(MouseEvent e)
            {
                JOptionPane.showMessageDialog(null, "��������δ���ţ�");

            }
        });
        remPassword.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "��������δ���ţ�");

            }
        });
        autoLogin.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "��������δ���ţ�");
            }
        });

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
