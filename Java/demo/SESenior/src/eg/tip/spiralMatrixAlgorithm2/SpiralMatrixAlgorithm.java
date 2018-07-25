/**
 * 螺旋矩阵算法
 */

package eg.tip.spiralMatrixAlgorithm2;

public class SpiralMatrixAlgorithm {
	public static void main(String[] args) {  
        int m = 5;/*行*/  
        int n = 6;/*列*/  
        int[][] pos = new int[m][n];/*位置*/  
        /** 
         * 位置结构如下： 
         * [0][0],[0][1],[0][2],[0][3],[0][4] 
         *  
         * [1][0],[1][1],[1][2],[1][3],[1][4] 
         *  
         * [2][0],[2][1],[2][2],[2][3],[2][4] 
         *  
         * [3][0],[3][1],[3][2],[3][3],[3][4] 
         *  
         * [4][0],[4][1],[4][2],[4][3],[4][4] 
         */  
        int count = 0;  
        int r = 0, c = 0;/*r:行下标    c:列下标    pos[r][c]对应以上位置*/  
        /*赋值方向，先向右c++，再向下r++，再向左c--，再向上r--*/  
        final int up = 1;  
        final int  down = -1;  
        final int left = 2;  
        final int right = -2;  
        int dir = right;/*开始方向*/  
        int cir = 1;/* 第几圈赋值 */  
        while(true){  
            count++;  
            pos[r][c]=count;/*赋值*/  
            switch(dir){  
                case right:  
                    if(c<n-cir){/*当前行右方还有没赋值的*/  
                        c++;  
                    }else{  
                        dir = down;  
                        r++;  
                    }  
                    break;  
                case down:  
                    if(r<m-cir){/*当前列下方还有没赋值的*/  
                        r++;  
                    }else{  
                        dir = left;  
                        c--;  
                    }  
                    break;  
                case left:  
                    if(c>cir-1){/*当前行左边还有没赋值的*/  
                        c--;  
                    }else{  
                        dir = up;  
                        r--;  
                    }  
                    break;  
                case up:  
                    if(r>cir){/*当前列上边边还有没赋值的*/  
                        r--;  
                    }else{  
                        cir++;/*赋值了一圈*/  
                        dir = right;  
                        c++;  
                    }  
                    break;  
            }  
            if(count>=m*n){  
                break;  
            }  
        }  
        /*输出*/  
        for(int i = 0; i<m; i++){  
            for(int j = 0; j<n; j++){  
                if(pos[i][j]<10){  
                    System.out.print(pos[i][j]+" "+" ");  
                }else{  
                    System.out.print(pos[i][j]+" ");  
                }  
            }  
            System.out.println();  
        }  
    }  
}
