package grafica.ingresoDatos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelIngresoDatos extends  JFrame{

	public PanelIngresoDatos() {
		this.setTitle("Panel Usuario");
		this.setVisible(true);
		this.setSize(400, 200);
		this.setLocation(900, 350);
		
		Container contenedor = new Container();
		contenedor.setLayout(new BorderLayout());
		
		ingresorDatos(contenedor);
		
	}

	
	
	
	
	private void ingresorDatos(Container contenedor) {
		JPanel panel =  new JPanel();
		panel.setSize(new Dimension(70, 70));
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		
		
		//---------------------------------------
		
		JTextField nombre = new JTextField();
		nombre.setVisible(true);
		nombre.setSize(new Dimension(60, 60));
		nombre.add(panel);
		
		nombre.getText();
		
		
		
		
		contenedor.add(panel);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
