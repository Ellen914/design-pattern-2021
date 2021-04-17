package org.ntutssl.shape;

public class CompositeShape implements IShape
{
    

    @Override
    public Double area() {
        Double result = 0.0;
        Iterator<IShape> it = shapeList.iterator();
        while(it.hasNext()) {
            result += it.next().area();
        }
        return result;
    }

    public Iterator<IShape> iterator() {
        return shapeList.iterator();
    }


    @Override
    public IShape findFirstTriangle() {
        Iterator<IShape> it = this.iterator();
        IShape t1 = null;

        while(it.hasNext()) {
            IShape temp = it.next();
            if( temp instanceof Triangle) {
                t1 = temp;
            }
        }
        return t1;
    }

    public void accept(FindFirstTriangleVisitor fftv) {
        fftv.visit(cs);
        
    }
}
