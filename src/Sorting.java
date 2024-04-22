/**********************************************************************
        * @file Lab7.java
        * @brief This is a program about linkedlist
        * @author Alantis Green
        * @date: 3/24/2023
        * @acknowledgement:
        */
import java.util.ArrayList;
import java.util.Random;

public class Sorting{
    public static void main(String[] args) {
        // Create already sorted arraylists of sizes 1, 10000 and 1000000
        ArrayList<Integer> sortedList1 = new ArrayList<Integer>();
        sortedList1.add(1);
        ArrayList<Integer> sortedList2 = new ArrayList<Integer>();
        for (int i = 1; i <= 10000; i++) {
            sortedList2.add(i);
        }
        ArrayList<Integer> sortedList3 = new ArrayList<Integer>();
        for (int i = 1; i <= 1000000; i++) {
            sortedList3.add(i);
        }

        // Create unsorted arraylists of sizes 10000 and 1000000
        ArrayList<Integer> unsortedList1 = new ArrayList<Integer>();
        ArrayList<Integer> unsortedList2 = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 1; i <= 10000; i++) {
            unsortedList1.add(rand.nextInt(10000));
        }
        for (int i = 1; i <= 1000000; i++) {
            unsortedList2.add(rand.nextInt(1000000));
        }
        System.out.println("Contents of Lists:");

        System.out.println("merge sort:" + sortedList1);
        long startTime = System.nanoTime();
        sortedList1 = mergeSort(sortedList1);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 1 Time:" + 1.0 * endTime / 10000);

        System.out.println("merge sort:" + sortedList2);
        startTime = System.nanoTime();
        sortedList2 = mergeSort(sortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 2 Time:" + 1.0 * endTime / 10000);

        System.out.println("merge sort:" + sortedList3);
        startTime = System.nanoTime();
        sortedList3 = mergeSort(sortedList3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 3 Time:" + 1.0 * endTime / 10000);

        System.out.println("merge sort:" + unsortedList1);
        startTime = System.nanoTime();
        unsortedList1 = mergeSort(unsortedList1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 4 Time:" + 1.0 * endTime / 10000);

        System.out.println("merge sort:" + unsortedList2);
        startTime = System.nanoTime();
        unsortedList2 = mergeSort(unsortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 5 Time:" + 1.0 * endTime / 10000);

        // bubble
        System.out.println("Contents of  bubble Lists:");

        System.out.println("bubble sort:" + sortedList1);
        startTime = System.nanoTime();
        sortedList1 = bubbleSort(sortedList1);
         endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 1 Time:" + 1.0 * endTime / 10000);

        System.out.println("bubble sort:" + sortedList2);
        startTime = System.nanoTime();
        sortedList2 = bubbleSort(sortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 2 Time:" + 1.0 * endTime / 10000);

        System.out.println("bubble sort:" + sortedList3);
        startTime = System.nanoTime();
        sortedList3 = bubbleSort(sortedList3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 3 Time:" + 1.0 * endTime / 10000);

        System.out.println("bubble sort:" + unsortedList1);
        startTime = System.nanoTime();
        unsortedList1 = bubbleSort(unsortedList1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 4 Time:" + 1.0 * endTime / 10000);

        System.out.println("bubble sort:" + unsortedList2);
        startTime = System.nanoTime();
        unsortedList2 = bubbleSort(unsortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 5 Time:" + 1.0 * endTime / 10000);


        /// insertion short
        System.out.println("Contents of Lists:");

        System.out.println("insertion sort:" + sortedList1);
        startTime = System.nanoTime();
        sortedList1 = insertionSort(sortedList1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 1 Time:" + 1.0 * endTime / 10000);

        System.out.println("insertion sort:" + sortedList2);
        startTime = System.nanoTime();
        sortedList2 = insertionSort(sortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 2 Time:" + 1.0 * endTime / 10000);

        System.out.println("insertion sort:" + sortedList3);
        startTime = System.nanoTime();
        sortedList3 = insertionSort(sortedList3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 3 Time:" + 1.0 * endTime / 10000);

        System.out.println("insertionsort:" + unsortedList1);
        startTime = System.nanoTime();
        unsortedList1 = insertionSort(unsortedList1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 4 Time:" + 1.0 * endTime / 10000);

        System.out.println("insertion sort:" + unsortedList2);
        startTime = System.nanoTime();
        unsortedList2 = insertionSort(unsortedList2);
        endTime = System.nanoTime() - startTime;
        System.out.println("Sorted List 5 Time:" + 1.0 * endTime / 10000);


    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

        private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
            ArrayList<Integer> result = new ArrayList<>();

            int i = 0;
            int j = 0;

            while (i < left.size() && j < right.size()) {
                if (left.get(i) <= right.get(j)) {
                    result.add(left.get(i));
                    i++;
                } else {
                    result.add(right.get(j));
                    j++;
                }
            }

            while (i < left.size()) {
                result.add(left.get(i));
                i++;
            }

            while (j < right.size()) {
                result.add(right.get(j));
                j++;
            }

            return result;
        }
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<Integer>(list);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>(list);
        for (int i = 1; i < result.size(); i++) {
            int key = result.get(i);
            int j = i - 1;
            while (j >= 0 && result.get(j) > key) {
                result.set(j + 1, result.get(j));
                j--;
            }
            result.set(j + 1, key);
        }
        return result;
    }

}







