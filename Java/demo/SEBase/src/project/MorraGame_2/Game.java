package project.MorraGame_2;

public class Game {
	User u=new User();  
    Computer c=new Computer();  
    public int times;  
      
    //游戏初始化  
    public void init(){  
        u.name="匿名";  
        u.score=0;  
        c.name="匿名";  
        u.score=0;  
        times=0;  
    }  
    public void computerPlayer(int input){  
        switch(input){  
        case 1:c.name="刘备";break;  
        case 2:c.name="孙权";break;  
        case 3:c.name="曹操";break;  
        }  
    }  
    public void user(String name){  
        u.name=name;  
    }  
    public void chuquan(int a){  
        if(a==1||a==2||a==3){  
            times+=1;  
            u.chuquan(a);  
            int b=(int)(Math.random()*3)+1;//产生一个1~3的随机数  
            c.chuquan(b);  
            if(a==1&&b==3||a==2&&b==1||a==3&&b==2){//若用户赢，分数＋1  
                u.score+=1;  
            }else if(a==3&&b==1||a==1&&b==2||a==2&&b==1){//若电脑赢，分数＋1  
                c.score+=1;  
            }  
            }else{  
                System.out.println("输入有误，请输入一个0~3的整数！");  
            }  
          
    }  
      
    public void jisuan(){  
        System.out.println("一共玩了："+times+" 次！ "+u.name+" 赢了："+u.score+"次！ "+c.name+" 赢了："+c.score+"次！");  
    }  
    public void result(){  
        System.out.println("最后结果为：\n一共玩了："+times+" 次！ "+u.name+" 赢了："+u.score+"次！ "+c.name+" 赢了："+c.score+"次！");  
    } 
}
