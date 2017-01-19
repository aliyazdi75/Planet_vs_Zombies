package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 01/07/2016.
 */
public class CatapultShoot extends Shot {

    int t, tTotal;
    boolean firstShoot = true, beforeH = true;
    int diffrence;
    int lastPlanetLocx;

    public CatapultShoot(int locX, int locY, int kind, int lastPlanetx) {

        super(locX, locY, kind);
        ImageIcon ii = new ImageIcon("p4.png");
        image = ii.getImage();
        makeRectangle();
        lastPlanetLocx = lastPlanetx;

    }

    /**
     * @return
     */
    @Override
    public Image getShotImage() {
        return image;
    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, width, height);

    }

    public void move() {
        if (firstShoot) {
            diffrence = locX - lastPlanetLocx;
            firstShoot = false;
        }
        if (locX >= (lastPlanetLocx + diffrence / 2)) {
            t++;
            locX -= speed * t / 30;
            locY -= speed * t / 60 - 5 * t * t / 2000;
        } else {
            locX -= speed * t / 30;
            locY += speed * t / 60 - 5 * t * t / 2000;
            t--;
        }
        makeRectangle();
    }

}
