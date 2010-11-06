/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locacao;

/**
 *
 * @author Filipe
 */
public enum Problemas {
    NENHUM(0),
    ARRANHÕES(80),
    AMASSADOS_LEVES(180),
    AMASSADOS_GRAVES(350),
    ROUBADO(5000),
    PERDA_TOTAL(5000);
    private double preco;

    private Problemas(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
