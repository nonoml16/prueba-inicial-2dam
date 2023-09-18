package ejercicio;

public class Main {

	public static void main(String[] args) {

		Personaje p1 = new Personaje("Paco");
		Personaje p2 = new Personaje("Manolo");
		Batalla b = new Batalla(p1, p2);
		b.pelea();
	}

}
