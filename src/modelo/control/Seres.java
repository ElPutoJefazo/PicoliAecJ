package modelo.control;


import utilesglobal.Constantes;

public class Seres {

	
	long id=0;
	private int edad;
	private int esperanzaVida;
	private int NV=Constantes.NV;
	private int ahorro;
	private Situacion situacion;
	
	public Seres(long id, int edad, int ahorro) {
		super();
		this.id = id;
		this.edad = edad;
		this.ahorro = ahorro;
		this.esperanzaVida= esperanzaVida;
		this.NV=NV;
	}


	public int getEdad() {
		return edad;
	}

	public int getEsperanzaVida() {
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
		//TODO
	}
	
	private int esperanzaVidaAleatoria() {
		//TODO
		return esperanzaVida;
	}
	
}
