/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.webclient1.jsf;

import br.utfpr.webclient1.client_rest.SomaClientRest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named(value = "jsfSoma")
@RequestScoped
public class SomaJsf {
    
    private int num1, num2;
    private String resultado;
    
    public SomaJsf() {}

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public void soma() {
        SomaClientRest clienteRest = new SomaClientRest();
        
        try {
            this.setResultado(clienteRest.getSoma(getNum1(), getNum2()));
        } catch (IOException ex) {
            Logger.getLogger(SomaJsf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
