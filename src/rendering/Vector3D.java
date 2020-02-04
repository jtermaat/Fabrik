/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;
    
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double dotProduct(Vector3D other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }
    
    public Vector3D crossProduct(Vector3D other) {
        double x1;
        double y1;
        double z1;
        x1 = y * other.getZ() - z * other.getY();
        y1 = z * other.getX() - x * other.getZ();
        z1 = x * other.getY() - y * other.getX();
        return new Vector3D(x1, y1, z1);
    }
    
    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
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
