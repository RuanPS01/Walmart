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
 * @author RuanPatrickdeSouza
 */
public class proceduresAndFunctions {
    private static proceduresAndFunctions pAf;
    
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
    //--------------------------------------------------------------------
    //---------------------------------------------------------------------
    
    public proceduresAndFunctions(){
        
    }
    
    public synchronized static proceduresAndFunctions getInstance(){
        if(pAf == null){
            pAf = new proceduresAndFunctions();
        }       
        return pAf;
    }
    
    // IMPLEMENTANDO O CRUD de Usuario
    // (0) CONNECT: Metodo usado para abrir conexao com o banco.
    
    public void conectaBanco() {
        try {
            // Objeto que estabelece uma conexao com o Banco de Dados, usando a URL, usuario e senha.
            _con = DriverManager.getConnection(_url, _user, _password);
            System.out.println("Conexão feita com sucesso! [conectaBanco()]");
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( [conectaBanco()]");
            System.out.println("Erro Interno // "+ex.getMessage());
        }
    }
    
    public boolean callAlterTablesSQL() {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        //String sql = "CALL alterTablesProcedure();";
        
        try {
            CallableStatement _cs = _con.prepareCall("{CALL alterTablesProcedure()}");
            // Preparo
            //_pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            // Executo a pesquisa
            //_pst.executeUpdate();
            _sucesso = true;
            //_pst.executeUpdate(sql);
            _cs.execute();
      
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( [callAlterTablesSQL()]");
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
                System.out.println("Erro: Conexão não pode ser fechada! :( [callAlterTablesSQL()]");
                System.out.println("Erro Interno // "+ex.getMessage());
            }
        }
        return _sucesso;
    }
    
    public boolean callInsertDataExamples() {
        // Conecto com o Banco
        conectaBanco();
        
        // Faz a consulta
        //String sql = "CALL insertDataExamples();";
        
        try {
            CallableStatement _cs = _con.prepareCall("CALL insertDataExamples()");
            // Preparo
            //_pst = _con.prepareStatement(sql);
            
            // Indico que o primeiro ? significa o ID
            // Executo a pesquisa
            //_pst.executeUpdate();
            _sucesso = true;
            //_pst.executeUpdate(sql);
            _cs.execute();
            while(_rs.next()){
                System.out.println("Retorno da Funcao: "+_rs.getString("insertDataExamples"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( [callInsertDataExamples()]");
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
                System.out.println("Erro: Conexão não pode ser fechada! :( [callInsertDataExamples()]");
                System.out.println("Erro Interno // "+ex.getMessage());
            }
        }
        return _sucesso;
    }
}
