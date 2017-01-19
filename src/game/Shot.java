
package game;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * this is the sub class for all kind of shots
 *
 * @author kasra
 */
public class Shot {

    protected int locX, locY, height, width;
    protected int speed = 12;
    protected Rectangle rectangle;
    protected Image image;

    public Shot(int locX, int locY) {

        this.locX = locX + 80;
        this.locY = locY + 15;

    }
    /**
     * 
     * second constructor used by catapult zombie
     * 
     * @param locX
     * @param locY
     * @param kind 
     */
    public Shot(int locX, int locY,int kind) {

        this.locX = locX + 80;
        this.locY = locY + 110;

    }

    private void makeRectangle() {

    }

    public Image getShotImage() {
        return image;
    }

    public void move() {
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
