package Ej2_99threads;

public class Painter implements Runnable{
    private String Name;
    private int timeSpent;
    private static int counter=0;

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
            System.out.println("Counter:"+ Painter.counter );
            Painter.counter = 1;
        } catch (Exception e) {
            System.out.println (this.Name + " has been interrupted while painting");
        }
        System.out.println (this.Name + " just finished painting");
    }
    //Main
    public static void main(String[] args) {
        for (int i=0; i<20; i++) {
            Painter p = new Painter ("Painter" + i, (int) Math.floor(Math.random() * 10));
            p.run();
        }
    }
}

