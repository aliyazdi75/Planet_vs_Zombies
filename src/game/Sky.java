
package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * this class manages all kind of suns
 * @author kasra
 */
public class Sky {

    protected ArrayList<Sun> suns;
    private long startTime;
    private Image sunImage;
    public Integer storedSun = 0;

    public Sky () {

        suns = new ArrayList<>();
        startTime = System.currentTimeMillis();
        ImageIcon ii = new ImageIcon("sun.png");
        sunImage = ii.getImage();

    }
    /**
     * this method moves the suns and checks their life and makes a sun every 10 seconds
     */
    public void update () {

        if ( (System.currentTimeMillis() - startTime) / 1000 > 10 ) {
            suns.add(new Sun());
            startTime = System.currentTimeMillis();
        }

        for (int i = 0; i < suns.size(); i++) {

            Sun get = suns.get(i);
            get.move();
            if (get.checkIfSunIsdead()) {
                suns.remove(get);
            }

        }

    }
    /**
     * gets a sun from a flower planet
     * @param sun
     */
    public void addASun (Sun sun) {
        suns.add(sun);
    }

    public Image getSunImage () {
        return sunImage;
    }
    /**
     * removes a sun if its selected and adds one to stored sun
     * @param rectangle
     */
    public void checkIfASunIsSelected (Rectangle rectangle) {

        for (int i = 0; i < suns.size(); i++) {

            Sun get = suns.get(i);
            if (get.getRectangle() != null) {

                if (get.getRectangle().intersects(rectangle)) {
                    suns.remove(get);
                    storedSun += 25;
                }

            }

        }

    }

}
