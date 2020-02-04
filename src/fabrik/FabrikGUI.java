/*
 * Copyright 2019 John TerMaat
 */
package fabrik;

import fabrik.physics.BeadGrid;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rendering.Camera;
import rendering.Point3D;

/**
 *
 * @author John
 */
public class FabrikGUI {
    public static void main(String[] args) {
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
       Camera c = new Camera();
       c.setScreenHeight(600);
       c.setScreenWidth(600);
       c.setCameraPoint(new Point3D(50, -150, 200));
       c.setFocalPoint(new Point3D(80, -80, 190));
       c.setGraphics(g);
       BeadGrid grid = new BeadGrid(new Point3D(200, 200, 200), new Point3D(500, 200, 500), new Point3D(500, 500, 500), 10, 10);
       grid.draw(c);
       
        JSlider xSlider = new JSlider(-1000, 1000);
        JSlider ySlider = new JSlider(-1000, 1000);
        JSlider zSlider = new JSlider(-1000, 1000);
        
        
        ChangeListener cameraXChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                c.setCameraPointAndShiftFocal(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
                c.getGraphics().clearRect(0, 0, 1000, 1000);
                grid.draw(c);
            }
        };
        xSlider.addChangeListener(cameraXChangeListener);
        
        
        ChangeListener cameraYChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               c.setCameraPointAndShiftFocal(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
               c.getGraphics().clearRect(0, 0, 1000, 1000);
               grid.draw(c);
            }
        };
        ySlider.addChangeListener(cameraYChangeListener);
        
        ChangeListener cameraZChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               c.setCameraPointAndShiftFocal(new Point3D(xSlider.getValue(), ySlider.getValue(), zSlider.getValue()));
               c.getGraphics().clearRect(0, 0, 1000, 1000);
               grid.draw(c);
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
    
}
