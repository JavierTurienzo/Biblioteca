package actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PaginaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAñadirLibro;
	
	private Controlador controlador;
	private JButton btnPrestar;

	/**
	 * Create the frame.
	 */
	public PaginaPrincipal(Controlador controlador) {
		
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAñadirLibro = new JButton("Añadir libro");
		btnAñadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.cambiarVista(0, 1);
				
			}
		});
		btnAñadirLibro.setBounds(153, 57, 123, 21);
		contentPane.add(btnAñadirLibro);
		
		btnPrestar = new JButton("Prestar libro");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVista(0, 2);
			}
		});
		btnPrestar.setBounds(153, 88, 123, 21);
		contentPane.add(btnPrestar);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
