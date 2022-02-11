import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*
        Tester for dynamic integer array class
        that includes various sorting routines
         */

        Array array = new Array(3);

        array.addLast(4);
        array.addFirst(5);
        array.addFirst(3);
        array.print(); // 3, 5, 4
        System.out.println("Length: " + array.getLength()); // 3
        array.removeAt(0); // --> 5, 4
        array.reverse(); // --> 4, 5
        array.print(); // 4, 5
        System.out.println(array.indexOf(5)); // 1
        System.out.println(array.indexOf(0)); // -1

        array.addFirst(1, 2, 3);
        array.print();

//        System.out.println(array.indexOf(0));
//        array.addFirst(5, 100);
//        System.out.println(array.indexOf(100));
//        array.addLast(30, 20);
//        array.addFirst(40);
//        array.print();
//        System.out.println("Length: " + array.getLength());
//        System.out.println("\nSorted:");
//        array.insertionSort();
//        array.print();


        /*
        ADD METHODS:
            .lastIndexOf()          - accepts an index
            .compareTo()            - accepts an object

            .binarySearch()         - accepts a value     <-- iterative
            .recursiveBinarySearch()- accepts a value, a start index, and an end index    <-- recursive
         */

        System.out.println("\n\n===Comparing Objects===");


        Array toCompare1 = new Array(3);
        toCompare1.addLast(1);
        toCompare1.addLast(2);
        toCompare1.addLast(3);

        Array toCompare2 = new Array(3);
        toCompare2.addLast(1);
        toCompare2.addLast(2);
        toCompare2.addLast(3);

        Array toCompare3 = new Array(3);
        toCompare3.addLast(1);
        toCompare3.addLast(2);
        toCompare3.addLast(4);

        System.out.println(toCompare1.compareTo(toCompare2)); // 0
        System.out.println(toCompare1.compareTo(toCompare3)); // -1
        System.out.println(toCompare2.compareTo(toCompare3)); // -1

        System.out.println("\n\n");

        // .lastIndexOf()
        Array testArray = new Array(5);
        testArray.addLast(1);
        testArray.addLast(3);
        testArray.addLast(1);
        testArray.addLast(2);
        testArray.addLast(3);

        System.out.println(testArray.indexOf(1));               // 0
        System.out.println(testArray.lastIndexOf(1));      // 2
        System.out.println(testArray.indexOf(3));               // 1
        System.out.println(testArray.lastIndexOf(3));      // 4

        System.out.println("\n\n===Binary Search===");

        // .binarySearch()
        // only works with sorted lists (automatically done within method - modifies original list)
        // works best with no duplicates

        Array binSearchTest = new Array(5);
        binSearchTest.addLast(5);
        binSearchTest.addLast(2);
        binSearchTest.addLast(1);
        binSearchTest.addLast(4);
        binSearchTest.addLast(3);

        System.out.println(binSearchTest.binarySearch(1));
        System.out.println(binSearchTest.binarySearch(2));
        System.out.println(binSearchTest.binarySearch(3));
        System.out.println(binSearchTest.binarySearch(4));
        System.out.println(binSearchTest.binarySearch(5));
        System.out.println(binSearchTest.binarySearch(6));

        System.out.println("\n\n===Recursive Binary Search===");
        // .recursiveBinarySearch()
        // only works with sorted lists (NOT done within method - Array object is already sorted)
        // works best with no duplicates

        System.out.println(binSearchTest.recursiveBinarySearch(1, 0, binSearchTest.getLength()-1));
        System.out.println(binSearchTest.recursiveBinarySearch(2, 0, binSearchTest.getLength()-1));
        System.out.println(binSearchTest.recursiveBinarySearch(3, 0, binSearchTest.getLength()-1));
        System.out.println(binSearchTest.recursiveBinarySearch(4, 0, binSearchTest.getLength()-1));
        System.out.println(binSearchTest.recursiveBinarySearch(5, 0, binSearchTest.getLength()-1));
        System.out.println(binSearchTest.recursiveBinarySearch(6, 0, binSearchTest.getLength()-1));


    }
}
