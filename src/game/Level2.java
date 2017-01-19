/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import sounds.Sound;

import javax.sound.sampled.Clip;

/**
 * @author kasra
 */
public class Level2 extends Level {

    private boolean bool = true, firstSound = true;
    public static Clip clpMusicStart;

    public Level2(GameState state) {

        super(state);
        state.sky.storedSun = 500;
        state.planetsInTheBar[0] = new PlantInPlantBar(1, 0);
        state.planetsInTheBar[1] = new PlantInPlantBar(2, 1);
        state.planetsInTheBar[2] = new PlantInPlantBar(4, 2);

    }

    public void update() {

        super.update();

        if(firstSound) {
            if (GameState.clpMusicStart != null)
                Sound.stopLoopingSounds(GameState.clpMusicStart);
            clpMusicStart = Sound.clipForLoopFactory("level2.wav");
            clpMusicStart.loop(Clip.LOOP_CONTINUOUSLY);
            firstSound=false;
        }

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

                i = random.nextInt(5);
                if (bool) {
                    state.rows[i].makeAZombie(1);
                } else {
                    state.rows[i].makeAZombie(2);
                }
                //makes another zombie in another line
                while (true) {
                    k = random.nextInt(5);
                    if (k != i) {
                        state.rows[k].makeAZombie(1);
                        break;
                    }
                }
                //
                bool = !bool;
                startTime = System.currentTimeMillis();
                counter++;

            }
            if (counter > 8) {
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
            if (counter > 13 && !levelIsDone) {
                if (state.allZombiesAreDead()) {
                    levelIsDone = true;
                }
            } else if ((System.currentTimeMillis() - startTime) / 1000 > 15 - counter && !levelIsDone) {

                i = random.nextInt(5);
                state.rows[i].makeAZombie(1 + random.nextInt(2));

                while (true) {
                    j = random.nextInt(5);
                    if (j != i) {
                        state.rows[j].makeAZombie(1);
                        break;
                    }
                }
                while (true) {
                    k = random.nextInt(5);
                    if (k != i && k != j) {
                        state.rows[k].makeAZombie(1 + random.nextInt(2));
                        break;
                    }
                }

                startTime = System.currentTimeMillis();
                counter += 2;

            }

        }

    }

}
