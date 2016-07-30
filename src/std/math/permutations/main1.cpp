#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

void Perm(string &a, int k, int n) {
    if (k == n) {
        cout << a << endl;
        return;
    }

    for (int i = k; i < n; i++) {
        swap(a[k], a[i]);
        Perm(a, k + 1, n);
        swap(a[k], a[i]);
    }
}

int main() {
    string str = "abc";
    Perm(str, 0, 3);
    return 0;
}

