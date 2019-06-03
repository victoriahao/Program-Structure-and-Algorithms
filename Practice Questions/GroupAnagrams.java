import java.util.Arrays;
import java.util.Comparator;

//Practice Question (1)
//Question 9

//Topics - HashTable, Sort

public class GroupAnagrams {
	
	static class Word{
		String s;
		int index;
		
		Word(String s, int index){
			this.s = s;
			this.index = index;
		}
	}
	
	static class DuplicateArr{
		Word[] arr;
		int size;
		
		public DuplicateArr(String s[], int size) {
			this.size = size;
			arr = new Word[size];
			
			int i;
			for(i=0; i<size; i++) {
				arr[i] = new Word(s[i], i);
			}
		}
	}
	
	static class compareString implements Comparator<Word>{
		public int compare(Word a, Word b) {
			return a.s.compareTo(b.s);
		}
	}
	
	static void printAnagrams(String wordArray[], int size) {
		DuplicateArr duplicateArr = new DuplicateArr(wordArray, size);
		
		int i;
		for(i=0; i<size; i++) {
			char[] charArr = duplicateArr.arr[i].s.toCharArray();
			Arrays.sort(charArr);
			duplicateArr.arr[i].s = new String(charArr);
		}
		
		Arrays.sort(duplicateArr.arr, new compareString());
		
		for(i=0; i<size; i++) {
			System.out.print(wordArray[duplicateArr.arr[i].index] + " ");
		}
	}

	public static void main(String[] args) {
		String wordArray[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
		int size = wordArray.length;
		printAnagrams(wordArray, size);

	}

}
