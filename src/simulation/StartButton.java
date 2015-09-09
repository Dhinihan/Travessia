package simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Moving moving;

    public StartButton(Moving moving) {
        this.moving = moving;
        this.setBounds(10, 10, 120, 40);
        this.addActionListener(this);
        this.setText("Começa");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.moving.setVisible(false);
        this.moving.restart();
        this.moving.setVisible(true);
        this.moving.timer.start();
    }

}
