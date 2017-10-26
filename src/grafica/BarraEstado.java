package grafica;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import logicaJuego.AdministradorJuego;
import logicaJuego.Elemento;
import logicaJuego.Nave;
import logicaJuego.NaveCrazy;
import logicaJuego.NaveEcuatorial;
import logicaJuego.NaveGreenwich;
import logicaJuego.NaveManual;
import sun.security.jca.GetInstance.Instance;
import util.uDebugConsola;

public class BarraEstado extends JFrame{
	JTextArea texto = new JTextArea();
	
	public BarraEstado() {
		texto.setText("NAVE");
		this.setVisible(true);
		this.setBounds(902, 50, 250, 300);
		this.setBackground(Color.GREEN);
		this.setLayout(new FlowLayout());
		
	}

	private void agregarTexto(String c) {
		texto.setText(c);
		this.add(texto);
	}
	
	
//	private void agregarTexto(String c) {
//		texto.append("\n"+c);
//		this.add(texto);
//	}

	

	public void actualizar(ArrayList<Elemento> listaElemento) {
		String estado="";
		for (int i = 0; i < listaElemento.size(); i++) {
			Elemento e = listaElemento.get(i);
			if (e instanceof NaveManual) {
				NaveManual nave = (NaveManual) e;
				estado += (uDebugConsola.retornarNombreElemento(nave)+"\n"+uDebugConsola.mostrarEstado(nave));
				estado += "\n";
			}
			if (e instanceof NaveCrazy) {
				NaveCrazy nave = (NaveCrazy) e;
				estado += (uDebugConsola.retornarNombreElemento(nave)+"\n"+uDebugConsola.mostrarEstado(nave));
				estado += "\n";
			}
			if (e instanceof NaveEcuatorial) {
				NaveEcuatorial nave = (NaveEcuatorial) e;
				estado += (uDebugConsola.retornarNombreElemento(nave)+"\n"+uDebugConsola.mostrarEstado(nave));
				estado += "\n";
			}
			if (e instanceof NaveGreenwich) {
				NaveGreenwich nave = (NaveGreenwich) e;
				estado += (uDebugConsola.retornarNombreElemento(nave)+"\n"+uDebugConsola.mostrarEstado(nave));
				estado += "\n";
			}
		}
		this.agregarTexto(estado);
	}

	
	

}
