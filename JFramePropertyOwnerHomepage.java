/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class JFramePropertyOwnerHomepage extends javax.swing.JFrame {

    /**
     * Creates new form PropertyOwnerHomePage
     */
    public JFramePropertyOwnerHomepage() {
        initComponents();
    }
    
    private PropertyOwner owner;
    public JFramePropertyOwnerHomepage(PropertyOwner owner) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.owner = owner;
        
        this.propertyTableInitialize(jTablePropertyListing);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPropertyType = new javax.swing.JComboBox<>();
        jComboBoxMinPrice = new javax.swing.JComboBox<>();
        jComboBoxProjectName = new javax.swing.JComboBox<>();
        jComboBoxMaxPrice = new javax.swing.JComboBox<>();
        jComboBoxCurrentStatus = new javax.swing.JComboBox<>();
        jComboBoxPriceSortingMethod = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jCheckBoxSwimmingPool = new javax.swing.JCheckBox();
        jCheckBoxTV = new javax.swing.JCheckBox();
        jCheckBoxWifi = new javax.swing.JCheckBox();
        jCheckBoxAirConditioner = new javax.swing.JCheckBox();
        jCheckBoxFridge = new javax.swing.JCheckBox();
        jCheckBoxWaterHeater = new javax.swing.JCheckBox();
        jCheckBoxWashingMachine = new javax.swing.JCheckBox();
        jCheckBoxGymRoom = new javax.swing.JCheckBox();
        jCheckBoxBalcony = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePropertyListing = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPropertyID = new javax.swing.JTextField();
        jButtonGetPropertyDetail = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuAdd = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Property Owner");

        jTextFieldAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddressActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Search Address:");

        jComboBoxPropertyType.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxPropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Property Type", "Bungalow", "Semi-D", "Terrace/Link", "Townhouse", "Penthouse", "Condominium", "Duplex/Studio", "Apartment/Flat", "SoHo/SoVo/SoFo", "Mixed Development" }));
        jComboBoxPropertyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPropertyTypeActionPerformed(evt);
            }
        });

        jComboBoxMinPrice.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxMinPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min Price (RM)", "500", "1000", "1500", "2000", "2500", "3000", "3500", "4000", "5000" }));

        jComboBoxProjectName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxProjectName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any Project", "Cyberia", "Third Avenue", "Solstice", "Eclipse Residence", "Cristal Serin Residence", "Kenwingston Square Garden", "Symphony Hills Mozart Type", "Kanvas Soho", "Centrus Soho", "Lakefront Residence", "Verdi Eco-Dominiums", "Aspen @ Garden Residence", "Tamarind Suites", "Cybersquare", "Sky Park", "Mutiara Ville" }));

        jComboBoxMaxPrice.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxMaxPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Max Price (RM)", "500", "1000", "1500", "2000", "2500", "3000", "3500", "4000", "5000" }));

        jComboBoxCurrentStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxCurrentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Current Status", "Inactive", "Active" }));

        jComboBoxPriceSortingMethod.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxPriceSortingMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Price low to high", "Price high to low" }));

        jButtonSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("rsz_1rsz_home-alt-512.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jCheckBoxSwimmingPool.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxSwimmingPool.setText("Swimming Pool");

        jCheckBoxTV.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxTV.setText("TV");

        jCheckBoxWifi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxWifi.setText("Wifi");

        jCheckBoxAirConditioner.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCheckBoxAirConditioner.setText("Air-Conditioner");

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

        jTablePropertyListing.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTablePropertyListing.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePropertyListing);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Property Owner Homepage");

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

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Insert Property ID To Get Property Details:");

        jTextFieldPropertyID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTextFieldPropertyID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPropertyIDActionPerformed(evt);
            }
        });

        jButtonGetPropertyDetail.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButtonGetPropertyDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("rsz_1rsz_home-alt-512.png"))); // NOI18N
        jButtonGetPropertyDetail.setText("Get");
        jButtonGetPropertyDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetPropertyDetailActionPerformed(evt);
            }
        });

        jMenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("Webp.net-resizeimage.png"))); // NOI18N
        jMenuFile.setText("Account");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("edit.png"))); // NOI18N
        jMenuItem2.setText("Edit Account Information");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("exit.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem1);

        jMenuBar1.add(jMenuFile);

        jMenuAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("edit.png"))); // NOI18N
        jMenuAdd.setText("Property");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("rsz_1rsz_home-alt-512.png"))); // NOI18N
        jMenuItem3.setText("My Property");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("add.png"))); // NOI18N
        jMenuItem4.setText("Add Property");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItem4);

        jMenuBar1.add(jMenuAdd);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxAirConditioner)
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
                                .addComponent(jCheckBoxBalcony)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxWashingMachine)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldAddress))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBoxPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxPriceSortingMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGetPropertyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPriceSortingMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSwimmingPool, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBoxAirConditioner)
                                .addComponent(jCheckBoxWifi)
                                .addComponent(jCheckBoxTV)
                                .addComponent(jCheckBoxFridge)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxWaterHeater)
                            .addComponent(jCheckBoxGymRoom)
                            .addComponent(jCheckBoxBalcony)
                            .addComponent(jCheckBoxWashingMachine)))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButtonGetPropertyDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFrameVisitorPanel r = new JFrameVisitorPanel();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new JFrameMyProperty(owner).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddressActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new JFramePropertyOwnerEditAccountInformation(owner).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        int propertyID = -1;
        String propertyType = "-1";
        double minPrice = -1;
        double maxPrice = -1;
        int uploader_userID = -1;
        ArrayList<String> facilities = new ArrayList<>();
        int currentStatus = -1;
        String projectName = "-1";
        int priceSortingMethod = jComboBoxPriceSortingMethod.getSelectedIndex();
        String address = "-1";
        if (!jTextFieldAddress.getText().isBlank()) {
            address = jTextFieldAddress.getText().trim();
        }
        if (jComboBoxPropertyType.getSelectedIndex() != 0) {
            propertyType = jComboBoxPropertyType.getSelectedItem().toString();
        }
        if (jComboBoxMinPrice.getSelectedIndex() != 0) {
            minPrice = Double.parseDouble(jComboBoxMinPrice.getSelectedItem().toString());
        }
        if (jComboBoxMaxPrice.getSelectedIndex() != 0) {
            maxPrice = Double.parseDouble(jComboBoxMaxPrice.getSelectedItem().toString());
        }
        if (jComboBoxCurrentStatus.getSelectedIndex() != 0) {
            currentStatus = jComboBoxCurrentStatus.getSelectedIndex() - 1;
        }
        if (jComboBoxProjectName.getSelectedIndex() != 0) {
            projectName = jComboBoxProjectName.getSelectedItem().toString();
        }
        // facilities
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(jCheckBoxAirConditioner);
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
        ArrayList<Property> propertyList = new ArrayList<>();
        PropertyManager newManager = PropertyManager.getInstance();
        propertyList = newManager.searchProperty(propertyID, propertyType, minPrice, maxPrice,
                                    uploader_userID, facilities, currentStatus, projectName,
                                    priceSortingMethod, address);
        propertyTableSearchResult(jTablePropertyListing, propertyList);
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jComboBoxPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPropertyTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPropertyTypeActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new JFramePropertyOwnerAddProperty(owner).setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jTextFieldPropertyIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPropertyIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPropertyIDActionPerformed

    private void jButtonGetPropertyDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetPropertyDetailActionPerformed
        int propertyID = 0;
        boolean caught = false;
        Property foundProperty = null;
        PropertyManager newManager = PropertyManager.getInstance();
        
        if(jTextFieldPropertyID.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please insert the Property ID");
        }
        else {
            try {
                caught = false;
                propertyID = Integer.parseInt(jTextFieldPropertyID.getText().trim());
            } catch (NumberFormatException e) {
                caught = true;
                JOptionPane.showMessageDialog(null, "Please insert numerical value in required text field");
            }
            if (caught == false) {
                foundProperty = newManager.findProperty(propertyID);
                if (foundProperty != null) {
                    new JFrameGetPropertyDetail(foundProperty).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Property not found!");
                }
                
            }
        }
    }//GEN-LAST:event_jButtonGetPropertyDetailActionPerformed
    private void clearPropertyTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
    }
    private void propertyTableSearchResult(JTable table, ArrayList<Property> propertyList) {
        clearPropertyTable(table);
        String col[] = {"Property ID", "Property Type", "Property Price", "Size (sqrt)", "Project Name", 
                        "Current Status", "Unit No", "Street", "Garden", "Postcode"};
        
        DefaultTableModel tableModel = new DefaultTableModel(0, col.length);
        tableModel.setColumnIdentifiers(col);
        table.setModel(tableModel);
        table.setEnabled(false);
        for (Property row : propertyList) {
            int propertyID = row.getPropertyID();
            String propertyType = row.getPropertyType();
            double propertyPrice = row.getPropertyPrice();
            double propertySize = row.getPropertySize();
            String projectName = row.getProjectName();
            // Property current status
            int currentStatus = row.getCurrentStatus();
            String statusString;
            if (currentStatus == 0) {
                statusString = "Inactive";
            }
            else {
                statusString = "Active";
            }
            // address
            ArrayList<String> address = row.getAddress();
            
            Object [] data = {propertyID, propertyType, propertyPrice, propertySize, projectName, 
                statusString, address.get(0), address.get(1), address.get(2), address.get(3)};
            tableModel.addRow(data);
        }
    }
    private void propertyTableInitialize(JTable table) {
        clearPropertyTable(table);
        String col[] = {"Property ID", "Property Type", "Property Price", "Size (sqrt)", "Project Name", 
                        "Current Status", "Unit No", "Street", "Garden", "Postcode"};
        
        DefaultTableModel tableModel = new DefaultTableModel(0, col.length);
        tableModel.setColumnIdentifiers(col);
        table.setModel(tableModel);
        table.setEnabled(false);
        
        PropertyManager propertyManager = PropertyManager.getInstance();
        ArrayList<Property> propertyList = propertyManager.getPropertyList();
        
        for (Property row : propertyList) {
            int propertyID = row.getPropertyID();
            String propertyType = row.getPropertyType();
            double propertyPrice = row.getPropertyPrice();
            double propertySize = row.getPropertySize();
            String projectName = row.getProjectName();
            // Property current status
            int currentStatus = row.getCurrentStatus();
            String statusString;
            if (currentStatus == 0) {
                statusString = "Inactive";
            }
            else {
                statusString = "Active";
            }
            // address
            ArrayList<String> address = row.getAddress();
            
            Object [] data = {propertyID, propertyType, propertyPrice, propertySize, projectName, 
                statusString, address.get(0), address.get(1), address.get(2), address.get(3)};
            tableModel.addRow(data);
        }
        
    }
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
            java.util.logging.Logger.getLogger(JFramePropertyOwnerHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePropertyOwnerHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PropertyOwner owner = null;
                new JFramePropertyOwnerHomepage(owner).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGetPropertyDetail;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JCheckBox jCheckBoxAirConditioner;
    private javax.swing.JCheckBox jCheckBoxBalcony;
    private javax.swing.JCheckBox jCheckBoxFridge;
    private javax.swing.JCheckBox jCheckBoxGymRoom;
    private javax.swing.JCheckBox jCheckBoxSwimmingPool;
    private javax.swing.JCheckBox jCheckBoxTV;
    private javax.swing.JCheckBox jCheckBoxWashingMachine;
    private javax.swing.JCheckBox jCheckBoxWaterHeater;
    private javax.swing.JCheckBox jCheckBoxWifi;
    private javax.swing.JComboBox<String> jComboBoxCurrentStatus;
    private javax.swing.JComboBox<String> jComboBoxMaxPrice;
    private javax.swing.JComboBox<String> jComboBoxMinPrice;
    private javax.swing.JComboBox<String> jComboBoxPriceSortingMethod;
    private javax.swing.JComboBox<String> jComboBoxProjectName;
    private javax.swing.JComboBox<String> jComboBoxPropertyType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenuAdd;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePropertyListing;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldPropertyID;
    // End of variables declaration//GEN-END:variables
}
