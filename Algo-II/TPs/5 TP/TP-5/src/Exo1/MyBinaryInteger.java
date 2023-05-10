package Exo1;

public class MyBinaryInteger implements Comparable {
    public int b, value;
    public MyBinaryInteger(int value) {
        this.value = value;
        this.b = Integer.bitCount(this.value);
    }
    @Override
    public int compareTo(Object o) {
        MyBinaryInteger other = (MyBinaryInteger) o;
        if (this.b < other.b) {
            return -1;
        }
        if (this.b > other.b) {
            return 1;
        }
        return 0;
    }
    @Override
    public boolean equals(MyBinaryInteger other) {
        return (other.compareTo(this.b) == 0);
    }
    @Override
    public String toString() {
        return "Value = " + Integer.toString(this.value, 2) + " : b = " + this.b + "\n";
    }
}