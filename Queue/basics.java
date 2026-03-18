import java.util.*;

public class basics {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek()); // Output: 1
        System.out.println(q.poll()); // Output: 1
        System.out.println(q.peek()); // Output: 2
    }


    
}
