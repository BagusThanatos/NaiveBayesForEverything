/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import naivebayesforeverything.DataSets;
import naivebayesforeverything.Element;
import naivebayesforeverything.Groups;
import naivebayesforeverything.Lists;
import naivebayesforeverything.MainSet;

/**
 *
 * @author adityaabu
 */
public class InsertManual extends javax.swing.JFrame {

    /**
     * Creates new form hal2
     */
    DataSets D;
    public InsertManual() {
        initComponents();
    }

    public InsertManual(DataSets D){
        initComponents();
        this.D=D;
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
        Table = new javax.swing.JTable();
        butInsColumn = new javax.swing.JButton();
        butInsRow = new javax.swing.JButton();
        textCol = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        butDone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Table);

        butInsColumn.setText("Insert New Column");
        butInsColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butInsColumnActionPerformed(evt);
            }
        });

        butInsRow.setText("Insert New Row");
        butInsRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butInsRowActionPerformed(evt);
            }
        });

        textCol.setColumns(20);

        jLabel1.setText("Nama Kolom");

        butDone.setText("Done");
        butDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textCol, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butInsColumn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butInsRow))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butDone)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butInsColumn)
                    .addComponent(butInsRow)
                    .addComponent(textCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butDone)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butInsColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butInsColumnActionPerformed
        String n=textCol.getText();
        if (!n.equals("")) {
            DefaultTableModel d = (DefaultTableModel)Table.getModel(); 
            textCol.setText("");
            d.addColumn(n);
            D.addColumn(n);
        }
    }//GEN-LAST:event_butInsColumnActionPerformed

    private void butInsRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butInsRowActionPerformed
        String[] a = new String[Table.getColumnCount()];
        for (int i=0;i<Table.getColumnCount();i++) a[i]="";
        DefaultTableModel d = (DefaultTableModel)Table.getModel();
        d.addRow(a);
    }//GEN-LAST:event_butInsRowActionPerformed

    private void butDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDoneActionPerformed

        
        ArrayList<String> lines= new ArrayList();
        String n;
        for (int i=0;i<Table.getRowCount();i++) {  
            n="";
            for (int j=0;j<Table.getColumnCount();j++) {
                n+=Table.getValueAt(i, j)+",";
            }
            
            n=n.substring(0, n.length()-1);
            lines.add(n);
        }
            int size=D.getColumnSize();
            
            ArrayList<String> l =new ArrayList<>();
            for ( int i =0; i<lines.size();i++){
                n= lines.get(i);
                while (!n.equals("")) {
                    if (n.contains(",")){
                        l.add(n.substring(0,n.indexOf(",")));
                        n=n.substring(n.indexOf(",")+1);
                    }
                    else {
                        l.add(n);
                        n="";
                    }
                }
                if (l.size()<size) {
                    JOptionPane.showMessageDialog(null, "Terjadi error: Ada data yang kurang");
                    D=null;
                }
                else {
                    if (!D.getMainSets().contains(l.get(l.size()-1))) {
                        D.addMainSet(l.get(l.size()-1));
                    }
                    Lists M = D.getMainSets();
                    MainSet m = (MainSet)M.get(M.indexOf(l.get(l.size()-1)));
                   
                    for (int j=0;j<l.size()-1;j++){
                        Groups g=m.getGroupAt(j);
                        if (!g.contains(l.get(j))) g.addElement(l.get(j));
                        ((Element)g.getElements().get(g.getElements().indexOf(l.get(j)))).add(1);
                    }
                }
                l.clear();
                
            }
        dispose();
    }//GEN-LAST:event_butDoneActionPerformed

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
            java.util.logging.Logger.getLogger(InsertManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertManual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton butDone;
    private javax.swing.JButton butInsColumn;
    private javax.swing.JButton butInsRow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textCol;
    // End of variables declaration//GEN-END:variables
}
