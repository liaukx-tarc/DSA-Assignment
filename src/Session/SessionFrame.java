package Session;

import static Session.SingingSession.chooseSessionFrame;
import static Session.SingingSession.currentUser;
import static Session.SingingSession.session;
import static Session.SingingSession.sessionFrame;
import static Session.SingingSession.songEndTime;
import static Session.SingingSession.songQueue;
import java.time.LocalTime;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class SessionFrame extends javax.swing.JFrame {

    public static boolean adding = false;
    DefaultListModel memberJoinList = new DefaultListModel();

    public SessionFrame() {
        initComponents();
        String[] name = {"No.", "Singer", "Song", "Duration"};

        jInternalFrame1.setTitle(session.getSessionName());
        memberJoinedList.setModel(memberJoinList);
        songQueue = session.getSongQueue();
        songQueueList.setModel(new DefaultTableModel(name, songQueue.countEntry()));
    }

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
        durationField = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberJoinedList = new javax.swing.JList<>();
        memberJoinedText = new javax.swing.JTextPane();
        exitButton = new javax.swing.JButton();

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        songQueueList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        songQueueList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(skipSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(songProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addGap(12, 12, 12)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(songProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songProgressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipSongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        memberJoinedList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(memberJoinedList);

        memberJoinedText.setEditable(false);
        memberJoinedText.setBorder(null);
        memberJoinedText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        memberJoinedText.setText("Member Joined");

        exitButton.setBackground(new java.awt.Color(255, 102, 102));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(memberJoinedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberJoinedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipSongButtonActionPerformed
        int chooseIndex = songQueueList.getSelectedRow();
        songQueue = session.getSongQueue();
        songQueue.RemoveEntry(chooseIndex + 1);
        session.setSongQueue(songQueue);
        refreshList();
    }//GEN-LAST:event_skipSongButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!adding) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ChooseSongFrame().setVisible(true);
                }
            });
            adding = true;
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void skipNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipNextButtonActionPerformed
        songQueue = session.getSongQueue();
        songQueue.removeFirst();
        session.setSongQueue(songQueue);
        refreshList();
    }//GEN-LAST:event_skipNextButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                chooseSessionFrame.setVisible(true);
                sessionFrame.dispose();
            }
        });

        int index[] = session.getMemberList().include(currentUser);
        session.getMemberList().remove(index[1]);
    }//GEN-LAST:event_exitButtonActionPerformed

    public void refreshList() {
        int i = 0;
        songQueue = session.getSongQueue();
        Iterator<SelectedSong> iterator = songQueue.getIterator();

        String[] name = {"No.", "Singer", "Song", "Duration"};
        DefaultTableModel newTable = new DefaultTableModel(name, songQueue.countEntry()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        songQueueList.setModel(newTable);

        while (iterator.hasNext()) {
            SelectedSong nextSong = iterator.next();

            int songLenghtInSec = nextSong.getSong().getSongLength();
            String songLenght = String.format("%4d:%02d", songLenghtInSec / 60, songLenghtInSec % 60);
            songQueueList.setValueAt(i + 1 + ".", i, 0);
            songQueueList.setValueAt(nextSong.getMember().getMemberName(), i, 1);
            songQueueList.setValueAt(nextSong.getSong().getName(), i, 2);
            songQueueList.setValueAt(songLenght, i, 3);
            i++;
        }
    }

    public void updateMemberJoinedList() {
        memberJoinList.clear();
        for (int i = 0; i < session.getMemberList().getTotal(); i++) {
            memberJoinList.addElement(session.getMemberList().getEntry(i + 1).getMemberName());
        }
    }

    public void nextSong() {
        songQueue = session.getSongQueue();
        if (!songQueue.checkEmpty()) {
            session.setCurrentSong(songQueue.peek());
            session.setSongQueue(songQueue);
            singerField.setText(session.getCurrentSong().getMember().getMemberName());
            songField.setText(session.getCurrentSong().getSong().getName());
            songEndTime = LocalTime.now().plusSeconds(session.getCurrentSong().getSong().getSongLength());
            refreshList();
        }

    }

    public void updateCurrentSong() {
        singerField.setText(session.getCurrentSong().getMember().getMemberName());
        songField.setText(session.getCurrentSong().getSong().getName());
    }

    public void updateProgress() {
        if (session.getCurrentSong() != null) {
            //progress bar
            float currentTIme = (LocalTime.now().getHour() * 3600) + (LocalTime.now().getMinute() * 60) + (LocalTime.now().getSecond());
            float endTime = (songEndTime.getHour() * 3600) + (songEndTime.getMinute() * 60) + (songEndTime.getSecond());
            float songLength = session.getCurrentSong().getSong().getSongLength();

            float progressPercent = (songLength - (endTime - currentTIme)) / (songLength) * 100;

            songProgressBar.setValue((int) progressPercent);

            //Duration Time
            int timePass = (int) songLength - ((int) endTime - (int) currentTIme);
            String durationText = "";
            durationText += String.format("%4d:%02d", timePass / 60, timePass % 60) + " / " + String.format("%4d:%02d", (int) songLength / 60, (int) songLength % 60);
            durationField.setText(durationText);

        } else {
            songProgressBar.setValue(0);
        }

    }

    public void clearCurrentSong() {
        songField.setText(null);
        singerField.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel curSingerLabel;
    private javax.swing.JLabel curSongLabel;
    private javax.swing.JTextPane durationField;
    private javax.swing.JButton exitButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> memberJoinedList;
    private javax.swing.JTextPane memberJoinedText;
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
