package Vista;

import ParqueClases.Guardaparque;
import Repositorios.GuardaparqueRepositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class GuardaparqueVista extends JFrame {

    private JTextField txtNombre, txtAntiguedad, txtEspecialidad;
    private JButton btnCrear, btnActualizar, btnEliminar, btnListar;
    private DefaultListModel<String> listaModel;
    private JList<String> listaGuardaparques;
    private GuardaparqueRepositorio repositorio;
    private List<Guardaparque> guardaparques;

    public GuardaparqueVista() {
        setTitle("Gestión de Guardaparques");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        repositorio = new GuardaparqueRepositorio();
        guardaparques = repositorio.cargarGuardaparques();

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Antigüedad (años):"));
        txtAntiguedad = new JTextField();
        panelFormulario.add(txtAntiguedad);

        panelFormulario.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        panelFormulario.add(txtEspecialidad);

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

        // Lista de guardaparques
        listaModel = new DefaultListModel<>();
        listaGuardaparques = new JList<>(listaModel);
        actualizarLista();

        add(new JScrollPane(listaGuardaparques), BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                int antiguedad = Integer.parseInt(txtAntiguedad.getText());
                String especialidad = txtEspecialidad.getText();

                Guardaparque nuevoGuardaparque = new Guardaparque(nombre, antiguedad, especialidad);
                guardaparques.add(nuevoGuardaparque);
                repositorio.guardarGuardaparques(guardaparques);
                JOptionPane.showMessageDialog(null, "Guardaparque creado exitosamente.");
                actualizarLista();
                limpiarFormulario();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Antigüedad debe ser un número.");
            }
        });

        btnActualizar.addActionListener(e -> {
            int selectedIndex = listaGuardaparques.getSelectedIndex();
            if (selectedIndex >= 0) {
                try {
                    String nombre = txtNombre.getText();
                    int antiguedad = Integer.parseInt(txtAntiguedad.getText());
                    String especialidad = txtEspecialidad.getText();

                    Guardaparque guardaparqueSeleccionado = guardaparques.get(selectedIndex);
                    guardaparqueSeleccionado.setNombre(nombre);
                    guardaparqueSeleccionado.setAntiguedad(antiguedad);
                    guardaparqueSeleccionado.setEspecialidad(especialidad);
                    repositorio.guardarGuardaparques(guardaparques);
                    JOptionPane.showMessageDialog(null, "Guardaparque actualizado exitosamente.");
                    actualizarLista();
                    limpiarFormulario();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Antigüedad debe ser un número.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un guardaparque para actualizar.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int selectedIndex = listaGuardaparques.getSelectedIndex();
            if (selectedIndex >= 0) {
                guardaparques.remove(selectedIndex);
                repositorio.guardarGuardaparques(guardaparques);
                JOptionPane.showMessageDialog(null, "Guardaparque eliminado exitosamente.");
                actualizarLista();
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un guardaparque para eliminar.");
            }
        });

        btnListar.addActionListener(e -> actualizarLista());

        setVisible(true);
    }

    private void actualizarLista() {
        listaModel.clear();
        for (Guardaparque guardaparque : guardaparques) {
            listaModel.addElement(guardaparque.getNombre() + " - " + guardaparque.getAntiguedad() + " años - " + guardaparque.getEspecialidad());
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtAntiguedad.setText("");
        txtEspecialidad.setText("");
    }
}
