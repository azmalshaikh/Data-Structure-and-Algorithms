public String minRemoveToMakeValid(String s) {
    int open = 0, close = 0;

    for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == ')') close++;
    }

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') {
            if(open >= close) continue;

            open++;
        } else if(ch == ')') {

            close--;

            if(open == 0) continue;

            open--;
        }

        sb.append(ch);
    }

    return sb.toString();
}

public String minRemoveToMakeValid(String s) {
    Stack<Integer> st = new Stack<>();

    for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);

        if(ch == '(') {
            st.push(i);
        } else if(ch == ')'){
            if(!st.isEmpty() && s.charAt(st.peek()) == '(') st.pop();
            else st.push(i);
        }
    }

    HashSet<Integer> set = new HashSet<>();

    while(!st.isEmpty()) set.add(st.pop());

    // Without HashMap


    StringBuilder ans = new StringBuilder();

    for(int i=0; i<s.length(); i++) {
        if(!set.contains(i)) ans.append(s.charAt(i));
    }

    return ans.toString();

}
