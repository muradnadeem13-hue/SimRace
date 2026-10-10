import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimRace
{
    public final int NUM_CARS = 5;
    public final int NUM_ROUNDS = 30;


    static void main(String[] ignoredArgs) {
        (new SimRace()).performRace();
        System.err.println("-- Main thread terminated! --");
    }

    public void performRace() {
        List<Car> cars = new ArrayList<>();

        for(int i = 1; i <= NUM_CARS; i++)
        {
            cars.add(new Car("Car " + i, this));
        }
        System.err.println("-- Ready to roll!--");


        for(Car car : cars)
        {
            car.start(); // Cars are independent when it comes to finishing the race
        }
        for(Car car: cars)
        {
            try {
                car.join(); // Car has completed the race
            } catch (InterruptedException e) {
                System.err.println("Thread " + Thread.currentThread().getName() + " not terminated!");
            }
        }

        Collections.sort(cars);

        System.out.println("**** End result after " + NUM_ROUNDS + " rounds ****");
        for(int i = 0; i < NUM_CARS; i++)
        {
            System.out.println("Rank " + (i+1) + ": " +  cars.get(i).toString());
        }
    }
}



