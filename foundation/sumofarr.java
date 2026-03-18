import java.util.*;
// import java.Math;

class sumofarr{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n;i++){
            arr[i]= sc.nextInt();

        }

        // int sum=0;
        // for(int i=0;i<n;i++){
        //     sum += arr[i];
        // }
        // 6System.out.println(sum);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        System.out.println(max);
    }
}