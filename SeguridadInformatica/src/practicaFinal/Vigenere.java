package practicaFinal;

public class Vigenere {

	public Vigenere() {

	}

	public String descifrarClaveCifrado(String mensajeCifradoM, String alf, String clavesCifradoM) {
		// int[] numeroLetra = new int[mensajeCifrado.length];
		int[] numeroLetraMensaje = new int[mensajeCifradoM.length()];
		int[] numeroLetraClave = new int[clavesCifradoM.length()];
		int resta = 0;
		int longitudAlf = alf.length();
		
		String resultado = "";
		numeroLetraMensaje = convertirLetraNumero(mensajeCifradoM, alf);

		numeroLetraClave = convertirLetraNumero(clavesCifradoM, alf);

		for (int i = 0; i < numeroLetraMensaje.length; i++) {

			resta = numeroLetraMensaje[i] - numeroLetraClave[Math.floorMod(i, numeroLetraClave.length)];
			resta = Math.floorMod(resta, longitudAlf);

			resultado+=alf.charAt(resta);

			// System.out.println();
		}

		return resultado;
	}

	private void descrifrarConClaveDescifrado(String mensajeCifradoM, String alf, String clavesDescifrado) {
		int[] numeroLetraMensaje = new int[mensajeCifradoM.length()];
		int[] numeroLetraClaveDescifrado = new int[clavesDescifrado.length()];
		int suma = 0;
		int longitudAlf = alf.length();

		numeroLetraMensaje = convertirLetraNumero(mensajeCifradoM, alf);

		numeroLetraClaveDescifrado = convertirLetraNumero(clavesDescifrado, alf);
		for (int i = 0; i < numeroLetraMensaje.length; i++) {

			suma = numeroLetraMensaje[i]
					+ numeroLetraClaveDescifrado[Math.floorMod(i, numeroLetraClaveDescifrado.length)];
			suma = Math.floorMod(suma, longitudAlf);

			System.out.print(alf.charAt(suma));

			// System.out.println();
		}

	}

	public int[] convertirLetraNumero(String mensajeCifrado, String alf) {

		int numero[] = new int[mensajeCifrado.length()];

		for (int i = 0; i < mensajeCifrado.length(); i++) {
			numero[i] = alf.indexOf(mensajeCifrado.charAt(i));

		}

		return numero;

	}

	public void invertirClave(String claveDescifrado, String alf) {

		int[] numeroClaveDescifrado = new int[claveDescifrado.length()];
		int inversion = 0;

		numeroClaveDescifrado = convertirLetraNumero(claveDescifrado, alf);

		System.out.println("CLAVE INVERSA: ");

		for (int i = 0; i < numeroClaveDescifrado.length; i++) {

			inversion = numeroClaveDescifrado[i] * (-1);
			inversion = Math.floorMod(inversion, alf.length());

			System.out.print(alf.charAt(inversion));

		}

	}

	public String cifrarMensajeEnClaro(String mensajeEnClaro, String alf, String claveCifrado) {

		int[] numeroLetraMensaje = new int[mensajeEnClaro.length()];
		int[] numeroLetraClaveCifrado = new int[claveCifrado.length()];
		int suma = 0;
		String resultado = "";
		int longitudAlf = alf.length();

		numeroLetraMensaje = convertirLetraNumero(mensajeEnClaro, alf);

		numeroLetraClaveCifrado = convertirLetraNumero(claveCifrado, alf);
		for (int i = 0; i < numeroLetraMensaje.length; i++) {

			suma = numeroLetraMensaje[i] + numeroLetraClaveCifrado[Math.floorMod(i, numeroLetraClaveCifrado.length)];
			suma = Math.floorMod(suma, longitudAlf);

			resultado+=alf.charAt(suma);

			// System.out.println();
		}
		return resultado;
	}

}
