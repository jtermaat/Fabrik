/*
 * Copyright 2019 John TerMaat
 */
package fabrik;

import fabrik.physics.BeadGrid;
import java.awt.Graphics;
import rendering.Screen;

/**
 *
 * @author John
 */
public class Animator implements Runnable {
    private Graphics graphics;
    private BeadGrid grid;
    private Screen screen;
    
    
    
    @Override
    public void run() {
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public BeadGrid getGrid() {
        return grid;
    }

    public void setGrid(BeadGrid grid) {
        this.grid = grid;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
