public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-- > 0) {
          int n = sc.nextInt();
          int a[] = new int [n];
          for(int i=0; i<n; i++) {
              a[i] = sc.nextInt();
          }

          System.out.println(getCount(a,n));
      }

}
	
static int getCount(int arr[], int n) {
    int ans = 0;

    for(int i=0; i<n; i++) {
        int curCount = 0;

        while(i < n && arr[i]>=0) {
            curCount++;
            i++;
        }

        ans = Math.max(ans, curCount);
    }

    return ans;
}
