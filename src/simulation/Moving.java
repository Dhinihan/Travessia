package simulation;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import parse.DataParser;
import data.AverageSample;
import data.Sample;

public class Moving extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static JFrame frame;
    int x, y, counter, sampleIndex;
    public Timer timer;
    private Animator animator;
    private List<Sample> samples;
    
    Moving() {
        x = 0;
        y = 0;
        counter = 0;
        timer = new Timer(25, this);
        animator = Animator.create(0, 1);
    }
    
    public void restart(){
        for (Sample sample : samples) {
            System.out.println(sample.toString());
        }
        double acc = this.samples.get(sampleIndex).getAverageAcceleration();
        double spd = this.samples.get(sampleIndex).getAverageVelocity();
        this.animator = Animator.create(spd, acc);
        frame.setTitle(this.samples.get(sampleIndex) + " - Velocidade inicial: " + spd + ", Aceleração: " + acc);
        x = 0;
        y = frame.getHeight()/2 - 20;
        repaint();
    }
    
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        x += animator.getNextMotion(counter);
        
        repaint();
        setVisible(true);
        
        counter = (counter+1)%40;

        if(x > frame.getSize().getWidth()){
            timer.stop();
            restart();
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, 20, 20);
    }
    
    public static void main(String[] args) {   
        frame = new JFrame("Animação");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Moving m = new Moving();
        StartButton button = new StartButton(m);
        PeopleBox box = new PeopleBox(m);
        FileButton fileButton = new FileButton(m, box);
        frame.add(m);
        frame.setSize(600, 200);
        frame.setVisible(true);
        m.setVisible(false);
        
        JFrame btnFrame = new JFrame("Moving");
        btnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnFrame.add(button);
        btnFrame.add(fileButton);
        btnFrame.add(box);
        btnFrame.add(new MarksPanel());
        btnFrame.setSize(200, 200);
        btnFrame.setLayout(new FlowLayout());
        btnFrame.setVisible(true);
        
    }

    public boolean setCSVFile(File arquivo) {
        DataParser parser = new DataParser();
        parser.appendCSV(arquivo);
        try {
            this.samples = parser.getSamples();
            figureAverage();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void figureAverage() {
        double spd = 0, acc = 0;
        for (Sample personSample : samples) {
            spd += personSample.getAverageVelocity();
            acc += personSample.getAverageAcceleration();
        }
        samples.add(new AverageSample(spd/samples.size()*2, 0, "Média Constante"));
        samples.add(new AverageSample(0, acc/samples.size()*2, "Média Acelerada"));
    }

    public List<Sample> getSamples() {
        return this.samples;
    }

    public void setPerson(int index) {
        this.sampleIndex = index;
    }
    
}