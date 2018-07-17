package View;

import Controller.MotherShip;
import Controller.PublicInterface;
import Controller.SetOFData;
import Controller.SetOfBinSensors;
import Controller.SetOfFloodSensors;
import Controller.SetOfSensorMonitors;
import Controller.SetOfTrafficSensors;
import Models.BinSensor;
import Models.Data;
import Models.EmbelishedData;
import Models.FloodSensor;
import Models.SensorMonitor;
import Models.SensorStation;
import Models.TrafficSensor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshana
 */
public class UserInterface extends javax.swing.JFrame implements Serializable {

    private MotherShip mothership = new MotherShip();
    private ArrayList<SensorStation> sensorStations;
    private ArrayList<SensorMonitor> sensorMonitors;
    SensorStation currentSensorStation;
    BinSensor Currentbinsensor;

    //Additional
    SetOfSensorMonitors SOSM = SetOfSensorMonitors.getSetOfSensorMonitorsInstance();
    SetOfBinSensors SOBS = SetOfBinSensors.getSetOfBinSensorsInstance();
    SetOfFloodSensors SOFS = SetOfFloodSensors.getSetOfFloodSensorsInstance();
    SetOfTrafficSensors SOTS=SetOfTrafficSensors.getSetOfTrafficSensorsInstance();
    PublicInterface publicInterface = new PublicInterface();
    private Data data;

    /**
     * Creates new form View
     */
    public UserInterface() {
        initComponents();
        switchScreens();
    }

    public void switchScreens() {
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
        if (selectedIndex == 6) {
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

    public void selectSensorStation(String id) {
        for (SensorStation sensorstation : sensorStations) {
            if (sensorstation.getStationID().equals(id)) {
                currentSensorStation = sensorstation;
            }
        }

    }
    
     public void selectBinSensor(String id) {
        for (BinSensor binsensor : SOBS) {
            if (binsensor.getSensorId().equals(id)) {
                Currentbinsensor = binsensor;
                txtBinDummy.setText(id);
            }
        }

    }

    

    private void populateSensorMonitorList() {
        sensorMonitors = currentSensorStation.getSensorMonitors();
        DefaultTableModel dtm = (DefaultTableModel) tblViewSensorStation.getModel();
        dtm.setRowCount(0);
        for (SensorMonitor sensormonitor : sensorMonitors) {
            Vector v = new Vector();
            v.add(sensormonitor.getSensor().getSensorId());
            v.add(sensormonitor.getSensorDescription());
            v.add(sensormonitor.readingsCount);
            v.add(sensormonitor.getStatus());
            v.add(sensormonitor.getInterval());
            dtm.addRow(v);
        }
    }

    public void populateSensorStationList() {
        DefaultTableModel dtm = (DefaultTableModel) tblStationManagement.getModel();
        dtm.setRowCount(0);
        sensorStations = mothership.getSensorStations();
        for (int i = 0; i < sensorStations.size(); i++) {
            SensorStation st = mothership.getSensorStations().get(i);
            Vector v = new Vector();
            v.add(st.getStationID());
            v.add(st.getStationName());
            v.add(st.getLocation().getCoords().get(0) + " , " + st.getLocation().getCoords().get(1));
            v.add(0);
            dtm.addRow(v);
        }
    }
    
    
//This is a additional methode we used to load data to combo box    

    public void populateSensorStationDetailsToComboBox(SensorStation st) {
        cmbSelectSensorStation.addItem(st.getStationName() + "  " + st.getStationID() + "  (" + st.getLocation().getCoords().get(0) + " , " + st.getLocation().getCoords().get(1) + ")");
        // cmbSelectSensorStation.addItem(st.getStationID());
    }
     public void populateBinSensorsDetailsToComboBox(String id) {
         //for(BinSensor binsensor:SOBS){
           cmbAvailableBinSensorDummy.addItem(id);
         //}
        // cmbSelectSensorStation.addItem(st.getStationID());
    }
      public void populateFloodSensorsDetailsToComboBox() {
         for(FloodSensor floodsensor:SOFS){
                     cmbAvailableFloodSensorDummy.addItem(floodsensor.getSensorId());
         }
        // cmbSelectSensorStation.addItem(st.getStationID());
    }
     public void populateTrafficSensorsDetailsToComboBox() {
         for(TrafficSensor trafficSensor:SOTS){
                     cmbAvailableTrafficSensorDummy.addItem(trafficSensor.getSensorId());
         }
        // cmbSelectSensorStation.addItem(st.getStationID());
    }

    //Populate Alert Details Starts Here
    //problem
    public void populateBinAlertDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblWasteCollectorBinDetails.getModel();
        dtm.setRowCount(0);
        // sensorStations=mothership.getSensorStations();
        for (EmbelishedData embelishedData : publicInterface.getAllChangedData()) {

            for (BinSensor binsensor : SOBS) {
                if (binsensor.getSensorId().equals(embelishedData.getSensorID())) {
                    Vector v = new Vector();
                    if (embelishedData.getData() > embelishedData.getInterval()) {

                        v.add(binsensor.getSensorId());
                        v.add(embelishedData.getStationName() + "  " + "  (" + embelishedData.getLocation().get(0) + " , " + embelishedData.getLocation().get(1) + ")");
                        v.add(0);
                        dtm.addRow(v);

                    }
                }
            }
        }
    }

    public void populateFloodAlertDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblUserFloodAlerts.getModel();
        dtm.setRowCount(0);
        // sensorStations=mothership.getSensorStations();
        for (EmbelishedData embelishedData : publicInterface.getAllChangedData()) {

            for (FloodSensor floodSensor : SOFS) {
                if (floodSensor.getSensorId().equals(embelishedData.getSensorID())) {
                    Vector v = new Vector();
                    v.add(embelishedData.getStationName());
                    v.add(embelishedData.getData());
                    if (embelishedData.getData() <= embelishedData.getInterval() * 0.25) {
                        v.add("Flood Risk");
                    } else {
                        v.add("No flood risk");
                    }
                    v.add(0);
                    dtm.addRow(v);
                }
            }
        }
    }

     public void populateTrafficLightAlertDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblUserTraffic.getModel();
        dtm.setRowCount(0);
        // sensorStations=mothership.getSensorStations();
        for (EmbelishedData embelishedData : publicInterface.getAllChangedData()) {

            for (TrafficSensor trfficSensor : SOTS) {
                if (trfficSensor.getSensorId().equals(embelishedData.getSensorID())) {
                    Vector v = new Vector();
                    v.add(embelishedData.getStationName());
                    v.add(embelishedData.getData());
                   
                    v.add(0);
                    dtm.addRow(v);
                }
            }
        }
    }

     public void populateNearestRoadAlertDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblWasteCollectorTraffic.getModel();
        dtm.setRowCount(0);
        // sensorStations=mothership.getSensorStations();
        for (EmbelishedData embelishedData : publicInterface.getAllChangedData()) {

            for (TrafficSensor trfficSensor : SOTS) {
                if (trfficSensor.getSensorId().equals(embelishedData.getSensorID())) {
                    Vector v = new Vector();
                    v.add(embelishedData.getStationName());
                    v.add(embelishedData.getData());
                   
                    v.add(0);
                    dtm.addRow(v);
                }
            }
        }
    }
     
    
//      public void populateNearestRoadAlertDetails() {
//        DefaultTableModel dtm = (DefaultTableModel) tblWasteCollectorTraffic.getModel();
//        dtm.setRowCount(0);
//        // sensorStations=mothership.getSensorStations();
//        for (EmbelishedData embelishedData : publicInterface.getAllChangedData()) {
//
//            for (TrafficSensor trfficSensor : SOTS) {
//                if (trfficSensor.getSensorId().equals(embelishedData.getSensorID())) {
//                 for(EmbelishedData embelishedData2:publicInterface.getAllChangedData()){  
//                    for(BinSensor binSensor:SOBS){
//                        if(binSensor.getSensorId().equals(embelishedData2.getSensorID())){
//                            if(embelishedData.getSensorID().equals(embelishedData2.getSensorID())){
//                                
//                                 Vector v = new Vector();
//                    v.add(embelishedData.getStationName());
//                    v.add(embelishedData.getData());
//                   
//                    v.add(0);
//                    dtm.addRow(v);
//                            }
//                        }
//                    }
//                 }
//                   
//                }
//            }
//        }
//    }
//
//    
    
    
    //Filter Station Id
    public String getMatchedStationId(String cmbValue) {
        Pattern p = Pattern.compile("[ST]{2}[0-9]{3}");
        Matcher m = p.matcher(cmbValue);
        if (m.find()) {
            return m.group();
        } else {
            return null;
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
        jTabbedPaneHome = new javax.swing.JTabbedPane();
        jPanelWelcome = new javax.swing.JPanel();
        btnRoleAdmin = new javax.swing.JButton();
        btnRoleParamedic = new javax.swing.JButton();
        btnRoleUser = new javax.swing.JButton();
        btnRoleWasteCollector = new javax.swing.JButton();
        lblWelcomeImage = new javax.swing.JLabel();
        jPanelUser = new javax.swing.JPanel();
        jTabbedPaneUserSubPanel = new javax.swing.JTabbedPane();
        jPanelUserFloodNotify = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblUserFloodAlerts = new javax.swing.JTable();
        jPanelUserTrafficMonitor = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUserTraffic = new javax.swing.JTable();
        jPanelCityCouncil = new javax.swing.JPanel();
        jTabbedPaneStationMgtSubPanel = new javax.swing.JTabbedPane();
        jPanelMayorMap = new javax.swing.JPanel();
        lblMap = new javax.swing.JLabel();
        jPanelMayorStationManagement = new javax.swing.JPanel();
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
        jPanelMayorSensorStation = new javax.swing.JPanel();
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
        jPanelParamedic = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblParamedicTraffic = new javax.swing.JTable();
        jPanelWasteCollector = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblWasteCollectorBinDetails = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblWasteCollectorTraffic = new javax.swing.JTable();
        btnEmptyBin = new javax.swing.JButton();
        jPanelDummyData = new javax.swing.JPanel();
        btnAddGarbage = new javax.swing.JButton();
        cmbAvailableBinSensorDummy = new javax.swing.JComboBox<>();
        txtBinDummy = new javax.swing.JTextField();
        btnMakeFlood = new javax.swing.JButton();
        cmbAvailableFloodSensorDummy = new javax.swing.JComboBox<>();
        txtFloodDummy = new javax.swing.JTextField();
        btnIncreaseTraffic = new javax.swing.JButton();
        cmbAvailableTrafficSensorDummy = new javax.swing.JComboBox<>();
        txtTrafficDummy = new javax.swing.JTextField();
        jPanelExit = new javax.swing.JPanel();
        lblExitImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 33, 35));
        setUndecorated(true);
        setResizable(false);

        jTabbedPaneMainPanel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTabbedPaneMainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPaneMainPanelMouseMoved(evt);
            }
        });
        jTabbedPaneMainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMainPanelMouseClicked(evt);
            }
        });

        jTabbedPaneHome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanelWelcome.setBackground(new java.awt.Color(32, 33, 35));
        jPanelWelcome.setVerifyInputWhenFocusTarget(false);
        jPanelWelcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelWelcome.add(btnRoleAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 260, 260));

        btnRoleParamedic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ambulance256.png"))); // NOI18N
        btnRoleParamedic.setBorder(null);
        btnRoleParamedic.setContentAreaFilled(false);
        btnRoleParamedic.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ambulance128.png"))); // NOI18N
        btnRoleParamedic.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ambulancerollover.png"))); // NOI18N
        jPanelWelcome.add(btnRoleParamedic, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, -1, -1));

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
        jPanelWelcome.add(btnRoleUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnRoleWasteCollector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycling-truck256.png"))); // NOI18N
        btnRoleWasteCollector.setBorder(null);
        btnRoleWasteCollector.setContentAreaFilled(false);
        btnRoleWasteCollector.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycling-truck128.png"))); // NOI18N
        btnRoleWasteCollector.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycling-truckrollover.png"))); // NOI18N
        jPanelWelcome.add(btnRoleWasteCollector, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, -1, -1));

        lblWelcomeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/smartcitywelcome.jpg"))); // NOI18N
        jPanelWelcome.add(lblWelcomeImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 510));

        jTabbedPaneHome.addTab("                                                                               Welcome To Smart City - Select a Role To Proceed                                                                         ", jPanelWelcome);

        jTabbedPaneMainPanel.addTab("  HOME  ", jTabbedPaneHome);

        jTabbedPaneUserSubPanel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPaneUserSubPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPaneUserSubPanelMouseMoved(evt);
            }
        });

        jPanelUserFloodNotify.setBackground(new java.awt.Color(32, 33, 35));
        jPanelUserFloodNotify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUserFloodAlerts.setBackground(new java.awt.Color(32, 33, 35));
        tblUserFloodAlerts.setForeground(new java.awt.Color(255, 255, 255));
        tblUserFloodAlerts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Flood Level", "Recommendation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblUserFloodAlerts);

        jPanelUserFloodNotify.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1230, 450));

        jTabbedPaneUserSubPanel.addTab("                                        Flood Alerts                                             ", jPanelUserFloodNotify);

        jPanelUserTrafficMonitor.setBackground(new java.awt.Color(32, 33, 35));
        jPanelUserTrafficMonitor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUserTraffic.setBackground(new java.awt.Color(32, 33, 35));
        tblUserTraffic.setForeground(new java.awt.Color(255, 255, 255));
        tblUserTraffic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Traffic Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserTraffic.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblUserTrafficMouseMoved(evt);
            }
        });
        jScrollPane6.setViewportView(tblUserTraffic);

        jPanelUserTrafficMonitor.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1230, 450));

        jTabbedPaneUserSubPanel.addTab("                                     Road Traffic Information                                  ", jPanelUserTrafficMonitor);

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneUserSubPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneUserSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        jTabbedPaneMainPanel.addTab("  USER  ", jPanelUser);

        jPanelCityCouncil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneStationMgtSubPanel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPaneStationMgtSubPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneStationMgtSubPanelMouseClicked(evt);
            }
        });

        jPanelMayorMap.setBackground(new java.awt.Color(32, 33, 35));
        jPanelMayorMap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/map.PNG"))); // NOI18N
        jPanelMayorMap.add(lblMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -10, 1100, 530));

        jTabbedPaneStationMgtSubPanel.addTab("             Map              ", jPanelMayorMap);

        jPanelMayorStationManagement.setBackground(new java.awt.Color(32, 33, 35));
        jPanelMayorStationManagement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanelMayorStationManagement.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1220, 310));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorStationManagement.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 188, 10));

        txtSensorStationName.setBackground(new java.awt.Color(32, 33, 35));
        txtSensorStationName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtSensorStationName.setForeground(new java.awt.Color(255, 255, 255));
        txtSensorStationName.setBorder(null);
        jPanelMayorStationManagement.add(txtSensorStationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 190, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sensor Station Name:");
        jPanelMayorStationManagement.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 150, -1));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorStationManagement.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 100, 10));

        txtLongitude.setBackground(new java.awt.Color(32, 33, 35));
        txtLongitude.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtLongitude.setForeground(new java.awt.Color(255, 255, 255));
        txtLongitude.setBorder(null);
        jPanelMayorStationManagement.add(txtLongitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 100, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Longitude:");
        jPanelMayorStationManagement.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 80, -1));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorStationManagement.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 100, 10));

        txtLatitude.setBackground(new java.awt.Color(32, 33, 35));
        txtLatitude.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtLatitude.setForeground(new java.awt.Color(255, 255, 255));
        txtLatitude.setBorder(null);
        jPanelMayorStationManagement.add(txtLatitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 100, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Latitude:");
        jPanelMayorStationManagement.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 70, -1));

        btnRemoveSensorStation.setBackground(new java.awt.Color(38, 50, 56));
        btnRemoveSensorStation.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnRemoveSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveSensorStation.setText("Remove Sensor Station");
        btnRemoveSensorStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSensorStationActionPerformed(evt);
            }
        });
        jPanelMayorStationManagement.add(btnRemoveSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 450, 210, -1));

        btnAddSensorStation.setBackground(new java.awt.Color(38, 50, 56));
        btnAddSensorStation.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAddSensorStation.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSensorStation.setText("Add Sensor Station");
        btnAddSensorStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSensorStationActionPerformed(evt);
            }
        });
        jPanelMayorStationManagement.add(btnAddSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, 180, -1));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorStationManagement.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 90, 10));

        txtStationID.setBackground(new java.awt.Color(32, 33, 35));
        txtStationID.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtStationID.setForeground(new java.awt.Color(255, 255, 255));
        txtStationID.setBorder(null);
        jPanelMayorStationManagement.add(txtStationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Station ID:");
        jPanelMayorStationManagement.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, -1));

        jTabbedPaneStationMgtSubPanel.addTab("                   Station Management                   ", jPanelMayorStationManagement);

        jPanelMayorSensorStation.setBackground(new java.awt.Color(32, 33, 35));
        jPanelMayorSensorStation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tblViewSensorStation.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblViewSensorStationMouseMoved(evt);
            }
        });
        jScrollPane4.setViewportView(tblViewSensorStation);

        jPanelMayorSensorStation.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1220, 310));

        cmbStatus.setForeground(new java.awt.Color(255, 255, 255));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Not-Active" }));
        jPanelMayorSensorStation.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 100, -1));

        btnUpdateSelectedSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnUpdateSelectedSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpdateSelectedSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSelectedSensor.setText("Update Selected Sensor");
        jPanelMayorSensorStation.add(btnUpdateSelectedSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 220, -1));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorSensorStation.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 90, 10));

        txtSensorId.setBackground(new java.awt.Color(32, 33, 35));
        txtSensorId.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtSensorId.setForeground(new java.awt.Color(255, 255, 255));
        txtSensorId.setBorder(null);
        jPanelMayorSensorStation.add(txtSensorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sensor ID:");
        jPanelMayorSensorStation.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sensor Description:");
        jPanelMayorSensorStation.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 140, -1));

        jSeparator15.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMayorSensorStation.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 100, 10));

        txtFrequency.setBackground(new java.awt.Color(32, 33, 35));
        txtFrequency.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtFrequency.setForeground(new java.awt.Color(255, 255, 255));
        txtFrequency.setBorder(null);
        jPanelMayorSensorStation.add(txtFrequency, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 100, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Status:");
        jPanelMayorSensorStation.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 50, -1));

        btnAddSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnAddSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnAddSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSensor.setText("Add Sensor");
        btnAddSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSensorActionPerformed(evt);
            }
        });
        jPanelMayorSensorStation.add(btnAddSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 130, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Frequency:");
        jPanelMayorSensorStation.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 80, -1));

        cmbSensorType.setForeground(new java.awt.Color(255, 255, 255));
        cmbSensorType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select  Sensor Type", "Bin Sensor", "Flood Sensor", "Traffic Sensor" }));
        jPanelMayorSensorStation.add(cmbSensorType, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 150, -1));

        btnRemoveSensor.setBackground(new java.awt.Color(38, 50, 56));
        btnRemoveSensor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnRemoveSensor.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveSensor.setText("Remove Sensor");
        jPanelMayorSensorStation.add(btnRemoveSensor, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 260, -1));

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
        jPanelMayorSensorStation.add(cmbSelectSensorStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 349, -1));

        jTabbedPaneStationMgtSubPanel.addTab("              View Sensor Station             ", jPanelMayorSensorStation);

        jPanelCityCouncil.add(jTabbedPaneStationMgtSubPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 546));

        jTabbedPaneMainPanel.addTab("  MAYOR-CITY COUNCIL  ", jPanelCityCouncil);

        jPanelParamedic.setBackground(new java.awt.Color(32, 33, 35));
        jPanelParamedic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblParamedicTraffic.setBackground(new java.awt.Color(32, 33, 35));
        tblParamedicTraffic.setForeground(new java.awt.Color(255, 255, 255));
        tblParamedicTraffic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Traffic Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblParamedicTraffic);

        jPanelParamedic.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1230, 480));

        jTabbedPaneMainPanel.addTab("  PARAMEDIC  ", jPanelParamedic);

        jPanelWasteCollector.setBackground(new java.awt.Color(32, 33, 35));
        jPanelWasteCollector.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelWasteCollectorMouseMoved(evt);
            }
        });
        jPanelWasteCollector.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblWasteCollectorBinDetails.setBackground(new java.awt.Color(32, 33, 35));
        tblWasteCollectorBinDetails.setForeground(new java.awt.Color(255, 255, 255));
        tblWasteCollectorBinDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bin Sensor ID", "Bin Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblWasteCollectorBinDetails);

        jPanelWasteCollector.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 500, 480));

        tblWasteCollectorTraffic.setBackground(new java.awt.Color(32, 33, 35));
        tblWasteCollectorTraffic.setForeground(new java.awt.Color(255, 255, 255));
        tblWasteCollectorTraffic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Traffic Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblWasteCollectorTraffic);

        jPanelWasteCollector.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 500, 480));

        btnEmptyBin.setBackground(new java.awt.Color(38, 50, 56));
        btnEmptyBin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEmptyBin.setForeground(new java.awt.Color(255, 255, 255));
        btnEmptyBin.setText("Empty Bin");
        btnEmptyBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyBinActionPerformed(evt);
            }
        });
        jPanelWasteCollector.add(btnEmptyBin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 130, -1));

        jTabbedPaneMainPanel.addTab("  WASTE COLLECTOR  ", jPanelWasteCollector);

        jPanelDummyData.setBackground(new java.awt.Color(32, 33, 35));
        jPanelDummyData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddGarbage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycle-bin256.png"))); // NOI18N
        btnAddGarbage.setBorder(null);
        btnAddGarbage.setContentAreaFilled(false);
        btnAddGarbage.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycle-bin128.png"))); // NOI18N
        btnAddGarbage.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/recycle-binrollover.png"))); // NOI18N
        btnAddGarbage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGarbageActionPerformed(evt);
            }
        });
        jPanelDummyData.add(btnAddGarbage, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        cmbAvailableBinSensorDummy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Available bin sensors to add garbage" }));
        cmbAvailableBinSensorDummy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAvailableBinSensorDummyActionPerformed(evt);
            }
        });
        jPanelDummyData.add(cmbAvailableBinSensorDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        txtBinDummy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBinDummyActionPerformed(evt);
            }
        });
        jPanelDummyData.add(txtBinDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 160, -1));

        btnMakeFlood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/makeFlood256.png"))); // NOI18N
        btnMakeFlood.setBorder(null);
        btnMakeFlood.setContentAreaFilled(false);
        btnMakeFlood.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/makeFlood128.png"))); // NOI18N
        btnMakeFlood.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/makeFloodrollover.png"))); // NOI18N
        jPanelDummyData.add(btnMakeFlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, -1, -1));

        cmbAvailableFloodSensorDummy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Available Flood sensors to Make Flood" }));
        cmbAvailableFloodSensorDummy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAvailableFloodSensorDummyActionPerformed(evt);
            }
        });
        jPanelDummyData.add(cmbAvailableFloodSensorDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));
        jPanelDummyData.add(txtFloodDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 160, -1));

        btnIncreaseTraffic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trafficlights256.png"))); // NOI18N
        btnIncreaseTraffic.setBorder(null);
        btnIncreaseTraffic.setContentAreaFilled(false);
        btnIncreaseTraffic.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/traffic-lights128.png"))); // NOI18N
        btnIncreaseTraffic.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/traffic-lightsrollover.png"))); // NOI18N
        jPanelDummyData.add(btnIncreaseTraffic, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, -1, -1));

        cmbAvailableTrafficSensorDummy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Available Traffic sensors to Increase Traffic" }));
        jPanelDummyData.add(cmbAvailableTrafficSensorDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, -1));
        jPanelDummyData.add(txtTrafficDummy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 160, -1));

        jTabbedPaneMainPanel.addTab("  DUMMY DATA  ", jPanelDummyData);

        jPanelExit.setBackground(new java.awt.Color(32, 33, 35));
        jPanelExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExitImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SmartCityexit.jpg"))); // NOI18N
        jPanelExit.add(lblExitImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        jTabbedPaneMainPanel.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png")), jPanelExit); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jTabbedPaneMainPanel.getAccessibleContext().setAccessibleName("     Me     ");

        setSize(new java.awt.Dimension(1291, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPaneMainPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMainPanelMouseClicked
        switchScreens();
       
    }//GEN-LAST:event_jTabbedPaneMainPanelMouseClicked

    private void jTabbedPaneStationMgtSubPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneStationMgtSubPanelMouseClicked
        switchScreens();

    }//GEN-LAST:event_jTabbedPaneStationMgtSubPanelMouseClicked

    private void cmbSelectSensorStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectSensorStationActionPerformed
//       if (cmbSelectSensorStation.getSelectedIndex() == 0) {
//            System.out.println("index 0");
//        } else if (cmbSelectSensorStation.getSelectedIndex() == 1) {
//            System.out.println("index 1");
//        } else if (cmbSelectSensorStation.getSelectedIndex() == 2) {
//            System.out.println("index 2");
//        } else if (cmbSelectSensorStation.getSelectedIndex() == 3) {
//            System.out.println("index 3");
//        } else {
//            System.out.println("err");
//        }
        selectSensorStation(getMatchedStationId(cmbSelectSensorStation.getSelectedItem().toString()));
        populateSensorMonitorList();
    }//GEN-LAST:event_cmbSelectSensorStationActionPerformed

    private void btnRoleAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleAdminActionPerformed
        jTabbedPaneMainPanel.setSelectedIndex(2);
        switchScreens();
    }//GEN-LAST:event_btnRoleAdminActionPerformed

    private void btnRoleUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoleUserActionPerformed
        jTabbedPaneMainPanel.setSelectedIndex(1);
        switchScreens();
    }//GEN-LAST:event_btnRoleUserActionPerformed

    private void btnAddSensorStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSensorStationActionPerformed

        String stationID = txtStationID.getText();
        String stationName = txtSensorStationName.getText();
        Double latitude = Double.parseDouble(txtLatitude.getText());
        Double longitude = Double.parseDouble(txtLongitude.getText());

        SensorStation aSensorStation = new SensorStation(stationID, stationName, latitude, longitude);
        mothership.addNewSensorStation(aSensorStation);
        populateSensorStationList();
        populateSensorStationDetailsToComboBox(aSensorStation);
       

    }//GEN-LAST:event_btnAddSensorStationActionPerformed

    private void cmbSelectSensorStationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSelectSensorStationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectSensorStationMouseClicked

    private void btnAddSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSensorActionPerformed

        SensorMonitor sensormonitor = new SensorMonitor(txtSensorId.getText(), currentSensorStation.getStationName(), cmbStatus.getSelectedItem().toString(), Double.parseDouble(txtFrequency.getText()), cmbSensorType.getSelectedItem().toString());
        currentSensorStation.addNewSensorMonitor(sensormonitor);
        sensormonitor.setCoords(currentSensorStation.getLocation().getCoords());
        SOSM.addSensorMonitor(sensormonitor);
        populateSensorMonitorList();
        if( cmbSensorType.getSelectedItem().toString()=="Bin Sensor"){
           populateBinSensorsDetailsToComboBox(txtSensorId.getText());
           }
        
        
    //    populateFloodSensorsDetailsToComboBox(txtSensorId.getText());
     //   populateTrafficSensorsDetailsToComboBox(txtSensorId.getText());
        
         populateBinAlertDetails();
        populateTrafficLightAlertDetails();
         populateNearestRoadAlertDetails();

    }//GEN-LAST:event_btnAddSensorActionPerformed

    private void tblViewSensorStationMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSensorStationMouseMoved
        populateSensorMonitorList();
    }//GEN-LAST:event_tblViewSensorStationMouseMoved

    private void btnAddGarbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGarbageActionPerformed
        SetOFData SOD = SetOFData.getSetOFDataInstance();
        String binSensorid = Currentbinsensor.getSensorId();
        data = new Data(binSensorid);
        SOD.addData(data);
        populateBinAlertDetails();
        
    }//GEN-LAST:event_btnAddGarbageActionPerformed

    private void btnEmptyBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyBinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmptyBinActionPerformed

    private void jTabbedPaneMainPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMainPanelMouseMoved
       
    }//GEN-LAST:event_jTabbedPaneMainPanelMouseMoved

    private void jTabbedPaneUserSubPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneUserSubPanelMouseMoved
        populateFloodAlertDetails();
        populateTrafficLightAlertDetails();

    }//GEN-LAST:event_jTabbedPaneUserSubPanelMouseMoved

    private void tblUserTrafficMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserTrafficMouseMoved
          
    }//GEN-LAST:event_tblUserTrafficMouseMoved

    private void jPanelWasteCollectorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelWasteCollectorMouseMoved
       
    }//GEN-LAST:event_jPanelWasteCollectorMouseMoved

    private void cmbAvailableBinSensorDummyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAvailableBinSensorDummyActionPerformed

        selectBinSensor(cmbAvailableBinSensorDummy.getSelectedItem().toString());


    }//GEN-LAST:event_cmbAvailableBinSensorDummyActionPerformed

    private void cmbAvailableFloodSensorDummyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAvailableFloodSensorDummyActionPerformed
         


    }//GEN-LAST:event_cmbAvailableFloodSensorDummyActionPerformed

    private void txtBinDummyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBinDummyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBinDummyActionPerformed

    private void btnRemoveSensorStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSensorStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveSensorStationActionPerformed

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
    private javax.swing.JButton btnAddGarbage;
    private javax.swing.JButton btnAddSensor;
    private javax.swing.JButton btnAddSensorStation;
    private javax.swing.JButton btnEmptyBin;
    private javax.swing.JButton btnIncreaseTraffic;
    private javax.swing.JButton btnMakeFlood;
    private javax.swing.JButton btnRemoveSensor;
    private javax.swing.JButton btnRemoveSensorStation;
    private javax.swing.JButton btnRoleAdmin;
    private javax.swing.JButton btnRoleParamedic;
    private javax.swing.JButton btnRoleUser;
    private javax.swing.JButton btnRoleWasteCollector;
    private javax.swing.JButton btnUpdateSelectedSensor;
    private javax.swing.JComboBox<String> cmbAvailableBinSensorDummy;
    private javax.swing.JComboBox<String> cmbAvailableFloodSensorDummy;
    private javax.swing.JComboBox<String> cmbAvailableTrafficSensorDummy;
    private javax.swing.JComboBox<String> cmbSelectSensorStation;
    private javax.swing.JComboBox<String> cmbSensorType;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanelCityCouncil;
    private javax.swing.JPanel jPanelDummyData;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelMayorMap;
    private javax.swing.JPanel jPanelMayorSensorStation;
    private javax.swing.JPanel jPanelMayorStationManagement;
    private javax.swing.JPanel jPanelParamedic;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JPanel jPanelUserFloodNotify;
    private javax.swing.JPanel jPanelUserTrafficMonitor;
    private javax.swing.JPanel jPanelWasteCollector;
    private javax.swing.JPanel jPanelWelcome;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JTabbedPane jTabbedPaneHome;
    private javax.swing.JTabbedPane jTabbedPaneMainPanel;
    private javax.swing.JTabbedPane jTabbedPaneStationMgtSubPanel;
    private javax.swing.JTabbedPane jTabbedPaneUserSubPanel;
    private javax.swing.JLabel lblExitImage;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblWelcomeImage;
    private javax.swing.ButtonGroup radGrpGender;
    private javax.swing.JTable tblParamedicTraffic;
    private javax.swing.JTable tblStationManagement;
    private javax.swing.JTable tblUserFloodAlerts;
    private javax.swing.JTable tblUserTraffic;
    private javax.swing.JTable tblViewSensorStation;
    private javax.swing.JTable tblWasteCollectorBinDetails;
    private javax.swing.JTable tblWasteCollectorTraffic;
    private javax.swing.JTextField txtBinDummy;
    private javax.swing.JTextField txtFloodDummy;
    private javax.swing.JTextField txtFrequency;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtSensorId;
    private javax.swing.JTextField txtSensorStationName;
    private javax.swing.JTextField txtStationID;
    private javax.swing.JTextField txtTrafficDummy;
    // End of variables declaration//GEN-END:variables

}
