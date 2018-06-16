/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

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
public class selectCountDAO {
    private static selectCountDAO countDAO;
    
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
    
    public selectCountDAO(){
        
    }
    
    public synchronized static selectCountDAO getInstance(){
        if(countDAO == null){
            countDAO = new selectCountDAO();
        }       
        return countDAO;
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
    public String selectQuant(String table) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql = "SELECT count(*) FROM "+table;
        String quant = "";
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Executo a pesquisa
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){               
                quant = _rs.getString("count(*)");
                System.out.println("Qunatidade de elementos na tabela "+table+": "+quant);
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
        return quant;
    }
}
