public class Car extends Vehicle
{
    protected String licensePlate;

    public Car(String brand, String licensePlate)
    {
        /* Initialise la variable d'instance brand via Vehicle. */
        super(brand);
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString()
    {
        return this.brand + " " + this.licensePlate;
    }

    @Override
    public boolean canPass()
    {
        return false;
    }
}
