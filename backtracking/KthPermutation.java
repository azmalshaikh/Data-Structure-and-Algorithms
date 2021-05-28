import java.util.*;

public class Main {
    public static void main(String args[]) {
        System.out.println(kthpermutation(4, 9));
    }

    static String kthpermutation(int n, int k) {
        k--;
        String ans = "";
        ArrayList<Integer> list = new ArrayList<>();
        int factorial = 1;

        for(int i=1; i<n; i++) {
            factorial *= i;
            list.add(i);
        }

        list.add(n);

        while(true) {
            ans += Integer.toString(list.get(k/factorial));

            list.remove(k/factorial);

            if(list.isEmpty()) break;

            k %= factorial;
            factorial /= list.size();
        }

        return ans;
    }
}
