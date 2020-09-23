package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement {
	

	static Scanner input = new Scanner(System.in);
	
	
	// Moi doi tuong DictionaryManagement co duy nhat mot tu dien
	
	private Dictionary dic = new Dictionary();
	
	public Dictionary getDictionary() {
		return this.dic;
	}
	
	
	
	//Them tu moi vao tu dien bang CommmandLine
	
	public void insertFromCommandLine() {
		
		int number_word = input.nextInt();
		String trash = input.nextLine();
		
		for (int i=0; i<number_word; i++) {
			
			System.out.print("Enter word_target: ");
			String word_target = input.nextLine();
			
			System.out.print("Enter word_explain: ");
			String word_explain = input.nextLine();
			
			Word word = new Word(word_target, word_explain);
			
			dic.setWord(word);
			
		}
		
	}
	
	
	
	// Ham them tu moi bang File, ham nay throw Exception FileNotFound va catch ngoai le nay 
	// o ben ham DictionaryAdvanced trong doi tuong DictionaryCommandLine
	
	public void insertFromFile() throws FileNotFoundException {
		
		File file = new File("dictionaries.txt");
		FileReader fileReader = new FileReader(file);
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line = null;
		
		try {
			while ( (line=reader.readLine())!=null ) {
			
				int separate = line.indexOf("\t");
				String word_target = line.substring(0, separate);
				String word_explain = line.substring(separate+1);
				
				Word word = new Word(word_target, word_explain);
				
				dic.setWord(word);
			}
		} catch (IOException e) {
			System.out.println("Has error in reading file");
		}
			
	}
	
	
	
	// Ham tim kiem tu, vang lap den khi nao ban khong can tim nua thi thoi
	
	public void dictionaryLookup() {
		
		int k;
		String trash;
		
		System.out.print("\n\nWant to look up any words? 1-yes / 0-no: ");
		k = input.nextInt();
		trash = input.nextLine();
		
		if (k==1) {
			while (true) {
				System.out.print("\n\nEnter the word want to look up: ");
				String word = input.nextLine();
				
				int index = dic.indexOfWord(word);
				if ( index >= 0 ) {
					System.out.println("The meaning of "+word+" is: "+dic.getWord(index).getWord_explain()+"\n");
				}
				else System.out.println("The word you search hasn't in dictionary\n");
				
				
				System.out.print("Want to continue? 1-yes / 0-no: ");
				k = input.nextInt();
				trash = input.nextLine();
				
				if (k==1) continue;
				else break;
			}
		}
	}
	
	
	
	// Cac ham them, sua, xoa
	
	//Ham them tu moi vao du lieu va ghi ra file
	public void addData() {
		System.out.println("Enter word target and expalain: ");
		String target = input.nextLine();
		String explain = input.nextLine();
		
		Word newWord = new Word(target, explain);
		dic.setWord(newWord);
		
		File file = new File("dictionaries.txt");
		
		try {
			
			FileWriter fileWriter = new FileWriter(file, true);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.append(target);
			writer.append("\t");
			writer.append(explain);
			writer.append("\r\n");
			
			
			writer.close();
			
			System.out.println("Write to file successfully");
			
		} catch (IOException e) {
			System.out.println("Has error");
		}
	}
	
	
	//Sua nghia expalain cua mot tu target trong du lieu
	
	public void editData() {
		
		System.out.print("Enter the word_target you want to change word_explain: ");
		String word_target = input.nextLine();
		
		int index = -1;
		
		for (int i=0; i<dic.getSize(); i++) {
			if ( dic.getWord(i).getWord_target().equals(word_target) ) {
				index = i;
				break;
			}
		}
		
		if ( index == -1 ) {
			System.out.println("The dictinary doesn't have this word");
			return;
		}
		
		System.out.print("Enter the word_explain to replace: ");
		String explainReplace = input.nextLine();
		
		dic.getWord(index).setWord_explain(explainReplace);
		
		System.out.println("Successfully changed\n");
		
	}
	
	
	//Xoa mot cap tu target va explain trong du lieu
	
	public void deleteData() {
		
		System.out.print("Enter word_target want to delete: ");
		String targetDelete = input.nextLine();
		
		int index = -1;
		
		for (int i=0; i<dic.getSize(); i++) {
			if ( dic.getWord(i).getWord_target().equals(targetDelete) ) {
				index = i;
				break;
			}
		}
		
		if ( index==-1 ) {
			System.out.println("The dictionary doesn't have this word");
			return;
		}
		
		dic.removeWord(index);
	}
	
	
	
	//Export toan bo du lieu ra file
	
	public void dictionaryExportToFile() {
		
		File file = new File("dictionaries.txt");
		
		try {
			
			FileWriter fileWriter = new FileWriter(file);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			for (int i=0; i<dic.getSize(); i++) {
				writer.write( dic.getWord(i).getWord_target() );
				writer.write("\t");
				writer.write( dic.getWord(i).getWord_explain() );
				writer.write("\n");
			}
			
			writer.close();
			
		} catch (IOException e) {
			System.out.println("Having some error in writing file");
		}
	}
	
	
}
