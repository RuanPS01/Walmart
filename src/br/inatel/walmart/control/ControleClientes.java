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

public class ControleClientes {
    
    //Variáveis de controle do banco
    private Connection _con = null;
    private ResultSet _set = null;
    private Statement _st = null;
    private PreparedStatement _ps = null;
    private String _url = "jdbc:mysql://localhost:3306/" + "walmart";
    private String _user = "root";
    private String _password = "";
    private boolean _success = false;
    
    //Variáveis do Cliente
    private int cpfCliente;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String enderecoCliente;
    private String nascimentoCliente;
    
    //Singleton instance
    private static ControleClientes client;
    private ControleClientes(){
        
    }
    
    public synchronized static ControleClientes getInstance(){
        if(client == null){
            client = new ControleClientes();
        }
        return client;
    }
    
    //Métodos 
    public void conectaBD(){
        try {
            _con = DriverManager.getConnection(_url, _user, _password);
            System.out.println("Conexão iniciada com o banco de dados.");
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao BD! :0");
            System.out.println("Mensagem de erro: "+e.getMessage());
        }
    }
    
    public void addCliente(Cliente cliente){
        //Conecta ao banco de dados
        conectaBD();
        
        //Comando do SQL
        String comando = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            _ps = _con.prepareStatement(comando);
            
            //Define os valores da string
            _ps.setString(1, cliente.getEnderecoCliente());
        } catch (Exception e) {
        }
    }
    
    
}
