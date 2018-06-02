package pr08;

import java.math.BigInteger;
import java.util.ArrayList;

public class Principal {

	public static final BigInteger modulo = new BigInteger("6956072540376423616884");
	public static final BigInteger numeroAInvertir = new BigInteger("410338673");

	public static final BigInteger mensajeACifrar = new BigInteger("123123123123");
	public static final BigInteger mensajeADescifrar = new BigInteger("783062732984423314384");
	public static final BigInteger n = new BigInteger("6956072614011871995641");
	public static final BigInteger factorn1 = new BigInteger("73635353912279");
	public static final BigInteger factorn2 = new BigInteger("94466479");
	public static final BigInteger e = new BigInteger("410338673");

	public static final BigInteger expresion = new BigInteger("123456789123456789");
	public static final BigInteger base1 = new BigInteger("5");
	public static final BigInteger base2 = new BigInteger("27");

	public static void main(String[] args) {

		Principal objeto = new Principal();

		System.out.println("1:\nInverso:\t" + objeto.euclidesExtendido(numeroAInvertir, modulo));

		System.out.println("\n2 a):\nCifrado:\t" + objeto.potenciacionModular(mensajeACifrar, e, n));

		System.out.println("\n2 b):\nClave Privada:\t" + objeto.obtenerClavePrivada(e, factorn1, factorn2));
		System.out.println("Descifrado:\t" + objeto.descifrarRSA(mensajeADescifrar, e, n, factorn1, factorn2));

		System.out.println("\n3:\nExpresion base 5:\t" + objeto.imprimirArray(objeto.expresionBase(expresion, base1)));
		System.out.println("Expresion base 27:\t" + objeto.imprimirArray(objeto.expresionBase(expresion, base2)));

	}

	private String imprimirArray(BigInteger[] array) {
		String texto = "";

		for (BigInteger e : array) {
			texto += e+" ";
		}
		return texto;
	}

	public BigInteger euclidesExtendido(BigInteger num, BigInteger modulo) {

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

	public BigInteger potenciacionModular(BigInteger num, BigInteger exponente, BigInteger modulo) {

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

	public BigInteger obtenerClavePrivada(BigInteger e, BigInteger factorn1, BigInteger factorn2) {

		BigInteger phi = factorn1.subtract(new BigInteger("1")).multiply(factorn2.subtract(new BigInteger("1")));

		return euclidesExtendido(e, phi);
	}

	public BigInteger descifrarRSA(BigInteger mensajeADescifrar, BigInteger e, BigInteger n, BigInteger factorn1,
			BigInteger factorn2) {

		BigInteger solucion;
		BigInteger d = obtenerClavePrivada(e, factorn1, factorn2);

		solucion = potenciacionModular(mensajeADescifrar, d, n);

		return solucion;
	}

	public BigInteger[] expresionBase(BigInteger expresion, BigInteger base) {

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
