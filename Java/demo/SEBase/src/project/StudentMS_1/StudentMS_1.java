package project.StudentMS_1;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
  
public class StudentMS_1 { 
  public static void main(String[] args) { 
    StudentSys stuSys=new StudentSys("ѧ������ϵͳ"); 
    stuSys.initWin(); 
  }  
} 
class StudentSys extends JFrame{ 
    
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel p1,p2,p3,combop; 
  private JTabbedPane tab; 
  private Container container; 
  private JButton b1,b2; 
  private Listener listener; 
  private Label nameLabel; 
  private Label gradeLabel; 
  private Label showLabel; 
  private JTextField textName; 
  private JTextField textGrade; 
  private TextArea showGradeArea; 
  /* 
  * ���� 
  * */ 
  private Label searchLabel; 
  private JTextField searchText; 
  private JButton sBut; 
  private JTextField resultText; 
  private String[] name; 
  private String[] grade; 
    
  /* 
  * ���� 
  * */ 
  private TextArea showTextArea; 
  private JButton sortBut; 
  private int countNum=0; 
  private JButton clearBut; 
  public StudentSys(String str){ 
    super(str); 
      
    this.name=new String[100]; 
    this.grade=new String[100]; 
    listener = new Listener(); 
    tab = new JTabbedPane(JTabbedPane.TOP);  
    //���� 
    container = this.getLayeredPane(); 
    //������� 
    combop = new JPanel(); 
    p1 = new JPanel(); 
    p2 = new JPanel(); 
    p3 = new JPanel(); 
      
    b1 =new JButton("ȷ�����"); 
    b2 =new JButton("�������"); 
    nameLabel =new Label("����"); 
    gradeLabel =new Label("�ɼ�"); 
      
    showLabel=new Label("��ǰ��¼Ϊ�㣡             "); 
      
    textName =new JTextField(15); 
    textGrade =new JTextField(15); 
    showGradeArea=new TextArea(); 
      
    /* 
    * ���� 
    * */ 
    searchLabel=new Label("������������"); 
    searchText=new JTextField(15); 
    sBut=new JButton("ȷ�ϲ���"); 
    resultText=new JTextField(15); 
    /* 
    * ���� 
    * */ 
    showTextArea=new TextArea(); 
    sortBut=new JButton("�ɼ�����"); 
    clearBut=new JButton("�������"); 
  } 
  public void initWin(){ 
    this.setBounds(300, 300, 500, 400); 
    this.addWindowListener(new WindowAdapter(){ 
      public void windowClosing(WindowEvent e) { 
        super.windowClosing(e); 
        System.exit(0); 
      }}); 
      layoutWin(); 
      this.setVisible(true); 
  } 
  private void layoutWin(){ 
      
    tab.add(p1,"�ɼ�����"); 
    tab.add(p2,"�ɼ���ѯ"); 
    tab.add(p3,"�ɼ�����"); 
    combop.add(new JLabel("ѧ����Ϣ����ϵͳ")); 
    container.setLayout(new BorderLayout()); 
    container.add(combop,BorderLayout.NORTH); 
    container.add(tab,BorderLayout.CENTER); 
      
    Container con1=new Container(); 
    con1.setLayout(new FlowLayout()); 
    con1.add(nameLabel); 
    con1.add(textName); 
      
    con1.add(gradeLabel); 
    con1.add(textGrade); 
    p1.add(con1,BorderLayout.NORTH); 
    p1.add(con1); 
    p1.add(showGradeArea); 
      
    Container con2=new Container(); 
    con2.setLayout(new FlowLayout()); 
    con2.add(b1); 
    con2.add(b2); 
    con2.add(showLabel); 
    p1.add(con2); 
    b1.addActionListener(listener); 
    b2.addActionListener(listener); 
    /* 
    * ���Ҳ��� 
    * */ 
      
    Container con3=new Container(); 
    con3.setLayout(new FlowLayout()); 
    con3.add(searchLabel); 
    con3.add(searchText); 
    con3.add(sBut); 
    p2.add(con3,BorderLayout.NORTH); 
    sBut.addActionListener(listener); 
    p2.add(resultText); 
    /* 
    * ���򲼾� 
    * */ 
    p3.add(showTextArea); 
    p3.add(sortBut); 
    p3.add(clearBut); 
    sortBut.addActionListener(listener); 
    clearBut.addActionListener(listener); 
  } 
  /* 
  * java�ڲ���ʵ��ActionListener�ӿ� 
  * */
  class Listener implements ActionListener{ 
    @Override
      public void actionPerformed(ActionEvent e) { 
        
      if(e.getSource()==b1){ 
          
        if((textName.getText().equals(""))||(textGrade.getText().equals(""))){ 
          showLabel.setText("���ʧ��(����,�ɼ������п�)��"); 
        } 
        else{ 
          name[countNum]=textName.getText(); 
          grade[countNum]=textGrade.getText(); 
          countNum++; 
          String area="��ӳɹ�,��ǰ��"+countNum+"����¼"; 
          showLabel.setText(area); 
          sortMess(false); 
          textName.setText(""); 
          textGrade.setText(""); 
        } 
          
      } 
      if(e.getSource()==b2){ 
        if(countNum>0){ 
          countNum--; 
          String area="���سɹ�,��ǰ��"+countNum+"����¼"; 
          showLabel.setText(area); 
          sortMess(false); 
        } 
      } 
      if(e.getSource()==sBut){ 
        if(!searchText.getText().equals("")){ 
          searchMess(searchText.getText()); 
        } 
      } 
      if(e.getSource()==sortBut){ 
        sortMess(true); 
      } 
      if(e.getSource()==clearBut){ 
        if(!showTextArea.getText().equals("")){ 
          showTextArea.setText(""); 
         } 
      } 
    } 
      
    public void sortMess(boolean sign) { 
      // TODO Auto-generated method stub 
      if(sign){ 
        for(int i=0;i<countNum;i++){ 
          for(int j=i+1;j<countNum;j++){ 
            if(Integer.parseInt(grade[i])<Integer.parseInt(grade[j])){ 
              String s1,s2; 
              s1=name[i]; 
              s2=grade[i]; 
                
              name[i]=name[j]; 
              grade[i]=grade[j]; 
                
              name[j]=s1; 
              grade[j]=s2; 
            } 
          } 
        } 
      }else{  
        
        if(!showGradeArea.getText().equals("")){ 
          showGradeArea.setText(""); 
        } 
      } 
      for(int i=0;i<countNum;i++){ 
        String content="����:"+name[i]+"\t"+"�ɼ�"+grade[i]; 
        if(sign)showTextArea.append(content+"\n"); 
        else showGradeArea.append(content+"\n"); 
      } 
    } 
      
    public void searchMess(String n) { 
      // TODO Auto-generated method stub 
        
      for(int i=0;i<countNum;i++){ 
        if(name[i].equals(n)){ 
          String content="����:"+name[i]+","+"�ɼ�"+grade[i]; 
          resultText.setText(content); 
          return; 
        } 
      } 
      resultText.setText("δ�ҵ���ѧ��!"); 
    } 
  } 
}