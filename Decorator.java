interface IBeverage {
    int getCost();
    String getDescription();
}

interface CondimentDecorator extends IBeverage{
   
}

class DarkRoast implements IBeverage{
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

class Decaf implements IBeverage{
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

class Espresso implements IBeverage{
    private int cost = 150;
    
    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public String getDescription() {
        return "Espresso";
    }
}

class HouseBlend implements IBeverage{
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


class WhipDecorator implements CondimentDecorator{
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

class SoyDecorator implements CondimentDecorator{
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

class MochaDecorator implements CondimentDecorator{
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

class MilkDecorator implements CondimentDecorator{
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

class Main {
    public static void main(String[] args) {
        IBeverage order = new HouseBlend();
        order = new MilkDecorator(order);
        order = new MochaDecorator(order);
        order = new WhipDecorator(order);
        
        System.out.println(order.getDescription());
        System.out.println(order.getCost());
        
    }
}
