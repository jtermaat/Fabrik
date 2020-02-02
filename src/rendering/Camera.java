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
    
    
    public Camera(double x, double y, double z, double focalX, double focalY, double focalZ) {
        this.cameraPoint = new Point3D(x, y, z);
        this.focalPoint = new Point3D(focalX, focalY, focalZ);
    }
    
    public Camera(Point3D cameraPoint, Point3D focalPoint) {
        this.cameraPoint = cameraPoint;
        this.focalPoint = focalPoint;
    }
    
    public Camera() {
        this.cameraPoint = new Point3D(0.0, 0.0, 0.0);
        this.focalPoint = new Point3D(0.0, 0.0, 0.0);
    }    
    
    public Point2D getDisplayPoint(Point3D point) {
        return GraphicsRenderer.getDisplayLocation(point, getCameraPoint(), getFocalPoint());
    }
    
    public void setCameraPointAndShiftFocal(Point3D point) {
        double shiftX = point.getX() - cameraPoint.getX();
        double shiftY = point.getY() - cameraPoint.getY();
        double shiftZ = point.getZ() - cameraPoint.getZ();
        this.cameraPoint = point;
        double focalX = focalPoint.getX() + shiftX;
        double focalY = focalPoint.getY() + shiftY;
        double focalZ = focalPoint.getZ() + shiftZ;
        this.focalPoint = new Point3D(focalX, focalY, focalZ);
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
    
    
    
}
