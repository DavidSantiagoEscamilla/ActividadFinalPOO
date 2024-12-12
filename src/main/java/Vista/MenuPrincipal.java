package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Gestión de Parques");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuParque = new JMenu("Parques");
        JMenuItem crudParque = new JMenuItem("Gestionar Parques");

        crudParque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParqueVista();
            }
        });
        menuParque.add(crudParque);

        JMenu menuGuardaparque = new JMenu("Guardaparques");
        JMenuItem crudGuardaparque = new JMenuItem("Gestionar Guardaparques");

        crudGuardaparque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuardaparqueVista();
            }
        });
        menuGuardaparque.add(crudGuardaparque);

        JMenu menuAtraccion = new JMenu("Atracciones");
        JMenuItem crudAtraccion = new JMenuItem("Gestionar Atracciones");

        crudAtraccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtraccionVista();
            }
        });
        menuAtraccion.add(crudAtraccion);

        menuBar.add(menuParque);
        menuBar.add(menuGuardaparque);
        menuBar.add(menuAtraccion);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}
