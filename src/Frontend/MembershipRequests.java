/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import connecthub.GroupAuthorityManager;
import connecthub.entities.Group;
import connecthub.entities.MembershipRequest;
import connecthub.entities.User;
import connecthub.mappers.MembershipRequestMapper;
import connecthub.mappers.UserMapper;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahinour Mohamed
 */
public class MembershipRequests extends javax.swing.JFrame {

    /**
     * Creates new form MembershipRequests
     */
    Group group;
    User user;
    GroupProfile groupProfile;
    List<MembershipRequest> requests;
    public MembershipRequests(Group group,GroupProfile groupProfile,User user) {
        initComponents();
        this.group=group;
        this.groupProfile=groupProfile;
        this.user=user;
        fillList();
    }
    private void fillList() {
        if (group == null) {
            JOptionPane.showMessageDialog(this,
                    "Group or GroupProfile data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        requests = MembershipRequestMapper.getAllForGroup(group.getID());
        for (MembershipRequest request : requests) {
            Optional<User> user = UserMapper.get(request.getUserID());
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
        accept = new javax.swing.JToggleButton();
        decline = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Membersip Requests");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(0, 51, 102));
        label.setText("   Membership Requests");

        accept.setBackground(new java.awt.Color(0, 51, 102));
        accept.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        accept.setForeground(new java.awt.Color(255, 255, 255));
        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        decline.setBackground(new java.awt.Color(204, 51, 0));
        decline.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        decline.setForeground(new java.awt.Color(255, 255, 255));
        decline.setText("Decline");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(requestList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(decline, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(decline))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGap(57, 57, 57)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
         if (group == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int index = requestList.getSelectedIndex();

            if (index >= 0) {
                GroupAuthorityManager.acceptMembershipRequest(requests.get(index),user.getID());
                fillList();
                javax.swing.JOptionPane.showMessageDialog(null, " Successfully", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_acceptActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        if (group == null) {
            JOptionPane.showMessageDialog(this,
                    "User or Newsfeed data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int index = requestList.getSelectedIndex();

            if (index >= 0) {
                GroupAuthorityManager.declineMembershipRequest(requests.get(index),user.getID());
                fillList();
                javax.swing.JOptionPane.showMessageDialog(null, " Successfully", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_declineActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (user == null||group==null||groupProfile==null) {
            JOptionPane.showMessageDialog(this,
                    "User or GroupProfile or group data is missing. Please log in again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            groupProfile.setVisible(true);
            groupProfile.setLocationRelativeTo(null);
            setVisible(false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton accept;
    private javax.swing.JToggleButton decline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JList<String> requestList;
    // End of variables declaration//GEN-END:variables
}
