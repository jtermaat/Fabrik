/*
 * Copyright 2019 John TerMaat
 */
package rendering;

/**
 *
 * @author John
 */
public class Line3D {
    private Point3D point1;
    private Point3D point2;
    
    public static void main(String[] args) {
        Point3D p1 = new Point3D(3, 1, -1);
        Point3D p2 = new Point3D(5, 2, 1);
        Line3D line = new Line3D();
        line.setPoint1(p1);
        line.setPoint2(p2);
        Point3D p0 = new Point3D(0,2,3);
        System.out.println("distance: " + line.getDistanceFromPoint(p0)); // expect 5;
    }
    
//    private double getDistanceFromPoint(Point3D point0) {
//        return Math.sqrt(
//                ((point1.getX() - point0.getX()) + (point2.getX() - point1.getX())*Math.pow(((point0.getY() - point1.getY())/(point2.getY() - point1.getY())), 2)) 
//                +((point1.getY() - point0.getY()) + (point2.getY() - point1.getY())*Math.pow(((point0.getX() - point1.getX())/(point2.getX() - point1.getX())), 2))
//                +((point1.getZ() - point0.getZ()) + (point2.getZ() - point1.getZ())*Math.pow(((point0.getX() - point1.getX())/(point2.getX() - point1.getX())), 2)));
//    }
    
    private double getDistanceFromPoint(Point3D point0) {
        Vector3D lineVector = getVector();
        Vector3D pointVector = new Vector3D(point0.getX() - point1.getX(), point0.getY() - point1.getY(), point0.getZ() - point1.getX());
        Vector3D productVector = lineVector.crossProduct(pointVector);
        return productVector.getMagnitude() / pointVector.getMagnitude(); 
    }
    
    public Vector3D getVector() {
        return new Vector3D(point2.getX() - point1.getX(), point2.getY() - point1.getY(), point2.getZ() - point1.getZ());
        
    }

    public Point3D getPoint1() {
        return point1;
    }

    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }
}
