/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

import clientes.Cliente;

/**
 * Classe PagarDebito
 * Quitar dividas do Cliente
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
    private Cliente cliente;

    /**
     * Construtor de PagarDebito
     * @param cliente - cliente a pagar
     */
    public PagarDebito(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo que retorna quanto um cliente esta devendo
     * @return - O valor da divida
     */
    public double getQuantoEstaDevendo() {
        dividas = cliente.getDivida();
        return dividas;
    }

    /**
     * Metodo que quita a divida do cliente.
     */
    public void saldarDividas() {
        cliente.setEmDebito(Boolean.FALSE);
        cliente.setDivida(0);
    }
}
