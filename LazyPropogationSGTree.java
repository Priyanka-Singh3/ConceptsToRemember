public class LazyPropogationSGTree {
    private int seg[];
    private int lazy[];

    public LazyPropogationSGTree(int n) {
        seg = new int[4 * n + 1];
        lazy = new int[4 * n + 1];
    }

    public void rangeUpdate(int ind, int low, int high, int l, int r, int val) {
        if(lazy[ind] != 0) {
            seg[ind] += (lazy[ind]) * (high - low + 1);
            if(low != high) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }

        if(r < low || high < l) return;
        if(l <= low && high <= r) {
            seg[ind] += (high - low + 1) * val;
            if(low != high) {
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }

        int mid = (low + high) >> 1;
        rangeUpdate(2 * ind + 1, low, mid, l, r, val);
        rangeUpdate(2 * ind + 2, mid + 1, high, l, r, val);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public int querySumLazy(int ind, int low, int high, int l, int r) {
        if(lazy[ind] != 0) {
            seg[ind] += (high - low + 1) * lazy[ind];
            if(low != high) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }
        if(r < low || high < l) return 0;
        if(l <= low && high <= r) {
            return seg[ind];
        }
        int mid = (low + high) >> 1;
        return querySumLazy(2 * ind + 1, low, mid, l, r) + querySumLazy(2 * ind + 2, mid + 1, high, l, r);
    }



}
