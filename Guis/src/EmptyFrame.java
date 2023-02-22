import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmptyFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Hi Aidan");
		JButton button2 = new JButton("Hi Evan");
		Dimension dim = new Dimension(498, 353);
		Color funny = new Color(160, 160, 255);
		frame.setSize(dim);
		panel.setBackground(funny);
		
		try {
		    File pathToFile = new File("pizza.gif");
		    Image image = ImageIO.read(pathToFile);
		    JLabel picLabel = new JLabel(new ImageIcon(image));
		    panel.add(picLabel);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello Evan");
			}
		});
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello Aidan");
			}
		});
		
		panel.add(button);
		panel.add(button2);
		
		JLabel text = new JLabel("Its Pizza Time");
		panel.add(text);
		panel.setVisible(true);
		frame.add(panel);
		frame.setTitle("ITS PIZZA TIME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
