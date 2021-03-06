/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class JFramePropertyOwnerAddProperty extends javax.swing.JFrame {

    /**
     * Creates new form JFramePropertyOwnerAddProperty
     */
    public JFramePropertyOwnerAddProperty() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private PropertyOwner owner;
    public JFramePropertyOwnerAddProperty(PropertyOwner owner) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGrantID = new javax.swing.JTextField();
        jTextFieldOwnerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAddress1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonSaveChanges = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPropertyPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldAddress2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAddress3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldAddress4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumBathroom = new javax.swing.JTextField();
        jTextFieldNumRoom = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxProjectName = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxCurrentStatus = new javax.swing.JComboBox<>();
        jCheckBoxSwimmingPool = new javax.swing.JCheckBox();
        jCheckBoxTV = new javax.swing.JCheckBox();
        jCheckBoxWifi = new javax.swing.JCheckBox();
        jCheckBoxAC = new javax.swing.JCheckBox();
        jCheckBoxFridge = new javax.swing.JCheckBox();
        jCheckBoxWaterHeater = new javax.swing.JCheckBox();
        jCheckBoxWashingMachine = new javax.swing.JCheckBox();
        jCheckBoxGymRoom = new javax.swing.JCheckBox();
        jCheckBoxBalcony = new javax.swing.JCheckBox();
        jComboBoxPropertyType = new javax.swing.JComboBox<>();
        jTextFieldPropertySize = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Property");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldGrantID.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jTextFieldOwnerName.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Property Type:");

        jTextFieldAddress1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Rental Rate (Number only)*");

        jButtonSaveChanges.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButtonSaveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOAD_Assignment/save.png"))); // NOI18N
        jButtonSaveChanges.setText("Add Property");
        jButtonSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChangesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Owner Name*");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Owner Grant ID*");

        jTextFieldPropertyPrice.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Unit No*");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Street*");

        jTextFieldAddress2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Garden*");

        jTextFieldAddress3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Postcode*");

        jTextFieldAddress4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Number Of Bathroom (Number only)*");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setText("Number Of Room (Number only)*");

        jTextFieldNumBathroom.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jTextFieldNumRoom.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Project Name:");

        jComboBoxProjectName.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jComboBoxProjectName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cyberia", "Third Avenue", "Solstice", "Eclipse Residence", "Cristal Serin Residence", "Kenwingston Square Garden", "Symphony Hills Mozart Type", "Kanvas Soho", "Centrus Soho", "Lakefront Residence", "Verdi Eco-Dominiums", "Aspen @ Garden Residence", "Tamarind Suites", "Cybersquare", "Sky Park", "Mutiara Ville" }));
        jComboBoxProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProjectNameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Status:");

        jComboBoxCurrentStatus.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jComboBoxCurrentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactive", "Active" }));
        jComboBoxCurrentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCurrentStatusActionPerformed(evt);
            }
        });

        jCheckBoxSwimmingPool.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxSwimmingPool.setText("Swimming Pool");

        jCheckBoxTV.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxTV.setText("TV");

        jCheckBoxWifi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxWifi.setText("Wifi");

        jCheckBoxAC.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxAC.setText("Air-Conditioner");

        jCheckBoxFridge.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxFridge.setText("Fridge");

        jCheckBoxWaterHeater.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxWaterHeater.setText("Water Heater");

        jCheckBoxWashingMachine.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxWashingMachine.setText("Washing Machine");

        jCheckBoxGymRoom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxGymRoom.setText("Gym Room");

        jCheckBoxBalcony.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxBalcony.setText("Balcony");

        jComboBoxPropertyType.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jComboBoxPropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bungalow", "Semi-D", "Terrace/Link", "Townhouse", "Penthouse", "Condominium", "Duplex/Studio", "Apartment/Flat", "SoHo/SoVo/SoFo", "Mixed Development" }));
        jComboBoxPropertyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPropertyTypeActionPerformed(evt);
            }
        });

        jTextFieldPropertySize.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Size in sqrt (Number only)*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxAC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxWifi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSwimmingPool)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxFridge))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxWaterHeater)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxGymRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSaveChanges)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxBalcony)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxWashingMachine))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldGrantID)
                                .addComponent(jTextFieldPropertyPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jTextFieldOwnerName)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldNumRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel13)
                                .addComponent(jComboBoxPropertyType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldPropertySize, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPropertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPropertySize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGrantID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumBathroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxSwimmingPool, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxAC)
                        .addComponent(jCheckBoxWifi)
                        .addComponent(jCheckBoxTV)
                        .addComponent(jCheckBoxFridge)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxWaterHeater)
                    .addComponent(jCheckBoxGymRoom)
                    .addComponent(jCheckBoxBalcony)
                    .addComponent(jCheckBoxWashingMachine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChangesActionPerformed
        
        // Check values are inserted by the user or not
        if (jTextFieldAddress1.getText().isBlank() || jTextFieldAddress2.getText().isBlank() ||
                jTextFieldAddress3.getText().isBlank() || jTextFieldAddress4.getText().isBlank() ||
                jTextFieldGrantID.getText().isBlank() || jTextFieldNumBathroom.getText().isBlank() ||
                jTextFieldNumRoom.getText().isBlank() || jTextFieldOwnerName.getText().isBlank() ||
                jTextFieldPropertyPrice.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please insert all the text field!");
        }
        
        else {
            // Check try catch
            boolean caught = false;
            // Parameters needed
            double propertyPrice = 0;
            double propertySize = 0;
            int numBathroom = 0;
            int numRoom = 0;
            String propertyType;
            String ownerName;
            int uploader_userID;    
            String grantID; 
            String projectName;    
            int currentStatus;
            ArrayList<String> address;
            ArrayList<String> facilities;
           
            // Check numerical value or not
            try {
                caught = false;
                propertyPrice = Double.parseDouble(jTextFieldPropertyPrice.getText().trim());
                propertySize = Double.parseDouble(jTextFieldPropertySize.getText().trim());
                numBathroom = Integer.parseInt(jTextFieldNumBathroom.getText().trim());
                numRoom = Integer.parseInt(jTextFieldNumRoom.getText().trim());
            } catch (NumberFormatException e) {
                caught = true;
                JOptionPane.showMessageDialog(null, "Please insert numerical value in required text field");
            }
            // If numerical value
            if (caught == false) {
                propertyType = jComboBoxPropertyType.getSelectedItem().toString();
                ownerName = jTextFieldOwnerName.getText().trim();
                uploader_userID = owner.getUserID();
                grantID = jTextFieldGrantID.getText().trim();
                projectName = jComboBoxProjectName.getSelectedItem().toString();
                currentStatus = jComboBoxCurrentStatus.getSelectedIndex();
                address = new ArrayList<>();
                address.add(jTextFieldAddress1.getText().trim());
                address.add(jTextFieldAddress2.getText().trim());
                address.add(jTextFieldAddress3.getText().trim());
                address.add(jTextFieldAddress4.getText().trim());
                facilities = new ArrayList<>();
                ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
                checkBoxes.add(jCheckBoxAC);
                checkBoxes.add(jCheckBoxBalcony);
                checkBoxes.add(jCheckBoxFridge);
                checkBoxes.add(jCheckBoxGymRoom);
                checkBoxes.add(jCheckBoxSwimmingPool);
                checkBoxes.add(jCheckBoxTV);
                checkBoxes.add(jCheckBoxWashingMachine);
                checkBoxes.add(jCheckBoxWaterHeater);
                checkBoxes.add(jCheckBoxWifi);
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        facilities.add(checkBoxes.get(i).getText());
                    }
                }
                PropertyManager manager = PropertyManager.getInstance();
                manager.addProperty(propertyType, propertyPrice, propertySize, ownerName, uploader_userID, grantID, 
                        projectName, currentStatus, numBathroom, numRoom, address, facilities);
                JOptionPane.showMessageDialog(null, "Adding Completed!");
                this.dispose();
            }
            
        }
    }//GEN-LAST:event_jButtonSaveChangesActionPerformed

    private void jComboBoxProjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProjectNameActionPerformed

    private void jComboBoxCurrentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCurrentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCurrentStatusActionPerformed

    private void jComboBoxPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPropertyTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPropertyTypeActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerAddProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerAddProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerAddProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerAddProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePropertyOwnerAddProperty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveChanges;
    private javax.swing.JCheckBox jCheckBoxAC;
    private javax.swing.JCheckBox jCheckBoxBalcony;
    private javax.swing.JCheckBox jCheckBoxFridge;
    private javax.swing.JCheckBox jCheckBoxGymRoom;
    private javax.swing.JCheckBox jCheckBoxSwimmingPool;
    private javax.swing.JCheckBox jCheckBoxTV;
    private javax.swing.JCheckBox jCheckBoxWashingMachine;
    private javax.swing.JCheckBox jCheckBoxWaterHeater;
    private javax.swing.JCheckBox jCheckBoxWifi;
    private javax.swing.JComboBox<String> jComboBoxCurrentStatus;
    private javax.swing.JComboBox<String> jComboBoxProjectName;
    private javax.swing.JComboBox<String> jComboBoxPropertyType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAddress1;
    private javax.swing.JTextField jTextFieldAddress2;
    private javax.swing.JTextField jTextFieldAddress3;
    private javax.swing.JTextField jTextFieldAddress4;
    private javax.swing.JTextField jTextFieldGrantID;
    private javax.swing.JTextField jTextFieldNumBathroom;
    private javax.swing.JTextField jTextFieldNumRoom;
    private javax.swing.JTextField jTextFieldOwnerName;
    private javax.swing.JTextField jTextFieldPropertyPrice;
    private javax.swing.JTextField jTextFieldPropertySize;
    // End of variables declaration//GEN-END:variables
}
