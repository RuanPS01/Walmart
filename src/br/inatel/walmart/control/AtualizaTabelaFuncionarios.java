/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;
import br.inatel.walmart.control.ControleFuncionarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


/**
 *
 * @author ruanp
 */
public class AtualizaTabelaFuncionarios implements Runnable{
    
    private JTable tabela;
    private ControleFuncionarios funcionario = new ControleFuncionarios();
    
    @Override
    public void run() {
        while(true){
           try {
            atualizaTabela(funcionario);
            System.out.println("Tabela atualizada!");
            Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizaTabelaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
    }
    
    public void atualizaTabela(ControleFuncionarios listaFuncionarios) throws InterruptedException{
        if (listaFuncionarios.size() != 0) {
            for (int i = 0; i < listaFuncionarios.size(); i++) {
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getCpfFuncionario(), i, 0);
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getNomeFuncionario(), i, 1);
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getTelefoneFuncionario(), i, 2);
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getNascimentoFuncionario(), i, 3);
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getEmailFuncionario(), i, 4);
                tabela.setValueAt(listaFuncionarios.ListaFuncionarios.get(i).getEnderecoFuncionario(), i, 5);
            }
        }        
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public ControleFuncionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ControleFuncionarios funcionarios) {
        this.funcionario = funcionarios;
    }
    
    
}
