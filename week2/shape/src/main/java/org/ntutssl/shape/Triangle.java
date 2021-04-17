package org.ntutssl.shape;

public class Triangle implements IShape
{
    private Double a,b,c;
    public Triangle (Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double area() {
        Double s = (a + b + c)*0.5;
        return Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
