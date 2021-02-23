public static int countSetBits(int n) {

    if(n == 0) return 0;
    int x = (int)(Math.log(n)/Math.log(2));

    return ((x * (1 << (x-1))) + (n - (1 << x) + 1) + countSetBits(n - (1 << x)));

    // return (int) ( (Math.pow(2, x-1)*x) + (n - Math.pow(2,x) + 1) + 
    //               countSetBits(n - (int)Math.pow(2,x)) );
}
