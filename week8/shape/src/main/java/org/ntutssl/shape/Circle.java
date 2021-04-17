package org.ntutssl.shape;

public class Circle implements IShape
{
    private Double r;
    public Circle (Double r) {
        this.r = r;
    }

    public Double area() {
        Double s = r*r*Math.PI;
        return s;
    }

    
}
