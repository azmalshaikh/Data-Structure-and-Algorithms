static boolean recreationalSpot(int[] arr , int n) {
    if (n < 3)
        return false;
    Stack < Integer > stack = new Stack < > ();
    int[] temp = new int[n];
    temp[0] = arr[0];
    for(int i = 1; i <n; i++)
        temp[i] = Math.min(temp[i - 1], arr[i]);

    for (int j = n - 1; j >= 0; j--) {
        if (arr[j] > temp[j]) {
            while (!stack.empty() && stack.peek() <= temp[j])
                stack.pop();
            if (!stack.empty() && stack.peek() < arr[j])
                return true;
            stack.push(arr[j]);
        }
    }
    return false;
}
