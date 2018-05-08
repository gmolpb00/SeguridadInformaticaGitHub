package pr05;

import java.util.Arrays;

public class Principal {

	public static final String alf = "abcde ABCDEfghijklmnFGHIJKLMNopqrstuvwxyzOPQRSTUVWXYZ.,;¿?¡!";

	public static final int[] lista = { 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1,
			0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0,
			0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1,
			0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0,
			1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1,
			1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1,
			0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0,
			0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1,
			0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0,
			1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1,
			1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1,
			0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1,
			1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0,
			1 };

	public static final int[][] A = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 } };

	public static final int q = 2;

	public static void main(String[] args) {

		Principal objeto = new Principal();

		objeto.codificar("ac!", alf, A, q);
		System.out.println();
		System.out.println();
		objeto.descodificar(lista, alf, A, q);
	}

	public void descodificar(int[] codigo, String alfabeto, int[][] matrizA, int qario) {

		System.out.println("Se descodificará un codigo en base a un alfabeto");
		System.out.print("Codificacion: \t");
		for (int i = 0; i < codigo.length; i++) {
			System.out.print(codigo[i] + " ");
		}
		System.out.println();
		System.out.println("Alfabeto:\t" + alfabeto);

		int[][] codificacion = dividir(codigo, matrizA.length + matrizA[0].length);
		int[] cola = obtenerCola(codigo, matrizA.length + matrizA[0].length);

		int[][] secuenciaDividida = seleccionarEnMatriz(codificacion, 0, matrizA.length);

		int[] secuencia = fusionarMatrizYVector(secuenciaDividida, cola);

		String palabra = descodificarTexto(secuencia, alfabeto, qario);

		System.out.println("\nPalabra descodificada:\n" + palabra);

	}

	public void codificar(String palabra, String alfabeto, int[][] matrizA, int qario) {
		System.out.println("Se codificará una palabra en base a un alfabeto");
		System.out.println("Palabra:\t" + palabra);
		System.out.println("Alfabeto:\t" + alfabeto);

		pr04.Principal pr04 = new pr04.Principal();

		int[][] matrizG = pr04.crearMatrizGIzquierda(matrizA);

		int[] secuencia = codificarTexto(palabra, alfabeto, qario);

		int[][] secuenciaDividida = dividir(secuencia, matrizA.length);

		int[] cola = obtenerCola(secuencia, matrizA.length);

		int[][] codificado = pr04.crearPalabrasCodigo(matrizG, secuenciaDividida, qario);

		int[] codigo = fusionarMatrizYVector(codificado, cola);

		System.out.println("\nCodigo codificado: ");
		for (int i = 0; i < codigo.length; i++) {
			System.out.print(codigo[i] + " ");
		}
		System.out.println();

	}

	public String descodificarTexto(int[] secuencia, String alf, int qario) {

		pr04.Principal pr04 = new pr04.Principal();

		int longitudSimbolos = (int) Math.ceil((Math.log(alf.length()) / Math.log(2)));

		int[][] simbolosCodificados = pr04.rellenarVector(qario, longitudSimbolos);

		String resultado = "";

		int[] aux = new int[longitudSimbolos];

		for (int i = 0; i < secuencia.length; i++) {
			aux[i % longitudSimbolos] = secuencia[i];

			if (i % longitudSimbolos == longitudSimbolos - 1) {
				for (int j = 0; j < simbolosCodificados.length; j++) {
					if (Arrays.equals(aux, simbolosCodificados[j])) {
						resultado += alf.charAt(j);
						break;
					}
				}
			}
		}
		return resultado;
	}

	public int[] codificarTexto(String palabras, String alf, int qario) {
		// System.out.println("PREcodificarTexto: " + palabras + " " + alf +
		// "simbolos");
		// imprimirDobleArray(simbolosCodificados);
		pr04.Principal pr04 = new pr04.Principal();

		int longitudSimbolos = (int) Math.ceil((Math.log(alf.length()) / Math.log(2)));

		int[][] simbolosCodificados = pr04.rellenarVector(qario, longitudSimbolos);

		int[] resultado = new int[simbolosCodificados[0].length * palabras.length()];
		int contador = 0;

		for (int i = 0; i < palabras.length(); i++) {
			for (int j = 0; j < alf.length(); j++) {
				if (palabras.charAt(i) == alf.charAt(j)) {
					for (int e : simbolosCodificados[j]) {
						resultado[contador] = e;
						contador++;
					}
					break;
				}
			}
		}

		// System.out.println("codificarTexto: ");
		// for (int e : resultado)
		// System.out.print(e);

		return resultado;
	}

	public int[][] seleccionarEnMatriz(int[][] matriz, int desde, int hasta) {

		int[][] resultado = new int[matriz.length][hasta - desde];

		for (int i = 0; i < resultado.length; i++) {
			int x = 0;
			for (int j = desde; j < hasta; j++) {
				resultado[i][x] = matriz[i][j];
				x++;
			}
		}
		return resultado;
	}

	public int[] fusionarMatrizYVector(int[][] matriz, int[] vector) {
		int[] fusion;

		if (vector != null) {
			fusion = new int[vector.length + (matriz.length * matriz[0].length)];
		} else {
			fusion = new int[matriz.length * matriz[0].length];
		}
		int x = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				fusion[x] = matriz[i][j];
				x++;
			}
		}
		if (vector != null) {
			for (int e : vector) {
				fusion[x] = e;
				x++;
			}
		}

		return fusion;
	}

	

	private int[][] dividir(int[] codificado, int length) {
		// System.out.println("PRE division: ");
		// for (int e : codificado)
		// System.out.print(e);

		int num = codificado.length / length;
		int[][] resultado = new int[num][length];

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < length; j++) {
				resultado[i][j] = codificado[length * i + j];
			}
		}
		// System.out.println("\ndivision: ");
		// imprimirDobleArray(resultado);

		return resultado;
	}

	private int[] obtenerCola(int[] secuencia, int length) {

		int[] cola = null;
		int resto = secuencia.length % length;

		if (resto != 0) {
			cola = new int[resto];
			for (int i = 0; i < resto; i++) {
				cola[i] = secuencia[secuencia.length - resto + i];
			}
		}

		return cola;
	}

	public void imprimirDobleArray(int[][] codificado) {
		for (int i = 0; i < codificado.length; i++) {
			for (int j = 0; j < codificado[0].length; j++) {
				System.out.print(codificado[i][j]);
				System.out.print(" ");
			}
			System.out.println();

		}
	}

}
