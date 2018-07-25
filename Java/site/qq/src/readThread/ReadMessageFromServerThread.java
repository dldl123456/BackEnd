package readThread;

import java.util.Map;

import javax.swing.JList;
import javax.swing.JOptionPane;

import stream.ServerClientConnectionStream;
import tools.MyMap;

public class ReadMessageFromServerThread implements Runnable {

    /**
     * @author CSJ
     */
    private ServerClientConnectionStream userCS;
    private String onlineUserList[];
    private MyMap isOnlineMap;
    private JList<String> currentOnlineUserList;
    private volatile boolean stop = false;
    private MyMap isOpenMap;
    private Map<String, String> userInfoMap;
    private String loginName;

    public ReadMessageFromServerThread(ServerClientConnectionStream userCS,
            Map<String, String> userInfoMap, JList<String> currentOnlineUserList,
            MyMap isOnlineMap, MyMap isOpenMap) {
        super();
        this.userCS = userCS;
        this.userInfoMap=userInfoMap;
        this.isOnlineMap = isOnlineMap;
        this.isOpenMap = isOpenMap;
        this.currentOnlineUserList = currentOnlineUserList;
    }

    public void refreshGUIUserList() {
        StringBuffer t = new StringBuffer();
        System.out.println("�ڷ�����--�ͻ����߳���ˢ���û����棡");
        for (String string : onlineUserList)
        {
            // ���� �˺� IP-�˿� ͷ�����--
            String per[] = string.split("-");
            if (!per[2].equals(loginName))
            {
                System.out.println(per[2]);
                isOnlineMap.put(per[2], false);
                isOpenMap.put(per[2], false);
            }
            t.append(per[3] + "��" + per[2]+ "��"+":");
            userInfoMap.put(per[2], string);
        }
        String tt[] = t.toString().split(":");
        currentOnlineUserList.setListData(tt);
    }

    @Override
    public void run()
    {
        while (!stop)
        {

                System.out.println("������--�ͻ��˶�ȡ��Ϣ�߳���������");
                String message = userCS.read();
                if (message != null)
                {
                    System.out.println("������--�ͻ��˶�ȡ��Ϣ�߳���������" + message);
                    String perMessage[] = message.split(":");
                    loginName = perMessage[1];
                    if ("%USER_LIST%".equals(perMessage[0]))
                    {
                        onlineUserList = perMessage[2].split(",");
                        if ("LOGIN".equals(perMessage[1].split("&")[1]))
                        {
                            isOnlineMap.put(perMessage[1].split("&")[0], true);
                            isOpenMap.put(perMessage[1].split("&")[0], false);
                        } else if ("EXIT".equals(perMessage[1].split("&")[1]))
                        {
                            if (isOpenMap.getValue(perMessage[1].split("&")[0]) == true)
                            {
                                JOptionPane.showMessageDialog(null, "�Է������ߣ�");
                            }
                            isOnlineMap.replace(perMessage[1].split("&")[0], false);
                            isOpenMap.replace(perMessage[1].split("&")[0], false);
                        }
                        refreshGUIUserList();
                    }
                }

        }
    }

    public void stopMe() {
        stop = true;
    }
}
