public class FenwickTree {
    private int[] fen;

    public FenwickTree(int N) {
        fen = new int[N];
    }

    public void update(int i, int val, int N) {
        while(i < N) {
            fen[i] += val;
            i = i + (i & (-i));
        }
    }
    public int sum(int i) {
        int s = 0;
        while(i > 0) {
            s += fen[i];
            i = i - (i & (-i));
        }
        return s;
    }
    public int rangeSum(int l, int r) {
        return sum(r) - sum(l-1);
    }
}
