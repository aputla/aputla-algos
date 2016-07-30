#include <iostream>

using std::cout;
using std::endl;

int count = 0;

void merge(int A[], int p, int q, int r) {

    int n = r - p;
    int B[n];

    int x = p;
    int y = q;
    int z = 0;

    while (true) {
        if (x >= q || y >= r) {
            break;
        }

        if (A[x] <= A[y]) {
            B[z++] = A[x++];
        }
        else {
            B[z++] = A[y++];
            count++;
        }
    }

    while (x < q) {
        B[z++] = A[x++];
    }

    while (y < r) {
        B[z++] = A[y++];
    }

    for (int i = 0; i < n; i++) {
        A[i + p] = B[i];
    }
}

void mergeSort(int A[], int p, int r) {
    if (p + 1 >= r) {
        return;
    }
    int q = (p + r) / 2;

    mergeSort(A, p, q);
    mergeSort(A, q, r);

    merge(A, p, q, r);
}

void display(int A[], int size) {
    for (int i = 0; i < size; i++) {
        cout << A[i] << " ";
    }
    cout << endl;
}

int main() {
    int A[] = {1, 3, 2};

    mergeSort(A, 0, 3);
    cout << "Total no of inversions = " << count << endl;

    return 0;
}
