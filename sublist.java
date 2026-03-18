import java.util.*;
public class sublist{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        int arr[]= {1,2,3};
        solve(list, arr, new ArrayList<>(), 0);
        System.out.println(list);
    }
    public static void solve(ArrayList<ArrayList<Integer>>list, int arr[], ArrayList<Integer>sublist, int idx){

        if (idx==arr.length){
            list.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(arr[idx]);
        solve(list, arr, sublist, idx+1);
        sublist.remove(sublist.size()-1);
        solve(list,arr,sublist, idx+1);

    }
}




