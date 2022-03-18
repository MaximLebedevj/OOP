
public class SoyDecorator implements CondimentDecorator{
    private int cost = 20;
    
    IBeverage component;
    
    public SoyDecorator(IBeverage component) {
        this.component = component;
    }
    
    public int getCost() {
        return component.getCost() + cost;
    }
    
    public String getDescription() {
        return component.getDescription() + " with Soy";
    }
}
