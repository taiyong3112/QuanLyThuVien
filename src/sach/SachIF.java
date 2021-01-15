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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TaiyoNg
 */
public class SachIF extends javax.swing.JInternalFrame {
    SachDAOImp sachDAOImp;
    SachUpdate su = new SachUpdate();
    Date date = new Date();
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Creates new form SachIF
     */
    public SachIF() {
        sachDAOImp = new SachDAOImp();
        initComponents();
        btnBookSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtBookSearch.getText();
                List<Sach> sach = null;
                try {
                    if (name.trim().length() == 0) {
                        sach = sachDAOImp.toList();
                    }else{
                        sach = sachDAOImp.findByName(name);
                    }
                    DefaultTableModel modelSearch = (DefaultTableModel) tblBook.getModel();
                    modelSearch.setRowCount(0);
                    Calendar c = Calendar.getInstance();
                    for (Sach sa : sach) {
                        c.setTime(sa.getNgayTao());
                        c.add(Calendar.DATE, 2);
                        modelSearch.addRow(new Object[]{sa.getId(), sa.getTenSach(), sa.getButDanh(), sa.getTenNXB(), sa.getTenTheLoai(), sa.getTenViTri(), sa.isTrangThai(), sdf.format(c.getTime())});
                    }
                    tblBook.setModel(modelSearch);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Lỗi", "Error", 0);
                }
            }
        });
        txtAddBookCreatedDate.setText(sf.format(date));
        displayBook();
        loadCbo();
    }
    
    public void loadCbo(){
        TheLoaiDAOImp theLoaiDAOImp = new TheLoaiDAOImp();
        TacGiaDAOImp tacGiaDAOImp = new TacGiaDAOImp();
        NhaXuatBanDAOImp nhaXuatBanDAOImp = new NhaXuatBanDAOImp();
        ViTriDAOImp viTriDAOImp = new ViTriDAOImp();
        List<TheLoai> tldata = theLoaiDAOImp.toList();
        for (TheLoai tl : tldata) {
            cboAddBookCategory.addItem(tl);
        }
        List<TacGia> tgdata = tacGiaDAOImp.toList();
        for (TacGia tg : tgdata) {
            cboAddBookAuthor.addItem(tg);
        }
        List<NhaXuatBan> nxbdata = nhaXuatBanDAOImp.toList();
        for (NhaXuatBan nxb : nxbdata) {
            cboAddBookPublisher.addItem(nxb);
        }
        List<ViTri> vtdata = viTriDAOImp.toList();
        for (ViTri vt : vtdata) {
            cboAddBookLocation.addItem(vt);
        }
    }
    public void displayBook(){
        List<Sach> data = sachDAOImp.toList();
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);
        Calendar c = Calendar.getInstance();
        for (Sach sa : data) {
            c.setTime(sa.getNgayTao());
            c.add(Calendar.DATE, 2);
            model.addRow(new Object[]{sa.getId(), sa.getTenSach(), sa.getButDanh(), sa.getTenNXB(), sa.getTenTheLoai(), sa.getTenViTri(), sa.isTrangThai(), sdf.format(c.getTime())});
        }
        tblBook.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBookSearch = new javax.swing.JTextField();
        btnBookSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        btnUpdateBook = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnBookRefresh = new javax.swing.JButton();
        pnlAddBook = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAddBookID = new javax.swing.JTextField();
        cboAddBookCategory = new javax.swing.JComboBox();
        txtAddBookName = new javax.swing.JTextField();
        cboAddBookAuthor = new javax.swing.JComboBox();
        txtAddBookPublishYear = new javax.swing.JTextField();
        cboAddBookPublisher = new javax.swing.JComboBox();
        txtAddBookPage = new javax.swing.JTextField();
        cboAddBookLocation = new javax.swing.JComboBox();
        txtAddBookRentPrice = new javax.swing.JTextField();
        txtAddBookNumber = new javax.swing.JTextField();
        chbAddBookStatus = new javax.swing.JCheckBox();
        btnRefreshAddBook = new javax.swing.JButton();
        btnConfirmAddBook = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAddBookCreatedDate = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sách");

        txtBookSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnBookSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBookSearch.setText("Tìm Kiếm");

        tblBook.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Tác Giả", "Nhà Xuất Bản", "Danh Mục", "Vị Trí", "Trạng Thái", "Ngày Tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        btnUpdateBook.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUpdateBook.setText("Cập Nhật");
        btnUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setText("Xóa");

        btnBookRefresh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBookRefresh.setText("Làm Mới");
        btnBookRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdateBook)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBookSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(btnBookRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBookSearch)
                            .addComponent(txtBookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBookRefresh)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateBook)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sách", jPanel1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm mới Sách");

        txtAddBookID.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboAddBookCategory.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtAddBookName.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboAddBookAuthor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtAddBookPublishYear.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtAddBookPublishYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddBookPublishYearActionPerformed(evt);
            }
        });

        cboAddBookPublisher.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtAddBookPage.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        cboAddBookLocation.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtAddBookRentPrice.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtAddBookNumber.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        chbAddBookStatus.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        chbAddBookStatus.setText("Còn");

        btnRefreshAddBook.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnRefreshAddBook.setText("Làm mới");

        btnConfirmAddBook.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnConfirmAddBook.setText("Thêm mới");
        btnConfirmAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmAddBookActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel3.setText("Mã Sách:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel8.setText("Tên Sách:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setText("Năm Xuất Bản:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel5.setText("Số Trang:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel6.setText("Giá Mượn:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel7.setText("Số Lượng:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel9.setText("Trạng Thái:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel10.setText("Thể loại:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel11.setText("Tác Giả:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel12.setText("Nhà Xuất Bản:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel13.setText("Vị Trí:");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel14.setText("Ngày Tạo:");

        txtAddBookCreatedDate.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtAddBookCreatedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddBookCreatedDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddBookLayout = new javax.swing.GroupLayout(pnlAddBook);
        pnlAddBook.setLayout(pnlAddBookLayout);
        pnlAddBookLayout.setHorizontalGroup(
            pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAddBookLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAddBookLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddBookID)
                            .addComponent(txtAddBookName)))
                    .addGroup(pnlAddBookLayout.createSequentialGroup()
                        .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddBookPage)
                            .addComponent(txtAddBookRentPrice)
                            .addComponent(txtAddBookNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addGroup(pnlAddBookLayout.createSequentialGroup()
                                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbAddBookStatus)
                                    .addComponent(txtAddBookPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 208, Short.MAX_VALUE)))))
                .addGap(59, 59, 59)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlAddBookLayout.createSequentialGroup()
                        .addComponent(btnRefreshAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnConfirmAddBook))
                    .addComponent(cboAddBookPublisher, 0, 241, Short.MAX_VALUE)
                    .addComponent(cboAddBookAuthor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAddBookCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAddBookLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddBookCreatedDate))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlAddBookLayout.setVerticalGroup(
            pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddBookLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cboAddBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cboAddBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtAddBookPublishYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cboAddBookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddBookPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cboAddBookLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddBookRentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtAddBookCreatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAddBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnlAddBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(chbAddBookStatus)
                    .addComponent(btnConfirmAddBook)
                    .addComponent(btnRefreshAddBook))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm mới sách", pnlAddBook);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblBook.getSelectedRow();
        TableModel model = tblBook.getModel();
        String id = model.getValueAt(selectedRow, 0).toString();
        String tenSach = model.getValueAt(selectedRow, 1).toString();
        String tacGia = model.getValueAt(selectedRow, 2).toString();
        String nxb = model.getValueAt(selectedRow, 3).toString();
        String theLoai = model.getValueAt(selectedRow, 4).toString();
        String viTri = model.getValueAt(selectedRow, 5).toString();
        Boolean trangThai = (Boolean) model.getValueAt(selectedRow, 6);
        
        su.txtUpdateBookID.setText(id);
        su.txtUpdateBookName.setText(tenSach);
        su.chbUpdateBookStatus.setSelected(trangThai);
        for (int i = 0; i < su.cboUpdateBookAuthor.getItemCount(); i++) {
            if (su.cboUpdateBookAuthor.getItemAt(i).toString().equalsIgnoreCase(tacGia)) {
                su.cboUpdateBookAuthor.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < su.cboUpdateBookCategory.getItemCount(); i++) {
            if (su.cboUpdateBookCategory.getItemAt(i).toString().equalsIgnoreCase(theLoai)) {
                su.cboUpdateBookCategory.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < su.cboUpdateBookPublisher.getItemCount(); i++) {
            if (su.cboUpdateBookPublisher.getItemAt(i).toString().equalsIgnoreCase(nxb)) {
                su.cboUpdateBookPublisher.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < su.cboUpdateBookLocation.getItemCount(); i++) {
            if (su.cboUpdateBookLocation.getItemAt(i).toString().equalsIgnoreCase(viTri)) {
                su.cboUpdateBookLocation.setSelectedIndex(i);
            }
        }
        
        
        Sach sa = sachDAOImp.find(id);
        su.txtUpdateBookPublishYear.setText(String.valueOf(sa.getNamXuatBan()));
        su.txtUpdateBookPage.setText(String.valueOf(sa.getSoTrang()));
        su.txtUpdateBookNumber.setText(String.valueOf(sa.getSoLuong()));
        su.txtUpdateBookRentPrice.setText(String.valueOf(sa.getGiaMuon()));
    }//GEN-LAST:event_tblBookMouseClicked

    private void btnUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookActionPerformed
        // TODO add your handling code here:
        su.setVisible(true);
    }//GEN-LAST:event_btnUpdateBookActionPerformed

    private void btnBookRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookRefreshActionPerformed
        // TODO add your handling code here:
        displayBook();
        JOptionPane.showMessageDialog(rootPane, "Cập nhật danh sách thành công", "Thông báo", 1);
    }//GEN-LAST:event_btnBookRefreshActionPerformed

    private void txtAddBookPublishYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddBookPublishYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddBookPublishYearActionPerformed

    private void btnConfirmAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmAddBookActionPerformed

        Sach sa = new Sach();
        sa.setId(txtAddBookID.getText());
        sa.setTenSach(txtAddBookName.getText());
        sa.setNamXuatBan(Integer.parseInt(txtAddBookPublishYear.getText()));
        sa.setSoTrang(Integer.parseInt(txtAddBookPage.getText()));
        sa.setGiaMuon(Float.parseFloat(txtAddBookRentPrice.getText()));
        sa.setSoLuong(Integer.parseInt(txtAddBookNumber.getText()));
        sa.setTrangThai(chbAddBookStatus.isSelected());
        sa.setIdTheLoai(((TheLoai)cboAddBookCategory.getSelectedItem()).getId());
        sa.setIdTacGia(((TacGia)cboAddBookAuthor.getSelectedItem()).getId());
        sa.setIdNXB(((NhaXuatBan)cboAddBookPublisher.getSelectedItem()).getId());
        sa.setIdViTri(((ViTri)cboAddBookLocation.getSelectedItem()).getId());
        sa.setNgayTao(java.sql.Date.valueOf(txtAddBookCreatedDate.getText()));
        sachDAOImp.add(sa);
        JOptionPane.showMessageDialog(rootPane, "Thêm mới thông tin sách thành công", "Thông báo", 1);
        displayBook();
    }//GEN-LAST:event_btnConfirmAddBookActionPerformed

    private void txtAddBookCreatedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddBookCreatedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddBookCreatedDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookRefresh;
    private javax.swing.JButton btnBookSearch;
    private javax.swing.JButton btnConfirmAddBook;
    private javax.swing.JButton btnRefreshAddBook;
    private javax.swing.JButton btnUpdateBook;
    public javax.swing.JComboBox cboAddBookAuthor;
    public javax.swing.JComboBox cboAddBookCategory;
    public javax.swing.JComboBox cboAddBookLocation;
    public javax.swing.JComboBox cboAddBookPublisher;
    public javax.swing.JCheckBox chbAddBookStatus;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlAddBook;
    private javax.swing.JTable tblBook;
    public javax.swing.JTextField txtAddBookCreatedDate;
    public javax.swing.JTextField txtAddBookID;
    public javax.swing.JTextField txtAddBookName;
    public javax.swing.JTextField txtAddBookNumber;
    public javax.swing.JTextField txtAddBookPage;
    public javax.swing.JTextField txtAddBookPublishYear;
    public javax.swing.JTextField txtAddBookRentPrice;
    private javax.swing.JTextField txtBookSearch;
    // End of variables declaration//GEN-END:variables
}
