class Solution {
    
    public int scoreOfParentheses(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
    
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                // Treat -1 as '('
                st.push(-1); 
            } else {
                if(st.peek() == -1) {
                    st.pop();
                    st.push(1);
                } else {
                    int score = 0;
                    while(st.peek() != -1) score += st.pop();
                    st.pop();
                    st.push(2*score);
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty()) ans += st.pop();
        
        return ans;
    }
}

// M-III
// Using Tree
class Solution {
    
    class Node {
        Node parent = null;
        ArrayList<Node> child = new ArrayList<>();
        
        public void setParent(Node parent) {
            this.parent = parent;
        }
        
        public Node getParent() {
            return parent;
        }
        
        public int getScore() {
            if(child.size() == 0) {
                return 1;
            }
            
            int ans = 0;
            for(Node node: child) {
                ans += node.getScore();
            }
            
            if(parent == null) return ans;
            else return 2*ans;
        }
    }
    
    public int scoreOfParentheses(String s) {
        Node cur = new Node();
        Node root = cur;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                Node temp = new Node();
                cur.child.add(temp);
                temp.setParent(cur);
                cur = temp;
            } else {
                cur = cur.getParent();
            }
        }
        
        return root.getScore();
    }
}
