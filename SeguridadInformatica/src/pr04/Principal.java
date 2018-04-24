package pr04;

public class Principal {

	 public static final int[][] A2 = { { 0, 2, 1, 1 }, { 1, 1, 2, 1 }, { 1, 1, 1,
	 2 } };

	public static final int[][] A = { { 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
			{ 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 }, { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1 }, { 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 } };

	public static final int q = 2;

	public static void main(String[] args) {

		Principal objeto = new Principal();

		objeto.devolverDistanciaHamming(A, q);
	}

	public int devolverDistanciaHamming(int[][] matrizA, int qario) {

		int[][] matrizG;

		matrizG = crearMatrizGIzquierda(matrizA);

		int[][] vectoresMultiplicacion = rellenarVector(qario, matrizG.length);

		int[][] listaPalabrasCodigo = crearPalabrasCodigo(matrizG, vectoresMultiplicacion, qario);

		int distancia = calcularHamming(listaPalabrasCodigo);

		
		System.out.println("Numero de palabras: " + listaPalabrasCodigo.length + "\nCon un tamaño de palabra de "
				+ listaPalabrasCodigo[0].length);

		System.out.println("M.D.H. " + distancia);
		
		return distancia;

	}

	public int calcularHamming(int[][] listaPalabrasCodigo) {

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

	public int[][] crearPalabrasCodigo(int[][] matrizG, int[][] vectoresMultiplicacion, int qario) {

		int[][] resultado = new int[vectoresMultiplicacion.length][matrizG[0].length];

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				for (int k = 0; k < vectoresMultiplicacion[0].length; k++) {

					resultado[i][j] += vectoresMultiplicacion[i][k] * matrizG[k][j];
				}
				resultado[i][j] = resultado[i][j] % qario;
				// System.out.print(resultado[i][j]);

			}
			// System.out.println();

		}
		return resultado;
	}

	public int[][] rellenarVector(int qario, int k) {

		int[][] resultado = new int[(int) Math.pow(qario, k)][k];
		int[] inicial = new int[k];

		for (int t = 0; t < k; t++)
			inicial[t] = 0;

		for (int i = 0; i < resultado.length; i++) {

			/*
			 * for (int j = 0; j < inicial.length; j++) { System.out.print(inicial[j]); }
			 * System.out.println();
			 */

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

	public int[][] crearMatrizGIzquierda(int[][] matrizA) {

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
				//System.out.print(matrizG[i][j]);
			}

			//System.out.println();
		}

		return matrizG;
	}
}
