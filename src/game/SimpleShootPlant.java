
package game;

import javax.swing.*;
import java.awt.*;

/**
 * @author kasra
 */
public class SimpleShootPlant extends Plant {

    public SimpleShootPlant(int arr[]) {

        super(arr);
        shootingRate = 10;
        ii = new ImageIcon("PeaShooter.gif");
        image = ii.getImage();
        ii = new ImageIcon("PeaShooter.png");
        preViewImage = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    @Override
    public void update(Row row) throws InterruptedException {

        super.update(row);
        if (row.zombieIsInRow) {
            shotCounter += 1;
            if (shotCounter == 7 * shootingRate) {

                shots.add(new SimpleShot(locX, locY));
                shotCounter = 0;

            }
        }

    }

}
