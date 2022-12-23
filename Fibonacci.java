public class Fibonacci {
    public static int getFibNumb(int n) {
        if (n==1) return 1;
        n=n+1;
        int[] fibo=new int[n];
        fibo[0]=0;
        fibo[1]=1;
        for(int i=2;i<=n-1;i++)
        {
            fibo[i]=(fibo[i-1]+fibo[i-2])%10;
        }
        return fibo[n-1];
    }
}