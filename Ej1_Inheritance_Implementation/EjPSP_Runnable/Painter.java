package EjPSP_Runnable;

public class Painter implements Runnable{
    private String Name;
    private int timeSpent;

    //constructor Painter
    public Painter(String name, int time) {
        super();
        this.Name = name;
        this.timeSpent = time;
    }
    //Methods
    @Override
    public void run() {
        System.out.println (this.Name + " started painting");
        try {
            Thread.sleep(this.timeSpent*300L);
        } catch (Exception e) {
            System.out.println (this.Name + " has been interrupted while painting");
        }
        System.out.println (this.Name + " just finished painting");
    }
    //Main
    public static void main(String[] args) {
        Painter Maria = new Painter ("Maria", 5);
        Painter Javier = new Painter ("Javier", 10);
        Painter Luisa = new Painter ("Luisa", 1);

        Maria.run();
        Javier.run();
        Luisa.run();
        System.out.println ("All the painters finished painting");
    }
}