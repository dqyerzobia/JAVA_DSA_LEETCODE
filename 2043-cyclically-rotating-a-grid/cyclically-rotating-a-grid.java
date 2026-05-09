class Solution {

    public static void rotate(ArrayList<Integer> nums, int n, int k){
        k = k % n;

        Collections.reverse(nums.subList(0, k));
        Collections.reverse(nums.subList(k, n));
        Collections.reverse(nums);
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m/2, n/2);


        for(int layer = 0; layer < layers; layer++){
            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            ArrayList<Integer> nums = new ArrayList<>();

            //left --> right
            for(int i = left; i<= right; i++){
                nums.add(grid[top][i]);
            }

            //right --> bottom
            for(int i = top+1; i<bottom; i++){
                nums.add(grid[i][right]);
            }

            //bottom --> left
            for(int i = right; i>=left; i--){
                nums.add(grid[bottom][i]);
            }

            //bottom --> top
            for(int i = bottom-1;i > top;i--){
                nums.add(grid[i][left]);
            }

            //rotate the complete layer of nums
            int size = nums.size();
            rotate(nums,size,k);

            //fill the grid again with new rotate list sequence
            int idx = 0;

            for(int i = left; i<=right; i++){
                grid[top][i] = nums.get(idx++);
            }

            for(int i = top + 1; i<bottom; i++){
                grid[i][right] = nums.get(idx++);
            }

            for(int i = right; i>=left; i--){
                grid[bottom][i] = nums.get(idx++);
            }

            for(int i = bottom-1; i > top; i--){
                grid[i][left] = nums.get(idx++);
            }
        }

        return grid;
    }
}