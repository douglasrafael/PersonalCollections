package br.edu.uepb.personalcollections.enums;

/**
 * Representa os parentescos dos amigos sem relação ao usuário
 *
 * @author Douglas Rafael
 *
 */
public enum Parentesco {

    PAI("Pai"), MAE("Mãe"), IRMAO("Irmão"), IRMA("Irmã"), TIO("Tio"), TIA("Tia"),
    PRIMO("Primo"), PRIMA("Prima"), AVO1("Avô"), AVO2("Avó"), ESPOSO("Esposo"),
    ESPOSA("Esposa"), NAMORADA("Namorada"), NAMORADO("Namorado"), FILHO("Filho"),
    FILHA("Filha"), CONHECIDO("Conhecido"), OUTRO("Outro");

    private String nome;

    /**
     * Método construtor.
     *
     * @param parentesco
     */
    Parentesco(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera o nome do parentesco.
     *
     * @return O parentesco
     */
    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
}
