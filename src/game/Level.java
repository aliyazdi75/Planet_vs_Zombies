/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *  this is a super class for all levels
 * @author kasra
 */
public class Level {
    
    protected Random random;
    protected boolean roundOneIsDone = false, roundTwoIsDone = false;
    protected long startTime;
    protected int counter = 0;
    public GameState state;
    protected int i = 1, j = 2, k = 3;
    protected boolean FirstSound = true, FirstSoundH = true;
    public boolean levelIsDone = false, gameOver = false;

    public Level (GameState state) {
	
	random = new Random();
	startTime = System.currentTimeMillis();
	this.state = state;
	state.planetsInTheBar[6] = new PlantInPlantBar(7, 7);
	
    }
    
    public void update () {
	//cheks if game is over
	for (int l = 0; l < 5; l++) {
	    
	    if (state.rows[l].gameOver) {
		this.gameOver = true;
	    }
		
	}

    }
    
}
