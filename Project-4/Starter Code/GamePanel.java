import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies,
 * turret, and missile. It also keeps track of the 
 * 
 * @author Dr. Garrett Goodman
 */
public class GamePanel extends JPanel {

	/**
	 * Paints the enemies and missiles when called and also paints
	 * the background of the panel White.
	 */
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.white); 
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
	} 

	/**
	 * Method detects the collision of the missile and all the enemies. This is done by
	 * drawing invisible rectangles around the enemies and missiles, if they intersect, then 
	 * they collide.
	 */
	public void detectCollision() {
		// Create temporary rectangles for every enemy and missile on the screen currently       
		for(int i = 0; i < enemyList.size(); i++) {
			Rectangle enemyRec = enemyList.get(i).getBounds();
			for(int j = 0; j < missileList.size(); j++) {
				Rectangle missileRec = missileList.get(j).getBounds();
				if(missileRec.intersects(enemyRec)) {
					(enemyList.get(i)).processCollision(enemyList, i);
					missileList.remove(j); 
					if(enemyList.get(i) instanceof BigEnemy) {
						totalScore += 100;
					} else {
						totalScore += 150;
					}
				}
			}
		}
	}

}
