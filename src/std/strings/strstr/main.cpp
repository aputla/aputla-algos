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

VS tokenize( string s, string delim = " " ) {
    VS result;
    int b = 0;
    int p = s.find(delim, b);

    while ( p != -1 ) {
        result.push_back(s.substr(b, p - b));
        b = p + delim.size();
        p = s.find( delim, b);
    }
    result.push_back(s.substr(b, s.size()));
    return result;
}

int main() {
    char ch = ' ';
    string s;
    s += ch;
    VS result = tokenize("quick and lazy fox jumped over the wall", s);

    for ( int i = 0; i < result.size(); i++ ) {
        cout << result[i] << endl;
    }

    return 0;
}
