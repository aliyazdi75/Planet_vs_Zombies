/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import sounds.Sound;

/**
 * @author kasra
 */
public class Level1 extends Level {

    public Level1(GameState state) {

	super(state);
	state.sky.storedSun = 500;
	state.planetsInTheBar[0] = new PlantInPlantBar(1, 0);
	state.planetsInTheBar[1] = new PlantInPlantBar(2, 1);

    }

    public void update() {

	super.update();

	if (!roundOneIsDone) {

	    if ((System.currentTimeMillis() - startTime) / 1000 > 15) {
		if (FirstSound) {
		    Sound.playSound("ZombieComing.wav");
		    FirstSound = false;
		}
		state.rows[random.nextInt(5)].makeAZombie(1);
		startTime = System.currentTimeMillis();
		counter++;
	    }
	    if (counter > 2) {
		roundOneIsDone = true;
	    }

	} else if (!roundTwoIsDone) {

	    if ((System.currentTimeMillis() - startTime) / 1000 > 15 - counter) {
		state.rows[random.nextInt(5)].makeAZombie(1);
		startTime = System.currentTimeMillis();
		counter++;
	    }
	    if (counter > 6) {
		roundTwoIsDone = true;
	    }

	} /**
	 * performing huge wave
	 */
	else {
	    if (FirstSoundH) {
		Sound.playSound("Hojoom.wav");
		FirstSoundH = false;
	    }
	    if (counter > 9) {
		if (state.allZombiesAreDead()) {
		    levelIsDone = true;
		}
	    } else if ((System.currentTimeMillis() - startTime) / 1000 > 12 - counter && !levelIsDone) {

		for (int i = 0; i < state.rows.length; i++) {
		    state.rows[i].makeAZombie(1);
		}
		state.rows[random.nextInt(5)].makeAZombie(1);
		startTime = System.currentTimeMillis();
		counter += 2;

	    }

	}

    }

}
