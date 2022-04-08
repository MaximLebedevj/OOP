
public class WhipDecorator implements CondimentDecorator{
    private int cost = 25;
    
    IBeverage component;
    
    public WhipDecorator(IBeverage component) {
        this.component = component;
    }
    
    public int getCost() {
        return component.getCost() + cost;
    }
    
    public String getDescription() {
        return component.getDescription() + " with Whip";
    }
}
