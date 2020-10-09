package graphic;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import module.Word;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FrameAddWord {
	

	private JFrame addWord;
	private JTextField enterWordTarget;
	private JTextField enterWordExplain;
	private JButton submit;
	
	private Word newWord;
	
	
	private void action(DictionaryApplication app) {
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if ( enterWordTarget.getText()!="" || enterWordExplain.getText()!="" ) {
					app.admin.getManagement().writeToData(enterWordTarget.getText(), enterWordExplain.getText());
				}
				addWord.setVisible(false);
			}
		});
	}
	
	public FrameAddWord(DictionaryApplication app) {
		
		addWord = new JFrame();
		addWord.getContentPane().setBackground(SystemColor.activeCaption);
		addWord.setTitle("Add word to Dictionary");
		addWord.setBounds(350, 100, 346, 232);
		addWord.getContentPane().setLayout(null);
		
		
		
		
		JLabel wordTarget = new JLabel("Word target    :");
		wordTarget.setForeground(SystemColor.controlLtHighlight);
		wordTarget.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		wordTarget.setBounds(14, 29, 144, 30);
		addWord.getContentPane().add(wordTarget);
		
		JLabel wordExplain = new JLabel("Word explain :");
		wordExplain.setForeground(SystemColor.controlLtHighlight);
		wordExplain.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		wordExplain.setBounds(14, 90, 144, 30);
		addWord.getContentPane().add(wordExplain);
		
		
		
		
		
		enterWordTarget = new JTextField();
		enterWordTarget.setForeground(new Color(25, 25, 112));
		enterWordTarget.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterWordTarget.setBounds(125, 28, 155, 35);
		enterWordTarget.setBorder(null);
		enterWordTarget.setBorder(BorderFactory.createCompoundBorder(enterWordTarget.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		addWord.getContentPane().add(enterWordTarget);
		enterWordTarget.setColumns(10);
		
		enterWordExplain = new JTextField();
		enterWordExplain.setForeground(new Color(25, 25, 112));
		enterWordExplain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterWordExplain.setBounds(126, 87, 155, 35);
		enterWordExplain.setBorder(null);
		enterWordExplain.setBorder(BorderFactory.createCompoundBorder(enterWordExplain.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		addWord.getContentPane().add(enterWordExplain);
		enterWordExplain.setColumns(10);
		
		
		
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		submit.setForeground(new Color(25, 25, 112));
		submit.setBounds(125, 141, 89, 35);
		submit.setBorder(null);
		addWord.getContentPane().add(submit);
		
		
		
		
		
		addWord.setVisible(true);
		
		this.action(app);
	}
}
