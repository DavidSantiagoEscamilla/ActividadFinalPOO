package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ParqueClases.Parque;
import Repositorios.ParqueRepositorio;

public class ParqueVista extends JFrame {

    private JTextField txtNombre, txtUbicacion, txtSuperficie;
    private JButton btnCrear, btnActualizar, btnEliminar, btnListar;
    private DefaultListModel<String> listaModel;
    private JList<String> listaParques;
    private ParqueRepositorio repositorio;

    public ParqueVista() {
        setTitle("Gestión de Parques");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        repositorio = new ParqueRepositorio();

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Ubicación:"));
        txtUbicacion = new JTextField();
        panelFormulario.add(txtUbicacion);

        panelFormulario.add(new JLabel("Superficie:"));
        txtSuperficie = new JTextField();
        panelFormulario.add(txtSuperficie);

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
        listaParques = new JList<>(listaModel);
        add(new JScrollPane(listaParques), BorderLayout.SOUTH);

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parque parque = new Parque(txtNombre.getText(), txtUbicacion.getText(),
                        Double.parseDouble(txtSuperficie.getText()));
                List<Parque> parques = repositorio.cargarParques();
                parques.add(parque);
                repositorio.guardarParques(parques);
                JOptionPane.showMessageDialog(null, "Parque creado exitosamente.");
                actualizarLista(parques);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Parque> parques = repositorio.cargarParques();
                actualizarLista(parques);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaParques.getSelectedIndex();
                if (index >= 0) {
                    List<Parque> parques = repositorio.cargarParques();
                    parques.remove(index);
                    repositorio.guardarParques(parques);
                    JOptionPane.showMessageDialog(null, "Parque eliminado.");
                    actualizarLista(parques);
                }
            }
        });

        setVisible(true);
    }

    private void actualizarLista(List<Parque> parques) {
        listaModel.clear();
        for (Parque parque : parques) {
            listaModel.addElement(parque.getNombre() + " - " + parque.getUbicacion());
        }
    }
}

