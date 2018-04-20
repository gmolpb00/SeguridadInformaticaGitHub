package pr03;

import java.util.ArrayList;

public class Principal {
	public static final int Q = 2;
	public static final int[] frecuencia = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

	public static void main(String[] args) {
		Principal objeto = new Principal();
		objeto.calcularEntropiaYEficacia(frecuencia, 1);
		
	}

	public void calcularEntropiaYEficacia(int[] frec, int orden) {

		int sumaFrecuencia = 0;
		Double[] prob = new Double[frec.length];

		for (int i = 0; i < frec.length; i++) {
			sumaFrecuencia += frec[i];
		}

		for (int i = 0; i < frec.length; i++) {
			prob[i] = ((double) frec[i] / sumaFrecuencia);
		}

		calcularEntropiaYEficacia(prob, orden);
	}

	public void calcularEntropiaYEficacia(Double[] prob, int orden) {

		prob = transformarOrden(prob, prob, orden);

		Double entropia = 0.0;
		for (int i = 0; i < prob.length; i++) {
			entropia += prob[i] * (-1) * (Math.log(prob[i]) / Math.log(2));
		}

		ArrayList<String> codigoHuffman;
		Double longitudMedia = 0.0;
		Double eficaciaFinal;

		pr02.Principal obj = new pr02.Principal();
		codigoHuffman = obj.huffmanBinario(prob);

		for (int i = 0; i < codigoHuffman.size(); i++) {
			longitudMedia += codigoHuffman.get(i).length() * prob[i];
			// System.out.println("l media: " + longitudMedia + " \tclave: " +
			// codigoHuffman.get(clave) + " \tprob: "+probabilidades[i] );
		}
		eficaciaFinal = entropia / ((Math.log(Q) / Math.log(2)) * (longitudMedia));

		System.out.println();
		System.out.println("Entropia: " + entropia);
		System.out.println("Longitud media: " + longitudMedia);
		System.out.println("Eficacia: " + eficaciaFinal);
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
}
