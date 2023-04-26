package Exo2;

public abstract class MyArrayList<T> {
    private int objectCount, copy, addCount;
    protected Object[] array;

    public MyArrayList(){
        this(1);
    }
    public MyArrayList(int n){
        array = new Object[n];
        objectCount = 0;
        copy = 0;
    }
    public int size(){
        return objectCount;
    }
    public int physicalSize(){
        return array.length;
    }
    protected abstract int reallocateSize();
    private void checkIndex(int i){
        if (i <0 || i > size()){
            throw new ArrayIndexOutOfBoundsException(String.format("Index %d is out of bounds for array of size %d", i, size()));
        }
    }
    public T get(int i){
        checkIndex(i);
        @SuppressWarnings("unchecked")
        final T o = (T) array[i];
        return o;
    }
    public void add(T o){
        reallocateIfNecessary();
        array[size()] = o;
        objectCount++;
        addCount++;
    }
    private void reallocateIfNecessary(){
        if(physicalSize() <= size()){
            Object[] newArray = new Object[reallocateSize()];
            copy += array.length;
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
    public void add(int i, T o){
        checkIndex(i);
        reallocateIfNecessary();
        //for (int j = size()-1; j >= i ; j--) {
        //    array[j+1] = array[j];
        //}
        copy += array.length;
        System.arraycopy(array, i, array, i+1, size()-i);
        array[i] = o;
        objectCount++;
        addCount++;
    }
    public int getV(){
        return physicalSize();
    }
    public int getW(){
        return copy;
    }
    public int getX(){
        return size()/physicalSize();
    }
    public int getY(){
        return addCount/size();
    }

}
