package actividad;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblResultados;
	private JTextField txtBuscar;
	private JButton btnBuscar;

	
	/**
	 * Create the frame.
	 * @param gb 
	 * @param controlador 
	 */
	public VistaPrestarLibro(Controlador controlador, GestorBiblioteca gb) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 416, 170);
		contentPane.add(scrollPane);
		
		tblResultados = new JTable();
		
		scrollPane.setViewportView(tblResultados);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 32, 373, 19);
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
		btnBuscar.setBounds(393, 27, 33, 30);
		contentPane.add(btnBuscar);
	}
}
