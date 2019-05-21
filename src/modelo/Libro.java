package modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Libro {
	private FileReader libro = null;
	private List<Pagina> paginas;
	private String ruta, rutaMarcada;

	// Quien controla que el archivo exista
	public Libro(String ruta) {
		if (validarLibro(ruta)) {
			this.ruta = ruta;
			rutaMarcada = ruta.replace(".txt", ".paginaMarcada");
			libro = abrirLibro(new File(ruta));
			paginas = new ArrayList<>();

		} else {
			System.out.println("El libro no existe");
		}
	}

	public boolean validarLibro(String ruta2) {
		File file = new File(ruta2);
		// Aqui haces programcion defensiva
		// Porque la clase libro debe tomar una decison sobre los errores
		return file.exists() && file.canRead();
	}

	public Libro() {
	}

	public FileReader abrirLibro(File ruta2) {
		assert ruta2.exists() && ruta2.canRead();
		try {
			return new FileReader(ruta2);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public String dameCaracter() throws IOException {
		return String.valueOf((char) libro.read());
	}

	public void addPagina(Pagina pagina) {
		paginas.add(pagina);
	}

	public boolean contarPagina(int numeroPagina) {
		for (Pagina pagina : paginas) {
			if (pagina.getNumeroPagina() == numeroPagina) {
				return true;
			}
		}
		return false;

	}

	public Pagina getPagina(int numeroPagina) {
		if (contarPagina(numeroPagina)) {

			for (Pagina pagina : paginas) {
				if (pagina.getNumeroPagina() == numeroPagina) {
					return pagina;
				}
			}
		}
		return null;

	}

	public int getMarcada() {
		try {
			if (validarLibro(rutaMarcada)) {
				FileReader marca = new FileReader(new File(rutaMarcada));
				return marca.read();
			} else {
				System.out.println("El libro no existe");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	private FileWriter guardarLibro(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			return new FileWriter(file);
		} catch (Exception e) {

		}
		return null;

	}

	public boolean marcar(int numeroPagina) {
		FileWriter writer = guardarLibro(new File(rutaMarcada));
		try {
			writer.write(numeroPagina);
			writer.flush();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

}
