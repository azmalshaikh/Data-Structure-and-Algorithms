class Solution {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)  {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0, j=0, k=0, temp=Integer.MIN_VALUE;
        
        while(i<n1 && j<n2 && k<n3) {
            int minE = Math.min(A[i], Math.min(B[j], C[k]));
            
            if(minE == A[i] && minE == B[j] && minE == C[k] && temp != minE) {
                ans.add(A[i]);
                i++;j++;k++;
                temp = minE;
            } else if(minE == A[i]) {
                i++;
            } else if(minE == B[j]) {
                j++;
            } else {
                k++;               
            }
        }  
        return ans;
    }
}
