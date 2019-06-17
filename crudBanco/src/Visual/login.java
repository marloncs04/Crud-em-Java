
package Visual;

import java.sql.*;
import DAL.Conectabd;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     
    public login() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conectabd.conectabd();
    }
    
    
    public void limparCampo(){
        
        txtUsuario.setText("");
        txtSenha.setText("");
        
    }
    
    public void Logar(){
        String consultaLog = "SELECT * FROM login WHERE usuario = ? and senha = ?";
        try
        {
            pst = con.prepareStatement(consultaLog);
            
            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();
            pst.setString( 1, usuario);
            pst.setString( 2, senha);
            
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                Principal logado = new Principal();
                logado.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos, tente novamente!");
                limparCampo();
            }
            
            }
        catch(SQLException error){            
            JOptionPane.showMessageDialog(null, error);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(jLabel2, gridBagConstraints);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(txtUsuario, gridBagConstraints);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(jButton1, gridBagConstraints);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(txtSenha, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        getContentPane().add(jLabel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Realizando verificação de login   
        Logar ();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new login().setVisible(true);
            }
            catch (ClassNotFoundException ex) {
                
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
