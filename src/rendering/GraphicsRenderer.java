/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John
 */
public class GraphicsRenderer {
    
    public static Point2D getDisplayLocation(Point3D point, Point3D camera, Point3D focalPoint) {
        return new Point2D(getXDisplayLocation(point.getX(), point.getY(), point.getZ(),
                camera.getX(), camera.getY(), camera.getZ(),
                focalPoint.getX(), focalPoint.getY(), focalPoint.getZ()), 
                getYDisplayLocation(point.getX(), point.getY(), point.getZ(),
                camera.getX(), camera.getY(), camera.getZ(),
                focalPoint.getX(), focalPoint.getY(), focalPoint.getZ()));
    }
    
    public static double getXDisplayLocation(double x, double y, double z, double cameraX, double cameraY, double cameraZ, double focalX, double focalY, double focalZ) {
        return Math.tan(
                    Math.atan((focalZ - cameraZ) / (focalX - cameraX)) 
                    - Math.atan((z - cameraZ) / (x - cameraX)))
                * Math.sqrt((focalX - cameraX) 
                        * (focalX - cameraX) 
                        + (focalZ - cameraZ) 
                        * (focalZ - cameraZ));
        
    }
    
    public static double getYDisplayLocation(double x, double y, double z, double cameraX, double cameraY, double cameraZ, double focalX, double focalY, double focalZ) {
        return Math.tan(
                    Math.atan((focalZ - cameraZ) / (focalY - cameraY)) 
                    - Math.atan((z - cameraZ) / (y - cameraY)))
                * Math.sqrt((focalY - cameraY) 
                        * (focalY - cameraY) 
                        + (focalZ - cameraZ) 
                        * (focalZ - cameraZ));
        
    }
    
    
}
