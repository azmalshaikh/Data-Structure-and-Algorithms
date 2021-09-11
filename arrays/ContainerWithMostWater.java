class Solution {
    public int maxArea(int[] arr) {
        int i=0, j=arr.length-1;
        int area = (j-i) * Math.min(arr[i], arr[j]);
        
        while(i<j) {
            area = Math.max(area, (j-i) * Math.min(arr[i], arr[j]));
            if(arr[i] > arr[j]) {
                j--;
            } else {
                i++;
            }
        }
        
        return area;
    }
}
