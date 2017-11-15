package grafica.ingresoDatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sun.webkit.ContextMenu.ShowContext;

import javafx.scene.text.Text;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Box;
import java.awt.Font;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class PantallaDatosUsuario extends JFrame implements KeyListener {
	private ArrayList<String> listaJugadores = new ArrayList<>();

	private JPanel contentPane;
	private JTextField txtIngreseSuNombre;
	private JTextField TextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDatosUsuario frame = new PantallaDatosUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaDatosUsuario() {
		setTitle("Puntuacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 350, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		contentPane.add(panel, BorderLayout.CENTER);

		cartelBienvenido(panel);
		
		panelIngresoNombre(panel);
		
		areaTextoIngresoNombre(panel);



	
	}

	/**
	 * setea los tamanios del cartel 
	 * @param panel
	 */
	private void cartelBienvenido(JPanel panel) {
		JTextArea txtpnBienvenido = new JTextArea();
		txtpnBienvenido.setEditable(false);
		txtpnBienvenido.setBackground(Color.BLUE);
		Font fuente = new Font("Tahoma", Font.PLAIN, 33);
		txtpnBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtpnBienvenido.setText("        Bienvenido         ");
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.black);
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.add(txtpnBienvenido);
	}

	
	/**
	 * controla el ingreso de de los datos del jugador
	 * @param panel
	 */
	private void areaTextoIngresoNombre(JPanel panel) {

		TextArea = new JTextField();
		TextArea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String aux = TextArea.getText();
				System.out.println(TextArea.getText());
				if ((JOptionPane.showInputDialog("Confirma ingresar jugador?", aux) != null)&&(!aux.isEmpty())){
					listaJugadores.add(aux);
					guardarDatos(aux);
				}else
					System.err.println("WARNING! ERROR CADENA INGRESADA VACIA");
			}

		});
		panel.add(TextArea);
		TextArea.setColumns(15);
		
	}

	private void guardarDatos(String aux) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * panel donde muestra un mensaje 
	 * @param panel
	 */
	private void panelIngresoNombre(JPanel panel) {
		txtIngreseSuNombre = new JTextField();
		txtIngreseSuNombre.setForeground(Color.green);
		txtIngreseSuNombre.setBackground(Color.black);
		panel.add(txtIngreseSuNombre);
		txtIngreseSuNombre.setFont(new Font("n", Font.ROMAN_BASELINE, 16));
		txtIngreseSuNombre.setText("Ingrese su nombre");
		txtIngreseSuNombre.setColumns(18);
		
	}

	public ArrayList<String> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<String> listaJugadores) {
		this.listaJugadores = listaJugadores;
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
