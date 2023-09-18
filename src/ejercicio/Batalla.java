package ejercicio;

import java.util.Objects;

public class Batalla {

	private Personaje p1, p2;

	public Batalla(Personaje p1, Personaje p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Personaje getP1() {
		return p1;
	}

	public void setP1(Personaje p1) {
		this.p1 = p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "Batalla [p1=" + p1 + ", p2=" + p2 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(p1, p2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batalla other = (Batalla) obj;
		return Objects.equals(p1, other.p1) && Objects.equals(p2, other.p2);
	}
	
	public void pelea() {
		do {
			p1.recibirGolpe(p1.golpear(p1), p2);
			p2.recibirGolpe(p2.golpear(p2), p1);
			if (p1.getPuntosVida()<=30)
				p1.curar();
			if (p2.getPuntosVida()<=30)
				p2.curar();
		}while(p1.getPuntosVida()<=0 || p2.getPuntosVida()<=0);
	}
}
