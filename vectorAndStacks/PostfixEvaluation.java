 public static int evaluatePostFix(String str) {
    Stack<Integer> st = new Stack<>();

    for(int i=0; i<str.length(); i++) {
        char c = str.charAt(i);

        if(Character.isDigit(c)) {
            st.push(c - '0');
        } else {
            int v2 = st.pop();
            int v1 = st.pop();
            st.push(calculate(v1, v2, c));
        }
    }

    return st.pop();
}

static int calculate(int v1, int v2, char op) {
    if(op == '+') return v1 + v2;
    else if(op == '-') return v1 - v2;
    else if(op == '*') return v1 * v2;
    else return v1 / v2;
}
