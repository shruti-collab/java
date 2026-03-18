public class fibonacci{
   //
   
    public static void main(String[] args){
        int n;
        n=6;
         if(n==0){
            System.out.println(0);
            return;
        }
        int prev2=0;
        int prev1=1;
        for(int i=2; i<=n;i++){
            int curri= prev1+prev2;
            prev2 = prev1;
            prev1 = curri;
        }
        System.out.println(prev1);
        
        //int[] dp= new int [n+1];
        // for(int i=0; i<=n;i++){
        //     dp[i]=-1;
    
        // }
        //System.out.println("fibonacci of "+n+"is:"+ fib(n, dp));
    }
}