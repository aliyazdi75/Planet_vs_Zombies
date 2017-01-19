
package game;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author kasra
 */
public class SimpleZombie extends Zombie{
    
    public SimpleZombie (int arr[]) {
	
	super(arr);
	health = 8;
	ImageIcon ii = new ImageIcon("zombie_normal.gif");
	image = ii.getImage();
	makeRectangle();
	
    }
    /**
     *
     * @return
     */
    public Image getZombieImage () {
	return image;
    }
    
    private void makeRectangle () {

        rectangle = new Rectangle(locX + 25, locY + 28, 50, 200);
	
    }
    
    public void move() {
	locX -= speed;
	makeRectangle();
    }
    
}
