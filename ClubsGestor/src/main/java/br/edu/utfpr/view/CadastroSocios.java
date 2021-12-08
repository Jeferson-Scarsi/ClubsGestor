/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.view;

import br.edu.utfpr.main.Main;
import br.edu.utfpr.model.Categorias_Socios;
import br.edu.utfpr.model.Socios;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeferson.scarsi
 */
public class CadastroSocios extends javax.swing.JInternalFrame {
        private DefaultTableModel modeloTabela = new DefaultTableModel();
        private Socios socioSelecionado;
        private String logradouro;            
        private String bairro;
        private String cidade; 
        private String uf; 
        
    /**
     * Creates new form CadastroCLube
     */
    public CadastroSocios() {
        initComponents();
        
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        carregarListaCategorias();
        
        
        
    }
    
    private void novoSocio(){
        // Limpa os campos para digitar um registro novo        
        ftxCPF.setText("");
        txtNomeCompleto.setText("");
        txtNumCarteirinha.setText("");
        ftxCEP.setText("");
        txtCidade.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtEmail.setText("");
        ftxFoneComercial.setText("");
        ftxFoneComercial.setText("");       
        
        //Habilita a edição do campo
        ftxCPF.setEditable(true);
        txtNomeCompleto.setEditable(true);
        btnBuscar.setEnabled(true);
        ftxCEP.setEditable(true);
        txtCidade.setEditable(true);
        txtEndereco.setEditable(true);
        txtNumero.setEditable(true);
        txtComplemento.setEditable(true);
        txtBairro.setEditable(true);
        txtEmail.setEditable(true);
        ftxFoneComercial.setEditable(true);
        ftxFoneComercial.setEditable(true);       
        
        
        tblCategoria.clearSelection();
        socioSelecionado = null;
        
    }
    
    private void carregarListaCategorias(){
        cmbCategoria.removeAllItems();
        
        String jpql = "select c from Categorias_Socios c where c.flagativo = true";
        TypedQuery query = Main.em.createQuery(jpql, Categorias_Socios.class);
        
        List<Categorias_Socios> lista = query.getResultList();
        for (Categorias_Socios c : lista ){
            cmbCategoria.addItem(c);
        }
        
    }
    
    private boolean validarCampos(){
        
        if (ftxCPF.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo CPF é obrigatório.");
            return false;
        }
        
        if (txtNomeCompleto.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Impossível salvar: Campo Nome Completo é obrigatório.");
            return false;
        }
        
        if (ftxCEP.getText().trim().length() == 0){
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
    
    public void buscarCep (String cep) {
        String json = null;
        
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
                             
            logradouro = array[7];            
            bairro = array[15];
            cidade = array[19]; 
            uf = array[23];
            
            txtEndereco.setText(logradouro);
            txtBairro.setText(bairro);
            txtCidade.setText(cidade);
            txtUF.setText(uf);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível encontrar o seu endereço.");
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

        tbpSocios = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblDadosClube = new javax.swing.JLabel();
        lblCNPJ = new javax.swing.JLabel();
        txtNomeCompleto = new javax.swing.JTextField();
        lblRazaoSocial = new javax.swing.JLabel();
        txtNumCarteirinha = new javax.swing.JTextField();
        lblNomeFantasia = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblCNPJ1 = new javax.swing.JLabel();
        lblEnderecoContato = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblFoneComercial = new javax.swing.JLabel();
        lblFoneCelular = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        ftxCPF = new javax.swing.JFormattedTextField();
        ftxCEP = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        txtUF = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        ftxFoneCelular = new javax.swing.JFormattedTextField();
        ftxFoneComercial = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Sócios");
        setLayer(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDadosClube.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDadosClube.setText("Dados Gerais");
        jPanel1.add(lblDadosClube, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblCNPJ.setText("CPF:");
        jPanel1.add(lblCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        txtNomeCompleto.setEditable(false);
        jPanel1.add(txtNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 77, 288, 25));

        lblRazaoSocial.setText("Nome Completo:");
        jPanel1.add(lblRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 57, -1, -1));

        txtNumCarteirinha.setEditable(false);
        jPanel1.add(txtNumCarteirinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 77, 123, 25));

        lblNomeFantasia.setText("Número Carteirinha:");
        jPanel1.add(lblNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 57, -1, -1));

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, 150, 25));

        lblCNPJ1.setText("Categoria:");
        jPanel1.add(lblCNPJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        lblEnderecoContato.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEnderecoContato.setText("Endereço e Contatos");
        jPanel1.add(lblEnderecoContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, -1, -1));

        lblCEP.setText("CEP:");
        jPanel1.add(lblCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, -1, -1));

        lblCidade.setText("Cidade:");
        jPanel1.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtCidade.setEditable(false);
        jPanel1.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 170, 25));

        lblBairro.setText("Bairro:");
        jPanel1.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        txtBairro.setEditable(false);
        jPanel1.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 150, 25));

        txtEmail.setEditable(false);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 215, 25));

        lblEmail.setText("E-mail:");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        txtEndereco.setEditable(false);
        jPanel1.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 210, 25));

        lblEndereco.setText("Endereço");
        jPanel1.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        lblNumero.setText("Número:");
        jPanel1.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        txtNumero.setEditable(false);
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 50, 25));

        lblFoneComercial.setText("Fone Comercial:");
        jPanel1.add(lblFoneComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lblFoneCelular.setText("Fone Celular:");
        jPanel1.add(lblFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        txtComplemento.setEditable(false);
        jPanel1.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 123, 25));

        lblComplemento.setText("Complemento:");
        jPanel1.add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        ftxCPF.setEditable(false);
        try {
            ftxCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 150, 25));

        ftxCEP.setEditable(false);
        try {
            ftxCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 25));

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 75, 25));

        txtUF.setEditable(false);
        jPanel1.add(txtUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 130, 25));

        lblUF.setText("UF:");
        jPanel1.add(lblUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        ftxFoneCelular.setEditable(false);
        try {
            ftxFoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 140, 25));

        ftxFoneComercial.setEditable(false);
        try {
            ftxFoneComercial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxFoneComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 140, 25));

        jScrollPane1.setViewportView(jPanel1);

        tbpSocios.addTab("Cadastro", jScrollPane1);

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblCategoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbpSocios.addTab("Pesquisar", jPanel2);

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

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/lapis.png"))); // NOI18N
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens-24px/excluir.png"))); // NOI18N
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExcluir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tbpSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoSocio();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        boolean novo = false;
        
        if (validarCampos() == false){
            return;
        }
        
        if (socioSelecionado == null){
            novo = true;
            socioSelecionado = new Socios();
        }
        
        socioSelecionado.setCpf(ftxCPF.getText());
        socioSelecionado.setNome(txtNomeCompleto.getText());
        socioSelecionado.setCpf(ftxCEP.getText());
        socioSelecionado.setCidade(txtCidade.getText());
        socioSelecionado.setEndereco(txtEndereco.getText());
        socioSelecionado.setNumero(txtNumero.getText());
        socioSelecionado.setComplemento(txtComplemento.getText());
        socioSelecionado.setBairro(txtBairro.getText());
        socioSelecionado.setEmail(txtEmail.getText());
        socioSelecionado.setFonecomercial(ftxFoneComercial.getText());
        socioSelecionado.setFonecelular(ftxFoneComercial.getText());
        
        Main.em.getTransaction().begin();
        if (novo){
            Main.em.persist(socioSelecionado);
        } else {
            Main.em.merge(socioSelecionado);
        }
        Main.em.getTransaction().commit();
        
        novoSocio();
        
        carregarListaCategorias();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarCep(ftxCEP.getText().replace(".", "").replace("-", "").trim());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblCategoria.getSelectedRow() != -1){
            Long id = (Long) modeloTabela.getValueAt(tblCategoria.getSelectedRow(), 0);
            
            socioSelecionado = Main.em.find(Socios.class, id);
            ftxCPF.setText(socioSelecionado.getCpf().toString());
            txtNomeCompleto.setText(socioSelecionado.getNome());
            txtNumCarteirinha.setText(socioSelecionado.getNrocarteirinha().toString());
            txtCidade.setText(socioSelecionado.getCidade());
            txtEndereco.setText(socioSelecionado.getEndereco());
            txtNumero.setText(socioSelecionado.getNumero());
            txtComplemento.setText(socioSelecionado.getComplemento());
            txtBairro.setText(socioSelecionado.getBairro());
            txtEmail.setText(socioSelecionado.getEmail());
            ftxFoneComercial.setText(socioSelecionado.getFonecomercial());     
            
            tbpSocios.setSelectedIndex(0);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Categorias_Socios> cmbCategoria;
    private javax.swing.JFormattedTextField ftxCEP;
    private javax.swing.JFormattedTextField ftxCPF;
    private javax.swing.JFormattedTextField ftxFoneCelular;
    private javax.swing.JFormattedTextField ftxFoneComercial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCNPJ1;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDadosClube;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnderecoContato;
    private javax.swing.JLabel lblFoneCelular;
    private javax.swing.JLabel lblFoneComercial;
    private javax.swing.JLabel lblNomeFantasia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblUF;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTabbedPane tbpSocios;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtNumCarteirinha;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
