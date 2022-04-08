interface IQuackStrategy {
    void quack();
}

class NormalQuack implements IQuackStrategy {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}

class SquiqQuack implements IQuackStrategy {
    @Override
    public void quack() {
        System.out.println("squiq");
    }
}

class SilentQuack implements IQuackStrategy {
    @Override
    public void quack() {
       
    }
}

interface ISwimStrategy {
    void swim();
}

class NormalSwim implements ISwimStrategy {
    @Override
    public void swim() {
        System.out.println("angry swimming splashes");
    }
}

class CuteSwim implements ISwimStrategy {
    @Override
    public void swim() {
        System.out.println("cute swimming splashes");
    }
}

class NoSwim implements ISwimStrategy {
    @Override
    public void swim() {
        
    }
}

interface DisplayStrategy {
    void display();
}

class mallardDisplay implements DisplayStrategy {
    @Override
    public void display() {
        System.out.println("Mallard goes meee");
    }
}

class newDisplay implements DisplayStrategy {
    @Override
    public void display() {
        System.out.println("Mallard goes meee");
    }
}

class RubberDuckDisplay implements DisplayStrategy {
    @Override
    public void display() {
        System.out.println("Rubber goes hoo");    
    }
}

class RedHeadDisplay implements DisplayStrategy {
    @Override
    public void display(){
        System.out.println("RedHead goes woo");
    }
}

class NoDisplay implements DisplayStrategy {
    @Override
    public void display(){
    }
}

interface FlyStrategy {
    void fly();
}

class NormalFly implements FlyStrategy {
    @Override
    public void fly(){
        System.out.println("flying");
    }
}

class SlowFly implements FlyStrategy {
    @Override
    public void fly(){
        System.out.println("flying slowly");
    }
}

class FastFly implements FlyStrategy {
    @Override
    public void fly(){
        System.out.println("flying fast");
    }
}

class NoFly implements FlyStrategy {
    @Override
    public void fly(){
        System.out.println("cannot fly");
    }
}


class Duck {
    private IQuackStrategy quackStrategy;
    private ISwimStrategy swimStrategy;
    private DisplayStrategy displayStrategy;
    private FlyStrategy flyStrategy;
    
    public Duck(IQuackStrategy quackStrategy, ISwimStrategy swimStrategy, DisplayStrategy displayStrategy, FlyStrategy flyStrategy) {
        this.quackStrategy = quackStrategy;
        this.swimStrategy = swimStrategy;
        this.displayStrategy = displayStrategy;
        this.flyStrategy = flyStrategy;
    }
    
    public void Qauck() {
        quackStrategy.quack();
    }
    
    public void Swim() {
        swimStrategy.swim();
    }
    
    public void Display() {
        displayStrategy.display();
    }
    
    public void Fly() {
        flyStrategy.fly();
    }
}

class DecoyDuck extends Duck {
    
    public DecoyDuck(IQuackStrategy quackStrategy, ISwimStrategy swimStrategy, DisplayStrategy displayStrategy, FlyStrategy flyStrategy) {
        super(quackStrategy, swimStrategy, displayStrategy,  flyStrategy);
    }
}

class MallardDuck extends Duck {
    public MallardDuck(IQuackStrategy quackStrategy, ISwimStrategy swimStrategy, DisplayStrategy displayStrategy, FlyStrategy flyStrategy) {
        super(quackStrategy, swimStrategy, displayStrategy, flyStrategy);
    }
}

class RedheadDuck extends Duck {
    public RedheadDuck(IQuackStrategy quackStrategy, ISwimStrategy swimStrategy, DisplayStrategy displayStrategy, FlyStrategy flyStrategy) {
        super(quackStrategy, swimStrategy, displayStrategy, flyStrategy);
    }
}

class RubberDuck extends Duck {
    public RubberDuck(IQuackStrategy quackStrategy, ISwimStrategy swimStrategy, DisplayStrategy displayStrategy, FlyStrategy flyStrategy) {
        super(quackStrategy, swimStrategy, displayStrategy, flyStrategy);
    }
}

class Program {
    static void TestDuck(Duck duck) {
        duck.Qauck();
        duck.Swim();
        duck.Display();
        duck.Fly();
    }
}

class Main {
    public static void main(String[] args) {
        Program.TestDuck(new MallardDuck(new NormalQuack(), new NormalSwim(), new mallardDisplay(), new NormalFly()));
        Program.TestDuck(new RedheadDuck(new SilentQuack(), new NormalSwim(), new NoDisplay(), new NoFly()));
        Program.TestDuck(new RubberDuck(new SquiqQuack(), new NormalSwim(), new RubberDuckDisplay(), new FastFly()));
    }
}



