
public class MochaDecorator implements CondimentDecorator{
    private int cost = 15;
   
    IBeverage component;
    
    public MochaDecorator(IBeverage component) {
        this.component = component;
    }
    
    public int getCost() {
        return component.getCost() + cost;
    }
    
    public String getDescription() {
        return component.getDescription() + " with Mocha";
    }
}
