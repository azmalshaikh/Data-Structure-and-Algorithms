public static void main(String args[]) {
    int arr[] = {9, 5, 3};
    int n = 3;

    minimumxorpairs(arr, n);
}

// Traverse the array and then check for every consecutive pairs

static void minimumxorpairs(int arr[], int n) {
    Arrays.sort(arr);

    ArrayList<String> ans = new ArrayList<>();
    int minxor = Integer.MAX_VALUE;
    for(int i=0; i<n-1; i++) {
        int xor = arr[i] ^ arr[i+1];

        if(xor < minxor) {
            minxor = xor;
            ans = new ArrayList<>();
            ans.add(arr[i] + ", " + arr[i+1]);
        } else if(xor == minxor) {
            ans.add(arr[i] + ", " + arr[i+1]);
        }
    }

    for(String str: ans) {
        System.out.println(str);
    }
}
