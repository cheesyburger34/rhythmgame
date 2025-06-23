package rhythmgame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class SongSelection extends JFrame implements ActionListener {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SongSelection.class.getName());

    // Updated Song object with full constructor
    Song song1 = new Song("Somebody Told Me", "The Killers", "EASY", 198, 200, 0, 0, "/music/somebody-told-me.wav", "/beatmaps/song1.notes");



    // GUI Components
    private JButton backButton;
    private JLabel bestAccL;
    private JLabel difficultyL;
    private JLabel numNotesL;
    private JLabel lengthL;
    private JLabel titleL;
    private JButton pressPlay;
    private JLabel selectionTitle;
    private JButton song1Btn;
    private JButton song2Btn;
    private JButton song3Btn;
    private JPanel songInfo;

    // Data Structures
    private ArrayList<Song> songs;
    private Song selectedSong;

    public SongSelection() throws IOException {
        // Initialize songs list and add song1
        songs = new ArrayList<>();
        songs.add(song1);
        songs.add(new Song("Somebody Told Me", "The Killers", "INTERMEDIATE", 197, 480, 0, 0, "/music/somebody-told-me.wav", "/beatmaps/song1_intermediate.notes"));

        // Initialize GUI
        initComponents();
        setTitle("Song Selection");
        setLocationRelativeTo(null);

        // Add action listeners
        backButton.addActionListener(this);
        pressPlay.addActionListener(this);
        song1Btn.addActionListener(this);
        song2Btn.setVisible(false); // Ignored for now
        song3Btn.setVisible(false); // Ignored for now

        // Set initial state
        selectedSong = null;
        updateSongInfo();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        backButton = new JButton();
        selectionTitle = new JLabel();
        songInfo = new JPanel();
        pressPlay = new JButton();
        lengthL = new JLabel();
        bestAccL = new JLabel();
        difficultyL = new JLabel();
        numNotesL = new JLabel();
        song1Btn = new JButton();
        song2Btn = new JButton();
        song3Btn = new JButton();
        titleL = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Song Selection");
        setPreferredSize(new java.awt.Dimension(900, 900));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        backButton.setText("<---");

        selectionTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        selectionTitle.setText("SONG SELECTION");

        songInfo.setBackground(new java.awt.Color(0, 0, 0));

        pressPlay.setFont(new java.awt.Font("Segoe UI", 1, 24));
        pressPlay.setText("PLAY");

        lengthL.setFont(new java.awt.Font("Segoe UI", 1, 18));
        bestAccL.setFont(new java.awt.Font("Segoe UI", 1, 18));
        difficultyL.setFont(new java.awt.Font("Segoe UI", 1, 18));
        numNotesL.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titleL.setFont(new java.awt.Font("Segoe UI", 1, 36));

        song1Btn.setText("SONG 1");
        song2Btn.setText("SONG 2");
        song3Btn.setText("SONG 3");

        // Layout setup )
        GroupLayout songInfoLayout = new GroupLayout(songInfo);
        songInfo.setLayout(songInfoLayout);
        songInfoLayout.setHorizontalGroup(
            songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(songInfoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(songInfoLayout.createSequentialGroup()
                            .addComponent(pressPlay, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 367, Short.MAX_VALUE))
                        .addGroup(songInfoLayout.createSequentialGroup()
                            .addGroup(songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(difficultyL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numNotesL, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(lengthL, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(bestAccL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(titleL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        songInfoLayout.setVerticalGroup(
            songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(songInfoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titleL)
                    .addGap(18, 18, 18)
                    .addGroup(songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(difficultyL)
                        .addComponent(lengthL, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(songInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(numNotesL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bestAccL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(11, 11, 11)
                    .addComponent(pressPlay, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(song3Btn, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(song2Btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(song1Btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                            .addComponent(songInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addGap(237, 237, 237)
                            .addComponent(selectionTitle)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton)
                        .addComponent(selectionTitle))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(song1Btn)
                            .addGap(59, 59, 59)
                            .addComponent(song2Btn)
                            .addGap(58, 58, 58)
                            .addComponent(song3Btn)
                            .addGap(0, 364, Short.MAX_VALUE))
                        .addComponent(songInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );

        pack();
    }

    private void song1BtnActionPerformed(ActionEvent evt) {
        selectedSong = songs.get(0); // Select song1
        updateSongInfo();
    }

    private void pressPlayActionPerformed(ActionEvent evt) throws IOException {
        if (selectedSong != null) {
            new Play(selectedSong);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a song first.", "No Song Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        try {
            new Menu();
            dispose();
        } catch (IOException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void updateSongInfo() {
        if (selectedSong != null) {
            titleL.setText(selectedSong.getTitle().toUpperCase());
            difficultyL.setText("Difficulty: " + selectedSong.getDifficulty());
            lengthL.setText("Length: " + selectedSong.getLength() + " seconds");
            numNotesL.setText("Number of Notes: " + selectedSong.getNumNotes());
            bestAccL.setText("Best Accuracy: " + selectedSong.getBestAcc() + "%");
        } else {
            titleL.setText("Select a Song");
            difficultyL.setText("Difficulty: -");
            lengthL.setText("Length: -");
            numNotesL.setText("Number of Notes: -");
            bestAccL.setText("Best Accuracy: -");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == song1Btn) {
            song1BtnActionPerformed(e);
        } else if (e.getSource() == pressPlay) {
            try {
                pressPlayActionPerformed(e);
            } catch (IOException ex) {
                Logger.getLogger(SongSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == backButton) {
            backButtonActionPerformed(e);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new SongSelection();
            } catch (IOException ex) {
                logger.log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }
}