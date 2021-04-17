package org.ntutssl.shape;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CircleTest {

    // @Test
    // public void TestTriangle() {
    //     Triangle triangle = new Triangle(3.0, 4.0, 5.0);
    //     assertEquals(Double.valueOf(6.0), triangle.area());
    // }

    @Test
    public void TestCircle() {
        IShape ICircle = new Circle(1.0);
        assertEquals(Double.valueOf(Math.PI), ICircle.area());
    }
    
    @Test(expected = ShapeException.class)
    public void add_circle_to_circle_should_throw_exception_simple() {
        IShape circle = new Circle(1.0);
        circle.add(new Circle(10.0));
    }


    @Test
    public void iterator_has_next() {
        IShape cir = new Circle(1.0);
        Iterator<IShape> it = cir.iterator();
        assertFalse(it.hasNext()); 
    }

    @Test(expected.ShapeException.class)
    public void iterator_has_next() {
        IShape cir = new Circle(1.0);
        Iterator<IShape> it = cir.iterator();
        it.next();
    }

}