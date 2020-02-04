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
    
    public static void main(String[] args) {
        Vector3D v = new Vector3D(2, 1, 2);
        Point3D p = new Point3D(3, 1, -1);
        Line3D line = new Line3D(p,v);
        Point3D p0 = new Point3D(0,2,3);
        System.out.println("distance: " + line.getDistanceFromPoint(p0)); // expect 5;
        
        Point3D p1 = new Point3D(5,2,1);
        Point3D p2 = new Point3D(3,1,-1);
        Point3D p3 = new Point3D(0,2,3);
        Line3D line2 = new Line3D(p1, p2);
        System.out.println("distance2: " + line2.getDistanceFromPoint(p3));
    }
    
    private double getDistanceFromPoint(Point3D point0) {
        Vector3D lineVector = getVector();
        Vector3D pointVector = Point3D.getVector3DFromPoints(point, point0);
        Vector3D productVector = lineVector.crossProduct(pointVector);
        System.out.println("line vector; " + lineVector);
        System.out.println("point vector: " + pointVector);
        System.out.println("product vector: " + productVector);
        return productVector.getMagnitude() / lineVector.getMagnitude(); 
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
