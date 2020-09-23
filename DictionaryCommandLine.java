package dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
	
	
	static Scanner input = new Scanner(System.in);
	
	//Moi doi tuong DictionaryCommandLine se co duy nhat mot management de quan ly du lieu
	
	private DictionaryManagement management = new DictionaryManagement();
	
	
	//Ham in ra tat ca tu trong du lieu
	
	private void showAllWords() {
		
		System.out.printf("%-6s %s %-20s %s %s\n\n", "No", "|", "English" ,"|", "Vietnamese");
		
		Dictionary dic = management.getDictionary();
		
		for (int i=0; i<dic.getSize(); i++) {
			
			Word tempt = dic.getWord(i);
			System.out.printf("%-6d %s %-20s %s %s\n", i+1, "|", tempt.getWord_target(), "|", tempt.getWord_explain());
			
		}
	}
	
	
	//DictionaryBasic
	
	public void dictionaryBasic() {
		
		management.insertFromCommandLine();
		this.showAllWords();
	}
	
	
	
	//DictionaryAdvanced
	
	public void dictionaryAdvanced() {
		
		try {
			management.insertFromFile();
		} catch (Exception e) {
			System.out.println("Can not open file request\n");
		}
		this.showAllWords();
		
		management.dictionaryLookup();
		
	}
	
	
	
	//Ham tra ve tat ca cac tu target co lien quan den du lieu nhap vao
	
	public ArrayList<String> dictionarySearcher() {
		
		ArrayList<String> result = new ArrayList<>();
		
		System.out.print("Enter the word want to search: ");
		String word = input.nextLine();
		
		Dictionary dic = management.getDictionary();
		
		for (int i=0; i<dic.getSize(); i++) {
			if ( dic.getWord(i).getWord_target().indexOf(word) > -1 ) {
//				System.out.print(dic.getWord(i).getWord_target() + ", ");
				result.add(dic.getWord(i).getWord_target());
			}
		}
		
		return result;
	}
	
	
	
	//Main
	
	public static void main(String[] args) {
		
		DictionaryCommandLine commandLine = new DictionaryCommandLine();
		commandLine.dictionaryAdvanced();
		
		commandLine.dictionarySearcher();
		
	}
	
}
