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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TaiyoNg
 */
public class DocGiaIF extends javax.swing.JInternalFrame implements UpdateDocGia.CallbackUpdateDocGia{
    DocGiaDAOImp docGiaDAOImp;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    UpdateDocGia ud = new UpdateDocGia(this);
    /**
     * Creates new form DocGia
     */
    public DocGiaIF() {
        docGiaDAOImp = new DocGiaDAOImp();    
        initComponents();
        displayReader();
    }
    
    public void displayReader(){
        List<DocGia> data = docGiaDAOImp.toList();
        DefaultTableModel model = (DefaultTableModel) tblReader.getModel();
        model.setRowCount(0);
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
                tblReader.setRowSorter(tr);
                tr.setRowFilter(null);
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
    public void updateDocGia(String id, String name, String email, boolean male, boolean female, String birthday, String sdt, String address){
        DocGia dg = new DocGia();
        dg.setId(id);
        dg.setTenDocGia(name);
        dg.setEmail(email);
        if (male) {
            dg.setGioiTinh(true);
        }else if(female){
            dg.setGioiTinh(false);
        }
        dg.setNgaySinh(birthday);
        dg.setSdt(sdt);
        dg.setDiaChi(address);
        docGiaDAOImp.edit(dg);
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
        txtReaderSearch = new javax.swing.JTextField();
        btnReaderSearch = new javax.swing.JButton();
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
        btnAddReader = new javax.swing.JButton();
        btnAddReaderRefresh = new javax.swing.JButton();
        rdoAddReaderGender1 = new javax.swing.JRadioButton();
        rdoAddReaderGender0 = new javax.swing.JRadioButton();
        lblIdErr = new javax.swing.JLabel();
        lblNameErr = new javax.swing.JLabel();
        lblEmailErr = new javax.swing.JLabel();
        lblPhoneErr = new javax.swing.JLabel();
        lblAddressErr = new javax.swing.JLabel();
        lblBirthdayErr = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quản Lý Độc Giả");

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Độc Giả");

        tblReader.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
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

        txtReaderSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnReaderSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReaderSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-18.png"))); // NOI18N
        btnReaderSearch.setText("Tìm Kiếm");
        btnReaderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReaderSearchActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-18.png"))); // NOI18N
        jButton2.setText("Cập Nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-18.png"))); // NOI18N
        jButton3.setText("Xóa");

        btnReaderRefresh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnReaderRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-renew-18.png"))); // NOI18N
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
                        .addComponent(txtReaderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnReaderSearch)
                        .addContainerGap(263, Short.MAX_VALUE))
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
                    .addComponent(txtReaderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReaderSearch))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnReaderRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Độc Giả", jPanel1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
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
        txtAddReaderId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddReaderIdKeyReleased(evt);
            }
        });

        txtAddReaderName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtAddReaderEmail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtAddReaderEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddReaderEmailKeyReleased(evt);
            }
        });

        txtAddReaderPhone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtAddReaderPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddReaderPhoneKeyReleased(evt);
            }
        });

        txtAddReaderAddress.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        dchAddReaderBirthday.setDateFormatString("yyyy-MM-dd");
        dchAddReaderBirthday.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnAddReader.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAddReader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-property-18.png"))); // NOI18N
        btnAddReader.setText("Thêm Mới");
        btnAddReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReaderActionPerformed(evt);
            }
        });

        btnAddReaderRefresh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAddReaderRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-renew-18.png"))); // NOI18N
        btnAddReaderRefresh.setText("Làm Mới");

        buttonGroup1.add(rdoAddReaderGender1);
        rdoAddReaderGender1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rdoAddReaderGender1.setText("Nam");

        buttonGroup1.add(rdoAddReaderGender0);
        rdoAddReaderGender0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rdoAddReaderGender0.setText("Nữ");

        lblIdErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblIdErr.setForeground(new java.awt.Color(248, 4, 19));

        lblNameErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblNameErr.setForeground(new java.awt.Color(248, 4, 19));

        lblEmailErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblEmailErr.setForeground(new java.awt.Color(248, 4, 19));

        lblPhoneErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblPhoneErr.setForeground(new java.awt.Color(248, 4, 19));

        lblAddressErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblAddressErr.setForeground(new java.awt.Color(248, 4, 19));

        lblBirthdayErr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblBirthdayErr.setForeground(new java.awt.Color(248, 4, 19));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dchAddReaderBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddReaderAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddReaderPhone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddReaderEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddReaderName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddReaderId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameErr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmailErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhoneErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddressErr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(194, 194, 194))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(rdoAddReaderGender1)
                        .addGap(55, 55, 55)
                        .addComponent(rdoAddReaderGender0)
                        .addContainerGap(342, Short.MAX_VALUE))
                    .addComponent(lblBirthdayErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddReaderRefresh)
                .addGap(27, 27, 27)
                .addComponent(btnAddReader)
                .addGap(51, 51, 51))
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
                .addGap(9, 9, 9)
                .addComponent(lblIdErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddReaderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddReaderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddReaderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhoneErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dchAddReaderBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBirthdayErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdoAddReaderGender1)
                    .addComponent(rdoAddReaderGender0))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAddReaderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddressErr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReaderRefresh)
                    .addComponent(btnAddReader))
                .addContainerGap())
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
        txtReaderSearch.setText("");
        JOptionPane.showMessageDialog(rootPane, "Danh sách đã được làm mới", "Thông báo", 1);
        displayReader();
    }//GEN-LAST:event_btnReaderRefreshActionPerformed

    private void btnAddReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReaderActionPerformed
        // TODO add your handling code here:
        DocGia dg = new DocGia();
        LocalDate today = LocalDate.now();
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
        dg.setNgayTao(Date.valueOf(today));
        docGiaDAOImp.add(dg);
        JOptionPane.showMessageDialog(rootPane, "Thêm độc giả mới thành công", "Thông báo", 1);
        displayReader();
    }//GEN-LAST:event_btnAddReaderActionPerformed

    private void btnReaderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReaderSearchActionPerformed
        // TODO add your handling code here:
         if (txtReaderSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Xin mời nhập từ khóa tìm kiếm", "Thông báo", 1);
                    
        }else{
            try {
                DefaultTableModel model = (DefaultTableModel)tblReader.getModel();
                String search = txtReaderSearch.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
                tblReader.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error" + e.getMessage());
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_btnReaderSearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TableModel model = tblReader.getModel();
        int selectedRow = tblReader.getSelectedRow();
        String id = model.getValueAt(selectedRow, 0).toString();
        String name = model.getValueAt(selectedRow, 1).toString();
        String email = model.getValueAt(selectedRow, 2).toString();
        String gender = model.getValueAt(selectedRow, 3).toString();
        String sdt = model.getValueAt(selectedRow, 4).toString();
        ud.txtUpdateReaderId.setText(id);
        ud.txtUpdateReaderName.setText(name);
        ud.txtUpdateReaderEmail.setText(email);
        if (gender.equals("Nam")) {
            ud.rdoUpdateReaderGender1.setSelected(true);
        }else if(gender.equals("Nữ")){
            ud.rdoUpdateReaderGender0.setSelected(true);
        }
        ud.txtUpdateReaderPhone.setText(sdt);
        DocGia dg = docGiaDAOImp.find(id);
        ud.txtUpdateReaderAddress.setText(dg.getDiaChi());
        ud.dchUpdateReaderBirthday.setDate(Date.valueOf(dg.getNgaySinh()));
        ud.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtAddReaderIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddReaderIdKeyReleased
        // TODO add your handling code here:
        String pattern = "^DG[0-9]{3}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtAddReaderId.getText());
        if(!match.matches()){
            lblIdErr.setText("Mã người đọc phải có 5 ký tự và theo định dạng DGxxx (x là số)");
        }else{
            lblIdErr.setText("");
        }
    }//GEN-LAST:event_txtAddReaderIdKeyReleased

    private void txtAddReaderEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddReaderEmailKeyReleased
        // TODO add your handling code here:
        String pattern = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9-]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtAddReaderEmail.getText());
        if(!match.matches()){
            lblEmailErr.setText("Định dạng email không đúng");
        }else{
            lblEmailErr.setText("");
        }
    }//GEN-LAST:event_txtAddReaderEmailKeyReleased

    private void txtAddReaderPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddReaderPhoneKeyReleased
        // TODO add your handling code here:
        String pattern = "^0((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d{7})$";
        Pattern patt = Pattern.compile(pattern);
        Matcher match = patt.matcher(txtAddReaderPhone.getText());
        if(!match.matches()){
            lblPhoneErr.setText("Số điện thoại phải đúng định dạng và theo nhà mạng Việt Nam");
        }else{
            lblPhoneErr.setText("");
        }
    }//GEN-LAST:event_txtAddReaderPhoneKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReader;
    private javax.swing.JButton btnAddReaderRefresh;
    private javax.swing.JButton btnReaderRefresh;
    private javax.swing.JButton btnReaderSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dchAddReaderBirthday;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lblAddressErr;
    private javax.swing.JLabel lblBirthdayErr;
    private javax.swing.JLabel lblEmailErr;
    private javax.swing.JLabel lblIdErr;
    private javax.swing.JLabel lblNameErr;
    private javax.swing.JLabel lblPhoneErr;
    private javax.swing.JRadioButton rdoAddReaderGender0;
    private javax.swing.JRadioButton rdoAddReaderGender1;
    private javax.swing.JTable tblReader;
    private javax.swing.JTextField txtAddReaderAddress;
    private javax.swing.JTextField txtAddReaderEmail;
    private javax.swing.JTextField txtAddReaderId;
    private javax.swing.JTextField txtAddReaderName;
    private javax.swing.JTextField txtAddReaderPhone;
    private javax.swing.JTextField txtReaderSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doUpdateDocGia(String id, String name, String email, boolean male, boolean female, String birthday, String sdt, String address) {
        try {
            updateDocGia(id, name, email, male, female, birthday, sdt, address);
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin độc giả thành công", "Thông Báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin độc giả thành công", "Thông Báo", 0);
            e.printStackTrace();
        }
        displayReader();
    }
}
