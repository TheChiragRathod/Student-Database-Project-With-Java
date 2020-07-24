package MyForm;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DisplayData extends javax.swing.JFrame
{
    public DisplayData()
    {
        initComponents();
       show_user_Data();
    }

    public ArrayList<User> userList()
        {
            
            ArrayList<User> userList=new ArrayList<>();
            
            try
            {
                
                //load jdbc driver...
                 Class.forName("com.mysql.jdbc.Driver");
            
                //connection url...
                String MySqlUrl="jdbc:mysql://localhost:3306/javadb?user=root";
            
                //Connection established...
                Connection con=DriverManager.getConnection(MySqlUrl);
            
                Statement stm=con.createStatement();
            
                //Sql Query...
                String Query="SELECT *FROM students";
                
                ResultSet rs=stm.executeQuery(Query);
                
                User user;
                while(rs.next())
                {
                    user=new User(rs.getInt("id"),rs.getString("enrollment"),rs.getString("name"),rs.getString("username"),rs.getString("password"),rs.getString("address"),rs.getString("gender"),rs.getString("java"),rs.getString("python"));
                    userList.add(user);
                }
            
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
            
            return userList; 
        }
        public void show_user_Data()
        {
            ArrayList<User> list=userList();
        
            DefaultTableModel model=(DefaultTableModel)jTable_Display_Data.getModel();
            
            Object[] obj=new Object[9];
            
            for(int i=0;i<list.size();i++)
            {
               
                obj[0]=list.get(i).getid();
                obj[1]=list.get(i).getenrollment();
                obj[2]=list.get(i).getname();
                obj[3]=list.get(i).getusername();
                obj[4]=list.get(i).getpassword();
                obj[5]=list.get(i).getaddress();
                obj[6]=list.get(i).getgender();
                obj[7]=list.get(i).getjava();
                obj[8]=list.get(i).getpython();
                
                model.addRow(obj);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Data = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Record");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Student Record");

        jTable_Display_Data.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_Display_Data.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable_Display_Data.setForeground(new java.awt.Color(153, 153, 255));
        jTable_Display_Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.", "Enrollment No.", "Name", "Username", "Password", "Address", "Gender", "Java", "Python"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Display_Data.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable_Display_Data.getTableHeader().setResizingAllowed(false);
        jTable_Display_Data.getTableHeader().setReorderingAllowed(false);
        jTable_Display_Data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_DataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Data);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 51, 51));
        btnDelete.setText("Delete Record");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(51, 51, 255));
        btnUpdate.setText("Update Record");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 153, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHIRAG-PC\\Documents\\NetBeansProjects\\Form\\src\\MyForm\\student.png")); // NOI18N

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu3.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1149, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(400, 400, 400)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
    if(JOptionPane.showConfirmDialog(this,"Do you want to delete the record?")==0)
    {  
    
        try
        {
            //load jdbc driver...
            Class.forName("com.mysql.jdbc.Driver");
            
           //connection url...
           String MySqlUrl="jdbc:mysql://localhost:3306/javadb?user=root";
           
           //Connection established...
           Connection con=DriverManager.getConnection(MySqlUrl);
           
           Statement stm=con.createStatement();
           
           int Row=jTable_Display_Data.getSelectedRow();
           if(Row==-1)
           {
               JOptionPane.showMessageDialog(this,"Please select any record!...");
               return;
           }
               
           String id=jTable_Display_Data.getModel().getValueAt(Row,0).toString();
           String enrollment=jTable_Display_Data.getModel().getValueAt(Row,1).toString();
           String username=jTable_Display_Data.getModel().getValueAt(Row,3).toString();
           
           //Sql Query...
           String Query="DELETE FROM students WHERE id="+id;
           
           PreparedStatement pst=con.prepareStatement(Query);
           pst.executeUpdate();
           
           DefaultTableModel model=(DefaultTableModel)jTable_Display_Data.getModel();
           model.setRowCount(0);
           
           show_user_Data();
           JOptionPane.showMessageDialog(this,"Deleted Successfully...");
           
           //Creating Delete logs...
            FileWriter fw =new FileWriter("DeleteLog.txt",true);
            BufferedWriter out =new BufferedWriter(fw);
            java.util.Date date = new java.util.Date();
            SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String str=formater.format(date)+"  "+enrollment+"  "+username;
            out.write(str);
            out.write("\n");
            out.close();
            //Delete Log Code Finish...
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error :"+e.getMessage());
        }
    }
    
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    
    public void TableRefresh()
    {
        //Refresing The Table....
        DefaultTableModel temp=(DefaultTableModel)jTable_Display_Data.getModel();
        temp.setRowCount(0);          
        show_user_Data();
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
       
       int row=jTable_Display_Data.getSelectedRow();
       if(row==-1)
       {
            JOptionPane.showMessageDialog(this,"Please select any record!...");
            return;
       }
      
        TableModel model=jTable_Display_Data.getModel();
        String id=model.getValueAt(row,0).toString();
        String Enrollment=model.getValueAt(row,1).toString();
        String Name=model.getValueAt(row,2).toString();
        String Username=model.getValueAt(row,3).toString();
        String Pass=model.getValueAt(row,4).toString();
        String Address=model.getValueAt(row,5).toString();
        String Gender=model.getValueAt(row,6).toString();
        String Java=model.getValueAt(row,7).toString();
        String Python=model.getValueAt(row,8).toString();
        Insert ins=new Insert();
        ins.setValue(id,Enrollment,Name,Username,Pass,Address,Gender,Java,Python);
        ins.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed
    
    private void jTable_Display_DataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_DataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Display_DataMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
     
    if(JOptionPane.showConfirmDialog(this,"Do you want to logout?")==0)
    {
        //Redirect To Login Form...
        new Login_Form().setVisible(true);
        //Closing The Table...
        setVisible(false);   
    }
        
    }//GEN-LAST:event_btnLogoutActionPerformed
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DisplayData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Data;
    // End of variables declaration//GEN-END:variables
}