package dictionary;

import java.util.ArrayList;

public class Dictionary {
	
	
	//Tao 2 ArrayList la words de luu cac cap tu moi phuc vu cac ham insert, lookup va search
	//và word_target de giup ham DictionaryLookUp duoc de dang hon
	
	private ArrayList<Word> words = new ArrayList<>();
	private ArrayList<String> word_target = new ArrayList<>();
	
	
	public int getSize() {
		return this.words.size();
	}
	
	
	//Them mot cap tu target - expalain vao trong mang
	
	public void setWord(Word w) {
		words.add(w);
		word_target.add(w.getWord_target());
	}
	
	
	//Lay cap tu o vi tri index = k
	
	public Word getWord(int k) {
		return words.get(k);
	}
	
	
	//Xoa tu o vi tri index = k, phuc vu cho ham deleteWord
	
	public void removeWord(int k) {
		this.words.remove(k);
	}
	
	
	// tra ve vi tri index cua mot tu target trong mang word_target
	
	public int indexOfWord(String w) {
		return word_target.indexOf(w);
	}

	
}
