package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import configuracion.ConfiguracionInicial;
import logicaJuego.AdministradorJuego;
import logicaJuego.Elemento;
import sonido.uSonido;

@SuppressWarnings("serial")
public class vTableroJuego extends JFrame implements KeyListener{
	private TableroJuego tableroJuego;
	private AdministradorJuego administradorJuego;
	
	
	public vTableroJuego(AdministradorJuego administradorJuego) {
		this.administradorJuego=administradorJuego;
//		this.setAlwaysOnTop(true);
		this.setEnabled(true);
		this.setFocusTraversalKeysEnabled(true);
		this.setTitle("JUEGO FINAL 2017 JONES MAXI, CARLOS IRIGOYEN");
		this.tableroJuego = new TableroJuego(administradorJuego);

		Container contenedor = this.getContentPane(); //PANEL		
		contenedor.setLayout(new BorderLayout());		
		
//		Container contenedorpanel = this.getContentPane();
//		contenedorpanel.setLayout(new BorderLayout());
		
		agregarMenu(contenedor);
//		agregarPanel(contenedor);
		
		contenedor.add(tableroJuego, null);		 
		this.setSize(ConfiguracionInicial.ANCHO_ESCENARIO,ConfiguracionInicial.ALTO_ESCENARIO);			
		this.setVisible(true);
		tableroJuego.inicializar();
		
		
	}
//	
	
	
//	private void agregarPanel(Container contenedor) {
//		PanelStatus panelStatus = new PanelStatus();
//		panelStatus.setVisible(true);
//		panelStatus.setSize(new Dimension(30, 30));
//		
//		contenedor.add(panelStatus);
//	}

	
	/**
	 * Agregamos elementos menu al panel del juego
	 * @param contenedor
	 */
	public void agregarMenu(Container contenedor){
		//menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(160,20);
		
		JMenuItem mntmPausar = botonPausa();
		
		//AÑADIMOS EL BOTON DE PAUSA
		menuBar.add(mntmPausar);
		
		
		JMenuItem mntmReanudar = botonNoReanudar();
		
		menuBar.add(mntmReanudar);
		
		//LO AÑADIMOS AL CONTAINER
		contenedor.add(menuBar);
	}


	private JMenuItem botonNoReanudar() {
		JMenuItem mntmReanudar = new JMenuItem("Reanudar");
		mntmReanudar.setBackground(Color.black);
		mntmReanudar.setForeground(Color.red);
		mntmReanudar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				uSonido.reproducir("/sonido/pause.wav");
				for(int i=0; i<administradorJuego.getListaElemento().size(); i++){
					Elemento e1 = administradorJuego.getListaElemento().get(i);
					e1.getAdministradorJuego().setPausa(false);
				}
//				JOptionPane.showMessageDialog(tableroJuego, "JUEGO PAUSADO");
			}
		});
		return mntmReanudar;
	}


	/**
	 * boton de pausa del juego
	 * @return
	 */
	private JMenuItem botonPausa() {
		JMenuItem mntmPausar = new JMenuItem("Pausar");
		mntmPausar.setBackground(Color.black);
		mntmPausar.setForeground(Color.green);
		mntmPausar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uSonido.reproducir("/sonido/pause.wav");
				for(int i=0; i<administradorJuego.getListaElemento().size(); i++){
					Elemento e1 = administradorJuego.getListaElemento().get(i);
					e1.getAdministradorJuego().setPausa(true);
				}
//				JOptionPane.showMessageDialog(tableroJuego, "JUEGO PAUSADO");
			}
		});
		return mntmPausar;
	}


	public void actualizar(AdministradorJuego administradorJuego) {
		this.tableroJuego.actualizar();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}
