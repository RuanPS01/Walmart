/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;
import br.inatel.walmart.control.ControleRemessas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
//import br.inatel.medlar.view.MenuDeRemedios;

/**
 *
 * @author ruanp
 */
public class AtualizaTabelaRemessas implements Runnable{
    
    private JTable tabela;
    private ControleRemessas remessas = new ControleRemessas();
    
    @Override
    public void run() {
        while(true){
           try {
            atualizaTabela(remessas);
            System.out.println("Tabela atualizada!");
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizaTabelaRemessas.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
    }
    
    public void atualizaTabela(ControleRemessas listaRemessas) throws InterruptedException{
        if (listaRemessas.size() != 0) {
            for (int i = 0; i < listaRemessas.size(); i++) {
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getId(), i, 0);
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getTipo(), i, 1);
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getEmpresa(), i, 2);
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getFuncionario(), i, 3);
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getHora(), i, 4);
                tabela.setValueAt(listaRemessas.ListaRemessas.get(i).getData(), i, 5);
            }
        }        
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public ControleRemessas getRemessa() {
        return remessas;
    }

    public void setRemessa(ControleRemessas remessas) {
        this.remessas = remessas;
    }
    
    
}
