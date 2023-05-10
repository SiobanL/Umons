public class Bicycle extends Vehicle
{
    protected String color;

    public Bicycle(String brand, String color)
    {
        super(brand);
        this.color = color;
    }

    @Override
    public String toString()
    {
        return this.brand + " " + this.color;
    }

    @Override
    public boolean canPass()
    {
        return true;
    }
}
