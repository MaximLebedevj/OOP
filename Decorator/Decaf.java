
public class Decaf implements IBeverage{
    private int cost = 135;
    
    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public String getDescription() {
        return "Decaf";
    }
}


