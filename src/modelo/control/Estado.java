package modelo.control;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import utilesglobal.Constantes;

public class Estado {

	ArrayList<Seres> listaMenores = new ArrayList<Seres>();
	ArrayList<Seres> listaAdultos = new ArrayList<Seres>();
	ArrayList<Seres> listaJubilados = new ArrayList<Seres>();

	ArrayList<Empresa> empresas = new ArrayList<Empresa>();

	private long dineroEstado = 100000;
	public int nacimientos = 0;
	private int jubilados = 0;
	private long identificador = 0;
	private long contadorMuertos = 0;

	public void nacer(int nacimientos) {
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
		for (int i = 0; i < listaAdultos.size(); i++) {
			if (listaAdultos.get(i).getEsperanzaVida() < listaAdultos.get(i).getEdad()) {
				listaAdultos.remove(i);
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
		// TODO
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
		// TODO
	}

	private void annadirEmpresa() {
		// TODO
	}

	private void eliminarEmpresa() {
		// TODO
	}

	private void jubilar() {
		for (Seres ser : listaAdultos) {
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

	private void crearSer() {
		// TODO
	}

	private void CrearSituacionInicial() {
		// TODO
	}

	static class TestClass {
		@Test
		void Testnacer() {

		}

	}
}
