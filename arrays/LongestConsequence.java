static int findLongestConseqSubseq(int arr[], int N) {
	    
    HashSet<Integer> set = new HashSet<>();

    int ans = 0;

    for(int i=0; i<arr.length; i++) set.add(arr[i]);

    for(int i=0; i<arr.length; i++) {

        if(!set.contains(arr[i]-1)) {
            int j = arr[i];

            while(set.contains(j)) {
                j++;
            }

            ans = Math.max(ans, j - arr[i]);
        }
    }

    return ans;
}
