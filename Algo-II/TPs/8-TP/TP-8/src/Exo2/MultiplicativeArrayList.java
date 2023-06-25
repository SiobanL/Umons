package Exo2;

public class MultiplicativeArrayList<T> extends MyArrayList<T>{
    protected int mult;
    public MultiplicativeArrayList(int capacity, int mult){
        super(capacity);
        this.mult = mult;
    }
    @Override
    protected int reallocateSize() {
        return size()*mult;
    }
}
