import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private JTextField SKUTEXT;
	private JTextField TITLETEXT;
	private JTextField PRICETEXT;
	private JTextField QUANTITYTEXT;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SKU number");
		lblNewLabel.setBounds(25, 29, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		
		SKUTEXT = new JTextField();
		SKUTEXT.setBounds(6, 54, 84, 19);
		frame.getContentPane().add(SKUTEXT);
		SKUTEXT.setColumns(10);
		
		TITLETEXT = new JTextField();
		TITLETEXT.setBounds(100, 53, 96, 20);
		frame.getContentPane().add(TITLETEXT);
		TITLETEXT.setColumns(10);
		
		PRICETEXT = new JTextField();
		PRICETEXT.setBounds(213, 53, 96, 20);
		frame.getContentPane().add(PRICETEXT);
		PRICETEXT.setColumns(10);
		
		QUANTITYTEXT = new JTextField();
		QUANTITYTEXT.setBounds(319, 53, 96, 20);
		frame.getContentPane().add(QUANTITYTEXT);
		QUANTITYTEXT.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(119, 29, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price(no $ sign)");
		lblNewLabel_2.setBounds(213, 29, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(342, 29, 49, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add textbook");
		btnNewButton.setBounds(165, 84, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddtoInventory(Integer.parseInt(SKUTEXT.getText()),TITLETEXT.getText(),Double.parseDouble(PRICETEXT.getText()),Integer.parseInt(QUANTITYTEXT.getText()));
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("SKU number for removal");
		lblNewLabel_4.setBounds(260, 118, 131, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Remove textbook");
		btnNewButton_1.setBounds(240, 163, 131, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemovefromInventory(Integer.parseInt(SKUTEXT.getText()));
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setBounds(262, 139, 96, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SKU number for display");
		lblNewLabel_5.setBounds(25, 118, 124, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(35, 139, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Display info for textbook");
		btnNewButton_2.setBounds(6, 163, 162, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showtext(Integer.parseInt(SKUTEXT.getText()));
			}
		});
		
		JButton btnNewButton_3 = new JButton("Display Inventory");
		btnNewButton_3.setBounds(150, 213, 119, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showinventory();
			}
		});
	}

}
