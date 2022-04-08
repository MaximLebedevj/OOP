
public class HouseBlend implements IBeverage{
    private int cost = 100;
    
    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public String getDescription() {
        return "HouseBlend";
    }
}
