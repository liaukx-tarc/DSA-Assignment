package Session;

import java.time.LocalTime;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class SessionFrame extends javax.swing.JFrame {

    public static boolean adding = false;

    public SessionFrame() {
        initComponents();
        String[] name = {"Singer", "Song"};
        songQueueList.setModel(new DefaultTableModel(name,Session.songQueue.countEntry()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        songQueuePanel = new javax.swing.JScrollPane();
        songQueueList = new javax.swing.JTable();
        curSingerLabel = new javax.swing.JLabel();
        songField = new javax.swing.JTextPane();
        curSongLabel = new javax.swing.JLabel();
        singerField = new javax.swing.JTextPane();
        addButton = new javax.swing.JButton();
        skipSongButton = new javax.swing.JButton();
        skipNextButton = new javax.swing.JButton();
        songProgressLabel = new javax.swing.JLabel();
        songProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Singing Session");
        jInternalFrame1.setVisible(true);

        songQueueList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        songQueuePanel.setViewportView(songQueueList);

        curSingerLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        curSingerLabel.setText("Current Singer : ");

        songField.setEditable(false);

        curSongLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        curSongLabel.setText("Current Song :");

        singerField.setEditable(false);

        addButton.setText("Add Song");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        skipSongButton.setText("Skip Song");
        skipSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipSongButtonActionPerformed(evt);
            }
        });

        skipNextButton.setText("Skip Next");
        skipNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipNextButtonActionPerformed(evt);
            }
        });

        songProgressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        songProgressLabel.setText("Song Progress");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songQueuePanel)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(curSingerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(singerField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(curSongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(songField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(songProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skipNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(songProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(skipSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(singerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curSingerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curSongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songQueuePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(songProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipSongButtonActionPerformed
        int chooseIndex = songQueueList.getSelectedRow();
        Session.songQueue.RemoveEntry(chooseIndex + 1);
        refreshList();
    }//GEN-LAST:event_skipSongButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!adding) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ChooseSongFrame().setVisible(true);
                }
            });
            adding = true;
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void skipNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipNextButtonActionPerformed
        Session.songQueue.removeFirst();
        refreshList();
    }//GEN-LAST:event_skipNextButtonActionPerformed

    public void refreshList() {
        int i=0;
        Iterator<SelectedSong> iterator = Session.songQueue.getIterator();
        
        String[] name = {"Singer", "Song"};
        songQueueList.setModel(new DefaultTableModel(name,Session.songQueue.countEntry()));
        
        while (iterator.hasNext()) {
            SelectedSong nextSong = iterator.next();
            songQueueList.setValueAt(nextSong.getMember().name, i, 0);
            songQueueList.setValueAt(nextSong.getSong().getName(), i, 1);
            i++;
        }
    }

    public void nextSong() {
        if (!Session.songQueue.checkEmpty()) {
            Session.currentSong = Session.songQueue.peek();

            singerField.setText(Session.currentSong.getMember().name);
            songField.setText(Session.currentSong.getSong().getName());
            Session.songEndTime = LocalTime.now().plusSeconds(Session.currentSong.getSong().getSongLength());
            refreshList();
        }

    }

    public void updateProgress() {
        if (Session.currentSong != null) {
            float currentTIme = (LocalTime.now().getHour() * 3600) + (LocalTime.now().getMinute() * 60) + (LocalTime.now().getSecond());
            float endTime = (Session.songEndTime.getHour() * 3600) + (Session.songEndTime.getMinute() * 60) + (Session.songEndTime.getSecond());
            float songLength = Session.currentSong.getSong().getSongLength();
            
            float progressPercent = (songLength - (endTime - currentTIme)) / (songLength) * 100;
            
            songProgressBar.setValue((int) progressPercent);
        }
        else{
            songProgressBar.setValue(0);
        }

    }
    
    public void clearCurrentSong(){
        songField.setText(null);
        singerField.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel curSingerLabel;
    private javax.swing.JLabel curSongLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JTextPane singerField;
    private javax.swing.JButton skipNextButton;
    private javax.swing.JButton skipSongButton;
    private javax.swing.JTextPane songField;
    private javax.swing.JProgressBar songProgressBar;
    private javax.swing.JLabel songProgressLabel;
    private javax.swing.JTable songQueueList;
    private javax.swing.JScrollPane songQueuePanel;
    // End of variables declaration//GEN-END:variables
}
