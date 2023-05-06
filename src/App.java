import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App extends JFrame {

    SocialNetwork sn = new SocialNetwork();
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panel1;
    private JButton ingresarButton;
    private JButton mostrarButton;
    private JTextArea textArea1;
    private JTextField textField6;
    private JButton buscarPorIdButton;
    private JButton buscarPorPrioridad50Button;
    private JTextArea textArea2;
    private JButton agregarButton;
    private JButton activarParticipanteSiguienteButton;
    private JButton activarTodosButton;
    private JButton eliminarParticipateButton;
    private JButton eliminarTodosButton;
    private JButton restaurarUltimoEliminadoButton;
    private JButton restaurarTodosButton;
    private JTextArea textArea3;
    private JCheckBox chBoxColaActiva;
    private JTabbedPane tabbedPane2;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;

    public App(){

        setContentPane(panel1);

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarActivos();
            }
        });

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });

        buscarPorIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPredeterminado();
            }
        });

        activarParticipanteSiguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarParticipante();
            }
        });

        activarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarTodos();
            }
        });

        eliminarParticipateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCabeza();
            }
        });

        eliminarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTodos();
            }
        });

        buscarPorIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorId();
            }
        });

        buscarPorPrioridad50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorPrioridad();
            }
        });

        restaurarUltimoEliminadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recuperarUltimoEl();
            }
        });

        restaurarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurarTodos();
            }
        });
    }

    private void buscarPorPrioridad(){
        List<Persona> personasPrioridad = sn.BuscarPorPrioridad(chBoxColaActiva.isSelected());
        if(!personasPrioridad.isEmpty()){
            textArea2.setText(personasPrioridad.toString());
        }else{
            textArea2.setText("Persona no encontrada");
        }
    }

    private void buscarPorId(){
        Queue<Persona> pEncontrada = sn.BuscarPorId(Integer.parseInt(textField6.getText()), chBoxColaActiva.isSelected());

        Iterator<Persona> iterador = pEncontrada.iterator();

        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            if(pEncontrada != null){
                textArea2.setText(pEncontrada.toString());
            }else{
                textArea2.setText("No se encuentran resultados.");
            }
        }

    }

    private void restaurarTodos(){
        String text = "";

        if(!sn.getPila().isEmpty()){
            while (!sn.getPila().isEmpty()) {
                Persona rec = sn.getPila().pop();
                sn.getColaPrioridad().add(rec);
                text += rec.toString();
            }
            textArea6.setText(text);
            JOptionPane.showMessageDialog(null, "Se restauraron todos con exito");
        }else{
            textArea6.setText("No hay personas para restaurar");
        }

    }

    private void recuperarUltimoEl(){
        if(!sn.getPila().isEmpty()){
            Persona rec = sn.getPila().pop();
            sn.getColaPrioridad().add(rec);
            textArea6.setText(rec.toString());
            JOptionPane.showMessageDialog(null, "Se restauro con exito el ultimo elemento");
        }else{
            textArea6.setText("No hay personas para restaurar");
        }

    }

    private void eliminarTodos(){
        String text = "";
        if(!sn.getColaPrioridad().isEmpty()){
            while (!sn.getColaPrioridad().isEmpty()) {
                Persona Premove = sn.getColaPrioridad().remove();
                sn.getPila().add(Premove);
                text += Premove.toString();
            }
            textArea5.setText(text);
            JOptionPane.showMessageDialog(null, "Se eliminaron todos con exito");
        }else{
            textArea5.setText("No hay personas para eliminar");
        }

    }

    private void eliminarCabeza(){
        if(!sn.getColaPrioridad().isEmpty()){
            Persona Premove = sn.getColaPrioridad().remove();
            sn.getPila().add(Premove);
            textArea5.setText(Premove.toString());
            JOptionPane.showMessageDialog(null, "Se elimino exitosamente la cabeza");
        }else{
            textArea5.setText("No hay personas para eliminar");
        }

    }

    private void activarTodos(){
        String text = "";
        if(!sn.getCola().isEmpty()){
            while (!sn.getCola().isEmpty()) {
                Persona Precu = sn.getCola().remove();
                sn.getColaPrioridad().add(Precu);
                text += Precu.toString();
            }
            textArea4.setText(text);
            JOptionPane.showMessageDialog(null, "Se agregaron todos con exito");
        }else{
            textArea4.setText("No hay personas para activar");
        }
    }

    private void activarParticipante(){
        if(!sn.getCola().isEmpty()){
            Persona Precu = sn.getCola().remove();
            sn.getColaPrioridad().add(Precu);
            textArea4.setText(Precu.toString());
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        }else{
            textArea4.setText("No hay personas para activar");
        }
    }

    private void agregarPredeterminado(){
        String text = "";
        Queue<Persona> prede = new LinkedList<>();

        prede.add(new Persona(1, "Josue", 18, 0, 12));
        prede.add(new Persona(2, "Jose", 18, 0, 12));
        prede.add(new Persona(3, "Mariio", 18, 0, 12));
        prede.add(new Persona(4, "Luigi", 18, 0, 12));
        prede.add(new Persona(5, "Bowser", 18, 0, 12));
        prede.add(new Persona(6, "David", 18, 0, 12));

        Iterator<Persona> iterador = prede.iterator();

        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            if (!sn.buscarPersona(elemento.getNombreCompleto())){
                JOptionPane.showMessageDialog(null, "Error. La persona nombre " + elemento.getNombreCompleto() + " ya se agrego.");
                continue;
            }else{
                sn.getCola().add(elemento);
                text+= elemento.toString();
                JOptionPane.showMessageDialog(null, "La persona nombre " + elemento.getNombreCompleto() + " se agrego con exito.");
            }
        }

        textArea1.setText(text);
    }

    private void agregarPersona(){
        if(sn.agregarPersona(new Persona(Integer.parseInt(textField1.getText()), textField2.getText(), Integer.parseInt(textField3.getText()), Integer.parseInt(textField4.getText()),
                Integer.parseInt(textField5.getText())))){
            JOptionPane.showMessageDialog(null, "Persona agregada con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Error. Ya existe la persona.");
        }
    }

    private void mostrarActivos(){
        textArea3.setText(sn.getColaPrioridad().toString());
    }



}
