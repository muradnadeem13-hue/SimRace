import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimRace
{
    public final int ANZAHL_AUTOS = 5;
    public final int ANZAHL_RUNDEN = 20;


    static void main(String[] ignoredArgs)
    {
        (new SimRace()).performRace();
        System.err.println("-- Hauptthread wird beendet!--");
    }

    public void performRace()
    {
        List<Car> cars = new ArrayList<>();

        for(int i = 1; i <= ANZAHL_AUTOS; i++)
        {
            cars.add(new Car("Wagen " + i, this));
        }
        System.err.println("-- Noch nichts passiert!--");


        for(Car car : cars)
        {
            car.start();
        }
        for(Car car: cars)
        {
            try {
                car.join();
            } catch (InterruptedException e) {
                System.err.println("Thread " + Thread.currentThread().getName() + " wurde nicht beendet!");
            }
        }

        Collections.sort(cars);

        System.out.println("**** Endstand nach " + ANZAHL_RUNDEN + " Runden ****");
        for(int i = 0; i < ANZAHL_AUTOS; i++)
        {
            System.out.println("Platz " + (i+1) + ": " +  cars.get(i).toString());
        }
    }
}



