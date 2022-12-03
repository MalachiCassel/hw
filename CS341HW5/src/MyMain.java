import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MyMain {

	private JFrame frame;
	private static JButton inputBtn;
    private static JButton outputBtn;
    private static JButton computeBtn;
    private static JFrame jframeWindow;
    private static JPanel panel;
    private static File fileToRead;
    private static File fileToSave;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyMain() {
		initialize();
		constructAppWindow();
		addListenerEvents();
	}
	
	private static void constructAppWindow() {
        jframeWindow = new JFrame();
        jframeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(3, 0));
        panel.setPreferredSize(new Dimension(500, 150));
        panel.setBackground(Color.DARK_GRAY);
        inputBtn = new JButton("Specify Input Text File");
        outputBtn = new JButton("Specify Output Text File");
        computeBtn = new JButton("Perform Work");
        panel.add(inputBtn);
        panel.add(outputBtn);
        panel.add(computeBtn);
        jframeWindow.add(panel);
        jframeWindow.pack();
        jframeWindow.setVisible(true);
    }
    
    private static void addListenerEvents() {
        inputBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                requestInputFile();
            }
        });
        outputBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                requestSaveFile();
            }
        });
        computeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeSomething();
            }
        });
        
    }

    public static void requestSaveFile() {
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }
    }

    public static void requestInputFile() {
    	Numbers num=new Numbers();
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            fileToRead = jfc.getSelectedFile();
            System.out.println(fileToRead.getAbsolutePath());
			try {
				Scanner myReader = new Scanner(fileToRead);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					String[]list=data.split(" ");
					for(int i=0; i<list.length; i++) {
						num.push(Integer.parseInt(list[i]));
					}
					System.out.println(num.Mean());
					System.out.println(num.stdev());
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
        }
    }
    
    public static void computeSomething() {
        System.out.println("now computing");
    }

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
