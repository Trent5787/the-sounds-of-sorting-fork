package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true if <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }
    
    public static Integer[] makeSmallTestArray() {
        return new Integer[] {
            4, 3, 9, 1, 2
        };
    }
    
    public static Integer[] makeSortedArray() {
        return new Integer[] {
            3, 7, 9
        };
    }
    
    public static Integer[] makeOneElementArray() {
        return new Integer[] {
            3
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    public void testSmallSort(Consumer<Integer[]> func) {
        Integer[] arr = makeSmallTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    public void testSortedSort(Consumer<Integer[]> func) {
        Integer[] arr = makeSortedArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    public void testSingularSort(Consumer<Integer[]> func) {
        Integer[] arr = makeOneElementArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
        testSortedSort(Sorts::bubbleSort);
        testSingularSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
        testSortedSort(Sorts::insertionSort);
        testSingularSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
        testSortedSort(Sorts::selectionSort);
        testSingularSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
        testSortedSort(Sorts::mergeSort);
        testSingularSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
        testSortedSort(Sorts::quickSort);
        testSingularSort(Sorts::quickSort);
    }
    
    @Test
    public void randomSort() {
        testSmallSort(Sorts::randomSort); //any big array will likely timeout in the testing
        testSortedSort(Sorts::randomSort);
        testSingularSort(Sorts::randomSort);
    }
}