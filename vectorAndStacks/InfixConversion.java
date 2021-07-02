import java.util.*;

public class Main {
    public static void main(String args[]) {
        infixToPrefixPostfix("a+b*(c^d-e)^(f+g*h)-i");
    }

    public static void infixToPrefixPostfix(String str) {
	    Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
	    Stack<Character> operator = new Stack<>();
	    
	    for(int i=0; i<str.length(); i++) {
	        char c = str.charAt(i);
	        
	        if(c == '(') {
	            operator.push(c);
	        } else if(Character.isLetter(c)) {
	            post.push(Character.toString(c));
                pre.push(Character.toString(c));
	        } else if(c == ')') {
	            while(operator.peek() != '(') {
	                String v2 = post.pop();
	                String v1 = post.pop();
                    char op = operator.pop();
	                
	                post.push(v1 + v2 + op);

                    v2 = pre.pop();
	                v1 = pre.pop();
	                
	                pre.push(op + v1 + v2);
	            }
	            
	            operator.pop();
	        } else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
	            while(!operator.isEmpty() && operator.peek() != '(' && precendence(c) <= precendence(operator.peek()) ) {
	                String v2 = post.pop();
	                String v1 = post.pop();
                    char op = operator.pop();
	                
	                post.push(v1 + v2 + op);

                    v2 = pre.pop();
	                v1 = pre.pop();
	                
	                pre.push(op + v1 + v2);
	            }
	            
	            operator.push(c);
	        }
	    }
	    
	    while(!operator.isEmpty()) {
	        String v2 = post.pop();
            String v1 = post.pop();
            char op = operator.pop();
            
            post.push(v1 + v2 + op);

            v2 = pre.pop();
            v1 = pre.pop();
            
            pre.push(op + v1 + v2);
	    }
	    
	    System.out.println("Prefix is " + pre.pop());
        System.out.println("Postfix is " + post.pop());
	} 
	
	static int precendence(char c) {
	    if(c == '^') return 3;
	    else if(c == '*' || c == '/') return 2;
	    else if(c == '+' || c == '-') return 1;
	    
	    return 0;
	}
}
