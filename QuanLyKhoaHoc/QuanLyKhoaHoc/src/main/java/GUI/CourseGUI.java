/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.*;
import GUI.CourseInsert_Edit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CourseGUI extends javax.swing.JInternalFrame {

    private CourseBLL courseBLL = new CourseBLL();
    private DepartmentBLL departmentBLL = new DepartmentBLL();
    private OnlineCourseBLL onlineCourseBLL = new OnlineCourseBLL();
    private OnsiteCourseBLL onsiteCourseBLL = new OnsiteCourseBLL();
    private DefaultTableModel model;

    /**
     * Creates new form Course
     */
    public CourseGUI() {
        initComponents();
        loadToTable(courseBLL.getList());
    }

    public void loadToTable(ArrayList<Course> list) {
        String[] header = {"Mã khóa học", "Tên khóa học", "Tín chỉ", "Mã phòng", "Phương thức", ""};
        model = new DefaultTableModel(header, 0);
        this.jTable1.setModel(model);
        for (Course x : list) {
            if (!x.getTitle().equals("null")) {
                boolean flag = false;
                for (OnlineCourse y : onlineCourseBLL.getList()) {
                    if (x.getCourseId() == y.getCourseId()) {
                        Object[] data = {x.getCourseId(), x.getTitle(), x.getCredits(), x.getDepartmentId(), "Trực tuyến", "Click để xem chi tiết..."};
                        model.addRow(data);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                for (OnsiteCourse y : onsiteCourseBLL.getList()) {
                    if (x.getCourseId() == y.getCourseId()) {
                        Object[] data = {x.getCourseId(), x.getTitle(), x.getCredits(), x.getDepartmentId(), "Tại lớp", "Click để xem chi tiết..."};
                        model.addRow(data);
                        break;
                    }
                }
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÓA HỌC");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 15, -1, 55));

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 88, 80, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 88, 354, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khóa học", "Tên khóa học", "Tín chỉ", "Mã phòng", "Phương thức", ""
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, 749, 298));

        jButtonAdd.setText("Thêm Khóa học");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 448, -1, 31));

        jButtonUpdate.setText("Sửa khóa học");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 448, 102, 31));

        jButtonDelete.setText("Xóa khóa học");
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 448, -1, 31));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter search information!");
            loadToTable(courseBLL.getList());
        }
        else {
            if("online".equalsIgnoreCase(jTextField1.getText())) {
                loadToTable(onlineCourseBLL.searchCourse());
            }
            else if("onsite".equalsIgnoreCase(jTextField1.getText())) {
                loadToTable(onsiteCourseBLL.searchCourse());
            }
            else if(courseBLL.searchCourse(jTextField1.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No courses found!");
                loadToTable(courseBLL.getList());
            }
            else {
                loadToTable(courseBLL.searchCourse(jTextField1.getText()));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        CourseInsert_Edit courseInsert_Edit = new CourseInsert_Edit();
        courseInsert_Edit.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadToTable(courseBLL.getList());
            }
        });

        courseInsert_Edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        courseInsert_Edit.setInsert(true);
        courseInsert_Edit.setFlag(true);
        try {
            courseInsert_Edit.getjComboBox1().setSelectedIndex(0);
            courseInsert_Edit.getjComboBox1().setEnabled(true);
            
            courseInsert_Edit.getjTextFieldId().setText("");
            courseInsert_Edit.getjTextFieldId().setEnabled(false);

            courseInsert_Edit.getjTextFieldTen().setText("");
            courseInsert_Edit.getjTextFieldTen().setEditable(true);

            courseInsert_Edit.getjTextFieldGia().setText("");
            courseInsert_Edit.getjTextFieldGia().setEditable(true);

            courseInsert_Edit.getjTextFieldUrl().setText("");
            courseInsert_Edit.getjTextFieldUrl().setEditable(true);

            courseInsert_Edit.getjTextFieldDiaChi().setEnabled(false);

            courseInsert_Edit.getjTextFieldGio().setEnabled(false);

            courseInsert_Edit.getjTextFieldNgay().setEnabled(false);
            
            ArrayList<String> data = new ArrayList<>();

            for(Department x: departmentBLL.getListDepartment()) {
                data.add(x.getName());
            }
            courseInsert_Edit.getjComboBox2().setModel(new javax.swing.DefaultComboBoxModel<>(data.toArray(String[]::new)));
            
            courseInsert_Edit.getjButton1().setVisible(true);
            courseInsert_Edit.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CourseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int col = (int) this.jTable1.getSelectedColumn();
        int row = (int) this.jTable1.getSelectedRow();
        if (col == 5) {
            boolean flag = false;
            for (Course x : courseBLL.getList()) {
                if (x.getCourseId() == (int) this.jTable1.getValueAt(row, 0)) {
                    for (OnlineCourse y : onlineCourseBLL.getList()) {
                        if (x.getCourseId() == y.getCourseId()) {
                            CourseInsert_Edit courseInsert_Edit = new CourseInsert_Edit();
                            courseInsert_Edit.getjButton1().setVisible(false);
                            
                            courseInsert_Edit.getjComboBox1().setSelectedIndex(0);
                            courseInsert_Edit.getjComboBox1().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldId().setText(Integer.toString(x.getCourseId()));
                            courseInsert_Edit.getjTextFieldId().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldTen().setText(x.getTitle());
                            courseInsert_Edit.getjTextFieldTen().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldGia().setText(Integer.toString(x.getCredits()));
                            courseInsert_Edit.getjTextFieldGia().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldUrl().setText(y.getUrl());
                            courseInsert_Edit.getjTextFieldUrl().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldDiaChi().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldGio().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldNgay().setEnabled(false);
                            
                            for(int i=0;i< courseInsert_Edit.getjComboBox2().getItemCount();i++){
                                String item= (String) courseInsert_Edit.getjComboBox2().getItemAt(i);
                                String departmentId= Integer.toString(x.getDepartmentId());
                                if(item.equals(departmentId)){
                                    courseInsert_Edit.getjComboBox2().setSelectedIndex(i);
                                    courseInsert_Edit.getjComboBox2().setEnabled(false);
                                    break;
                                }
                            }
                            
                            courseInsert_Edit.setVisible(true);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    for (OnsiteCourse y : onsiteCourseBLL.getList()) {
                        if (x.getCourseId() == y.getCourseId()) {
                            CourseInsert_Edit courseInsert_Edit = new CourseInsert_Edit();
                            courseInsert_Edit.getjButton1().setVisible(false);
                            
                            courseInsert_Edit.getjComboBox1().setSelectedIndex(1);
                            courseInsert_Edit.getjComboBox1().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldId().setText(Integer.toString(x.getCourseId()));
                            courseInsert_Edit.getjTextFieldId().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldTen().setText(x.getTitle());
                            courseInsert_Edit.getjTextFieldTen().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldGia().setText(Integer.toString(x.getCredits()));
                            courseInsert_Edit.getjTextFieldGia().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldUrl().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldDiaChi().setText(y.getLocation());
                            courseInsert_Edit.getjTextFieldDiaChi().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldGio().setText(y.getTime().toString());
                            courseInsert_Edit.getjTextFieldGio().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldNgay().setText(y.getDays());
                            courseInsert_Edit.getjTextFieldNgay().setEditable(false);
                            
                            for(int i=0;i< courseInsert_Edit.getjComboBox2().getItemCount();i++){
                                String item= (String) courseInsert_Edit.getjComboBox2().getItemAt(i);
                                String departmentId= Integer.toString(x.getDepartmentId());
                                if(item.equals(departmentId)){
                                    courseInsert_Edit.getjComboBox2().setSelectedIndex(i);
                                    courseInsert_Edit.getjComboBox2().setEnabled(false);
                                    break;
                                }
                            }
                            
                            courseInsert_Edit.setVisible(true);
                            break;
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        int row = (int) this.jTable1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khóa học muốn xóa");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (courseBLL.deleteCourse((int) this.jTable1.getValueAt(row, 0)) == 1) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                    loadToTable(courseBLL.getList());
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                }
            }
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        CourseInsert_Edit courseInsert_Edit = new CourseInsert_Edit();
        courseInsert_Edit.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadToTable(courseBLL.getList());
            }
        });
        courseInsert_Edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        courseInsert_Edit.getjButton1().setVisible(true);
        courseInsert_Edit.setInsert(false);
        courseInsert_Edit.setFlag(true);
        if(selectedRow != -1) {
            // Lấy dữ liệu từ hàng đã chọn
            boolean flag = false;
            for (Course x : courseBLL.getList()) {
                if (x.getCourseId() == (int) this.jTable1.getValueAt(selectedRow, 0)) {
                    for (OnlineCourse y : onlineCourseBLL.getList()) {
                        if (x.getCourseId() == y.getCourseId()) {
                            
                            courseInsert_Edit.getjComboBox1().setSelectedIndex(0);
                            courseInsert_Edit.getjComboBox1().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldId().setText(Integer.toString(x.getCourseId()));
                            courseInsert_Edit.getjTextFieldId().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldTen().setText(x.getTitle());
                            courseInsert_Edit.getjTextFieldTen().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldGia().setText(Integer.toString(x.getCredits()));
                            courseInsert_Edit.getjTextFieldGia().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldUrl().setText(y.getUrl());
                            courseInsert_Edit.getjTextFieldUrl().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldDiaChi().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldGio().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldNgay().setEnabled(false);
                            
                            ArrayList<String> data = new ArrayList<>();
                            try {
                                for(Department z: departmentBLL.getListDepartment()) {
                                    data.add(z.getName());
                                }
                                courseInsert_Edit.getjComboBox2().setModel(new javax.swing.DefaultComboBoxModel<>(data.toArray(String[]::new)));

                                for(int i=0;i< courseInsert_Edit.getjComboBox2().getItemCount();i++){
                                    String item= (String) courseInsert_Edit.getjComboBox2().getItemAt(i);
                                    if(item.equals(departmentBLL.getDeparment(x.getDepartmentId()).getName())){
                                        courseInsert_Edit.getjComboBox2().setSelectedIndex(i);
                                        courseInsert_Edit.getjComboBox2().setEnabled(true);
                                        break;
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CourseGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            courseInsert_Edit.setVisible(true);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    for (OnsiteCourse y : onsiteCourseBLL.getList()) {
                        if (x.getCourseId() == y.getCourseId()) {
                            
                            courseInsert_Edit.getjComboBox1().setSelectedIndex(1);
                            courseInsert_Edit.getjComboBox1().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldId().setText(Integer.toString(x.getCourseId()));
                            courseInsert_Edit.getjTextFieldId().setEditable(false);
                            
                            courseInsert_Edit.getjTextFieldTen().setText(x.getTitle());
                            courseInsert_Edit.getjTextFieldTen().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldGia().setText(Integer.toString(x.getCredits()));
                            courseInsert_Edit.getjTextFieldGia().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldUrl().setEnabled(false);
                            
                            courseInsert_Edit.getjTextFieldDiaChi().setText(y.getLocation());
                            courseInsert_Edit.getjTextFieldDiaChi().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldGio().setText(y.getTime().toString());
                            courseInsert_Edit.getjTextFieldGio().setEditable(true);
                            
                            courseInsert_Edit.getjTextFieldNgay().setText(y.getDays());
                            courseInsert_Edit.getjTextFieldNgay().setEditable(true);
                            
                            ArrayList<String> data = new ArrayList<>();
                                                        try {
                                for(Department z: departmentBLL.getListDepartment()) {
                                    data.add(z.getName());
                                }
                                courseInsert_Edit.getjComboBox2().setModel(new javax.swing.DefaultComboBoxModel<>(data.toArray(String[]::new)));

                                for(int i=0;i< courseInsert_Edit.getjComboBox2().getItemCount();i++){
                                    String item= (String) courseInsert_Edit.getjComboBox2().getItemAt(i);
                                    if(item.equals(departmentBLL.getDeparment(x.getDepartmentId()).getName())){
                                        courseInsert_Edit.getjComboBox2().setSelectedIndex(i);
                                        courseInsert_Edit.getjComboBox2().setEnabled(true);
                                        break;
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CourseGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            courseInsert_Edit.setVisible(true);
                            break;
                        }
                    }
                }
            }

            // Mở một hộp thoại chỉnh sửa hoặc một form chỉnh sửa với dữ liệu đã chọn
            // Ví dụ: new EditDialog(data).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một bản ghi để chỉnh sửa.");
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
