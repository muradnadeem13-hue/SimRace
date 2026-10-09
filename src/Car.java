import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"FieldMayBeFinal", "BusyWait"})
public class Car extends Thread implements Comparable<Car>
{

    private String _name;
    private long _fahrzeitGesamt;
    private SimRace _caller;

    public Car(String name, SimRace caller)
    {
        _name = name;
        _fahrzeitGesamt = 0;
        _caller = caller;
    }

    public void run()
    {
        for(int i=1; i <= _caller.ANZAHL_RUNDEN; i++)
        {
            _fahrzeitGesamt += (long) (100 * Math.random());
            try {
                Thread.sleep(_fahrzeitGesamt / 2);
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted");
            }

        }

        System.err.println(_name+ ": "+_fahrzeitGesamt);

    }

    @Override
    public String toString() {
        return _name + "; Zeit: " + _fahrzeitGesamt;
    }

    @Override
    public int compareTo(@NotNull Car obj)
    {
        return Long.compare(this._fahrzeitGesamt, obj._fahrzeitGesamt);
    }
}
