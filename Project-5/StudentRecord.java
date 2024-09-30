import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
/**
 * This class creates and contains all methods to run a GUI to read and search through an arraylist of student objects
 * @author will1310
 *
 */
public class StudentRecord extends JFrame {
	private JTextField idLookup;
	private ArrayList<Student> studentArray = new ArrayList<Student>();
	private Student temp = new Student();
	private Student[] list = null;
	private JTextArea allStudentInfo = new JTextArea();
	private JTextArea studentInfo = new JTextArea();
	private String filePath = "MOCK_DATA.csv";
	
	/**
	 * Constructor for the GUI
	 */
	public StudentRecord() {
		constructDisplay();
	}
	
	/**
	 * Method to build the GUI
	 */
	public void constructDisplay() {
		Container container = getContentPane();
		
		setTitle("AddressBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 530);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(null, "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(controlPanel);

		JButton loadData = new JButton("Load Data");
		loadData.addActionListener(new ActionListener() {
			/**
			 * this method loads the data from the input file upon click of the button
			 */
			public void actionPerformed(ActionEvent e) {
				list = null;
				try {
					list = temp.readFromFile(filePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				for(int i = 0; i <list.length; i++) {
					studentArray.add(list[i]);
				}
				displayAllRecords();
			}
		});
		controlPanel.add(loadData);
		JButton sortRecords = new JButton("Sort Records");
		sortRecords.addActionListener(new ActionListener() {
			/**
			 * this method sorts the student records upon button click
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				temp.sort(list);
				displayAllRecords();
			}
		});
		controlPanel.add(sortRecords);
		JButton findStudent = new JButton("Find the Student by ID");
		findStudent.addActionListener(new ActionListener() {
			/**
			 * this method takes the input from the textField and searched for any matching results in id in the student arrayList
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				if(idLookup.getText().equals("") || Integer.parseInt(idLookup.getText()) <=0 || Integer.parseInt(idLookup.getText()) >=list.length+1) {
					studentInfo.setText("That is not an ID of a student, please enter another");
				}else {
					int searchId = Integer.parseInt(idLookup.getText());
					Student search = new Student(searchId, "","", 0);
					int index = temp.search(list, search);
					studentInfo.setText(list[index].toString() + ", Index = " + (index+1));
				}
			}
		});
		controlPanel.add(findStudent);
		idLookup = new JTextField();
		controlPanel.add(idLookup);
		idLookup.setColumns(10);
		JPanel singleStudent = new JPanel();
		singleStudent.setBorder(new TitledBorder(null, "Individual Student Record", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		getContentPane().add(singleStudent);
		studentInfo.setEditable(false);
		studentInfo.setColumns(50);
		singleStudent.add(studentInfo);
		JPanel allStudents = new JPanel();
		allStudents.setBorder(
				new TitledBorder(null, "All Student Records", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(allStudents);
		allStudentInfo.setEditable(false);
		allStudentInfo.setRows(20);
		allStudentInfo.setColumns(50);
		JScrollPane pane = new JScrollPane(allStudentInfo);
		allStudents.add(pane);
	}
	
	/**
	 * helper method to print all records to the text area containing all student records
	 */
	private void displayAllRecords() {
		allStudentInfo.setText("");
		for(int i = 0; i<list.length; i++) {
			allStudentInfo.append(list[i].toString() + "\n");
		}
	}

	/**
	 * Main method to test and display GUI
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new StudentRecord();
		frame.setVisible(true);
	}

}
