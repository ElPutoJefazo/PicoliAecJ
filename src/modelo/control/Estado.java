package modelo.control;

import java.util.ArrayList;

import utilesglobal.Utiles;
import org.junit.jupiter.api.Test;
import utilesglobal.Constantes;

public class Estado {
	ArrayList<Seres> listaMenores = new ArrayList<Seres>();
	ArrayList<Seres> listaParados = new ArrayList<Seres>();
	ArrayList<Seres> listaTrabajadores = new ArrayList<Seres>();
	ArrayList<Seres> listaJubilados = new ArrayList<Seres>();
	ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	ArrayList<Seres> poblacion = new ArrayList<Seres>();

	public void Poblacion(int menoresInicial, int trabajadoresIncial, int jubiladosInicial) {
		listaMenores = new ArrayList<>();
		listaParados = new ArrayList<>();
		listaTrabajadores = new ArrayList<>();
		listaJubilados = new ArrayList<>();
		empresas = new ArrayList<>();
		poblacion = new ArrayList<>();

		for (int i = 0; i < menoresInicial; i++) {
			poblacion.add(new Seres(Utiles.obtenerAleatorio(0, 17), Situacion.menor));
		}
		for (int i = 0; i < trabajadoresIncial; i++) {
			poblacion.add(new Seres(Utiles.obtenerAleatorio(18, 65), Situacion.trabajador));
		}
		for (int i = 0; i < jubiladosInicial; i++) {
			poblacion.add(new Seres(Utiles.obtenerAleatorio(65, 90), Situacion.jubilado));
		}
	}

	private long dineroEstado = 100000;
	private int nacimientos = 0;
	private int jubilados = 0;
	private int identificador;
	private int contadorMuertos = 0;

	private void nacer() {
		for (int i = 0; i <= nacimientos; i++) {
			Seres menor = new Seres(identificador++, Constantes.EDAD_NACIMIENTO, Constantes.AHORROS_INICIALES);
			listaMenores.add(menor);
		}
	}

	private void morir() {
		for (int i = 0; i < listaMenores.size(); i++) {
			if (listaMenores.get(i).getEsperanzaVida() < listaMenores.get(i).getEdad()) {
				listaMenores.remove(i);
				contadorMuertos++;
			}
		}
		for (int i = 0; i < listaTrabajadores.size(); i++) {
			if (listaTrabajadores.get(i).getEsperanzaVida() < listaTrabajadores.get(i).getEdad()) {
				listaTrabajadores.remove(i);
				contadorMuertos++;
			}
		}
		for (int i = 0; i < listaParados.size(); i++) {
			if (listaParados.get(i).getEsperanzaVida() < listaParados.get(i).getEdad()) {
				listaParados.remove(i);
				contadorMuertos++;
			}
		}

		for (int i = 0; i < listaJubilados.size(); i++) {
			if (listaJubilados.get(i).getEsperanzaVida() < listaJubilados.get(i).getEdad()) {
				listaJubilados.remove(i);
				contadorMuertos++;
			}
		}

	}

	private void aumentarAnno() {
		for (Seres ser : poblacion) {
			ser.setEdad(ser.getEdad() + 1);
		}
	}

	private void incrementarProduccion() {
		// TODO
	}

	private void decrementarProduccion() {
		// TODO
	}

	private void subsidio() {
		// TODO
	}

	private void pagarTrabajador() {
		for (Seres ser : listaTrabajadores) {
			ser.setAhorro(ser.getAhorro() + ser.getTipoEstado().getSueldo());
		}
	}

	private void annadirEmpresa() {
		empresas.add(new Empresa());
	}

	private void eliminarEmpresa() {
		// TODO
	}

	private void jubilar() {
		for (Seres ser : listaTrabajadores) {
			if (ser.getEdad() == Constantes.EDAD_MINIMA_JUBILADO) {
				listaJubilados.add(ser);
				ser.setEsperanzaVida(Constantes.NV / 2);
			}
		}
	}

	private void nacimientosPorJubilacion() {
		for (Seres ser : listaJubilados) {
			if (ser.getEdad() == Constantes.EDAD_MINIMA_JUBILADO) {
				nacimientos++;
			}
		}
	}

	private void CrearSituacionInicial() {
		for (int i = 0; i < 50;) {
			Seres ser = new Seres(Utiles.obtenerAleatorio(Constantes.EDAD_NACIMIENTO, Constantes.EDAD_MAXIMA_MENOR),
					Situacion.menor);
			if (ser.getEdad() < ser.getEsperanzaVida()) {
				poblacion.add(ser);
				i++;
			}
		}
		for (int i = 0; i < 100;) {
			Seres ser = new Seres(Utiles.obtenerAleatorio(Constantes.EDAD_MINIMA_ADULTO, Constantes.EDAD_MAXIMA_ADULTO),
					Situacion.trabajador);
			ser.setEdad((int) (Math.random() * (65 - 18) + 18));
			if (ser.getEdad() < ser.getEsperanzaVida()) {
				poblacion.add(ser);
				i++;
			}
		}
		for (int i = 0; i < 30;) {
			Seres ser = new Seres(Utiles.obtenerAleatorio(Constantes.EDAD_MINIMA_JUBILADO, Constantes.EDAD_MAXIMA),
					Situacion.jubilado);
			ser.setEdad((int) (Math.random() * (90 - 65) + 65));
			if (ser.getEdad() < ser.getEsperanzaVida()) {
				poblacion.add(ser);
				i++;
			}
		}
	}

	static class TestClass {
		@Test
		void Testnacer() {

		}

	}

	public void pagarNV() {
		pagarNVMenores();
		pagarDemandantes();
		pagarJubilados();
	}

	public void pagarNVMenores() {
		// Dinero que se le da a cada menor y se acumula en el ahorro

		float nv = 365;
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(Situacion.menor, contador);
		dineroTotalPagar = contador * nv;
		if (dineroEstado >= dineroTotalPagar) {
			for (int i = 0; i < this.poblacion.size(); i++) {
				if (this.poblacion.get(i).getTipoEstado().menor == poblacion.get(i).getTipoEstado().menor) {
					this.poblacion.get(i).setAhorro(nv);
				}
			}
		} else {
			float reparto = (float) (dineroEstado / listaMenores.size());
			for (int i = 0; i < this.poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().menor) {
					this.poblacion.get(i).setAhorro(reparto);
				}
			}
		}
	}

	public int contarTipoPersona(Situacion estado, int contador) {
		for (int i = 0; i < this.poblacion.size(); i++) {
			if (estado == this.poblacion.get(i).getTipoEstado()) {
				contador++;
			}
		}
		return contador;
	}

	public void pagarDemandantes() {
		// Dinero que se le da a cada demandante y se acumula en el ahorro
		float nv = 182.5f;
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(Situacion.parado, contador);
		dineroTotalPagar = contador * nv / 2;
		if (dineroEstado >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().parado) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + dineroTotalPagar);
				}
			}
		} else {
			float reparto = (float) (dineroEstado / contador);
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().parado) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	private float pedirAhorro(ArrayList<Seres> poblacion, int i) {
		return poblacion.get(i).getAhorro();
	}

	public void pagarJubilados() {
		// Dinero que se le da a cada jubilado y se acumula en el ahorro
		float nv = 182.5f;
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(Situacion.jubilado, contador);
		dineroTotalPagar = deberJubilados();
		if (dineroEstado >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().jubilado) {
					if (pedirAhorro(poblacion, i) < nv) {
						float pagar = nv - pedirAhorro(poblacion, i);
						poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + pagar);
					}
				}
			}
		} else {
			float reparto = (float) (dineroEstado / contarJubiladosMorosos());
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().jubilado
						&& pedirAhorro(poblacion, i) < nv) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	public float deberJubilados() {
		int contador = 0;
		float nv = 182.5f;
		float acumulador = 0;
		contador = contarTipoPersona(Situacion.jubilado, contador);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().jubilado) {
				if (pedirAhorro(poblacion, i) < nv) {
					float diferencia = nv - pedirAhorro(poblacion, i);
					acumulador += diferencia;
				}
			}
		}
		return acumulador;

	}

	public int contarJubiladosMorosos() {
		float nv = (float) listaJubilados.get(0).getTipoEstado().getNivelVida();
		int morosos = 0;
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getTipoEstado() == poblacion.get(i).getTipoEstado().jubilado) {
				if (poblacion.get(i).getAhorro() < nv) {
					morosos++;
				}
			}
		}
		return morosos;
	}

	public void reducirVida() {
		for (int i = 0; i < poblacion.size(); i++) {
			float nv = obtenerNivelVida(i);
			float ahorro = poblacion.get(i).getAhorro();
			float reduccion = 0.5f;
			if (poblacion.get(i).getAhorro() < nv) {
				if (ahorro == 0) {
					cambiarVida(i, reduccion);
				} else {
					float diferencia = nv - poblacion.get(i).getAhorro();
					float porcentaje = diferencia / nv;
					float resto = porcentaje * reduccion;
					cambiarVida(i, resto);
				}
			} else {
				poblacion.get(i).setAhorro(poblacion.get(i).getAhorro() - nv);
			}
		}
	}

	private float obtenerNivelVida(int i) {
		return (float) poblacion.get(i).getTipoEstado().getNivelVida();
	}

	private void cambiarVida(int i, float reduccion) {
		float esperanzaNueva = poblacion.get(i).getEsperanzaVida() - reduccion;
		poblacion.get(i).setEsperanzaVida(esperanzaNueva);
	}
}
