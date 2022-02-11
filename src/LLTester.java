import java.util.Arrays;

public class LLTester {
    public static void main(String[] args) {
        var ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
//        System.out.println(ll.indexOf(10));
//        System.out.println(ll.indexOf(30));
//        System.out.println(ll.indexOf(100));
//        System.out.println(ll.size());
//        System.out.println(ll.contains(10));
//        System.out.println(ll.contains(40));
//        ll.removeFirst();
//        ll.removeLast();
//        System.out.println(ll.size());
        ll.reverse();
        var array = ll.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(ll.getKthFromTheEnd(2));
    }
}
