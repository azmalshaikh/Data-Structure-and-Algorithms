package BackTracking;
import java.util.* ;

public class PartitionAnArray {

	public static void main(String[] args) {
		
		int a [] = {2, 1, 3, 4, 8, 2} ;
		int sum = 0 ;
		for(int s : a ) {
			sum += s ;
		}
		ArrayList <Integer> ans = new ArrayList <>();

		boolean possible = (sum&1) == 0 && partition(a, sum/2, 0, ans);
		
		if(possible) {
			for(int x : ans ) {
				System.out.print(x + " ");
			}
		} else {
			System.out.println("Not possible");
		}

	}
	
	static boolean partition (int a[], int sum, int i, ArrayList <Integer> ans ) {
		
		if(i >= a.length || sum < 0) return false ;
		if(sum == 0) return true ;
		
		ans.add(a[i]);
		boolean left = partition(a, sum-a[i], i+1, ans) ;
		
		if(left) return true ;
		ans.remove(ans.size()-1);
		return partition(a, sum, i+1, ans);
	}

}
