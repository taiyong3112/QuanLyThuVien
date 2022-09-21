/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieumuon;

import com.bkap.dao.DocGiaDAOImp;
import com.bkap.dao.PhieuMuonDAOImp;
import com.bkap.dao.PhieuMuonSachDAOImp;
import com.bkap.dao.SachDAOImp;
import com.bkap.entities.DocGia;
import com.bkap.entities.PhieuMuon;
import com.bkap.entities.PhieuMuonSach;
import com.bkap.entities.Sach;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import quanlythuvien.MainFrame;

/**
 *
 * @author TaiyoNg
 */
public class PhieuMuonIF extends javax.swing.JInternalFrame implements RentCardDetail.CallbackRentStatus{
    DocGiaDAOImp docGiaDAOImp;
    SachDAOImp sachDAOImp;
    PhieuMuonDAOImp phieuMuonDAOImp;
    PhieuMuonSachDAOImp phieuMuonSachDAOImp;
    RentCardDetail rc = new RentCardDetail(this);
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form PhieuMuonIF
     */
    public PhieuMuonIF() {
        sachDAOImp = new SachDAOImp();
        docGiaDAOImp = new DocGiaDAOImp();
        phieuMuonDAOImp = new PhieuMuonDAOImp();
        phieuMuonSachDAOImp = new PhieuMuonSachDAOImp();
        initComponents();
        displayBooks();
        loadCbo();
        displayRentList();
    }
    public void displayRentList() {
        List<PhieuMuon> pmdata = phieuMuonDAOImp.toList();
        DefaultTableModel model = (DefaultTableModel) tblRentList.getModel();
        model.setRowCount(0);
        int sachDaTra = 0;
        String tinhTrang;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        for (PhieuMuon pm : pmdata) {
            List<PhieuMuonSach> listpm = phieuMuonSachDAOImp.find(pm.getId());
            for (PhieuMuonSach pms : listpm) {
                if (pms.getNgayTra() != null) {
                    sachDaTra = sachDaTra + 1;
                }
            }
            if (pm.isTrangThai() == true) {
                tinhTrang = "Đã Trả";
            }else{
                tinhTrang = "Chưa Trả";
            }
            c1.setTime(pm.getNgayMuon());
            c1.add(Calendar.DATE, 2);
            c2.setTime(pm.getHanTra());
            c2.add(Calendar.DATE, 2);
            model.addRow(new Object[]{pm.getId(), pm.getIdDocGia(), pm.getTenDocGia(), pm.getSoLuongMuon(), sachDaTra, sdf.format(c1.getTime()), sdf.format(c2.getTime()), tinhTrang});
            sachDaTra = 0;
        }
        tblRentList.setModel(model);
        
    }
    public void loadCbo(){
        List<DocGia> dgdata = docGiaDAOImp.toList();
        for (DocGia dg : dgdata) {
            cboReaderId.addItem(dg);
        }
        
    }
    public void displayBooks() {
        List<Sach> sadata = sachDAOImp.toList();
        DefaultTableModel model = (DefaultTableModel) tblBookList.getModel();
        model.setRowCount(0);
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tblBookList.setRowSorter(tr);
        tr.setRowFilter(null);
        String trangThai;
        for (Sach sa : sadata) {
            if (sa.isTrangThai() == true) {
                trangThai = "Còn Sách";
            }else{
                trangThai = "Hết Sách";
            }
            model.addRow(new Object[]{sa.getId(), sa.getTenSach(), sa.getButDanh(), trangThai});
        }
        tblBookList.setModel(model);
    }
    public void updateRentStatus(int idPhieuMuon){
        int soLuongSach = 0;
        int dem = 0;
        
        List<PhieuMuonSach> pmsdata = phieuMuonSachDAOImp.find(idPhieuMuon);
        for (PhieuMuonSach pmslist : pmsdata) {
            soLuongSach = soLuongSach + 1;
            if (pmslist.getNgayTra() != null) {
                dem++;
            }
        }
        PhieuMuon pm = phieuMuonDAOImp.find(idPhieuMuon);
        if (soLuongSach == dem) {
            pm.setTrangThai(true);
            phieuMuonDAOImp.edit(pm);
        }
    }
    public void updateBookStatus(String tenSach, boolean viPham, String chiTietViPham){
        Sach sa = sachDAOImp.findByName(tenSach);
        sa.setSoLuong(sa.getSoLuong() + 1);
        sa.setTrangThai(true);
        sachDAOImp.edit(sa);
        if(viPham){
            if (chiTietViPham != "Làm Mất") {
                sa.setSoLuong(sa.getSoLuong() + 1);
            }else{
                sa.setSoLuong(sa.getSoLuong());
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblReaderName = new javax.swing.JLabel();
        lblReaderEmail = new javax.swing.JLabel();
        lblReaderPhone = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboReaderId = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        txtBookSearch = new javax.swing.JTextField();
        btnBookSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookList = new javax.swing.JTable();
        btnBookChoose = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookChoose = new javax.swing.JTable();
        btnBookChooseDelete = new javax.swing.JButton();
        btnCreateRent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnRentDetail = new javax.swing.JButton();
        btnRentListRefresh = new javax.swing.JButton();
        btnRentDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRentList = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Quản lý Phiếu Mượn");

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Người đọc");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        lblReaderName.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        lblReaderEmail.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        lblReaderPhone.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel8.setText("ID người đọc:");

        cboReaderId.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cboReaderId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn" }));
        cboReaderId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboReaderIdItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReaderName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReaderEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReaderPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboReaderId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(15, 15, 15)
                .addComponent(cboReaderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblReaderName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(lblReaderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReaderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtBookSearch.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        btnBookSearch.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnBookSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-18.png"))); // NOI18N
        btnBookSearch.setText("Tìm");
        btnBookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookSearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sách");

        tblBookList.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tblBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Tác Giả", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBookList);

        btnBookChoose.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnBookChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-choose-18.png"))); // NOI18N
        btnBookChoose.setText("Chọn Sách");
        btnBookChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtBookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBookSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBookChoose)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBookSearch)
                    .addComponent(btnBookChoose))
                .addGap(194, 194, 194))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel6)
                    .addContainerGap(243, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sách đã chọn");

        tblBookChoose.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tblBookChoose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBookChoose);

        btnBookChooseDelete.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnBookChooseDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-18.png"))); // NOI18N
        btnBookChooseDelete.setText("Xóa Sách");
        btnBookChooseDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookChooseDeleteActionPerformed(evt);
            }
        });

        btnCreateRent.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnCreateRent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-property-18.png"))); // NOI18N
        btnCreateRent.setText("Tạo Phiếu Mượn");
        btnCreateRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreateRent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBookChooseDelete)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBookChooseDelete)
                    .addComponent(btnCreateRent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mượn Sách", jPanel1);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thống kê phiếu mượn");

        btnRentDetail.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnRentDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-more-details-18.png"))); // NOI18N
        btnRentDetail.setText("Chi Tiết");
        btnRentDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentDetailActionPerformed(evt);
            }
        });

        btnRentListRefresh.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnRentListRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-renew-18.png"))); // NOI18N
        btnRentListRefresh.setText("Làm Mới");
        btnRentListRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentListRefreshActionPerformed(evt);
            }
        });

        btnRentDelete.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnRentDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-bin-18.png"))); // NOI18N
        btnRentDelete.setText("Xóa");
        btnRentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentDeleteActionPerformed(evt);
            }
        });

        tblRentList.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tblRentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Mượn", "ID Người Đọc", "Tên Người Đọc", "Số Sách Mượn", "Số Sách Đã Trả", "Ngày Mượn", "Hạn Trả", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRentListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRentList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRentDetail)
                .addGap(18, 18, 18)
                .addComponent(btnRentListRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnRentDelete)
                .addGap(81, 81, 81))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRentDetail)
                    .addComponent(btnRentListRefresh)
                    .addComponent(btnRentDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống Kê Phiếu Mượn", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRentListMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblRentListMouseClicked

    private void btnRentDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentDetailActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRentList.getSelectedRow();
        TableModel model = tblRentList.getModel();
        int id = (int) model.getValueAt(selectedRow, 0);
        String ngayMuon = (String) model.getValueAt(selectedRow, 5);
        String hanTra = (String) model.getValueAt(selectedRow, 6);

        rc.lblRentId.setText(String.valueOf(id));
        PhieuMuon pm = phieuMuonDAOImp.find(id);
        rc.lblReaderId.setText(pm.getIdDocGia());
        rc.lblReaderBirthday.setText(pm.getNgaySinh());
        rc.lblReaderName.setText(pm.getTenDocGia());
        rc.lblReaderEmail.setText(pm.getEmail());
        rc.lblReaderPhone.setText(pm.getSdt());
        rc.lblRentDate.setText(String.valueOf(ngayMuon));
        rc.lblReturnDate.setText(String.valueOf(hanTra));

        List<PhieuMuonSach> pmsdata = phieuMuonSachDAOImp.findBook(id);
        DefaultTableModel bmodel = (DefaultTableModel) rc.tblRentedBook.getModel();
        bmodel.setRowCount(0);
        String tinhTrang;
        for (PhieuMuonSach pms : pmsdata) {
            if (pms.getNgayTra() == null) {
                tinhTrang = "Chưa Trả";
            }else{
                tinhTrang = "Đã Trả";
            }
            bmodel.addRow(new Object[]{pms.getIdSach(), pms.getTenSach(), pms.getButDanh(), pms.getTenNXB(), tinhTrang});
        }
        rc.tblRentedBook.setModel(bmodel);
        rc.setVisible(true);
    }//GEN-LAST:event_btnRentDetailActionPerformed

    private void btnCreateRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRentActionPerformed
        // TODO add your handling code here:
        if (tblBookChoose.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bảng hiện đang trống", "Lỗi", 0);
        }else{
            try {
                PhieuMuon pm = new PhieuMuon();
                LocalDate today = LocalDate.now();
                int tienMuon = 0;
                DefaultTableModel model = (DefaultTableModel) tblBookChoose.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    Sach sa = sachDAOImp.find((String) model.getValueAt(i, 0));
                    tienMuon = (int) (tienMuon + sa.getGiaMuon());
                }
                pm.setIdDocGia(((DocGia) cboReaderId.getSelectedItem()).getId());
                pm.setSoLuongMuon(tblBookChoose.getRowCount());
                pm.setNgayMuon(Date.valueOf(today));
                pm.setHanTra(Date.valueOf(today.plusDays(20)));
                pm.setTongTien(tienMuon);
                pm.setTrangThai(false);
                pm.setNgayTao(Date.valueOf(today));
                phieuMuonDAOImp.add(pm);

                PhieuMuon pmLastInsert = phieuMuonDAOImp.findLastInserted();
                PhieuMuonSach pms = new PhieuMuonSach();
                int soLuong = 0;
                for (int i = 0; i < model.getRowCount(); i++) {
                    Sach sa = sachDAOImp.find((String) model.getValueAt(i, 0));
                    pms.setIdPhieuMuon(pmLastInsert.getId());
                    pms.setIdSach(sa.getId());
                    pms.setNgayTra(null);
                    phieuMuonSachDAOImp.add(pms);
                    soLuong = sa.getSoLuong() - 1;
                    sa.setSoLuong(soLuong);
                    if (soLuong == 0) {
                        sa.setTrangThai(false);
                    }
                    sachDAOImp.edit(sa);
                }

                displayRentList();
                displayBooks();
                JOptionPane.showMessageDialog(rootPane, "Tạo phiếu mượn thành công", "Thông báo", 1);
                model.setRowCount(0);
                
            }catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Đã có lỗi xảy ra", "Lỗi", 0);
            }
        }
    }//GEN-LAST:event_btnCreateRentActionPerformed

    private void btnBookChooseDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookChooseDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblBookChoose.getModel();
        if (tblBookChoose.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Bảng đã trống", "Thông báo", 3);
        } else {
            if (tblBookChoose.getSelectedRowCount() != 0) {
                model.removeRow(tblBookChoose.getSelectedRow());
            } else {
                model.setRowCount(0);
            }
        }
    }//GEN-LAST:event_btnBookChooseDeleteActionPerformed

    private void btnBookChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookChooseActionPerformed
        // TODO add your handling code here:
        TableModel model1 = tblBookList.getModel();
        int[] indexs = tblBookList.getSelectedRows();
        Object[] rows = new Object[2];
        DefaultTableModel model2 = (DefaultTableModel) tblBookChoose.getModel();
        for (int i = 0; i < indexs.length; i++) {
            Sach sa = sachDAOImp.find(model1.getValueAt(indexs[i], 0).toString());
            if (sa.isTrangThai() == false) {
                JOptionPane.showMessageDialog(rootPane, "Không thể chọn sách đã hết", "Warning", 2);
            }else{
                rows[0] = model1.getValueAt(indexs[i], 0);
                rows[1] = model1.getValueAt(indexs[i], 1);
                model2.addRow(rows);
            }
        }
    }//GEN-LAST:event_btnBookChooseActionPerformed

    private void tblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookListMouseClicked

    private void btnBookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookSearchActionPerformed
        // TODO add your handling code here:
         if (txtBookSearch.getText().equals("")) {
            displayBooks();
                    
        }else{
            try {
                DefaultTableModel model = (DefaultTableModel)tblBookList.getModel();
                String search = txtBookSearch.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
                tblBookList.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error" + e.getMessage());
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_btnBookSearchActionPerformed

    private void btnRentListRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentListRefreshActionPerformed
        // TODO add your handling code here:
        displayRentList();
        JOptionPane.showMessageDialog(rootPane, "Danh sách mượn đã được làm mới", "Thông báo", 1);
    }//GEN-LAST:event_btnRentListRefreshActionPerformed

    private void cboReaderIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboReaderIdItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(cboReaderId.getSelectedItem().toString().equals("Chọn")){
                lblReaderName.setText("");
                lblReaderEmail.setText("");
                lblReaderPhone.setText("");
            }else{
                String id = ((DocGia)cboReaderId.getSelectedItem()).getId();
                DocGia dg = docGiaDAOImp.find(id);
                lblReaderName.setText(dg.getTenDocGia());
                lblReaderEmail.setText(dg.getEmail());
                lblReaderPhone.setText(dg.getSdt());
            }
        }
    }//GEN-LAST:event_cboReaderIdItemStateChanged

    private void btnRentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentDeleteActionPerformed
        // TODO add your handling code here:
        int dialogConfirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?", "Thông báo", 0);
        if (dialogConfirm == JOptionPane.YES_OPTION) {
            phieuMuonSachDAOImp.remove((int) tblRentList.getValueAt(tblRentList.getSelectedRow(), 0));
            phieuMuonDAOImp.remove((int) tblRentList.getValueAt(tblRentList.getSelectedRow(), 0));
            JOptionPane.showMessageDialog(rootPane, "Xóa phiếu mượn thành công", "Thông báo", 1);
            displayRentList();
        }
    }//GEN-LAST:event_btnRentDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookChoose;
    private javax.swing.JButton btnBookChooseDelete;
    private javax.swing.JButton btnBookSearch;
    private javax.swing.JButton btnCreateRent;
    private javax.swing.JButton btnRentDelete;
    private javax.swing.JButton btnRentDetail;
    private javax.swing.JButton btnRentListRefresh;
    private javax.swing.JComboBox cboReaderId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblReaderEmail;
    private javax.swing.JLabel lblReaderName;
    private javax.swing.JLabel lblReaderPhone;
    private javax.swing.JTable tblBookChoose;
    private javax.swing.JTable tblBookList;
    public javax.swing.JTable tblRentList;
    private javax.swing.JTextField txtBookSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doRentStatus(int idPhieuMuon) {
        updateRentStatus(idPhieuMuon);
        displayRentList();
    }

    @Override
    public void doBookStatus(String tenSach, boolean viPham, String chiTietViPham) {
        updateBookStatus(tenSach, viPham, chiTietViPham);
        displayBooks();
    }

    
}
