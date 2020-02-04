/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John TerMaat
 */
public class Plane3D {
    private double a; // ax + by + cz + d = 0
    private double b;
    private double c;
    private double d;
    
    public Plane3D(Line3D perpendicular, Point3D pointOnPlane) {
        
    }
    
    /**
     * Creates a plane from three distinct points on that plane.
     * 
     * @param point1 A distinct point on the plane
     * @param point2 A distinct point on the plane  
     * @param point3 A distinct point on the plane
     */
    public Plane3D(Point3D point1, Point3D point2, Point3D point3) {
        
    }
    
    /**
     * Creates a plane that is equidistant between the two given points.
     * 
     * @param point1 The constructed plane is equidistant between this and point2.
     * @param point2 The constructed plane is equidistant between this and point1.
     */
    public Plane3D(Point3D point1, Point3D point2) {
        this.a = 2.0 * point2.getX() - 2.0 * point1.getX();
        this.b = 2.0 * point2.getY() - 2.0 * point1.getY();
        this.c = 2.0 * point2.getZ() - 2.0 * point1.getZ();
        this.d = point1.getX()*point1.getX() - point2.getX()*point2.getX()
                + point1.getY()*point1.getY() - point2.getY()*point2.getY()
                + point1.getZ()*point1.getZ() - point2.getZ()*point2.getZ();
    }
    
    public Point3D intersectsWith(Line3D line) {
        double x = line.getVector().getX() - line.getPoint().getX();
        return null;
    }

    
    
}
