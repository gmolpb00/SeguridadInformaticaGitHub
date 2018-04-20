package pr05;

public class Principal {

	public static void main(String[] args) {
		String alf="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .,;¿?¡!";
		int [] lista = {0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,0,1,0,0,1,
				0,0,0,0,1,0,1,1,0,0,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,0,
				1,0,0,0,1,0,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,
				0,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,0,0,0,0,
				1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,
				0,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1,1,1,0,0,0,1,0,1,0,0,1,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,
				1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,
				0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,1,1,
				0,0,1,0,1,1,0,1,0,0,1,0,1,0,1,1,0,0,1,1,0,0,0,0,0,1,0,1,
				1,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,
				1,0,0,0,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,0,1,1,
				0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,1,0,1,0,0,1,1,
				0,0,0,0,1,0,1,1,0,1,0,0,1,1,0,0,1,0,0,1,1,0,1,0,0,0,1,1,
				1,0,1,0,0,1,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,
				0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,
				0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1,1,
				1,1,0,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,
				1,1,0,1,1,0,0,1};
		int [][] matrizA = {{1,1,1,0}, {1,1,0,1}, {1,0,1,1}};
		int[][] simbolosCodificados = pr04.Principal.rellenarVector(2, (int)Math.ceil((Math.log(alf.length()) / Math.log(2))));
		int[][] matrizG = pr04.Principal.crearMatrizG(matrizA);
		int[] secuencia = codificarTexto("ac!", alf, simbolosCodificados);
		int[][] secuenciaDividida = dividir(secuencia, matrizA[0].length);
		int[] cola = null;
		int resto = secuencia.length% matrizA[0].length;
		if (resto != 0) {
			cola = new int[resto];
			for (int i = 0; i<resto; i++) {
				cola[i] = secuencia[secuencia.length-1-resto+i];
			}
		}
		int [][] codificado = pr04.Principal.crearPalabrasCodigo(matrizG, secuenciaDividida, 2);
		imprimirDobleArray(codificado);
		if (cola != null)
			for (int e: cola)
				System.out.print(e + " ");

	}

	public static int[][] dividir(int[] codificado, int length) {
		System.out.println("PRE division: ");
		for (int e: codificado)
			System.out.print(e);
		int num = codificado.length/length;
		int[][] resultado = new int[num][length];
		for (int i = 0; i<num; i++) {
			
			for (int index = 0; index<length; index++) {
				resultado[i][index] = codificado[length*i+index];
				index++;
			}
		}
		System.out.println("\ndivision: ");
		imprimirDobleArray(resultado);
		return resultado;
	}

	public static int[] codificarTexto(String palabras, String alf, int[][] simbolosCodificados) {
		System.out.println("PREcodificarTexto: " + palabras + " " + alf + " simbolos");
		imprimirDobleArray(simbolosCodificados);

		int[] resultado = new int[simbolosCodificados[0].length* palabras.length()];
		int contador=0;
		for (int i = 0; i<palabras.length(); i++) {
			for (int j = 0; j<alf.length(); j++) {
				if (palabras.charAt(j) == alf.charAt(j)) {
					for (int e: simbolosCodificados[j]) {
						resultado[contador] = e;
						contador++;
					}
					break;
				}
			}
		}
		System.out.println("codificarTexto: " );
		for(int e: resultado)
			System.out.print(e);
		
		return resultado;
	}
	public static void imprimirDobleArray(int [][] codificado) {
		for (int i = 0; i < codificado.length; i++) {
			for (int j = 0; j < codificado[0].length; j++) {
				System.out.print(codificado[i][j]);
				System.out.print(" ");
			}
			System.out.println();

		}
	}

}
