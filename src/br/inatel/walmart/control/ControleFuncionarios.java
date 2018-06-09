/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Funcionario;
import br.inatel.walmart.model.Produto;
import java.util.List;
import java.util.ArrayList;

/**Classe de controle dos remédios em uma lista
 *
 * @author ruanp
 */
public class ControleFuncionarios {
    List<Funcionario> ListaFuncionarios = new ArrayList<>();
    
    /** Método para
     * 
    */
    public boolean addProduto(Funcionario funcionario){
        
        System.out.println("-------------------------");
        System.out.println(funcionario.getNomeFuncionario());
        
        ListaFuncionarios.add(funcionario);
        
        for (int i = 0; i < ListaFuncionarios.size(); i++) {
            if(i==0)System.out.println("-----------------Listagem dos já cadastrados-----------------");
            System.out.println(ListaFuncionarios.get(i).getNomeFuncionario());
        }
       return true; 
    }
    
    //Metodo para adicionar o dado na posição indicada
    public void addProdutoAt(Funcionario funcionario, int index){
        ListaFuncionarios.remove(index);
        ListaFuncionarios.add(index, funcionario);
    }
    
    //Método para pegar o dado completo da lista
    public Funcionario getFuncionario(int index){
        return ListaFuncionarios.get(index);   
    }
    
    //Metodo para remover o dado da lista
    public void excluir(int index){
        ListaFuncionarios.remove(index);    
    }
    
    public int size(){
        return ListaFuncionarios.size();
    }

    public List<Funcionario> getListaFuncionarios() {
        return ListaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> ListaFuncionarios) {
        this.ListaFuncionarios = ListaFuncionarios;
    }
    
}
