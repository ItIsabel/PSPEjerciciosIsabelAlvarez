package EjPSP_Thread;

public class Painter extends Thread{
	private String Nombre;
	private int timeSpentxMeter;
	
	//constructor Painter
	public Painter(String name, int time) {
		super();
		this.Nombre = name;
		timeSpentxMeter=time;
	}

	@Override
public void run() {
	System.out.println(Nombre + " started painting ");
	try {//tiempo que tarda en pintar el pitor los metros
		Thread.sleep(timeSpentxMeter*300L);
	} catch (Exception e) {
		System.out.println(Nombre + " Ha sido interrumpido mientras pinta");
	}
	System.out.println(this.Nombre + " Ha terminado de pintar");
}
	
public static void main(String[] args) {
	Painter Maria = new Painter ("Maria",5);
	Painter Javier = new Painter ("Javier",10);
	Painter Luisa = new Painter ("Luisa",1);
	
	Maria.start();
	Javier.start();
	Luisa.start();
	System.out.println("todos los pintores pintan");
}

}
