package pr06;

import java.util.HashMap;

public class Principal {

	public static final String alf = "abcdefghijklmnopqrstuvwwyzABCDEFGHIJKLMNOPQRSTUVWXYZ :.,;¿¡!";

	public static final int[] lista = { 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1,
			0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0,
			1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1,
			1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0,
			0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0,
			0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0,
			1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1,
			1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1,
			0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0,
			0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0,
			0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0,
			1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0,
			1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1,
			0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1,
			1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1,
			0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0,
			0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1,
			1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0,
			0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0,
			1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1,
			0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1,
			1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1,
			1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0,
			0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,
			1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0,
			0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0,
			0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0,
			1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1,
			1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
			1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1,
			1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0,
			0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0,
			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0,
			1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1,
			0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0,
			0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1,
			0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1,
			1, 0, 0, 1, 0, 1, 0, 1, 0 };

	public static final int[][] A = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 0, 1, 1 } };

	public static final int q = 2;

	public static void main(String[] args) {

		Principal objeto = new Principal();

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

		pr04.Principal pr04 = new pr04.Principal();

		int[][] codificacion = dividir(codigo, matrizA.length + matrizA[0].length);
		int[] cola = obtenerCola(codigo, matrizA.length + matrizA[0].length);

		int[][] matrizH = crearMatrizGDerecha(matrizNegativaTraspuesta(matrizA, q));

		int distancia = pr04.devolverDistanciaHamming(matrizA, q);
		int t = (distancia - 1) / 2;
		HashMap<int[], int[]> palabrasCodigoMenorPeso = obtenerTablaSindromes(matrizH, q, t);
		
		int[][] secuenciaDividida = // multiplicar H por lista Codificada 
				
				

		/*
		 * int[][] secuenciaDividida = seleccionarEnMatriz(codificacion, 0,
		 * matrizA.length);
		 * 
		 * int[] secuencia = fusionarMatrizYVector(secuenciaDividida, cola);
		 * 
		 * String palabra = descodificarTexto(secuencia, alfabeto, qario);
		 * 
		 * System.out.println("\nPalabra descodificada:\n"+palabra);
		 */
	}

	private HashMap<int[], int[]> obtenerTablaSindromes(int[][] matrizH, int q, int t) {
		pr04.Principal pr04 = new pr04.Principal();

		HashMap<int[], int[]> resultado = new HashMap<int[], int[]> ();

		int [][] palabrasCodigoLongitudK = pr04.rellenarVector(q, matrizH[0].length);

		for (int[] e: palabrasCodigoLongitudK) {
			int peso=0;

			for(int f : e) {
				if(f!=0) {
					peso+=1;
				}
			}
			if(peso<=t) {
				int[] sindrome = multiplicarMatrizPorVector(matrizH, e);
				resultado.put(e, sindrome);
			}
		}
		return resultado;
	}

	private int[] multiplicarMatrizPorVector(int[][] matriz, int[] vector) {

		int[] resultado = new int[matriz.length];

		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[0].length; y++) {
				
				resultado[x] += matriz[x][y] * vector[y];

			}
		}
		return resultado;
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

	public int[][] matrizNegativaTraspuesta(int[][] matrizA, int qario) {

		int[][] negativaTraspuesta = new int[matrizA[0].length][matrizA.length];

		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {

				negativaTraspuesta[j][i] = (qario - matrizA[i][j] % qario) % qario;
			}
		}

		return negativaTraspuesta;
	}

	public int[][] crearMatrizGDerecha(int[][] matrizA) {

		int[][] matrizG = new int[matrizA.length][matrizA[0].length + matrizA.length];

		int ordenIdentidad = matrizA.length;

		for (int i = 0; i < ordenIdentidad; i++) {
			for (int j = 0; j < matrizG[0].length; j++) {

				if (j >= matrizA[0].length) {
					if (j == i + matrizA[0].length) {
						matrizG[i][j] = 1;
					} else {
						matrizG[i][j] = 0;
					}
				} else {
					matrizG[i][j] = matrizA[i][j];
				}
			}

		}

		return matrizG;
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
	/*
	 * public int[][] matrizTraspuesta(int[][] matrizA) {
	 * 
	 * int[][] traspuesta = new int[matrizA[0].length][matrizA.length];
	 * 
	 * for (int i = 0; i < matrizA.length; i++) { for (int j = 0; j <
	 * matrizA[0].length; j++) {
	 * 
	 * traspuesta[j][i] = matrizA[i][j]; } }
	 * 
	 * return traspuesta; }
	 */

}
