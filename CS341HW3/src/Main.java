import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField Itemtxt;
	private JTextField Costtxt;
	private JTextField Quantitytxt;
	private JTextField saletextarea;
	private JButton btnNewButton;
	private SalesSlip salesList;
	private JTextArea textarea;

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
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(163, 0, 93, 34);
		frame.getContentPane().add(lblNewLabel);
		
		Itemtxt = new JTextField();
		Itemtxt.setBounds(133, 27, 205, 28);
		frame.getContentPane().add(Itemtxt);
		Itemtxt.setColumns(10);
		
		Costtxt = new JTextField();
		Costtxt.setBounds(133, 66, 205, 28);
		frame.getContentPane().add(Costtxt);
		Costtxt.setColumns(10);
		
		Quantitytxt = new JTextField();
		Quantitytxt.setBounds(133, 105, 205, 28);
		frame.getContentPane().add(Quantitytxt);
		Quantitytxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(59, 25, 64, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost:  $");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(59, 64, 64, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(59, 103, 64, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add items of sale list");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(133, 144, 169, 28);
		frame.getContentPane().add(btnNewButton);
		
		saletextarea = new JTextField();
		saletextarea.setBounds(207, 240, 114, 20);
		frame.getContentPane().add(saletextarea);
		saletextarea.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(124, 240, 73, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(124, 183, 214, 46);
		frame.getContentPane().add(textArea);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printarray();
			}
		});
	}
	public void printarray() {
		String itemName=Itemtxt.getText();
		double itemPrice=Double.parseDouble(Costtxt.getText());
		int itemquantity=Integer.parseInt(Quantitytxt.getText());
		SalesItem x=new SalesItem(itemName,itemquantity,itemPrice);
		salesList.additem(x);
		textarea.setText(salesList.toString());
		saletextarea.setText(salesList.totalcost());
	}
}
