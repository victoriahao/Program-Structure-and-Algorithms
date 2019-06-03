//Practice Questions (1)
//Question 1

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

//Sort Characters by Frequency
//Topics - HashTable, Sort
//Sort in decreasing order based on frequency


//I chose to use HashTable and PriorityQueue for my answers
//First assume that it cannot have null values, so I use HashTable
public class SortCharByFrequency {
	
	class Element{
		int count;
		char c;
		public Element(char c, int count) {
			this.c = c;
			this.count = count;
		}		
	}
	
	public String CharFrequency(String str) {
		
		if(str == null || str.length() == 0) {
			return "";  //If the string is null, then return empty string
		}
		
		Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
		
		for(int i=0; i<str.length(); i++) {
			hashtable.put(str.charAt(i), hashtable.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		PriorityQueue<Element> priorityqueue = new PriorityQueue<Element>(str.length(), new Comparator<Element>() {
			public int compare(Element m, Element n) {
				if(m.count > n.count) {
					return -1;
				}
				else if(m.count == n.count) {
					return 0;
				}
				else {
					return 1;
				}
				
			}
		});
		
		for(char key: hashtable.keySet()) {
			Element e = new Element(key, hashtable.get(key));
			priorityqueue.offer(e);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!priorityqueue.isEmpty()) {
			Element polled = priorityqueue.poll();
			for(int i=0; i<polled.count; i++) {
				sb.append(polled.c);
			}
		}
		return sb.toString();

	}
	
	public static void main(String[] args) {
		
		SortCharByFrequency sortchar = new SortCharByFrequency();
		
		String s = sortchar.CharFrequency("tree");
		System.out.println(s);

	}

}
