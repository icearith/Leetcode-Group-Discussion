import java.util.*;

class Solution {
    private ArrayList<Integer>[] graph;
    private Map<Integer, Integer> colour;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        colour = new HashMap<>(N);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= N; i++) {
            if (!colour.containsKey(i) && !dfs(i, 0))
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int c) {
        if (colour.containsKey(node))
            return colour.get(node) == c;
        colour.put(node, c);
        for (int tnode : graph[node]) {
            if (!dfs(tnode, c ^ 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().possibleBipartition(3, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3},
        });
        System.out.println(res);
    }
}
