package Vista;

import ParqueClases.Atraccion;
import Repositorios.AtraccionRepositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AtraccionVista extends JFrame {

    private JTextField txtNombre, txtTipo, txtPrecio;
    private JButton btnCrear, btnActualizar, btnEliminar, btnListar;
    private DefaultListModel<String> listaModel;
    private JList<String> listaAtracciones;
    private AtraccionRepositorio repositorio;
    private List<Atraccion> atracciones;

    public AtraccionVista() {
        setTitle("Gestión de Atracciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        repositorio = new AtraccionRepositorio();
        atracciones = repositorio.cargarAtracciones(); 

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        panelFormulario.add(txtTipo);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnCrear = new JButton("Crear");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");

        panelBotones.add(btnCrear);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        add(panelBotones, BorderLayout.CENTER);

        listaModel = new DefaultListModel<>();
        listaAtracciones = new JList<>(listaModel);
        actualizarLista();

        add(new JScrollPane(listaAtracciones), BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                String tipo = txtTipo.getText();
                double precio = Double.parseDouble(txtPrecio.getText());

                Atraccion nuevaAtraccion = new Atraccion(nombre, tipo, precio);
                atracciones.add(nuevaAtraccion);
                repositorio.guardarAtracciones(atracciones);
                JOptionPane.showMessageDialog(null, "Atracción creada exitosamente.");
                actualizarLista();
                limpiarFormulario();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número.");
            }
        });

        btnActualizar.addActionListener(e -> {
            int selectedIndex = listaAtracciones.getSelectedIndex();
            if (selectedIndex >= 0) {
                try {
                    String nombre = txtNombre.getText();
                    String tipo = txtTipo.getText();
                    double precio = Double.parseDouble(txtPrecio.getText());

                    Atraccion atraccionSeleccionada = atracciones.get(selectedIndex);
                    atraccionSeleccionada.setNombre(nombre);
                    atraccionSeleccionada.setTipo(tipo);
                    atraccionSeleccionada.setPrecio(precio);
                    repositorio.guardarAtracciones(atracciones);
                    JOptionPane.showMessageDialog(null, "Atracción actualizada exitosamente.");
                    actualizarLista();
                    limpiarFormulario();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un numero.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una atraccion para actualizar.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int selectedIndex = listaAtracciones.getSelectedIndex();
            if (selectedIndex >= 0) {
                atracciones.remove(selectedIndex);
                repositorio.guardarAtracciones(atracciones);
                JOptionPane.showMessageDialog(null, "Atracción eliminada exitosamente.");
                actualizarLista();
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una atraccion para eliminar.");
            }
        });

        btnListar.addActionListener(e -> actualizarLista());

        setVisible(true);
    }

    private void actualizarLista() {
        listaModel.clear();
        for (Atraccion atraccion : atracciones) {
            listaModel.addElement(atraccion.getNombre() + " - " + atraccion.getTipo() + " ($" + atraccion.getPrecio() + ")");
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtTipo.setText("");
        txtPrecio.setText("");
    }
}
