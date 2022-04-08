package lecture4;


public class GreekPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    
    public GreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    void prepare() {
        this.dough = ingredientFactory.createDough();
        this.cheese = ingredientFactory.createCheese();
        this.sausage = ingredientFactory.createSausage();
        this.sause = ingredientFactory.createSause();
        this.veggies = ingredientFactory.createVeggies();
    }
}
