package veiculos;

/**
* Classe Acessorio
* Classe do tipo ENUM para listar todos os possiveis acessorios
*
*
* @author Filipe Alencar   -twitter.com/filipealencar_
* @author Felipe Jose      -twitter.com/felipejosefc
* @author Emilio Farias    -twitter.com/militofarias
*
* http://code.google.com/p/localisap2/
* Universidade Federal de Campina Grande - Computacao
*
*/
public enum Acessorio {

    QP("Quatro Portas"),
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

    /**
     * Captura o Nome completo do acessorio
     * @return nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }
}
