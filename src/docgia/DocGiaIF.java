/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docgia;

import com.bkap.dao.DocGiaDAOImp;
import com.bkap.entities.DocGia;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TaiyoNg
 */
public class DocGiaIF extends javax.swing.JInternalFrame {
    DocGiaDAOImp docGiaDAOImp;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = new java.util.Date();
    /**
     * Creates new form DocGia
     */
    public DocGiaIF() {
        docGiaDAOImp = new DocGiaDAOImp();    
        initComponents();
        txtAddReaderCreatedDate.setText(sf.format(date));
        displayReader();
    }
    
    public void displayReader(){
        List<DocGia> data = docGiaDAOImp.toList();
        DefaultTableModel model = (DefaultTableModel) tblReader.getModel();
        model.setRowCount(0);
        Calendar c = Calendar.getInstance();
        String gioitinh;
        for (DocGia dg : data) {
            c.setTime(dg.getNgayTao());
            c.add(Calendar.DATE, 2);
            if (dg.getGioiTinh() == true) {
                gioitinh = "Nam";
            }else{
                gioitinh = "Nữ";
            }
            model.addRow(new Object[]{dg.getId(), dg.getTenDocGia(), dg.getEmail(), gioitinh, dg.getSdt(), sdf.format(c.getTime())});
        }
        tblReader.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReader = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnReaderRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAddReaderId = new javax.swing.JTextField();
        txtAddReaderName = new javax.swing.JTextField();
        txtAddReaderEmail = new javax.swing.JTextField();
        txtAddReaderPhone = new javax.swing.JTextField();
        txtAddReaderAddress = new javax.swing.JTextField();
        dchAddReaderBirthday = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btnAddReader = new javax.swing.JButton();
        btnAddReaderRefresh = new javax.swing.JButton();
        rdoAddReaderGender1 = new javax.swing.JRadioButton();
        rdoAddReaderGender0 = new javax.swing.JRadioButton();
        txtAddReaderCreatedDate = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Độc Giả");

        tblReader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Độc Giả", "Email", "Giới Tính", "Số Điện Thoại", "Ngày Tạo"
            }
        ));
        jScrollPane1.setViewportView(tblReader);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Tìm Kiếm");

        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setText("Cập Nhật");

        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setText("Xóa");

        btnReaderRefresh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReaderRefresh.setText("Làm Mới");
        btnReaderRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReaderRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addContainerGap(285, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReaderRefresh)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnReaderRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Độc Giả", jPanel1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm mới Độc Giả");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Mã Độc Giả:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Tên Độc Giả:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Số Điện Thoại:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Ngày Sinh:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Giới Tính:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Địa Chỉ:");

        txtAddReaderId.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtAddReaderName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtAddReaderEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtAddReaderPhone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtAddReaderAddress.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        dchAddReaderBirthday.setDateFormatString("yyyy-MM-dd");
        dchAddReaderBirthday.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Ngày Tạo:");

        btnAddReader.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAddReader.setText("Thêm Mới");
        btnAddReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReaderActionPerformed(evt);
            }
        });

        btnAddReaderRefresh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAddReaderRefresh.setText("Làm Mới");

        buttonGroup1.add(rdoAddReaderGender1);
        rdoAddReaderGender1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rdoAddReaderGender1.setText("Nam");

        buttonGroup1.add(rdoAddReaderGender0);
        rdoAddReaderGender0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rdoAddReaderGender0.setText("Nữ");

        txtAddReaderCreatedDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtAddReaderCreatedDate.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddReaderAddress)
                            .addComponent(txtAddReaderPhone)
                            .addComponent(txtAddReaderEmail)
                            .addComponent(txtAddReaderName)
                            .addComponent(txtAddReaderId)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtAddReaderCreatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(209, 209, 209))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchAddReaderBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoAddReaderGender1)
                                .addGap(55, 55, 55)
                                .addComponent(rdoAddReaderGender0)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddReaderRefresh)
                .addGap(32, 32, 32)
                .addComponent(btnAddReader)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddReaderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddReaderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddReaderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddReaderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dchAddReaderBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdoAddReaderGender1)
                    .addComponent(rdoAddReaderGender0))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAddReaderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAddReaderCreatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReader)
                    .addComponent(btnAddReaderRefresh))
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("Thêm mới Độc Giả", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReaderRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReaderRefreshActionPerformed
        // TODO add your handling code here:
        displayReader();
    }//GEN-LAST:event_btnReaderRefreshActionPerformed

    private void btnAddReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReaderActionPerformed
        // TODO add your handling code here:
        DocGia dg = new DocGia();
        String ngaysinh = ((JTextField)dchAddReaderBirthday.getDateEditor().getUiComponent()).getText();
        dg.setId(txtAddReaderId.getText());
        dg.setTenDocGia(txtAddReaderName.getText());
        dg.setEmail(txtAddReaderEmail.getText());
        dg.setSdt(txtAddReaderPhone.getText());
        if (rdoAddReaderGender1.isSelected()) {
            dg.setGioiTinh(true);
        }
        else if(rdoAddReaderGender0.isSelected()){
            dg.setGioiTinh(false);
        }
        dg.setNgaySinh(ngaysinh);
        dg.setDiaChi(txtAddReaderAddress.getText());
        dg.setNgayTao(Date.valueOf(txtAddReaderCreatedDate.getText()));
        docGiaDAOImp.add(dg);
        JOptionPane.showMessageDialog(rootPane, "Thêm độc giả mới thành công", "Thông báo", 1);
        displayReader();
    }//GEN-LAST:event_btnAddReaderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReader;
    private javax.swing.JButton btnAddReaderRefresh;
    private javax.swing.JButton btnReaderRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dchAddReaderBirthday;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdoAddReaderGender0;
    private javax.swing.JRadioButton rdoAddReaderGender1;
    private javax.swing.JTable tblReader;
    private javax.swing.JTextField txtAddReaderAddress;
    private javax.swing.JTextField txtAddReaderCreatedDate;
    private javax.swing.JTextField txtAddReaderEmail;
    private javax.swing.JTextField txtAddReaderId;
    private javax.swing.JTextField txtAddReaderName;
    private javax.swing.JTextField txtAddReaderPhone;
    // End of variables declaration//GEN-END:variables
}
