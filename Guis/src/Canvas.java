import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Canvas extends JComponent{

	public static void main(String[] args) {
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		
		JFrame frame = new JFrame();
		
		JComponent jc = new Canvas();
		frame.add(jc);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Canvas");
		frame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(80, 200, 50, 100);
		g.setColor(Color.WHITE);
		g.fillRect(130, 200, 50, 100);
		g.setColor(Color.RED);
		g.fillRect(180, 200, 50, 100);
		super.paintComponent(g);
	}

}
