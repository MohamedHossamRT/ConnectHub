/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import connecthub.controllers.FriendController;
import connecthub.entities.Friend;
import connecthub.entities.User;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahinour Mohamed
 */
public class FriendsManagement extends javax.swing.JFrame {

    User u;
    List<User> friends;
    /**
     * Creates new form FriendsManegment
     */
    public FriendsManagement(User u) {
        initComponents();
        this.u = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        friendsRequests = new javax.swing.JToggleButton();
        friendsList = new javax.swing.JToggleButton();
        friendSuggestion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Friends Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        friendsRequests.setBackground(new java.awt.Color(0, 51, 102));
        friendsRequests.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        friendsRequests.setForeground(new java.awt.Color(255, 255, 255));
        friendsRequests.setText("Friends Requests");
        friendsRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsRequestsActionPerformed(evt);
            }
        });

        friendsList.setBackground(new java.awt.Color(0, 51, 102));
        friendsList.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        friendsList.setForeground(new java.awt.Color(255, 255, 255));
        friendsList.setText("Friends List");
        friendsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsListActionPerformed(evt);
            }
        });

        friendSuggestion.setBackground(new java.awt.Color(0, 51, 102));
        friendSuggestion.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        friendSuggestion.setForeground(new java.awt.Color(255, 255, 255));
        friendSuggestion.setText("Friends Suggestions");
        friendSuggestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendSuggestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(friendsRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendSuggestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(friendsRequests)
                .addGap(32, 32, 32)
                .addComponent(friendsList)
                .addGap(29, 29, 29)
                .addComponent(friendSuggestion)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void friendsRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsRequestsActionPerformed

        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            FriendsRequest f = new FriendsRequest(u, this);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            setVisible(false);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_friendsRequestsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            FrontProfile f = FrontProfile.getInstanceOf();
            f.setVisible(true);
            f.handleButtonsTrue();
            f.setLocationRelativeTo(null);
            setVisible(false);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void friendsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsListActionPerformed
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            FriendsList f = new FriendsList(u, this);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            setVisible(false);
        } catch (Exception e) {

        }

    }//GEN-LAST:event_friendsListActionPerformed

    private void friendSuggestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendSuggestionActionPerformed
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            friends = FriendController.suggestFriends(u.getID());

            if (friends == null || friends.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No friends to suggest.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            FriendSuggestion f = new FriendSuggestion(u, this);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
            setVisible(false);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_friendSuggestionActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton friendSuggestion;
    private javax.swing.JToggleButton friendsList;
    private javax.swing.JToggleButton friendsRequests;
    // End of variables declaration//GEN-END:variables
}
