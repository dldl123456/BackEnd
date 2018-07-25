package Demo;
import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * javaʵ������
 */
public class Robot {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        PrintWriter pw = null;
//        String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//urlƥ�����
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("https://www.rndsystems.com/cn");//��ȡ����ַ��������ȡ����һ��������վ
            urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:/SiteURL.txt"), true);//����ȡ�������ӷŵ�D�̵�SiteURL�ļ���
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            System.out.println("��ȡ�ɹ�^_^");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}