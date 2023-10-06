package Modelo.Blocos;

import Modelo.Elementos.Personagem;
import auxiliar.Posicao;
/**
 *
 * @author João Pedro e Rafaela
 */
public class SetaBaixo extends Personagem {
    public SetaBaixo(Posicao posicao) {
        super("setaBaixo.png");
        this.setPosicao(posicao);
        this.bTransponivel = false;
        this.setaBaixo = true;
        this.setaAux = true;
    }
}