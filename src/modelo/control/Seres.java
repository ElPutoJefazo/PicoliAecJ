package modelo.control;

import java.util.ArrayList;
import java.util.LinkedList;

import utilesglobal.Utiles;

public class Seres {

	private long id = 0;
	private int edad;
	private float esperanzaVida;
	private int NV;
	private float ahorro;
	private Situacion tipoEstado;
	private String nombre;
	private String[] nombresPersona = { "Juan", "David", "Laura", "Jose" };

	public Seres(long id, int edad, int ahorro) {
		super();
		this.id = generarId();
		this.nombre = darNombre();
		this.edad = 0;
		this.ahorro = 0;
		this.esperanzaVida = Utiles.obtenerAleatorio(90);
		this.NV = (int) Situacion.menor.getNivelVida();
		this.tipoEstado = Situacion.menor;
	}

	public Seres(int edad, Situacion situacion) {
		super();
		this.nombre = darNombre();
		this.id = generarId();
		this.edad = edad;
		this.ahorro = 0;
		this.esperanzaVida = Utiles.obtenerAleatorio(this.edad, 90);
		this.tipoEstado = situacion;
	}

	public long generarId() {
		this.id++;
		return this.id;

	}

	public String darNombre() {
		int aleatorio = Utiles.obtenerAleatorio(0, nombresPersona.length);
		nombre = nombresPersona[aleatorio];
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNV() {
		return NV;
	}

	public void setNV(int nV) {
		NV = nV;
	}

	public Situacion getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(Situacion tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getNombresPersona() {
		return nombresPersona;
	}

	public void setNombresPersona(String[] nombresPersona) {
		this.nombresPersona = nombresPersona;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public float setEsperanzaVida(float esperanzaNueva) {
		return this.esperanzaVida = esperanzaNueva;
	}

	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public void decrementarEsperanzaVida() {

	}

	public float esperanzaVidaAleatoria() {

		return esperanzaVida;
	}
}
