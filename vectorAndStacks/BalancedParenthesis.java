package vectorAndStacks;

import java.util.Scanner;
import java.util.Stack; 

public class BalancedParenthesis {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		String expression = sc.nextLine();
	    Stack <Character> number = new Stack <>();
	    
	    boolean balanced = true ;
	    
	    for (int j=0 ; j<expression.length() ; j++ ) {
	        char c = expression.charAt(j) ;
	        if(c=='(' || c=='{' || c=='[' ) {
	            number.push(c);
	            continue;
	        }
	        if(number.isEmpty()) {
	            balanced = false ;
	            break ;
	        }
	        if(c==')') {
	            if(number.peek() == '(') {
	                number.pop();
	            } else {
	                balanced = false ;
	                break ;
	            }
	        }
	        if(c=='}') {
	            if(number.peek() == '{') {
	                number.pop();
	            } else {
	                balanced = false ;
	                break ;
	            }
	        }
	        if(c==']') {
	            if(number.peek() == '[') {
	                number.pop();
	            } else {
	                balanced = false ;
	                break ;
	            }
	        }
	    }
	    if(!number.isEmpty()) {
	        balanced = false ;
	    } 
	    if(balanced){
	        System.out.println("balanced");
	    } else {
	        System.out.println("not balanced");
	    }
	}

}
