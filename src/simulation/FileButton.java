package simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.Sample;

public class FileButton extends JButton implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Moving moving;
    private PeopleBox box;

    public FileButton(Moving moving, PeopleBox box) {
        this.moving = moving;
        this.box = box;
        this.addActionListener(this);
        this.setText("Escolha o arquivo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION){
            File arquivo = fc.getSelectedFile();
            if(this.moving.setCSVFile(arquivo)){
                for (Sample sample: moving.getSamples()) {
                    box.addItem(sample.toString());
                }
                box.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo csv, tente novamente");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo."); 
        
    }

}
