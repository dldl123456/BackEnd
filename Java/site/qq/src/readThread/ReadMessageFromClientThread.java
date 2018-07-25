package readThread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JTextArea;
import stream.ClientToClientConnectionStream;
import user.UserInformation;

public class ReadMessageFromClientThread implements Runnable
{

    /**
     * @author CSJ
     */
    private ClientToClientConnectionStream userDataCS;
    private JTextArea chatTextArea;
    private UserInformation toUserInfo;
    private volatile boolean stop = false;

    public ReadMessageFromClientThread(ClientToClientConnectionStream userDataCS, JTextArea chatTextArea,
            UserInformation toUserInfo)
    {
        super();
        this.userDataCS = userDataCS;
        this.chatTextArea = chatTextArea;
        this.toUserInfo = toUserInfo;
    }

    @Override
    public void run()
    {
        while (!stop)
        {
            synchronized (this)
            {
                System.out.println("�ͻ���--�ͻ��˶�ȡ��Ϣ�߳���������");
                if (userDataCS != null)
                {
                    String message = userDataCS.read();
                    System.out.println(message);
                    if ("%TEST%".equals(message))
                    {
                        System.out.println("�ͻ�����ԭIP��" + userDataCS.getHostAddress() + "ԭ�˿ڣ�" + userDataCS.getPort());
                        userDataCS.setHostAddress(userDataCS.getUserReceivePacket().getAddress());
                        userDataCS.setPort(userDataCS.getUserReceivePacket().getPort());
                        System.out.println("�ͻ�������IP��" + userDataCS.getHostAddress() + "���ڶ˿ڣ�" + userDataCS.getPort());
                    } else if ("I_HAVE_EXIT_THE_WINDOW".equals(message))
                    {
                        try
                        {
                            userDataCS.setHostAddress(InetAddress.getByName(toUserInfo.getRecenIP()));
                            userDataCS.setPort(toUserInfo.getRecentPort());
                        } catch (UnknownHostException e)
                        {
                            e.printStackTrace();
                        }
                    } else
                    {
                        String tString[] = message.split("-");
                        System.out.println("�ͻ���--�ͻ���(IP:" + userDataCS.getHostAddress() + "�˿�(UDP)��"
                                + userDataCS.getPort() + ")��ȡ����Ϣ:" + message);
                        StringBuffer tMessage = new StringBuffer();
                        tMessage.append(tString[0]);
                        tMessage.append(tString[5]);
                        chatTextArea.append(tMessage + "\n");
                    }
                }
            }
        }
    }

    public void stopMe()
    {
        stop = true;
    }
}
