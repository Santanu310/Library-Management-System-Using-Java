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
public class managebooks extends javax.swing.JFrame {

    /**
     * Creates new form managebooks
     */
    
    String bookName,author,clas,quantity;
    int bookId;
    DefaultTableModel model;
    public managebooks() {
        initComponents();
        
        setBookDetailsToTable();
    }
    
    //display data in table from database
    
    public void setBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useTimezone=true&serverTimezone=UTC","root","");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book_details");
             
             while(rs.next()){
                 String bookId = rs.getString("book_id");
                 String bookName = rs.getString("book_name");
                 String author = rs.getString("author");
                 String clas = rs.getString("class");
                 String quantity = rs.getString("quantity");
                 
                 Object[] obj = {bookId,bookName,author,clas,quantity};
                 model= (DefaultTableModel) tbl_bookDetails.getModel();
                 model.addRow(obj);
                 
             
             }
             
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    //add button
    
    public boolean addBook(){
        
        boolean isAdded = false;
        bookId = Integer.parseInt(txt_bookId.getText());
        bookName = txt_bookName.getText();
        author = txt_author.getText();
        clas = txt_class.getText();
        quantity = txt_quantity.getText();
        
        try {
           Connection con = LMS.getConnection();
           String sql = "INSERT INTO book_details values(?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, bookId);
           pst.setString(2, bookName);
           pst.setString(3, author);
           pst.setString(4, clas);
           pst.setString(5, quantity);
           
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
    
    public boolean updateBook(){
        boolean isUpdated = false;
        bookId = Integer.parseInt(txt_bookId.getText());
        bookName = txt_bookName.getText();
        author = txt_author.getText();
        clas = txt_class.getText();
        quantity = txt_quantity.getText();
        
        try {
            Connection con = LMS.getConnection();
           String sql = "update book_details set book_name = ?,author = ?,class = ?,quantity = ? where book_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, bookName);
           pst.setString(2, author);
           pst.setString(3, clas);
           pst.setString(4, quantity);
           pst.setInt(5, bookId);
           
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
    
    public boolean deleteBook(){
        boolean isDeleted = false; 
        bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            
           Connection con = LMS.getConnection();
           String sql = "DELETE FROM book_details WHERE book_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, bookId);
           
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
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
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
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        rSButtonHover3 = new rojerusan.RSButtonHover();
        rSButtonHover4 = new rojerusan.RSButtonHover();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_class = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_author = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
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
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel10.setText("Manage Books");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 260, 60));

        tbl_bookDetails.setBackground(new java.awt.Color(78, 73, 73,20));
        tbl_bookDetails.setForeground(new java.awt.Color(102, 102, 102));
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Class", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(242, 157, 71));
        tbl_bookDetails.setColorBordeHead(new java.awt.Color(242, 157, 71));
        tbl_bookDetails.setColorFilasBackgound1(new java.awt.Color(102, 102, 102));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 153, 102));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(30);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

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

        txt_quantity.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quantity.setPlaceholder("Enter Quantity");
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 290, -1));

        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 30, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 255));
        jLabel15.setText("Enter Quantity");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 160, 40));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8-class-26.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 30, 30));

        txt_class.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_class.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_class.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_class.setPlaceholder("Enter Class");
        txt_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_classActionPerformed(evt);
            }
        });
        jPanel1.add(txt_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 290, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 255));
        jLabel5.setText("Enter Class");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 160, 20));

        txt_author.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_author.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_author.setPlaceholder("Enter Author Name");
        txt_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorActionPerformed(evt);
            }
        });
        jPanel1.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 290, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 30, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 255));
        jLabel4.setText("Enter Author Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 190, 20));

        txt_bookName.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_bookName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_bookName.setPlaceholder("Enter Book Name");
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 290, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 30, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 255));
        jLabel3.setText("Enter Book Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 160, 20));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 30, 30));

        txt_bookId.setBackground(new java.awt.Color(78, 73, 73,70));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 204, 255)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book ID");
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 290, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("Enter Book ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 160, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/manage books.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 576));

        setSize(new java.awt.Dimension(1040, 615));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorActionPerformed

    private void txt_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_classActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_classActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
       if(addBook() == true){
           JOptionPane.showMessageDialog(this, "Book Added Successfully.");
           clearTable();
           setBookDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Book Addition Failed.");
       }
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
          if(updateBook() == true){
           JOptionPane.showMessageDialog(this, "Book Updated Successfully.");
           clearTable();
           setBookDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Book Updation Failed.");
       }
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
         if(deleteBook() == true){
           JOptionPane.showMessageDialog(this, "Book Deleted Successfully.");
           clearTable();
           setBookDetailsToTable();
       }else{
           JOptionPane.showMessageDialog(this, "Book Delation Failed.");
       }
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dashboard board = new dashboard();
        board.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo=tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        
        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_author.setText(model.getValueAt(rowNo, 2).toString());
        txt_class.setText(model.getValueAt(rowNo, 3).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 4).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managebooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonHover rSButtonHover2;
    private rojerusan.RSButtonHover rSButtonHover3;
    private rojerusan.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_author;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_class;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
