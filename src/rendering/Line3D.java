/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John
 */
public class Line3D {
    private Point3D point;
    private Vector3D vector;
    
    public Line3D(Point3D p1, Point3D p2) {
        this(p1, Point3D.getVector3DFromPoints(p2, p1));
    }
    
    public Line3D(Point3D point, Vector3D vector) {
        this.point = point;
        this.vector = vector;
    }
    
    public double getDistanceFromPoint(Point3D point0) {
        Vector3D lineVector = getVector();
        Vector3D pointVector = Point3D.getVector3DFromPoints(point, point0);
        Vector3D productVector = lineVector.crossProduct(pointVector);
        return productVector.getMagnitude() / lineVector.getMagnitude(); 
    }
    
    public Point3D getAuxPoint() {
        return new Point3D(point.getX() + vector.getX(), point.getY() + vector.getY(), point.getZ() + vector.getZ());
    }

    public Point3D getPoint() {
        return point;
    }

    public void setPoint(Point3D point) {
        this.point = point;
    }

    public Vector3D getVector() {
        return vector;
    }

    public void setVector(Vector3D vector) {
        this.vector = vector;
    }
}
