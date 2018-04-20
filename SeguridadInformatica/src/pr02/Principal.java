package pr02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	public static final Double[] probabilidades = {};
	public static final int[] frecuencias = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

	public static void main(String[] args) {
		Principal objeto = new Principal();
		objeto.huffmanBinario(frecuencias);

	}

	public ArrayList<String> huffmanBinario(int[] frec) {

		int sumaFrecuencia = 0;
		Double[] prob = new Double[frec.length];

		for (int i = 0; i < frec.length; i++) {
			sumaFrecuencia += frec[i];
		}
		for (int i = 0; i < frec.length; i++) {
			prob[i] = ((double) frec[i] / sumaFrecuencia);
		}

		return huffmanBinario(prob);
	}

	public ArrayList<String> huffmanBinario(Double[] prob) {

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

			System.out.println(String.format("%.5f", prob[i]) + "\t --> \t" + codigoResultado.get(clave));
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