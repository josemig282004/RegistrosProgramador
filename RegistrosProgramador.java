
package registrosprogramador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrosProgramador {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registros de Programador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new FlowLayout());

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField textNombre = new JTextField(20);
        JLabel labelGenero = new JLabel("Género:");
        JRadioButton radioMasculino = new JRadioButton("Masculino");
        JRadioButton radioFemenino = new JRadioButton("Femenino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioMasculino);
        grupoGenero.add(radioFemenino);

        JLabel labelLenguajes = new JLabel("Lenguajes de programación:");
        JCheckBox checkJava = new JCheckBox("Java");
        JCheckBox checkPython = new JCheckBox("Python");
        JCheckBox checkCSharp = new JCheckBox("C#");

        JLabel labelEstado = new JLabel("Estado:");
        JComboBox<String> comboEstado = new JComboBox<>(new String[]{"Activo", "Inactivo"});

        JButton buttonGuardar = new JButton("Guardar");
        JLabel labelResultado = new JLabel("<html>Programadores registrados:<br/></html>");

        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = radioMasculino.isSelected() ? "Masculino" : "Femenino";
                String lenguajes = "";
                if (checkJava.isSelected()) lenguajes += "Java ";
                if (checkPython.isSelected()) lenguajes += "Python ";
                if (checkCSharp.isSelected()) lenguajes += "C#";

                String programador = textNombre.getText() + " - " + genero + " - " + lenguajes + " - " + comboEstado.getSelectedItem();
                labelResultado.setText(labelResultado.getText() + programador + "<br/>");
                textNombre.setText("");
                grupoGenero.clearSelection();
                checkJava.setSelected(false);
                checkPython.setSelected(false);
                checkCSharp.setSelected(false);
                comboEstado.setSelectedIndex(0);
            }
        });

        frame.add(labelNombre);
        frame.add(textNombre);
        frame.add(labelGenero);
        frame.add(radioMasculino);
        frame.add(radioFemenino);
        frame.add(labelLenguajes);
        frame.add(checkJava);
        frame.add(checkPython);
        frame.add(checkCSharp);
        frame.add(labelEstado);
        frame.add(comboEstado);
        frame.add(buttonGuardar);
        frame.add(labelResultado);

        frame.setVisible(true);
    }
}


