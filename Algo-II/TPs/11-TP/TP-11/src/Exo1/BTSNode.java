package Exo1;

import java.util.Arrays;
import java.util.Objects;

public class BTSNode<T extends Comparable<T>> implements Cloneable {
    private T data;
    private BTSNode<T>[] children = new BTSNode[2];

    public BTSNode(T data){
        this.data = data;
    }
    public void setLeftChild(BTSNode child){
        children[1] = child;
    }
    public void setRigthChild(BTSNode child){
        children[0] = child;
    }
    public void setData(T data){
        this.data = data;
    }
    public BTSNode<T> getLeftChild(){
        return children[0];
    }
    public BTSNode<T> getRightChild(){
        return children[1];
    }
    public T getData(){
        return this.data;
    }

//    private BTSNode copy(BTSNode tree){
//        BTSNode temp = new BTSNode(getData());
//        if (getRightChild() != null){
//            temp.setRigthChild(copy(getRightChild()));
//        }
//        if (getLeftChild() != null){
//            temp.setLeftChild(copy(getLeftChild()));
//        }
//        return temp;
//    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        var root = new BTSNode<T>(getData());
        if(getRightChild() != null){
            root.setRigthChild((BTSNode) getRightChild().clone());
        }
        if (getLeftChild() != null){
            root.setLeftChild((BTSNode) getLeftChild().clone());
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BTSNode<?> btsNode = (BTSNode<?>) o;
        return Objects.equals(data, btsNode.data) && Arrays.equals(children, btsNode.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(data);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    public boolean search(T data){
        BTSNode current = this;
        if (current.getData() == data){
            return true;
        }
        if (current.getRightChild() != null){
            current.setRigthChild(current.getRightChild());
            return current.search(data);
        }
        if (current.getLeftChild() != null){
            current.setLeftChild(current.getLeftChild());
            return current.search(data);
        }
        return false;
    }
    public void insert(T data){

    }

    public void display(){
        if (getLeftChild() != null){
            getLeftChild().display();
        }
        if (getRightChild() != null){
            getLeftChild().display();
        }
        System.out.printf("%s\n",getData().toString());
    }
}