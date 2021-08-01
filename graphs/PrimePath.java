public static boolean isPrime(int n) {
        for(int i=2; i*i<=n; i++) if(n%i == 0) return false;
        
        return true;
    }

    public static boolean isValid(int i, int j) {
        int count = 0;
        while(i > 0) {
            if(i%10 != j%10) count++;
            i /= 10;
            j /= 10;
        }

        return count == 1;
    }

	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            ArrayList<Integer> graph[] = new ArrayList[100001];
            
            for(int i=1000; i<=9999; i++) graph[i] = new ArrayList<>();

            ArrayList<Integer> primes = new ArrayList<>();

            for(int i=1000; i<=9999; i++) {
                if(isPrime(i)) primes.add(i);
            }

            // Creating Edges
            for(int i=0; i<primes.size()-1; i++) {
                for(int j=i+1; j<primes.size(); j++) {
                	int x = primes.get(i), y = primes.get(j);
                    if(isValid(x, y)) {
                        graph[x].add(y);
                        graph[y].add(x);
                    }
                }
            }

            boolean vis[] = new boolean[100001];
            int parent[] = new int [100001];

            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            vis[a] = true;
            parent[a] = -1;
            boolean hasPath = false;

            while(!q.isEmpty()) {
                int temp = q.remove();

                if(temp == b) {
                    hasPath = true;
                    break;
                }

                for(int nbr: graph[temp]) {
                    if(!vis[nbr]) {
                        q.add(nbr);
                        vis[nbr] = true;
                        parent[nbr] = temp;
                    }
                }
            }

            if(!hasPath) System.out.println("Impossible");

            int cur = b, ans = 0;
            while(parent[cur] != -1) {
                cur = parent[cur];
                ans++;
            }

            System.out.println(ans);
        }
	}
