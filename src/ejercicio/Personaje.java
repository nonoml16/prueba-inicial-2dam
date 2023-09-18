package ejercicio;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {

	private String nombre;
	private int puntosVida, puntosConseguidos, numObjetos, puntosFuerza;
	private String[] mochila;
	
	public Personaje() {
		
	}

	public Personaje(String nombre) {
		this.nombre = nombre;
		this.puntosVida = 100;
		this.puntosConseguidos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getPuntosConseguidos() {
		return puntosConseguidos;
	}

	public void setPuntosConseguidos(int puntosConseguidos) {
		this.puntosConseguidos = puntosConseguidos;
	}

	public int getNumObjetos() {
		return numObjetos;
	}

	public void setNumObjetos(int numObjetos) {
		this.numObjetos = numObjetos;
	}

	public String[] getMochila() {
		return mochila;
	}

	public void setMochila(String[] mochila) {
		this.mochila = mochila;
	}

	public int getPuntosFuerza() {
		return puntosFuerza;
	}

	public void setPuntosFuerza(int puntosFuerza) {
		this.puntosFuerza = puntosFuerza;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntosConseguidos=" + puntosConseguidos
				+ ", numObjetos=" + numObjetos + ", mochila=" + Arrays.toString(mochila) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mochila);
		result = prime * result + Objects.hash(nombre, numObjetos, puntosConseguidos, puntosVida);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Arrays.equals(mochila, other.mochila) && Objects.equals(nombre, other.nombre)
				&& numObjetos == other.numObjetos && puntosConseguidos == other.puntosConseguidos
				&& puntosVida == other.puntosVida;
	}
	
	public void agregarObjeto (String nombreObjeto) {
		for (int i = 0; i < mochila.length; i++) {
			if(mochila[i]==null)
				mochila[i] = nombreObjeto;
			else
				if(i>10)
					System.out.println("YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA");
		}
	}
	
	public int golpear(Personaje p) {
		return ((int)Math.floor(Math.random() * (3 - 1 + 1)) + 1)*p.getPuntosFuerza();
	}
	
	public int recibirGolpe (int dano, Personaje p) {
		p.setPuntosVida(p.getPuntosVida()-dano);
		if(p.getPuntosVida()<=0) {
			p.setPuntosVida(0);
			System.out.println("Has MUERTO");
		}
		return p.getPuntosVida();
	}
	
	public String curar () {
		int vida = getPuntosVida();
		for (int i = 0; i < mochila.length; i++) {
			if(mochila[i].equals("BOTIQUIN")) {
				if(puntosVida >= 90 && puntosVida <=100)
					setPuntosVida(100);
				else
					setPuntosVida(getPuntosVida()+10);
			}
		}
		if(vida != getPuntosVida())
			return "Tiene "+getPuntosVida()+" puntos de vida";
		else
			return "No se ha encontrado el objeto tipo BOTIQUIN";
	}

}
