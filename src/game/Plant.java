package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * this is the sub class for all planets
 *
 * @author kasra
 */
public class Plant {

    protected ArrayList<Shot> shots;
    protected Rectangle rectangle;
    protected ImageIcon ii;
    protected Image image, preViewImage;
    int health = 3;
    protected Integer shootingRate = null;
    protected int locX, locY, height, width;
    protected int shotCounter;

    public Plant(int arr[]) {

        locX = arr[0];
        locY = arr[1];
        shots = new ArrayList<>();

    }

    private void makeRectangle() {

    }

    public Image getPlanetImage() {
        return image;
    }

    public Image getPreviewPlanetImage() {
        return preViewImage;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * checks if the shots hit the closest zombie
     *
     * @param row
     * @throws InterruptedException
     */
    public void update(Row row) throws InterruptedException {

        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            shot.move();
            try {

                if (!row.firstZombie.zombieIsBurned && row.firstZombie.health > 0
                        && row.firstZombie.getRectangle().intersects(shot.getRectangle())) {

                    if (shot instanceof IceShoot) {
                        row.firstZombie.zombieGotALowSpeedShot();
                    }
                    Sound.playSound("shoot.wav");
                    shots.remove(shot);
                    row.firstZombie.health -= 3;
                    //checking if zombie is dead
                    if (row.firstZombie.health <= 0) {
                        row.zombies.remove(row.firstZombie);
                        Sound.stopLoopingSounds(Zombie.clpMusicEating);
                        Zombie.FirstSound = true;
                    }

                }

            } catch (Exception e) {
            }
            //removes the shot that goes out of frame
            if (shot.locX > 2200) {
                shots.remove(shot);
            }
        }

    }

}
