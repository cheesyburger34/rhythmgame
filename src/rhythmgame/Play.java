/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rhythmgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author lcros3
 */
public class Play extends javax.swing.JFrame implements ActionListener {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Play.class.getName());
    private Song song;
    private Clip clip;

    /**
     * Creates new form Play
     *
     * @param song
     */
    // Variables declaration
    private long songStartTime; // delay before song starts
    private ArrayList<Note> notes;
    private ArrayList<Note> baseNotes;
    private GamePanel gamePanel;

    private JLabel accPlay;
    private JButton backButton;
    private JButton startSongBtn;
    private JLabel badPlay;
    private JLabel goodPlay;
    //private JPanel jPanel1;
    private JLabel missPlay;
    private JLabel rankPlay;
    private JLabel scorePlay;
    private JLabel sickPlay;
    private JProgressBar songProgress;

    private double noteSpeed;
    private long songDuration;
    // End of variables declaration                   

    public Play(Song song) {
        initComponents();
        this.song = song;
        setTitle("Play");
        setSize(750, 900);
        setMinimumSize(new Dimension(400, 400));
        Container c = getContentPane();
        c.setLayout(null); // Use null layout for manual positioning
        setLocationRelativeTo(null);

        // Add game panel as the lanes and notes
        gamePanel = new GamePanel(/* parameters */);
        gamePanel.setBounds(0, 0, 750, 900); // Define position and size
        c.add(gamePanel);

        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateNoteSpeed();
            }
        });
        updateNoteSpeed(); // Initial speed calculation

        notes = new ArrayList<>();

        // Configure and position components from initComponents
        backButton.addActionListener(this);
        backButton.setBounds(10, 10, 92, 30);
        // Position rank, accuracy, and score on the left side
        rankPlay.setBounds(20, 400, 50, 50);
        accPlay.setBounds(20, 450, 73, 25);
        scorePlay.setBounds(20, 480, 50, 25);
        // Position feedback labels to the left of the red line (invisible for now)
        sickPlay.setBounds(20, 700, 106, 30);
        goodPlay.setBounds(20, 730, 106, 30);
        badPlay.setBounds(20, 760, 106, 30);
        missPlay.setBounds(20, 790, 106, 30);

        songProgress.setBounds(0, 0, 750, 12);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                // Reposition the start button to stay centered
                startSongBtn.setBounds((width - 150) / 2, (height - 150) / 2, 150, 150);

                // Reposition labels
                rankPlay.setBounds(20, height - 800, 50, 50);
                accPlay.setBounds(20, height - 725, 73, 25);
                scorePlay.setBounds(20, height - 650, 50, 25);

                int btnWidth = 150;
                int btnHeight = 150;
                int btnX = (width - btnWidth) / 2;  // Center horizontally
                int btnY = (height - btnHeight) / 2; // Center vertically
                startSongBtn.setBounds(btnX, btnY, btnWidth, btnHeight);

                // Trigger a refresh
                revalidate();
                repaint();
            }
        });

        System.out.println("Loading: " + song.getMusic());

        // Add startSongBtn (overlay on game panel)
        startSongBtn = new JButton("START");
        startSongBtn.setBounds(350, 325, 150, 150);
        startSongBtn.addActionListener(this);
        c.add(startSongBtn);

        // Set up key listener
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyChar() == 'd') {
                    System.out.println("D key pressed");
                }
            }
        });
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void updateNoteSpeed() {
        int targetY = (int) (gamePanel.getHeight() * 0.8); // Match target line position
        double travelTime = 2.0; // Time in seconds for note to reach target
        noteSpeed = (double) targetY / travelTime; // Speed in pixels per second
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
        rankPlay = new javax.swing.JLabel();
        accPlay = new javax.swing.JLabel();
        scorePlay = new javax.swing.JLabel();
        sickPlay = new javax.swing.JLabel();
        songProgress = new javax.swing.JProgressBar();
        goodPlay = new javax.swing.JLabel();
        badPlay = new javax.swing.JLabel();
        missPlay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(900, 900, 900, 900));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backButton.setText("<---");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        rankPlay.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        rankPlay.setText("D");

        accPlay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        accPlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accPlay.setText("0");

        scorePlay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scorePlay.setText("0");

        sickPlay.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        sickPlay.setText("SICK!");
        sickPlay.setVisible(false);

        goodPlay.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        goodPlay.setText("GOOD!");
        goodPlay.setVisible(false);

        badPlay.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        badPlay.setText("BAD!");
        badPlay.setVisible(false);

        missPlay.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        missPlay.setText("MISS!");
        missPlay.setVisible(false);

//        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 250, Short.MAX_VALUE)
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 599, Short.MAX_VALUE)
//        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(songProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(goodPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sickPlay)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(accPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(rankPlay))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(scorePlay)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(missPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(badPlay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(songProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addGap(30, 30, 30)
                                                .addComponent(scorePlay)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rankPlay)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(accPlay)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sickPlay)
                                                        .addComponent(badPlay))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(goodPlay)
                                                        .addComponent(missPlay))
                                                .addGap(126, 126, 126))
                                        .addGroup(layout.createSequentialGroup()
                                                //.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == backButton) {
            try {
                new SongSelection();
            } catch (IOException ex) {
                System.getLogger(Play.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            dispose();
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startSongBtn) { // prompt to start the song
            playSong();
            startSongBtn.setVisible(false);
            playGame();

        }
    }

    private void startAnimation() {
        // Animation timer: Update every 8ms (~120 FPS, improves performance)
        System.out.println("Beginning start animation"); // debug purposes
        try {
            new Timer(8, e -> {
                long currentTime = System.currentTimeMillis();
                long songTime = currentTime - songStartTime; // Time since song started
                updateNotes(songTime);
                gamePanel.repaint();
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playSong() {
        Timer audioTimer = new javax.swing.Timer(2000, e -> {
            try {
                URL audioUrl = getClass().getResource(song.getMusic());
                if (audioUrl == null) {
                    throw new IOException("Audio file not found: " + song.getMusic());
                }
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                songStartTime = System.currentTimeMillis();
                songDuration = clip.getMicrosecondLength() / 1000; // Duration in ms
                clip.start();
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
                playGame(); // Load notes after clip is opened
                startAnimation(); // Start game loop
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error playing song: " + song.getTitle(),
                        "Audio Error", JOptionPane.ERROR_MESSAGE);
            }
            ((javax.swing.Timer) e.getSource()).stop();
        });
        audioTimer.setRepeats(false);
        audioTimer.start();
    }

    // Got the txt file reader idea for each note from a youtube video
    private void playGame() {
    notes = new ArrayList<>();
    baseNotes = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
            getClass().getResourceAsStream(song.getBeatmap())))) {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            String[] parts = line.split(",");
            if (parts.length == 3) {
                try {
                    long spawnTime = Long.parseLong(parts[0].trim());
                    int lane = Integer.parseInt(parts[1].trim());
                    int type = Integer.parseInt(parts[2].trim());
                    baseNotes.add(new Note((int) spawnTime, lane, type));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid note data: " + line);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading beatmap", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (baseNotes.isEmpty()) {
        System.err.println("No notes loaded from beatmap");
        return;
    }

    // Calculate loop duration as the max spawn time plus a small buffer
    long loopDuration = 0;
    for (Note baseNote : baseNotes) {
        loopDuration = Math.max(loopDuration, baseNote.getSpawnTime());
    }
    loopDuration += 1; // Ensure gap after last note

    // Precompute all notes
    long currentOffset = 0;
    while (currentOffset < songDuration) {
        for (Note baseNote : baseNotes) {
            long newSpawnTime = baseNote.getSpawnTime() + currentOffset;
            if (newSpawnTime >= songDuration) {
                break;
            }
            notes.add(new Note((int) newSpawnTime, baseNote.getLane(), baseNote.getType()));
        }
        currentOffset += loopDuration;
    }
}

    private void updateNotes(long songTime) {
    Iterator<Note> iterator = notes.iterator();
    while (iterator.hasNext()) {
        Note note = iterator.next();
        if (songTime >= note.getSpawnTime()) {
            double elapsed = (songTime - note.getSpawnTime()) / 1000.0;
            note.setYPosition(elapsed * noteSpeed);
            if (note.getYPosition() > gamePanel.getHeight()) {
                iterator.remove();
            }
        }
    }
}

    private class GamePanel extends JPanel {

        private static final int LANE_COUNT = 4;
        private static final int LANE_WIDTH = 100;
        private static final int NOTE_HEIGHT = 20;

        // got this idea from GitHub
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);

            // Calculate dynamic lane positioning
            int panelWidth = getWidth();
            int totalLanesWidth = LANE_COUNT * LANE_WIDTH;
            int startX = (panelWidth - totalLanesWidth) / 2; // Center lanes horizontally

            // Draw lanes
            g.setColor(Color.GRAY);
            for (int i = 0; i < LANE_COUNT; i++) {
                int x = startX + i * LANE_WIDTH;
                g.fillRect(x, 0, LANE_WIDTH - 10, getHeight());
            }
            // Draw target line
            int targetY = (int) (getHeight() * 0.8); // 80% of panel height
            g.setColor(Color.RED);
            g.fillRect(startX, targetY, totalLanesWidth - 10, 5);

            // Draw notes
            g.setColor(Color.GREEN);
            for (Note note : notes) {
                if (note.getYPosition() > 0) {
                    int x = startX + note.getLane() * LANE_WIDTH + 5; // Align with lane
                    int y = (int) note.getYPosition();
                    g.fillRect(x, y, LANE_WIDTH - 20, NOTE_HEIGHT);
                }
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

}
