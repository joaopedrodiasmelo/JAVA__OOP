package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class VermelhoPreto extends Personagem  {
    public VermelhoPreto(Posicao posicao) {
        super("vermelhoPreto.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
        this.movel = true;
    }
}