package practicaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.Box;
import javax.swing.JButton;
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
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textoAlfabeto;
	private JTextField textoEntropia;
	private JTextField matrizRedundancia;
	private JTextField clavePrivado;
	private JTextField textoNumeropalabras;
	private JTextField textField_1;
	private JTextField textoN;
	private JTextField textoE;
	public String rsa = "rsa";
	public String rsaBloques = "rsa por bloques";
	private boolean flagPublico = true;
	public JToggleButton togleEleccion;
	public JPanel datosPublicaRSA;
	protected JTextArea textoEntrada;
	private JTextField textoFactor1;
	private JTextField textoFactor2;
	public JPanel publico;
	private JTextField textoQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();

					frame.setVisible(true);
					frame.togleEleccion.doClick();
					frame.publico.setVisible(false);
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
		panel_izquierdo.setMaximumSize(new Dimension(500, 600));
		contentPane.add(panel_izquierdo, BorderLayout.WEST);
		panel_izquierdo.setLayout(new BorderLayout(10, 0));

		textoEntrada = new JTextArea("patata? 123456");
		JScrollPane scrollpaneR = new JScrollPane(textoEntrada);
		textoEntrada.setColumns(12);
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
								
								JPanel panel_10 = new JPanel();
								panel_izquierdo.add(panel_10, BorderLayout.NORTH);
								panel_10.setLayout(new BorderLayout(0, 0));
										
										JPanel panel_11 = new JPanel();
										panel_10.add(panel_11, BorderLayout.SOUTH);
										panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
										
										JLabel lblQ = new JLabel("           Q");
										panel_11.add(lblQ);
										
										textoQ = new JTextField("");
										textoQ.setColumns(10);
										panel_11.add(textoQ);
								
										JPanel panel_3 = new JPanel();
										panel_10.add(panel_3);
										panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
										
												JLabel dfslfabeto = new JLabel("Alfabeto");
												panel_3.add(dfslfabeto);
												
														textoAlfabeto = new JTextField(
																"abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ0123456789 ,.:-¿?()");
														panel_3.add(textoAlfabeto);
														textoAlfabeto.setColumns(10);

		JPanel panel_central = new JPanel();
		panel_central.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BorderLayout(20, 0));

		Component rigidArea = Box.createRigidArea(new Dimension(20, 30));
		panel_central.add(rigidArea, BorderLayout.SOUTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_central.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_ruido = new JPanel();
		tabbedPane.addTab("Ruido", null, panel_ruido, null);
		panel_ruido.setLayout(new BorderLayout(5, 5));

		JLabel lblNewLabel_2 = new JLabel("Elige el % de ruido a simular");
		// lblNewLabel_2.setLocation(5, 15);
		lblNewLabel_2.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ruido.add(lblNewLabel_2, BorderLayout.NORTH);

		JSlider ruido = new JSlider();
		ruido.setOrientation(SwingConstants.VERTICAL);
		panel_ruido.add(ruido, BorderLayout.CENTER);
		ruido.setValue(10);
		ruido.setMaximum(100);
		ruido.setMinimum(0);

		JPanel panel_redundancia = new JPanel();
		tabbedPane.addTab("Redundancia", null, panel_redundancia, null);
		panel_redundancia.setLayout(new BorderLayout(0, 0));

		matrizRedundancia = new JTextField();
		matrizRedundancia.setText("[[1,1,0],[1,0,1]]");
		panel_redundancia.add(matrizRedundancia, BorderLayout.CENTER);
		matrizRedundancia.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Introduce matriz A.  ");
		panel_redundancia.add(lblNewLabel_3, BorderLayout.NORTH);
		JPanel panel_cifrado = new JPanel();
		tabbedPane.addTab("Cifrado", null, panel_cifrado, null);
		panel_cifrado.setLayout(new BorderLayout(0, 0));

		JPanel privado = new JPanel();
		panel_cifrado.add(privado, BorderLayout.SOUTH);
		privado.setLayout(new BorderLayout(0, 20));

		JLabel lblNewLabel_6 = new JLabel("Clave cifrado");
		privado.add(lblNewLabel_6, BorderLayout.NORTH);

		clavePrivado = new JTextField("K,j8aj(8aÍ¿j¿0j7C0j8a1:aij7C0j0¿:Ó14j0¿1Cj¿8j(,-1a?4h");
		privado.add(clavePrivado, BorderLayout.SOUTH);
		clavePrivado.setColumns(10);

		publico = new JPanel();
		panel_cifrado.add(publico, BorderLayout.CENTER);
		publico.setLayout(new BorderLayout(0, 0));
		datosPublicaRSA = new JPanel();

		publico.add(datosPublicaRSA, BorderLayout.CENTER);
		datosPublicaRSA.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("Datos RSA en bloques:");
		datosPublicaRSA.add(lblNewLabel_7, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		datosPublicaRSA.add(panel, BorderLayout.NORTH);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JLabel lblNewLabel_4 = new JLabel("N  ");
		panel_5.add(lblNewLabel_4);

		textoN = new JTextField("62439738695706104201747");
		panel_5.add(textoN);
		textoN.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		JLabel E = new JLabel("E");
		panel_6.add(E);

		textoE = new JTextField("356812573");
		panel_6.add(textoE);
		textoE.setColumns(10);

		JPanel panel_7 = new JPanel();
		datosPublicaRSA.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);

		JLabel lblFactor = new JLabel("Factor 1");
		panel_8.add(lblFactor);

		textoFactor1 = new JTextField("249879448303");
		textoFactor1.setColumns(10);
		panel_8.add(textoFactor1);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);

		JLabel lblFactor_1 = new JLabel("Factor 2");
		panel_9.add(lblFactor_1);

		textoFactor2 = new JTextField("249879448349");
		textoFactor2.setColumns(10);
		panel_9.add(textoFactor2);

		JPanel eleccionCifrado = new JPanel();
		panel_cifrado.add(eleccionCifrado, BorderLayout.NORTH);

		togleEleccion = new JToggleButton("Publico / privado");
		eleccionCifrado.add(togleEleccion);
		togleEleccion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				privado.setVisible(flagPublico);
				publico.setVisible(!flagPublico);
				flagPublico = !flagPublico;
			}
		});

		JPanel panel_derecho = new JPanel();
		panel_derecho.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(panel_derecho, BorderLayout.EAST);
		panel_derecho.setLayout(new BorderLayout(10, 0));

		JPanel panel_derecho_izq = new JPanel();
		panel_derecho.add(panel_derecho_izq, BorderLayout.WEST);
		panel_derecho_izq.setLayout(new BorderLayout(8, 8));

		JLabel lblNewLabel_1 = new JLabel("Texto salida");
		panel_derecho_izq.add(lblNewLabel_1, BorderLayout.NORTH);

		JTextArea textoSalida = new JTextArea(20, 8);
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
		scrollpanA.setViewportBorder(new EmptyBorder(0, 0, 15, 0));

		codigoArreglado.setEditable(false);
		codigoArreglado.setBackground(UIManager.getColor("Button.focus"));
		codigoArreglado.setRows(15);
		codigoArreglado.setColumns(8);
		panel_derecho_der.add(scrollpanA, BorderLayout.SOUTH);

		JButton botonEmpezar = new JButton("Empezar");
		botonEmpezar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				RSA rsa = new RSA();
				Vigenere vigenere = new Vigenere();
				CodigosCorrectores codigosCorrectores = new CodigosCorrectores();

				String alf = null;
				int porcentajeRuido = 0;
				int[][] matrizA = null;
				String claveCifrado = null;
				BigInteger nValor = null;
				BigInteger eValor = null;
				BigInteger factorn1Valor = null;
				BigInteger factorn2Valor = null;

				try {

					alf = textoAlfabeto.getText();
					porcentajeRuido = ruido.getValue();
					matrizA = stringADobleArray(matrizRedundancia.getText());
					claveCifrado = clavePrivado.getText();
					nValor = new BigInteger(textoN.getText());
					eValor = new BigInteger(textoE.getText());
					factorn1Valor = new BigInteger(textoFactor1.getText());
					factorn2Valor = new BigInteger(textoFactor2.getText());

				} catch (Exception e1) {

					System.err.println("Se han de rellenar todos los campos");
				}

				String mensajeEnClaro = textoEntrada.getText();

				boolean esPrivado = togleEleccion.isSelected();

				String cifradoSinRuidoPrevio = "";

				if (esPrivado) {
					cifradoSinRuidoPrevio = vigenere.cifrarMensajeEnClaro(mensajeEnClaro, alf, claveCifrado);
				} else {
					cifradoSinRuidoPrevio = rsa.codificarRSABloque(mensajeEnClaro, alf, eValor, nValor);
				}

				int[] cifradoConRuido = codigosCorrectores.codificarConRuido(cifradoSinRuidoPrevio, alf, matrizA, 2,
						porcentajeRuido);

				String cifradoSinRuidoPosterior = codigosCorrectores.descodificarConRuido(cifradoConRuido, alf, matrizA,
						2);

				String mensajeDescifrado = "";

				if (esPrivado) {
					mensajeDescifrado = vigenere.descifrarClaveCifrado(cifradoSinRuidoPosterior, alf, claveCifrado);
				} else {
					mensajeDescifrado = rsa.descodificarRSABloque(cifradoSinRuidoPosterior, alf, eValor, nValor,
							factorn1Valor, factorn2Valor);
				}
				System.out.println(mensajeDescifrado);

				textoSalida.setText(mensajeDescifrado);
				codigoArreglado.setText(cifradoSinRuidoPosterior);

				String aux = "";
				for (int x : cifradoConRuido) {
					aux += String.valueOf(x);
				}
				codigoSinArreglar.setText(cifradoSinRuidoPrevio);
			}
		});
		botonEmpezar.setBackground(new Color(143, 188, 143));
		contentPane.add(botonEmpezar, BorderLayout.SOUTH);
		botonLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textoSalida.setText("");
				textoE.setText("");
				textoEntrada.setText("");
				textoEntropia.setText("");
				textoN.setText("");
				textoNumeropalabras.setText("");
				codigoArreglado.setText("");
				codigoSinArreglar.setText("");
			}
		});
	}

	public static void imprimirDobleArray(int[][] codificado) {
		for (int i = 0; i < codificado.length; i++) {
			for (int j = 0; j < codificado[0].length; j++) {
				System.out.print(codificado[i][j]);
				System.out.print(" ");
			}
			System.out.println();

		}
	}

	public int[][] stringADobleArray(String original) {

		original = original.replace("[", "");
		original = original.replace(" ", "");
		int filas = (int) (original.chars().filter(ch -> ch == ']').count() - 1);
		int columnas = (int) ((original.chars().filter(ch -> ch == ',').count() + 1) / filas);

		original = original.replace("]", "");

		int[][] resultado = new int[filas][columnas];

		String[] tokens = original.split(",");

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = Integer.valueOf(tokens[i * j + j]);
			}
		}

		return resultado;
		/*
		 * StringBuilder avanzado = new StringBuilder(original); long count =
		 * original.chars().filter(ch -> ch == '[').count(); int contador = 0; for (int
		 * o = 0; o < original.length(); o++) { if (original.charAt(0) != '[' &&
		 * original.charAt(0) != ']') contador++; if (original.charAt(0) == ']') {
		 * break; } } char e = ' '; String nuevo = original.replace('[', e);
		 * System.out.println(count);System.out.println(contador); int[][] resultado =
		 * new int[(int) count - 1][contador]; int indice = 0; for (int i = 0; i < (int)
		 * count - 1; i++) { for (int j = 0; j < contador; j++) { while
		 * (nuevo.charAt(indice) == ' ') { indice++; } resultado[i][j] =
		 * nuevo.charAt(indice); System.out.println("a"); indice++; } } return
		 * resultado;
		 */
	}
}
