package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author kasra
 */
public class Sun {

    private Image sunImage;
    public int initLocX, initLocY = 0, locX, locY, fallingDistance, horizontalMovingDistance = 0;
    private Random random;
    private double speedY = 7, speedX = 0.5, movingKind;
    private long startTime = 0;
    private boolean timeIsSet = false, sunHasStopedVer = false, sunMustMove = true, goingUpIsDone = false;
    private int durationTime = 3;
    Rectangle rectangle = null;

    /**
     * a sun constructor for sun flower
     *
     * @param initLocX
     * @param initLocY
     */
    public Sun(int initLocX, int initLocY) {

        movingKind = 1;
        random = new Random();
        fallingDistance = 180 + random.nextInt(100);
        horizontalMovingDistance = 40;
        locX = this.initLocX = initLocX;
        locY = this.initLocY = initLocY;

    }

    /**
     * a sun constructor for a sun which comes from sky
     */
    public Sun() {

        movingKind = 2;
        random = new Random();
        fallingDistance = 300 + random.nextInt(1200);
        locX = this.initLocX = 200 + random.nextInt(1200);

    }

    /**
     * this method moves the sun
     */
    public void move() {

        if (movingKind == 1) {

            if (!goingUpIsDone) {
                if (locY > initLocY - 130) {
                    locY -= speedY;
                } else {
                    goingUpIsDone = true;
                    initLocY = locY;
                }
            } else if (locY < initLocY + fallingDistance) {
                locY += speedY - 1;
            } else {
                sunHasStopedVer = true;
            }

        } else if (locY < initLocY + fallingDistance) {
            locY += speedY;
        } else {
            sunHasStopedVer = true;
        }
        //cheking if the sun has stoped moving
        if (sunHasStopedVer && !timeIsSet) {
            startTime = System.currentTimeMillis();
            timeIsSet = true;
        }
        makeRectangle();

    }

    /**
     * this method checks if sun is still alive
     *
     * @return
     */
    public boolean checkIfSunIsdead() {

        boolean bool;
        if ((System.currentTimeMillis() - startTime) / 1000 > durationTime && startTime != 0) {
            bool = true;
        } else {
            bool = false;
        }

        return bool;

    }

    private void makeRectangle() {
        rectangle = new Rectangle(locX, locY, 140, 140);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
