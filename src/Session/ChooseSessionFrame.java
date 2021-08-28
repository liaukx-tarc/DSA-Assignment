/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import MemberMaintenance.MemberComparator;
import static Session.SingingSession.chooseSessionFrame;
import static Session.SingingSession.currentUser;
import static Session.SingingSession.session;
import static Session.SingingSession.sessionFrame;
import static Session.SingingSession.sessionList;
import javax.swing.table.DefaultTableModel;

public class ChooseSessionFrame extends javax.swing.JFrame {

    public ChooseSessionFrame() {
        initComponents();

        String[] name = {"No.", "Session Name", "Member Number"};
        DefaultTableModel newTable = new DefaultTableModel(name, sessionList.getTotal()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        sessionListUI.setModel(newTable);

        for (int i = 0; i < sessionList.getTotal(); i++) {
            sessionListUI.setValueAt(i + 1, i, 0);
            sessionListUI.setValueAt(sessionList.getEntry(i + 1).getSessionName(), i, 1);
            sessionListUI.setValueAt(sessionList.getEntry(i + 1).getMemberList().getTotal(), i, 2);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sessionListPane = new javax.swing.JScrollPane();
        sessionListUI = new javax.swing.JTable();
        titleText = new javax.swing.JLabel();
        joinButton = new javax.swing.JButton();
        addNewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sessionListUI.setModel(new javax.swing.table.DefaultTableModel(
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
        sessionListPane.setViewportView(sessionListUI);

        titleText.setText("Choose Session");

        joinButton.setText("Join");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

        addNewButton.setText("Add New");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(titleText)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sessionListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addNewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(joinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joinButton)
                    .addComponent(addNewButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        if (sessionListUI.getSelectedColumnCount() == 1) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sessionFrame.setVisible(true);
                    chooseSessionFrame.dispose();
                }
            });

            int selectedSession = sessionListUI.getSelectedRow();
            session = sessionList.getEntry(selectedSession + 1);

            sessionFrame = new SessionFrame();
            if (session.getCurrentSong() != null) {
                sessionFrame.updateCurrentSong();
            }

            sessionFrame.refreshList();
            session.getMemberList().add(currentUser);
        }

    }//GEN-LAST:event_joinButtonActionPerformed

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sessionFrame.setVisible(true);
                chooseSessionFrame.dispose();
            }
        });
        session = new Session("Session " + (sessionList.getTotal() + 1));
        sessionFrame = new SessionFrame();
        session.getMemberList().setComparator(new MemberComparator(2));
        session.getMemberList().add(currentUser);
    }//GEN-LAST:event_addNewButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton joinButton;
    private javax.swing.JScrollPane sessionListPane;
    private javax.swing.JTable sessionListUI;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
