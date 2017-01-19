package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class AthleteZombie extends Zombie {

    int FirstReachAthlete;
    int tm = -1;
    int rowyLoc;
    int rowxLoc;

    public AthleteZombie(int arr[]) {

        super(arr);
        health = 6;
        speed = 3;
        ImageIcon ii = new ImageIcon("PoleVaultingZombie1.png");
        image = ii.getImage();
        makeRectangle();

    }

    /**
     * @return
     */
    public Image getZombieImage() {
        return image;
    }

    private void makeRectangle() {

        rectangle = new Rectangle(locX + 25, locY + 28, 50, 200);

    }

    public void move() {
        locX -= speed;
        makeRectangle();
    }
    /**
     * performs special jump for athlete
     */
    public void jump() {

        locY++;
        if (tm == 0) {
            FirstReachAthlete = 2;
            locY = rowyLoc;
        } else {
            locX += speed * tm;
            if (rowxLoc - locX >= 130) {
                tm++;
                locY -= speed * tm;
            } else {
                tm--;
                locY += speed * tm;
            }
        }
        makeRectangle();

    }

    @Override
    public void update(Row row) {

        for (int i = row.planets.length - 1; i >= 0; i--) {

            Plant planet = row.planets[i];
            if (planet != null) {

                if (planet.getRectangle().intersects(this.rectangle)) {

                    zombieReachedPlanet = true;
                    if (FirstReachAthlete == 0) {
                        ImageIcon ii = new ImageIcon("PoleVaultingZombie2.png");
                        image = ii.getImage();
                        rowyLoc = locY;
                        rowxLoc = locX;
                        FirstReachAthlete = 1;
                        jump();
                        speed = 2;
                    } else {
                        super.update(row);
                        Sound.stopLoopingSounds(clpMusicEating);
                        FirstSound=true;
                    }
                }

            }
        }

        if (FirstReachAthlete == 1) {
            jump();
            zombieReachedPlanet = false;
        }
        if (!zombieReachedPlanet) {
            move();
        }
    }
}

