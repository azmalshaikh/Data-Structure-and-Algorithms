int search(String pat, String txt) {
    int n = txt.length();
    int k = pat.length();

    int arr[] = new int [256];

    for(int i=0; i<k; i++) {
        arr[pat.charAt(i)]++;
    }

    for(int i=0; i<k; i++) {
        arr[txt.charAt(i)]--;
    }

    int res = 0;
    if(zero(arr)) res++;

    for(int i=k; i<n; i++) {
        arr[txt.charAt(i)]--;

        arr[txt.charAt(i-k)]++;

        if(zero(arr)) res++;
    }

    return res;
}

boolean zero(int arr[]) {
    for(int i=0; i<256; i++) {
        if(arr[i] != 0) return false;
    }
    return true;
}
