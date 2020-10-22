package graphic;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import module.DictionaryCommmandLine;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FrameEditWord {
	
	
	private JFrame frame;
	private JTextField editTarget;
	private JTextField editExplain;
	private JButton done;
	
	
	
	public FrameEditWord(DictionaryCommmandLine admin, String word_target) {
		
		this.intinalize(admin, word_target);
	}
	
	
	
	private void action(int index, DictionaryCommmandLine admin) {
		
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String word_target = editTarget.getText();
				String word_explain = editExplain.getText();
				
				admin.getManagement().editWord(index, word_target, word_explain);
				admin.getManagement().writeToDataAfterEdit();
				
				frame.setVisible(false);
			}
		});
	}
	
	
	
	
	private void intinalize(DictionaryCommmandLine admin, String word_target) {
		
		frame = new JFrame();
		frame.setBounds(350, 100, 349, 248);
		frame.setTitle("Edit Word");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		
		
		
		JLabel title = new JLabel("Edit word in two boxes");
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(60, 11, 220, 32);
		frame.getContentPane().add(title);
		
		
		
		
		
		JLabel jlbTarget = new JLabel("Word target :");
		jlbTarget.setForeground(new Color(255, 255, 255));
		jlbTarget.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbTarget.setBounds(20, 54, 107, 32);
		frame.getContentPane().add(jlbTarget);
		
		JLabel JlbExplain = new JLabel("Word exlain  :");
		JlbExplain.setForeground(new Color(255, 255, 255));
		JlbExplain.setFont(new Font("Tahoma", Font.BOLD, 14));
		JlbExplain.setBounds(20, 101, 107, 32);
		frame.getContentPane().add(JlbExplain);
		
		
		
		
		
		
		editTarget = new JTextField();
		editTarget.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editTarget.setForeground(new Color(25, 25, 112));
		editTarget.setBounds(137, 54, 165, 35);
		editTarget.setColumns(10);
		editTarget.setBorder(null);
		editTarget.setBorder(BorderFactory.createCompoundBorder(editTarget.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		frame.getContentPane().add(editTarget);
		
		
		editExplain = new JTextField();
		editExplain.setForeground(new Color(25, 25, 112));
		editExplain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editExplain.setBounds(137, 100, 165, 35);
		editExplain.setBorder(null);
		editExplain.setBorder(BorderFactory.createCompoundBorder(editExplain.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		frame.getContentPane().add(editExplain);
		
		
		int index = admin.getManagement().getDictionary().indexOfWordTarget(word_target);
		
		String word_explain = admin.getManagement().getDictionary().getWord(index).getWord_explain();
		
		editTarget.setText(word_target);
		editExplain.setText(word_explain);
		
		
				
		
		done = new JButton("Done\r\n");
		done.setForeground(new Color(25, 25, 112));
		done.setFont(new Font("Tahoma", Font.BOLD, 14));
		done.setBounds(137, 157, 89, 32);
		frame.getContentPane().add(done);
		
		
		
		
		frame.setVisible(true);
		
		this.action(index, admin);
	}
}