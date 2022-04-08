
public class DarkRoast implements IBeverage{
    private int cost = 110;
    
    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public String getDescription() {
        return "DarkRoast";
    }
}
