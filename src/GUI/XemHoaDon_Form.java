/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Helper.jdbcHelper;
import Utils.MsgBox;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class XemHoaDon_Form extends javax.swing.JFrame {

    private String TGBD1, TGKT1;
    DefaultTableModel model;

    public XemHoaDon_Form() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public XemHoaDon_Form(String TGBD, String TGKT) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        model = (DefaultTableModel) tblXemHoaDon.getModel();
        this.TGBD1 = TGBD;
        this.TGKT1 = TGKT;
        fillTablle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblXemHoaDon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XEM HÓA ĐƠN");

        tblXemHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã hóa đơn", "Mã nhân viên", "Mã KH", "Ngày tạo", "Ngày thanh toán", "Tiền lãi", "Hình thức TT", "Hình thức bán hàng", "Phí ship", "Tổng tiền", "Ghi chú", "Trạng thái", "Đang xử lý", "Địa chí", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblXemHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(XemHoaDon_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemHoaDon_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemHoaDon_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemHoaDon_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemHoaDon_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblXemHoaDon;
    // End of variables declaration//GEN-END:variables
    void fillTablle() {
        model.setRowCount(0);
        try {
            ResultSet rs = jdbcHelper.query("select * from HOADON\n"
                    + "where  NGAYTHANHTOAN between  ? and ?", TGBD1, TGKT1);

            while (rs.next()) {
                String hinhThucTT, trangThai, dangXuLy, hinhThucBanHang;
                if (rs.getBoolean("HINHTHUCTHANHTOAN") == true) {
                    hinhThucTT = "Tiền mặt";
                } else {
                    hinhThucTT = "Tài khoản";
                }
                if (rs.getBoolean("TRANGTHAI") == true) {
                    trangThai = "HĐ đã thanh toán";
                } else {
                    trangThai = "HĐ bị hủy";
                }
                if (rs.getBoolean("DANGXULY") == false) {
                    dangXuLy = "Hóa đơn chờ";
                } else {
                    dangXuLy = "Đã xử lý";
                }
                if (rs.getBoolean("DANGGIAOHANG") == false) { // hình thức bán hàng
                    hinhThucBanHang = "Trực tiếp";
                } else {
                    hinhThucBanHang = "Online";
                }

                Object[] rowData = {
                    rs.getString("ID"),
                    rs.getString("MAHOADON"),
                    rs.getString("MANHANVIEN"),
                    rs.getString("MAKHACHHANG"),
                    rs.getString("NGAYTAO"),
                    rs.getString("NGAYTHANHTOAN"),
                    rs.getDouble("TIENLAI"),
                    hinhThucTT,
                    hinhThucBanHang,
                    rs.getDouble("PHISHIP"),
                    rs.getDouble("TONGTIEN"),
                    rs.getString("GHICHU"),
                    trangThai,
                    dangXuLy,
                    rs.getString("DIACHI"),
                    rs.getString("SODT"),};
                model.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi xem hóa đơn!");
        }
    }

}