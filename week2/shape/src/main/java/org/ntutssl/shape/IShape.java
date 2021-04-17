package org.ntutssl.shape;

public interface IShape 
{
    public Double area();

    public default Iterator<IShape> iterator() {
        return new NullIterator();
    }

    public default IShape findFirstTriangle() {
        return null;
    }
}
