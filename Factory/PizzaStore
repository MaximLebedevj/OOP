package lecture4;


public abstract class PizzaStore {
    Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }
    
    abstract Pizza createPizza(String type);
}
