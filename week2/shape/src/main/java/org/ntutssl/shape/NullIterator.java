package org.ntutssl.shape;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<IShape> {
    public boolean hasNext() {
        return false;
    }

    public IShape next() {
        throw new ShapeException("Iterator doesn't have next()");
    }

}