
public class MilkDecorator implements CondimentDecorator{
    private int cost = 10;
    
    IBeverage component;
    
    public MilkDecorator(IBeverage component) {
        this.component = component;
    }
    
    public int getCost() {
        return component.getCost() + cost;
    }
    
    public String getDescription() {
        return component.getDescription() + " with Milk";
    }
    
}
