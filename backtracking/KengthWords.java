public class Main {
    public static void main(String args[]) {
        System.out.println(klengthwords("geeksforgeeks", 4));
    }

    static int klengthwords(String str, int k) {
        boolean isPresent [] = new boolean [26];
        int count = 0;

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(!isPresent[c - 'a']) {
                isPresent[c - 'a']  = true;
                count++;
            }
        }

        int ans = 1;

        //nPr

        for(int i=1; i<=count; i++) {
            ans *= i;
        }

        for(int i=count-k; i>1; i--) {
            ans /= i;
        }

        return ans;
    }
}
