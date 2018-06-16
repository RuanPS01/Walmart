/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 1513 MXTI
 */
public class ClienteBancoDAO {
    private static ClienteBancoDAO clienteDAO;
    
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
    private String _password = "";
    // Variavel que indicara se uma operacao foi feita com sucesso ou nao
    private boolean _sucesso = false;
    //--------------------------------------------------------------------
    // CADA COLUNA DE UMA TABELA DEVE POSSUIR UMA VARIAVEL QUE A REPRESENTE NA SUA RESPECTIVA DAO
    private int cpfFuncionario;
    private String nomeFuncionario, telefoneFuncionario, nascimentoFuncionario, emailFuncionario, enderecoFuncionario;
    //---------------------------------------------------------------------
    
    private ClienteBancoDAO(){
        
    }
    
    public synchronized static ClienteBancoDAO getInstance(){
        if(clienteDAO == null){
            clienteDAO = new ClienteBancoDAO();
        }       
        return clienteDAO;
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
    
    // (1) INSERT: Insere novo Usuario
    public boolean insere(Cliente novo_cliente) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta

        String sql = "INSERT INTO cliente(cpfCliente,nomeCliente,emailCiente,telefoneCliente,enderecoCliente,nascimentoCliente) VALUES (?,?,?,?,?,?)";

        try {
            // Preparo a insercao
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o nome digitado pelo usuario
            _pst.setString(1, novo_cliente.getCpfCliente());           // CPF
            _pst.setString(2, novo_cliente.getNomeCliente());       // NOME
            _pst.setString(3, novo_cliente.getEmailCliente());       // EMAIL
            _pst.setString(4, novo_cliente.getTelefoneCliente());   // TELEFONE
            _pst.setString(5, novo_cliente.getEnderecoCliente());   // ENDERECO
            _pst.setString(6, novo_cliente.getNascimentoCliente()); // DATA DE NASCIMENTO
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :(");
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
        return _sucesso;
    }
    
    // (1) DELETE: Deleta um Usuario
    public boolean deleta(Cliente novo_cliente) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        //DELETE FROM NomeTabela WHERE atributo1 = 'valor1‘;
        String sql = "DELETE FROM cliente WHERE cpfCliente = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setString(1, novo_cliente.getCpfCliente());
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :(");
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
        return _sucesso;
    }
    
    // (1) UPDATE NomeTabela SET atributo1 = valor1, atributo2 = valor2 WHERE atributo3 = 'valor1';
    public boolean edita(Cliente novo_cliente, int id) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql = "UPDATE cliente SET cpfCliente = ?, nomeCliente = ?,emailCiente = ?,telefoneCliente = ?,enderecoCliente = ?,nascimentoCliente = ? WHERE idCliente = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setString(1, novo_cliente.getCpfCliente());
            _pst.setString(2, novo_cliente.getNomeCliente());
            _pst.setString(3, novo_cliente.getEmailCliente());
            _pst.setString(4, novo_cliente.getTelefoneCliente());
            _pst.setString(5, novo_cliente.getEnderecoCliente());
            _pst.setString(6, novo_cliente.getNascimentoCliente());
            _pst.setInt(7, id);
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( //"+ex.getMessage());
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
        return _sucesso;
    }
    
    public Cliente busca(int id) {
        // Conecto com o Banco
        conectaBanco();
        System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        Cliente c = new Cliente();
        c.setNomeCliente("");
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, id);
            // Executo a pesquisa
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                System.out.println("Nome: "+_rs.getString("nomeCliente"));
                c.setCpfCliente(_rs.getString("cpfCliente"));
                c.setEmailCliente(_rs.getString("emailCiente"));
                c.setEnderecoCliente(_rs.getString("enderecoCliente"));
                c.setNascimentoCliente(_rs.getString("nascimentoCliente"));
                c.setNomeCliente(_rs.getString("nomeCliente"));
                c.setTelefoneCliente(_rs.getString("telefoneCliente"));
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
        return c;
    }
    
}
