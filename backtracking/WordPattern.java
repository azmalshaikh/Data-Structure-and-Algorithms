class GfG {
    
    // M - I
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
        
        ArrayList<String> res = new ArrayList<>();
        
	    int len = pattern.length();
	    
	    for(String str: dict) {
	        if(check(str, pattern)) res.add(str);
	    }
	    
	    return res;
	}
	
	static boolean check(String word, String pattern) {
	    int len = pattern.length();
	    
	    if(word.length() != len) return false;
	    
	    char arr[] = new char [128];
	    
	    for(int i=0; i<len; i++) {
	        if(arr[(int)pattern.charAt(i)] == 0) {
	            arr[(int)pattern.charAt(i)] = word.charAt(i);
	        } else if(arr[(int)pattern.charAt(i)] != word.charAt(i)) {
	            return false;
	        }
	    }
	    
	    return true;
	}

    // M - II
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
        
        ArrayList<String> res = new ArrayList<>();
        
	    int len = pattern.length();
	    String hash = encode(pattern);
	    
	    for(String str: dict) {
	        if(str.length() == len && encode(str).equals(hash)) res.add(str);
	    }
	    
	    return res;
	}
	
	static String encode(String str) {
	    int counter=1;
	    String res = "";
	    HashMap<Character, Integer> map= new HashMap<>();
	    
	    for(int i=0; i<str.length(); i++) {
	        char c = str.charAt(i);
	        if(!map.containsKey(c)) {
	            map.put(c, counter);
	            counter++;
	        }
	        res += map.get(c);
	    }
	    
	    return res;
	}
}
