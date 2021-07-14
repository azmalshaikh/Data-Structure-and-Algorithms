import java.util.*;

class Solution {
    public int subarraySum(int[] arr, int k) {
        int ans = 0, curSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++) {
            curSum += arr[i];
            
            if(curSum == k) {
                ans++;
            }
            
            if(map.containsKey(curSum - k) && k == 0) {
                ans += map.get(curSum - k);
            }
            
            map.put(curSum, map.getOrDefault(curSum,0) + 1);
            
            if(map.containsKey(curSum - k) && k != 0) {
                ans += map.get(curSum - k);
            }
        }
        
        return ans;
    }
}
