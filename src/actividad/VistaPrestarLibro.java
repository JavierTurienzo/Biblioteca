package actividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;

/**
 * Clase que representa la vista para prestar un libro en la aplicación.
 */
public class VistaPrestarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblResultados;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JLabel lblBuscador;
	private JButton btnVolver;
	private JTextField txtUsuario;
	private JTextField txtIsbn;
	private JLabel lblUsuario;
	private JButton btnPrestar;
	private JLabel lblIsbn;
	private JLabel lblResultado;

	private ArrayList<Libro> resultados = new ArrayList<>();

	/**
     * Crea la vista para prestar un libro.
     *
     * @param controlador - El controlador que gestionará las acciones en esta vista.
     * @param gb         - El gestor de la biblioteca para realizar acciones de préstamo.
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

                resultados = gb.buscarLibro(txtBuscar.getText());

                String[] columnas = { "Título", "Autor", "ISBN", "Disponible" };
                DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        // Las celdas no son editables
                        return false;
                    }
                };

                for (Libro libro : resultados) {
                    String[] fila = { libro.getTitulo(), libro.getAutor(), libro.getIsbn(),
                            libro.isDisponible() ? "Sí" : "No" };

                    modelo.addRow(fila);
                }

                tblResultados.setModel(modelo);
                txtBuscar.setText(null);
            }
        });
        btnBuscar.setBounds(881, 30, 43, 34);
        contentPane.add(btnBuscar);

        lblBuscador = new JLabel("Busca por título, autor o ISBN");
        lblBuscador.setBounds(10, 10, 384, 13);
        contentPane.add(lblBuscador);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.cambiarVista(2, 0);
            }
        });
        btnVolver.setBounds(24, 439, 85, 30);
        contentPane.add(btnVolver);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(427, 439, 149, 30);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);

        txtIsbn = new JTextField();
        txtIsbn.setColumns(10);
        txtIsbn.setBounds(676, 439, 149, 30);
        contentPane.add(txtIsbn);

        btnPrestar = new JButton("Prestar");
        btnPrestar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnPrestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Comprobar que los campos están rellenos
                if (!txtUsuario.getText().isEmpty() && !txtIsbn.getText().isEmpty()) {

                    // Comprobar que el libro está disponible
                    if (gb.estaDisponible(txtIsbn.getText())) {

                        for (Libro libro : resultados) {
                            if (libro.getIsbn().equals(txtIsbn.getText())) {
                                gb.prestarLibro(txtUsuario.getText(), libro);
                            }
                        }
                        txtUsuario.setText(null);
                        txtIsbn.setText(null);
                        lblResultado.setForeground(new Color(0, 185, 0));
                        lblResultado.setText("Préstamo aplicado");

                    // Si no está disponible
                    } else {
                        lblResultado.setForeground(new Color(255, 0, 0));
                        lblResultado.setText("El libro no está disponible");
                    }

                // Si los campos no están rellenos
                } else {
                    lblResultado.setForeground(new Color(255, 0, 0));
                    lblResultado.setText("Los campos no están rellenos");
                }
            }

        });
        btnPrestar.setBounds(835, 439, 89, 30);
        contentPane.add(btnPrestar);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setBounds(336, 439, 80, 30);
        contentPane.add(lblUsuario);

        lblIsbn = new JLabel("ISBN");
        lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIsbn.setBounds(586, 439, 80, 30);
        contentPane.add(lblIsbn);

        lblResultado = new JLabel("");
        lblResultado.setBounds(662, 473, 262, 21);
        contentPane.add(lblResultado);
    }
}
