package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lectorTxt {

	public static final String archivoBuscado = "src/files/archivo_01.txt";

	public static void main(String[] args) throws IOException {
		muestraContenido(archivoBuscado);
	}

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;

		FileReader f = new FileReader(archivo);

		BufferedReader b = new BufferedReader(f);

		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

}
