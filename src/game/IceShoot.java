package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class IceShoot  extends Shot {

    public IceShoot (int locX, int locY) {

        super(locX, locY);
        ImageIcon ii = new ImageIcon("p3.png");
        image = ii.getImage();
        makeRectangle();

    }
    /**
     *
     * @return
     */
    @Override
    public Image getShotImage () {
        return image;
    }

    private void makeRectangle () {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, width, height);

    }

    public void move() {
        locX += speed;
        makeRectangle();
    }

}
