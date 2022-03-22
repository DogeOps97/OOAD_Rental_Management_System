/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author user
 */
public class JFrameVisitorPanel extends javax.swing.JFrame {

    /**
     * Creates new form JFrameVisitorPanel
     */
    Visitor visitor;
    public JFrameVisitorPanel() {
        initComponents();
        visitor = new Visitor();
        this.setLocationRelativeTo(null);
        //jTable1 = new JTable (null, col);
        clearRegisterField();
       // propertyTableInitialize(jTable1);
        propertyTableInitialize(jTablePropertyListing);
    }
    
//    private void propertyTableUpdate(){
//        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
//        tableModel.setRowCount(0);
//        
//        ArrayList<Property> propertyList = visitor.getPropertyList();
//        
//        for (Property row : propertyList){
//            int propertyID = row.getPropertyID();
//            String propertyType = row.getPropertyType();
//            double propertyPrice = row.getPropertyPrice();
//            String ownerName = row.getOwnerName(); 
//            int uploader_userID = row.getUploader_userID();
//            String grantID = row.getGrantID();
//            String projectName = row.getProjectName();
//            int currentStatus = row.getCurrentStatus();
//            
//            // -- address -------------------------------
//            ArrayList<String> address = row.getAddress();
//            StringBuilder test_address = new StringBuilder();
//            for (String addressPart : address){
//                test_address.append(addressPart);
//            }
//            
//            String actualAddress = test_address.toString();      
//            // ------------------------------------------
//            
//            Object [] data = {propertyID, propertyType, propertyPrice, ownerName, uploader_userID, grantID, projectName, currentStatus, actualAddress};
//            
//            tableModel.addRow(data);
//            
//        }
//    }
    
    class MyTableModel extends AbstractTableModel{
        private String columnNames[] = { "propertyID", "Property Type", "Property Price", "Owner name", "Uploader ID", "Grant ID", "Project name", "Current status", "Address" };
        private Object[][] data = { {new Integer(2), "condo", new Double(300.00), "Rahman", new Integer(2), "21314-1241-14212", "Taman Bestari", new Boolean(true), "Subang Jaya"}, 
                                {null, null, null, null, null, null, null ,null, null}};

        public int getColumnCount(){
            return columnNames.length;
        }

        public int getRowCount(){
            return data.length;
        }

        public String getColumnName(int col){
            return columnNames[col];
        }

        public Object getValueAt(int row, int col){
            return data[row][col];
        }

        public Class getColumnClass(int c){
            return getValueAt(0, c).getClass();
        }

        public void setValueAt(Object value, int row, int col){
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

        private void printDebugData(){
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i = 0; i < numRows; i++){
                System.out.println("    row " + i + ":");
                for (int j = 0; j < numCols; j++){
                    System.out.print(" " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
   
    class TestTableSorter extends DefaultTableModel{
        TestTableSorter(int row, int col){
            super(row, col);
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex){
            switch(columnIndex){
                case 0:
                    return Integer.class;  
                default:
                    return getValueAt(0, columnIndex).getClass();
            }
            
        }
    }
    
    private JTextField filterText;
    private TableRowSorter<DefaultTableModel> sorter;
//    private void propertyTableInitialize(JTable table){
//        String col[] = { "propertyID", "Property Type", "Property Price", "Owner name", "Uploader ID", "Grant ID", "Project name", "Current status", "Address" };
//
//        DefaultTableModel model = new DefaultTableModel(0, col.length);
//        model.setColumnIdentifiers(col);
//        table.setModel(model);
//
//        sorter = new TableRowSorter<DefaultTableModel>(model);
//        jTable1  = new JTable(model);
//        //table.setRowSorter(sorter);
//        table.setAutoCreateRowSorter(true);
//
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        table.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
//            int viewRow = table.getSelectedRow();
//            if (viewRow < 0){
//                jTextField6.setText("");
//            }
//            else {
//                int modelRow = table.convertRowIndexToModel(viewRow);
//                
//                jTextField6.setText(
//                        String.format("Selected row in view: %d. " + "Selected Row in model: %d.", viewRow, modelRow));
//            }
//        });
//
//        filterText = jTextField5; // set a text field here for the filter 
//
//
//        filterText.getDocument().addDocumentListener(
//                new DocumentListener() {
//                    @Override
//                    public void changedUpdate(DocumentEvent e) {
//                        newFilter();
//                    }
//                    @Override
//                    public void insertUpdate(DocumentEvent e) {
//                        newFilter();
//                    }
//                    @Override
//                    public void removeUpdate(DocumentEvent e) {
//                        newFilter();
//                    }
//        });
//
//
//        //DefaultTableModel tableModel = new DefaultTableModel(0, col.length);
//       // tableModel.setColumnIdentifiers(col);
//        //table.setModel(tableModel);
//        //tableModel.setRowCount(0);
//        ArrayList<Property> propertyList = visitor.getPropertyList();
//        
//        for (Property row : propertyList){
//            int propertyID = row.getPropertyID();
//            String propertyType = row.getPropertyType();
//            double propertyPrice = row.getPropertyPrice();
//            String ownerName = row.getOwnerName(); 
//            int uploader_userID = row.getUploader_userID();
//            String grantID = row.getGrantID();
//            String projectName = row.getProjectName();
//            int currentStatus_field = row.getCurrentStatus();
//            Boolean currentStatus;
//            if (currentStatus_field == 1){
//                currentStatus = true;
//            }
//            else{
//                currentStatus = false;
//            }
//            // -- address -------------------------------
//            ArrayList<String> address = row.getAddress();
//            StringBuilder test_address = new StringBuilder();
//            for (String addressPart : address){
//                test_address.append(addressPart);
//            }
//            
//            String actualAddress = test_address.toString();      
//            // ------------------------------------------
//            
//            Object [] data = {new Integer(propertyID), propertyType, new Double(propertyPrice), ownerName, uploader_userID, grantID, projectName, new Boolean(currentStatus), actualAddress};
//            
//            model.addRow(data);
//            
//        }
//        
//    }
    
//     public void newFilter(){
//        RowFilter<DefaultTableModel, Object> rf = null;
//        
//        //String getType = (String) jComboBox2.getSelectedItem();
//        int typeFilterSet = jComboBox2.getSelectedIndex();
//        
//        // PropertyID PropertyType PropertyPrice UploaderID GrantID ProjectName CurrentStatus Address
//        // 0,1, 2, , 4
//
//        
//
//
//
//
//
//        
//        try{
//            rf = RowFilter.regexFilter(filterText.getText(), 2);
//        } catch (java.util.regex.PatternSyntaxException e){
//            return;
//        }
//
//        sorter.setRowFilter(rf);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePropertyListing = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPropertyID = new javax.swing.JTextField();
        jButtonGetPropertyDetail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setText("Not logged in");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1)))
                .addContainerGap(577, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Login", jPanel1);

        jLabel4.setText("Name");

        jLabel6.setText("Contact info");

        jLabel7.setText("Role");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenant", "Property Agent", "Property Owner", "Admin" }));

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 481, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(107, 107, 107)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Register for account");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Register");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register", jPanel7);

        jTextFieldAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddressActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Search Address:");

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
        jScrollPane2.setViewportView(jTablePropertyListing);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Insert Property ID To Get Property Details:");

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCheckBoxAirConditioner)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxWifi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxTV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxSwimmingPool)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxFridge))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCheckBoxWaterHeater)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxGymRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxBalcony)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxWashingMachine)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldAddress))
                                .addGroup(jPanel11Layout.createSequentialGroup()
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
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jTextFieldPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGetPropertyDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(22, 22, 22))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPriceSortingMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCurrentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSwimmingPool, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBoxAirConditioner)
                                .addComponent(jCheckBoxWifi)
                                .addComponent(jCheckBoxTV)
                                .addComponent(jCheckBoxFridge)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBoxWaterHeater)
                            .addComponent(jCheckBoxGymRoom)
                            .addComponent(jCheckBoxBalcony)
                            .addComponent(jCheckBoxWashingMachine)))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPropertyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButtonGetPropertyDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Property Listing", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String userName = jTextField1.getText().trim();
        String userPassword = jTextField2.getText().trim();
        User user = visitor.login(userName, userPassword);
        
        int errno = visitor.getErrno();
        
        if (errno == 0){
            if (user.getUserRole().equalsIgnoreCase("admin")){
                JOptionPane.showMessageDialog(null, "Login successful");
                JFrameAdminPanel r = new JFrameAdminPanel((Admin) user);
                r.setVisible(true);
                this.dispose();
            }
            
            else if (user.getUserRole().equalsIgnoreCase("property owner") || user.getUserRole().equalsIgnoreCase("propertyowner")){
                JOptionPane.showMessageDialog(null, "Login successful");
                JFramePropertyOwnerHomepage r = new JFramePropertyOwnerHomepage((PropertyOwner) user);
                r.setVisible(true);
                this.dispose();
            }
            else if (user.getUserRole().equalsIgnoreCase("property agent") || user.getUserRole().equalsIgnoreCase("propertyagent")){
                JOptionPane.showMessageDialog(null, "Login successful");
                JFramePropertyAgentHomepage r = new JFramePropertyAgentHomepage((PropertyAgent) user);
                r.setVisible(true);
                this.dispose();
            }
        }
        
        else if (errno == -1){
            JOptionPane.showMessageDialog(null, "Invalid userID or password", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        else if (errno == -2){
            JOptionPane.showMessageDialog(null, "User role improperly configured. Please contact admin", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        else if (errno == -3){
            JOptionPane.showMessageDialog(null, "Role has not been implemented yet. Please contact admin", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Unknown error occured. Please contact admin", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String userRealName_field = jTextField3.getText();
        String userContact_field = jTextField4.getText();
        
        String userRole_field = (String) jComboBox1.getSelectedItem();
        
        visitor.register(userRealName_field, userContact_field, userRole_field);
        int returnCode = visitor.getErrno();
        
        if (returnCode == 0){
            JOptionPane.showMessageDialog(null, "Registration successful");
            clearRegisterField();
        }
        
        else if (returnCode == -1){
            JOptionPane.showMessageDialog(null, "You need to fill in both name and contact info", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Unknown error occured", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clearRegisterField();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddressActionPerformed

    private void jComboBoxPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPropertyTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPropertyTypeActionPerformed

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
    
    private void clearRegisterField(){
        jTextField3.setText("");
        jTextField4.setText("");
        
        jComboBox1.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(JFrameVisitorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVisitorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVisitorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVisitorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            LoginIDManager loginMan = LoginIDManager.getInstance();
            RegistrationManager regisMan = RegistrationManager.getInstance();
            public void run() {
                new JFrameVisitorPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxCurrentStatus;
    private javax.swing.JComboBox<String> jComboBoxMaxPrice;
    private javax.swing.JComboBox<String> jComboBoxMinPrice;
    private javax.swing.JComboBox<String> jComboBoxPriceSortingMethod;
    private javax.swing.JComboBox<String> jComboBoxProjectName;
    private javax.swing.JComboBox<String> jComboBoxPropertyType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePropertyListing;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldPropertyID;
    // End of variables declaration//GEN-END:variables
}
