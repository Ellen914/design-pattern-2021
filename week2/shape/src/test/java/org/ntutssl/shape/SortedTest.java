package org.ntutssl.shape;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SortedTest 
{
    @Test
    public void SortTest()
    {
        List<IShape> shapeList = new ArrayList<IShape>();
        shapeList.add(new Triangle(3.0, 4.0, 5.0));
        shapeList.add(new Circle(10.0));
        shapeList.add(new Circle(1.0));
        shapeList.sort((x,y) ->  Double.valueOf(x.area()) - Double.valueOf(y.area()));
    }
}
