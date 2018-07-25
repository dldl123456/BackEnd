package demo.ease.primeNumber;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System. in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();
        if( m == 1 )     m=2;
        int cnt = 0;
        int sum = 0;
        for( int i=m ; i<=n ; i++ )
        {
             boolean isPrime = true;
             for( int k=2 ; k< i ; k++ )
            {
                   if( i % k == 0 )
                  {
                         isPrime = false;
                         break;
                  }
            }
             if( isPrime )
            {
                   cnt++;
                   sum++;
            }
        }
        System. out.println( "在" + m + "和" + n + "之间有" + cnt + "个素数，总和为" + sum );
      }
}
