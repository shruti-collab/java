public class sumofno {
    public static void main(String[] args){
        System.out.println(solve(5,0));

    }
    public static int solve(int n, int sum){
        if(n==0){
            return sum;
        }
         return solve(n-1, sum+n);
    }
    // public static int solve(int n){
    //     if(n==0){
    //         return 0;
    //     }
    //     int sum= n+ solve(n-1);
    //     return sum;

    // }
    
}
