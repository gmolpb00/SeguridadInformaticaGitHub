package practicaFinal;

public class Vigenere {
	
	private String alf;
	private int longitudAlf;
	private String mensajeCifrado;
	private String claveCifrado;
	private String claveDescifrado;
	private String mensajeEnClaro;
	
	public Vigenere() {
		
		alf = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ0123456789 ,.:-¿?()";
		longitudAlf = alf.length();
		mensajeCifrado = "g,ti76qROéHÚc?hcnmbxi lncs(eBDnG:bémo2bÉaheBÓa(4m-jCnl54e7f51oÍ.gnhV)xÚc?hole.q.nCn1 ia)C7Néu¿)jZ)gn6cqÓ(c:c-mCnl5bikÁÓ,ti76qROíagu54dn60t-uv(ÚmÍjmA7t,na6¿:adnofxb)6í eeagfodi).B, g7(a9Q:l.pcjsb6?D.dnlÚdÍñ)Dbt2x:l¿6:.njjx06ÍÓCjYCg:-ídbÁ1Ó fÚl2bt?Dhaó4Iui0vket8za paaZqZ?Ú";
		claveCifrado = "áÓa6Ú4j7C0j8a1:aj¿0j8aj(8aÍ¿ij7C0j0¿:Ó14j¿8j7¿60a ¿j(,-1a?4";
		
		//TODO - Se podría hacer invertirClave(claveCifrado). Depende de que introduzcamos en la interfaz decidiremos que hacer.
		
		claveDescifrado = "K,j8aj(8aÍ¿j¿0j7C0j8a1:aij7C0j0¿:Ó14j0¿1Cj¿8j(,-1a?4h";  
		
		mensajeEnClaro = "Intuición y conceptos constituyen, pues, los elementos de todo nuestro conocimiento. De tal modo que ni conceptos sin intuición, que de alguna manera les corresponda, ni intuición sin conceptos, pueden dar un conocimiento.  (Crítica de la razón pura, Immanuel Kant, 1787)";
	}
	
	public static void main(String[] args) {
		
		Vigenere vigenere = new Vigenere();
		
		vigenere.descifrarClaveCifrado(vigenere.getMensajeCifrado(),vigenere.getClaveCifrado());
		vigenere.descrifrarConClaveDescifrado(vigenere.getMensajeCifrado(), vigenere.getClaveDescifrado());
		System.out.println();
		vigenere.cifrarMensajeEnClaro(vigenere.getMensajeEnClaro(), vigenere.getClaveCifrado());
	}

	
	public void descifrarClaveCifrado(String mensajeCifradoM, String clavesCifradoM) {
		// int[] numeroLetra = new int[mensajeCifrado.length];
		int[] numeroLetraMensaje = new int[mensajeCifradoM.length()];
		int[] numeroLetraClave = new int[clavesCifradoM.length()];
		int resta = 0;

		numeroLetraMensaje = convertirLetraNumero(mensajeCifradoM);

		numeroLetraClave = convertirLetraNumero(clavesCifradoM);
		

		for (int i = 0; i < numeroLetraMensaje.length; i++) {

			resta = numeroLetraMensaje[i] - numeroLetraClave[Math.floorMod(i, numeroLetraClave.length)];
			resta = Math.floorMod(resta, longitudAlf);



			System.out.print(alf.charAt(resta));


			// System.out.println();
		}


	}

	
		
	private void descrifrarConClaveDescifrado(String mensajeCifradoM, String clavesDescifrado) {
		int[] numeroLetraMensaje = new int[mensajeCifradoM.length()];
		int[] numeroLetraClaveDescifrado = new int[clavesDescifrado.length()];
		int suma = 0;

		numeroLetraMensaje = convertirLetraNumero(mensajeCifradoM);

		numeroLetraClaveDescifrado = convertirLetraNumero(clavesDescifrado);
		for (int i = 0; i < numeroLetraMensaje.length; i++) {


			suma = numeroLetraMensaje[i] + numeroLetraClaveDescifrado[Math.floorMod(i, numeroLetraClaveDescifrado.length)];
			suma = Math.floorMod(suma, longitudAlf);

			System.out.print(alf.charAt(suma));

			// System.out.println();
		}

		
	}
	
	public int[] convertirLetraNumero(String mensajeCifrado) {

		int numero[] = new int[mensajeCifrado.length()];

		for (int i = 0; i < mensajeCifrado.length(); i++) {
			numero[i] = alf.indexOf(mensajeCifrado.charAt(i));

		}

		return numero;

	}
	
	public void invertirClave(String claveDescifrado) {
		
		
		int[] numeroClaveDescifrado = new int[claveDescifrado.length()];
		int inversion = 0;
		
		numeroClaveDescifrado = convertirLetraNumero(claveDescifrado);

		System.out.println("CLAVE INVERSA: ");
		
		for(int i = 0; i < numeroClaveDescifrado.length; i++)
		{
			
			inversion = numeroClaveDescifrado[i]*(-1);
			inversion = Math.floorMod(inversion, longitudAlf);
			
			System.out.print(alf.charAt(inversion));
			
			
		}

		
	}
	
	public void cifrarMensajeEnClaro(String mensajeEnClaro, String claveCifrado) {
		
		int[] numeroLetraMensaje = new int[mensajeEnClaro.length()];
		int[] numeroLetraClaveCifrado = new int[claveCifrado.length()];
		int suma = 0;

		numeroLetraMensaje = convertirLetraNumero(mensajeEnClaro);

		numeroLetraClaveCifrado = convertirLetraNumero(claveCifrado);
		for (int i = 0; i < numeroLetraMensaje.length; i++) {


			suma = numeroLetraMensaje[i] + numeroLetraClaveCifrado[Math.floorMod(i, numeroLetraClaveCifrado.length)];
			suma = Math.floorMod(suma, longitudAlf);

			System.out.print(alf.charAt(suma));

			// System.out.println();
		}
		
		
		
	}

	public String getAlf() {
		return alf;
	}

	public void setAlf(String alf) {
		this.alf = alf;
	}

	public int getLongitudAlf() {
		return longitudAlf;
	}

	public void setLongitudAlf(int longitudAlf) {
		this.longitudAlf = longitudAlf;
	}

	public String getMensajeCifrado() {
		return mensajeCifrado;
	}

	public void setMensajeCifrado(String mensajeCifrado) {
		this.mensajeCifrado = mensajeCifrado;
	}

	public String getClaveCifrado() {
		return claveCifrado;
	}

	public void setClaveCifrado(String claveCifrado) {
		this.claveCifrado = claveCifrado;
	}

	public String getClaveDescifrado() {
		return claveDescifrado;
	}

	public void setClaveDescifrado(String claveDescifrado) {
		this.claveDescifrado = claveDescifrado;
	}

	public String getMensajeEnClaro() {
		return mensajeEnClaro;
	}

	public void setMensajeEnClaro(String mensajeEnClaro) {
		this.mensajeEnClaro = mensajeEnClaro;
	}
	

	

}
