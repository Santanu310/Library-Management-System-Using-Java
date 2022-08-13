/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santanu
 */
public class viewrecords extends javax.swing.JFrame {

    /**
     * Creates new form viewrecords
     */
    DefaultTableModel model;

    public viewrecords() {
        initComponents();
        setissueDetailsToTable();
    }

    //display data in table from database
    public void setissueDetailsToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM issue_book_details");

            while (rs.next()) {
                String issueId = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj = {issueId, bookName, studentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //search button
    public void search() {
        Date uFromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();

        long l1 = uFromDate.getTime(); //L1
        long l2 = uToDate.getTime(); //L2

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);

        try {
            Connection con = LMS.getConnection();
            String sql = "SELECT * FROM issue_book_details WHERE issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Record Found.");

            } else {

                while (rs.next()) {
                    String issueId = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String studentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj = {issueId, bookName, studentName, issueDate, dueDate, status};
                    model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                    model.addRow(obj);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //methodd to clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSButtonHover4 = new rojerusan.RSButtonHover();
        rSButtonHover3 = new rojerusan.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel30 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonHover4.setBackground(new java.awt.Color(78, 73, 73,70));
        rSButtonHover4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 185, 70)));
        rSButtonHover4.setText("ALL");
        rSButtonHover4.setColorHover(new java.awt.Color(0,0,0,80));
        rSButtonHover4.setColorTextHover(new java.awt.Color(255, 153, 102));
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 155, 70, 40));

        rSButtonHover3.setBackground(new java.awt.Color(78, 73, 73,70));
        rSButtonHover3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 185, 70)));
        rSButtonHover3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-search-24.png"))); // NOI18N
        rSButtonHover3.setText("SEARCH");
        rSButtonHover3.setColorHover(new java.awt.Color(0,0,0,80));
        rSButtonHover3.setColorTextHover(new java.awt.Color(255, 153, 102));
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 155, 160, 40));

        tbl_issueBookDetails.setBackground(new java.awt.Color(78, 73, 73,20));
        tbl_issueBookDetails.setForeground(new java.awt.Color(102, 102, 102));
        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tbl_issueBookDetails.setColorBordeFilas(new java.awt.Color(242, 157, 71));
        tbl_issueBookDetails.setColorBordeHead(new java.awt.Color(242, 157, 71));
        tbl_issueBookDetails.setColorFilasBackgound1(new java.awt.Color(102, 102, 102));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 153, 102));
        tbl_issueBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_issueBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_issueBookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_issueBookDetails.setRowHeight(30);
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 980, 290));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 204, 255));
        jLabel28.setText("Enter Issue Date");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 190, 20));

        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-view-schedule-26.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 30, 30));

        date_fromDate.setColorBackground(new java.awt.Color(78, 73, 73,70));
        date_fromDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_fromDate.setFuente(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_fromDate.setPlaceholder("Enter Issue Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 290, 32));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 204, 255));
        jLabel30.setText("Enter Due Date");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 160, 20));

        date_toDate.setColorBackground(new java.awt.Color(78, 73, 73,70));
        date_toDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_toDate.setFuente(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_toDate.setPlaceholder("Enter Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 290, 32));

        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-moleskine-icon-26.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 30, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 204, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-view-details-64.png"))); // NOI18N
        jLabel22.setText("View Records ");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 9, 0, new java.awt.Color(255, 204, 255)));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 290, 80));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-home-50.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/view records.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        setSize(new java.awt.Dimension(1040, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dashboard board = new dashboard();
        board.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha()!= null){
                    
            clearTable();
            search();
        }else{
            JOptionPane.showMessageDialog(this, "Please Select Date.");
        }


    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
        clearTable();
        setissueDetailsToTable();
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

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
            java.util.logging.Logger.getLogger(viewrecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewrecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewrecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewrecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewrecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonHover rSButtonHover3;
    private rojerusan.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}