import java.util.Arrays;

public class Array implements Comparable {

    private int length;
    public int[] array;
    private int atIndex = 0;

    public Array(int length) {
        this.length = length;
        array = new int[length];
    }

    public void print() {
        for (int i = 0; i < atIndex; i++)
            System.out.println(array[i]);
    }

    public void addLast(int item) {
        if (atIndex == length) {
            length++;
            int[] tempArray = new int[length];
            for (int i = 0; i < array.length; i++)
                tempArray[i] = array[i];
            array = tempArray;
        }
        array[atIndex++] = item;
    }

    public void addLast(int... items) {
        for (int item: items)
            addLast(item);
    }

    public void addFirst(int item) {
        if (atIndex == length)
            length++;
        int[] tempArray = new int[length];
        for (int i = 0; i < atIndex; i++)
            tempArray[i + 1] = array[i];
        array = tempArray;
        array[0] = item;
        atIndex++;
    }

    public void addFirst(int... items) {
        for (int i = items.length - 1; i >= 0; i--)
            addFirst(items[i]);
    }

    public void removeAt(int index) {
        if (index >= 0 && index < atIndex--) {
            int[] tempArray = new int[--length];
            int tempI = 0;
            for (int i = 0; i <= length; i++) {
                if (i != index)
                    tempArray[tempI++] = array[i];
            }
            array = tempArray;
        } else
            throw new IllegalArgumentException("Index out of bounds.");
    }

    public int indexOf(int item) {
        for (int i = 0; i < atIndex; i++)
            if (array[i] == item)
                return i;
        return -1;
    }

    public int lastIndexOf(int item) {
        for (int i = atIndex - 1; i >= 0; i--)
            if (array[i] == item)
                return i;
        return -1;
    }

    public int binarySearch(int item) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (true) {
            int middle = (first + last) / 2;
            if (array[middle] == item)
                return middle;
            else if (array[last] == item)
                return last;
            else if (array[middle] > item)
                last = middle;
            else if (array[middle] < item)
                first = middle;
            if (first == last - 1 && array[first] != item && array[last] != item)
                return -1;
        }
    }

    public int recursiveBinarySearch(int item, int lower_boundary, int upper_boundary) {
        int middle = (lower_boundary + upper_boundary) / 2;
        if (lower_boundary == upper_boundary - 1 && array[lower_boundary] != item && array[upper_boundary] != item)
            return -1;
        if (array[middle] == item)
            return middle;
        else if (array[middle] > item)
            return recursiveBinarySearch(item, lower_boundary, middle - 1);
        else if (array[middle] < item)
            return recursiveBinarySearch(item, middle + 1, upper_boundary);
        return -1;
    }

    public int getLength() {
        return atIndex;
    }

    public void reverse() {
        int[] tempArray = new int[length];
        for (int i = 0; i < length; i++)
            tempArray[length - i - 1] = array[i];
        array = tempArray;
    }

    public void bubbleSort() {
        boolean loopSomeMore;
        do {
            loopSomeMore = false;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]) {
                    //swap a[i] and a[i+1]
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    loopSomeMore = true;
                }
            }
        } while(loopSomeMore);
    }

    public void selectionSort() {
        int min, minIndex;
        for(int i = 0;i < array.length; ++i) {
            min = array[i];
            minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {    // Find minimum
                if (array[j] < min) {   //salient feature
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i]; // swap
            array[i] = min;
        }
    }

    public void insertionSort() { //This will do an ascending sort
        int itemToInsert, j;
        boolean keepGoing;
        //On kth pass, insert item k into its correct position among the first k items in the array
        for (int k = 1; k < array.length; k++) {
            //Go backwards through the list, looking for the slot to insert a[k]
            itemToInsert = array[k];
            j = k - 1;
            keepGoing = true;
            while ((j >= 0) && keepGoing) {
                if (itemToInsert < array[j]) {
                    array[j + 1] = array[j]; //Salient feature
                    j--;
                    if (j == -1) //special case for inserting an item at [0]
                        array[0] = itemToInsert;
                } else {    //Upon leaving loop, j + 1 is the index where itemToInsert belongs
                    keepGoing = false;
                    array[j + 1] = itemToInsert;
                }
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        Array otherArray = (Array) o;
        if (otherArray.getLength() == getLength()) {
            for (int i = 0; i < getLength(); i++) {
                if (array[i] != otherArray.array[i])
                    return -1;
            }
            return 0;
        }
        return -1;
    }
}
