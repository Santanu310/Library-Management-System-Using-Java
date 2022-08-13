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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Santanu
 */
public class managestudents extends javax.swing.JFrame {

    /**
     * Creates new form managebooks
     */
    
    String studentName,course,clas;
    int studentId;
    DefaultTableModel model;
    
    public managestudents() {
        initComponents();
        
         setStudentDetailsToTable();
    }
    
    //display data in table from database
     public void setStudentDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useTimezone=true&serverTimezone=UTC","root","");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student_details");
             
             while(rs.next()){
                 String studentId = rs.getString("student_id");
                 String studentName = rs.getString("name");
                 String course = rs.getString("course");
                 String clas = rs.getString("class");
                 
                 
                 Object[] obj = {studentId,studentName,course,clas};
                 model= (DefaultTableModel) tbl_studentDetails.getModel();
                 model.addRow(obj);
                 
             
             }
             
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    //add button
    
    public boolean addStudent(){
        
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = txt_courseName.getText();
        clas = txt_class.getText();
        
        
        try {
           Connection con = LMS.getConnection();
           String sql = "INSERT INTO student_details values(?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, studentId);
           pst.setString(2, studentName);
           pst.setString(3, course);
           pst.setString(4, clas);
           
           
           int rowCount = pst.executeUpdate();
           
           if(rowCount > 0){
               isAdded = true;
           }else{
               isAdded = false;
           }
             
             
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return isAdded;
    }
    
    
    //uppdate button
    
    public boolean updateStudent(){
        boolean isUpdated = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = txt_courseName.getText();
        clas = txt_class.getText();
        
        try {
            Connection con = LMS.getConnection();
           String sql = "update student_details set name = ?,course = ?,class = ? where student_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, studentName);
           pst.setString(2, course);
           pst.setString(3, clas);
           pst.setInt(4, studentId);
           
           int rowCount = pst.executeUpdate();
           if(rowCount > 0){
               isUpdated = true;
           }else{
               isUpdated =  false;
           }
            
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
    
        return isUpdated;
    
    }
    
    //delete button
    
    public boolean deleteStudent(){
        boolean isDeleted = false; 
        studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            
           Connection con = LMS.getConnection();
           String sql = "DELETE FROM student_details WHERE student_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, studentId);
           
            int rowCount = pst.executeUpdate();
           if(rowCount > 0){
               isDeleted = true;
           }else{
               isDeleted =  false;
           }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
            return isDeleted;
    }
    
    //methodd to clear table
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        rSButtonHover3 = new rojerusan.RSButtonHover();
        rSButtonHover4 = new rojerusan.RSButtonHover();
        jLabel9 = new javax.swing.JLabel();
        txt_class = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_courseName = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-home-50.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(228, 70, 11));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-student-male-52.png"))); // NOI18N
        jLabel10.setText("Manage Students");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 340, 60));

        tbl_studentDetails.setBackground(new java.awt.Color(78, 73, 73,20));
        tbl_studentDetails.setForeground(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Course", "Class"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(242, 157, 71));
        tbl_studentDetails.setColorBordeHead(new java.awt.Color(242, 157, 71));
        tbl_studentDetails.setColorFilasBackgound1(new java.awt.Color(102, 102, 102));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 153, 102));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 590, 240));

        rSButtonHover2.setBackground(new java.awt.Color(78, 73, 73,70));
        rSButtonHover2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 185, 70)));
        rSButtonHover2.setText("ADD ");
        rSButtonHover2.setColorHover(new java.awt.Color(0,0,0,80));
        rSButtonHover2.setColorTextHover(new java.awt.Color(255, 153, 102));
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 140, -1));

        rSButtonHover3.setBackground(new java.awt.Color(78, 73, 73,70));
        rSButtonHover3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 185, 70)));
        rSButtonHover3.setText("UPDATE");
        rSButtonHover3.setColorHover(new java.awt.Color(0,0,0,80));
        rSButtonHover3.setColorTextHover(new java.awt.Color(255, 153, 102));
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 140, -1));

        rSButtonHover4.setBackground(new java.awt.Color(78, 73, 73,70));
        rSButtonHover4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 185, 70)));
        rSButtonHover4.setText("DELETE");
        rSButtonHover4.setColorHover(new java.awt.Color(0,0,0,80));
        rSButtonHover4.setColorTextHover(new java.awt.Color(255, 153, 102));
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 190, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-class-26.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 30, 30));

        txt_class.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_class.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_class.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_class.setPlaceholder("Enter Class");
        txt_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_classActionPerformed(evt);
            }
        });
        jPanel1.add(txt_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 290, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 255));
        jLabel5.setText("Enter Class");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 160, 20));

        txt_courseName.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_courseName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_courseName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_courseName.setPlaceholder("Enter Course Name");
        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 290, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 30, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 255));
        jLabel4.setText("Enter Course Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 190, 20));

        txt_studentName.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 290, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 30, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 255));
        jLabel3.setText("Enter Student Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 220, 20));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 30, 30));

        txt_studentId.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student ID");
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 290, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("Enter Student ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/manage books.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        setSize(new java.awt.Dimension(1040, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void txt_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_classActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_classActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        if(addStudent()== true){
           JOptionPane.showMessageDialog(this, "Student Added Successfully.");
           clearTable();
           setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Student Addition Failed.");
       }
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        if(updateStudent() == true){
           JOptionPane.showMessageDialog(this, "Student Updated Successfully.");
           clearTable();
           setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Student Updation Failed.");
       }
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
         if(deleteStudent()== true){
           JOptionPane.showMessageDialog(this, "Sttudent Deleted Successfully.");
           clearTable();
           setStudentDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Student Delation Failed.");
       }
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dashboard board = new dashboard();
        board.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo=tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        txt_courseName.setText(model.getValueAt(rowNo, 2).toString());
        txt_class.setText(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managestudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonHover rSButtonHover2;
    private rojerusan.RSButtonHover rSButtonHover3;
    private rojerusan.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_class;
    private app.bolivia.swing.JCTextField txt_courseName;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
