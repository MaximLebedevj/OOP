
public class Main {
    public static void main(String[] args) {
        IBeverage order = new HouseBlend();
        order = new MilkDecorator(order);
        order = new MochaDecorator(order);
        order = new WhipDecorator(order);
        
        System.out.println(order.getDescription());
        System.out.println(order.getCost());
        
    }
}
