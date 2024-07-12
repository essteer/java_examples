
public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
    }

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i : array) {
            if (i < smallest) {
                smallest = i;
            }
        }
        return smallest;

    }

    public static int indexOfSmallest(int[] array) {
        int smallest = smallest(array);
        int index = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] == smallest) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {

        int[] newArray = new int[table.length - startIndex];
        int j = 0;

        for (int i=startIndex; i<table.length; i++) {
            newArray[j] = table[i];
            j++;
        }
        return indexOfSmallest(newArray) + startIndex;
    }

    public static void swap(int[] array, int index1, int index2) {

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {

        System.out.println(array);

        int length = array.length;
        int i = 0;

        while (i < length) {
            int j = indexOfSmallestFrom(array, i);
            swap(array, i, j);
            System.out.println(array);
            i++;
        }
    }
}
