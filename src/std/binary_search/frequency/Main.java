package std.binary_search.frequency;

public class Main {
    private static int solve(int[] a, int k) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == k) {
                int i = doleft(a, k, 0, mid);
                int j = doright(a, k, mid, a.length - 1);
                return j - i + 1;
            } else if (a[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private static int doleft(int[] a, int k, int low, int high) {
        while (true) {
            if (a[low] == k && a[high] == k) {
                return low;
            } else if (low + 1 == high) {
                return high;
            }

            int mid = (low + high) / 2;
            if (a[mid] != k) {
                low = mid;
            } else if (a[mid] == k) {
                high = mid;
            }
        }
    }

    private static int doright(int[] a, int k, int low, int high) {
        while (true) {
            if (a[low] == k && a[high] == k) {
                return high;
            } else if (low + 1 == high) {
                return low;
            }

            int mid = (low + high) / 2;
            if (a[mid] != k) {
                high = mid;
            } else if (a[mid] == k) {
                low = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(solve(a, 1));
    }
}
