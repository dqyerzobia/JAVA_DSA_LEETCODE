class Solution {
    public static ArrayList<ArrayList<Integer>> adj;
    public static int [] visited;

    public static int bfs(int src){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        visited[src] = 1;
        int size = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            size++;

            for(int ne: adj.get(curr)){
                if(visited[ne] == 0){
                    visited[ne] = 1;
                    q.offer(ne);
                }
            }
        }

        return size;
    }

    public long countPairs(int n, int[][] edges) {
        adj = new ArrayList<>();
        visited = new int [n];

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e: edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> sizes = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                sizes.add(bfs(i));
            }
        }
        
        //remianig unreachable nodes
        int remaining = n;
        long ans  = 0;

        for(int size: sizes){
            remaining -= size;
            ans += (long) size * remaining;
        }

        return ans;
    }
}