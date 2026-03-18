import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int[][] dp = new int[n][n];
            
       
            for (int gap = 1; gap < n; gap++) {
                for (int i = 0; i < n - gap; i++) {
                    int j = i + gap;
                    dp[i][j] = Integer.MAX_VALUE;
                    
                  
                    for (int k = i; k < j; k++) {
                        
                       
                        int c1 = 0;
                        for (int p = i; p <= k; p++) {
                            c1 += arr[p];
                        }
                        c1 = c1 % 100;
                        
                        
                        int c2 = 0;
                        for (int p = k + 1; p <= j; p++) {
                            c2 += arr[p];
                        }
                        c2 = c2 % 100;
                        
                        int smoke = dp[i][k] + dp[k + 1][j] + c1 * c2;
                        
                        dp[i][j] = Math.min(dp[i][j], smoke);
                    }
                }
            }
            
            System.out.println(dp[0][n - 1]);
        }
        
        sc.close();
    }
}