package practicaFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntropiaEficacia {

	public Double[] entropiaYFrecuenciaTexto(String texto, int q) {
		Map<Character, Integer> frecuenciasLetras = frecuenciaTextoOrdenada(texto);

		int[] frec = new int[frecuenciasLetras.size()];
		char[] letra = new char[frecuenciasLetras.size()];

		Character[] claves = frecuenciasLetras.keySet().toArray(new Character[frecuenciasLetras.size()]);

		int x = 0;
		for (Character i : claves) {
			frec[x] = frecuenciasLetras.get(i);
			letra[x] = i;
			x++;
		}

		return calcularEntropiaYEficacia(frec, 1, q);
	}

	private Map<Character, Integer> frecuenciaTextoOrdenada(String fuente) {

		Map<Character, Integer> mapLetrasValor = new HashMap<Character, Integer>();

		for (char letra : fuente.toCharArray()) {

			if (mapLetrasValor.containsKey(letra)) {
				mapLetrasValor.put(letra, mapLetrasValor.get(letra) + 1);

			} else {
				mapLetrasValor.put(letra, 1);
			}

		}

		return mapLetrasValor;

	}

	private String obtenerOrdenada(Map<Character, Integer> lista) {
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

	private Double[] calcularEntropiaYEficacia(int[] frec, int orden, int q) {

		int sumaFrecuencia = 0;
		Double[] prob = new Double[frec.length];

		for (int i = 0; i < frec.length; i++) {
			sumaFrecuencia += frec[i];
		}

		for (int i = 0; i < frec.length; i++) {
			prob[i] = ((double) frec[i] / sumaFrecuencia);
		}

		return calcularEntropiaYEficacia(prob, orden, q);
	}

	private Double[] calcularEntropiaYEficacia(Double[] prob, int orden, int q) {

		prob = transformarOrden(prob, prob, orden);

		Double entropia = 0.0;
		for (int i = 0; i < prob.length; i++) {
			entropia += prob[i] * (-1) * (Math.log(prob[i]) / Math.log(2));
		}

		ArrayList<String> codigoHuffman;
		Double longitudMedia = 0.0;
		Double eficaciaFinal;

		codigoHuffman = huffmanBinario(prob);

		for (int i = 0; i < codigoHuffman.size(); i++) {
			longitudMedia += codigoHuffman.get(i).length() * prob[i];
			// System.out.println("l media: " + longitudMedia + " \tclave: " +
			// codigoHuffman.get(clave) + " \tprob: "+probabilidades[i] );
		}
		eficaciaFinal = entropia / ((Math.log(q) / Math.log(2)) * (longitudMedia));

		Double[] resultado = new Double[2];

		resultado[0] = entropia;
		resultado[1] = eficaciaFinal;
		return resultado;
	}

	private Double[] transformarOrden(Double[] probOrigibal, Double[] prob, int orden) {

		if (orden <= 1) {

			return prob;

		} else {

			Double[] proOrden = new Double[probOrigibal.length * prob.length];

			for (int i = 0; i < probOrigibal.length; i++) {
				for (int j = 0; j < prob.length; j++) {
					proOrden[j + (prob.length * i)] = probOrigibal[i] * prob[j];
				}
			}
			return transformarOrden(probOrigibal, proOrden, orden - 1);
		}

	}

	private ArrayList<String> huffmanBinario(Double[] prob) {

		Map<String, Double> frecuenciasCodigo = new HashMap<String, Double>();
		Map<String, String> codigoResultado = new HashMap<String, String>();

		String clave;
		for (int i = 0; i < prob.length; i++) {

			clave = String.format("%04d", i);
			frecuenciasCodigo.put(clave, (prob[i] * 20));
			codigoResultado.put(clave, "");
		}

		String[] menores;
		Double suma = 0.0;
		String[][] keysSumadas = new String[prob.length - 1][2];

		for (int i = 0; i < prob.length - 1; i++) {

			menores = devolverMenores(frecuenciasCodigo);
			keysSumadas[i] = menores;

			suma = frecuenciasCodigo.remove(menores[0]) + frecuenciasCodigo.remove(menores[1]);

			frecuenciasCodigo.put(menores[1].concat(menores[0]), suma);
		}

		String claveAux;
		for (int i = keysSumadas.length - 1; i >= 0; i--) {

			for (int j = 0; j < keysSumadas[i].length; j++) {
				for (int k = 0; k < keysSumadas[i][j].length() / 4; k++) {
					claveAux = keysSumadas[i][j].substring(k * 4, (k * 4) + 4);
					codigoResultado.put(claveAux, codigoResultado.get(claveAux).concat(Integer.toString(j)));
				}
				// System.out.print(keysSumadas[i][j]+" ");
			}
			// System.out.println();
		}

		ArrayList<String> codigoDevolver = new ArrayList<String>();
		for (int i = 0; i < prob.length; i++) {

			clave = String.format("%04d", i);

			// System.out.println(prob[i]+"\t --> \t"+codigoResultado.get(clave));

			codigoDevolver.add(codigoResultado.get(clave));
		}

		return codigoDevolver;
	}

	private String[] devolverMenores(Map<String, Double> frecuenciasCodigo) {

		String[] menores = { "", "" };

		Double aux1 = Double.MAX_VALUE;
		Double aux2 = Double.MAX_VALUE;

		String[] claves = frecuenciasCodigo.keySet().toArray(new String[frecuenciasCodigo.size()]);

		for (int i = 0; i < claves.length; i++) {

			if (frecuenciasCodigo.get(claves[i]) < aux2) {

				aux1 = aux2;
				aux2 = frecuenciasCodigo.get(claves[i]);

				menores[0] = menores[1];
				menores[1] = claves[i];

			} else if (frecuenciasCodigo.get(claves[i]) < aux1) {

				aux1 = frecuenciasCodigo.get(claves[i]);

				menores[0] = claves[i];
			}
		}

		return menores;
	}

}
