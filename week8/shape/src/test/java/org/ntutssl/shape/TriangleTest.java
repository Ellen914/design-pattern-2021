package org.ntutssl.shape;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {

    // @Test
    // public void TestTriangle() {
    //     Triangle triangle = new Triangle(3.0, 4.0, 5.0);
    //     assertEquals(Double.valueOf(6.0), triangle.area());
    // }

    @Test
    public void TestTriangle() {
        IShape Itriangle = new Triangle(3.0, 4.0, 5.0);
        assertEquals(Double.valueOf(6.0), Itriangle.area());
    }

}