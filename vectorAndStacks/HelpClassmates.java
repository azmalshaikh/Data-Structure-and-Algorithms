public static int[] help_classmate(int arr[], int n) { 
    int ans[] = new int [n];
    Arrays.fill(ans, -1);

    Stack<Integer> s = new Stack<>();

    for(int i=0; i<n; i++) {
        if(s.isEmpty()) s.push(i);

        if(arr[s.peek()] < arr[i]) s.push(i);
        else {
            while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
               ans[s.pop()] = arr[i];
            }
            s.push(i);
        }
    }


   // int l=0, r=1;

   // while(l<n && r<n) {
   //     if(arr[l] < arr[r]) r++;

   //     else if(arr[l] > arr[r]) {
   //         ans[l] = arr[r];
   //         l++;
   //         r=l+1;
   //     }
   // }

    return ans;
}
