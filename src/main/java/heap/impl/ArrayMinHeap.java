package heap.impl;

import heap.Heap;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Rapol Tongchenchitt on 14/11/14.
 */
public class ArrayMinHeap<T extends Comparable> implements Heap<T> {

    /**
     *  Class Variable
     */
    T[] data;
    int count;

    /**
     * Constructor
     * @param capacity - initial capacity
     */
    public ArrayMinHeap(int capacity){
        data = (T[]) new Comparable[capacity];
        count = 0;
    }

    /* UTILITY */

    @Override
    public int size() {
        return count;
    }

    /* NAVIGATION */
    private static int getParent(int pos){  return pos % 2 == 0 ? (pos - 2) / 2 : (pos - 1) / 2; }
    private static int getLeft(int pos){    return 2 * pos + 1;                 }
    private static int getRight(int pos){   return 2 * pos + 2;                 }
    private void swap(int pos, int parent){ T temp = data[pos]; data[pos] = data[parent]; data[parent] = temp; }

    /* INSERT */
    @Override
    public void insert(T element) {
        if(count >= data.length){
            final T[] temp = (T[]) new Comparable[data.length * 2];
            for(int i = 0; i < data.length; i++) temp[i] = data[i];
            data = temp;
        }

        data[count] = element;
        siftUp(count++);
    }

    private void siftUp(int pos) {
        if(pos == 0) return;

        int parent = getParent(pos);
        if(data[pos].compareTo(data[parent]) < 0){
            swap(pos, parent);
            siftUp(parent);
        }
    }

    /* DELETE */
    @Override
    public T deleteMin() {
        T ans = data[0];

        swap(0, count-1);
        data[--count] = null;
        siftDown(0);

        return ans;
    }

    private void siftDown(int pos) {

        T left = (getLeft(pos) > count) ? null : data[getLeft(pos)];
        T right = (getRight(pos) > count) ? null : data[getRight(pos)];

        if(left == null) return;
        if(right == null){
            if(left.compareTo(data[pos]) < 0){
                swap(pos, getLeft(pos));
                siftDown(getLeft(pos));
            } else {
                return;
            }
        } else {
            if(left.compareTo(data[pos]) >= 0 && right.compareTo(data[pos]) >= 0){
                return;
            } else if(left.compareTo(right) < 0){
                swap(pos, getLeft(pos));
                siftDown(getLeft(pos));
            } else {
                swap(pos, getRight(pos));
                siftDown(getRight(pos));
            }
        }
    }
}
