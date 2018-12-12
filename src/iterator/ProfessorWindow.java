package iterator;

import adapter.AdapterPersistencia;
import adapter.Persistencia;
import decorator.EncryptPersistencia;
import decorator.UpperPersistencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import template_method.*; 

/**
 * @author Yugo
 */
public final class ProfessorWindow extends javax.swing.JFrame {

    private final ProfessorPersistencia crud = new ProfessorPersistencia();

    /**
     * Creates new form ProfessorWindow
     */
    public ProfessorWindow() {
        initComponents();
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) this.jTable_Professores.getModel();
        int rowCount = model.getRowCount();
        //Apaga uma linha por vez
        for (int i = rowCount - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }
    }
    
    public void imprimeTable(Iterator<Professor> metodo){
        clearTable();
        for (Iterator<Professor> conteudo = metodo; conteudo.hasNext();) {
            Professor current = conteudo.next();
            DefaultTableModel model = (DefaultTableModel) this.jTable_Professores.getModel();
            model.addRow(new Object[]{
                current.getId(),
                current.getNome(),
                current.getDep(),
                current.getTitulacao(),
                current.getTipo()
            });
        }
    }
    
    private void ordena(Iterator<Professor> iter) { 
        int type = this.jComboBox_Ordenacao.getSelectedIndex(); 
        ArrayList conteudo = toArrayList(iter); 
        switch( type ) {
            case 0: //Id
                Collections.sort(conteudo, new ComparePorId()); 
                break; 
            case 1: //Nome 
                Collections.sort(conteudo, new ComparePorNome()); 
                break; 
            case 2: //Departamento | Nome
                Collections.sort(conteudo, new ComparePorDepNome()); 
                break; 
            case 3: //Titulacao | Nome 
                Collections.sort(conteudo, new ComparePorTitulacaoNome()); 
                break;
            case 4: //Departamento | Titulacao | Nome 
                Collections.sort(conteudo, new ComparePorDepTitulacaoNome()); 
                break;
            default:
                System.out.print("Ordenacao nao definida");
                break; 
        }
        imprimeTable(conteudo.iterator()); 
    }
    
    public ArrayList toArrayList( Iterator i ) { 
        ArrayList arrList;
        arrList = new ArrayList();
        while (i.hasNext()) {
            arrList.add(i.next()); 
        }
        return arrList; 
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
        jTable_Professores = new javax.swing.JTable();
        jPanel_Iterator = new javax.swing.JPanel();
        jButtonHashSet = new javax.swing.JButton();
        jButtonLista = new javax.swing.JButton();
        jButtonFila = new javax.swing.JButton();
        jButtonTreeMap = new javax.swing.JButton();
        jPanel_TemplateMethod = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_Ordenacao = new javax.swing.JComboBox<>();
        jButtonLimpar = new javax.swing.JButton();
        jPanel_Decorator = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton_toUpper = new javax.swing.JRadioButton();
        jRadioButton_Encrypt = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Padrão Iterator");

        jTable_Professores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Departamento", "Titulação", "Tipo"
            }
        ));
        jTable_Professores.setEnabled(false);
        jScrollPane1.setViewportView(jTable_Professores);
        if (jTable_Professores.getColumnModel().getColumnCount() > 0) {
            jTable_Professores.getColumnModel().getColumn(1).setMinWidth(80);
        }

        jPanel_Iterator.setBorder(javax.swing.BorderFactory.createTitledBorder("Iterator"));
        jPanel_Iterator.setName("Iterator"); // NOI18N

        jButtonHashSet.setText("HashSet");
        jButtonHashSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHashSetActionPerformed(evt);
            }
        });

        jButtonLista.setText("Lista");
        jButtonLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaActionPerformed(evt);
            }
        });

        jButtonFila.setText("Fila");
        jButtonFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilaActionPerformed(evt);
            }
        });

        jButtonTreeMap.setText("TreeMap");
        jButtonTreeMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreeMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_IteratorLayout = new javax.swing.GroupLayout(jPanel_Iterator);
        jPanel_Iterator.setLayout(jPanel_IteratorLayout);
        jPanel_IteratorLayout.setHorizontalGroup(
            jPanel_IteratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_IteratorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_IteratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_IteratorLayout.createSequentialGroup()
                        .addComponent(jButtonTreeMap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHashSet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_IteratorLayout.createSequentialGroup()
                        .addComponent(jButtonFila, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLista, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel_IteratorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonFila, jButtonHashSet, jButtonLista, jButtonTreeMap});

        jPanel_IteratorLayout.setVerticalGroup(
            jPanel_IteratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_IteratorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_IteratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLista)
                    .addComponent(jButtonFila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_IteratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTreeMap)
                    .addComponent(jButtonHashSet))
                .addContainerGap())
        );

        jPanel_TemplateMethod.setBorder(javax.swing.BorderFactory.createTitledBorder("Template Method"));

        jLabel1.setText("Ordenar por:");

        jComboBox_Ordenacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nome", "Departamento | Nome ", "Titulação | Nome ", "Departamento | Titulação | Nome ", " " }));
        jComboBox_Ordenacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_OrdenacaoActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_TemplateMethodLayout = new javax.swing.GroupLayout(jPanel_TemplateMethod);
        jPanel_TemplateMethod.setLayout(jPanel_TemplateMethodLayout);
        jPanel_TemplateMethodLayout.setHorizontalGroup(
            jPanel_TemplateMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TemplateMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_TemplateMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TemplateMethodLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox_Ordenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_TemplateMethodLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar)))
                .addContainerGap())
        );
        jPanel_TemplateMethodLayout.setVerticalGroup(
            jPanel_TemplateMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TemplateMethodLayout.createSequentialGroup()
                .addGroup(jPanel_TemplateMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_TemplateMethodLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel_TemplateMethodLayout.createSequentialGroup()
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_Ordenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Decorator.setBorder(javax.swing.BorderFactory.createTitledBorder("Decorator"));

        jRadioButton_toUpper.setText("toUpper");
        jRadioButton_toUpper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_toUpperActionPerformed(evt);
            }
        });

        jRadioButton_Encrypt.setText("encrypt");
        jRadioButton_Encrypt.setActionCommand("encrypt");
        jRadioButton_Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_EncryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_DecoratorLayout = new javax.swing.GroupLayout(jPanel_Decorator);
        jPanel_Decorator.setLayout(jPanel_DecoratorLayout);
        jPanel_DecoratorLayout.setHorizontalGroup(
            jPanel_DecoratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DecoratorLayout.createSequentialGroup()
                .addGroup(jPanel_DecoratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DecoratorLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2))
                    .addGroup(jPanel_DecoratorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton_toUpper))
                    .addGroup(jPanel_DecoratorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton_Encrypt)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel_DecoratorLayout.setVerticalGroup(
            jPanel_DecoratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DecoratorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton_Encrypt)
                .addGap(2, 2, 2)
                .addComponent(jRadioButton_toUpper)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_Decorator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_TemplateMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_Iterator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_Iterator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_TemplateMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Decorator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaActionPerformed
        try {
            imprimeTable(this.crud.carregaEstruturaComLista());
        } catch (IOException ex) {
            Logger.getLogger(ProfessorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonListaActionPerformed

    private void jButtonFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilaActionPerformed
        try {
            imprimeTable(this.crud.carregaEstruturaComFila());
        } catch (IOException ex) {
            Logger.getLogger(ProfessorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFilaActionPerformed

    private void jButtonTreeMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreeMapActionPerformed
       try {
            imprimeTable(this.crud.carregaEstruturaComTreeMap());
        } catch (IOException ex) {
            Logger.getLogger(ProfessorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTreeMapActionPerformed

    private void jButtonHashSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHashSetActionPerformed
       try {
            imprimeTable(this.crud.carregaEstruturaComHashSet());
        } catch (IOException ex) {
            Logger.getLogger(ProfessorWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonHashSetActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        clearTable();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBox_OrdenacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_OrdenacaoActionPerformed
        Persistencia drive = new ProfessorPersistencia(); 
        Iterator<Professor> iter = drive.selectAll();
        ordena(iter);
    }//GEN-LAST:event_jComboBox_OrdenacaoActionPerformed

    private void jRadioButton_toUpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_toUpperActionPerformed
        Persistencia drive = new ProfessorPersistencia(); 
        if(this.jRadioButton_toUpper.isSelected()){
            drive = new UpperPersistencia(drive);         
        } 
        Iterator<Professor> iter = drive.selectAll();
        ordena(iter);
    }//GEN-LAST:event_jRadioButton_toUpperActionPerformed

    private void jRadioButton_EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_EncryptActionPerformed
        Persistencia drive = new ProfessorPersistencia(); 
        if(this.jRadioButton_Encrypt.isSelected()){
            drive = new EncryptPersistencia(drive);         
        } 
        Iterator<Professor> iter = drive.selectAll();
        ordena(iter);
    }//GEN-LAST:event_jRadioButton_EncryptActionPerformed

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
            java.util.logging.Logger.getLogger(ProfessorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFila;
    private javax.swing.JButton jButtonHashSet;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonLista;
    private javax.swing.JButton jButtonTreeMap;
    private javax.swing.JComboBox<String> jComboBox_Ordenacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_Decorator;
    private javax.swing.JPanel jPanel_Iterator;
    private javax.swing.JPanel jPanel_TemplateMethod;
    private javax.swing.JRadioButton jRadioButton_Encrypt;
    private javax.swing.JRadioButton jRadioButton_toUpper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Professores;
    // End of variables declaration//GEN-END:variables
}
