package practicaFinal;

import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {


	public int obtenerK(String alf, BigInteger n) {
		int solucion = (int) Math.floor((Math.log(Double.valueOf(n.toString())) / Math.log(alf.length())));
		return solucion;
	}

	public String codificarRSA(String mensajeACifrar, BigInteger e, BigInteger n) {

		BigInteger solucion;

		solucion = potenciacionModular(new BigInteger(mensajeACifrar), e, n);

		return solucion.toString();
	}

	public String descodificarRSA(String mensajeADescifrar, BigInteger e, BigInteger n, BigInteger factorn1,
			BigInteger factorn2) {

		BigInteger solucion;
		BigInteger d = obtenerClavePrivada(e, factorn1, factorn2);

		solucion = potenciacionModular(new BigInteger(mensajeADescifrar), d, n);

		return solucion.toString();
	}

	public String codificarRSABloque(String mensajeLimpio, String alf, BigInteger e, BigInteger n) {

		int K = obtenerK(alf, n);

		while(mensajeLimpio.length()%K !=0) {
			mensajeLimpio+=" ";

		}

		int[] mensajeCodigo = codificacionNumerica(mensajeLimpio, alf);

		BigInteger[] arrayBloquesM = hallarC(mensajeCodigo, alf, K, n);

		String solucionTexto = "";
		for (BigInteger x : arrayBloquesM) {

			BigInteger c = potenciacionModular(x, e, n);

			BigInteger[] codificacionBase = expresionBase(c, BigInteger.valueOf(alf.length()));

			if (codificacionBase.length < K + 1) {

				BigInteger[] aux = codificacionBase;

				codificacionBase = new BigInteger[K + 1];

				for (int i = 1; i < K + 2; i++) {
					if (i <= aux.length) {
						codificacionBase[codificacionBase.length - i] = aux[aux.length - i];
					} else {
						codificacionBase[codificacionBase.length - i] = new BigInteger("0");
					}
				}

			}

			int[] temp = new int[codificacionBase.length];

			for (int i = 0; i < temp.length; i++) {
				temp[i] = codificacionBase[i].intValue();
			}

			solucionTexto += codificacionTexto(temp, alf);
		}

		return solucionTexto;
	}

	public String descodificarRSABloque(String codificacion, String alf, BigInteger e, BigInteger n,
			BigInteger factorn1, BigInteger factorn2) {

		int K = 1 + obtenerK(alf, n);

		int[] codificado = codificacionNumerica(codificacion, alf);

		BigInteger[] arrayBloquesC = hallarC(codificado, alf, K, n);

		BigInteger d = obtenerClavePrivada(e, factorn1, factorn2);

		String solucionTexto = "";
		for (BigInteger x : arrayBloquesC) {

			BigInteger m = potenciacionModular(x, d, n);

			BigInteger[] solucionBase = expresionBase(m, BigInteger.valueOf(alf.length()));

			if (solucionBase.length < K) {

				BigInteger[] aux = solucionBase;

				solucionBase = new BigInteger[K - 1];

				for (int i = 1; i < K; i++) {
					if (i <= aux.length) {
						solucionBase[solucionBase.length - i] = aux[aux.length - i];
					} else {
						solucionBase[solucionBase.length - i] = new BigInteger("0");
					}
				}

			}

			int[] temp = new int[solucionBase.length];

			for (int i = 0; i < temp.length; i++) {
				temp[i] = solucionBase[i].intValue();
			}

			solucionTexto += codificacionTexto(temp, alf);
		}

		return solucionTexto;
	}

	private BigInteger[] hallarC(int[] textoCodificado, String alf, int k, BigInteger n) {

		int N = alf.length();

		BigInteger[] solucion = new BigInteger[textoCodificado.length / k];

		int[] aux = new int[k];

		BigInteger c = new BigInteger("0");
		int index = 0;

		for (int i = 0; i < textoCodificado.length; i++) {

			aux[i % k] = textoCodificado[i];

			if ((i % k) == (k - 1)) {

				c = new BigInteger("0");

				for (int j = 0; j < k; j++) {

					BigInteger x = potenciacionModular(new BigInteger(String.valueOf(N)),
							new BigInteger(String.valueOf(k - j - 1)), n)
							.multiply(new BigInteger(String.valueOf(aux[j])));

					c = c.add(x);

				}

				solucion[index] = c;
				index++;
			}
		}
		return solucion;
	}

	private String codificacionTexto(int[] original, String alfabeto) {
		// no tiene en cuenta si alguna palabra no esta en el alfabeto, se da por
		// supuesto.
		String resultado = "";

		for (int e : original) {
			int contador = 0;
			for (char letra : alfabeto.toCharArray()) {
				if (e == contador) {
					resultado += letra;
					break;
				} else
					contador++;
			}

		}
		return resultado;
	}

	private int[] codificacionNumerica(String original, String alfabeto) {
		// no tiene en cuenta si alguna palabra no esta en el alfabeto, se da por
		// supuesto.
		int[] resultado = new int[original.length()];
		int index = 0;
		for (char e : original.toCharArray()) {
			int contador = 0;
			for (char letra : alfabeto.toCharArray()) {
				if (e == letra)
					break;
				else
					contador++;
			}
			resultado[index] = contador;
			index++;

		}
		return resultado;
	}

	private BigInteger euclidesExtendido(BigInteger num, BigInteger modulo) {

		BigInteger solucion;
		ArrayList<BigInteger> mu = new ArrayList<BigInteger>();
		ArrayList<BigInteger> lambda = new ArrayList<BigInteger>();
		ArrayList<BigInteger> restos = new ArrayList<BigInteger>();
		ArrayList<BigInteger> cocientes = new ArrayList<BigInteger>();

		int indice = 1;

		mu.add(new BigInteger("0"));
		mu.add(new BigInteger("1"));

		lambda.add(new BigInteger("1"));
		lambda.add(new BigInteger("0"));

		cocientes.add(new BigInteger("0"));
		cocientes.add(new BigInteger("0"));

		restos.add(modulo);
		restos.add(num);

		while (!restos.get(indice).equals(new BigInteger("1"))) {
			indice++;

			BigInteger cociente = restos.get(indice - 2).divide(restos.get(indice - 1));
			BigInteger resto = restos.get(indice - 2).mod(restos.get(indice - 1));
			restos.add(resto);
			cocientes.add(cociente);

			mu.add(mu.get(indice - 2).subtract(cocientes.get(indice).multiply(mu.get(indice - 1))));
			lambda.add(lambda.get(indice - 2).subtract(cocientes.get(indice).multiply(lambda.get(indice - 1))));
		}

		solucion = mu.get(indice);

		if (solucion.compareTo(new BigInteger("0")) == -1) {
			solucion = solucion.add(modulo);
		}

		return solucion;
	}

	private BigInteger potenciacionModular(BigInteger num, BigInteger exponente, BigInteger modulo) {

		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		ArrayList<BigInteger> b = new ArrayList<BigInteger>();
		ArrayList<BigInteger> m = new ArrayList<BigInteger>();

		a.add(num);
		m.add(new BigInteger("1"));

		String binario = exponente.toString(2);

		for (int i = binario.length() - 1; i >= 0; i--) {
			b.add(new BigInteger(String.valueOf(binario.charAt(i))));
		}

		for (int indice = 0; indice < b.size(); indice++) {

			a.add((a.get(indice).pow(2)).mod(modulo));

			m.add((b.get(indice).equals(new BigInteger("0")) ? m.get(indice)
					: (a.get(indice).multiply(m.get(indice)).mod(modulo))));
		}

		return m.get(b.size());
	}

	private BigInteger obtenerClavePrivada(BigInteger e, BigInteger factorn1, BigInteger factorn2) {

		BigInteger phi = factorn1.subtract(new BigInteger("1")).multiply(factorn2.subtract(new BigInteger("1")));

		return euclidesExtendido(e, phi);
	}

	private BigInteger[] expresionBase(BigInteger expresion, BigInteger base) {

		BigInteger[] solucion;

		ArrayList<BigInteger> restos = new ArrayList<BigInteger>();
		BigInteger resto;
		BigInteger cociente = expresion;
		do {
			resto = cociente.mod(base);
			cociente = cociente.divide(base);

			restos.add(resto);

		} while (cociente.compareTo(base) != -1);

		restos.add(cociente);
		solucion = new BigInteger[restos.size()];

		for (int i = 0; i < restos.size(); i++) {
			solucion[i] = restos.get(restos.size() - 1 - i);
		}
		return solucion;
	}
}
