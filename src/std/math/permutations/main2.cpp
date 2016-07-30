#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <vector>
#include <set>
#include <cctype>
#include <cmath>
#include <cstdio>

using namespace std;

typedef vector<int>    VI;
typedef vector<string> VS;
typedef vector<vector<int> > VII;
typedef ostringstream OSS;
typedef istringstream ISS;

int main() {
    string s = "cba";

    /* In Ascending Order */

    cout << "Ascending ..." << endl;

    sort( s.begin(), s.end());

    do {
        cout << s << endl;
    } while ( next_permutation( s.begin(), s.end() ));

    /* In Descending Order */

    cout << "Descending ..." << endl;

    sort( s.begin(), s.end());
    reverse(s.begin(), s.end());

    do {
        cout << s << endl;
    } while ( prev_permutation( s.begin(), s.end() ));
}

