
/**
 * Write a description of class Ingredient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient
{
    private String name;
    private double quantity;
    private String unit;
    
    // This is the Constructor
    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }
    
    public String toString()
    {
        return quantity + " " + unit + " of " + name;
        
    }
    
    public void setQuantity(double quantity)
    {
        this.quantity= quantity;
    }
    
    public double getQuantity()
    {
        return quantity;
    }
}