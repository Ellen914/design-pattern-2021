package org.ntutssl.shape;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CompositeTest 
{
    @Test
    public void iterator_test()
    {
        CompositeShape cs = new CompositeShape();
        IShape cir = new Circle(1.0);
        IShape rec = new Triangle(3.0,4.0,5.0);
        cs.add(cir);
        cs.add(rec);
        Iterator<IShape> it = cs.iterator();
        assertTrue(it.hasNext());
        assertEquals(3.14, it.next().area(), 0.01);
        assertTrue(it.hasNext());
        assertEquals(6.0, it.next().area(), 0.01);
        assertFalse(it.hasNext());
    }


    @Test
    public void find_triangle_test()
    {
        CompositeShape cs = new CompositeShape();
        IShape cir = new Circle(1.0);
        IShape rec = new Triangle(3.0,4.0,5.0);
        cs.add(cir);
        cs.add(rec);
        Iterator<IShape> it = cs.iterator();
        IShape t1 = null;

        while(it.hasNext()) {
            IShape temp = it.next();
            if( temp instanceof Triangle) {
                t1 = temp;
            }
        }

        assertEquals(6.0, t1.area(), 0.01);
    }


    @Test
    public void find_first_triangle_test() {

        CompositeShape cs = new CompositeShape();
        IShape cir = new Circle(1.0);
        IShape rec = new Triangle(3.0,4.0,5.0);
        cs.add(cir);
        cs.add(rec);

        IShape t2 = cs.findFirstTriangle();

        assertEquals(6.0, t2.area(), 0.01);

    }

    @Test
    public void visitor_test() {
        FindFirstTriangleVisitor fftv = new FindFirstTriangleVisitor();
        //修水管 : 請個水電工(專家)來家裡幫忙吧! fftv:水電工
        
        CompositeShape cs = new CompositeShape();
        //我家 : cs
        IShape cir = new Circle(1.0);
        IShape rec = new Triangle(3.0,4.0,5.0);
        cs.add(cir);
        cs.add(rec);

        cs.accept(fftv);
        //請修水管的人進來家裡幫忙 : accept 
        IShape t3 = fftv.getResult();

        assertEquals(6.0, t3.area(), 0.01);

    }
}
