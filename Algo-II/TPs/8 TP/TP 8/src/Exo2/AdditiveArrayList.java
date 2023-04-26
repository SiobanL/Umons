package Exo2;

public class AdditiveArrayList<T> extends MyArrayList<T>{
    private int sizeIncrement;
    public AdditiveArrayList(int capacity, int sizeIncrement){
        super(capacity);
        this.sizeIncrement = sizeIncrement;
    }
    @Override
    protected int reallocateSize() {
        return size()+sizeIncrement;
    }
}
