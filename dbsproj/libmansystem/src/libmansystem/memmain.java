/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahe
 */
public class memmain extends javax.swing.JFrame {
       Connection Myconn;
    Statement mystmt;
    ResultSet myrs;
    String user;
    String password;
    /**
     * Creates new form memmain
     */
    public memmain( String u,String p) {
        try {
            user=u;
            password=p;
            this.setContentPane(new JLabel(new ImageIcon("yellow.jpg")));
            initComponents();
            this.setSize(600,600);
            this.Myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","myuser1","mypassword");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String nam="",addr="",auth="",tit="";
        int bid=0,pid=0,av =0;
        
        try {
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel() ;
            
            
            
            model.setColumnCount(0);
            model.addColumn("publisher ID");
            model.addColumn("book ID");
            model.addColumn("title");
            model.addColumn("availability");
            model.addColumn("author");
            model.addColumn("name");
            model.addColumn("address");
            mystmt=Myconn.createStatement();
             myrs=mystmt.executeQuery("select * from book natural join publisher");
             while(myrs.next())
             {
                 bid=Integer.parseInt(myrs.getString("book_id"));
                 pid=Integer.parseInt(myrs.getString("publisher_id"));
                 av = Integer.parseInt(myrs.getString("availability"));
                 nam = myrs.getString("name");
                 addr = myrs.getString("address");
                 auth = myrs.getString("author");
                 tit = myrs.getString("title");
                         
                         model.addRow(new Object[] {pid,bid,tit,av,auth,nam,addr});
                 
                 
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(viewbook.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Enter Book Id :");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View Fine");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(117, 117, 117)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int checkbid=Integer.parseInt(jTextField1.getText());
        int flag=0;
                
        String nam="",addr="",auth="",tit="";
        int bid=0,pid=0,av =0;
        
        
        try {
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel() ;
            model.setRowCount(0);

            
            
            
            model.setColumnCount(0);
            model.addColumn("publisher ID");
            model.addColumn("book ID");
            model.addColumn("title");
            model.addColumn("availability");
            model.addColumn("author");
            model.addColumn("name");
            model.addColumn("address");
            mystmt=Myconn.createStatement();
             myrs=mystmt.executeQuery("select * from book natural join publisher");
             while(myrs.next())
             {
                 int abc =Integer.parseInt(myrs.getString("book_id"));
                 if (abc==checkbid)
                 {
                 bid=Integer.parseInt(myrs.getString("book_id"));
                 pid=Integer.parseInt(myrs.getString("publisher_id"));
                 av = Integer.parseInt(myrs.getString("availability"));
                 nam = myrs.getString("name");
                 addr = myrs.getString("address");
                 auth = myrs.getString("author");
                 tit = myrs.getString("title");
                         
                         model.addRow(new Object[] {pid,bid,tit,av,auth,nam,addr});
                         flag=1;
                         break;
                 
                 } 
             }
             if(flag==0)
             {
                 JOptionPane.showMessageDialog(null,"Invalid book id!!!");
                 new memmain(user,password).setVisible(true);
                 this.dispose();
                 
             }
             
             
            
        } catch (SQLException ex) {
            Logger.getLogger(viewbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            new memlogin().setVisible(true);
            this.dispose();// TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             try{
                mystmt=Myconn.createStatement();
                myrs=mystmt.executeQuery("select fine_due from member where member_id='"+user+"'");
                myrs.next();
                JOptionPane.showMessageDialog(null,"Your Due is "+myrs.getString("fine_due"));
             }
             catch(Exception e){
                 System.out.println(user);
                 e.printStackTrace();
             }// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(memmain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memmain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memmain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memmain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
