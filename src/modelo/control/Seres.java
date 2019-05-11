package modelo.control;

import java.util.ArrayList;
import java.util.LinkedList;

import utilesglobal.Utilies;

public class Seres {

	
	private long id=0;
	private int edad;
	private int esperanzaVida;
	private int NV=365;
	private int ahorro;
	private Situacion tipoEstado;
	private String nombre;
	private String[] nombresPersona = {"Juan" , "David", "Laura" , "Jose"};
	
	
	
	public Seres(long id, int edad, int ahorro) {
		super();
		this.id = generarId();
		this.nombre=darNombre();
		this.edad=0;
		this.ahorro = 0;
		this.esperanzaVida= Utilies.obtenerAleatorio(90);
		this.NV=365;
		this.tipoEstado=Situacion.menor;
	}
//	hola

	public long generarId() {
		this.id++;
		return  this.id;
			
	}
	
	public String darNombre() {
		int aleatorio=Utilies.obtenerAleatorio(0, nombresPersona.length);
		nombre= nombresPersona[aleatorio];
		return nombre;
		
		
		
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
