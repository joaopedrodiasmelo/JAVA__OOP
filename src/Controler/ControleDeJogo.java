package Controler;

import Modelo.Elementos.Monstrinhos;
import Modelo.Elementos.Personagem;
import Modelo.Elementos.Skoot;
import auxiliar.Posicao;
import java.util.ArrayList;

public class ControleDeJogo {
    /*Desenha os personagens na tela em seus respectivos locais da fase*/
    public void desenhaTudo(ArrayList<Personagem> e) {
        for (int i = 0; i < e.size(); i++) {

            if (e.get(i) instanceof Monstrinhos) {
                e.get(i).autoDesenhoMonstro(e, e.get(i).getLinha(), e.get(i).getColuna());
            } else {
                e.get(i).autoDesenho();
            }
        }
    }

    /*Realiza as operacoes basicas em cada fase, analisando a posicao do skoot em relacao aos outros elementos*/
    public void processaTudo(ArrayList<Personagem> umaFase) {
        Skoot skoot = (Skoot) umaFase.get(0); //primeiro personagem do array é sempre o skoot
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i); //recebe os próximos personagens
            if (skoot.getPosicao().igual(pIesimoPersonagem.getPosicao())) //compara a posicao do skoot com determinado elemento
            { //verifica qual das operacoes deve ser realizada
                if (pIesimoPersonagem.isQuebravel() || pIesimoPersonagem.isColecionavel() || pIesimoPersonagem.isSetaAux()) {
                    if (pIesimoPersonagem.isSetaAux()) {
                        if (pIesimoPersonagem.isSetaCima()) {
                            skoot.moveUp();
                        } else if (pIesimoPersonagem.isSetaBaixo()) {
                            skoot.moveDown();
                        } else if (pIesimoPersonagem.isSetaEsquerda()) {
                            skoot.moveLeft();
                        } else if (pIesimoPersonagem.isSetaDireita()) {
                            skoot.moveRight();
                        }
                        continue;
                    }
                    
                    umaFase.remove(pIesimoPersonagem);
                    
                } else
                    skoot.voltaAUltimaPosicao();

            }
        }
    }   
       
    /*Retorna true se a posicao p é válida para Skoot com relacao a um personagem no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p) {
        Personagem pIesimoPersonagem;
        for (int i = 0; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(0);
            if (!pIesimoPersonagem.isbTransponivel()) //elemento nao transponivel
                if (pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }
        return true;
    }

    /*Identifica quando o Skoot bate em algum elemento intransponível*/
    public boolean ehPosicaoValidaPersonagem(ArrayList<Personagem> personagens, Personagem atual) {
        Personagem teste;

        for (int a = 0; a < personagens.size(); a++) {
            teste = personagens.get(a);
            if (teste == atual)
                continue;
            if (!teste.isbTransponivel() || teste.isColecionavel()) {
                if (teste.getPosicao().igual(atual.getPosicao())) {
                    if (atual.isCausaDano() && teste.isbMortal()) //skoot bateu em um elemento mortal
                    {
                        teste.setVidas(teste.getVidas() - 1);//diminui uma vida do skoot
                       System.out.println("Skoot PERDEU uma vida\nVidas restantes: " + teste.getVidas()+"\n");
                    }
                    return false; //significa que o Personagem atual nao pode ficar na posicao que estava
                }
            }
        }
        return true;
    }

    public Personagem elementoIntransponivel(ArrayList<Personagem> e, Posicao p) {
        Personagem aux;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for (int i = 1; i < e.size(); i++) {
            /*Olha todos os elementos*/
            aux = e.get(i);
            /*Pega o i-esimo elemento do jogo*/
            if (!aux.isbTransponivel()) {
                if (aux.getPosicao().igual(p)) {
                    return aux;
                    /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }
        }
        return null;
    }

    public boolean verificaComidas(ArrayList<Personagem> elementos) {
        for (int a = 0; a < elementos.size(); a++) {
            if (elementos.get(a).isColecionavel())
                return true;
        }

        return false;
    }
}
