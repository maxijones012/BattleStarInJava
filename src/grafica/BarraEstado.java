package grafica;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.sun.javafx.tk.FontMetrics;

import logicaJuego.Elemento;
import logicaJuego.NaveCrazy;
import logicaJuego.NaveEcuatorial;
import logicaJuego.NaveGreenwich;
import logicaJuego.NaveManual;
import util.uDebugConsola;

@SuppressWarnings("serial")
public class BarraEstado extends JFrame{
	JTextArea texto = new JTextArea();
	
	public BarraEstado() {
		texto.setText("NAVE");
		Font fuente = new Font("font", Font.BOLD, 12);
		texto.setFont(fuente);
		texto.setForeground(Color.green);
		texto.setBackground(Color.black);
		this.getContentPane().setBackground(Color.black);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setTitle("PANEL DE ESTADO");
		this.setBounds(902, 50, 450, 300);
		this.setBackground(Color.black);
		this.setLayout(new FlowLayout());
		
	}

	
	/**
	 * agrega un texto a la barra de estado
	 * @param c
	 */
	private void agregarTexto(String c) {
		texto.setText(c);
		this.add(texto);
	}
	
	
//	private void agregarTexto(String c) {
//		texto.append("\n"+c);
//		this.add(texto);
//	}

	
	/**
	 * Actualiza el estado de las {@link Nave naves}
	 * 
	 * @see nivelDeVida
	 * @see nombreNave
	 * 
	 * @param listaElemento
	 */
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
