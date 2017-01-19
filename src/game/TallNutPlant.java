package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 02/07/2016.
 */
public class TallNutPlant extends Plant {

    public TallNutPlant(int arr[]) {

        super(arr);

        ii = new ImageIcon("Tall-nut.png");
        image = ii.getImage();
        ii = new ImageIcon("Tall-nut.png");
        preViewImage = ii.getImage();
        makeRectangle();
        health = 15;

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update (Row row) throws InterruptedException {

    }

}
