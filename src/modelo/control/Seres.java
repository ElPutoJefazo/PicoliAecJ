package modelo.control;

import utilesglobal.Constantes;
import utilesglobal.Utilies;

public class Seres {
	long id = 0;
	private int edad;
	private int esperanzaVida;
	private int NV = Constantes.NV;
	private int ahorro;
	private Situacion situacion;
	private String nombre;
	private String[] nombresPersona = { "Juan", "David", "Laura", "Jose" };

	public Seres(long id, int edad, int ahorro) {
		super();
		this.id = generarId();
		this.nombre = darNombre();
		this.edad = 0;
		this.ahorro = 0;
		this.esperanzaVida = Utilies.obtenerAleatorio(90);
		this.NV = 365;
		this.situacion = Situacion.menor;
	}

	public long generarId() {
		this.id++;
		return this.id;

	}

	public String darNombre() {
		int aleatorio = Utilies.obtenerAleatorio(0, nombresPersona.length);
		nombre = nombresPersona[aleatorio];
		return nombre;

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
		// TODO
	}

	private int esperanzaVidaAleatoria() {
		// TODO
		return esperanzaVida;
	}
}