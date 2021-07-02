import java.util.*;

public class Main {
    public static void main(String args[]) {
        postfixToInfixAndPrefix("abcd^e-fgh*+^*+i-");
    }

    public static void postfixToInfixAndPrefix(String str) {
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            if(Character.isLetter(c)) {
                infix.push(Character.toString(c));
                prefix.push(Character.toString(c));
            } else {

                String v2 = infix.pop();
                String v1 = infix.pop();
                infix.push("(" + v1 + c + v2 + ")");

                v2 = prefix.pop();
                v1 = prefix.pop();
                prefix.push(c + v1 + v2);
            }
        }
        
        System.out.println("Infix is " + infix.pop());
        System.out.println("Prefix is " + prefix.pop());
    }
    
    static int calculate(int v1, int v2, char op) {
        if(op == '+') return v1 + v2;
        else if(op == '-') return v1 - v2;
        else if(op == '*') return v1 * v2;
        else return v1 / v2;
    }
}
