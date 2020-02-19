/*
 * Copyright 2019 John TerMaat
 */
package fabrik;

import fabrik.physics.Bead;
import fabrik.physics.BeadGrid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rendering.Line3D;
import rendering.Point2D;
import rendering.Point3D;
import rendering.Screen;
import rendering.Vector3D;

/**
 *
 * @author John
 */
public class FabrikGUI implements MouseListener, MouseMotionListener {
    Screen screen;
    BeadGrid grid;
    Bead selected;
    
    public static void main(String[] args) {
        FabrikGUI gui = new FabrikGUI();
        gui.go(args);
    }
    
    public void go(String[] args) {
       JFrame frame = new JFrame("Fabrik");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1000,1000);
       frame.setVisible(true);
       JPanel panel = new JPanel();
       panel.setSize(600, 600);
       panel.setAlignmentY(40);
       frame.add(panel);
       panel.setBounds(100, 200, 800, 600);
       panel.setBackground(Color.WHITE);
       Graphics g = panel.getGraphics();
       panel.addMouseListener(this);
       Point3D cameraPoint = new Point3D(-500, -500, -500);
       Vector3D cameraVector = new Vector3D(1, 1, 1);
       screen = new Screen(cameraPoint, cameraVector, 800,600);
       screen.setGraphics(g);
       grid = new BeadGrid(new Point3D(200, 200, 300), new Point3D(500, 300, 300), new Point3D(500, 500, 500), 10, 10);
       grid.draw(screen);
       
        JSlider xSlider = new JSlider(200, 800);
        JSlider ySlider = new JSlider(200, 800);
        JSlider zSlider = new JSlider(200, 800);
        
        
        ChangeListener cameraXChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                screen.setCameraPoint(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
                screen.getGraphics().clearRect(0, 0, 1000, 1000);
                grid.draw(screen);
            }
        };
        xSlider.addChangeListener(cameraXChangeListener);
        
        
        ChangeListener cameraYChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                screen.setCameraPoint(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
                screen.getGraphics().clearRect(0, 0, 1000, 1000);
                grid.draw(screen);
            }
        };
        ySlider.addChangeListener(cameraYChangeListener);
        
        ChangeListener cameraZChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                screen.setCameraPoint(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
                screen.getGraphics().clearRect(0, 0, 1000, 1000);
                grid.draw(screen);
            }
        };
        zSlider.addChangeListener(cameraZChangeListener);
        
        frame.getContentPane().add(xSlider);
        xSlider.setBounds(10, 10, 500, 10);
        xSlider.setValue(200);
        frame.getContentPane().add(ySlider);
        ySlider.setBounds(10, 20, 500, 20);
        frame.getContentPane().add(zSlider);
        zSlider.setBounds(10, 30, 500, 30);
        xSlider.setVisible(true);
        ySlider.setVisible(true);
        zSlider.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point2D spotClicked = new Point2D(e.getX(), e.getY());
        Line3D lineClicked = screen.get3DLineFrom2DPoint(spotClicked);
        selected = grid.getSelectedBead(lineClicked);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point2D spotClicked = new Point2D(e.getX(), e.getY());
        Line3D lineClicked = screen.get3DLineFrom2DPoint(spotClicked);
        selected = grid.getSelectedBead(lineClicked);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selected = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selected != null) {
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Do nothing..
    }
    
}
