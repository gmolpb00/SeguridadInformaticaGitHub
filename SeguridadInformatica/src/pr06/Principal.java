package pr06;

import java.util.HashMap;

public class Principal {

	public static final String alf = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ :.,;¿¡!()?";

	public static final int[] lista03 = { 2, 2, 1, 1, 1, 1, 0, 2, 2, 2, 1, 1, 1, 1, 0, 2, 2, 2, 0, 1, 0, 1, 1, 0, 2, 0,
			0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 0, 1, 2, 1, 0, 1, 0, 1, 1, 0, 0, 0, 2, 0, 2, 0, 1, 1, 2, 2, 2, 1, 2, 1,
			2, 1, 0, 2, 0, 1, 0, 1, 1, 0, 1, 2, 0, 2, 0, 2, 2, 0, 1, 2, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 0, 2, 2, 0, 2, 0,
			2, 0, 2, 0, 1, 1, 0, 2, 0, 2, 0, 2, 2, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 2, 2, 2, 2, 2, 2,
			0, 1, 2, 2, 2, 0, 2, 0, 1, 1, 2, 2, 0, 1, 0, 1, 1, 0, 0, 0, 0, 2, 0, 2, 2, 0, 0, 1, 2, 0, 2, 0, 1, 1, 2, 0,
			2, 1, 2, 1, 2, 1, 2, 2, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 2, 2, 2, 2,
			0, 1, 2, 0, 0, 1, 0, 1, 1, 0, 1, 2, 0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 2, 2, 0, 1, 2, 1, 2, 2, 2, 2, 0, 1, 1, 2,
			2, 0, 2, 0, 1, 1, 2, 0, 0, 2, 0, 2, 2, 0, 0, 1, 1, 1, 1, 1, 0, 2, 2, 2, 1, 1, 1, 1, 0, 2, 1, 0, 0, 1, 0, 1,
			1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 0, 1, 0, 0, 2, 1, 2, 1, 2, 1, 2, 2,
			2, 1, 2, 1, 2, 1, 2, 2, 2, 0, 2, 0, 1, 1, 2, 0, 0, 2, 0, 2, 2, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 0, 2, 1, 2, 1,
			2, 1, 0, 0, 2, 1, 2, 1, 2, 1, 1, 0, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 0, 2, 1, 2,
			1, 2, 1, 2, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 2, 1, 2, 1, 0, 0, 2, 1, 2, 1, 2, 1, 0, 1, 1, 1, 1, 1,
			0, 2, 0, 2, 0, 2, 0, 2, 2, 0 };

	public static final int[][] A3 = { { 1, 0, 1, 0, 2, 2 }, { 2, 1, 2, 1, 2, 1 } };

	public static final int q3 = 3;

	public static void main(String[] args) {

		Principal objeto = new Principal();

		objeto.descodificar(lista03, alf, A3, q3);

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
		pr05.Principal pr05 = new pr05.Principal();

		int[][] codificacion = dividir(codigo, matrizA.length + matrizA[0].length);
		int[] cola = obtenerCola(codigo, matrizA.length + matrizA[0].length);

		int[][] matrizH = crearMatrizGDerecha(matrizNegativaTraspuesta(matrizA, qario));

		int distancia = pr04.devolverDistanciaHamming(matrizA, qario);
		int t = (distancia - 1) / 2;
		HashMap<String, int[]> tablaSindromesIncompleta = obtenerTablaSindromes(matrizH, qario, t);

		int[][] sindromeCodigosAux = matrizTraspuesta(
				multiplicarMatrices(matrizH, matrizTraspuesta(codificacion), qario));// multiplicar H por lista
		// Codificada

		String[] sindromeCodigos = new String[sindromeCodigosAux.length];

		for (int i = 0; i < sindromeCodigosAux.length; i++) {
			String aux = "";
			for (int numero : sindromeCodigosAux[i]) {
				aux += numero;
			}
			sindromeCodigos[i] = aux;
		}

		int[][] erroresPatron = identificarErrorPatronSindrome(tablaSindromesIncompleta, sindromeCodigos);

		int[][] secuenciaDecodificadaConRuido = restarMatrices(codificacion, erroresPatron, qario);

		int[][] secuenciaDividida = pr05.seleccionarEnMatriz(secuenciaDecodificadaConRuido, 0, matrizA.length);
		
		int[] secuencia = pr05.fusionarMatrizYVector(secuenciaDividida, cola);

		String palabra = pr05.descodificarTexto(secuencia, alfabeto, qario);

		System.out.println("\nPalabra descodificada:\n" + palabra);

	}

	private int[][] restarMatrices(int[][] codificacion, int[][] erroresPatron, int qario) {

		int[][] resultado = new int[codificacion.length][codificacion[0].length];

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				// resultado[i][j] = codificacion[i][j] - erroresPatron[i][j];
				int temp = codificacion[i][j] - erroresPatron[i][j];
				resultado[i][j] = (temp > 0) ? temp : (qario + temp) % qario;
				// (qario - matrizA[i][j] % qario) % qario
			}
		}

		return resultado;
	}

	private int[][] identificarErrorPatronSindrome(HashMap<String, int[]> tablaSindromesIncompleta,
			String[] sindromeCodigos) {

		int[][] resultado = new int[sindromeCodigos.length][tablaSindromesIncompleta
				.get(tablaSindromesIncompleta.keySet().toArray()[0]).length];

		for (int i = 0; i < sindromeCodigos.length; i++) {
			resultado[i] = tablaSindromesIncompleta.get(sindromeCodigos[i]);
		}
		return resultado;
	}

	public int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2, int qario) {

		int[][] multiplicacion = new int[matriz1.length][matriz2[0].length];

		for (int x = 0; x < multiplicacion.length; x++) {
			for (int y = 0; y < multiplicacion[x].length; y++) {
				for (int z = 0; z < matriz1[0].length; z++) {
					multiplicacion[x][y] += matriz1[x][z] * matriz2[z][y];
				}
				multiplicacion[x][y] = multiplicacion[x][y] % qario;
			}
		}

		return multiplicacion;
	}

	private HashMap<String, int[]> obtenerTablaSindromes(int[][] matrizH, int qario, int t) {
		pr04.Principal pr04 = new pr04.Principal();

		HashMap<String, int[]> resultado = new HashMap<String, int[]>();

		int[][] palabrasCodigoLongitudK = pr04.rellenarVector(qario, matrizH[0].length);

		for (int[] e : palabrasCodigoLongitudK) {
			int peso = 0;

			for (int f : e) {
				if (f != 0) {
					peso += 1;
				}
			}
			if (peso <= t) {
				int[] sindrome = multiplicarMatrizPorVector(matrizH, e, qario);
				String aux = "";
				for (int numero : sindrome) {
					aux += numero;
				}
				resultado.put(aux, e);
			}
		}
		return resultado;
	}

	private int[] multiplicarMatrizPorVector(int[][] matriz, int[] vector, int qario) {

		int[] resultado = new int[matriz.length];

		for (int x = 0; x < matriz.length; x++) {
			for (int y = 0; y < matriz[0].length; y++) {

				resultado[x] += matriz[x][y] * vector[y];

			}
			resultado[x] = resultado[x] % qario;

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

	public int[][] matrizTraspuesta(int[][] matrizA) {

		int[][] traspuesta = new int[matrizA[0].length][matrizA.length];

		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {

				traspuesta[j][i] = matrizA[i][j];
			}
		}

		return traspuesta;
	}

}
