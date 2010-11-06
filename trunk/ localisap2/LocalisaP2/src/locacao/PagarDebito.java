/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.PessoaFisica;
import clientes.PessoaJuridica;

/**
 *
 * @author Filipe
 */
public class PagarDebito {

    private double dividas;
    private Object cliente;
    public PagarDebito(Object cliente) {
        this.cliente = cliente;
    }

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
