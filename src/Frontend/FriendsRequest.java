/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import connecthub.FriendsManager;
import connecthub.controllers.FriendController;
import connecthub.entities.FriendRequest;
import connecthub.entities.User;
import connecthub.mappers.FriendRequestMapper;
import connecthub.mappers.UserMapper;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahinour Mohamed
 */
public class FriendsRequest extends javax.swing.JFrame {

    User u;
    FriendsManagement f;
    List<FriendRequest> friendRequestList;

    /**
     * Creates new form FriendsRequest
     */
    public FriendsRequest(User u, FriendsManagement f) {
        initComponents();
        this.f = f;
        this.u = u;
        fillList();
    }

    private void fillList() {
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        friendRequestList = FriendController.getFriendRequests(u.getID());
        for (FriendRequest friendRequest : friendRequestList) {
            Optional<User> user = UserMapper.get(friendRequest.getSenderId());
            if (user.isPresent()) {
                User foundUser = user.get();
                listModel.addElement(foundUser.getUsername());
            }
        }
        requestList.setModel(listModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestList = new javax.swing.JList<>();
        accept = new javax.swing.JToggleButton();
        remove = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Friends Requests");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(0, 51, 102));
        label.setText("        Friends Requests");

        jScrollPane1.setViewportView(requestList);

        accept.setBackground(new java.awt.Color(0, 51, 102));
        accept.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        accept.setForeground(new java.awt.Color(255, 255, 255));
        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(204, 51, 0));
        remove.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(remove))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int index = requestList.getSelectedIndex();

            if (index != 0) {
                FriendsManager.acceptFriendRequest(friendRequestList.get(index));
                fillList();
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_acceptActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int index = requestList.getSelectedIndex();

            if (index != 0) {
                if (FriendRequestMapper.delete(friendRequestList.get(index).getID())) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Remove Successfully", "Message", javax.swing.JOptionPane.ERROR_MESSAGE);

                    fillList();
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_removeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (u == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            f.setVisible(true);
            f.setLocation(null);
            setVisible(false);
        } catch (Exception e) {

        }

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton accept;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JToggleButton remove;
    private javax.swing.JList<String> requestList;
    // End of variables declaration//GEN-END:variables
}
