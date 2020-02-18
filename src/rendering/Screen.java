/*
 * Copyright 2019 John TerMaat
 */
package rendering;

import java.awt.Graphics;

/**
 *
 * @author John
 */
public class Screen {
    private Plane3D plane;
    private Point3D origin;
    private Vector3D xAxisVector;
    private Vector3D yAxisVector;
    private Point3D cameraPoint;
    private Vector3D cameraVector;
    private Graphics graphics;
    private double height;
    private double width;
    
    public Screen(Point3D cameraPoint, Vector3D cameraVector, double height, double width) {
        this.height = height;
        this.width = width;
        this.cameraVector = cameraVector;
        this.cameraPoint = cameraPoint;
        orient();
    }
    
    public void setCameraPoint(Point3D cameraPoint) {
        this.cameraPoint = cameraPoint;
        orient();
    }
    
    public void setCameraVector(Vector3D cameraVector) {
        this.cameraVector = cameraVector;
        orient();
    }
    
    public void setHeight(double height) {
        this.height = height;
        orient();
    }
    
    public void setWidth(double width) {
        this.width = width;
        orient();
    }
    
    private void orient() {
        Point3D oppositePoint = cameraPoint.addVector(cameraVector).addVector(cameraVector);
        Line3D cameraLine = new Line3D(cameraPoint, oppositePoint);
        this.plane = new Plane3D(cameraPoint, oppositePoint);
        this.yAxisVector = plane.getDefaultVector();
        this.xAxisVector = cameraVector.crossProduct(yAxisVector);
        Point3D centerPoint = plane.intersectsWith(cameraLine);
        Point3D xIntercept = centerPoint.moveDistanceInDirection(height * -1.0/2.0, yAxisVector);
        this.origin = xIntercept.moveDistanceInDirection(width * -1.0/2.0, xAxisVector);
    }
    
    public void drawLine(Point3D lineStart, Point3D lineEnd) {
        Point2D lineStart2D = getRenderedPoint(lineStart);
        Point2D lineEnd2D = getRenderedPoint(lineEnd);
        graphics.drawLine((int)lineStart2D.getX(), (int)lineStart2D.getY(), (int)lineEnd2D.getX(), (int)lineEnd2D.getY());
    }
    
    public Point2D getPointFromLineIntersection(Line3D line) {
        Line3D xAxis = new Line3D(origin, xAxisVector);
        Line3D yAxis = new Line3D(origin, yAxisVector);
        Point3D intersection = plane.intersectsWith(line);
        double x = yAxis.getDistanceFromPoint(intersection);
        double y = xAxis.getDistanceFromPoint(intersection);
        return new Point2D(x, y);
    }
    
    public Point2D getRenderedPoint(Point3D point) {
        Line3D line = new Line3D(point, cameraPoint);
        return getPointFromLineIntersection(line);
    }
    
    public Plane3D getPlane() {
        return plane;
    }

    public void setPlane(Plane3D plane) {
        this.plane = plane;
    }

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origin) {
        this.origin = origin;
    }

    public Vector3D getxAxisVector() {
        return xAxisVector;
    }

    public void setxAxisVector(Vector3D xAxisVector) {
        this.xAxisVector = xAxisVector;
    }

    public Vector3D getyAxisVector() {
        return yAxisVector;
    }

    public void setyAxisVector(Vector3D yAxisVector) {
        this.yAxisVector = yAxisVector;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
    
    
}
