/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Produto;
import java.util.List;
import java.util.ArrayList;

/**Classe de controle dos remédios em uma lista
 *
 * @author ruanp
 */
public class ControleProdutos {
    List<Produto> ListaProdutos = new ArrayList<>();
    
    /** Método para
     * 
    */
    public boolean addProduto(Produto remedio){
        
        System.out.println("-------------------------");
        System.out.println(remedio.getNomeProduto());
        
        ListaProdutos.add(remedio);
        
        for (int i = 0; i < ListaProdutos.size(); i++) {
            if(i==0)System.out.println("-----------------Listagem dos já cadastrados-----------------");
            System.out.println(ListaProdutos.get(i).getNomeProduto());
        }
       return true; 
    }
    
    //Metodo para adicionar o dado na posição indicada
    public void addProdutoAt(Produto remedio, int index){
        ListaProdutos.remove(index);
        ListaProdutos.add(index, remedio);
    }
    
    //Método para pegar o dado completo da lista
    public Produto getProduto(int index){
        return ListaProdutos.get(index);   
    }
    
    //Metodo para remover o dado da lista
    public void excluir(int index){
        ListaProdutos.remove(index);    
    }
    
    public int size(){
        return ListaProdutos.size();
    }
    public String getNomeProduto(int i){
        return ListaProdutos.get(i).getNomeProduto();
    }
    public String getDataVencimento(int i){
        return String.valueOf(ListaProdutos.get(i).getDataVencimento());
    }
    public String getQuantidadeDisponivel(int i){
        return String.valueOf(ListaProdutos.get(i).getQuantidadeDisponivel());
    }
}
