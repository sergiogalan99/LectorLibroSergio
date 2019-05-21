package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;

public class Mostrador {
	private Libro libro;
	private JTextArea jTxtArea;
	private int contador;
	public int numeroPagina;

	public Mostrador(JTextArea jTxtArea) {
		this.jTxtArea = jTxtArea;
	}

	public void setLibro(String ruta) {
		libro = new Libro(ruta);
	}

	public void avanzarPagina() {
		numeroPagina++;
		if (libro.contarPagina(numeroPagina)) {
			jTxtArea.setText(libro.getPagina(numeroPagina).getTextoPagina());
		} else {
			rellenarPaginaNueva();
		}

	}
	public void recargarLibro() {
		if (libro.contarPagina(numeroPagina)) {
			jTxtArea.setText(libro.getPagina(numeroPagina).getTextoPagina());
		} else {
			rellenarPaginaNueva();
		}

	}

	public boolean comprobarLibro(File file) {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public void retrocederPagina() {
		if (numeroPagina > 1) {
			numeroPagina--;
		}
		if (numeroPagina > 0 && libro.contarPagina(numeroPagina)) {
			jTxtArea.setText(libro.getPagina(numeroPagina).getTextoPagina());
		}

	}

	public String getNumeroPagina() {
		return String.valueOf(numeroPagina);

	}
	public String getNumeroPaginaReiniciado() {
		numeroPagina=1;
		return String.valueOf(numeroPagina);

	}

	public void getPaginaMarcada() {
		int marca = libro.getMarcada();
		for (int i = 0; i < marca; i++) {
			numeroPagina++;
			rellenarPaginaNueva();
		}
	}

	public void marcar() {
		libro.marcar(numeroPagina);
	}

	public void rellenarPaginaNueva() {
		StringBuilder cadena = new StringBuilder();
		// TODO igual el textArea sabe el tamaño de letra
		double height2 = jTxtArea.getFont().getSize();
		int inicio = contador;
		boolean salir = false;
		do {
			try {
				cadena.append(libro.dameCaracter());
				jTxtArea.setText(cadena.toString());
				contador++;
			} catch (IOException e) {
				salir = true;
			}

		} while (jTxtArea.getPreferredSize().getHeight() + height2 <= jTxtArea.getHeight() && !salir);
		Pagina pagina = new Pagina(inicio, contador, numeroPagina, cadena.toString());
		libro.addPagina(pagina);

	}

	public String leerTxt(String direccion) {

		String texto = "";

		try {
			BufferedReader leerBuffer = new BufferedReader(new FileReader(direccion));
			String cadena = "";
			String leer;
			while ((leer = leerBuffer.readLine()) != null) {
				// mientras bfRead tiene datos
				cadena = cadena + leer; // guardado el texto del archivo
			}

			texto = cadena;

		} catch (Exception e) {
			// System.err.println("No se encontro archivo");
		}

		return texto;

	}

	public static void replaceTxt(String direccion, String direccion2) {
		try {
			FileWriter w = new FileWriter(direccion);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write(direccion2);
			wr.close();
			bw.close();
		} catch (IOException e) {
		};
	}

}
