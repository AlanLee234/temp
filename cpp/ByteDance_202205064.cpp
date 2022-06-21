#include <bits/stdc++.h>

using namespace std;

#define maxn 1000005

int n;
int arr[maxn];
int len[maxn];
int no;
unordered_map<int, int> mmap;

int lowbit(int x) {
    return x&-x;
}

void add(int x, int v) {
    while (x <= no) {
        len[x] = max(len[x], v);
        x += lowbit(x);
    }
}

int query(int x) { 
    int ans = 0;
    while (x) {
        ans = max(ans, len[x]);
        x -= lowbit(x);
    }
    return ans;
}

int solve() {
    if (n <= 0) return 0;
    int i = 0, j = 1;
    int ans = 1;
    vector<int> qq;
    qq.push_back(query(1));
    while (j < n) {
        if (arr[j] <= arr[j-1]) { // 递减
            for (int k = i; k < j; ++k) {
                ans = max(ans, qq[k-i] + j - k);
            }
            qq.clear();
            int st = i;
            while (i < j) {
                add(arr[i], i - st + 1);
                ++i;
            }
            qq.push_back(query(arr[j]-1));
        } else { // 递增
            int t = query(arr[j]-1);
            qq.push_back(t);
            ans = max(ans, j - i + 1);
        }
        ++j;
    }
    for (int k = i; k < j; ++k) {
        ans = max(ans, qq[k-i] + j - k);
    }
    return ans;
}

int main() {
    // cin >> n;
    int n = 9;
    vector<int> data;
    // for (int i = 0; i < n; ++i) {
    //     cin >> arr[i];
    //     data.push_back(arr[i]);
    // }
    data = {5, 3, 4, 9, 2, 8, 6, 7, 1};
    sort(data.begin(), data.end());
    for (auto e : data) {
        if (!mmap.count(e)) 
            mmap[e] = ++no;
    }
    for (int i = 0; i < n; ++i) {
        arr[i] = mmap[arr[i]];
    }
    cout << solve() << endl;
}