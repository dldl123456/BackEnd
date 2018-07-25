package project.MorraGame_1;
import java.util.Scanner;
 public class C {
	 /**
	  * 网络上的人机猜拳
	  * @param args
	  */
    @SuppressWarnings("resource")
	public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
         System.out.println("--------欢迎进入猜拳游戏---------\n\n");
         System.out.println("  出拳规则：1.剪刀  2.石头  3.布\n");
         System.out.println("******************************\n");
         System.out.println("*******  猜拳          开始      ********\n");
         System.out.println("******************************\n\n");
         System.out.println("游戏开始前给自己起一个威武霸气的昵称吧\n");
         System.out.println("请输入你的昵称：");
         String username=input.next();//让用户输入昵称
        String name="1";//给name一个初始值,name是computer的名字
         do{
             System.out.println("请选择对战角色（1.刘备  2.曹操  3.盖伦）：");
             boolean zhenjia=input.hasNextInt();//判断输入是否是数值
             while(!zhenjia){//如果不是数字，进入
                 String zhen=input.next();
                System.out.println("您输入的是："+zhen+"  臣妾做不到啊！");
                System.out.println("请重新选择角色（1.刘备  2.曹操  3.盖伦）：");
                 zhenjia=input.hasNextInt();//判断输入是否是数值，如果不是 ，继续循环
             }
             int num=input.nextInt();//取出的数字
             while(num>3||num<0){//判断输入的值是否是1-3，如果不是进入循环
                 System.out.println("臣妾做不到啊！");
                 System.out.println("请重新选择角色（1.刘备  2.曹操  3.盖伦）：");
                 num=input.nextInt();//输入数值，如果是1-3跳出循环，如果不是继续循环
             }
             switch(num){
             case 1:
                 name="刘备";
                 break;
             case 2:
                 name="曹操";
                 break;
             case 3:
                 name="盖伦";
                 break;
             }
         }while(name.equals("1"));//当name不是1时 ，跳出循环
         System.out.println("你选择了  "+name+"对战");
         String go;
         do{
             System.out.println(username+"\tVS\t"+name);
             //出拳代码
             int i=1;//i是猜拳的轮数
             int userScore=0;//用户得分
             int compScore=0;//computer得分
             String come;//当come赋值y，继续循环，在下面写着
             do{
                 System.out.println("这是第"+i+"轮");
                 System.out.println("请出拳：1.剪刀 2.石头  3.布");
                 boolean zhenjia=input.hasNextInt();//判断输入是否是数值
                 while(!zhenjia){//如果不是数字，进入
                     String zhen=input.next();//把上面的值放入此处，一边下面重新输入
                     System.out.println("您输入的是："+zhen+"  臣妾做不到啊！");
                     System.out.println("请重新出拳：1.剪刀 2.石头  3.布");
                     zhenjia=input.hasNextInt();//判断输入是否是数值，如果不是 ，继续循环
                 }
                int num=input.nextInt();//取出上面的数值
                while(num>3||num<0){//判断输入的值是否是1-3，如果不是进入循环
                     System.out.println("臣妾做不到啊！");
                     System.out.println("请重新出拳：1.剪刀 2.石头  3.布");
                     num=input.nextInt();//输入数值，如果是1-3跳出循环，如果不是继续循环
                }
                 String user="";//储存用户的出拳
                switch(num){
                case 1:
                    System.out.println("你出拳：剪刀");
                    user="剪刀";
                     break;
                case 2:
                    System.out.println("你出拳：石头");
                    user="石头";
                   break;
                case 3:
                     System.out.println("你出拳：布");
                    user="布";
                    break;
                 }
                 String comp="";//储存computer的猜拳
                int numc=(((int)(Math.random()*10))%3+1);//随机产生1-3
                 switch(numc){
                 case 1:
                     System.out.println(name+"出拳：剪刀");
                     comp="剪刀";
                    break;
                case 2:
                    System.out.println(name+"出拳：石头");
                     comp="石头";
                    break;
                case 3:
                     System.out.println(name+"出拳：布");
                     comp="布";
                     break;
                 }
                 if(user.equals(comp)){//判断双方出拳是否相同
                     System.out.println("双方出拳："+user+"  本局是平局");
                }else{
                    if(user.equals("剪刀")){//当用户出剪刀时
                       if(comp.equals("石头")){//当computer出石头时
                             System.out.println(name+"赢了！");
                            compScore++;
                       }else{//当computer出布时
                            System.out.println("你赢了！");
                             userScore++;
                         }
                     }else if(user.equals("石头")){
                         if(comp.equals("布")){
                             System.out.println(name+"赢了！");
                             compScore++;
                         }else{
                            System.out.println("你赢了！");
                             userScore++;
                         }
                     }else{
                         if(comp.equals("剪刀")){
                             System.out.println(name+"赢了！");
                            compScore++;
                         }else{
                            System.out.println("你赢了！");
                             userScore++;
                         }
                     }
               }
                i++;//猜拳轮数增加1
                 System.out.println("继续第"+i+"轮  y\n结束  n");
               come=input.next();//当come赋值y，继续循环
            }while("y".equals(come));//判断come的值是否是y,如果是 ，继续循环，否则跳出循环
             System.out.println("游戏进行了"+(i-1)+"轮");
            System.out.println("姓名\t得分");
           System.out.println(username+"\t"+userScore);
             System.out.println(name+"\t"+compScore);
             if(userScore==compScore){//当得分一样的情况，这是修改后添加的代码
               System.out.println("你和"+name+"打了个平手");
                 System.out.println("这怎么能忍，打爆他才有快感");
                System.out.println(" 继续y/认怂了n");
            }else if(userScore>compScore){

                 System.out.println("你把"+name+"打的落花流水");
                 System.out.println("\t你tm帅呆了");
                 System.out.println("再打"+name+"一局就把他打成猪头了 \n  继续y/认怂了n");
             }else{
                System.out.println("你被"+name+"打成猪头了");
                 System.out.println("复仇y/认怂n");
             }
             go=input.next();
         }while("y".equals(go));
         System.out.println("GAME OVER!");
     }//mian
 }
