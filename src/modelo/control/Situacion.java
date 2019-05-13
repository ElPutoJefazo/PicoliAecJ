package modelo.control;

public enum Situacion {
menor(365,365,"menor"),trabajador(365,730,"trabajador"),parado(365,182.5,"parado"),jubilado(182.5f,182.5,"jubilado");



	private double nivelVida;
	private double sueldo;
	private String Situacion;

	
	private Situacion(float nivelVida,double sueldo, String estado) {
		this.nivelVida=nivelVida;
		this.sueldo=sueldo;
		this.Situacion=estado;
		
	}
	

	public double getNivelVida() {
		return nivelVida;
	}

	public double getSueldo() {
		return sueldo;
	}


	public String getSituacion() {
		return Situacion;
	}


	public void setSituacion(String situacion) {
		Situacion = situacion;
	}


}
