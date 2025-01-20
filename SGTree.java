public class SGTree {
    private int seg[];

    public SGTree(int n) {
        seg = new int[4 * n + 1];
    }

    public void build(int ind, int low, int high, int a[]) {

        if(low == high) {
            seg[ind] = a[low];
            return;
        }

        int mid = (low + high)/2;

        build(2*ind+1, low, mid, a);
        build(2*ind+2, mid+1, high, a);
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {

        //complete overlap -> [l  low   high   r]
        if(l <= low && high <= r) {
            return seg[ind];
        }

        //no overlap -> [low  high] [l  r] || [l  r] [low  high]
        if(high < l || r < low) {
            return Integer.MAX_VALUE;
        }
        
        //partial overlap
        int mid = (low + high)/2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);

        return Math.min(left, right);

    }

    public void update(int ind, int low, int high, int i, int val) {

        if(low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high)/2;
        if(i <= mid) {
            update(2 * ind + 1, low, mid, i, val);
        }
        else {
            update(2 * ind + 2, mid + 1, high, i, val);
        }

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

}
