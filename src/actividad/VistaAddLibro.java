package actividad;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VistaAddLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtIsbn;
	private JButton btnAdd;

	private Controlador controlador;
	private GestorBiblioteca gb;
	private JLabel lblResultado;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public VistaAddLibro(Controlador controlador, GestorBiblioteca gb) {
		
		this.controlador = controlador;
		this.gb = gb;
		
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("Título");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(53, 66, 73, 24);
		contentPane.add(lblTitulo);

		lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(53, 110, 73, 24);
		contentPane.add(lblAutor);

		lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(53, 152, 73, 24);
		contentPane.add(lblIsbn);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(136, 66, 204, 30);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(136, 110, 204, 30);
		contentPane.add(txtAutor);

		txtIsbn = new JTextField();
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(136, 152, 204, 30);
		contentPane.add(txtIsbn);

		btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtAutor.getText().equals("") || txtTitulo.getText().equals("") || txtIsbn.getText().equals("")) {
					lblResultado.setForeground(new Color(255,0,0));
					lblResultado.setText("Faltan campos por rellenar");
				} else {
					gb.addLibro(new Libro(txtTitulo.getText(), txtAutor.getText(), txtIsbn.getText()));
					gb.guardarLibros();
					txtTitulo.setText("");
					txtAutor.setText("");
					txtIsbn.setText("");
					lblResultado.setForeground(new Color(0,255,0));
					lblResultado.setText("Libro añadido correctamente");
				}
			}
		});
		btnAdd.setBounds(341, 232, 85, 21);
		contentPane.add(btnAdd);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResultado.setBounds(134, 232, 183, 17);
		contentPane.add(lblResultado);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.cambiarVista(1, 0);
				
			}
		});
		btnVolver.setBounds(10, 232, 85, 21);
		contentPane.add(btnVolver);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public void setGb(GestorBiblioteca gb) {
		this.gb = gb;
	}
}
