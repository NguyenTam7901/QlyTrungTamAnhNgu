/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytrungtamanhngu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class GiangVien extends javax.swing.JInternalFrame {
    private int index;
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;
    DefaultTableModel tableModel;
    /**
     * Creates new form GiangVien
     */
    public GiangVien() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        tableModel = (DefaultTableModel) jtableGiangVien.getModel();
        jtxtDiaChi.grabFocus();
        hienThiDuLieu();
    }
    private Connection ConnectToServer() {
        String user = "sa";
        String pass = "123456";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu",user,pass);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void hienThiDuLieu() {
        try {
            conn = ConnectToServer();
            String sql = "select *"+
                            "from GIANGVIEN";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            //
            tableModel.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                   };
                tableModel.addRow(row);
            }

            // 
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
     public void refresh() {      
        jtxtMaGiangVien.setText("");
        jtxtTenGiangVien.setText("");
        jtxtDiaChi.setText("");
        jtxtSDT.setText("");
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
        jtableGiangVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtMaGiangVien = new javax.swing.JTextField();
        jtxtTenGiangVien = new javax.swing.JTextField();
        jtxtDiaChi = new javax.swing.JTextField();
        jtxtSDT = new javax.swing.JTextField();
        jbtnThem = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtxtTimKiem = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ GIẢNG VIÊN");

        jtableGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Giảng Viên", "Tên Giảng Viên", "Địa Chỉ", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableGiangVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableGiangVien);

        jLabel2.setText("Mã Giảng Viên");

        jLabel3.setText("Tên Giảng Viên");

        jLabel4.setText("Địa Chỉ");

        jLabel5.setText("Số Điện Thoại");

        jtxtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSDTActionPerformed(evt);
            }
        });

        jbtnThem.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnXoa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnXoa.setText("Xóa");
        jbtnXoa.setPreferredSize(new java.awt.Dimension(60, 28));
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jbtnSua.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnSua.setText("Sửa");
        jbtnSua.setPreferredSize(new java.awt.Dimension(60, 28));
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm Kiếm");

        jtxtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtxtTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jtxtMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(50, 50, 50)
                                            .addComponent(jtxtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jbtnThem)
                                .addGap(119, 119, 119)
                                .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jtxtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jtxtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSDTActionPerformed

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
        
        try {
            StringBuffer sb = new StringBuffer();
            Validation.check(jtxtTenGiangVien, sb, "Tên giảng viên không được để trống");
            Validation.check(jtxtSDT, sb, "Số điện thoại không được để trống");

            while (true) {
                if (jtxtSDT.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
                    jtxtSDT.grabFocus();
                    return;
                } else if (jtxtSDT.getText().trim().length() > 11 || jtxtSDT.getText().trim().length() < 10) {
                    JOptionPane.showMessageDialog(this, "SĐT chứa từ 10-11 số.");
                    jtxtSDT.grabFocus();
                    return;
                } else if (!jtxtSDT.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
                    JOptionPane.showMessageDialog(this, "SĐT chưa đúng định dạng.");
                    jtxtSDT.grabFocus();
                    return;
                } else {
                    break;
                }
            }

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Thêm vào csdl
            conn = ConnectToServer();
            String sql =  "INSERT INTO GIANGVIEN (MAGIANGVIEN,TENGIANGVIEN,DIACHI,SDT)" + "VALUES(?,?,?,?)";
            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            tableModel.setRowCount(0);
//            while(rs.next()){
//                
//            String[]row  = new String[]{
//            rs.getString(1),
//            rs.getString(2), 
//            rs.getString(3),
//            rs.getString(4),
//            rs.getString(5),
//            };
//         }
            ps.setString(1,jtxtMaGiangVien.getText());
            ps.setString(2,jtxtTenGiangVien.getText());
            ps.setString(3,jtxtDiaChi.getText());
            ps.setString(4,jtxtSDT.getText());
            ps.executeUpdate();
            hienThiDuLieu();
            
            JOptionPane.showMessageDialog(this, "Thêm giảng viên thành công");
            refresh();
//            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jtableGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableGiangVienMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtableGiangVien.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vào dòng cần hiển thị");
                return;
            } else {
                jtxtMaGiangVien.setText(jtableGiangVien.getValueAt(row, 0).toString());
                jtxtTenGiangVien.setText(jtableGiangVien.getValueAt(row, 1).toString());
                jtxtDiaChi.setText(jtableGiangVien.getValueAt(row, 2).toString());
                jtxtSDT.setText(jtableGiangVien.getValueAt(row, 3).toString());           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jtableGiangVienMouseClicked

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        // TODO add your handling code here:
         int row = jtableGiangVien.getSelectedRow();
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa giảng viên này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
         try {
            if (getIndex() >= 0){
                row = getIndex();
            }
            
//        try {
            String MaGiangVien = jtableGiangVien.getValueAt(row, 0).toString();
            conn = ConnectToServer();
            //Xóa tt csdl từ mã kh
            String sql = "  DELETE FROM GIANGVIEN WHERE MAGIANGVIEN = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, MaGiangVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Xóa giảng viên này thành công");
            hienThiDuLieu();
            refresh();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật giảng viên này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = ConnectToServer();
            int row =jtableGiangVien.getSelectedRow();
            //Câp nhật vào csdl , lấy từ mã KH
            String sql = "update  GIANGVIEN set TENGIANGVIEN = ?, DIACHI = ?, SDT = ?"
            +" where MAGIANGVIEN = ? ";
            ps = conn.prepareStatement(sql);

            ps.setString(4, jtxtMaGiangVien.getText());
            ps.setString(1, jtxtTenGiangVien.getText());           
            ps.setString(2,jtxtDiaChi.getText());
            ps.setString(3, jtxtSDT.getText());                             
            //ps.setString(4,dtmKH.getValueAt(row,0 ).toString());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật giảng viên thành công");
            hienThiDuLieu();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnSuaActionPerformed

    
     private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }
    
    private void jtxtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTimKiemKeyReleased
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//              String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu", user, pass; 
//              Connection con = DriverManager.getConnection(url);
              conn = ConnectToServer();
              String sql = "Select *from [GiangVien] where [MaGiangVien] = ?";
              PreparedStatement pst = conn.prepareStatement(sql);
              pst.setString(1, jtxtTimKiem.getText());
              ResultSet rs = pst.executeQuery();
              
              String getIndex = "SELECT [MaGiangVien], ROW_NUMBER() OVER (ORDER BY MaGiangVien) AS [MaGiangVien]\n"
                                + "FROM [GiangVien]";
              PreparedStatement ps = conn.prepareStatement(getIndex);
              ResultSet rt = ps.executeQuery();
              
            if (rs.next()) {
                String setid = rs.getString(1);
                jtxtMaGiangVien.setText(setid);

                String settengiangvien = rs.getString(2);
                jtxtTenGiangVien.setText(settengiangvien);

                String setdiachi= rs.getString(3);
                jtxtDiaChi.setText(setdiachi);

                String setsdt= rs.getString(4);
                jtxtSDT.setText(setsdt);

         
            }
            
            int index = 0;
            while (rt.next()){                
                if (rt.getString(1).equalsIgnoreCase(jtxtMaGiangVien.getText())){
                    System.out.println(rt.getString(1) + " " + rt.getString(2));
                    index = Integer.parseInt(rt.getString(2));
                }
            }
            if (index >= 0) {
                setIndex(index - 1);
                System.out.println(index);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtxtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JTable jtableGiangVien;
    private javax.swing.JTextField jtxtDiaChi;
    private javax.swing.JTextField jtxtMaGiangVien;
    private javax.swing.JTextField jtxtSDT;
    private javax.swing.JTextField jtxtTenGiangVien;
    private javax.swing.JTextField jtxtTimKiem;
    // End of variables declaration//GEN-END:variables
}
