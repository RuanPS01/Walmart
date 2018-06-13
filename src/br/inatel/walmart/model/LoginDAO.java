/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;

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
public class LoginDAO {
    private static LoginDAO login;
    
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
    
    private LoginDAO(){
        
    }
    
    public synchronized static LoginDAO getInstance(){
        if(login == null){
            login = new LoginDAO();
        }       
        return login;
    }
    
    // IMPLEMENTANDO O CRUD de Login
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

        String sql = "INSERT INTO cliente(cpfCliente,nomeCliente,emailCiente,telefoneCliente,enderecoCliente,nascimentoCliente) VALUES (?,?,?,?,?,?,?,?)";

        try {
            // Preparo a insercao
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o nome digitado pelo usuario
            _pst.setInt(1, novo_cliente.getCpfCliente());           // CPF
            _pst.setString(2, novo_cliente.getNomeCliente());       // NOME
            _pst.setString(3, novo_cliente.getEmailCiente());       // EMAIL
            _pst.setString(4, novo_cliente.getTelefoneCliente());   // TELEFONE
            _pst.setString(5, novo_cliente.getEnderecoCliente());   // ENDERECO
            _pst.setString(6, novo_cliente.getNascimentoCliente()); // DATA DE NASCIMENTO
            _pst.setString(7, novo_cliente.getUsuarioCliente());
            _pst.setString(8, novo_cliente.getSenhaCliente());
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
            _pst.setInt(1, novo_cliente.getCpfCliente());
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
    
    public void verificaLogin(String usuario, String senha){
        String query = "select * from "
    }
}