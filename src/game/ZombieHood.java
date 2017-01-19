package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class ZombieHood extends Zombie{

    public ZombieHood (int arr[]) {

        super(arr);
        health = 10;
        ImageIcon ii = new ImageIcon("Conehead_Zombie.gif");
        image = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle () {

        rectangle = new Rectangle(locX + 25, locY + 28, 50, 200);

    }

    public void move() {
        locX -= speed;
        makeRectangle();
    }

}
