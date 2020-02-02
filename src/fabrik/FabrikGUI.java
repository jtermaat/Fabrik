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
       JFrame frame = new JFrame("My First GUI");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1000,800);
       frame.setVisible(true);
       JPanel panel = new JPanel();
       panel.setSize(800, 600);
       panel.setAlignmentY(40);
       frame.add(panel);
       panel.setBounds(10, 200, 800, 600);
       panel.setBackground(Color.WHITE);
       Graphics g = panel.getGraphics();
       Camera c = new Camera();
       c.setCameraPoint(new Point3D(100, 150, 100));
       c.setFocalPoint(new Point3D(100, 150, 50));
       c.setGraphics(g);
       BeadGrid grid = new BeadGrid(new Point3D(50, 0, 10), new Point3D(1000, 20, 1000), new Point3D(0, 20, 1000), 10, 10);
       grid.draw(c);
       
        JSlider xSlider = new JSlider(-200, 1000);
        xSlider.setAlignmentY(10);
        JSlider ySlider = new JSlider(-200, 1000);
        ySlider.setAlignmentY(20);
        JSlider zSlider = new JSlider(-200, 1000);
        zSlider.setAlignmentY(30);
        
        
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
        frame.getContentPane().add(ySlider);
        ySlider.setBounds(10, 20, 500, 20);
        frame.getContentPane().add(zSlider);
        zSlider.setBounds(10, 30, 500, 30);
        xSlider.setVisible(true);
        ySlider.setVisible(true);
        zSlider.setVisible(true);
    }
    
}
