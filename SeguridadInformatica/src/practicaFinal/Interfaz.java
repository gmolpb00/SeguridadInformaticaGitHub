package practicaFinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textoEntropia;
	private JTextField matrizRedundancia;
	private JTextField vectorPrivado;
	private JTextField textoNumeropalabras;
	private JTextField textField_1;

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
		setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		setTitle("Simulador canal ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setJMenuBar(menuBar);
		
		JMenuItem botonLimpiar = new JMenuItem("limpiar");
		botonLimpiar.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		menuBar.add(botonLimpiar);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.focus"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_izquierdo = new JPanel();
		panel_izquierdo.setBorder(new EmptyBorder(0, 10, 0, 10));
		panel_izquierdo.setMaximumSize(new Dimension(300, 600));
		contentPane.add(panel_izquierdo, BorderLayout.WEST);
		panel_izquierdo.setLayout(new BorderLayout(10, 0));
		
		JPanel panel_3 = new JPanel();
		panel_izquierdo.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel dfslfabeto = new JLabel("Alfabeto");
		panel_3.add(dfslfabeto);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JTextArea textoEntrada = new JTextArea();
		JScrollPane scrollpaneR = new JScrollPane(textoEntrada);
		textoEntrada.setColumns(10);
		textoEntrada.setBackground(UIManager.getColor("Tree.selectionBackground"));
		textoEntrada.setRows(8);
		
		panel_izquierdo.add(scrollpaneR, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_izquierdo.add(panel_4, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Entropia");
		panel_4.add(lblNewLabel);
		
		textoEntropia = new JTextField();
		textoEntropia.setEditable(false);
		panel_4.add(textoEntropia);
		textoEntropia.setColumns(10);
		
		JPanel panel_central = new JPanel();
		panel_central.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BorderLayout(20, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_central.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_ruido = new JPanel();
		tabbedPane.addTab("Ruido", null, panel_ruido, null);
		panel_ruido.setLayout(new BorderLayout(5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Elige el % de ruido a simular");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ruido.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JSlider ruido = new JSlider();
		panel_ruido.add(ruido, BorderLayout.CENTER);
		ruido.setValue(10);
		ruido.setMaximum(100);
		ruido.setMinimum(0);
		
		JPanel panel_redundancia = new JPanel();
		tabbedPane.addTab("Redundancia", null, panel_redundancia, null);
		panel_redundancia.setLayout(new BorderLayout(0, 0));
		
		matrizRedundancia = new JTextField();
		matrizRedundancia.setText("Formato: [[A,B,C][A2,B2,B3]]");
		panel_redundancia.add(matrizRedundancia, BorderLayout.CENTER);
		matrizRedundancia.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Introduce matriz A.  ");
		panel_redundancia.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_cifrado = new JPanel();
		tabbedPane.addTab("Cifrado", null, panel_cifrado, null);
		panel_cifrado.setLayout(new BorderLayout(0, 0));
		
		JPanel privado = new JPanel();
		panel_cifrado.add(privado, BorderLayout.SOUTH);
		privado.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Vector codificacion");
		privado.add(lblNewLabel_6, BorderLayout.NORTH);
		
		vectorPrivado = new JTextField();
		privado.add(vectorPrivado, BorderLayout.SOUTH);
		vectorPrivado.setColumns(10);
		
		JPanel publico = new JPanel();
		panel_cifrado.add(publico, BorderLayout.CENTER);
		publico.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		publico.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("Elige cifrado publico");
		panel.add(lblNewLabel_5);
		
		JComboBox seleccionCifradoPublico = new JComboBox();
		panel.add(seleccionCifradoPublico);
		
		JPanel datosPublicaRSA = new JPanel();
		datosPublicaRSA.setVisible(false);
		publico.add(datosPublicaRSA, BorderLayout.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("Datos:");
		datosPublicaRSA.add(lblNewLabel_7);
		
		JPanel datosPublicaRSABloques = new JPanel();
		datosPublicaRSABloques.setVisible(false);
		publico.add(datosPublicaRSABloques);
		
		JLabel label = new JLabel("Datos:");
		datosPublicaRSABloques.add(label);
		
		JPanel eleccionCifrado = new JPanel();
		panel_cifrado.add(eleccionCifrado, BorderLayout.NORTH);
		
		JToggleButton togleEleccion = new JToggleButton("Publico / privado");
		eleccionCifrado.add(togleEleccion);
		
		JPanel panel_derecho = new JPanel();
		panel_derecho.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(panel_derecho, BorderLayout.EAST);
		panel_derecho.setLayout(new BorderLayout(10, 0));
		
		JPanel panel_derecho_izq = new JPanel();
		panel_derecho.add(panel_derecho_izq, BorderLayout.WEST);
		panel_derecho_izq.setLayout(new BorderLayout(8, 8));
		
		JLabel lblNewLabel_1 = new JLabel("Texto salida");
		panel_derecho_izq.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JTextArea textoSalida = new JTextArea(20,8);
		JScrollPane scrollpanea = new JScrollPane(textoSalida);

		textoSalida.setBackground(UIManager.getColor("Tree.selectionBackground"));

		textoSalida.setEditable(false);
		panel_derecho_izq.add(scrollpanea, BorderLayout.CENTER);
		
		JPanel panel_detalles = new JPanel();
		panel_derecho_izq.add(panel_detalles, BorderLayout.SOUTH);
		panel_detalles.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_detalles.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNumeroPalabras = new JLabel("Numero palabras");
		panel_1.add(lblNumeroPalabras);
		
		textoNumeropalabras = new JTextField();
		textoNumeropalabras.setEditable(false);
		textoNumeropalabras.setColumns(10);
		panel_1.add(textoNumeropalabras);
		
		JPanel panel_2 = new JPanel();
		panel_detalles.add(panel_2);
		
		JLabel lblNumeroerrores = new JLabel("Numero de errores");
		panel_2.add(lblNumeroerrores);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JPanel panel_derecho_der = new JPanel();
		panel_derecho.add(panel_derecho_der, BorderLayout.EAST);
		panel_derecho_der.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel_8 = new JLabel("Codigo no-arreglado/arreglado");
		panel_derecho_der.add(lblNewLabel_8, BorderLayout.NORTH);
		
		JTextArea codigoSinArreglar = new JTextArea();
		JScrollPane scrollpan = new JScrollPane(codigoSinArreglar);

		codigoSinArreglar.setBackground(UIManager.getColor("Button.focus"));
		codigoSinArreglar.setRows(15);
		codigoSinArreglar.setColumns(8);
		codigoSinArreglar.setEditable(false);
		panel_derecho_der.add(scrollpan, BorderLayout.CENTER);
		
		JTextArea codigoArreglado = new JTextArea();
		JScrollPane scrollpanA = new JScrollPane(codigoArreglado);

		codigoArreglado.setEditable(false);
		codigoArreglado.setBackground(UIManager.getColor("Button.focus"));
		codigoArreglado.setRows(15);
		codigoArreglado.setColumns(8);
		panel_derecho_der.add(scrollpanA, BorderLayout.SOUTH);
		
		JButton botonEmpezar = new JButton("Empezar");
		botonEmpezar.setBackground(new Color(143, 188, 143));
		contentPane.add(botonEmpezar, BorderLayout.SOUTH);
	}
}
