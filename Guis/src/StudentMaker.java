import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class StudentMaker extends JFrame{

	private final int FRAME_WIDTH = 300;
	private final int FRAME_HEIGHT = 400;
	private JPanel panel;
	private JButton readStudents;
	private JButton calculateGrades;
	private JButton printToString;
	private JTextField bonusGrade;
	private JLabel bonusLabel;
	private JTextArea historyText;
	
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentMaker() {
		constructDisplay();
	}
	
	public void constructDisplay() {
		
		Container container = getContentPane(); // dont need to add container it is auto added
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.setBorder(new TitledBorder("Calculate Student Grades"));

		readStudents = new JButton("Read Students");
		readStudents.addActionListener(new StudentButtonListener());
		bonusLabel = new JLabel("Enter Grade Bonus");
		
		bonusGrade = new JTextField(5);
		
		calculateGrades = new JButton("Calculate Grades");
		calculateGrades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = bonusGrade.getText();
				double bonus = Double.parseDouble(text);
				
				for(Student s : students) {
					historyText.append(s.getName() + " Grade: " + s.calcFinalGrade() + " Final Grade: " + s.calcFinalGrade(bonus) + "\n");
				}
			}
			
		});
		
		printToString = new JButton("Print to String");
		printToString.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Student s : students) {
					historyText.append(s.toString() + "\n");
				}
			}
			
		});
		
		JPanel rowOne = new JPanel();
		rowOne.setLayout(new GridLayout(1,2));
		rowOne.add(bonusLabel, 0);
		rowOne.add(bonusGrade, 1);
		panel.add(rowOne, 0);
		panel.add(calculateGrades, 1);
		
		JPanel otherButtons = new JPanel();
		otherButtons.setBorder(new TitledBorder("The Remaining Buttons"));
		otherButtons.add(readStudents);
		otherButtons.add(printToString);
		
		JPanel displayOutput = new JPanel();
		displayOutput.setBorder(new TitledBorder("Output of Program"));
		displayOutput.add(new JLabel("Area to display information"));
		
		historyText = new JTextArea(10,20);
		/*
		panel.add(bonusLabel);
		panel.add(bonusGrade);
		panel.add(readStudents);
		panel.add(calculateGrades);
		panel.add(printToString);
		*/
		
	
		
		//panel.add(new JLabel("Display Information"));
		JScrollPane pane = new JScrollPane(historyText);
		displayOutput.add(pane);
		
		container.setLayout(new BorderLayout());
		container.add(otherButtons, BorderLayout.NORTH);
		container.add(panel, BorderLayout.CENTER);
		container.add(displayOutput, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new MenuActionListener());
		fileMenu.add(exitItem);
		
		JMenuItem tempItemTwo = new JMenuItem("Temp");
		tempItemTwo.addActionListener(new MenuActionListener());
		helpMenu.add(tempItemTwo);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Calculator");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String item = e.getActionCommand();
			if(item.equals("Exit")) {
				System.out.println("Exit Called");
				System.exit(0);
			}else if(item.equals("Temp")) {
				System.out.println("Temp Called");
			}
		}
		
	}
	
	class StudentButtonListener implements ActionListener{

		private Scanner in = null;
		private boolean hasRead = false;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(hasRead == false) {
				
				try {
					in = new Scanner(new File("StudentGrades.txt"));
					
					while(in.hasNextLine()) {
						String temp = in.nextLine();
						students.add(new Student(temp));
					}
					hasRead = true;
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}else {
				historyText.append("Already read From the file. \n");
			}
		}
		
	}
	
}
