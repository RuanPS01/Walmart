/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Remessa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author 1513 MXTI
 */
public class RemessaBancoDAO {
    private static RemessaBancoDAO remessaDAO;
    
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
    private int idRemessa;
    private String tipoRemessa, empresaRemessa, funcionarioRemessa, horaRemessa, dataRemessa;
    //---------------------------------------------------------------------
    
    private RemessaBancoDAO(){
        
    }
    
    public synchronized static RemessaBancoDAO getInstance(){
        if(remessaDAO == null){
            remessaDAO = new RemessaBancoDAO();
        }       
        return remessaDAO;
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
    public boolean insere(Remessa nova_remessa) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta

        String sql = "INSERT INTO Remessa (tipoRemessa, dataRemessa,horaRemessa,empresaRemessa,funcionarioRemessa) VALUES (?,?,?,?,?)";

        try {
            // Preparo a insercao
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o nome digitado pelo usuario
            _pst.setString(1, nova_remessa.getTipo());               // TIPO
            _pst.setString(2, nova_remessa.getData());               // DATA
            _pst.setString(3, nova_remessa.getHora());               // HORA
            _pst.setString(4, nova_remessa.getEmpresa());            // EMPRESA
            _pst.setString(5, nova_remessa.getFuncionario());        // FUNCIONARIO
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :(");
            System.out.println("Mensagem do erro: "+ex.getMessage());
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
    public boolean deleta(Remessa nova_remessa) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        //DELETE FROM NomeTabela WHERE atributo1 = 'valor1‘;
        String sql = "DELETE FROM Remessa WHERE idRemessa = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, nova_remessa.getId());
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
    public boolean edita(Remessa novo_remessa) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql = "UPDATE Remessa SET dataRemessa = ?, horaRemessa = ?, empresaRemessa = ?, funcionarioRemessa = ? WHERE idRemessa = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setString(1, novo_remessa.getData());
            _pst.setString(2, novo_remessa.getHora());
            _pst.setString(3, novo_remessa.getEmpresa());
            _pst.setString(4, novo_remessa.getFuncionario());
            _pst.setInt(5, novo_remessa.getId());

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
}

