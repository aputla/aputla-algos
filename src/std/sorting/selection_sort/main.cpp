#include <iostream>
#include <algorithm>

using std::cout;
using std::endl;
using std::swap;

void SelectionSort( int a[], int n ) {
    for (int i = 1; i < n; i++) {
        int j = i;
        for (int k = j + 1; k <= n; k++) {
            if (a[k] < a[j]) {
                j = k;
            }
        }
        if (j != i) {
            swap(a[i], a[j]);
        }
    }
}

int main() {
    int a[] = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1, -1};

    SelectionSort(a, 9);

    for (int i = 1; i <= 9; i++) {
        cout << a[i] << " ";
    }
    cout << endl;

    return 0;
}
