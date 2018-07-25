/**
 * 螺旋矩阵算法
 */

package eg.tip.spiralMatrixAlgorithm3;

public class SpiralMatrixAlgorithm {
	public static void main(String[] args){
        int v=8;
        int max=v*v-1;
        int[][]  a=new int[v][v];
        int temp=2;//+ -
        int temp2=2;//h s
        int temp3=v;
        int x=0;
        int y=0;
        for(;max>0;max--){
            if((temp%2==0)&&(temp2%2==0)){//x的值不变y在加
                if(x>0){
                    y++;
                }
                a[x][y]=max;
                
                if(y==temp3-1||a[x][y+1]>0){
                    temp2++;
                    continue;
                }
                if(x==0){
                    y++;
                }
            }else if((temp%2==0)&&(temp2%2==1)){//y的值不变x在加
                x++;
                a[x][y]=max;
                if(x==temp3-1||a[x+1][y]>0){
                    temp2++;
                    temp++;
                    continue;
                }
            }else if((temp%2==1)&&(temp2%2==0)){// x的值不变 y在减
                y--;
                a[x][y]=max;
                
                if(y==0||a[x][y-1]>0){
                    temp2++;
                    continue;
                }
            }else if((temp%2==1)&&(temp2%2==1)){// y的值不变x在减
                x--;
                a[x][y]=max;
                
                if(x==0||a[x-1][y]>0){
                    temp2++;
                    temp++;
                    continue;
                }
            }
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(a[i][j]>10){
                    System.out.print(a[i][j]);
                    System.out.print(" ");
                }else{
                    System.out.print(" ");
                    System.out.print(a[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
