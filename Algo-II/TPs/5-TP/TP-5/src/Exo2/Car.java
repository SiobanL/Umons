package Exo2;
public class Car extends Vehicule implements Lineable {
    private String licensePlate;
    public Car(String licensePlate, String brand){
        super(brand);
        this.licensePlate = licensePlate;
    }
    @Override
    public boolean canPass() {
        return false;
    }
    @Override
    public String toString(){
        return "LicensePlate: " + licensePlate + " brand: " + brand;
    }
}
