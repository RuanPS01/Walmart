/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.view;


import br.inatel.walmart.model.Cliente;
import br.inatel.walmart.control.ClienteBancoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Polez
 */
public class addCliente extends javax.swing.JFrame {

    /**
     * Creates new form addFuncionario
     */
    Cliente clienteTemp = new Cliente();
    private boolean isEdit = false;
    private int editId = 0;
    
    public addCliente(){
        initComponents();
    }
    
    public addCliente(Cliente c, int id){
        initComponents();
        labelJanela.setText("Edição de cliente");
        NOME_textBoxCliente.setText(c.getNomeCliente());
        CPF_textBoxCliente.setText(c.getCpfCliente());
        EMAIL_textBoxCliente.setText(c.getEmailCliente());
        ENDERECO_textBoxCliente.setText(c.getEnderecoCliente());
        String[] partes = c.getNascimentoCliente().split("/");
        DIA_textBoxCliente.setText(partes[0]);
        MES_textBoxCliente.setText(partes[1]);
        ANO_textBoxCliente.setText(partes[2]);
        TELEFONE_textBoxCliente.setText(c.getTelefoneCliente());
        isEdit = true;
        editId = id;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NOME_textBoxCliente = new javax.swing.JTextField();
        ENDERECO_textBoxCliente = new javax.swing.JTextField();
        CPF_textBoxCliente = new javax.swing.JTextField();
        DIA_textBoxCliente = new javax.swing.JTextField();
        EMAIL_textBoxCliente = new javax.swing.JTextField();
        TELEFONE_textBoxCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MES_textBoxCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ANO_textBoxCliente = new javax.swing.JTextField();
        CANCEL_Produto = new javax.swing.JButton();
        CONFIRM_Produto = new javax.swing.JButton();
        labelJanela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente");
        setResizable(false);

        jLabel1.setText("Nome:");

        jLabel2.setText("Endereço:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Data de nasc.:");

        jLabel5.setText("Email:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("/");

        jLabel8.setText("/");

        CANCEL_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/inatel/walmart/view/CANCEL_70.png"))); // NOI18N
        CANCEL_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCEL_ProdutoActionPerformed(evt);
            }
        });

        CONFIRM_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/inatel/walmart/view/OK_70.png"))); // NOI18N
        CONFIRM_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIRM_ProdutoActionPerformed(evt);
            }
        });

        labelJanela.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        labelJanela.setText("Regitro de novo cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJanela)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(NOME_textBoxCliente))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(CPF_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(DIA_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MES_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ANO_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ENDERECO_textBoxCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(TELEFONE_textBoxCliente))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(EMAIL_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CANCEL_Produto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CONFIRM_Produto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NOME_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CPF_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(EMAIL_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TELEFONE_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ENDERECO_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DIA_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(MES_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(ANO_textBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CANCEL_Produto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CONFIRM_Produto)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CANCEL_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCEL_ProdutoActionPerformed
        NOME_textBoxCliente.setText("");
        ENDERECO_textBoxCliente.setText("");
        CPF_textBoxCliente.setText("");
        DIA_textBoxCliente.setText("");
        MES_textBoxCliente.setText("");
        ANO_textBoxCliente.setText("");
        EMAIL_textBoxCliente.setText("");
        TELEFONE_textBoxCliente.setText("");
    }//GEN-LAST:event_CANCEL_ProdutoActionPerformed

    private void CONFIRM_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRM_ProdutoActionPerformed
        clienteTemp.setNomeCliente(NOME_textBoxCliente.getText());
        clienteTemp.setEnderecoCliente(ENDERECO_textBoxCliente.getText());
        clienteTemp.setCpfCliente(CPF_textBoxCliente.getText());
        clienteTemp.setNascimentoCliente(DIA_textBoxCliente.getText()+"/"+MES_textBoxCliente.getText()+"/"+ANO_textBoxCliente.getText());
        clienteTemp.setEmailCliente(EMAIL_textBoxCliente.getText());
        clienteTemp.setTelefoneCliente(TELEFONE_textBoxCliente.getText());

        //Adiciona o cliente no banco de dados
        if(isEdit){
            System.out.println("Editing.");
            ClienteBancoDAO.getInstance().edita(clienteTemp, editId);
        }else{
            System.out.println("Adding.");
            ClienteBancoDAO.getInstance().insere(clienteTemp);
        }
        
        JOptionPane.showMessageDialog(null, "Registro efetuado e salvo com sucesso! ");
        this.dispose();

    }//GEN-LAST:event_CONFIRM_ProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(addCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ANO_textBoxCliente;
    private javax.swing.JButton CANCEL_Produto;
    private javax.swing.JButton CONFIRM_Produto;
    private javax.swing.JTextField CPF_textBoxCliente;
    private javax.swing.JTextField DIA_textBoxCliente;
    private javax.swing.JTextField EMAIL_textBoxCliente;
    private javax.swing.JTextField ENDERECO_textBoxCliente;
    private javax.swing.JTextField MES_textBoxCliente;
    private javax.swing.JTextField NOME_textBoxCliente;
    private javax.swing.JTextField TELEFONE_textBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelJanela;
    // End of variables declaration//GEN-END:variables
}
