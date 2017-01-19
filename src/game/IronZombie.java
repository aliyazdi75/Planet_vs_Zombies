package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 02/07/2016.
 */
public class IronZombie  extends Zombie{

    public IronZombie (int arr[]) {

        super(arr);
        health = 15;
        ImageIcon ii = new ImageIcon("Buckethead_Zombie.png");
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
