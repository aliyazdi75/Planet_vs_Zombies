package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 02/07/2016.
 */
public class FieryPepper extends Plant {

    Rectangle[][] rectsOfHouses;
    long startTime;
    int[] rectLoc;
    boolean isExploded = false;

    public FieryPepper(int arr[]) {

        super(arr);
        startTime = System.currentTimeMillis();
        ii = new ImageIcon("Jalapeno.png");
        image = ii.getImage();
        ii = new ImageIcon("Jalapeno.png");
        preViewImage = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update(Row row) throws InterruptedException {

        if ((System.currentTimeMillis() - startTime) / 1000 > 1) {
            this.explod(row);
        }

    }

    /**
     * burns all the zombies in 9 houses around cherryPlanet
     *
     * @param row
     */
    private void explod(Row row) {

        for (int i = 0; i < row.zombies.size(); i++) {
            row.zombies.get(i).zombieIsBurned();
        }
        Sound.playSound("explosion.wav");
        isExploded = true;

    }

}
