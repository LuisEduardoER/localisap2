/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.PessoaFisica;
import clientes.PessoaJuridica;

/**
*
* @author Filipe Alencar   -twitter.com/filipealencar_
* @author Felipe Jose      -twitter.com/felipejosefc
* @author Emilio Farias    -twitter.com/militofarias
*
* http://code.google.com/p/localisap2/
* Universidade Federal de Campina Grande - Computacao
*
*/
public class PagarDebito {

    private double dividas;
    private Object cliente;
    public PagarDebito(Object cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo que retorna quanto um cliente esta devendo
     * @return - O valor da divida
     */
    public double getQuantoEstaDevendo() {
        if (cliente instanceof PessoaFisica) {
            PessoaFisica cliente1 = (PessoaFisica) cliente;
            dividas = cliente1.getDivida();
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
            cliente1.setEmDebito(Boolean.FALSE);
            cliente1.setDivida(0);
            dividas = cliente1.getDivida();
        }
        return dividas;
    }
    /**
     * Metodo que quita a divida do cliente.
     */
    public void saldarDividas() {
        if (cliente instanceof PessoaFisica) {
            PessoaFisica cliente1 = (PessoaFisica) cliente;
            cliente1.setEmDebito(Boolean.FALSE);
            cliente1.setDivida(0);
            cliente = cliente1;
        }
        if (cliente instanceof PessoaJuridica) {
            PessoaJuridica cliente1 = (PessoaJuridica) cliente;
            cliente1.setEmDebito(Boolean.FALSE);
            cliente1.setDivida(0);
            cliente = cliente1;
        }
    }
}
