package lecture4;


public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sause createSause();
    public Cheese createCheese();
    public Veggies createVeggies();
    public Sausage createSausage();
}
