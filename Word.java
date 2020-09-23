package dictionary;

public class Word {

	private String word_target;
	private String word_explain;
	
	
	//Constructor
	public Word() {
		word_target = "";
		word_explain="";
	}
	
	public Word(String word_target, String word_explain) {
		this.word_target = word_target;
		this.word_explain = word_explain;
	}
	
	
	//Ham setter
	public void setWord_target(String word) {
		this.word_target = word;
	}
	public void setWord_explain(String word) {
		this.word_explain = word;
	}
	
	
	//Ham getter
	public String getWord_target() {
		return this.word_target;
	}
	public String getWord_explain() {
		return this.word_explain;
	}
	
	
}
