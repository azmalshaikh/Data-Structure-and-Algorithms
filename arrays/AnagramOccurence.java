int search(String pat, String txt) {
    int n = txt.length();
    int k = pat.length();

    int arr1[] = new int [256];
    int arr2[] = new int [256];

    for(int i=0; i<k; i++) {
        arr2[pat.charAt(i)]++;
    }

    for(int i=0; i<k; i++) {
        arr1[txt.charAt(i)]++;
    }

    int res = 0;
    if(Arrays.equals(arr1, arr2)) res++;

    for(int i=k; i<n; i++) {
        arr1[txt.charAt(i)]++;

        arr1[txt.charAt(i-k)]--;

        if(Arrays.equals(arr1, arr2)) res++;
    }

    return res;
}
