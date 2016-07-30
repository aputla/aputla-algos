package std.sorting.kth_smallest;

public class Main {
    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];
        
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }
    
    private static int solve(int[] array, int left, int right, int k) {
        int index = partition(array, left, right);
        if (index == k) {
            return array[index];
        }
        
        if (k < index) {
            return solve(array, left, index - 1, k);
        } else {
            return solve(array, index + 1, right, k);
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 0};
        System.out.println(solve(array, 0, array.length - 1, 3));
    }
}
