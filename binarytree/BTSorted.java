public static void main (String[] args) {
  Scanner sc = new Scanner(System.in);
  int t = sc.nextInt();
  while(t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int [n];
      for(int i=0; i<n; i++) {
          arr[i]=sc.nextInt();
      }

      printSorted(arr, n); 
  }
}

static void printSorted(int arr[], int n) {
    int level = 0;
    for(int i=0; i<n;level++) {
        int cur = (int)Math.pow(2, level);

        cur -= 1;

        int j = Math.min(i+cur, n-1);

        Arrays.sort(arr, i, j+1);

        while(i <= j) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
    }
}
