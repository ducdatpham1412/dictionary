package graphic;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import module.DictionaryCommmandLine;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FrameDeleteWord {
	
	private JFrame frame;
	private JList<String> listWords_;
	private JList<String> wordsToDelete_;
	private JButton delete;
	private JLabel lblListWord;
	private JLabel lblListDelete;
	
	private void action(DictionaryCommmandLine admin, Vector<String> words) {
		
		Vector<String> listDelete = new Vector<>();
		
		listWords_.addMouseListener(new MouseListener() {
			
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
				if ( listWords_.getSelectedIndex()!=-1 ) {
					
					listDelete.add(listWords_.getSelectedValue());
					words.remove(listWords_.getSelectedIndex());
					
					listWords_.setListData(words);
					wordsToDelete_.setListData(listDelete);
					
				}
			}
		});
		
		wordsToDelete_.addMouseListener(new MouseListener() {
			
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
				if ( wordsToDelete_.getSelectedIndex()!=-1 ) {
					words.add(wordsToDelete_.getSelectedValue());
					listDelete.remove(wordsToDelete_.getSelectedIndex());
					
					listWords_.setListData(words);
					wordsToDelete_.setListData(listDelete);
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.getManagement().deleteWord(listDelete);
				frame.setVisible(false);
			}
		});
	}
	

	public FrameDeleteWord(DictionaryCommmandLine admin) {
		
		Vector<String> words = admin.getAllWordTarget();
		
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setTitle("Delete Word");
		frame.setBounds(350, 100, 350, 488);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		
		
		
		
		
		
		JScrollPane listWords = new JScrollPane();
		listWords.setBounds(10, 52, 149, 327);
		frame.getContentPane().add(listWords);
		listWords.setBorder(null);
		
		listWords_ = new JList<String>();
		listWords_.setBackground(SystemColor.inactiveCaptionBorder);
		listWords_.setForeground(new Color(25, 25, 112));
		listWords_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listWords_.setFixedCellHeight(40);
		listWords_.setListData(words);
		listWords_.setBorder(BorderFactory.createCompoundBorder(listWords_.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		listWords.setViewportView(listWords_);
		
		
	
		
		
		JScrollPane wordsToDelete = new JScrollPane();
		wordsToDelete.setBounds(211, 52, 115, 327);
		frame.getContentPane().add(wordsToDelete);
		wordsToDelete.setBorder(null);
		
		wordsToDelete_ = new JList<String>();
		wordsToDelete_.setForeground(new Color(25, 25, 112));
		wordsToDelete_.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wordsToDelete_.setBackground(SystemColor.inactiveCaptionBorder);
		wordsToDelete_.setFixedCellHeight(40);
		wordsToDelete_.setBorder(BorderFactory.createCompoundBorder(wordsToDelete_.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		wordsToDelete.setViewportView(wordsToDelete_);
		
		
		
		
		
		delete = new JButton("Delete");
		delete.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		delete.setForeground(new Color(25, 25, 112));
		delete.setBounds(172, 400, 89, 31);
		delete.setBorder(null);
		frame.getContentPane().add(delete);
		
		
		
			
		
		lblListWord = new JLabel("Click to word need delete");
		lblListWord.setForeground(new Color(25, 25, 112));
		lblListWord.setBackground(SystemColor.inactiveCaptionBorder);
		lblListWord.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListWord.setBounds(10, 21, 171, 25);
		frame.getContentPane().add(lblListWord);
		
		lblListDelete = new JLabel("List Delete\r\n");
		lblListDelete.setForeground(new Color(25, 25, 112));
		lblListDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListDelete.setBackground(SystemColor.inactiveCaptionBorder);
		lblListDelete.setBounds(229, 20, 97, 25);
		frame.getContentPane().add(lblListDelete);
		
		
		
		
		frame.setVisible(true);
		
		this.action(admin, words);
	}
}
