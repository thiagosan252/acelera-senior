package br.atos.impacta.controller;

import br.atos.impacta.view.MenuInicial;

public class Controlador {

	public void start() {
		
		System.out.println("Programa iniciando...");
		
		new MenuInicial().showMenu();
		System.out.println("Programa iniciado");
		
	}
}
