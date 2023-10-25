package actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VistaPrestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblResultados;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JLabel lblBuscador;
	private JButton btnVolver;

	
	/**
	 * Create the frame.
	 * @param gb 
	 * @param controlador 
	 */
	public VistaPrestarLibro(Controlador controlador, GestorBiblioteca gb) {
		
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 926, 318);
		contentPane.add(scrollPane);
		
		tblResultados = new JTable();
		

		
		scrollPane.setViewportView(tblResultados);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 30, 861, 34);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		ImageIcon icoLupa = new ImageIcon("src/actividad/lupaEscaladaPequena.png");
		
		btnBuscar = new JButton(icoLupa);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblResultados.setModel(gb.buscarLibro(txtBuscar.getText()));
				
				txtBuscar.setText(null);
			}
		});
		btnBuscar.setBounds(881, 30, 43, 34);
		contentPane.add(btnBuscar);
		
		lblBuscador = new JLabel("Busca por título, autor o ISBN");
		lblBuscador.setBounds(10, 10, 384, 13);
		contentPane.add(lblBuscador);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVista(2, 0);
			}
		});
		btnVolver.setBounds(20, 472, 85, 21);
		contentPane.add(btnVolver);
	}
}
