package Exo2;
public class Bicycle extends Vehicule implements Lineable{
    private String color;
    public Bicycle(String color, String brand){
        super(brand);
        this.color = color;
    }
    @Override
    public boolean canPass() {
        return true;
    }
    @Override
    public String toString(){
        return "Color: " + color + " brand: " + brand;
    }
}
