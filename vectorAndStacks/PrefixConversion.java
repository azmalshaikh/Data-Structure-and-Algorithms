import java.util.*;

public class Main {
    public static void main(String args[]) {
        prefixToInfixAndPostfix("-+a*b^-^cde+f*ghi");

        // -+a*b^-^cde+f*ghi
    }

    public static void prefixToInfixAndPostfix(String str) {
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        
        for(int i=str.length()-1; i>=0; i--) {
            char c = str.charAt(i);
            
            if(Character.isLetter(c)) {
                infix.push(Character.toString(c));
                postfix.push(Character.toString(c));
            } else {

                String v1 = infix.pop();
                String v2 = infix.pop();
                infix.push("(" + v1 + c + v2 + ")");

                v1 = postfix.pop();
                v2 = postfix.pop();
                postfix.push(v1 + v2 + c);
            }
        }
        
        System.out.println("Infix is " + infix.pop());
        System.out.println("Postfix is " + postfix.pop());
    }
    
    static int calculate(int v1, int v2, char op) {
        if(op == '+') return v1 + v2;
        else if(op == '-') return v1 - v2;
        else if(op == '*') return v1 * v2;
        else return v1 / v2;
    }
}
