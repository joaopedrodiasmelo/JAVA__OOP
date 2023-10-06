package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;

/**
 * @author João Pedro e Rafaela
 */
public class VerdePreto extends Personagem  {
    public VerdePreto(Posicao posicao) {
        super("verdePreto.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
        this.quebravel = false;
        this.movel = true;

    }
}