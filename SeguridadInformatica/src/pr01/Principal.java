package pr01;

import java.util.HashMap;
import java.util.Map;

public class Principal {
	public static final String fuenteEjemplo = new String(
			"Cuanto peor mejor para todos y cuanto peor para todos mejor, mejor para mi, el suyo, beneficio politico.");
	public static final Double[] probabilidades = { 0.3, 0.2, 0.1, 0.1, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05 };
	public static String[] BINARIO = { "0", "1" };

	public static void main(String[] args) {

		Principal objeto = new Principal();
		objeto.frecuenciaTextoOrdenada(fuenteEjemplo);
		objeto.entropiaYFrecuenciaTexto();
	}

	public Map<Character, Integer> frecuenciaTextoOrdenada(String fuente) {

		Map<Character, Integer> mapLetrasValor = new HashMap<Character, Integer>();
		int nSimbolos = 0;
		int frecuenciaTotal = 0;

		for (char letra : fuente.toCharArray()) {

			if (mapLetrasValor.containsKey(letra)) {
				frecuenciaTotal++;
				mapLetrasValor.put(letra, mapLetrasValor.get(letra) + 1);

			} else {
				frecuenciaTotal++;
				nSimbolos++;
				mapLetrasValor.put(letra, 1);
			}

		}

		System.out.println("Ordenada de mayor a menor frecuencia: \n\n" + obtenerOrdenada(mapLetrasValor));
		System.out.println("Numero de simbolos: " + nSimbolos);
		System.out.println("Frecuencia total: " + frecuenciaTotal);
		return mapLetrasValor;

	}

	public String obtenerOrdenada(Map<Character, Integer> lista) {
		String resultado = "";

		Character[] ordenada = lista.keySet().toArray(new Character[lista.size()]);

		Character aux;
		for (int j = 0; j < ordenada.length; j++) {
			for (int i = 0; i < j; i++) {

				if (lista.get(ordenada[j]) > lista.get(ordenada[i])) {
					aux = ordenada[j];
					ordenada[j] = ordenada[i];
					ordenada[i] = aux;
				}
			}
		}
		int sumaFrecuencia = 0;
		for (Character i : ordenada) {
			sumaFrecuencia += lista.get(i).intValue();
		}
		for (Character i : ordenada) {

			resultado += i;
			resultado += " -> \t";
			resultado += lista.get(i).intValue();
			resultado += "\t";
			resultado += (double) (int) lista.get(i) / sumaFrecuencia;

			resultado += "\n";
		}

		return resultado;
	}

	public void entropiaYFrecuenciaTexto() {
		Map<Character, Integer> frecuenciasLetras = frecuenciaTextoOrdenada(fuenteEjemplo);

		int[] frec = new int[frecuenciasLetras.size()];
		char[] letra = new char[frecuenciasLetras.size()];

		Character[] claves = frecuenciasLetras.keySet().toArray(new Character[frecuenciasLetras.size()]);

		int x = 0;
		for (Character i : claves) {
			frec[x] = frecuenciasLetras.get(i);
			letra[x] = i;
			x++;
		}
		pr03.Principal pr03 = new pr03.Principal();

		pr03.calcularEntropiaYEficacia(frec, 1);
	}
}