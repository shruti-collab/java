public class recursion {
    public static void main(String[] args){
        solve(6);
    }
    public static void solve(int n){
        if(n==0){
            return;
        }
        //System.out.println("hello world");
        System.out.println(n);
        solve(n-1);  // this is a recursive call statement 

        
    }

    
}
