/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Cliente;
import br.inatel.walmart.model.Produto;
import java.util.List;
import java.util.ArrayList;

/**Classe de controle dos remédios em uma lista
 *
 * @author ruanp
 */
public class ControleClientes {
    List<Cliente> ListaClientes = new ArrayList<>();
    
    /** Método para
     * 
    */
    public boolean addCliente(Cliente cliente){
        
        System.out.println("-------------------------");
        System.out.println(cliente.getNomeCliente());
        
        ListaClientes.add(cliente);
        
        for (int i = 0; i < ListaClientes.size(); i++) {
            if(i==0)System.out.println("-----------------Listagem dos já cadastrados-----------------");
            System.out.println(ListaClientes.get(i).getNomeCliente());
        }
       return true; 
    }
    
    //Metodo para adicionar o dado na posição indicada
    public void addClienteAt(Cliente cliente, int index){
        ListaClientes.remove(index);
        ListaClientes.add(index, cliente);
    }
    
    //Método para pegar o dado completo da lista
    public Cliente getCliente(int index){
        return ListaClientes.get(index);   
    }
    
    //Metodo para remover o dado da lista
    public void excluir(int index){
        ListaClientes.remove(index);    
    }
    
    public int size(){
        return ListaClientes.size();
    }

    public List<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(List<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }
    
}
