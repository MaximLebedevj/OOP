package lecture4;


public abstract class Pizza {
    String name;
    Dough dough;
    Sause sause;
    Cheese cheese;
    Veggies veggies;
    Sausage sausage;
    
    abstract void prepare();
    
    void bake() {
        
    }
    
    void cut(){
        
    }
    
    void box() {
        
    }
}
