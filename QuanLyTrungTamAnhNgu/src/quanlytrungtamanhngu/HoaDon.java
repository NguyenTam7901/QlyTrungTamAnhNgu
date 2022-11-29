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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

 /*
 * @author HP
 */
public class HoaDon extends javax.swing.JInternalFrame {
     private int index;
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;
    DefaultTableModel tableModel;
    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        tableModel = (DefaultTableModel) jtableHoaDon.getModel();
        jtxtTrangThai.grabFocus();
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
                            "from HOADON";
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
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
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
        jtxtMaHoaDon.setText("");
        jtxtMaHocPhi.setText("");
        jtxtMaHocVien.setText("");
        jtxtSoTienPhaiDong.setText("");
        jtxtNgayDong.setText("");
        jtxtHinhThucThanhToan.setText("");        
        jtxtTrangThai.grabFocus();
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
        jtableHoaDon = new javax.swing.JTable();
        jtxtMaHoaDon = new javax.swing.JTextField();
        jtxtSoTienPhaiDong = new javax.swing.JTextField();
        jtxtNgayDong = new javax.swing.JTextField();
        jtxtHinhThucThanhToan = new javax.swing.JTextField();
        jtxtMaHocPhi = new javax.swing.JTextField();
        jtxtMaHocVien = new javax.swing.JTextField();
        jtxtTrangThai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbtnThem = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtxtTimKiem = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(659, 580));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jtableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Học Phí", "Mã Học Viên", "Số Tiền Phải Đóng", "Ngày Đóng", "Hình Thức Thanh Toán", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableHoaDon);

        jtxtTrangThai.setText("Đã đóng");

        jLabel2.setText("Mã Hóa Đơn");

        jLabel3.setText("Số Tiền Phải Đóng");

        jLabel4.setText("Ngày Đóng");

        jLabel5.setText("Hình ThứcThanh Toán");

        jLabel6.setText("Trạng Thái");

        jLabel7.setText("Mã HọcPhí");

        jLabel8.setText("Mã Học Viên");

        jbtnThem.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnXoa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnXoa.setText("Xóa ");
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

        jLabel9.setText("Tìm Kiếm");

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
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jtxtSoTienPhaiDong)
                            .addComponent(jtxtNgayDong)
                            .addComponent(jtxtHinhThucThanhToan)
                            .addComponent(jtxtTrangThai))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jtxtMaHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtTimKiem)
                                    .addComponent(jtxtMaHocVien, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jbtnThem)
                        .addGap(67, 67, 67)
                        .addComponent(jbtnXoa)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMaHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtSoTienPhaiDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMaHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNgayDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnXoa)
                    .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
        try {
            StringBuffer sb = new StringBuffer();
            Validation.check(jtxtSoTienPhaiDong, sb, "Số tiền phải đóng không được để trống");
            //Validation.check(jtxtSDT, sb, "Sđt không được để trống");

//            while (true) {
//                if (jtxtSDT.getText().trim().equals("")) {
//                    JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else if (jtxtSDT.getText().trim().length() > 11 || jtxtSDT.getText().trim().length() < 10) {
//                    JOptionPane.showMessageDialog(this, "SĐT chứa từ 10-11 số.");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else if (!jtxtSDT.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
//                    JOptionPane.showMessageDialog(this, "SĐT chưa đúng định dạng.");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else {
//                    break;
//                }
//            }

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Thêm vào csdl
            conn = ConnectToServer();
            String sql =  "INSERT INTO HOADON (MAHOADON,MAHOCPHI,MAHOCVIEN,SoTienDaDong,NGAYDONG,HINHTHUCTHANHTOAN,TRANGTHAI)" + "VALUES(?,?,?,?,?,?,?)";
//            String sql =  "INSERT INTO HOADON (1,2,3,4,5,6,7)" + "VALUES(?,?,?,?,?,?,?)";

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
            ps.setString(1,jtxtMaHoaDon.getText());
            ps.setString(2,jtxtMaHocPhi.getText());
            ps.setString(3,jtxtMaHocVien.getText());
            ps.setFloat(4,Float.parseFloat(jtxtSoTienPhaiDong.getText()));
            ps.setString(5,jtxtNgayDong.getText());
            ps.setString(6,jtxtHinhThucThanhToan.getText());
            ps.setString(7,jtxtTrangThai.getText());


            ps.executeUpdate();
            hienThiDuLieu();
            
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
            refresh();
//            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jtableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableHoaDonMouseClicked
        // TODO add your handling code here:
          try {
            int row = jtableHoaDon.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vào dòng cần hiển thị");
                return;
            } else {
                jtxtMaHoaDon.setText(jtableHoaDon.getValueAt(row, 0).toString());
                jtxtMaHocPhi.setText(jtableHoaDon.getValueAt(row, 1).toString());
                jtxtMaHocVien.setText(jtableHoaDon.getValueAt(row, 2).toString());
                jtxtSoTienPhaiDong.setText(jtableHoaDon.getValueAt(row, 3).toString());
                jtxtNgayDong.setText(jtableHoaDon.getValueAt(row, 4).toString());
                jtxtHinhThucThanhToan.setText(jtableHoaDon.getValueAt(row, 5).toString());
                jtxtTrangThai.setText(jtableHoaDon.getValueAt(row, 6).toString());

             
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtableHoaDonMouseClicked

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        // TODO add your handling code here:
         int row = jtableHoaDon.getSelectedRow();
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa hóa đơn này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            if (getIndex() >= 0){
                row = getIndex();
            }
//        try {
            String MaHoaDon = jtableHoaDon.getValueAt(row, 0).toString();
            conn = ConnectToServer();
            //Xóa tt csdl từ mã kh
            String sql = "  DELETE FROM HOADON WHERE MAHOADON = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, MaHoaDon);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Xóa hóa đơn này thành công");
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
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật hóa đơn này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = ConnectToServer();
            int row =jtableHoaDon.getSelectedRow();
            //Câp nhật vào csdl , lấy từ mã KH
            String sql = "update  HOADON set MAHOCPHI = ?,MAHOCVIEN = ?, SoTienDaDong = ?, NGAYDONG = ?, HINHTHUCTHANHTOAN = ?, TRANGTHAI = ?"
            +" where MAHOADON = ? ";
            ps = conn.prepareStatement(sql);

            ps.setString(7, jtxtMaHoaDon.getText());
            ps.setString(1, jtxtMaHocPhi.getText());           
            ps.setString(2,jtxtMaHocVien.getText());
            ps.setFloat(3, Float.parseFloat(jtxtSoTienPhaiDong.getText()));
            ps.setString(4, jtxtNgayDong.getText());
            ps.setString(5, jtxtHinhThucThanhToan.getText());
            ps.setString(6, jtxtTrangThai.getText());
            
           
           
            //ps.setString(4,dtmKH.getValueAt(row,0 ).toString());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật hóa đơn thành công");
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
              String sql = "Select *from [HoaDon] where [MaHoaDon] = ?";
              PreparedStatement pst = conn.prepareStatement(sql);
              pst.setString(1, jtxtTimKiem.getText());
              ResultSet rs = pst.executeQuery();
              
              String getIndex = "SELECT [MaHoaDon], ROW_NUMBER() OVER (ORDER BY MaHoaDon) AS [MaHoaDon]\n"
                                + "FROM [HoaDon]";
              PreparedStatement ps = conn.prepareStatement(getIndex);
              ResultSet rt = ps.executeQuery();
              
            if (rs.next()) {
                String setidhoadon = rs.getString(1);
                jtxtMaHoaDon.setText(setidhoadon);

                String setkhoahoc = rs.getString(2);
                jtxtMaHocPhi.setText(setkhoahoc);

                String setidhocvien = rs.getString(3);
                jtxtMaHocVien.setText(setidhocvien);

                String setsotienphaidong= rs.getString(4);
                jtxtSoTienPhaiDong.setText(setsotienphaidong);

                String setngaydong = rs.getString(5);
                jtxtNgayDong.setText(setngaydong);
                
                String sethinhthuc = rs.getString(6);
                jtxtHinhThucThanhToan.setText(sethinhthuc);
                
                String settrangthai = rs.getString(7);
                jtxtTrangThai.setText(settrangthai);
            }
            
            int index = 0;
            while (rt.next()){                
                if (rt.getString(1).equalsIgnoreCase(jtxtMaHoaDon.getText())){
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JTable jtableHoaDon;
    private javax.swing.JTextField jtxtHinhThucThanhToan;
    private javax.swing.JTextField jtxtMaHoaDon;
    private javax.swing.JTextField jtxtMaHocPhi;
    private javax.swing.JTextField jtxtMaHocVien;
    private javax.swing.JTextField jtxtNgayDong;
    private javax.swing.JTextField jtxtSoTienPhaiDong;
    private javax.swing.JTextField jtxtTimKiem;
    private javax.swing.JTextField jtxtTrangThai;
    // End of variables declaration//GEN-END:variables
}