/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author 1513 MXTI
 */
public class FuncionarioBancoDAO {
    private static FuncionarioBancoDAO funcionarioDAO;
    
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
    // CADA COLUNA DE UMA TABELA DEVE POSSUIR UMA VARIAVEL QUE A REPRESENTE NA SUA RESPECTIVA DAO
    private int cpfFuncionario;
    private String nomeFuncionario, telefoneFuncionario, nascimentoFuncionario, emailFuncionario, enderecoFuncionario;
    //---------------------------------------------------------------------
    
    private FuncionarioBancoDAO(){
        
    }
    
    public synchronized static FuncionarioBancoDAO getInstance(){
        if(funcionarioDAO == null){
            funcionarioDAO = new FuncionarioBancoDAO();
        }       
        return funcionarioDAO;
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
    public boolean insere(Funcionario novo_funcionario) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta

        String sql = "INSERT INTO funcionario(idFuncionario,cpfFuncionario,nomeFuncionario,emailFuncionario,telefoneFuncionario,enderecoFuncionario,nascimentoFuncionario, usuarioFuncionario, senhaFuncionario) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            // Preparo a insercao
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o nome digitado pelo usuario
            _pst.setInt(1, 0);
            _pst.setString(2, novo_funcionario.getCpfFuncionario());           // CPF
            _pst.setString(3, novo_funcionario.getNomeFuncionario());       // NOME
            _pst.setString(4, novo_funcionario.getEmailFuncionario());      // EMAIL
            _pst.setString(5, novo_funcionario.getTelefoneFuncionario());   // TELEFONE
            _pst.setString(6, novo_funcionario.getEnderecoFuncionario());   // ENDERECO
            _pst.setString(7, novo_funcionario.getNascimentoFuncionario()); // DATA DE NASCIMENTO
            _pst.setString(8, novo_funcionario.getUsuarioFuncionario());
            _pst.setString(9, novo_funcionario.getSenhaFuncionario());
            
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
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
        return _sucesso;
    }
    
    // (1) DELETE: Deleta um Usuario
    public boolean deleta(int id) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        //DELETE FROM NomeTabela WHERE atributo1 = 'valor1‘;
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
        String sql2 = "ALTER TABLE funcionario DROP idFuncionario";
        String sql3 = "ALTER TABLE funcionario AUTO_INCREMENT = 1";
        String sql4 = "ALTER TABLE funcionario ADD idFuncionario int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, id);
            // Executo a pesquisa
            _pst.executeUpdate();
            _pst.executeUpdate(sql2);
            _pst.executeUpdate(sql3);
            _pst.executeUpdate(sql4);
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
    
    public String checaLogin(String usuario, String senha){
        Statement _stm = null;
        String query = "SELECT * FROM funcionario WHERE usuarioFuncionario = ? AND senhaFuncionario = ?";
        try {
            conectaBanco();
            _pst = _con.prepareStatement(query);
            _pst.setString(1, usuario);
            _pst.setString(2, senha);
            _rs = _pst.executeQuery();
            System.out.println("Sent queries.");
            
            while(_rs.next()){
                if((Objects.equals(_rs.getString("usuarioFuncionario"), usuario)) && (Objects.equals(_rs.getString("senhaFuncionario"), senha))){
                    System.out.println("Found matching login information.");
                    return _rs.getString("nomeFuncionario");
                }
            }
            //Não encontrou usuário, retorna nome vazio
            return "";
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
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
        return "";
    }
    // (1) UPDATE NomeTabela SET atributo1 = valor1, atributo2 = valor2 WHERE atributo3 = 'valor1';
    public boolean edita(Funcionario novo_funcionario, int id) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql = "UPDATE funcionario SET idFuncionario = ?, cpfFuncionario = ?,nomeFuncionario = ?,emailFuncionario = ?,telefoneFuncionario = ?,enderecoFuncionario = ?,nascimentoFuncionario = ?, usuarioFuncionario = ?, senhaFuncionario = ? WHERE idFuncionario = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, 0);
            _pst.setString(2, novo_funcionario.getCpfFuncionario());
            _pst.setString(3, novo_funcionario.getNomeFuncionario());
            _pst.setString(4, novo_funcionario.getEmailFuncionario());
            _pst.setString(5, novo_funcionario.getTelefoneFuncionario());
            _pst.setString(6, novo_funcionario.getEnderecoFuncionario());
            _pst.setString(7, novo_funcionario.getNascimentoFuncionario());
            _pst.setString(8, novo_funcionario.getUsuarioFuncionario());
            _pst.setString(9, novo_funcionario.getSenhaFuncionario());
            _pst.setInt(10, id);
            // Executo a pesquisa
            _pst.executeUpdate();
            _sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: Conexão Banco! :( //" + ex.getMessage());
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
    
    public Funcionario busca(int id) {
        // Conecto com o Banco
        conectaBanco();
        System.out.println("ID: "+Integer.toString(id));
        // Faz a consulta
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        Funcionario f = new Funcionario();
        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, id);
            // Executo a pesquisa
            _rs = _pst.executeQuery();
            _sucesso = true;
            
            while(_rs.next()){
                f.setCpfFuncionario(_rs.getString("cpfFuncionario"));
                f.setEmailFuncionario(_rs.getString("emailFuncionario"));
                f.setEnderecoFuncionario(_rs.getString("enderecoFuncionario"));
                f.setNascimentoFuncionario(_rs.getString("nascimentoFuncionario"));
                f.setNomeFuncionario(_rs.getString("nomeFuncionario"));
                f.setSenhaFuncionario(_rs.getString("senhaFuncionario"));
                f.setTelefoneFuncionario(_rs.getString("telefoneFuncionario"));
                f.setUsuarioFuncionario(_rs.getString("usuarioFuncionario"));
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
        return f;
    }
}
