package heap.impl;

import heap.Heap;

import java.util.List;

/**
 * Created by Rapol Tongchenchitt on 14/11/14.
 */
public class TreeHeap<T extends Comparable> implements Heap<T>{

    class Node {
        Node parent;
        Node left, right;

        void setParent(Node parent) { this.parent = parent; }
        void setLeft  (Node left)   { this.left = left;     }
        void setRight (Node right)  { this.right = right;   }
    }

    Node root;
    int count;

    public TreeHeap(){
        root = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void insert(T element) {

    }

    @Override
    public T deleteMin() {
        return null;
    }


}

