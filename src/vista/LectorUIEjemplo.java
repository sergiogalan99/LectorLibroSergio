package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import modelo.Mostrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

public class LectorUIEjemplo extends JFrame {

	private JPanel contentPane;
	protected JTextArea textArea;
	protected JButton btnAlante;
	protected JLabel lblNumeroPagina;
	protected Mostrador mostrador;
	protected JButton btnAtras;
	protected JTextField txtLibroNuevo;
	protected JLabel lblMensaje;
	protected JTextField txtMensaje;
	protected JPanel panel_Inicial;
	protected JButton btnLibroNuevo;
	protected JButton btnLibroAnterior;
	protected JPanel panel;
	protected JLabel lblNewLabel;
	protected JTextField txtLibroAnterior;

	public LectorUIEjemplo() {
		
		setTitle("Lector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 490);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_Inicial = new JPanel();
		panel_Inicial.setVisible(false);
		panel_Inicial.setBackground(new Color(204, 204, 51));
		panel_Inicial.setBounds(0, 0, 315, 461);
		contentPane.add(panel_Inicial);
		panel_Inicial.setLayout(null);
		
		JLabel lblLectorLibro = new JLabel("LECTOR LIBRO");
		lblLectorLibro.setBounds(42, 11, 248, 44);
		panel_Inicial.add(lblLectorLibro);
		lblLectorLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLectorLibro.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD | Font.ITALIC, 40));
		
		btnLibroAnterior = new JButton("LIBRO ANTERIOR");
		
		
		btnLibroAnterior.setBounds(10, 66, 295, 70);
		panel_Inicial.add(btnLibroAnterior);
		btnLibroAnterior.setBackground(new Color(51, 51, 0));
		btnLibroAnterior.setForeground(new Color(0, 0, 0));
		btnLibroAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnLibroNuevo = new JButton("LIBRO NUEVO");
		btnLibroNuevo.setBounds(10, 175, 295, 68);
		panel_Inicial.add(btnLibroNuevo);
		btnLibroNuevo.setBackground(new Color(102, 51, 204));
		btnLibroNuevo.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtLibroNuevo = new JTextField();
		txtLibroNuevo.setText(".txt");
		txtLibroNuevo.setBounds(10, 254, 295, 34);
		panel_Inicial.add(txtLibroNuevo);
		txtLibroNuevo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLibroNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		txtLibroNuevo.setColumns(10);
		
		lblMensaje = new JLabel("MENSAJE: ");
		lblMensaje.setBounds(10, 392, 76, 17);
		panel_Inicial.add(lblMensaje);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtMensaje = new JTextField();
		txtMensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMensaje.setEditable(false);
		txtMensaje.setBounds(92, 392, 213, 17);
		panel_Inicial.add(txtMensaje);
		txtMensaje.setBorder(null);
		txtMensaje.setBackground(new Color(204, 204, 51));
		txtMensaje.setColumns(10);
		
		JLabel lblSergioGalnGmez = new JLabel("Sergio Gal\u00E1n G\u00F3mez");
		lblSergioGalnGmez.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblSergioGalnGmez.setBounds(199, 422, 116, 28);
		panel_Inicial.add(lblSergioGalnGmez);
		
		lblNewLabel = new JLabel("Libro Anterior: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 150, 115, 14);
		panel_Inicial.add(lblNewLabel);
		
		txtLibroAnterior = new JTextField();
		txtLibroAnterior.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLibroAnterior.setForeground(new Color(153, 51, 51));
		txtLibroAnterior.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtLibroAnterior.setEditable(false);
		txtLibroAnterior.setBounds(120, 148, 170, 20);
		txtLibroAnterior.setBackground(new Color(204, 204, 51));
		panel_Inicial.add(txtLibroAnterior);
		txtLibroAnterior.setColumns(10);
		textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(102, 204, 153));
		textArea.setEditable(false);
		textArea.setBounds(5, 5, 305, 418);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);

		// Panel de botones
		panel = new JPanel();
		panel.setBounds(5, 423, 305, 33);
		panel.setBackground(new Color(102, 153, 102));
		contentPane.add(panel);
		btnAlante = new JButton(">>");
		btnAlante.setBackground(new Color(102, 0, 102));
		btnAlante.setForeground(new Color(0, 0, 0));
		btnAtras = new JButton("<<");
		btnAtras.setForeground(new Color(0, 0, 0));
		btnAtras.setBackground(new Color(102, 0, 102));
		panel.add(btnAtras);

		lblNumeroPagina = new JLabel("0");
		lblNumeroPagina.setForeground(new Color(204, 204, 204));
		lblNumeroPagina.setBackground(new Color(0, 102, 51));
		lblNumeroPagina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNumeroPagina);

		panel.add(btnAlante);
	}
}
