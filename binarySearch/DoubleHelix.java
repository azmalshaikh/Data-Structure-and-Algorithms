import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();

            if(n == 0 ) break;

            int arr1[] = new int [n];
            for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
            
            int m = sc.nextInt();
            int arr2[] = new int [m];
            for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
            
            int sum1=0, sum2=0;
            int i=0, j=0;
            int ans = 0;

            while(i < n && j < m) {
                if(arr1[i] < arr2[j]) {
                    sum1 += arr1[i++];
                } else if(arr2[j] < arr1[i]) {
                    sum2 += arr2[j++];
                } else {
                    ans += Math.max(sum1, sum2) + arr1[i];
                    sum1 = sum2 = 0;
                    i++;
                    j++;
                }
            }

            while(i<n) {
                sum1 += arr1[i++];
            }

            while(j<m) {
                sum2 += arr2[j++];
            }
            
            ans += Math.max(sum1, sum2);        

            System.out.println(ans);
        }
		
	}
}
