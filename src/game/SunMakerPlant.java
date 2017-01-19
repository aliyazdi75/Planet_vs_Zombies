/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author kasra
 */
public class SunMakerPlant extends Plant{

    long startTime;

    public SunMakerPlant (int[] arr) {

        super(arr);
        ii = new ImageIcon("SunFlower.gif");
        image = ii.getImage();
        ii = new ImageIcon("Sunflower.png");
        preViewImage = ii.getImage();
        startTime = System.currentTimeMillis();
        makeRectangle();

    }

    private void makeRectangle () {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update (Row row) {

        if ( (System.currentTimeMillis() - startTime) / 1000 > 7 ) {
            row.sky.addASun(new Sun(locX, locY));
            startTime = System.currentTimeMillis();
        }

    }

}
