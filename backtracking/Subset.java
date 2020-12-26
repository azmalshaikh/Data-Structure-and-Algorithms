class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        subset(nums, 0, list, ans, true);
        return list;
    }
    
    void subset(int a[], int vidx, List<List<Integer>> list, List<Integer> ans, boolean flag) {
        
        if(vidx == a.length) {
            list.add(new ArrayList<>(ans));
            return;
        }
        
        if(flag == false && a[vidx] == a[vidx - 1]) {
            subset(a, vidx+1, list, ans, false);
        } else {  
            ans.add(a[vidx]);
            subset(a, vidx+1, list, ans, true);
            ans.remove(ans.size()-1);
            subset(a, vidx+1, list, ans, false);
        }
    }
}
