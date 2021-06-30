public class Main {

    static class kstack {
        int arr[], top[], next[], free;

        public kstack(int n, int k) {
            arr = new int [n];
            top = new int [k];
            next = new int [n];

            for(int i=0; i<k; i++) top[i] = -1;

            free = 0;
            for(int i=0; i<n-1; i++) next[i] = i+1;

            next[n-1] = -1;
        }

        public boolean isFull() {
            return (free == -1);
        }
        
        public boolean isEmpty(int sn) {
            return (top[sn] == -1);
        }

        void push(int data, int sn) {
            if(isFull()) {
                System.out.println("Stack Overflow");
            }

            int i = free;
            free = next[i];
            next[i] = top[sn];
            top[sn] = i;

            arr[i] = data;
        }

        int pop(int sn) {
            if(isEmpty(sn)) System.out.println("Stack is Empty");

            int i = top[sn];

            top[sn] = next[i];
            next[i] = free;
            free = i;

            return arr[i];
        }
    }

    public static void main(String args[]) {
        kstack stack = new kstack(10, 3);

        stack.push(10, 1);
        stack.push(15, 1);
        stack.push(20, 1);
        stack.push(25, 1);

        stack.push(6, 2);
        stack.push(8, 2);

        stack.push(1, 0);
        stack.push(9, 0);
        stack.push(13, 0);

        System.out.println("Popped element from stack 2 is " + stack.pop(1));
        System.out.println("Popped element from stack 2 is " + stack.pop(1));
        System.out.println("Popped element from stack 1 is " + stack.pop(0));
        System.out.println("Popped element from stack 1 is " + stack.pop(0));
        System.out.println("Popped element from stack 3 is " + stack.pop(2));
        System.out.println("Popped element from stack 3 is " + stack.pop(2));

    }
}
