package View;



import Controller.SetOfSensorStations;
import Models.SensorStation;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//IT16083424 Perera P.A.H.E     SHU ID=27045240 
/**
 *
 * @author Harshana
 */
public class UserInterface extends javax.swing.JFrame implements Serializable {

    SetOfSensorStations SOSST=SetOfSensorStations.getSetOfSensorStationsInstance();
    
    /**
     * Creates new form View
     */
    public UserInterface() {
        initComponents();
        roleSwitchValidator();
    }
    
    private void populateSensorStationList(){
         DefaultTableModel dtm = (DefaultTableModel) tblStationManagement.getModel();
         dtm.setRowCount(0);
        for (int i = 0; i < SOSST.size(); i++) {
            SensorStation st = SOSST.get(i);
            Vector v = new Vector();
            v.add(st.getStationID());
            v.add(st.getStationName());
            v.add(st.getCoords().get(0)+" , "+st.getCoords().get(1));
            v.add(0);
            dtm.addRow(v);
          }
        }
    
    private void populateSensorStationDetailsToComboBox(SensorStation st){
        cmbSelectSensorStation.addItem(st.getStationName()+"  ("+st.getCoords().get(0)+","+st.getCoords().get(1)+")");
     }

    public void roleSwitchValidator() {     //rename to switch screen as class diagram
        int selectedIndex = jTabbedPaneMainPanel.getSelectedIndex();
        if (selectedIndex == 0) {
            jTabbedPaneMainPanel.setEnabledAt(1, false);
            jTabbedPaneMainPanel.setEnabledAt(2, false);
        }
        if (selectedIndex == 1) {
            jTabbedPaneMainPanel.setEnabledAt(1, true);
            jTabbedPaneMainPanel.setEnabledAt(2, false);
        }
        if (selectedIndex == 2) {
            jTabbedPaneMainPanel.setEnabledAt(2, true);
            jTabbedPaneMainPanel.setEnabledAt(1, false);
        }
        if (selectedIndex == 3) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you really want to Exit?", "Smart City V.1.0", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {            //yes=0   No=1
                //call Serialize functions here before exit application
                this.dispose(); //exit application
            }
            if (answer == 1) {
                jTabbedPaneMainPanel.setSelectedIndex(0);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radGrpGender = new javax.swing.ButtonGroup();
        jTabbedPaneMainPanel = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnRoleAdmin = new javax.swing.JButton();
        btnRoleUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtUpdateUserName = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPaneSubPanel = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStationManagement = new javax.swing.JTable();
        jSeparator10 = new javax.swing.JSeparator();
        txtSensorStationName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtLongitude = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtLatitude = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnRemoveSensorStation = new javax.swing.JButton();
        btnAddSensorStation = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        txtStationID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblViewSensorStation = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox<>();
        btnUpdateSelectedSensor = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        txtSensorId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        txtFrequency = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnAddSensor = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cmbSensorType = new javax.swing.JComboBox<>();
        btnRemoveSensor = new javax.swing.JButton();
        cmbSelectSensorStation = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 33, 35));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPaneMainPanel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTabbedPaneMainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMainPanelMouseClicked(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRoleAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin256.png"))); // NOI18N
        btnRoleAdmin.setBorder(null);
        btnRoleAdmin.setContentAreaFilled(false);
        btnRoleAdmin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin128.png"))); // NOI18N
        btnRoleAdmin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin256rollover.png"))); // NOI18N
        btnRoleAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoleAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnRoleAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 450, 360));

        btnRoleUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user256.png"))); // NOI18N
        btnRoleUser.setBorder(null);
        btnRoleUser.setContentAreaFilled(false);
        btnRoleUser.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user128.png"))); // NOI18N
        btnRoleUser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user256rollover.png"))); // NOI18N
        btnRoleUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoleUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnRoleUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/smartcity3.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 510));

        jTabbedPane1.addTab("                                          Welcome To Smart City                                            ", jPanel1);

        jTabbedPaneMainPanel.addTab("          Home         ", jTabbedPane1);

        jTabbedPane3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(32, 33, 35));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Weight :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 118, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Height:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 171, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 230, -1, -1));

        txtWeight.setBackground(new java.awt.Color(32, 33, 35));
        txtWeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtWeight.setForeground(new java.awt.Color(255, 255, 255));
        txtWeight.setBorder(null);
        jPanel4.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 116, 125, -1));

        txtHeight.setBackground(new java.awt.Color(32, 33, 35));
        txtHeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtHeight.setForeground(new java.awt.Color(255, 255, 255));
        txtHeight.setBorder(null);
        jPanel4.add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 171, 125, -1));

        txtAge.setBackground(new java.awt.Color(32, 33, 35));
        txtAge.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        txtAge.setBorder(null);
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 125, -1));

        btnUpdate.setBackground(new java.awt.Color(38, 50, 56));
        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update Profile");
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 452, 1117, -1));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 143, 125, 10));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 198, 125, 10));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 67, 125, 10));

        radGrpGender.add(radMale);
        radMale.setForeground(new java.awt.Color(255, 255, 255));
        radMale.setText("Male");
        jPanel4.add(radMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 226, -1, -1));

        radGrpGender.add(radFemale);
        radFemale.setForeground(new java.awt.Color(255, 255, 255));
        radFemale.setText("Female");
        jPanel4.add(radFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 226, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 60, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 155, 60, -1));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 77, 188, 10));

        txtUpdateUserName.setBackground(new java.awt.Color(32, 33, 35));
        txtUpdateUserName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtUpdateUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateUserName.setBorder(null);
        jPanel4.add(txtUpdateUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 50, 188, -1));

        jTabbedPane3.addTab("                                                     Edit Profile                                                      ", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneMainPanel.addTab("          User Mgt          ", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneSubPanel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPaneSubPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneSubPanelMouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(32, 33, 35));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map.PNG"))); // NOI18N
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -20, 1010, 540));

        jTabbedPaneSubPanel.addTab("             Map              ", jPanel10);

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStationManagement.setBackground(new java.awt.Color(32, 33, 35));
        tblStationManagement.setForeground(new java.awt.Color(255, 255, 255));
        tblStationManagement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Station ID", "Sensor Station", "Location", "Number Of Active Sensors"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStationManagement);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1160, 310));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 188, 10));

        txtSensorStationName.setBackground(new java.awt.Color(32, 33, 35));
        txtSensorStationName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtSensorStationName.setForeground(new java.awt.Color(255, 255, 255));
        txtSensorStationName.setBorder(null);
        jPanel2.add(txtSensorStationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 190, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sensor Station Name:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 150, -1));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 100, 10));

        txtLongitude.setBackground(new java.awt.Color(32, 33, 35));
        txtLongitude.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtLongitude.setForeground(new java.awt.Color(255, 255, 255));
        txtLongitude.setBorder(null);
        jPanel2.add(txtLongitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 100, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Longitude:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 80, -1));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 100, 10));

        txtLatitude.setBackground(new java.awt.Color(32, 33, 35));
        txtLatitude.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtLatitude.setForeground(new java.awt.Color(255, 255, 255));
        txtLatitude.setBorder(null);
        jPanel2.add(txtLatitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 100, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Latitude:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 70, -1));

        btnRemoveSensorStation.setBackground(new java.awt.Color(38, 50, 56));
        btnRemoveSensorStation.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnRemoveSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveSensorStation.setText("Remove Sensor Station");
        jPanel2.add(btnRemoveSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 210, -1));

        btnAddSensorStation.setBackground(new java.awt.Color(38, 50, 56));
        btnAddSensorStation.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAddSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSensorStation.setText("Add Sensor Station");
        btnAddSensorStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSensorStationActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, -1, -1));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, 10));

        txtStationID.setBackground(new java.awt.Color(32, 33, 35));
        txtStationID.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtStationID.setForeground(new java.awt.Color(255, 255, 255));
        txtStationID.setBorder(null);
        jPanel2.add(txtStationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Station ID:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, -1));

        jTabbedPaneSubPanel.addTab("                   Station Management                   ", jPanel2);

        jPanel7.setBackground(new java.awt.Color(32, 33, 35));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblViewSensorStation.setBackground(new java.awt.Color(32, 33, 35));
        tblViewSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        tblViewSensorStation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensor ID", "Sensor Description", "Current Data", "Status", "Frequency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblViewSensorStation);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1160, 310));

        cmbStatus.setForeground(new java.awt.Color(255, 255, 255));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Not-Active" }));
        jPanel7.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 100, -1));

        btnUpdateSelectedSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnUpdateSelectedSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpdateSelectedSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSelectedSensor.setText("Update Selected Sensor");
        jPanel7.add(btnUpdateSelectedSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 220, -1));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 90, 10));

        txtSensorId.setBackground(new java.awt.Color(32, 33, 35));
        txtSensorId.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtSensorId.setForeground(new java.awt.Color(255, 255, 255));
        txtSensorId.setBorder(null);
        jPanel7.add(txtSensorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sensor ID:");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sensor Description:");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 140, -1));

        jSeparator15.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 100, 10));

        txtFrequency.setBackground(new java.awt.Color(32, 33, 35));
        txtFrequency.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtFrequency.setForeground(new java.awt.Color(255, 255, 255));
        txtFrequency.setBorder(null);
        jPanel7.add(txtFrequency, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 100, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Status:");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 50, -1));

        btnAddSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnAddSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAddSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSensor.setText("Add Sensor");
        jPanel7.add(btnAddSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1047, 50, 130, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Frequency:");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 80, -1));

        cmbSensorType.setForeground(new java.awt.Color(255, 255, 255));
        cmbSensorType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select  Sensor Type", "Bin Sensor", "Flood Sensor", "Traffic Sensor" }));
        jPanel7.add(cmbSensorType, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 150, -1));

        btnRemoveSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnRemoveSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnRemoveSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveSensor.setText("Remove Sensor");
        jPanel7.add(btnRemoveSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 260, -1));

        cmbSelectSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        cmbSelectSensorStation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select A Sensor Station" }));
        cmbSelectSensorStation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSelectSensorStationMouseClicked(evt);
            }
        });
        cmbSelectSensorStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectSensorStationActionPerformed(evt);
            }
        });
        jPanel7.add(cmbSelectSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 349, -1));

        jTabbedPaneSubPanel.addTab("              View Sensor Station             ", jPanel7);

        jPanel6.add(jTabbedPaneSubPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 546));

        jTabbedPaneMainPanel.addTab("           Station Management         ", jPanel6);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/endfinalfinal.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMainPanel.addTab("   X   ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jTabbedPaneMainPanel.getAccessibleContext().setAccessibleName("     Me     ");

        setSize(new java.awt.Dimension(1222, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPaneMainPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMainPanelMouseClicked
        roleSwitchValidator();
        
    }//GEN-LAST:event_jTabbedPaneMainPanelMouseClicked

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked

    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jTabbedPaneSubPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneSubPanelMouseClicked
            roleSwitchValidator();
//            int index=jTabbedPaneSubPanel.getSelectedIndex();
//            if(index==2){
//                populateSensorStationDetailsToComboBox();
//            }
            
    }//GEN-LAST:event_jTabbedPaneSubPanelMouseClicked

    private void cmbSelectSensorStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectSensorStationActionPerformed
       if (cmbSelectSensorStation.getSelectedIndex() == 0) {
            System.out.println("index 0");
        } else if (cmbSelectSensorStation.getSelectedIndex() == 1) {
            System.out.println("index 1");
        } else if (cmbSelectSensorStation.getSelectedIndex() == 2) {
            System.out.println("index 2");
        } else if (cmbSelectSensorStation.getSelectedIndex() == 3) {
            System.out.println("index 3");
        } else {
            System.out.println("err");
        }
    }//GEN-LAST:event_cmbSelectSensorStationActionPerformed

    private void btnRoleAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleAdminActionPerformed
        jTabbedPaneMainPanel.setSelectedIndex(2);
        roleSwitchValidator();
    }//GEN-LAST:event_btnRoleAdminActionPerformed

    private void btnRoleUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleUserActionPerformed
        jTabbedPaneMainPanel.setSelectedIndex(1);
        roleSwitchValidator();
    }//GEN-LAST:event_btnRoleUserActionPerformed

    private void btnAddSensorStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSensorStationActionPerformed

        String stationID=txtStationID.getText();
        String stationName=txtSensorStationName.getText();
        Double longitude=Double.parseDouble(txtLongitude.getText());               
        Double latitude=Double.parseDouble(txtLatitude.getText());   
        
        SensorStation sensorstation=new SensorStation(stationID,stationName,longitude,latitude);
        SOSST.addSensorStation(sensorstation);
        populateSensorStationList();
        
        populateSensorStationDetailsToComboBox(sensorstation);
        
    }//GEN-LAST:event_btnAddSensorStationActionPerformed

    private void cmbSelectSensorStationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSelectSensorStationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectSensorStationMouseClicked

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSensor;
    private javax.swing.JButton btnAddSensorStation;
    private javax.swing.JButton btnRemoveSensor;
    private javax.swing.JButton btnRemoveSensorStation;
    private javax.swing.JButton btnRoleAdmin;
    private javax.swing.JButton btnRoleUser;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateSelectedSensor;
    private javax.swing.JComboBox<String> cmbSelectSensorStation;
    private javax.swing.JComboBox<String> cmbSensorType;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPaneMainPanel;
    private javax.swing.JTabbedPane jTabbedPaneSubPanel;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.ButtonGroup radGrpGender;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JTable tblStationManagement;
    private javax.swing.JTable tblViewSensorStation;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFrequency;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtSensorId;
    private javax.swing.JTextField txtSensorStationName;
    private javax.swing.JTextField txtStationID;
    private javax.swing.JTextField txtUpdateUserName;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables

}
