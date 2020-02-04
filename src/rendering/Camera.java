/*
 * Copyright 2019 John TerMaat
 */
package rendering;

import java.awt.Graphics;

/**
 *
 * @author John
 */
public class Camera {
    private Point3D cameraPoint;
    private Point3D focalPoint;
    private Graphics graphics;
    private int screenHeight;
    private int screenWidth;
    private double screenAngle;
    
    private static final double DEFAULT_SCREEN_ANGLE = Math.PI / 5.0;
    
    
    public Camera(double x, double y, double z, double focalX, double focalY, double focalZ, int screenHeight, int screenWidth) {
        this.cameraPoint = new Point3D(x, y, z);
        this.focalPoint = new Point3D(focalX, focalY, focalZ);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.screenAngle = DEFAULT_SCREEN_ANGLE;
    }
    
    public Camera(Point3D cameraPoint, Point3D focalPoint, int screenHeight, int screenWidth) {
        this.cameraPoint = cameraPoint;
        this.focalPoint = focalPoint;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.screenAngle = DEFAULT_SCREEN_ANGLE;
    }
    
    public Camera() {
        this.cameraPoint = new Point3D(0.0, 0.0, 0.0);
        this.focalPoint = new Point3D(0.0, 0.0, 0.0);
    }    
    
    public Point2D getDisplayPoint(Point3D point) {
        return GraphicsRenderer.getDisplayLocation(point, getCameraPoint(), getFocalPoint());
    }
    
//    public Point2D getDisplayPoint(Point3D point) {
//        return new Point2D(
//            (Math.atan((point.getZ() - getCameraPoint().getZ()) / (point.getX() - getCameraPoint().getX())) / DEFAULT_SCREEN_ANGLE)* this.screenWidth - (this.screenWidth / 2.0),
//            (Math.atan((point.getZ() - getCameraPoint().getZ()) / (point.getY() - getCameraPoint().getY())) / DEFAULT_SCREEN_ANGLE) * this.screenHeight - (this.screenHeight / 2.0));
//    }
    
    public void setCameraPointAndShiftFocal(Point3D point) {
        double shiftX = point.getX() - getCameraPoint().getX();
        double shiftY = point.getY() - getCameraPoint().getY();
        double shiftZ = point.getZ() - getCameraPoint().getZ();
        this.setCameraPoint(point);
        double focalX = getFocalPoint().getX() + shiftX;
        double focalY = getFocalPoint().getY() + shiftY;
        double focalZ = getFocalPoint().getZ() + shiftZ;
        this.setFocalPoint(new Point3D(focalX, focalY, focalZ));
    }
    
//    public void setCameraFocalPointByAngleAndDistance(double angleX, double angleY, double distanceToFocalPoint) {
//        focalX = (2.0 * x + Math.sqrt(
//            (4.0 * x * x) 
//                - (4.0 * 
//                        (distanceToFocalPoint * distanceToFocalPoint 
//                                - x*x*Math.tan(angleX)*Math.tan(angleX) 
//                                - x*x)
//                        / (Math.tan(angleX) * Math.tan(angleX)
//                                ) + 1))) / 2.0;
//        
//        focalY = (2.0 * x + Math.sqrt(
//            (4.0 * x * x) 
//                - (4.0 * 
//                        (distanceToFocalPoint * distanceToFocalPoint 
//                                - x*x*Math.tan(angleX)*Math.tan(angleX) 
//                                - x*x)
//                        / (Math.tan(angleX) * Math.tan(angleX)
//                                ) + 1))) / 2.0;
//    }
    
    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Point3D getCameraPoint() {
        return cameraPoint;
    }

    public void setCameraPoint(Point3D cameraPoint) {
        this.cameraPoint = cameraPoint;
    }

    public Point3D getFocalPoint() {
        return focalPoint;
    }

    public void setFocalPoint(Point3D focalPoint) {
        this.focalPoint = focalPoint;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public double getScreenAngle() {
        return screenAngle;
    }

    public void setScreenAngle(double screenAngle) {
        this.screenAngle = screenAngle;
    }
    
    
    
}
