package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.junit.platform.engine.support.descriptor.FileSource;

import modelo.Libro;
import modelo.Mostrador;
import vista.LectorUIEjemplo;

public class ParaUI extends LectorUIEjemplo {
	public Mostrador mostrador;
//
	public ParaUI() {
		mostrador = new Mostrador(textArea);
		txtLibroAnterior.setText(mostrador.leerTxt("ultimoLibroLeido.txt"));
		panelesInicialesVisibilidad();
		mostrador.setLibro(mostrador.leerTxt("ultimoLibroLeido.txt"));
		
		btnLibroAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelesInicialesVisibiladadDos();

			}

		});
		
		
		
		btnLibroNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rutaUltimoLibroLeido = "ultimoLibroLeido.txt";
				// Comprobamos si el libro nuevo existe
				if (mostrador.comprobarLibro(new File(txtLibroNuevo.getText()))) {
					mostrador.replaceTxt(rutaUltimoLibroLeido, txtLibroNuevo.getText());
					mostrador.setLibro(mostrador.leerTxt("ultimoLibroLeido.txt"));
					lblNumeroPagina.setText(mostrador.getNumeroPaginaReiniciado());
					mostrador.recargarLibro();
					panelesInicialesVisibiladadDos();

				} else {
					txtMensaje.setText("El libro no existe");
				}
			}
		});

		btnAlante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrador.avanzarPagina();
				lblNumeroPagina.setText(mostrador.getNumeroPagina());
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrador.retrocederPagina();
				lblNumeroPagina.setText(mostrador.getNumeroPagina());
			}
		});
		
	
		
		// Guardar ultima pagina leida
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				mostrador.getPaginaMarcada();
				lblNumeroPagina.setText(mostrador.getNumeroPagina());
			};

			@Override
			public void windowClosing(WindowEvent ev) {
				mostrador.marcar();

			}

		});

	}

	public void panelesInicialesVisibilidad() {
		panel.setVisible(false);
		textArea.setVisible(false);
		panel_Inicial.setVisible(true);
	}

	public void panelesInicialesVisibiladadDos() {
		panel.setVisible(true);
		textArea.setVisible(true);
		panel_Inicial.setVisible(false);
	}
}
