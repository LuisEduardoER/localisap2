/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

/**
 *
 * @author Filipe
 */
public enum Acessorio {

    P2("Duas Portas"),
    P4("Quatro Portas"),
    AC("Ar Condicionado"),
    GPS("GPS - Global Positioning System"),
    DH("Direcao Hidraulica"),
    VE("Vidro Eletrico"),
    TE("Trava Eletrica"),
    AB("Air Bag"),
    BC("Bancos de Couro");
    private String nomeCompleto;

    private Acessorio(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}
