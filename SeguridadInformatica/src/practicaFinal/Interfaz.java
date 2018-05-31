package practicaFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textoEntropia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setTitle("Simulador canal con ruido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem botonLimpiar = new JMenuItem("limpiar");
		menuBar.add(botonLimpiar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_izquierdo = new JPanel();
		panel.add(panel_izquierdo, BorderLayout.SOUTH);
		panel_izquierdo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_izquierdo.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel dfslfabeto = new JLabel("Alfabeto");
		panel_3.add(dfslfabeto);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JTextArea textoEntrada = new JTextArea();
		textoEntrada.setRows(10);
		panel_izquierdo.add(textoEntrada, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_izquierdo.add(panel_4, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Entropia");
		panel_4.add(lblNewLabel);
		
		textoEntropia = new JTextField();
		textoEntropia.setEditable(false);
		panel_4.add(textoEntropia);
		textoEntropia.setColumns(10);
		
		JPanel panel_central = new JPanel();
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_central.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_ruido = new JPanel();
		tabbedPane.addTab("Ruido", null, panel_ruido, null);
		
		JPanel panel_redundancia = new JPanel();
		tabbedPane.addTab("Redundancia", null, panel_redundancia, null);
		
		JPanel panel_cifrado = new JPanel();
		tabbedPane.addTab("Cifrado", null, panel_cifrado, null);
		
		JPanel panel_derecho = new JPanel();
		contentPane.add(panel_derecho, BorderLayout.EAST);
		panel_derecho.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_derecho_izq = new JPanel();
		panel_derecho.add(panel_derecho_izq, BorderLayout.WEST);
		panel_derecho_izq.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Texto salida");
		panel_derecho_izq.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JTextArea textoSalida = new JTextArea();
		textoSalida.setEditable(false);
		panel_derecho_izq.add(textoSalida, BorderLayout.CENTER);
		
		JPanel panel_derecho_der = new JPanel();
		panel_derecho.add(panel_derecho_der, BorderLayout.EAST);
		panel_derecho_der.setLayout(new BorderLayout(0, 0));
		
		JTextArea codigoSinArreglar = new JTextArea();
		codigoSinArreglar.setEditable(false);
		panel_derecho_der.add(codigoSinArreglar, BorderLayout.NORTH);
		
		JTextArea codigoArreglado = new JTextArea();
		panel_derecho_der.add(codigoArreglado, BorderLayout.SOUTH);
	}

}
