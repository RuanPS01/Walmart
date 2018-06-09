/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;
import br.inatel.walmart.control.ControleProdutos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
//import br.inatel.medlar.view.MenuDeRemedios;

/**
 *
 * @author ruanp
 */
public class AtualizaTabelaProdutos implements Runnable{
    
    private JTable tabela;
    private ControleProdutos produtos = new ControleProdutos();
    
    @Override
    public void run() {
        while(true){
           try {
            atualizaTabela(produtos);
            System.out.println("Tabela atualizada!");
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizaTabelaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
    }
    
    public void atualizaTabela(ControleProdutos listaProdutos) throws InterruptedException{
        if (listaProdutos.size() != 0) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                tabela.setValueAt(listaProdutos.getNomeProduto(i), i, 0);
                tabela.setValueAt(listaProdutos.getDataVencimento(i), i, 1);
                tabela.setValueAt(listaProdutos.getQuantidadeDisponivel(i), i, 2);               
            }
        }        
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public ControleProdutos getProduto() {
        return produtos;
    }

    public void setProduto(ControleProdutos produtos) {
        this.produtos = produtos;
    }
    
    
}
