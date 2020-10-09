package module;

import java.util.Vector;

public class DictionaryCommmandLine {

	
	// Mỗi đối tượng CommmandLine sẽ có một trợ lý duy nhất chính là Management, ngay khi khởi tạo nó sẽ gọi management
	// để import từ file vào trong dữ liệu
	
	private DictionaryManagement management = new DictionaryManagement();
	
	public DictionaryCommmandLine() {
		this.management.insertFromFile();
	}
	
	public DictionaryManagement getManagement() {
		return this.management;
	}
	
	
	
	
	// Trả về một String là biểu diễn của dữ liệu theo form
	// Tuy nhiên hàm này trong đồ họa không dùng đến
	
	public String showAllWord() {
		
		String result = String.format("%-6s %s %-20s %s %s\n\n", "No", "|", "English" ,"|", "Vietnamese");
		
		Dictionary dic = management.getDictionary();
		
		for (int i=0; i<dic.getSize(); i++) {
			Word tempt = dic.getWord(i);
			String bonus = String.format("%-6d %s %-20s %s %s\n", i+1, "|", tempt.getWord_target(), "|", tempt.getWord_explain());
			result += bonus;
		}
		
		return result;
	}
	
	
	
	
	// Trả về một Vector là tất cả các từ Target trong dữ liệu, hàm này để phục vụ khi ấn "Library"
	
	public Vector<String> getAllWordTarget() {
		
		Vector<String> result = new Vector<>();
		
		Dictionary dic = management.getDictionary();
		
		for (int i=0; i<dic.getSize(); i++) {
			Word tempt = dic.getWord(i);
			String bonus = tempt.getWord_target();
			result.add(bonus);
		}
		
		return result;
	}
	
	
	
	
	
	// Trả về tất cả các từ Target có liên quan đến ký tự nhập vào trên thanh Search
	// Nhận tham số "para" liên tục từ thanh search mỗi khi có thay đổi để liên tục đưa ra Recommend hợp lý
	
	public Vector<String> dictionarySearcher(String para) {
		
		Vector<String> result = new Vector<>();
		
		Dictionary dic = management.getDictionary();
		
		if ( para!="" ) {
			for (int i=0; i<dic.getSize(); i++) {
				
				String mom = dic.getWord(i).getWord_target().toLowerCase();
				String child = para.toLowerCase();
				
				int k = mom.indexOf(child);
				if ( k==0 || k==1 ) {
					result.add( dic.getWord(i).getWord_target() );
				}
			}
		}
		
		return result;
	}
	
	
	
	// Trả về Một bộ từ Target và Explain có ứng với từ word_target cần tìm
	// Trả về null nếu không tìm thấy trong dữ liệu
	
	public Word dictionaryLookUp(String word_target) {
		
		Dictionary dic = management.getDictionary();
		
		Word result = null;
		
		int index = dic.indexOfWordTarget(word_target);
		
		if (index==-1) return result;
		
		result = dic.getWord(index);
		
		return result;
	}
	
	
}
