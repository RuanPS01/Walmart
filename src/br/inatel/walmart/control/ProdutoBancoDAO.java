/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author 1513 MXTI
 */
public class ProdutoBancoDAO {
    
    private static ProdutoBancoDAO produtoDAO;
    
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
    private int idProduto;
    private String nomeProduto, observacao, empresaProduto, barcodeProduto, dataVencimentoProduto;
    private LocalDate localDateVencimentoProduto;
    private int quantidadeDisponivelProduto = 0; 
    private double precoProduto;
    //---------------------------------------------------------------------
    
    private ProdutoBancoDAO(){
        
    }
    
    public synchronized static ProdutoBancoDAO getInstance(){
        if(produtoDAO == null){
            produtoDAO = new ProdutoBancoDAO();
        }       
        return produtoDAO;
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
    public boolean insere(Produto novo_produto) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta

        String sql = "INSERT INTO produto(idProduto,precoProduto,nomeProduto,observacao,empresaProduto,barcodeProduto,dataVencimentoProduto,quantidadeDisponivelProduto) VALUES (?,?,?,?,?,?,?,?)";

        try {
            // Preparo a insercao
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o nome digitado pelo usuario
            _pst.setInt(1, novo_produto.getIdProduto());                // ID
            _pst.setDouble(2, novo_produto.getPrecoProduto());          // PRECO
            _pst.setString(3, novo_produto.getNomeProduto());           // NOME
            _pst.setString(4, novo_produto.getObservacao());            // OBSERVACAO
            _pst.setString(5, novo_produto.getEmpresaProduto());        // EMPRESA
            _pst.setString(6, novo_produto.getBarcodeProduto());        // CODIGO DE BARRAS
            _pst.setString(7, novo_produto.getDataStringVencimento());  // DATA DE VENCIMENTO
            _pst.setInt(8, novo_produto.getQuantidadeDisponivelProduto()); // QUANTIDADE DISPONIVEL
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
    public boolean deleta(Produto novo_produto) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        //DELETE FROM NomeTabela WHERE atributo1 = 'valor1‘;
        String sql = "DELETE FROM produto WHERE idProduto = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, novo_produto.getIdProduto());
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
    public boolean edita(Produto novo_produto) {
        // Conecto com o Banco
        conectaBanco();
        // Faz a consulta
        String sql = "UPDATE produto SET idProduto = ?, precoProduto = ?, nomeProduto = ?,observacao = ?, empresaProduto = ?, barcodeProduto = ?,dataVencimentoProduto = ?, quantidadeDisponivelProduto = ? WHERE idProduto = ?";

        try {
            // Preparo
            _pst = _con.prepareStatement(sql);
            // Indico que o primeiro ? significa o ID
            _pst.setInt(1, novo_produto.getIdProduto());
            _pst.setDouble(2, novo_produto.getPrecoProduto());
            _pst.setString(3, novo_produto.getNomeProduto());
            _pst.setString(4, novo_produto.getObservacao());
            _pst.setString(5, novo_produto.getEmpresaProduto());
            _pst.setString(6, novo_produto.getBarcodeProduto());
            _pst.setString(7, novo_produto.getDataStringVencimento());
            _pst.setInt(8, novo_produto.getQuantidadeDisponivelProduto());
            _pst.setInt(9, novo_produto.getIdProduto());
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
}
