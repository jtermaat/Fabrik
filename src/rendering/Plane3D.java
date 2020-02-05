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
        this.a = ((point2.getY() - point1.getY()) * (point3.getZ() - point1.getZ())) - ((point3.getY() - point1.getY()) * (point2.getZ() - point1.getZ()));
        this.b = ((point2.getZ() - point1.getZ()) * (point3.getX() - point1.getY())) - ((point3.getZ() - point1.getZ()) * (point2.getX() - point1.getZ()));
        this.c = ((point2.getX() - point1.getX()) * (point3.getY() - point1.getY())) - ((point3.getZ() - point1.getX()) * (point2.getY() - point1.getY()));
        this.d = -1.0 * (this.a * point1.getX() + this.b * point1.getY() + this.c * point1.getZ());
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
        double x1 = line.getPoint().getX();
        double x2 = line.getAuxPoint().getX();
        double y1 = line.getPoint().getY();
        double y2 = line.getAuxPoint().getY();
        double z1 = line.getPoint().getZ();
        double z2 = line.getAuxPoint().getZ();
        double outputX = (x2 - x1) * ((-1 * x1) - y1 - z1) / (a * (x2-x1) + b * (y2-y1)  + c * (z2-z1)) + x1;
        double outputY = (y2 - y1) * (outputX - x1) / (x2 - x1) + y1;
        double outputZ = (z2 - z1) * (outputX - x1) / (x2 - x1) + z1;
        return new Point3D(outputX, outputY, outputZ);
    }

    
    
}
