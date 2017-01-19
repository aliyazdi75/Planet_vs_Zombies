package game;

public class GameLoop implements Runnable {

    public static final int FPS = 30;

    private GameFrame canvas;
    private GameState state;
    Level currentLevel;
    boolean lvl1IsDone = false, lvl2IsDone = false, lvl3IsDone = false, lvl4IsDone = false;

    public GameLoop(GameFrame frame) {
        canvas = frame;
    }

    /**
     * This must be called before the game loop starts.
     */
    public void init() {

        final GameFrame frm = canvas;
        state = new GameState(frm);
        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        currentLevel = new Level1(state);

    }
    @Override
    public void run() {

        while (true) {
            try {
                long start = System.currentTimeMillis();
                //
                if (!canvas.ProgramStart) {
                    currentLevel.update();
                }
                state.update();
                canvas.render(state);
                checkCurrentLevel();
                //
                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0) {
                    Thread.sleep(delay);
                }
            } catch (InterruptedException ex) {
            }
        }

    }

    /**
     * checks if game is over or game should go to next level
     */
    private void checkCurrentLevel() {

        if (currentLevel.gameOver) {
            state.refreshRows();
            if (currentLevel instanceof Level1) {
                currentLevel = new Level1(state);
            }
            if (currentLevel instanceof Level2) {
                currentLevel = new Level2(state);
                System.err.println("level2");
            }
            if (currentLevel instanceof Level3) {
                currentLevel = new Level3(state);
                System.err.println("level3");
            }
            if (currentLevel instanceof Level4) {
                currentLevel = new Level4(state);
                System.err.println("level4");
            }
            if (currentLevel instanceof Level5) {
                currentLevel = new Level5(state);
                System.err.println("level5");
            }

        }

        if (currentLevel.levelIsDone) {
            state.refreshRows();
            if (currentLevel instanceof Level1 && !lvl1IsDone) {
                currentLevel = new Level2(state);
                lvl1IsDone = true;
                System.err.println("level2");
            } else if (currentLevel instanceof Level2 && !lvl2IsDone) {
                currentLevel = new Level3(state);
                lvl2IsDone = true;
                System.err.println("level3");
            } else if (currentLevel instanceof Level3 && !lvl3IsDone) {
                currentLevel = new Level4(state);
                lvl3IsDone = true;
                System.err.println("level4");
            } else if (currentLevel instanceof Level4 && !lvl4IsDone) {
                currentLevel = new Level5(state);
                lvl4IsDone = true;
                System.err.println("level5");
            } else if (currentLevel instanceof Level5) {
                //victory!!!
            }

        }

    }

}
