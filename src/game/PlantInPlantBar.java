package game;

import javax.swing.*;
import java.awt.*;

/**
 * @author kasra
 */
public class PlantInPlantBar extends Plant {

    int firstHouseLocX = 240;
    int firstHouseLocY = 109;
    Image firstImage, secondImage;
    int intLocX, initLocY = 109;
    int kindOfPlanet;

    public PlantInPlantBar(int planetKind, int houseNum) {

	super(new int[2]);
	kindOfPlanet = planetKind;
	if (planetKind == 1) {

	    ii = new ImageIcon("PeashooterSeed.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("PeaShooter.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 2) {

	    ii = new ImageIcon("SunflowerSeed.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("Sunflower.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 3) {

	    ii = new ImageIcon("SnowPea.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("Snowpea2.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 4) {

	    ii = new ImageIcon("WallNutSeed.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("walnut_full_life.gif");
	    secondImage = ii.getImage();

	}
	if (planetKind == 5) {

	    ii = new ImageIcon("CherryBombSeed.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("PvZ_Pictures.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 6) {

	    ii = new ImageIcon("firepeper.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("Jalapeno.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 7) {

	    ii = new ImageIcon("shovel.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("shovel.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 8) {

	    ii = new ImageIcon("gradle.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("Agarliclol.png");
	    secondImage = ii.getImage();

	}
	if (planetKind == 9) {

	    ii = new ImageIcon("tallnut.PNG");
	    image = firstImage = ii.getImage();
	    ii = new ImageIcon("Tall-nut.png");
	    secondImage = ii.getImage();

	}
	//counting planet location
	if (houseNum == 0) {
	    intLocX = locX = firstHouseLocX;
	}
	if (houseNum == 1) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 2) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 3) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 4) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 5) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 6) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	if (houseNum == 7) {
	    intLocX = locX = firstHouseLocX + houseNum * 110;
	}
	locY = firstHouseLocY;
	makeRectangle();

    }

    public void makeRectangle() {

	rectangle = new Rectangle(locX, locY, 110, 90);

    }

    /**
     * changes the image when clicked or not
     *
     * @param bool
     */
    public void planetIsSelected(boolean bool) {

	if (bool) {
	    image = secondImage;
	} else {
	    image = firstImage;
	    locX = intLocX;
	    locY = initLocY;
	}

    }

    public int getKindOfPlanet() {
	return kindOfPlanet;
    }

}
