/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import br.inatel.walmart.model.Remessa;
import java.util.List;
import java.util.ArrayList;

/**Classe de controle dos remédios em uma lista
 *
 * @author ruanp
 */
public class ControleRemessas {
    List<Remessa> ListaRemessas = new ArrayList<>();
    
    /** Método para
     * 
    */
    public boolean addRemessa(Remessa remessa){
        
        System.out.println("-------------------------");
        System.out.println(remessa.getEmpresa());
        
        ListaRemessas.add(remessa);
        
        for (int i = 0; i < ListaRemessas.size(); i++) {
            if(i==0)System.out.println("-----------------Listagem dos já cadastrados-----------------");
            System.out.println(ListaRemessas.get(i).getEmpresa());
        }
       return true; 
    }
    
    //Metodo para adicionar o dado na posição indicada
    public void addRemessaAt(Remessa remessa, int index){
        ListaRemessas.remove(index);
        ListaRemessas.add(index, remessa);
    }
    
    //Método para pegar o dado completo da lista
    public Remessa getRemessa(int index){
        return ListaRemessas.get(index);   
    }
    
    //Metodo para remover o dado da lista
    public void excluir(int index){
        ListaRemessas.remove(index);    
    }
    
    public int size(){
        return ListaRemessas.size();
    }

    public List<Remessa> getListaRemessas() {
        return ListaRemessas;
    }

    public void setListaRemessas(List<Remessa> ListaRemessas) {
        this.ListaRemessas = ListaRemessas;
    }
    
}
