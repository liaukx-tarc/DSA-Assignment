package Session;

import static Session.SingingSession.currentUser;
import static Session.SingingSession.session;
import static Session.SingingSession.songList;
import static Session.SingingSession.songQueue;
import javax.swing.table.DefaultTableModel;

public class ChooseSongFrame extends javax.swing.JFrame {

    public ChooseSongFrame() {
        initComponents();
        String[] name = {"Name", "Song Legth"};
        DefaultTableModel newTable = new DefaultTableModel(name, songList.getSongList().getTotal()){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        songListUI.setModel(newTable);
        for (int i = 0; i < songList.getSongList().getTotal(); i++) {
            int songLenghtInSec = songList.getSongList().getEntry(i + 1).getSongLength();
            String songLenght = String.format("%4d:%02d", songLenghtInSec / 60, songLenghtInSec % 60);

            songListUI.setValueAt(songList.getSongList().getEntry(i + 1).getName(), i, 0);
            songListUI.setValueAt(songLenght, i, 1);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        songListPane = new javax.swing.JScrollPane();
        songListUI = new javax.swing.JTable();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        skipQueueLabel = new javax.swing.JLabel();
        noField = new javax.swing.JFormattedTextField();
        hintLabel = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        songListUI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        songListPane.setViewportView(songListUI);

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        skipQueueLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        skipQueueLabel.setText("Skip Queue : ");

        noField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        noField.setText("0");
        noField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noFieldActionPerformed(evt);
            }
        });

        hintLabel.setText("Write where u want to skip in (0 is no skip)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songListPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(skipQueueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(noField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipQueueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hintLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        super.dispose();
        SessionFrame.adding = false;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (songListUI.getSelectedRowCount() == 1) {
            
            int selectNum = songListUI.getSelectedRow();
            int placeChoose = Integer.parseInt(noField.getText());
            SelectedSong chooseSong;

            chooseSong = new SelectedSong(currentUser, songList.getSongList().getEntry(selectNum + 1));

            if (placeChoose <= session.getSongQueue().countEntry() && placeChoose != 0) {
                if (placeChoose < 0) {
                    placeChoose = 1;
                }
                songQueue.insertEntry(chooseSong, placeChoose);
                session.setSongQueue(songQueue);

            } else {
                songQueue.addQueue(chooseSong);
                session.setSongQueue(songQueue);
            }
            
            if (session.getCurrentSong() == null) {
                SingingSession.sessionFrame.nextSong();
            }
            SingingSession.sessionFrame.refreshList();

            super.dispose();
            SessionFrame.adding = false;
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void noFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel hintLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField noField;
    private javax.swing.JLabel skipQueueLabel;
    private javax.swing.JScrollPane songListPane;
    private javax.swing.JTable songListUI;
    // End of variables declaration//GEN-END:variables
}
