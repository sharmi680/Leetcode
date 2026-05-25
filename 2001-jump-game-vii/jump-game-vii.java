class Solution{
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        java.util.Queue<Integer> q=new java.util.LinkedList<>();
        q.offer(0);
        boolean[] visited=new boolean[n];
        visited[0] = true;
        int farthest = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            int start = Math.max(current + minJump, farthest + 1);
            int end = Math.min(current + maxJump, n - 1);
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0' && !visited[i]) {
                    if (i == n - 1) {
                        return true;
                    }
                    visited[i] = true;
                    q.offer(i);
                }
            }

            farthest = end;
        }
        return n == 1;
    }
}