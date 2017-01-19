package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ali Yazdi on 29/06/2016.
 */
public class CatapultZombie extends Zombie {

    boolean FirstKind = true;
    int shotCounter;
    Integer shootingRate = null;
    public int lastPlanetLocx;
    boolean planetIsInRow = false;

    public CatapultZombie(int arr[]) {

        super(arr);
        health = 8;
        shootingRate = 10;
        ImageIcon ii = new ImageIcon("5.png");
        image = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle() {

        rectangle = new Rectangle(locX + 25, locY + 28, 50, 200);

    }

    public void move() {
        if (!planetIsInRow) {
            locX -= speed;
        } else if (locX > 1860) {
            locX -= speed;
        }
        makeRectangle();
    }

    @Override
    public void update(Row row) {

        if (FirstKind) {
            super.update(row);
            findLastPlanet(row);
            for (int i = 0; i < shots.size(); i++) {
                Shot shot = shots.get(i);
                shot.move();
                for (int j = 0; j < row.planets.length; j++) {

                    if (row.planets[j] != null) {

                        if (row.planets[j].getRectangle().intersects(shot.getRectangle())) {

                            shots.remove(shot);
                            Sound.playSound("shoot.wav");
                            row.planets[j].health -= dps;
                            if (row.planets[j].health <= 0) {
                                row.planets[j] = null;
                            }

                        }

                    }
                }

            }
            if (planetIsInRow && locX <= 1860) {
                shotCounter += 1;
                if (shotCounter == 7 * shootingRate) {
                    shots.add(new CatapultShoot(locX, locY, 2, lastPlanetLocx));
                    shotCounter = 0;

                }
            }
            if (health == 1) {
                FirstKind = false;
                health = 5;
                ImageIcon ii = new ImageIcon("HD_Catapult_Zombie.png");
                image = ii.getImage();
            }

        }
        else{
            super.update(row);
        }

    }

    private void findLastPlanet(Row row) {

        lastPlanetLocx = 0;
        for (int i = 0; i < row.planets.length; i++) {

            if (row.planets[i] != null) {
                if (row.planets[i].health == 1) {
                    continue;
                }
                lastPlanetLocx = row.planets[i].locX;
                break;
            }

        }
        if (lastPlanetLocx == 0) {
            planetIsInRow = false;
        } else {
            planetIsInRow = true;
        }

    }

}
