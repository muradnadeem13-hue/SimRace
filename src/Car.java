import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"FieldMayBeFinal", "BusyWait"})
public class Car extends Thread implements Comparable<Car>
{

    private String name;
    private long totalDriveTime;
    private SimRace caller;

    public Car(String name, SimRace caller)
    {
        this.name = name;
        totalDriveTime = 0;
        this.caller = caller;
    }

    public void run()
    {
        for(int i=1; i <= caller.NUM_ROUNDS; i++)
        {
            totalDriveTime += (long) (100 * Math.random());
            try {
                Thread.sleep(totalDriveTime / 2);
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted");
            }

        }

        System.err.println(name + ": " + totalDriveTime);

    }

    @Override
    public String toString() {
        return name + "; Time: " + totalDriveTime;
    }

    @Override
    public int compareTo(@NotNull Car obj)
    {
        return Long.compare(this.totalDriveTime, obj.totalDriveTime);
    }
}
