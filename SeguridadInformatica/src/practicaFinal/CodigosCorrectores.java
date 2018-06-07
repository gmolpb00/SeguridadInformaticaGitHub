package practicaFinal;

import java.util.Arrays;
import java.util.HashMap;

public class CodigosCorrectores {

	public String descodificarConRuido(int[] codigo, String alfabeto, int[][] matrizA, int qario) {

		int[][] codificacion = dividirVectorPorMatriz(codigo, matrizA.length + matrizA[0].length);
		int[] cola = obtenerColaDivisionVectorPorMatriz(codigo, matrizA.length + matrizA[0].length);

		int[][] matrizH = crearMatrizGDerecha(matrizNegativaTraspuesta(matrizA, qario));

		int distancia = devolverDistanciaHamming(matrizA, qario);
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

		int[][] secuenciaDividida = seleccionarEnMatriz(secuenciaDecodificadaConRuido, 0, matrizA.length);

		int[] secuencia = fusionarMatrizYVector(secuenciaDividida, cola);

		String palabra = descodificarTexto(secuencia, alfabeto, qario);

		return palabra;

	}

	public int[] codificarConRuido(String palabra, String alfabeto, int[][] matrizA, int qario, int porcentajeRuido) {

		int[][] matrizG = crearMatrizGIzquierda(matrizA);

		int[] secuencia = codificarTexto(palabra, alfabeto, qario);

		int[][] secuenciaDividida = dividirVectorPorMatriz(secuencia, matrizA.length);

		int[] cola = obtenerColaDivisionVectorPorMatriz(secuencia, matrizA.length);

		int[][] codificado = crearPalabrasCodigo(matrizG, secuenciaDividida, qario);

		int[] codigoLimpio = fusionarMatrizYVector(codificado, cola);

		int[] codigoSucio = ruidoAlCodigo(codigoLimpio, porcentajeRuido, qario);

		return codigoSucio;
	}

	private int[] ruidoAlCodigo(int[] codigoLimpio, int porcentajeRuido, int q) {

		int[] solucion = new int[codigoLimpio.length];

		int porcentajeRandom;
		int valorRandom;

		for (int i = 0; i < codigoLimpio.length; i++) {
			porcentajeRandom = (int) Math.random() * 100;

			if (porcentajeRandom < porcentajeRuido) {
				valorRandom = (int) Math.random() * q;
				solucion[i] = valorRandom;
			} else {
				solucion[i] = codigoLimpio[i];
			}

		}

		return solucion;
	}

	private String descodificarTexto(int[] secuencia, String alf, int qario) {

		int longitudSimbolos = (int) Math.ceil((Math.log(alf.length()) / Math.log(qario)));

		int[][] simbolosCodificados = rellenarVector(qario, longitudSimbolos);
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

	private int[] codificarTexto(String palabras, String alf, int qario) {

		int longitudSimbolos = (int) Math.ceil((Math.log(alf.length()) / Math.log(2)));

		int[][] simbolosCodificados = rellenarVector(qario, longitudSimbolos);

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

	private HashMap<String, int[]> obtenerTablaSindromes(int[][] matrizH, int qario, int t) {

		HashMap<String, int[]> resultado = new HashMap<String, int[]>();

		int[][] palabrasCodigoLongitudK = rellenarVector(qario, matrizH[0].length);

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

	private int devolverDistanciaHamming(int[][] matrizA, int qario) {

		int[][] matrizG;

		matrizG = crearMatrizGIzquierda(matrizA);

		int[][] vectoresMultiplicacion = rellenarVector(qario, matrizG.length);

		int[][] listaPalabrasCodigo = crearPalabrasCodigo(matrizG, vectoresMultiplicacion, qario);

		int distancia = calcularHamming(listaPalabrasCodigo);

		return distancia;

	}

	private int calcularHamming(int[][] listaPalabrasCodigo) {

		int resultado = listaPalabrasCodigo[0].length;

		for (int i = 0; i < listaPalabrasCodigo.length; i++) {
			int[] palabra = listaPalabrasCodigo[i];

			for (int x = i; x < listaPalabrasCodigo.length; x++) {
				int temp = 0;

				for (int j = 0; j < listaPalabrasCodigo[0].length; j++) {
					if (palabra[j] != listaPalabrasCodigo[x][j]) {
						temp++;
					}
				}
				if (temp != 0)
					resultado = (temp < resultado) ? temp : resultado;
			}
		}
		return resultado;
	}

	private int[][] crearPalabrasCodigo(int[][] matrizG, int[][] vectoresMultiplicacion, int qario) {

		int[][] resultado = new int[vectoresMultiplicacion.length][matrizG[0].length];

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				for (int k = 0; k < vectoresMultiplicacion[0].length; k++) {

					resultado[i][j] += vectoresMultiplicacion[i][k] * matrizG[k][j];
				}
				resultado[i][j] = resultado[i][j] % qario;

			}

		}
		return resultado;
	}

	private int[][] rellenarVector(int qario, int k) {

		int[][] resultado = new int[(int) Math.pow(qario, k)][k];
		int[] inicial = new int[k];

		for (int t = 0; t < k; t++)
			inicial[t] = 0;

		for (int i = 0; i < resultado.length; i++) {

			resultado[i] = inicial.clone(); // recorro vertical
			inicial = incrementa(inicial, qario); // recorro horizontal

		}

		return resultado;
	}

	private int[] incrementa(int[] inicial, int qario) {
		int tamano = inicial.length - 1;
		boolean fin = false;

		do {

			if (inicial[tamano] == qario - 1) {
				inicial[tamano] = 0;
			} else {
				inicial[tamano]++;
				fin = true;
			}
			tamano--;
		} while (!fin && tamano >= 0);

		return inicial;
	}

	private int[][] restarMatrices(int[][] codificacion, int[][] erroresPatron, int qario) {

		int[][] resultado = new int[codificacion.length][codificacion[0].length];

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				int temp = codificacion[i][j] - erroresPatron[i][j];
				resultado[i][j] = (temp > 0) ? temp : (qario + temp) % qario;
			}
		}

		return resultado;
	}

	private int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2, int qario) {

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

	private int[] fusionarMatrizYVector(int[][] matriz, int[] vector) {
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

	private int[][] dividirVectorPorMatriz(int[] codificado, int length) {

		int num = codificado.length / length;
		int[][] resultado = new int[num][length];

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < length; j++) {
				resultado[i][j] = codificado[length * i + j];
			}
		}

		return resultado;
	}

	private int[] obtenerColaDivisionVectorPorMatriz(int[] secuencia, int length) {

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

	private int[][] crearMatrizGIzquierda(int[][] matrizA) {

		int[][] matrizG = new int[matrizA.length][matrizA[0].length + matrizA.length];

		int ordenIdentidad = matrizA.length;

		for (int i = 0; i < ordenIdentidad; i++) {
			for (int j = 0; j < matrizG[0].length; j++) {

				if (j < ordenIdentidad) {
					if (j == i) {
						matrizG[i][j] = 1;
					} else {
						matrizG[i][j] = 0;
					}
				} else {
					matrizG[i][j] = matrizA[i][j - ordenIdentidad];
				}
			}

		}

		return matrizG;
	}

	private int[][] crearMatrizGDerecha(int[][] matrizA) {

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

	private int[][] matrizTraspuesta(int[][] matrizA) {

		int[][] traspuesta = new int[matrizA[0].length][matrizA.length];

		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {

				traspuesta[j][i] = matrizA[i][j];
			}
		}

		return traspuesta;
	}

	private int[][] matrizNegativaTraspuesta(int[][] matrizA, int qario) {

		int[][] negativaTraspuesta = new int[matrizA[0].length][matrizA.length];

		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[0].length; j++) {

				negativaTraspuesta[j][i] = (qario - matrizA[i][j] % qario) % qario;
			}
		}

		return negativaTraspuesta;
	}

	private int[][] seleccionarEnMatriz(int[][] matriz, int desde, int hasta) {

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

}
