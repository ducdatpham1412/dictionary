package graphic;

import javax.swing.JFrame;

import module.DictionaryCommmandLine;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class FrameApi {

	JFrame frame;
	private JTextField searchBox;
	private JButton search;
	private JTextField result;
	
	public FrameApi(DictionaryCommmandLine admin) {
		
		this.intinaze();
		this.action(admin);
	}
	
	
	private void intinaze() {
		frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(350, 100, 331, 248);
		frame.getContentPane().setLayout(null);
		
		search = new JButton("Search");
		search.setBackground(SystemColor.inactiveCaptionBorder);
		search.setForeground(new Color(25, 25, 112));
		search.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		search.setBounds(35, 28, 66, 30);
		search.setBorder(null);
		
		searchBox = new JTextField();
		searchBox.setForeground(new Color(25, 25, 112));
		searchBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchBox.setBackground(SystemColor.inactiveCaptionBorder);
		searchBox.setBounds(102, 28, 176, 30);
		searchBox.setBorder(null);
		searchBox.setBorder(BorderFactory.createCompoundBorder(searchBox.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
		searchBox.setColumns(10);
		
		result = new JTextField();
		result.setForeground(new Color(25, 25, 112));
		result.setFont(new Font("Tahoma", Font.PLAIN, 12));
		result.setBounds(35, 69, 243, 117);
		result.setColumns(10);
		result.setBorder(null);
		result.setBorder(BorderFactory.createCompoundBorder(result.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
		result.setEditable(false);
		
		
		frame.getContentPane().add(searchBox);
		frame.getContentPane().add(search);
		frame.getContentPane().add(result);
		
		frame.setVisible(true);
	}
	
	
	private void action(DictionaryCommmandLine admin) {
		
		searchBox.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if ( e.getKeyCode()==KeyEvent.VK_ENTER ) {
					
//					String result = admin.getManagement().wordApi(searchBox.getText());
					String alert = "Do em chưa có MasterCard nên chưa kết nối được đến sever";
					result.setText(alert);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String result = admin.getManagement().wordApi(searchBox.getText());
				String alert = "Do em chưa có MasterCard nên chưa kết nối được đến sever";
				result.setText(alert);
			}
		});
	}
	
}
