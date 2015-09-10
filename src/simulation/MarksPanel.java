package simulation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarksPanel extends JPanel implements ActionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JComboBox<Integer> box;
    private JLabel label;
    
    public MarksPanel() {
        box = new JComboBox<Integer>();
        box.addActionListener(this);
        label = new JLabel("Escolha o N: ");
        for(int i = 1; i <= 30; i++ ){
            box.addItem(new Integer(i));
        }
        box.setSelectedItem(box.getItemAt(2));
        this.add(label);
        this.add(box);
        setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e) {
        int n = (int) ((JComboBox<Integer>) e.getSource()).getSelectedItem();
        Animator.defineNumberOfMarks(n);
    }
    
    
    
}
