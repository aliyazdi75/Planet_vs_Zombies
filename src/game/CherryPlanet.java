package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class CherryPlanet extends Plant {

    Rectangle[][] rectsOfHouses;
    long startTime;
    int[] rectLoc;
    boolean isExploded = false;

    public CherryPlanet(int arr[], Rectangle[][] rectsOfHouses, int[] rectangleLoc) {

        super(arr);
        startTime = System.currentTimeMillis();
        this.rectsOfHouses = rectsOfHouses;
        this.rectLoc = rectangleLoc;
        ii = new ImageIcon("PvZ_Pictures.png");
        image = ii.getImage();
        ii = new ImageIcon("PvZ_Pictures.png");
        preViewImage = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update(Row[] arrOfRows) throws InterruptedException {

        if ((System.currentTimeMillis() - startTime) / 1000 > 2) {
            this.explod(arrOfRows);
        }

    }

    /**
     * burns all the zombies in 9 houses around cherryPlanet
     *
     * @param arrOfRows
     */
    private void explod(Row[] arrOfRows) {

        for (int j = rectLoc[0] + 1; j > rectLoc[0] - 2; j--) {
            for (int k = rectLoc[1] + 1; k > rectLoc[1] - 2; k--) {

                try {

                    for (int i = 0; i < arrOfRows[j].zombies.size(); i++) {

                        try {
                            Zombie zombie = arrOfRows[j].zombies.get(i);
                            if (rectsOfHouses[j][k].intersects(zombie.getRectangle())) {
                                zombie.zombieIsBurned();
                            }
                        } catch (Exception e) {
                        }

                    }

                } catch (Exception e) {
                }

            }
        }
        Sound.playSound("explosion.wav");
        isExploded = true;

    }

}
