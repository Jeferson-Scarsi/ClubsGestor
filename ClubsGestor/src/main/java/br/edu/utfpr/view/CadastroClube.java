package br.edu.utfpr.view;

import br.edu.utfpr.main.Main;
import br.edu.utfpr.model.Empresa;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastroClube extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTabela = new DefaultTableModel();
    private Empresa empresaSelecionada;
    
    
    public CadastroClube() {
        initComponents();
        
        modeloTabela = (DefaultTableModel) tblEmpresas.getModel();
        
        carregarListaEmpresas();
    }
    
    private void carregarListaEmpresas(){
        //Remover linhas existentes
        while(tblEmpresas.getRowCount() > 0){
            modeloTabela.removeRow(0);
        }
        
        String jpql = "select e from Empresa e";
        TypedQuery query = Main.em.createQuery(jpql, Empresa.class);
        
        List<Empresa> lista = query.getResultList();
        for (Empresa e : lista){
            Object row[] = {
                e.getIdempresa(),
                e.getCnpj(),
                e.getRazaosocial(),
                e.getNomefantasia(),                
                e.getCep(),
                e.getCidade(),
                e.getEndereco(),
                e.getNumero(),
                e.getComplemento(),
                e.getBairro(),
                e.getFonecomercial(),
                e.getEmail()
            };
            
            modeloTabela.addRow(row);
        }
        
    }
    
    private boolean validarCampos(){
        
        if (txtCNPJ.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo CNPJ é obrigatório.");
            return false;
        }
        
        if (txtRazaoSocial.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Razão Social é obrigatório.");
            return false;
        }
        
        if (txtNomeFantasia.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Nome Fantasia é obrigatório.");
            return false;
        }
        
        if (txtCEP.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo CEP é obrigatório.");
            return false;
        }
        
        if (txtCidade.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Cidade é obrigatório.");
            return false;
        }
        
        if (txtEndereco.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Endereço é obrigatório.");
            return false;
        }
        
        if (txtBairro.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Bairro é obrigatório.");
            return false;
        }        
        
        return true;
    }    
    
    private void limpaCampos(){
        txtCodEmpresa.setText("");
        txtCNPJ.setText("");
        txtRazaoSocial.setText("");
        txtNomeFantasia.setText("");
        txtCEP.setText("");
        txtCidade.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtEmail.setText("");
        txtFoneComercial.setText("");
        
        tblEmpresas.clearSelection();
        empresaSelecionada = null;        
    }    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpCodEmpresa = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblDadosClube = new javax.swing.JLabel();
        lblCNPJ = new javax.swing.JLabel();
        lblRazaoSocial = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        txtNomeFantasia = new javax.swing.JTextField();
        lblNomeFantasia = new javax.swing.JLabel();
        lblEnderecoContato = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblFoneComercial = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtCNPJ = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtFoneComercial = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodEmpresa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpresas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Clube");
        setLayer(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDadosClube.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDadosClube.setText("Dados do Clube");
        jPanel1.add(lblDadosClube, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, -1, -1));

        lblCNPJ.setText("CNPJ:");
        jPanel1.add(lblCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblRazaoSocial.setText("Razão Social:");
        jPanel1.add(lblRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, -1, -1));
        jPanel1.add(txtRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 300, 25));
        jPanel1.add(txtNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 128, 300, 25));

        lblNomeFantasia.setText("Nome Fantasia:");
        jPanel1.add(lblNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 108, -1, -1));

        lblEnderecoContato.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEnderecoContato.setText("Endereço e Contatos");
        jPanel1.add(lblEnderecoContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, -1, -1));

        lblCEP.setText("CEP:");
        jPanel1.add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, -1, -1));

        lblCidade.setText("Cidade:");
        jPanel1.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 248, -1, -1));
        jPanel1.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 268, 175, 25));
        jPanel1.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 268, 215, 25));

        lblEndereco.setText("Endereço");
        jPanel1.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 248, -1, -1));

        lblNumero.setText("Número:");
        jPanel1.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 248, -1, -1));
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 268, 50, 25));
        jPanel1.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 268, 204, 25));

        lblComplemento.setText("Complemento:");
        jPanel1.add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 248, -1, -1));

        lblBairro.setText("Bairro:");
        jPanel1.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));
        jPanel1.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 175, 25));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 330, 25));

        lblEmail.setText("E-mail:");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        lblFoneComercial.setText("Fone Comercial:");
        jPanel1.add(lblFoneComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, 20));

        jToolBar1.setRollover(true);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/botao-adicionar.png"))); // NOI18N
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/disquete.png"))); // NOI18N
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        jPanel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 668, 25));

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 25));

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, 100, 25));
        jPanel1.add(txtFoneComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 123, 25));

        jLabel1.setText("Cód. Empresa:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtCodEmpresa.setEditable(false);
        jPanel1.add(txtCodEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 25));

        tbpCodEmpresa.addTab("Cadastro", jPanel1);

        jToolBar2.setRollover(true);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/lapis.png"))); // NOI18N
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/excluir.png"))); // NOI18N
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEliminar);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "CNPJ", "Razão Social", "Nome Fantasia", "CEP", "Cidade", "Endereço", "Número", "Complemento", "Bairro", "E-mail", "Fone Comercial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblEmpresas);
        if (tblEmpresas.getColumnModel().getColumnCount() > 0) {
            tblEmpresas.getColumnModel().getColumn(0).setMinWidth(50);
            tblEmpresas.getColumnModel().getColumn(0).setMaxWidth(50);
            tblEmpresas.getColumnModel().getColumn(1).setMinWidth(100);
            tblEmpresas.getColumnModel().getColumn(1).setMaxWidth(100);
            tblEmpresas.getColumnModel().getColumn(2).setMinWidth(200);
            tblEmpresas.getColumnModel().getColumn(2).setMaxWidth(400);
            tblEmpresas.getColumnModel().getColumn(3).setMinWidth(200);
            tblEmpresas.getColumnModel().getColumn(3).setMaxWidth(400);
            tblEmpresas.getColumnModel().getColumn(4).setMinWidth(50);
            tblEmpresas.getColumnModel().getColumn(4).setMaxWidth(100);
            tblEmpresas.getColumnModel().getColumn(5).setMinWidth(150);
            tblEmpresas.getColumnModel().getColumn(5).setMaxWidth(300);
            tblEmpresas.getColumnModel().getColumn(6).setMinWidth(200);
            tblEmpresas.getColumnModel().getColumn(6).setMaxWidth(400);
            tblEmpresas.getColumnModel().getColumn(7).setMinWidth(50);
            tblEmpresas.getColumnModel().getColumn(7).setMaxWidth(50);
            tblEmpresas.getColumnModel().getColumn(8).setMinWidth(150);
            tblEmpresas.getColumnModel().getColumn(8).setMaxWidth(250);
            tblEmpresas.getColumnModel().getColumn(9).setMinWidth(150);
            tblEmpresas.getColumnModel().getColumn(9).setMaxWidth(200);
            tblEmpresas.getColumnModel().getColumn(10).setMinWidth(150);
            tblEmpresas.getColumnModel().getColumn(10).setMaxWidth(200);
            tblEmpresas.getColumnModel().getColumn(11).setMinWidth(50);
            tblEmpresas.getColumnModel().getColumn(11).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbpCodEmpresa.addTab("Pesquisar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpCodEmpresa)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpCodEmpresa)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblEmpresas.getSelectedRow() != -1){
            Long id = (Long) modeloTabela.getValueAt(tblEmpresas.getSelectedRow(), 0);
            
            empresaSelecionada = Main.em.find(Empresa.class, id);
            txtCodEmpresa.setText(empresaSelecionada.getIdempresa().toString());
            txtCNPJ.setText(empresaSelecionada.getCnpj());
            txtRazaoSocial.setText(empresaSelecionada.getRazaosocial());
            txtNomeFantasia.setText(empresaSelecionada.getNomefantasia());
            txtCEP.setText(empresaSelecionada.getCep());
            txtCidade.setText(empresaSelecionada.getCidade());
            txtEndereco.setText(empresaSelecionada.getEndereco());
            txtNumero.setText(empresaSelecionada.getNumero());
            txtComplemento.setText(empresaSelecionada.getComplemento());
            txtBairro.setText(empresaSelecionada.getBairro());
            txtEmail.setText(empresaSelecionada.getEmail());
            txtFoneComercial.setText(empresaSelecionada.getFonecomercial());     
            
            tbpCodEmpresa.setSelectedIndex(0);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean novo = false;
        
        if (validarCampos() == false){
            return;
        }
        
        if (empresaSelecionada == null){
            novo = true;
            empresaSelecionada = new Empresa();
        }
        
        empresaSelecionada.setCnpj(txtCNPJ.getText().trim().replace(".", "").replace("/", "").replace("-", ""));
        empresaSelecionada.setRazaosocial(txtRazaoSocial.getText());
        empresaSelecionada.setNomefantasia(txtNomeFantasia.getText());
        empresaSelecionada.setCep(txtCEP.getText().trim().replace(".", "").replace("-", ""));
        empresaSelecionada.setCidade(txtCidade.getText());
        empresaSelecionada.setEndereco(txtEndereco.getText());
        empresaSelecionada.setNumero(txtNumero.getText());
        empresaSelecionada.setComplemento(txtComplemento.getText());
        empresaSelecionada.setBairro(txtBairro.getText());
        empresaSelecionada.setEmail(txtEmail.getText());
        empresaSelecionada.setFonecomercial(txtFoneComercial.getText());
        
        Main.em.getTransaction().begin();
        if (novo){
            Main.em.persist(empresaSelecionada);
        } else {
            Main.em.merge(empresaSelecionada);
        }
        Main.em.getTransaction().commit();
        
        limpaCampos();
        
        carregarListaEmpresas();        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblEmpresas.getSelectedRow() != -1){
            Long id = (Long) modeloTabela.getValueAt(tblEmpresas.getSelectedRow(), 0);
            empresaSelecionada = Main.em.find(Empresa.class, id);
            
            int result = JOptionPane.showConfirmDialog(this, "Deseja remover a empresa " + empresaSelecionada.getNomefantasia() + "?", "Remoção", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION){
                Main.em.getTransaction().begin();
                Main.em.remove(empresaSelecionada);
                Main.em.getTransaction().commit();

                carregarListaEmpresas();
                btnNovoActionPerformed(null);
            }            
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um registro para remover.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDadosClube;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnderecoContato;
    private javax.swing.JLabel lblFoneComercial;
    private javax.swing.JLabel lblNomeFantasia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JTabbedPane tbpCodEmpresa;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodEmpresa;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFoneComercial;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazaoSocial;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
