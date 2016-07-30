#include <cstdio>
#include <vector>
#include <set>
#include <iostream>
#include <cmath>

using namespace std;

vector<bool> prime;

vector<bool> sieve(int n ) {
    prime.resize(n + 1, true);
    int m = (int) sqrt(n);

    for ( int i = 2; i <= m; i++ ) {
        if ( prime[i] ) {
            for ( int j = i * i; j <= n; j += i ) {
                prime[j] = false;
            }
        }
    }
    return prime;
}

int main() {
    vector<bool> v = sieve(101);

    int count = 1;
    for ( int i = 2; i < v.size(); i++ ) {
        if ( v[i] ) {
            cout << i << " ";
            count++;

            if ( count > 10 ) {
                cout << endl;
                count = 0;
            }
        }
    }
    cout << endl;

    return 0;
}
