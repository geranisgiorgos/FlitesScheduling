/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antonis
 */
public class AvailableData extends JFrame {
    JFrame parent;
    DefaultTableModel tableModel, tableModel1;
    /**
     * Creates new form pilotData
     */
    public AvailableData(JFrame parent) {
        this.parent=parent;
        initComponents();
        parent.setEnabled(false);
        tableModel = (DefaultTableModel)pilotTable.getModel();
        tableModel1 = (DefaultTableModel)aeroskafosTable.getModel();
        pilotTable.setSelectionMode(NORMAL);
        aeroskafosTable.setSelectionMode(NORMAL);
        pilotList = pilotQuery.getResultList();
        fillTable();
    }

    // Προσθήκη δεδομένων στον πίνακα των πιλότων
    private void fillTable(){
        for(Pilot p:pilotList){
            addPilot(p);
        }
        for(Aeroskafos a:aeroskafosList){
            addAeroskafos(a);
        }
    }
    
    // Προσθήκη γραμμής στον πίνακα
    private void addPilot(Pilot p){
        Vector pilotRow = new Vector();
        pilotRow.add(p.getId());
        pilotRow.add(p.getLastname());
        pilotRow.add(p.getFirstname());
        boolean available=false;
        if(p.getAvailable()==1)
            available=true;
        pilotRow.add(available);        
        tableModel.addRow(pilotRow);
    }
    
     // Προσθήκη γραμμής στον πίνακα
    private void addAeroskafos(Aeroskafos a){
        Vector aeroRow = new Vector();
        aeroRow.add(a.getSn());
        aeroRow.add(a.getHoursA());
        aeroRow.add(a.getHoursB());

        boolean available=false;
        if(a.getAvailable()==1)
            available=true;
        aeroRow.add(available);        
        tableModel1.addRow(aeroRow);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        ProgrammaPtisewnPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Program_PtiseisPU").createEntityManager();
        pilotQuery = java.beans.Beans.isDesignTime() ? null : ProgrammaPtisewnPUEntityManager.createQuery("SELECT p FROM Pilot p");
        Program_PtiseisPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Program_PtiseisPU").createEntityManager();
        aeroskafosQuery = java.beans.Beans.isDesignTime() ? null : Program_PtiseisPUEntityManager.createQuery("SELECT a FROM Aeroskafos a");
        aeroskafosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : aeroskafosQuery.getResultList();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pilotTable = new javax.swing.JTable() ;
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        saveButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        aeroskafosTable = new javax.swing.JTable() ;

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));

        jButton5.setText("ΈΞΟΔΟΣ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        pilotTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Επώνυμο", "Όνομα", "Διαθέσιμος"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pilotTable);

        jLabel7.setText(">> Αρχείο");

        jLabel6.setText("Αρχείο >> Δεδομένα ");

        saveButton1.setText("Αποθήκευση");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel8.setText("Πιλότοι");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel9.setText("Αεροσκάφη");

        aeroskafosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "Ώρες Α", "Ώρες Β", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(aeroskafosTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(272, 272, 272))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(259, 259, 259))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jLabel7)))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
    for(int i=0;i<pilotList.size();i++){
        Pilot p = pilotList.get(i);
        boolean available=(boolean)tableModel.getValueAt(i, 3);
        if(available)
            p.setAvailable((short)1);
        else
            p.setAvailable((short)0);
        DBManager.modifyObject(p);
    }
    for(int i=0;i<aeroskafosList.size();i++){
        Aeroskafos a = aeroskafosList.get(i);
        boolean available=(boolean)tableModel1.getValueAt(i, 3);
        if(available)
            a.setAvailable((short)1);
        else
            a.setAvailable((short)0);
        DBManager.modifyObject(a);
    }
    parent.setEnabled(true);
    dispose();
    }//GEN-LAST:event_saveButton1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager Program_PtiseisPUEntityManager;
    private javax.persistence.EntityManager ProgrammaPtisewnPUEntityManager;
    private java.util.List<program_ptiseis.Aeroskafos> aeroskafosList;
    private javax.persistence.Query aeroskafosQuery;
    private javax.swing.JTable aeroskafosTable;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.persistence.Query pilotQuery;
    private javax.swing.JTable pilotTable;
    private javax.swing.JButton saveButton1;
    // End of variables declaration//GEN-END:variables
    List<Pilot> pilotList=new ArrayList();
}
