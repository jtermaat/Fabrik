/*
 * Copyright 2019 John TerMaat
 */
package fabrik.physics;

import java.util.HashSet;
import java.util.Set;
import rendering.Camera;
import rendering.Point2D;
import rendering.Point3D;

/**
 *
 * @author John
 */
public class Bead {
    private double x;
    private double y;
    private double z;
    private double xVelocity;
    private double yVelocity;
    private double zVelocity;
    private Set<Bead> influences;
    
    private static final double PULL_RATIO = 0.2;
    private static final double FRICTION_RATIO = 0.97;
    
    public Bead(double x, double y, double z) {
        influences = new HashSet<Bead>();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void nextFrame() {
        x += xVelocity;
        y += yVelocity;
        z += zVelocity;
        for (Bead influence : getInfluences()) {
            xVelocity += (influence.getX() - x) * PULL_RATIO;
            yVelocity += (influence.getY() - y) * PULL_RATIO;
            zVelocity += (influence.getZ() - z) * PULL_RATIO;
        }
        xVelocity = xVelocity * FRICTION_RATIO;
        yVelocity = yVelocity * FRICTION_RATIO;
        zVelocity = zVelocity * FRICTION_RATIO;
    }
    
    public static void connect(Bead first, Bead second) {
        first.addToInfluences(second);
        second.addToInfluences(first);
    }
    
    public void addToInfluences(Bead other) {
        influences.add(other);
    }
    
    public void draw(Camera c) {
        Point2D drawPoint = c.getDisplayPoint(new Point3D(x, y, z));
        System.out.println("drawPoint: " + drawPoint);
        c.getGraphics().drawOval((int)(drawPoint.getX()-2.0), (int)(drawPoint.getY()-2.0), 4, 4);
        for (Bead other : influences) {
            Point2D otherDrawPoint = c.getDisplayPoint(other.getPoint3D());
            c.getGraphics().drawLine((int)drawPoint.getX(), (int)drawPoint.getY(), (int)otherDrawPoint.getX(), (int)otherDrawPoint.getY());
        }
    }
    
    public Point3D getPoint3D() {
        return new Point3D(x, y, z);
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

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getzVelocity() {
        return zVelocity;
    }

    public void setzVelocity(double zVelocity) {
        this.zVelocity = zVelocity;
    }

    public Set<Bead> getInfluences() {
        return influences;
    }

    public void setInfluences(Set<Bead> influences) {
        this.influences = influences;
    }
}

