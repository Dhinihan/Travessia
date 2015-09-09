package simulation;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Moving extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static JFrame frame;
    int x, y, counter;
    public Timer timer;
    
    Moving() {
        x = 0;
        y = 0;
        counter = 0;
        timer = new Timer(25, this);
    }
    
    public void restart(){
        x = 0;
        y = frame.getHeight()/2 - 20;
        repaint();
    }
    
    public void actionPerformed(ActionEvent e) {
        int c = 193/40;
        int v = 193%40;
        
        x += c;
        if(v - counter > 0)
            x+=1;
        
        repaint();
     s   
        counter = (++counter)%40;
        
        System.out.println("c = " + c + "\n" + "v = " + v + "\n" + "count = " + counter + "\n" + "x = " + x + "\n");
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, 20, 20);
    }
    
    public static void main(String[] args) {   
        frame = new JFrame("Moving");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Moving m = new Moving();
        StartButton button = new StartButton(m);
        frame.add(m);
        frame.setSize(600, 200);
        frame.setVisible(true);
        m.setVisible(false);
        
        JFrame btnFrame = new JFrame("Moving");
        btnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnFrame.add(button);
        btnFrame.setSize(600, 200);
        btnFrame.setLayout(null);
        btnFrame.setVisible(true);
        
    }
    
}