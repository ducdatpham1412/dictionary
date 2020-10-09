package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

import javax.sql.RowSetInternal;
import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.JButton;

public class Alert {

	private JFrame frame;
	private JTextField txtYouHaveTo;

	
	public Alert() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(350, 100, 284, 151);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrChooseOneWord = new JTextArea();
		txtrChooseOneWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrChooseOneWord.setForeground(new Color(255, 255, 255));
		txtrChooseOneWord.setBackground(null);
		txtrChooseOneWord.setText("Choose one word in library\r\n        before editing");
		txtrChooseOneWord.setBounds(46, 11, 173, 43);
		txtrChooseOneWord.setEditable(false);
		frame.getContentPane().add(txtrChooseOneWord);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setBounds(95, 65, 66, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		frame.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
	}
}
