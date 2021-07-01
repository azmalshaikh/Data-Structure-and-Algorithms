import java.util.*;

public class Main {
    public static void main(String args[]) {
        System.out.println(evaluate("2+(5-3*6/2)"));
    }

    static int evaluate(String str) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(') {
                operator.push(c);
            } else if(Character.isDigit(c)) {
                operand.push(c - '0');
            } else if(c == '+' || c == '-' || c == '*' || c == '/') {
                while(!operator.isEmpty() && operator.peek() != '(' && precendence(operator.peek()) >= precendence(c)) {
                    int o2 = operand.pop();
                    int o1 = operand.pop();
                    char op = operator.pop();

                    operand.push(calculate(o1, o2, op));
                }

                operator.push(c);
            } else if(c == ')') {
                while(operator.peek() != '(') {

                    int o2 = operand.pop();
                    int o1 = operand.pop();
                    char op = operator.pop();

                    operand.push(calculate(o1, o2, op));
                }

                operator.pop();
            }
        }

        while(!operator.isEmpty()) {
            int o2 = operand.pop();
            int o1 = operand.pop();
            char op = operator.pop();

            operand.push(calculate(o1, o2, op));
        }

        return operand.pop();
    }

    static int precendence(char operator) {
        if(operator == '+') return 1;
        else if(operator == '-') return 1;
        else if(operator == '*') return 2;
        else if(operator == '/') return 2;

        return -1;
    }

    static int calculate(int o1, int o2, char operator) {
        if(operator == '+') return o1+o2;
        else if(operator == '-') return o1-o2;
        else if(operator == '*') return o1*o2;
        else if(operator == '/') return o1/o2;

        return 0;
    }
}
