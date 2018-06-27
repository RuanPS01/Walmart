/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import java.sql.CallableStatement;
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
public class alterTables {
    private static alterTables alterTablesDAO;
    
    // Abre conexao com o Banco
    private Connection _con = null;
    // Recebe a resposta da consulta do banco
    private ResultSet _rs = null;
    // Permite o envio de comandos ESTATICOS SQL para o banco
    private Statement _st = null;
    // Permite o envio de comandos DINAMICOS SQL para o banco
    private PreparedStatement _pst = null;   
    CallableStatement statement = null;
    // String indicando com qual schema havera conexao (livrariaacme)
    // Obs: Cada driver possui uma sintaxe diferente para a url
    private String _url = "jdbc:mysql://localhost:3306/" + "walmart";
    // Usuario do Banco
    private String _user = "root";
    // Senha do Banco
    private String _password = "root";
    // Variavel que indicara se uma operacao foi feita com sucesso ou nao
    private boolean _sucesso = false;
    //--------------------------------------------------------------------
    //---------------------------------------------------------------------
    
    public alterTables(){
        
    }
    
    public synchronized static alterTables getInstance(){
        if(alterTablesDAO == null){
            alterTablesDAO = new alterTables();
        }       
        return alterTablesDAO;
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
            System.out.println("Erro Interno // "+ex.getMessage());
        }
    }
    
    public boolean alterTablesSQL() {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql2 = "ALTER TABLE cliente DROP idCliente";
        String sql3 = "ALTER TABLE cliente AUTO_INCREMENT = 1";
        String sql4 = "ALTER TABLE cliente ADD idCliente int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
        
        String sql5 = "ALTER TABLE funcionario DROP idFuncionario";
        String sql6 = "ALTER TABLE funcionario AUTO_INCREMENT = 1";
        String sql7 = "ALTER TABLE funcionario ADD idFuncionario int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
        
        String sql8 = "ALTER TABLE produto DROP idProduto";
        String sql9 = "ALTER TABLE produto AUTO_INCREMENT = 1";
        String sq20 = "ALTER TABLE produto ADD idProduto int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
        
        String sq21 = "ALTER TABLE remessa DROP idRemessa";
        String sq22 = "ALTER TABLE remessa AUTO_INCREMENT = 1";
        String sq23 = "ALTER TABLE remessa ADD idRemessa int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql2);
            _pst = _con.prepareStatement(sql3);
            _pst = _con.prepareStatement(sql4);
            _pst = _con.prepareStatement(sql5);
            _pst = _con.prepareStatement(sql6);
            _pst = _con.prepareStatement(sql7);
            _pst = _con.prepareStatement(sql8);
            _pst = _con.prepareStatement(sql9);
            _pst = _con.prepareStatement(sq20);
            _pst = _con.prepareStatement(sq21);
            _pst = _con.prepareStatement(sq22);
            _pst = _con.prepareStatement(sq23);
            // Indico que o primeiro ? significa o ID
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
            
            //Ciente
            _pst.executeUpdate(sql2);
            _pst.executeUpdate(sql3);
            _pst.executeUpdate(sql4);
            
            //Funcionario
            _pst.executeUpdate(sql5);
            _pst.executeUpdate(sql6);
            _pst.executeUpdate(sql7);
            
            //Produto
            _pst.executeUpdate(sql8);
            _pst.executeUpdate(sql9);
            _pst.executeUpdate(sq20);
            
            //Remessa
            _pst.executeUpdate(sq21);
            _pst.executeUpdate(sq22);
            _pst.executeUpdate(sq23);
            
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :(");
            System.out.println("Erro Interno // "+ex.getMessage());
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
}
