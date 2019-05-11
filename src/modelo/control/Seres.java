package modelo.control;

import java.util.ArrayList;

public class Seres {

	
	private long id=0;
	private int edad;
	private int esperanzaVida;
	private int NV=365;
	private int ahorro;
	
	public Seres(long id, int edad, int ahorro) {
		super();
		this.id = id;
		this.edad = edad;
		this.ahorro = ahorro;
		this.esperanzaVida= esperanzaVida;
		this.NV=NV;
	}


	private int getEdad() {
		return edad;
	}

	private int getEsperanzaVida() {
		return esperanzaVida;
	}

	private void setEsperanzaVida(int esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	private int getAhorro() {
		return ahorro;
	}

	private void setAhorro(int ahorro) {
		this.ahorro = ahorro;
	}
	
	private void decrementarEsperanzaVida() {
		
	}
	
	private int esperanzaVidaAleatoria() {
		
		return esperanzaVida;
	}
	
	
	
	
	
	
}
