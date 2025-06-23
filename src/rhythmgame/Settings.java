/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rhythmgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author lcros3
 */
import javax.swing.*;
import java.io.*;

public class Settings extends javax.swing.JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Settings.class.getName());

    private int backgroundDim, noteSpeed;
    private String laneBindL, laneBindML, laneBindMR, laneBindR;
    private boolean noLoss = false;

    /**
     * @throws java.io.IOException
     */
    // Variables declaration - do not modify                     
    private JButton backButton;
    private JLabel dimPrompt;
    private JSlider dimSlider;
    private JLabel keybindPrompt;
    private JButton laneL;
    private JButton laneML;
    private JButton laneMR;
    private JButton laneR;
    private JLabel leftLaneL;
    private JLabel midLeftLaneL;
    private JLabel midRightLaneL;
    private JCheckBox noLossCheck;
    private JLabel noLossL;
    private JLabel noteSpeedL;
    private JSlider noteSpeedSlider;
    private JLabel rightLaneL;
    private JLabel settingsTitle;

    private boolean waitForLaneL = false;
    private boolean waitForLaneML = false;
    private boolean waitForLaneMR = false;
    private boolean waitForLaneR = false;

    // End of variables declaration
    Settings settings = new Settings(255, 'd', 'f', 'j', 'k', 1, false);

    public Settings() throws IOException {

        // Initialize JFrame
        initComponents();
        setTitle("Settings Screen");
        setLocationRelativeTo(null);

        backButton.addActionListener(this);
        noLossCheck.addActionListener(this);
        dimSlider.setMaximum(255);
        dimSlider.addMouseListener(this);
        laneL.addActionListener(this);
        laneML.addActionListener(this);
        laneMR.addActionListener(this);
        laneR.addActionListener(this);
        laneL.addKeyListener(this);
        laneML.addKeyListener(this);
        laneMR.addKeyListener(this);
        laneR.addKeyListener(this);
        backgroundDim = dimSlider.getExtent();
        System.out.println(backgroundDim); // Debug
        noteSpeed = noteSpeedSlider.getExtent() / 10;
        laneBindL = laneL.getText();
        laneBindML = laneML.getText();
        laneBindMR = laneMR.getText();
        laneBindR = laneR.getText();
        noLoss = false;
        dimSlider.setSnapToTicks(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Settings(int bgD, char l, char mL, char mR, char r, int nS, boolean nL) throws IOException {
        initComponents();
        setTitle("Settings Screen");
        setLocationRelativeTo(null);
        

        // Set GUI components
        dimSlider.setValue(bgD);
        laneL.setText("Left Lane: " + l);
        laneML.setText("Mid-Left Lane: " + mL);
        laneMR.setText("Mid-Right Lane: " + mR);
        laneR.setText("Right Lane: " + r);
        noteSpeedSlider.setValue(nS * 10);
        noLossCheck.setSelected(nL);

        // Set fields
        backgroundDim = bgD;
        laneBindL = "" + l;
        laneBindML = "" + mL;
        laneBindMR = "" + mR;
        laneBindR = "" + r;
        noteSpeed = nS;
        noLoss = nL;

        backButton.addActionListener(this);
        noLossCheck.addActionListener(this);
        dimSlider.setMaximum(255);
        dimSlider.addMouseListener(this);
        laneL.addActionListener(this);
        laneML.addActionListener(this);
        laneMR.addActionListener(this);
        laneR.addActionListener(this);
        laneL.addKeyListener(this);
        laneML.addKeyListener(this);
        laneMR.addKeyListener(this);
        laneR.addKeyListener(this);
        backgroundDim = dimSlider.getExtent();
        System.out.println(backgroundDim); // Debug
        noteSpeed = noteSpeedSlider.getExtent() / 10;
        laneBindL = laneL.getText();
        laneBindML = laneML.getText();
        laneBindMR = laneMR.getText();
        laneBindR = laneR.getText();
        noLoss = false;
        dimSlider.setSnapToTicks(true);

        // Add listeners, etc. (copy from no-arg constructor)
        // ...
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getBackgroundDim() {
        return backgroundDim;
    }

    public int getNoteSpeed() {
        return noteSpeed;
    }

    public String getLaneBindL() {
        return laneBindL;
    }

    public String getLaneBindML() {
        return laneBindML;
    }

    public String getLaneBindMR() {
        return laneBindMR;
    }

    public String getLaneBindR() {
        return laneBindR;
    }

    public boolean isNoLoss() {
        return noLoss;
    }

    public void setBackgroundDim(int backgroundDim) {
        this.backgroundDim = backgroundDim;
    }

    public void setNoteSpeed(int noteSpeed) {
        this.noteSpeed = noteSpeed;
    }

    public void setLaneBindL(String laneBindL) {
        this.laneBindL = laneBindL;
    }

    public void setLaneBindML(String laneBindML) {
        this.laneBindML = laneBindML;
    }

    public void setLaneBindMR(String laneBindMR) {
        this.laneBindMR = laneBindMR;
    }

    public void setLaneBindR(String laneBindR) {
        this.laneBindR = laneBindR;
    }

    public void setNoLoss(boolean noLoss) {
        this.noLoss = noLoss;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        backButton = new javax.swing.JButton();
        settingsTitle = new javax.swing.JLabel();
        dimPrompt = new javax.swing.JLabel();
        dimSlider = new javax.swing.JSlider();
        keybindPrompt = new javax.swing.JLabel();
        laneL = new javax.swing.JButton();
        laneML = new javax.swing.JButton();
        laneMR = new javax.swing.JButton();
        laneR = new javax.swing.JButton();
        noteSpeedL = new javax.swing.JLabel();
        noteSpeedSlider = new javax.swing.JSlider();
        leftLaneL = new javax.swing.JLabel();
        midLeftLaneL = new javax.swing.JLabel();
        midRightLaneL = new javax.swing.JLabel();
        rightLaneL = new javax.swing.JLabel();
        noLossL = new javax.swing.JLabel();
        noLossCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 400, 400, 400));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backButton.setText("<---");

        settingsTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        settingsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsTitle.setText("SETTINGS");

        dimPrompt.setText("Background Dim:");

        dimSlider.setValue(100);

        keybindPrompt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        keybindPrompt.setText("Keybinds: ");

        laneL.setText("D");

        laneML.setText("F");

        laneMR.setText("J");

        laneR.setText("K");

        noteSpeedL.setText("Note Speed:");

        leftLaneL.setText("Left Lane:");

        midLeftLaneL.setText("Mid-Left Lane:");

        midRightLaneL.setText("Mid-Right Lane:");

        rightLaneL.setText("Right Lane:");

        noLossL.setText("No Loss:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(keybindPrompt)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(noteSpeedL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noteSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(dimPrompt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(leftLaneL, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(midLeftLaneL, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(midRightLaneL, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rightLaneL, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(61, 61, 61)
                                                                .addComponent(settingsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(laneL)
                                                                        .addComponent(laneML)
                                                                        .addComponent(laneMR)
                                                                        .addComponent(laneR)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dimSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(noLossL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noLossCheck)))
                                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(settingsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dimPrompt)
                                        .addComponent(dimSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keybindPrompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(laneL)
                                        .addComponent(leftLaneL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(laneML)
                                        .addComponent(midLeftLaneL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(laneMR)
                                        .addComponent(midRightLaneL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(laneR)
                                        .addComponent(rightLaneL))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(noteSpeedL)
                                        .addComponent(noteSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(noLossL)
                                        .addComponent(noLossCheck))
                                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>                        

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("settings.txt", true))) {
            writer.println("backgroundDim = " + backgroundDim);
            writer.println("laneBindL = " + laneBindL);
            writer.println("laneBindML = " + laneBindML);
            writer.println("laneBindMR = " + laneBindMR);
            writer.println("laneBindR = " + laneBindR);
            writer.println("noteSpeed = " + noteSpeed);
            writer.println("noLoss = " + noLoss);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saving To File!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Settings().setVisible(true);
            } catch (IOException ex) {
                System.getLogger(Settings.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            try {
                new Menu();
            } catch (IOException ex) {
                System.getLogger(Settings.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            dispose();
        }

        if (e.getSource() == noLossCheck) {
            noLoss = noLossCheck.isSelected();
            settings.setNoLoss(noLoss);
        }
        if (e.getSource() == laneL) {
            laneL.setText("...");
            waitForLaneL = true; // Start waiting for key input
        }
        
        if (e.getSource() == laneML) {
            laneML.setText("...");
            waitForLaneML = true; // Start waiting for key input
        }
        
        if (e.getSource() == laneMR) {
            laneMR.setText("...");
            waitForLaneMR = true; // Start waiting for key input
        }
        
        if (e.getSource() == laneR) {
            laneR.setText("...");
            waitForLaneR = true; // Start waiting for key input
        }
    }
    
    
    
    public void loadFromFile() {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("settings.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length < 2) {
                    continue;
                }
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "backgroundDim":
                        backgroundDim = Integer.parseInt(value);
                        break;
                    case "laneBindL":
                        laneBindL = value;
                        break;
                    case "laneBindML":
                        laneBindML = value;
                        break;
                    case "laneBindMR":
                        laneBindMR = value;
                        break;
                    case "laneBindR":
                        laneBindR = value;
                        break;
                    case "noteSpeed":
                        noteSpeed = Integer.parseInt(value);
                        break;
                    case "noLoss":
                        noLoss = Boolean.parseBoolean(value);
                        break;
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            // Optionally set defaults here if file doesn't exist
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == dimSlider) {
            backgroundDim = dimSlider.getValue();
            settings.setBackgroundDim(backgroundDim);
            System.out.println(backgroundDim); // Debug
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (waitForLaneL) {
            char key = e.getKeyChar();
            laneBindL = String.valueOf(key);
            laneL.setText(laneBindL.toUpperCase()); // Show new keybind on button
            waitForLaneL = false; // Reset flag

            settings.setLaneBindL(laneBindL);
        }
        if (waitForLaneML) {
            char key = e.getKeyChar();
            laneBindML = String.valueOf(key);
            laneML.setText(laneBindML.toUpperCase()); // Show new keybind on button
            waitForLaneML = false; // Reset flag

            settings.setLaneBindML(laneBindML);
        }
        
        if (waitForLaneMR) {
            char key = e.getKeyChar();
            laneBindMR = String.valueOf(key);
            laneMR.setText(laneBindMR.toUpperCase()); // Show new keybind on button
            waitForLaneMR = false; // Reset flag
            settings.setLaneBindMR(laneBindMR);
        }
        
         if (waitForLaneR) {
            char key = e.getKeyChar();
            laneBindR = String.valueOf(key);
            laneR.setText(laneBindR.toUpperCase()); // Show new keybind on button
            waitForLaneR = false; // Reset flag
            settings.setLaneBindR(laneBindR);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
