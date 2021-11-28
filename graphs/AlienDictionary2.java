// M-I
public String findOrder(String [] dict, int N, int K) {
    ArrayList<ArrayList<Character>> adj = new ArrayList<>();

    for(int i=0; i<K; i++) {
        adj.add(new ArrayList<>());
    }

    for(int i=0; i<N-1; i++) {
        for(int j=0; j<Math.min(dict[i].length(), dict[i+1].length()); j++) {
            if(dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                adj.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j));
                break;
            }
        }
    }

    int indegree[] = new int [K];

    for(int i=0; i<K; i++) {
        for(char nbr : adj.get(i)) {
            indegree[nbr - 'a']++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i=0; i<K; i++) if(indegree[i] == 0) q.add(i);

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while(!q.isEmpty()) {
        int temp = q.poll();
        sb.append((char)(temp + 'a'));

        for(char nbr : adj.get(temp)) {
            indegree[nbr - 'a']--;
            if(indegree[nbr - 'a'] == 0) q.add(nbr - 'a');
        }
        count++;
    }

    sb.append('\n');
    return sb.toString();
}


// M-II
class Solution {
    public String findOrder(String [] words, int N, int K) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        for(String st: words) {
            for(char ch: st.toCharArray()) {
                indegree.put(ch, 0);
            }
        }
        
        for(int i=0; i<words.length-1; i++) {
            for(int j=0; j<Math.min(words[i].length(), words[i+1].length()); j++) {
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    HashSet<Character> temp = graph.getOrDefault(words[i].charAt(j), new HashSet<>());
                    temp.add(words[i+1].charAt(j));
                    indegree.put(words[i+1].charAt(j), indegree.get(words[i+1].charAt(j))+1);
                    graph.put(words[i].charAt(j), temp);
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(Character ch: indegree.keySet()) {
            if(indegree.get(ch) == 0) {
                q.add(ch);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!q.isEmpty()) {
            Character ch = q.remove();
            
            ans.append(ch);
            
            if(graph.containsKey(ch)) {
                for(Character temp: graph.get(ch)) {
                    indegree.put(temp, indegree.get(temp)-1);
                    
                    if(indegree.get(temp) == 0) {
                        q.add(temp);
                    }
                }
            }
        }
        
        if(ans.length() != indegree.size()) return "";
        
        return ans.toString();
    }
}
