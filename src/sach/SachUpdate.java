/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

import com.bkap.dao.NhaXuatBanDAOImp;
import com.bkap.dao.SachDAOImp;
import com.bkap.dao.TacGiaDAOImp;
import com.bkap.dao.TheLoaiDAOImp;
import com.bkap.dao.ViTriDAOImp;
import com.bkap.entities.NhaXuatBan;
import com.bkap.entities.Sach;
import com.bkap.entities.TacGia;
import com.bkap.entities.TheLoai;
import com.bkap.entities.ViTri;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TaiyoNg
 */
public class SachUpdate extends javax.swing.JFrame {
    SachDAOImp sachDAOImp;

    /**
     * Creates new form SachUpdate
     */
    public SachUpdate() {

        sachDAOImp = new SachDAOImp();
        initComponents();
        loadCbo();
    }
    
    public void loadCbo(){
        TheLoaiDAOImp theLoaiDAOImp = new TheLoaiDAOImp();
        TacGiaDAOImp tacGiaDAOImp = new TacGiaDAOImp();
        NhaXuatBanDAOImp nhaXuatBanDAOImp = new NhaXuatBanDAOImp();
        ViTriDAOImp viTriDAOImp = new ViTriDAOImp();
        List<TheLoai> tldata = theLoaiDAOImp.toList();
        for (TheLoai tl : tldata) {
            cboUpdateBookCategory.addItem(tl);
        }
        List<TacGia> tgdata = tacGiaDAOImp.toList();
        for (TacGia tg : tgdata) {
            cboUpdateBookAuthor.addItem(tg);
        }
        List<NhaXuatBan> nxbdata = nhaXuatBanDAOImp.toList();
        for (NhaXuatBan nxb : nxbdata) {
            cboUpdateBookPublisher.addItem(nxb);
        }
        List<ViTri> vtdata = viTriDAOImp.toList();
        for (ViTri vt : vtdata) {
            cboUpdateBookLocation.addItem(vt);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUpdateBookID = new javax.swing.JTextField();
        txtUpdateBookPage = new javax.swing.JTextField();
        txtUpdateBookRentPrice = new javax.swing.JTextField();
        txtUpdateBookNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUpdateBookName = new javax.swing.JTextField();
        chbUpdateBookStatus = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboUpdateBookCategory = new javax.swing.JComboBox();
        cboUpdateBookAuthor = new javax.swing.JComboBox();
        cboUpdateBookPublisher = new javax.swing.JComboBox();
        cboUpdateBookLocation = new javax.swing.JComboBox();
        btnConfirmUpdateBook = new javax.swing.JButton();
        btnCancelUpdateBook = new javax.swing.JButton();
        txtUpdateBookPublishYear = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cập nhật thông tin Sách");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setText("Mã Sách:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel3.setText("Năm Xuất Bản:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setText("Số Trang:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel5.setText("Giá Mượn:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel6.setText("Số Lượng:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel7.setText("Trạng Thái:");

        txtUpdateBookID.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtUpdateBookPage.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtUpdateBookRentPrice.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtUpdateBookNumber.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel8.setText("Tên Sách:");

        txtUpdateBookName.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        chbUpdateBookStatus.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        chbUpdateBookStatus.setText("Còn");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel9.setText("Thể loại:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel10.setText("Tác Giả:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel11.setText("Nhà Xuất Bản:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel12.setText("Vị Trí:");

        cboUpdateBookCategory.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboUpdateBookAuthor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboUpdateBookPublisher.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboUpdateBookLocation.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        btnConfirmUpdateBook.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnConfirmUpdateBook.setText("Cập nhật");
        btnConfirmUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmUpdateBookActionPerformed(evt);
            }
        });

        btnCancelUpdateBook.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnCancelUpdateBook.setText("Hủy");

        txtUpdateBookPublishYear.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtUpdateBookPublishYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateBookPublishYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUpdateBookID)
                            .addComponent(txtUpdateBookName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUpdateBookPage)
                            .addComponent(txtUpdateBookRentPrice)
                            .addComponent(txtUpdateBookNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbUpdateBookStatus)
                                    .addComponent(txtUpdateBookPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelUpdateBook, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnConfirmUpdateBook))
                    .addComponent(cboUpdateBookPublisher, 0, 231, Short.MAX_VALUE)
                    .addComponent(cboUpdateBookAuthor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboUpdateBookCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboUpdateBookLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUpdateBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboUpdateBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUpdateBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cboUpdateBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtUpdateBookPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cboUpdateBookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUpdateBookPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cboUpdateBookLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUpdateBookRentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUpdateBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(chbUpdateBookStatus)
                    .addComponent(btnConfirmUpdateBook)
                    .addComponent(btnCancelUpdateBook))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUpdateBookPublishYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateBookPublishYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateBookPublishYearActionPerformed

    private void btnConfirmUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmUpdateBookActionPerformed
        // TODO add your handling code here:
        Sach sa = new Sach();
        sa.setId(txtUpdateBookID.getText());
        sa.setTenSach(txtUpdateBookName.getText());
        sa.setNamXuatBan(Integer.parseInt(txtUpdateBookPublishYear.getText()));
        sa.setSoTrang(Integer.parseInt(txtUpdateBookPage.getText()));
        sa.setGiaMuon(Float.parseFloat(txtUpdateBookRentPrice.getText()));
        sa.setSoLuong(Integer.parseInt(txtUpdateBookNumber.getText()));
        sa.setTrangThai(chbUpdateBookStatus.isSelected());
        sa.setIdTheLoai(((TheLoai)cboUpdateBookCategory.getSelectedItem()).getId());
        sa.setIdTacGia(((TacGia)cboUpdateBookAuthor.getSelectedItem()).getId());
        sa.setIdNXB(((NhaXuatBan)cboUpdateBookPublisher.getSelectedItem()).getId());
        sa.setIdViTri(((ViTri)cboUpdateBookLocation.getSelectedItem()).getId());
        sachDAOImp.edit(sa);
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin sách thành công", "Thông báo", 1);
        
        SachIF saif = new SachIF();
        saif.displayBook();
        
        dispose();
    }//GEN-LAST:event_btnConfirmUpdateBookActionPerformed

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
            java.util.logging.Logger.getLogger(SachUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SachUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SachUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SachUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SachUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelUpdateBook;
    private javax.swing.JButton btnConfirmUpdateBook;
    public javax.swing.JComboBox cboUpdateBookAuthor;
    public javax.swing.JComboBox cboUpdateBookCategory;
    public javax.swing.JComboBox cboUpdateBookLocation;
    public javax.swing.JComboBox cboUpdateBookPublisher;
    public javax.swing.JCheckBox chbUpdateBookStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtUpdateBookID;
    public javax.swing.JTextField txtUpdateBookName;
    public javax.swing.JTextField txtUpdateBookNumber;
    public javax.swing.JTextField txtUpdateBookPage;
    public javax.swing.JTextField txtUpdateBookPublishYear;
    public javax.swing.JTextField txtUpdateBookRentPrice;
    // End of variables declaration//GEN-END:variables
}
