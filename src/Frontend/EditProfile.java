/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import connecthub.entities.Profile;
import connecthub.entities.User;
import connecthub.mappers.ProfileMapper;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Mahinour Mohamed
 */
public class EditProfile extends javax.swing.JFrame {
    User u;
    Profile p;
    /**
     * Creates new form EditProfile
     */
    public EditProfile(User u,Profile p) {
        initComponents();
        this.u=u;
        this.p=p;
        bioText.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coverPhoto = new javax.swing.JToggleButton();
        profilePhoto = new javax.swing.JToggleButton();
        bio = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit profile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        coverPhoto.setBackground(new java.awt.Color(0, 51, 102));
        coverPhoto.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        coverPhoto.setForeground(new java.awt.Color(255, 255, 255));
        coverPhoto.setText("Change Cover photo");
        coverPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coverPhotoActionPerformed(evt);
            }
        });

        profilePhoto.setBackground(new java.awt.Color(0, 51, 102));
        profilePhoto.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        profilePhoto.setForeground(new java.awt.Color(255, 255, 255));
        profilePhoto.setText("Change Profile photo");
        profilePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePhotoActionPerformed(evt);
            }
        });

        bio.setBackground(new java.awt.Color(0, 51, 102));
        bio.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        bio.setForeground(new java.awt.Color(255, 255, 255));
        bio.setText("Edit Bio");
        bio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bioActionPerformed(evt);
            }
        });

        bioText.setColumns(20);
        bioText.setRows(5);
        bioText.setText("\n\n");
        jScrollPane1.setViewportView(bioText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bio, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(coverPhoto)
                .addGap(26, 26, 26)
                .addComponent(profilePhoto)
                .addGap(27, 27, 27)
                .addComponent(bio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coverPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coverPhotoActionPerformed
       try{ JFileChooser x = new JFileChooser();
        x.showOpenDialog(this);
        File f = x.getSelectedFile();
       p.setCoverPhotoPath(f.getAbsolutePath());
       ProfileMapper.update(p.getID(), p);
       }
       catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_coverPhotoActionPerformed

    private void profilePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePhotoActionPerformed
       try{
        JFileChooser x = new JFileChooser();
        x.showOpenDialog(this);
        File f = x.getSelectedFile();
       p.setProfilePhotoPath(f.getAbsolutePath());
       ProfileMapper.update(p.getID(), p);
       }
       catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null, "ERROR", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_profilePhotoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        FrontProfile front= FrontProfile.getInstanceOf();
      front.setVisible(true);
      front.setLocation(null);
      setVisible(false);
        
    }//GEN-LAST:event_formWindowClosing

    private void bioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bioActionPerformed
     bioText.setVisible(true);
     try{
         String bio=bioText.getText();
         if(bio.isEmpty())
              javax.swing.JOptionPane.showMessageDialog(null, "Some fields are empty!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
         else 
         {  p.setBio(bio);
            ProfileMapper.update(p.getID(), p);
         }
     }
     catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null, "ERROR!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
     }   
    }//GEN-LAST:event_bioActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bio;
    private javax.swing.JTextArea bioText;
    private javax.swing.JToggleButton coverPhoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton profilePhoto;
    // End of variables declaration//GEN-END:variables
}
