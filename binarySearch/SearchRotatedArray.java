class Solution {
    int search(int arr[], int low, int high, int key) {
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(arr[mid] == key) return mid;
            
            // Left Part Sorted
            if(arr[low] < arr[mid]) {
                if(arr[low] <= key && arr[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            
            // Right Part Sorted
            else {
                if(arr[mid] < key && arr[high] >= key) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        
        return -1;
    }
}
