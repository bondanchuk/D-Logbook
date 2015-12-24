/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.JFileChooser;

/**
 *
 * @author HP
 */
public class LogBook_Frame extends javax.swing.JFrame {
int waktumulai =0;
private String KodeAlat;
File f;
String path;
    /**
     * Creates new form LogBook_Frame
     */
    public LogBook_Frame() {
        initComponents();
        cetak1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
           cetak2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        getCuaca();
        Calendar cal = Calendar.getInstance();
         SimpleDateFormat contoh4 = new SimpleDateFormat("EEEE, dd MMMM yyyy");
         String Tanggal4 = contoh4.format(cal.getTime());
         jLabel1.setText(Tanggal4);
        new Thread(){
            @Override
            public void run(){
              while(waktumulai == 0){
                Calendar kalender = new GregorianCalendar();
                int tgl = kalender.get(Calendar.DATE);
                int bln = kalender.get(Calendar.MONTH);
                int thn = kalender.get(Calendar.YEAR);
                  int thn2;
                  thn2 = kalender.get(Calendar.DAY_OF_WEEK);
                
                    int jam = kalender.get(Calendar.HOUR);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AM_PM = kalender.get(Calendar.AM_PM);
                    String siang_malam ="";
             if(AM_PM == 1){
                    siang_malam="PM"; 
             }else{
                    siang_malam = "AM";   
                  }
             String time =thn2+"  "+tgl +"/"+bln+"/"+thn+"\n";
             String wkt=jam + ":" + menit + ":" + detik + " " + siang_malam;
          //   jLabel1.setText(time);
             jLabel2.setText(wkt);
              }  
            }
        }.start();
    }
    
    
    public void setKodeAlat(String KodeAlat){
        this.KodeAlat=KodeAlat;
    }
    
    public String getKodeAlat(){
        return KodeAlat;
    }
    
    
    private void getCuaca(){
        WeatherDoc doc=new WeatherDoc("1048519","c");
        WeatherDisplay dis=new WeatherDisplay();
        info.setText(dis.getTemperature());
        c.setText(dis.getTemperatureUnit());
        angin.setText(dis.getWindSpeed()+" Km/h");
        lembab.setText(dis.getHumidity()+" %");
        as.setText(dis.getCondition()); 
    }
    
    
    
    private static ImageIcon loadImageIcon(String path) {
        URL imgURL = Login.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    
    private Connection conn;
    private void koneksi() throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logbook", "root", "");

        } catch (ClassNotFoundException ex) {
           System.out.println(ex);
        } catch (SQLException e) {
           System.out.println(e);
        } catch (Exception es) {
            System.out.println(es);
        }

    }
    
    private void kosongTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        model.addColumn("Nama Alat");
        model.addColumn("Uraian Kegiatan");
        model.addColumn("Nama Petugas");

        model.addColumn("Prioritas");
        jTable1.setModel(model);
        int kol=model.getRowCount();
        for(int x=0;x<kol;x++){
            model.removeRow(0);
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

        jbcClockBeanInfo1 = new jbc.beans.JbcClockBeanInfo();
        jbcClockBeanInfo2 = new jbc.beans.JbcClockBeanInfo();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Date date=new Date();
        SpinnerDateModel datemodel=new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        spin = new javax.swing.JSpinner(datemodel);
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        tgl = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        xA = new javax.swing.JTextField();
        alat = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Urai = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tg1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        tg2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        sc = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cetak1 = new org.freixas.jcalendar.JCalendarCombo();
        cetak2 = new org.freixas.jcalendar.JCalendarCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        angin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lembab = new javax.swing.JLabel();
        as = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digital Logbook");
        setIconImage(loadImageIcon("/img/xxx.png").getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Nama Petugas");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinas Pagi", "Dinas Siang" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Tanggal");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Jam");

        JSpinner.DateEditor ded=new JSpinner.DateEditor(spin, "HH:mm");
        spin.setEditor(ded);

        jLabel11.setText("Prioritas");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rendah", "Normal", "TInggi" }));

        jLabel14.setText("Nama Alat");

        xA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xAKeyReleased(evt);
            }
        });

        alat.setEditable(true);
        alat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(xA)
                    .addComponent(alat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Uraian Kegiatan"));

        Urai.setColumns(20);
        Urai.setRows(5);
        jScrollPane1.setViewportView(Urai);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Save Entry");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Cancel");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Upload Foto"));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gray-camera-icon.png"))); // NOI18N
        jButton6.setText("Upload Image");
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("+ Digital Log Book", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setText("Tampilkan Log Book Dari :");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("s/d");

        jButton3.setText("Cari");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Jam", "Nama Alat", "Uraian Kegiatan", "Nama Petugas", "Prioritas"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel15.setText("Serach :");

        sc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(2, 2, 2)
                                .addComponent(tg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(tg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tg1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(tg2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Daftar Log Book", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wpc0652f8c_06.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("Cetak Log Book");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-download.png"))); // NOI18N
        jButton4.setText("Cetak");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addGap(83, 83, 83)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(cetak1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cetak2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)))
                .addGap(56, 56, 56)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cetak2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cetak Log Book", jPanel7);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("DS-Digital", 1, 32)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Hari Ini :");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        info.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        info.setText("jLabel5");

        angin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        angin.setText("jLabel7");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("o");

        c.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Angin :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Kelembaban :");

        lembab.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lembab.setText("jLabel8");

        as.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        as.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(angin))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lembab)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(as)
                                .addGap(50, 50, 50))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(as)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(angin)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lembab))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(null);

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sd.png"))); // NOI18N
        jMenuItem1.setText("Logout");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("About Me");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
      Login balik=new Login();
      balik.setVisible(true);
      
      LogBook_Frame awal=new LogBook_Frame();
      setVisible(false);
      dispose();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     Login balik=new Login();
      balik.setVisible(true);
      
      LogBook_Frame awal=new LogBook_Frame();
      setVisible(false);
      dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void scActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scActionPerformed
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("Tanggal");
        tabelmapel.addColumn("Jam");
        tabelmapel.addColumn("Nama Alat");
        tabelmapel.addColumn("Uraian Kegiatan");
        tabelmapel.addColumn("Nama Petugas");

        tabelmapel.addColumn("Prioritas");

        try {
            tg1.setDateFormatString("yyyy-MM-dd");
            tg2.setDateFormatString("yyyy-MM-dd");
            String d3  = ((JTextField)tg1.getDateEditor().getUiComponent()).getText();
            String d4  = ((JTextField)tg2.getDateEditor().getUiComponent()).getText();
            koneksi();
            String sql = "select digitallogbook.Tanggal, digitallogbook.Jam,pustakaalat.namaalat, digitallogbook.uraianKegiatan,digitallogbook.namaPetugas,digitallogbook.prioritas from digitallogbook join pustakaalat on digitallogbook.idalat=pustakaalat.idalat where pustakaalat.namaalat like'%"+sc.getText()+"%' or namapetugas like'%"+sc.getText()+"%'";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                tabelmapel.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),
                    res.getString(4),res.getString(5),res.getString(6)});
        }
        jTable1.setModel(tabelmapel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_scActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("Tanggal");
        tabelmapel.addColumn("Jam");
        tabelmapel.addColumn("Nama Alat");
        tabelmapel.addColumn("Uraian Kegiatan");
        tabelmapel.addColumn("Nama Petugas");

        tabelmapel.addColumn("Prioritas");
        

        try {
            tg1.setDateFormatString("yyyy-MM-dd");
            tg2.setDateFormatString("yyyy-MM-dd");
            String d3  = ((JTextField)tg1.getDateEditor().getUiComponent()).getText();
            String d4  = ((JTextField)tg2.getDateEditor().getUiComponent()).getText();
            koneksi();
            String sql = "select digitallogbook.Tanggal, digitallogbook.Jam,pustakaalat.namaalat, digitallogbook.uraianKegiatan,digitallogbook.namaPetugas,digitallogbook.prioritas from digitallogbook join pustakaalat on digitallogbook.idalat=pustakaalat.idalat where tanggal between '"+d3+"' and '"+d4+"'";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                tabelmapel.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),
                    res.getString(4),res.getString(5),res.getString(6)});
        }
        jTable1.setModel(tabelmapel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            cetak1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            cetak2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            String NamaFile = "src/iReport/Laporan.jasper"; //Lokasi File jasper
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/LogBook","root","");
            @SuppressWarnings("rawtypes")
            HashMap hash = new HashMap(2);
            //Mengambil parameter dari ireport
            hash.put("cetak1",cetak1.getSelectedItem());
            hash.put("cetak2",cetak2.getSelectedItem());

            File file = new File(NamaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash,koneksi);
            JasperViewer.viewReport(jasperPrint,false);
        }
        catch(NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | JRException ex)
        {
            
           JOptionPane.showMessageDialog(null, "Gagal Print : "+ex.getMessage());
            System.out.println(ex.getMessage());

        }
        
        
        
        try{
            cetak1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            cetak2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            String lampiran = "src/iReport/LampiranGambar.jasper"; //Lokasi File jasper
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/LogBook","root","");
            @SuppressWarnings("rawtypes")
            HashMap hash = new HashMap(2);
            //Mengambil parameter dari ireport
            hash.put("cetak1",cetak1.getSelectedItem());
            hash.put("cetak2",cetak2.getSelectedItem());

            File file = new File(lampiran);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash,koneksi);
            JasperViewer.viewReport(jasperPrint,false);
        }
        catch(NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | JRException ex)
        {
            
           JOptionPane.showMessageDialog(null, "Gagal Print : "+ex.getMessage());
            System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      
        
        Preview prev=new Preview();
 prev.jLabel1.setIcon(new ImageIcon(path));
 prev.setVisible(true);
        try{
             FileInputStream fis=new FileInputStream(f);
             int len=(int)f.length();
                         
            tgl.setDateFormatString("yyyy-MM-dd");
            SimpleDateFormat fm2=new SimpleDateFormat("HH:mm");
            String jam=String.valueOf(fm2.format(spin.getValue()));
            String d1  = ((JTextField)tgl.getDateEditor().getUiComponent()).getText();
            Connection kon=Koneksi.koneksiDB.getKoneksi();
            String query="insert into digitallogbook values(?,?,?,?,?,?,?,?)";
            PreparedStatement state=kon.prepareCall(query);
            state.setString(1, null);
            state.setString(2, d1);
            state.setString(3, jam);
            state.setString(4, this.getKodeAlat());
            state.setString(5, Urai.getText());
            state.setString(6, (String) jComboBox1.getSelectedItem());
            state.setString(7, (String) jComboBox2.getSelectedItem());
            state.setBinaryStream(8, fis, len);
            state.executeUpdate();

            

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{

            Urai.setText("");
            xA.setText("");
            
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void xAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xAKeyReleased
        String ch=xA.getText();
        alat.removeAllItems();
        if(ch.equals("")){
            alat.setVisible(false);
        }else{

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/logbook", "root","");
                Statement st=connect.createStatement();
                ResultSet rs=st.executeQuery("select namaalat from pustakaalat where namaalat like'"+ch+"%'");
                while(rs.next()){
                    String name=rs.getString("namaAlat");
                    if(name.equals("")){
                        alat.addItem("");
                        alat.setVisible(false);
                    }else{
                        alat.addItem(rs.getString("namaAlat"));
                        alat.setVisible(true);
                    }
                }

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_xAKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      About j=new About();
      j.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void alatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alatActionPerformed
     if(alat.getSelectedItem()!=null){
         try{
         String query="select idalat from pustakaalat where namaalat=?";
         PreparedStatement pres=Koneksi.koneksiDB.getKoneksi().prepareStatement(query);
         pres.setString(1, alat.getSelectedItem().toString());
         ResultSet rest=pres.executeQuery();
         while(rest.next()){
             this.setKodeAlat(rest.getString(1));
         }
     }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "error gan");
             }
         
     }
    }//GEN-LAST:event_alatActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      kosongTabel();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 JFileChooser fc=new JFileChooser();
 fc.showOpenDialog(this);
 f=fc.getSelectedFile();
 
 path=f.getAbsolutePath();
 

    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            //</editor-fold>
        } catch (Exception ex) {
            Logger.getLogger(LogBook_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogBook_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Urai;
    private javax.swing.JComboBox alat;
    private javax.swing.JLabel angin;
    private javax.swing.JLabel as;
    private javax.swing.JLabel c;
    private org.freixas.jcalendar.JCalendarCombo cetak1;
    private org.freixas.jcalendar.JCalendarCombo cetak2;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private jbc.beans.JbcClockBeanInfo jbcClockBeanInfo1;
    private jbc.beans.JbcClockBeanInfo jbcClockBeanInfo2;
    private javax.swing.JLabel lembab;
    private javax.swing.JTextField sc;
    private javax.swing.JSpinner spin;
    private com.toedter.calendar.JDateChooser tg1;
    private com.toedter.calendar.JDateChooser tg2;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.JTextField xA;
    // End of variables declaration//GEN-END:variables
}
