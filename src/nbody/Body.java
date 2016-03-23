package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;

/******************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 ******************************************************************************/

public class Body {
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass

    public Body(Vector r, Vector v, double mass) {
        this.r = r;
        this.v = v;
        this.mass = mass;
    } // Body( Vector, Vector, double )

    public void move(Vector f, double dt) {
        Vector a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )

    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11; //gravity
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public void draw() {
        StdDraw.setPenRadius(0.015);
//        int red = (int) Math.round(Math.random() * 255);
//        int green = (int) Math.round(Math.random() * 255);
//        int blue = (int) Math.round(Math.random() * 255);
//        Color color = new Color(red, green, blue);
//        StdDraw.setPenColor(color);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        StdDraw.setPenColor(Color.BLACK);
        for (int i = 0; i < 200; i++) {
            double x0 = Math.random() * 2 - 2;
            double y0 = Math.random() * 2 - 2;
            double r0 = Math.random();
            StdDraw.point(x0, y0);
        } // for
        StdDraw.setPenRadius(.001);
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )

} // Body
