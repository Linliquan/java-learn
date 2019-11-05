package wangwei.t2;


import java.util.*;
import java.math.*;
public class Test{
    static int maxn=(int)(100+10);
    static int n,m;
    static BigInteger MOD =new BigInteger("100000");
    static String INF="";
    static BigInteger[][] map=new BigInteger[maxn][maxn];
    static BigInteger base=new BigInteger("2");

    static void init() {
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                if(i!=j)
                    map[i][j]=new BigInteger(INF);
                else
                    map[i][j]=new BigInteger("0");
            }
        }
    }

    static BigInteger[] dis=new BigInteger[maxn];
    static boolean[] vis =new boolean[maxn];
    static void dijkstra(int start) {
        for(int i=0;i<n;i++) {
            dis[i]=map[start][i];
            vis[i]=false;
        }
        dis[start]=new BigInteger("0");
        vis[start]=true;
        for(int i=0;i<n-1;i++) {
            int k=-1;
            BigInteger minD=new BigInteger(INF);
            for(int j=0;j<n;j++) {
                if(!vis[j]&&dis[j].compareTo(minD)<0) {
                    minD=dis[j];
                    k=j;
                }
            }
            if(k==-1)	break;
            vis[k]=true;
            for(int j=0;j<n;j++) {
                if(!vis[j]&&dis[j].compareTo(dis[k].add(map[k][j]))>0)
                    dis[j]=dis[k].add(map[k][j]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        for(int i=0;i<=160;i++)
            INF+="9";

        while(cin.hasNext()) {
            n=cin.nextInt();
            m=cin.nextInt();
            init();
            for(int k=0;k<m;k++) {
                int u=cin.nextInt();
                int v=cin.nextInt();
                if(!map[u][v].toString().equals(INF))	continue;
                map[u][v]=map[v][u]=new BigInteger( base.pow(k).toString());
            }

            dijkstra(0);
            for(int i=1;i<n;i++) {
                BigInteger d=dis[i];
                if(d.toString().equals(INF))
                    System.out.println("-1");
                else
                    System.out.println(d.mod(MOD));
            }
        }
        cin.close();
    }
}

//import java.util.Scanner;
//
//public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int [] a = new int[36];
//        for(int i = 0; i < 36; i++){
//           a[i] = sc.nextInt();
//        }
//
//    }
//}
