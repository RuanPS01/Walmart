/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.control;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;




/**
 *
 * @author 1513 MXTI
 */
public class sendEmail {
    public void sendEmail(String destinatario, String nomeDestinatario, String msgDeEmail) throws EmailException{
        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        System.out.println("alterando hostname...");
        email.setDebug(true);
        email.setHostName("smtp.gmail.com");
        //Quando a porta utilizada não é a padrão (gmail = 465, outlook = 25 ou 587)
        email.setSmtpPort(465);
        //Adicione os destinatários
        email.addTo(destinatario, nomeDestinatario);
        //Configure o seu email do qual enviará
        email.setFrom("ruanps01@gmail.com", "Ruan Patrick de Souza");
        //Adicione um assunto
        email.setSubject("Relatorio Walmart");
        //Adicione a mensagem do email
        email.setMsg(msgDeEmail);
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication("ruanps01@gmail.com", "Ruanps0197");
        email.setSSL(true);
        email.setTLS(true); 
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }
    
    
}
