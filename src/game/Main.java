
package game;


import sounds.Sound;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static Clip clpMusicBackground;

    public static void main(String[] args) {

        // Initialize the global thread-pool
        ThreadPool.init();

        // Show the game menu ...
        // After the palyer clicks 'PLAY' ...
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                clpMusicBackground = Sound.clipForLoopFactory("plants_vs_zombies.wav");
                clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
                GameFrame frame = new GameFrame("بازی مبارزه گیاهان علیه زامبی ها");
                frame.setLocationRelativeTo(null); // put frame at center of screen
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon imgicon = new ImageIcon("PlantsVsZombies.png");
                frame.setIconImage(imgicon.getImage());
                frame.setVisible(true);
                frame.initBufferStrategy();
                // Create and execute the game-loop
                GameLoop game = new GameLoop(frame);
                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });

    }
}
