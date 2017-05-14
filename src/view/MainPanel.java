/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Connection.Connect;
import Connection.ManageConnect;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Teacher;
import controller.TeacherDB;

/**
 *
 * @author Admin
 */
public class MainPanel extends javax.swing.JFrame {

    private ConnectPanel cntp = new ConnectPanel();
    private Connect con;
    public static MainPanel MainP;
    ManageConnect mcon;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private List<Teacher> teachers;

    public MainPanel() {
        initComponents();
        openConnectPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConnect = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelConnect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelConnect.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(

        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainP = new MainPanel();
                MainP.setVisible(false);
            }
        });

    }

    private void openConnectPanel() {
        cntp = new ConnectPanel();
        cntp.setVisible(true);
    }

    public void openConnect() {
        con = cntp.getCon();
         mcon = new ManageConnect(con);
        if (mcon.openConnect()) {
            jLabelConnect.setText("good connection");
        } else {
            jLabelConnect.setText("no connection");
        }

        jTable1.setModel(tableModel);
        try {
            updateInfo();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void updateInfo() throws SQLException {
        // assessments = model.getAssessments();

        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.addColumn("id_teacher");
        tableModel.addColumn("name");
        tableModel.addColumn("surname");
        tableModel.addColumn("patronymic");

        
        TeacherDB teacherdb = new TeacherDB(mcon);
        teachers = teacherdb.all();

        for (Teacher e : teachers) {
            tableModel.addRow(new String[]{e.getId_teacher() + "", e.getName(), e.getSurname(),e.getPatronymic()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelConnect;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
