package graphic;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


import module.DictionaryCommmandLine;
import module.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;


public class DictionaryApplication {
	
	
	public DictionaryCommmandLine admin;
	
	private JFrame home;
	private JTextField searchBox;
	private JTextField resultField;
	private JList<String> listWord;
	private JButton search;
	private JButton library;
	private JButton refresh;
	private JButton add, edit, delete;
	
	
	
	
	private void actionOfApp() {
		
		
		// Mỗi khi bạn nhập vô thanh search, cột "listword" sẽ liên tục hiện ra các từ liên quan đến từ bạn nhập
		// Có 2 cách để tìm kiếm: 1 là ấn Enter, 2 là click vô button Search
		
		searchBox.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				String para = searchBox.getText();
//				para = para.replace(para.charAt(0), Character.toUpperCase(para.charAt(0)));
				
				Vector<String> recommend = admin.dictionarySearcher(para);
				
				listWord.setListData(recommend);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
					String searchWord = searchBox.getText();
//					searchWord = searchWord.replace(searchWord.charAt(0), Character.toUpperCase(searchWord.charAt(0)));
					
					Word wordFind = admin.dictionaryLookUp(searchWord);
					resultField.setText(wordFind.getWord_explain());
				}
			}
		});
		
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String searchWord = searchBox.getText();
//				searchWord = searchWord.replace(searchWord.charAt(0), Character.toUpperCase(searchWord.charAt(0)));
				
				Word wordFind = admin.dictionaryLookUp(searchWord);
				resultField.setText(wordFind.getWord_explain());
			}
		});
		
		
		
		// listWord ô text bên trái
		
		listWord.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if ( listWord.getSelectedIndex() !=-1 ) {
					String word_target = listWord.getSelectedValue();
					Word wordFind = admin.dictionaryLookUp(word_target);
					resultField.setText(wordFind.getWord_explain());
				}
			}
		});
		
		
		// Click vào "library" để hiện thị các từ trong thư viện
		
		library.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> result = admin.getAllWordTarget();
				listWord.setListData(result);
			}
		});
		
		
		
		//Click vô "refresh" để Reset lại các hoạt động của bạn
		
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				listWord.setListData(new Vector<>());
				searchBox.setText(null);
				resultField.setText(null);
			}
		});
		
		
		
		//Click vô "Add" để thêm một từ mới vào thư viện
		
		DictionaryApplication app = this;
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				new FrameAddWord(app);
			}
		});
		
		
		
		//Click vô "Edit" sửa từ mà bạn chọn trong thư viện, nếu bạn chưa chọn từ nào sẽ có thông báo lên màn hình
		
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( listWord.getSelectedIndex()!=-1 ) {
					new FrameEditWord(admin, listWord.getSelectedValue());
				}
				else {
					new Alert();
				}
			}
		});
		
		
		// Hiện ra thư viện và bạn chọn từ cần xóa
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FrameDeleteWord(admin);
			}
		});
	}
	
	
	
	
	//Hàm khởi tạo
	
	public DictionaryApplication() {
		
		admin = new DictionaryCommmandLine();
		
		home = new JFrame();
		home.getContentPane().setBackground(new Color(25, 25, 112));
		home.setBounds(300, 50, 520, 600);
		home.setTitle("Dictionary");
		home.getContentPane().setLayout(null);
		
		
		// Thanh tìm kiếm
		
		searchBox = new JTextField();
		searchBox.setBackground(SystemColor.inactiveCaptionBorder);
		searchBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchBox.setForeground(new Color(25, 25, 112));
		searchBox.setSize(180, 30);
		searchBox.setBorder(null);
		searchBox.setBorder(BorderFactory.createCompoundBorder(searchBox.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		searchBox.setLocation(20,  20);
		
		
		
		// Hộp text hiển thị kết quả
		
		resultField = new JTextField();
		resultField.setBackground(SystemColor.inactiveCaptionBorder);
		resultField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultField.setForeground(new Color(25, 25, 112));
		resultField.setEditable(false);
		resultField.setSize(270, 400);
		resultField.setBorder(null);
		resultField.setBorder(BorderFactory.createCompoundBorder(resultField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		resultField.setLocation(210, 70);
		
		
		
		
		// Hộp text hiển thị danh sách các từ như các từ gợi ý, các từ trong thư viện
		
		JScrollPane scrollListWords = new JScrollPane();
		scrollListWords.setBounds(20, 70, 170, 400);
		scrollListWords.setBorder(null);
		
		listWord = new JList<String>();
		listWord.setBackground(SystemColor.inactiveCaptionBorder);
		listWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listWord.setForeground(new Color(25, 25, 112));
		listWord.setFixedCellHeight(40);
		listWord.setBorder(null);
		listWord.setBorder(BorderFactory.createCompoundBorder(listWord.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		scrollListWords.setViewportView(listWord);
	
		
		
		// Danh sách các button library, refresh, search, add, edit, delete
		
		library = new JButton("Library");
		library.setForeground(new Color(255, 255, 255));
		library.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		library.setSize(53,30);
		library.setBorder(null);
		library.setBackground(null);
		library.setLocation(364, 20);
		
		
		refresh = new JButton("Refresh");
		refresh.setForeground(SystemColor.window);
		refresh.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		refresh.setForeground(new Color(255, 255, 255));
		refresh.setBounds(430, 20, 53, 30);
		refresh.setBorder(null);
		refresh.setBackground(null);
		
		
		search = new JButton("Search");
		search.setForeground(new Color(0, 0, 139));
		search.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		search.setBounds(200, 20, 50, 30);
		search.setBorder(null);
		search.setBackground(new Color(240, 255, 255));
		
		
		add = new JButton("Add");
		add.setForeground(SystemColor.text);
		add.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		add.setBackground(null);
		add.setBorder(null);
		add.setBounds(20, 503, 36, 23);
		
		edit = new JButton("Edit");
		edit.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		edit.setForeground(SystemColor.text);
		edit.setBackground(null);
		edit.setBorder(null);
		edit.setBounds(63, 503, 36, 23);
		
		delete = new JButton("Delete");
		delete.setForeground(SystemColor.text);
		delete.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		delete.setBackground(null);
		delete.setBorder(null);
		delete.setBounds(103, 503, 53, 23);
		
		
		
		// Add tất cả các elements trên vào giao diện home
		
		home.getContentPane().add(searchBox);
		home.getContentPane().add(resultField);
		home.getContentPane().add(scrollListWords);
		home.getContentPane().add(library);
		home.getContentPane().add(refresh);
		home.getContentPane().add(search);
		home.getContentPane().add(add);
		home.getContentPane().add(edit);
		home.getContentPane().add(delete);
		
		home.setVisible(true);
		
		this.actionOfApp();
	}
	
	
}

