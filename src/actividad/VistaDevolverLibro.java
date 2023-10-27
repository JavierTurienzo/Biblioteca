package actividad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que representa la vista para devolver un libro en la aplicación.
 */
public class VistaDevolverLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPrestamos;
	private JTable tblPrestamos;
	private JButton btnVolver;
	private JButton btnDevolver;
	private JTextField txtIsbn;
	private JLabel lblIsbn;
	private JButton btnActualizar;

	/**
     * Crea la vista para devolver un libro.
     *
     * @param controlador - El controlador que gestionará las acciones en esta vista.
     * @param gb         - El gestor de la biblioteca para realizar acciones de devolución.
     */
    public VistaDevolverLibro(Controlador controlador, GestorBiblioteca gb) {

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

        lblPrestamos = new JLabel("Prestamos");
        lblPrestamos.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPrestamos.setBounds(10, 10, 340, 42);
        contentPane.add(lblPrestamos);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 62, 926, 371);
        contentPane.add(scrollPane);

        tblPrestamos = new JTable();
        scrollPane.setViewportView(tblPrestamos);

        tblPrestamos.setModel(gb.actualizarPrestamos());

        btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVista(3, 0);
            }
        });
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnVolver.setBounds(10, 463, 85, 30);
        contentPane.add(btnVolver);

        btnDevolver = new JButton("Devolver");
        btnDevolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtIsbn.getText().isBlank())
                    gb.devolverLibro(txtIsbn.getText());
                tblPrestamos.setModel(gb.actualizarPrestamos());
            }
        });
        btnDevolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnDevolver.setBounds(851, 463, 85, 30);
        contentPane.add(btnDevolver);

        txtIsbn = new JTextField();
        txtIsbn.setBounds(647, 463, 194, 30);
        contentPane.add(txtIsbn);
        txtIsbn.setColumns(10);

        lblIsbn = new JLabel("ISBN");
        lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIsbn.setBounds(525, 463, 112, 30);
        contentPane.add(lblIsbn);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tblPrestamos.setModel(gb.actualizarPrestamos());
            }
        });
        btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnActualizar.setBounds(851, 23, 85, 30);
        contentPane.add(btnActualizar);
    }
}
