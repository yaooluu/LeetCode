package datastructure;

import java.util.*;

public class P146_DataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class LRUCache {
	    
	    int len = 0;
	    Set<Integer> set = new HashSet<Integer>();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    Queue<Integer> q = new LinkedList<Integer>();
	    
	    public LRUCache(int capacity) {
	        len = capacity;
	    }
	    
	    public int get(int key) {
	        if(set.contains(key)) {
	            if(q.peek()==key) {
	                q.poll();
	                q.add(key);
	            }
	            return map.get(key);
	        }
	        else return -1;
	        
	    }
	    
	    public void set(int key, int value) {
	        if(set.contains(key)) {
	        	List<Integer> l = new ArrayList<Integer>();
	        	l.add(key);   
	            q.removeAll(l);
	        }else {
	        	if(set.size()==len) set.remove(q.poll());
	        	set.add(key);
	        }
            q.add(key);
            map.put(key,value);
	    }
	}
	
}
