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
public class PilotData extends JFrame {
    JFrame parent;
    DefaultTableModel tableModel;
    /**
     * Creates new form pilotData
     */
    public PilotData(JFrame parent) {
        this.parent=parent;
        initComponents();
        parent.setEnabled(false);
        tableModel = (DefaultTableModel)pilotTable.getModel();
        pilotTable.setSelectionMode(NORMAL);
        pilotList = pilotQuery.getResultList();
        fillTable();
    }

    // Προσθήκη δεδομένων στον πίνακα των πιλότων
    private void fillTable(){
        for(Pilot p:pilotList){
            addPilot(p);
        }
    }
    
    public void newPilot(Pilot pilot){
        addPilot(pilot);
        this.pilotList.add(pilot);
    }

    public void removePilot(int row){
        this.pilotList.remove(row);
        this.tableModel.removeRow(row);
        
    }
    
    // Προσθήκη γραμμής στον πίνακα
    private void addPilot(Pilot p){
        Vector pilotRow = new Vector();
        pilotRow.add(p.getLastname());
        pilotRow.add(p.getFirstname());
        boolean pic=false;
        if(p.getPic()==1)
            pic=true;
        pilotRow.add(pic);
        boolean em=false;
        if(p.getEm()==1)
            em=true;
        pilotRow.add(em);
        boolean ekp=false;
        if(p.getEkpaideytis()==1)
            ekp=true;
        pilotRow.add(ekp);
        boolean dok=false;
        if(p.getDokimastis()==1)
            dok=true;
        pilotRow.add(dok);
        boolean commander=false;
        if(p.getCommander()==1){
            commander=true;
        }
        pilotRow.add(commander);
        pilotRow.add(p.getTotalhours());
        pilotRow.add(p.getHoursexam());
        
        tableModel.addRow(pilotRow);
    }
    
    // Εισαγωγή τροποποιημένου πιλότου στον πίνακα πιλότων
    public void editPilot(Pilot pilot, int row){
        int noRows=tableModel.getRowCount();
        // Διαγράφουμε την γραμμή
        tableModel.removeRow(row);
        this.pilotList.remove(row);
        addPilot(pilot);
        tableModel.moveRow(noRows-1, noRows-1, row);
        pilotList.add(row, pilot);
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
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pilotTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false; }} ;
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
                "Επώνυμο", "Όνομα", "PiC", "Έμπειρος", "Εκπαιδευτής", "Δοκιμαστής", "Αρχηγός", "Συν. Ώρες", "Ώρες Εξαμήνου"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pilotTable);

        jLabel7.setText(">> Αρχείο");

        jLabel6.setText("Αρχείο >> Ιπτάμενοι ");

        jButton1.setText("Εισαγωγή");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Διαγραφή");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Επεξεργασία");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jLabel6))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(135, 135, 135)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PilotForm pf = new PilotForm(this, true, MainMenu.NEW, null, -1);
        pf.setLocation(350,50);
        pf.setTitle("Εισαγωγή Ιπταμένου");
        pf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row=this.pilotTable.getSelectedRow();
        if(row==-1)
            JOptionPane.showMessageDialog(this, "Επιλέξτε Ιπτάμενο");
        else {
            Pilot pilot = this.pilotList.get(row);
            PilotForm pf = new PilotForm(this, true, MainMenu.DELETE, pilot, row);
            pf.setLocation(350,50);
            pf.setTitle("Διαγραφή Ιπταμένου");
            pf.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row=this.pilotTable.getSelectedRow();
        if(row==-1)
            JOptionPane.showMessageDialog(this, "Επιλέξτε Ιπτάμενο");
        else {
            Pilot pilot = this.pilotList.get(row);
            PilotForm pf = new PilotForm(this, true, MainMenu.EDIT, pilot, row);
            pf.setLocation(350,50);
            pf.setTitle("Επεξεργασία Ιπταμένου");
            pf.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ProgrammaPtisewnPUEntityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.persistence.Query pilotQuery;
    private javax.swing.JTable pilotTable;
    // End of variables declaration//GEN-END:variables
    List<Pilot> pilotList=new ArrayList();
}
