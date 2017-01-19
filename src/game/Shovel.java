package game;

import javax.swing.*;

/**
 * Created by Ali Yazdi on 01/07/2016.
 */
public class Shovel extends Plant {

    public Shovel(int arr[]) {

        super(arr);
        health=0;
        ii = new ImageIcon("shovel.png");
        image = ii.getImage();
        ii = new ImageIcon("shovel.png");
        preViewImage = ii.getImage();


    }

    public void update(Row row) throws InterruptedException {

        for (int i = row.planets.length - 1; i >= 0; i--) {
            Plant planet = row.planets[i];
            if (planet.getRectangle().intersects(this.rectangle)) {
                row.planets[i] = null;
            }
        }
    }

}
