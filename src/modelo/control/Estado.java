package modelo.control;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import utilesglobal.Constantes;

public class Estado {

	ArrayList<Seres> listaMenores = new ArrayList<Seres>();
	ArrayList<Seres> listaAdultos = new ArrayList<Seres>();
	ArrayList<Seres> listaJubilados= new ArrayList<Seres>();
	
	ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	
	private long dineroEstado=100000;
	public int nacimientos=0;
	private int jubilados=0;
	private long identificador=0;
	
	public void nacer(int nacimientos) {
		for (int i = 0; nacimientos==i ; i++) {
			Seres menor = new Seres(identificador++, Constantes.EDAD_NACIMIENTO, Constantes.AHORROS_INICIALES);
			listaMenores.add(menor);
		}
	}
	
	private void morir() {
		
	}
	
	private void aumentarAnno() {
		//TODO
	}
	
	private void incrementarProduccion() {
		//TODO
	}
	
	private void decrementarProduccion() {
		//TODO
	}
	
	private void subsidio() {
		//TODO
	}
	
	private void pagarTrabajador() {
		//TODO
	}
	
	private void annadirEmpresa() {
		//TODO
	}
	
	private void eliminarEmpresa() {
		//TODO
	}
	
	static class TestClass {
		@Test
		void Testnacer() {
			
		}
		
		
	}
}
