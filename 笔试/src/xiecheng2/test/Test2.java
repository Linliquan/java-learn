package xiecheng2.test;

import java.util.Scanner;

public class Test2 {
    public static void main(String args[]){
        Scanner reader=new Scanner(System.in);
        while(reader.hasNextInt()){
            int m=reader.nextInt();
            int n=reader.nextInt();
            if(100<=m&&m<=n&&n<=999){
                int j=0;
                for(int i=m;i<=n;i++)
                {
                    int geWei,shiWei,baiWei;
                    baiWei=i/100;
                    shiWei=(i-baiWei*100)/10;
                    geWei=i-baiWei*100-shiWei*10;
                    if(i==geWei*geWei*geWei+shiWei*shiWei*shiWei+baiWei*baiWei*baiWei)
                    {j=j+1;
                        if(j>1){
                            System.out.print(" "+i);
                        }
                        else{
                            System.out.print(i);
                        }

                    }
                }
                if(j==0){
                    System.out.print("no");
                }
                System.out.println();
            }
        }
    }
}
