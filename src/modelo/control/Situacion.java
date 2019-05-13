package modelo.control;

public enum Situacion {
	menor(365, 365, "menor"), trabajador(365, 730, "trabajador"), parado(365, 182.5f, "parado"),
	jubilado(182.5f, 182.5f, "jubilado");

	private float nivelVida;
	private float sueldo;
	private String Situacion;

	private Situacion(float nivelVida, float sueldo, String estado) {
		this.nivelVida = nivelVida;
		this.sueldo = sueldo;
		this.Situacion = estado;

	}

	public float getNivelVida() {
		return nivelVida;
	}

	public float getSueldo() {
		return sueldo;
	}

	public String getSituacion() {
		return Situacion;
	}

	public void setSituacion(String situacion) {
		Situacion = situacion;
	}

}
