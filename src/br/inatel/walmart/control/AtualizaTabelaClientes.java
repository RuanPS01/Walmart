/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;
import br.inatel.walmart.control.ControleClientes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


/**
 *
 * @author ruanp
 */
public class AtualizaTabelaClientes implements Runnable{

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    private JTable tabela;
    private ControleClientes clientes = new ControleClientes();
    
    @Override
    public void run() {
        while(true){
           try {
            atualizaTabela(clientes);
            System.out.println("Tabela atualizada!");
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizaTabelaClientes.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
    }
    
    public void atualizaTabela(ControleClientes listaClientes) throws InterruptedException{
        if (listaClientes.size() != 0) {
            for (int i = 0; i < listaClientes.size(); i++) {
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getCpfCliente(), i, 0);
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getNomeCliente(), i, 1);
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getNascimentoCliente(), i, 2);
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getEmailCiente(), i, 3);
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getEnderecoCliente(), i, 4);
                tabela.setValueAt(listaClientes.ListaClientes.get(i).getTelefoneCliente(), i, 5);
            }
        }        
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public ControleClientes getCliente() {
        return clientes;
    }

    public void setCliente(ControleClientes cliente) {
        this.clientes = cliente;
    }
    
    */
}
