package connection;

import connection.ConnectionUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyze {

    //ʹ��ʱ���ô˷���������uid���� 5ef5edbdc64c1bb49e9d6899�����ص���һ���ַ��������Դ�ӡ������һ��
    public String regexMain(String uid) {
        String url="http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid="+uid;
        String result = ConnectionUtil.Connect(url);
        return getHouseInfo(result);
    }

    @SuppressWarnings("unused")
	private String getHouseInfo(String targetStr) {

        StringBuilder lastInfo=new StringBuilder();
        //��ȡͼƬurl
        Pattern imgpattern=Pattern.compile("<img class=\"img-large\".*\" />");
        Matcher imgmatcher=imgpattern.matcher(targetStr);
        while (imgmatcher.find()){
            String imgString=imgmatcher.group();
            int n=imgString.lastIndexOf("=\"");
            String imgUrl=imgString.substring(n+2,imgString.length()-3);
//System.out.println("imgRul:"+imgUrl);
            lastInfo.append("ͼƬurl:"+imgUrl+"\n");
        }
        //������ȡ������������Ϣ��htmlƬ�Σ��ٷֱ���
        Pattern pattern1 = Pattern
                .compile("fcg\">\\w*.+\\s*<dd>\\w*.+</dd>");
        Matcher matcher1 = pattern1.matcher(targetStr);
        String info = "";
        
        while (matcher1.find()) {
            info = matcher1.group();                //��ȡ����Ƭ��
            Pattern pattern2 = Pattern
                    .compile("f24 fcr\">[0-9]+");
            Matcher matcher2 = pattern2.matcher(info);
            while (matcher2.find()) {

                String price = matcher2.group().substring(9);    //��ȡ���۸�
//System.out.println("�۸�" + price);
                lastInfo.append("�۸�:"+price+"Ԫ/ƽ��\n");
            }

            Pattern pattern3 = Pattern
                    .compile("�������ͣ�</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher3 = pattern3.matcher(info);
            String houseType = "";            //�����е�û��
            while (matcher3.find()) {
                int n = matcher3.group().lastIndexOf(">");
                houseType = matcher3.group().substring(n + 1);
            }
//System.out.println("�������ͣ�" + houseType);
            lastInfo.append("��������:"+houseType+"\n");
            //��������ͬ��
            Pattern pattern4 = Pattern
                    .compile("�������ͣ�</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher4 = pattern4.matcher(info);
            String blockType = "";            //�����е�
            while (matcher4.find()) {
                int n = matcher4.group().lastIndexOf(">");
                blockType = matcher4.group().substring(n + 1);
            }
//System.out.println("�������ͣ�" + blockType);
            lastInfo.append("��������:"+blockType+"\n");
            //�������
            Pattern pattern5 = Pattern
                    .compile("���������</dt>\\s*<dd>[0-9]+");
            Matcher matcher5 = pattern5.matcher(info);
            String blockAge = "";            //�����е�û��
            while (matcher5.find()) {
                int n = matcher5.group().lastIndexOf(">");
                blockAge = matcher5.group().substring(n + 1);
            }
//System.out.println("���������" + blockAge);
            lastInfo.append("�������:"+blockAge+"\n");
            //�ݻ���
            Pattern pattern6 = Pattern
                    .compile("�ݻ��ʣ�</dt>\\s*<dd>[0-9]+\\.[0-9]+");
            Matcher matcher6 = pattern6.matcher(info);
            String FAR = "";            //�����е�û��
            while (matcher6.find()) {
                int n = matcher6.group().lastIndexOf(">");
                FAR = matcher6.group().substring(n + 1);
            }
//System.out.println("�ݻ��ʣ�" + FAR);
            lastInfo.append("�ݻ���:"+FAR+"\n");
            //��ҵ��
            Pattern pattern9 = Pattern
                    .compile("��ҵ�ѣ�</dt>\\s*<dd>[0-9]+\\.[0-9]+");
            Matcher matcher9 = pattern9.matcher(info);
            String fee = "";            //�����е�û��
            while (matcher9.find()) {
                int n = matcher9.group().lastIndexOf(">");
                fee = matcher9.group().substring(n + 1);
            }
//System.out.println("��ҵ�ѣ�" + fee);
            lastInfo.append("��ҵ��:"+fee+"Ԫ/ƽ��/��\n");
            //��ҵ��˾
            Pattern pattern7 = Pattern
                    .compile("��ҵ��˾��</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher7 = pattern7.matcher(info);
            String pManage = "";            //�����е�û��
            while (matcher7.find()) {
                int n = matcher7.group().lastIndexOf(">");
                pManage = matcher7.group().substring(n + 1);
            }
//System.out.println("��ҵ��˾��" + pManage);
            lastInfo.append("��ҵ��˾:"+pManage+"\n");
            //������
            Pattern pattern8 = Pattern
                    .compile("�����̣�</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher8 = pattern8.matcher(info);
            String company = "";            //�����е�û��
            while (matcher8.find()) {
                int n = matcher8.group().lastIndexOf(">");
                pManage = matcher8.group().substring(n + 1);
            }
//System.out.println("�����̣�" + pManage);
            lastInfo.append("������:"+pManage+"\n");
        }
        return lastInfo.toString();
    }

}
