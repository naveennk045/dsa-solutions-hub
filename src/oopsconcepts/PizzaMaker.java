package oopsconcepts;

public class PizzaMaker {
   public int pizzaSize;
   public String crust;
   public String toppings;

    public void display(){
        System.out.printf("Pizza Size : %s%nCrust : %s crust%nToppings : %s%n",pizzaSize,crust,toppings);
    }

    public PizzaMaker(int pizzaSize, String crust, String toppings) {
        this.pizzaSize = pizzaSize;
        this.crust = crust;
        this.toppings = toppings;
    }

    public PizzaMaker() {
    }
}