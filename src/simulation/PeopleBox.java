package simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class PeopleBox extends JComboBox<String> implements ActionListener{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Moving m;
    private String inicio;

    public PeopleBox(Moving m) {
        this.m = m;
        this.addActionListener(this);
        this.setVisible(false);
        inicio = "Escolha um arquivo";
        this.getEditor().setItem(inicio);
    }
    
    public void actionPerformed(ActionEvent e) {
        m.setPerson(((PeopleBox) e.getSource()).getSelectedIndex());
        this.getEditor().setItem(((PeopleBox) e.getSource()).getSelectedItem());
        super.actionPerformed(e);
    }
    
    
    
}
