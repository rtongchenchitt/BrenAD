package heap;

import java.util.List;

/**
 * Created by Rapol Tongchenchitt on 14/11/14.
 */
public interface Heap<T extends Comparable> {

    /**
     *  Utility
     */
    public int size();

    /**
     *  Heap Operation
     */
    public void insert(T  element);
    public T deleteMin();

}
