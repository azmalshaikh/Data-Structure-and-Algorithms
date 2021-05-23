class Solution {
    
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        // For removing duplicates
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
 
        findNumbers(ans, arr, sum, 0, temp);
        return ans;
    }
    
    static void findNumbers(ArrayList<ArrayList<Integer>> ans, 
        ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {
        
        if(sum == 0) {
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i=index; i<arr.size(); i++) {
            if((sum - arr.get(i)) >= 0) {
                temp.add(arr.get(i));
                findNumbers(ans, arr, sum - arr.get(i), i, temp);
                temp.remove(arr.get(i));
            }
        }
    }
}
