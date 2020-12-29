private static int mergeCount(int[] arr, int l, int m, int r) { 

    int[] left = Arrays.copyOfRange(arr, l, m + 1); 

    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

    int i = 0, j = 0, k = l, swap = 0; 

    while (i < left.length && j < right.length)  
    { 
        if (left[i] <= right[j]) 
            arr[k++] = left[i++]; 
        else { 
            arr[k++] = right[j++]; 
            swap += (m + 1) - (l + i); 
        } 
    } 
    return swap; 
} 

private static int mergeSort(int[] arr, int l, int r) { 

    int count = 0; 

    if (l < r) { 
        int m = (l + r) / 2; 
        
        count += mergeSort(arr, l, m); 

        count += mergeSort(arr, m + 1, r); 

        count += mergeCount(arr, l, m, r); 
    } 

    return count; 
}
