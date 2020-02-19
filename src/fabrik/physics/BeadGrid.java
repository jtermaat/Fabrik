/*
 * Copyright 2019 John TerMaat
 */
package fabrik.physics;

import java.util.HashSet;
import java.util.Set;
import rendering.Line3D;
import rendering.Point3D;
import rendering.Screen;

/**
 *
 * @author John
 */
public class BeadGrid {
    Set<Bead> beads;
    
    final static double SELECTION_THRESHHOLD = 5.0;
    
    public BeadGrid(Point3D corner1, Point3D corner2, Point3D corner3, int numBeadsWidth, int numBeadsLength) {
        beads = new HashSet<Bead>();
        Bead[][] grid = new Bead[numBeadsWidth][numBeadsLength];
        for (int i = 0;i<numBeadsWidth;++i) {
            for (int j = 0;j<numBeadsLength;++j) {
                
                double x = corner1.getX() + (corner2.getX() - corner1.getX()) * ((double)i / (double)numBeadsWidth);
                double y = corner1.getY() + (corner2.getY() - corner1.getY()) * ((double)j / (double)numBeadsLength);
                double z = corner1.getZ() + (corner2.getZ() - corner1.getZ()) * ((double)j / (double)numBeadsLength);
                
                Bead bead = new Bead(x, y, z);
                beads.add(bead);
                grid[i][j] = bead;
            }
        }
        for (int i = 0;i<numBeadsWidth;++i) {
            for (int j = 0;j<numBeadsLength;++j) {
                if (i > 0) {
                    Bead.connect(grid[i][j], grid[i-1][j]);
                }
                if (j > 0) {
                    Bead.connect(grid[i][j], grid[i][j-1]);
                }
            }
        }
    }
    
    public Bead getSelectedBead(Line3D selectionLine) {
        for (Bead bead : beads) {
            if (selectionLine.getDistanceFromPoint(bead.getPoint3D()) < SELECTION_THRESHHOLD) {
                return bead;
            }
        }
        return null;
    }
    
    public void nextFrame() {
        for (Bead bead : beads) {
            bead.nextFrame();
        }
    }
    
    public void draw(Screen s) {
        for (Bead bead : beads) {
            bead.draw(s);
        }
    }
}
