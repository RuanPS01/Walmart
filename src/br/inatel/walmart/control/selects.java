/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Funcionario;
import br.inatel.walmart.model.Cliente;
import br.inatel.walmart.model.Remessa;
import br.inatel.walmart.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RuanPatrickdeSouza
 */
public class selects {
    private static selects selectClass;
    
    // Abre conexao com o Banco
    private Connection _con = null;
    // Recebe a resposta da consulta do banco
    private ResultSet _rs = null;
    // Permite o envio de comandos ESTATICOS SQL para o banco
    private Statement _st = null;
    // Permite o envio de comandos DINAMICOS SQL para o banco
    private PreparedStatement _pst = null;
    // String indicando com qual schema havera conexao (livrariaacme)
    // Obs: Cada driver possui uma sintaxe diferente para a url
    private String _url = "jdbc:mysql://localhost:3306/" + "walmart";
    // Usuario do Banco
    private String _user = "root";
    // Senha do Banco
    private String _password = "root";
    // Variavel que indicara se uma operacao foi feita com sucesso ou nao
    private boolean _sucesso = false;
    ResultSet rs;
    //--------------------------------------------------------------------
    //---------------------------------------------------------------------
    
    public selects(){
        
    }
    
    public synchronized static selects getInstance(){
        if(selectClass == null){
            selectClass = new selects();
        }       
        return selectClass;
    }
    
    // IMPLEMENTANDO O CRUD de Usuario
    // (0) CONNECT: Metodo usado para abrir conexao com o banco.
    
    public void conectaBanco() {
        try {
            // Objeto que estabelece uma conexao com o Banco de Dados, usando a URL, usuario e senha.
            _con = DriverManager.getConnection(_url, _user, _password);
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :(");
        }
    }
    
    // (1) SELECT_Count: Conta quantos registros ha na tabela escolhida
    public ArrayList selectNomeFuncionarios() {
        // Conecto com o Banco
        conectaBanco();
        //System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT nomeFuncionario FROM Funcionario";
        ArrayList funcionarios = new ArrayList();
        
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                System.out.println("Nome do Funcionario: "+_rs.getString("nomeFuncionario"));
                funcionarios.add(_rs.getString("nomeFuncionario"));   
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( // "+ex.getMessage());
            _sucesso = false;
        } finally {
            // Independente se a conexao deu certo ou errado, fecha as conexoes pendentes
            try {
                if (_rs != null) {
                    _rs.close();
                }
                if (_pst != null) {
                    _pst.close();
                }
                if (_con != null) {
                    _con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: Conexão não pode ser fechada! :(");
            }
        }
        return funcionarios;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////  SELECTs DE LISTAGEM  ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Funcionario> selectFuncionarios() {
        // Conecto com o Banco
        conectaBanco();
        //System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM Funcionario";
        ArrayList<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
        
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            //_pst.setInt(1, id);
            // Executo a pesquisa
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                String idFuncionario = _rs.getString("idFuncionario");
                String nomeFuncionario = _rs.getString("nomeFuncionario");
                String emailFuncionario = _rs.getString("emailFuncionario");
                String usuarioFuncionario = _rs.getString("usuarioFuncionario");
                String senhaFuncionario = _rs.getString("senhaFuncionario");
                Funcionario funcionarioTemp = new Funcionario();
                funcionarioTemp.setIdFuncionario(Integer.parseInt(idFuncionario));
                funcionarioTemp.setNomeFuncionario(nomeFuncionario);
                funcionarioTemp.setEmailFuncionario(emailFuncionario);
                funcionarioTemp.setUsuarioFuncionario(usuarioFuncionario);
                funcionarioTemp.setSenhaFuncionario(senhaFuncionario);
                listFuncionarios.add(funcionarioTemp);                
            }          

        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( // "+ex.getMessage());
            _sucesso = false;
        } finally {
            // Independente se a conexao deu certo ou errado, fecha as conexoes pendentes
            try {
                if (_rs != null) {
                    _rs.close();
                }
                if (_pst != null) {
                    _pst.close();
                }
                if (_con != null) {
                    _con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: Conexão não pode ser fechada! :(");
            }
        }
        return listFuncionarios;
    }
    
    public ArrayList<Cliente> selectClientes() {
        // Conecto com o Banco
        conectaBanco();
        //System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM Cliente";
        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();
        
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                String idCliente = _rs.getString("idCliente");
                String nomeCliente = _rs.getString("nomeCliente");
                String cpfCliente = _rs.getString("cpfCliente");
                String emailCiente = _rs.getString("emailCiente");
                String telefoneCliente = _rs.getString("telefoneCliente");
                Cliente clienteTemp = new Cliente();               
                clienteTemp.setIdCliente(Integer.parseInt(idCliente));
                clienteTemp.setNomeCliente(nomeCliente);
                clienteTemp.setCpfCliente(cpfCliente);
                clienteTemp.setEmailCliente(emailCiente);
                clienteTemp.setTelefoneCliente(telefoneCliente);
                listClientes.add(clienteTemp);                
            }          

        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( // "+ex.getMessage());
            _sucesso = false;
        } finally {
            // Independente se a conexao deu certo ou errado, fecha as conexoes pendentes
            try {
                if (_rs != null) {
                    _rs.close();
                }
                if (_pst != null) {
                    _pst.close();
                }
                if (_con != null) {
                    _con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: Conexão não pode ser fechada! :(");
            }
        }
        return listClientes;
    }
    
    public ArrayList<Produto> selectProdutos() {
        // Conecto com o Banco
        conectaBanco();
        //System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM Produto";
        ArrayList<Produto> listProdutos = new ArrayList<Produto>();
        
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                String idProduto = _rs.getString("idProduto");
                String nomeProduto = _rs.getString("nomeProduto");
                String empresaProduto = _rs.getString("empresaProduto");
                String precoProduto = _rs.getString("precoProduto");
                String quantidadeDisponivelProduto = _rs.getString("quantidadeDisponivelProduto");
                Produto produtoTemp = new Produto();               
                produtoTemp.setIdProduto(Integer.parseInt(idProduto));
                produtoTemp.setNomeProduto(nomeProduto);
                produtoTemp.setEmpresaProduto(empresaProduto);
                produtoTemp.setPrecoProduto(Double.valueOf(precoProduto));
                produtoTemp.setQuantidadeDisponivelProduto(Integer.parseInt(quantidadeDisponivelProduto));
                listProdutos.add(produtoTemp);                
            }          

        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( // "+ex.getMessage());
            _sucesso = false;
        } finally {
            // Independente se a conexao deu certo ou errado, fecha as conexoes pendentes
            try {
                if (_rs != null) {
                    _rs.close();
                }
                if (_pst != null) {
                    _pst.close();
                }
                if (_con != null) {
                    _con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: Conexão não pode ser fechada! :(");
            }
        }
        return listProdutos;
    }
    
    public ArrayList<Remessa> selectRemessas() {
        // Conecto com o Banco
        conectaBanco();
        //System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM Remessa";
        ArrayList<Remessa> listRemessas = new ArrayList<Remessa>();
        
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                String idRemessa = _rs.getString("idRemessa");
                String empresaRemessa = _rs.getString("empresaRemessa");
                String dataRemessa = _rs.getString("dataRemessa");
                String horaRemessa = _rs.getString("horaRemessa");
                String nomefuncionarioRemessa = _rs.getString("nomefuncionarioRemessa");
                Remessa remessaTemp = new Remessa();                
                remessaTemp.setIdRemessa(Integer.parseInt(idRemessa));
                remessaTemp.setEmpresa(empresaRemessa);
                remessaTemp.setData(dataRemessa);
                remessaTemp.setHora(horaRemessa);
                remessaTemp.setNomeFuncionario(nomefuncionarioRemessa);
                listRemessas.add(remessaTemp);                
            }          

        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( // "+ex.getMessage());
            _sucesso = false;
        } finally {
            // Independente se a conexao deu certo ou errado, fecha as conexoes pendentes
            try {
                if (_rs != null) {
                    _rs.close();
                }
                if (_pst != null) {
                    _pst.close();
                }
                if (_con != null) {
                    _con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: Conexão não pode ser fechada! :(");
            }
        }
        return listRemessas;
    }
}
