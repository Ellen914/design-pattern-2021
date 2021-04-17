package org.ntutssl.shape;

import java.util.Iterator;

public class FindFirstTriangleVisitor {

    private IShape result = null;

    public void visit(CompositeShape cs) {

        Iterator<IShape> it = cs.iterator();

        while(it.hasNext()) {
            IShape temp = it.next();
            if( temp instanceof Triangle) {
                result = temp;
            }
        }
    }

    public IShape getResult() {
        return result;
    }
    
}