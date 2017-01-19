package game;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class WalnutPlant extends Plant {

    public WalnutPlant(int arr[]) {

        super(arr);

        ii = new ImageIcon("walnut_full_life.gif");
        image = ii.getImage();
        ii = new ImageIcon("WallNut.png");
        preViewImage = ii.getImage();
        makeRectangle();
        health = 10;

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update (Row row) throws InterruptedException {

    }

}
