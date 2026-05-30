import java.util.*;
class Solution {
    class SegmentTree {
        int[] tree;
        SegmentTree(int n) {
            tree = new int[4 * n];
        }
        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(node * 2, start, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, end, idx, val);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }
        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;
            if (l <= start && end <= r)
                return tree[node];
            int mid = (start + end) / 2;
            return Math.max(
                query(node * 2, start, mid, l, r),
                query(node * 2 + 1, mid + 1, end, l, r)
            );
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        int MAX = 0;
        for (int[] q : queries) {
            MAX = Math.max(MAX, q[1]);
        }
        MAX += 1; // sentinel
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX);
        SegmentTree seg = new SegmentTree(MAX + 1);
        seg.update(1, 0, MAX, MAX, MAX);
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                int left = obstacles.lower(x);
                int right = obstacles.higher(x);
                seg.update(1, 0, MAX, right, right - x);
                seg.update(1, 0, MAX, x, x - left);
                obstacles.add(x);
            } else {
                int x = q[1];
                int sz = q[2];
                Integer prev = obstacles.floor(x);
                int best = seg.query(1, 0, MAX, 0, prev);
                best = Math.max(best, x - prev);
                ans.add(best >= sz);
            }
        }

        return ans;
    }
}