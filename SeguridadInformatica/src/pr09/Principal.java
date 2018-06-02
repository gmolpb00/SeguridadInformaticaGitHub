package pr09;

import java.math.BigInteger;

public class Principal {
	public static final String alfabeto = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ0123456789 ,.:;-¿?()";

	public static final String textoCodificado = "nbSñihLK7C)apcykwN4MLxcYERpVS6zni1VÚuDojÁyfVkyv3z9a?I)L9lpVó";

	public static final BigInteger e = new BigInteger("356812573");
	public static final BigInteger n = new BigInteger("62439738695706104201747");
	public static final BigInteger factorn1 = new BigInteger("249879448303");
	public static final BigInteger factorn2 = new BigInteger("249879448349");

	public static void main(String[] args) {
		Principal objeto = new Principal();

		objeto.descodificarRSABloque(textoCodificado, alfabeto, e, n, factorn1, factorn2);
	}

	public void descodificarRSABloque(String codificacion, String alf, BigInteger e, BigInteger n, BigInteger factorn1,
			BigInteger factorn2) {

		pr07.Principal pr07 = new pr07.Principal();
		pr08.Principal pr08 = new pr08.Principal();

		int K = (int) Math.ceil((Math.log(Double.valueOf(n.toString())) / Math.log(alf.length()))); //////////////////// 7

		int[] codificado = pr07.codificacionNumerica(codificacion, alf);

		BigInteger[] arrayBloquesC = hallarC(codificado, alf, K, n);

		BigInteger d = pr08.obtenerClavePrivada(e, factorn1, factorn2);

		String solucionTexto = "";
		for (BigInteger x : arrayBloquesC) {

			BigInteger m = pr08.potenciacionModular(x, d, n);

			BigInteger[] solucionBase = pr08.expresionBase(m, BigInteger.valueOf(alf.length()));

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

			solucionTexto += pr07.codificacionTexto(temp, alf);
		}

		System.out.println(solucionTexto);
	}

	private BigInteger[] hallarC(int[] textoCodificado, String alf, int k, BigInteger n) {

		pr08.Principal pr08 = new pr08.Principal();

		int N = alf.length();

		System.out.println(k);
		BigInteger[] solucion = new BigInteger[textoCodificado.length / k];

		int[] aux = new int[k];

		BigInteger m = new BigInteger("0");
		int index = 0;

		for (int i = 0; i < textoCodificado.length; i++) {

			aux[i % k] = textoCodificado[i];

			if ((i % k) == (k - 1)) {

				m = new BigInteger("0");

				for (int j = 0; j < k; j++) {

					BigInteger x = pr08
							.potenciacionModular(new BigInteger(String.valueOf(N)),
									new BigInteger(String.valueOf(k - j - 1)), n)
							.multiply(new BigInteger(String.valueOf(aux[j])));

					m = m.add(x);

				}

				solucion[index] = m;
				index++;
			}
		}
		return solucion;
	}

}
