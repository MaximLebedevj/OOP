interface PizzaIngredientFactory {
    public Dough createDough();
    public Sause createSause();
    public Cheese createCheese();
    public Veggies createVeggies();
    public Sausage createSausage();
}

class Cheese {}

class ChicagoCheese extends Cheese {}

class ChicagoVeggies extends Veggies {}

class Dough {}

class FreshSausage extends Sausage {}

class FrozenSausage extends Sausage {}

class MarinaraSause extends Sause{}

class NyCheese extends Cheese {}

class NyVeggies extends Veggies{}

class PlumTomatoSause extends Sause {}

class Sausage {}

class Sause {}

class ThickCrustDough extends Dough {}

class ThinCrustDough extends Dough {}

class Veggies {}

abstract class Pizza {
    String name;
    Dough dough;
    Sause sause;
    Cheese cheese;
    Veggies veggies;
    Sausage sausage;
    
    abstract void prepare();
    
    void bake(){}
    
    void cut(){}
    
    void box(){}
}

class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;;
    
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
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

class PepperoniPizza extends Pizza {
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

class GreekPizza extends Pizza {
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

class ChicagoPizzaIngredientsFactory implements PizzaIngredientFactory {
    
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
    
    @Override 
    public Sause createSause() {
        return new PlumTomatoSause();
    }
    
    @Override 
    public Cheese createCheese() {
        return new ChicagoCheese();
    }
    
    @Override
    public Sausage createSausage() {
        return new FrozenSausage();
    }
    
    @Override
    public Veggies createVeggies() {
        return new ChicagoVeggies();
    }
}

class NyPizzaIngredientsFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }
    
    @Override
    public Sause createSause() {
        return new MarinaraSause();
    }
    
    @Override
    public Sausage createSausage() {
        return new FreshSausage();
    }
    
    @Override
    public Veggies createVeggies() {
        return new NyVeggies();
    }
    
    @Override
    public Cheese createCheese() {
        return new NyCheese();
    }
}

abstract class PizzaStore {
    Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }
    abstract Pizza createPizza(String type);
}

class NyPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NyPizzaIngredientsFactory();
        
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
        } else if (type.equals("greek")) {
            pizza = new GreekPizza(ingredientFactory);
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
        }
        return pizza;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientsFactory();
        
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
        } else if (type.equals("greek")) {
            pizza = new GreekPizza(ingredientFactory);
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
        }
        return pizza;
    }
}
