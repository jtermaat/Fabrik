/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John
 */
public class Point3D {
    private double x;
    private double y;
    private double z;
    
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public static Vector3D getVector3DFromPoints(Point3D p1, Point3D p2) {
        return new Vector3D(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
}
