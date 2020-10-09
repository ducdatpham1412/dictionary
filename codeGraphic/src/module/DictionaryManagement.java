package module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class DictionaryManagement {

	
	static Scanner input = new Scanner(System.in);
	
	
	
	// Biến private Dictionary dic, mỗi management sẽ quản lý duy nhất một dictionary

	private Dictionary dic = new Dictionary();

	public Dictionary getDictionary() {
		return this.dic;
	}
	
	
	private String filename = "dictionaries.txt";
	
	
	// Import tất cả các từ trong file vào trong dữ liệu Dictionay của management
	
	public void insertFromFile() {
		
		
		File file = new File("dataSource\\"+filename);

		try {
			
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line=null;
			
			try {
				
				while ( (line=reader.readLine())!=null ) {
					
					int separate = line.indexOf("\t");
				
					String word_target = line.substring(0, separate);
					String word_explain = line.substring(separate+1);
					
					Word newWord = new Word(word_target, word_explain);
					
					dic.addWord(newWord);
				}
				
				
			} catch (IOException e) {
				
				System.out.println("Has error in reading file");
			}
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Can't find file");
		}
	}
	
	
	
	
	
	//Khi có một từ cần thêm, gọi hàm này để thêm từ đó vào cả trong Dictionay dic và file quản lý
	
	public void writeToData(String word_target, String Word_explain) {
		
		Word newWord = new Word(word_target, Word_explain);
		this.dic.addWord(newWord);
		
		File file = new File("dataSource\\"+filename);
		
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			
			String str = newWord.getWord_target()+"\t"+newWord.getWord_explain()+"\r\n";
			writer.append(str);
			
			writer.close();
			
		} catch (IOException e) {
			System.out.println("Has error in writing to file");
		}
			
	}
	
	
	
	
	
	// Xóa một chuỗi các từ target đã chọn và cả nghĩa của nó, xóa cả trong dic và trong cả file
	
	public void deleteWord(Vector<String> word_targets) {
		
		for (int i=0; i<word_targets.size(); i++) {
			String word_target = word_targets.get(i);
			int index = this.dic.indexOfWordTarget(word_target);
			this.dic.removeWord(index);
		}
		
		File file = new File("dataSource\\"+filename);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			for (int i=0; i<this.dic.getSize(); i++) {
				String str = this.dic.getWord(i).getWord_target()+"\t"+this.dic.getWord(i).getWord_explain()+"\r\n";
				writer.append(str);
			}
			
			writer.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println("Has error in writing to file");
		}
	}
	
	
	
	
	// 2 hàm dưới đây để Edit Word, có nhiệm vụ sửa cả trong dic và cả trong file
	
	public void editWord(int index, String word_target, String word_explain) {
		
		this.dic.getWord(index).setWord_target(word_target);
		this.dic.getWord(index).setWord_explain(word_explain);
	}
	
	public void writeToDataAfterEdit() {
		
		File file = new File("dataSource\\"+filename);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			for (int i=0; i<this.dic.getSize(); i++) {
				String str = this.dic.getWord(i).getWord_target()+"\t"+this.dic.getWord(i).getWord_explain()+"\r\n";
				writer.append(str);
			}
			
			writer.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Has error in writing to file");
		}
	}
	
	
}
