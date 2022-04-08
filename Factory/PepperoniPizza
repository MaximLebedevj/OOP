package lecture4;


public class PepperoniPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
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
