package View;

import Controller.SetOfBinSensors;
import Controller.SetOfEmbelishedData;
import Controller.SetOfFloodSensors;
import Controller.SetOfSensorMonitors;
import Controller.SetOfSensors;
import Controller.SetOfTrafficSensors;
import Models.Clock;
import Models.Data;
import Models.EmbelishedData;

import Models.Sensor;
import Models.SensorMonitor;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshana
 */
public class AddSensor extends javax.swing.JFrame {

    private SetOfSensorMonitors SOSM = new SetOfSensorMonitors();
    private SetOfSensors SOS = new SetOfSensors();
    private SetOfEmbelishedData SOED=new SetOfEmbelishedData();
    
  
    private SensorMonitor sensormonitor;
    private EmbelishedData embelishedData;
    
    public AddSensor() {
        initComponents();
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sensorIdText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sensorStatusText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sensorFrequencyText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SensortypeCombo = new javax.swing.JComboBox<>();
        sensorAddButton = new javax.swing.JButton();
        sensorCancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mytesttable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sensor ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Type");

        sensorStatusText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorStatusTextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Status");

        sensorFrequencyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorFrequencyTextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Freaquency");

        SensortypeCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SensortypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", "Flood Sensor", "Traffic Sensor", "Bin Sensor" }));

        sensorAddButton.setText("Add");
        sensorAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorAddButtonActionPerformed(evt);
            }
        });

        sensorCancelButton.setText("Cancel");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Add Sensor");

        mytesttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(mytesttable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 460, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sensorFrequencyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorFrequencyTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sensorFrequencyTextActionPerformed

    private void sensorStatusTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorStatusTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sensorStatusTextActionPerformed

    private void sensorAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorAddButtonActionPerformed

        String inSensorId = sensorIdText.getText();
        String inIsActive = sensorStatusText.getText();
        Double inInterval = Double.parseDouble(sensorFrequencyText.getText());
        String inSensorType = SensortypeCombo.getSelectedItem().toString();

        embelishedData=new EmbelishedData(inSensorId, inSensorType, inIsActive, inInterval);
        SOED.addEmblishedData(embelishedData);
        
        sensormonitor = new SensorMonitor(inSensorId, inInterval, inIsActive, inSensorType);
        SOSM.addSensorMonitor(sensormonitor);
        sensormonitor.setSetOfSensorMonitors(SOSM);
        
         DefaultTableModel dtm = (DefaultTableModel) mytesttable.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < SOED.size(); i++) {
                EmbelishedData ed = SOED.get(i);
                Vector v = new Vector();
                v.add(ed.getSensorID());
                v.add(ed.getSensorDescription());
                v.add(0);
                v.add(ed.getStatus());
                v.add(ed.getFrequency());
                dtm.addRow(v);
            }
         try {
            Clock clock = Clock.getInstance();
            clock.registerObserver(sensormonitor);
           
           // System.out.println(SOED.size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_sensorAddButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSensor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SensortypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mytesttable;
    private javax.swing.JButton sensorAddButton;
    private javax.swing.JButton sensorCancelButton;
    private javax.swing.JTextField sensorFrequencyText;
    private javax.swing.JTextField sensorIdText;
    private javax.swing.JTextField sensorStatusText;
    // End of variables declaration//GEN-END:variables
}
