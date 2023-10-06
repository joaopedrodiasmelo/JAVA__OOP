package Fases;

import Modelo.Blocos.SetaBaixo;
import Modelo.Blocos.SetaCima;
import Modelo.Blocos.SetaDireita;
import Modelo.Blocos.SetaEsquerda;
import Modelo.Blocos.VerdePreto;
import Modelo.Blocos.Verde;
import Modelo.Blocos.Vermelho;
import Modelo.Blocos.VermelhoPreto;
import Modelo.Comida.*;
import Modelo.Elementos.*;
import Modelo.Elementos.Personagem;
import Modelo.Elementos.caveira.Caveira;
import auxiliar.Posicao;

import java.util.ArrayList;

/**
 * @author João Pedro e Rafaela
 */
public class FaseGeral extends ArrayList<Personagem> {

    private int fase_atual;

    private int fase_arquivo;


    public FaseGeral() {
        this.fase_atual = 1;
    }

    public void jogarFase(Skoot skoot, int fase) {

        this.fase_atual = fase;

        switch (fase_atual) {
            case 1:
                this.Fase1(skoot);
                break;

            case 2:
                this.Fase2(skoot);
                break;

            case 3:
                this.Fase3(skoot);
                break;
            case 4:
                this.Fase4(skoot);
                break;

            case 5:
                this.Fase5(skoot);
                break;

        }
    }

    public void Fase1(Skoot skoot) {
        System.out.println("------------ Fase 1 ------------\n");
        this.clear();

        skoot.setPosicao(0, 4);
        skoot.setVidas(3);
        this.add(skoot);
        
        Monstrinhos monstro1 = new Monstrinhos("roboRosa.png");
        monstro1.setPosicao(0, 9);
        this.add(monstro1);
        Monstrinhos monstro2 = new Monstrinhos("roboAmarelo.png");
        monstro2.setPosicao(10, 1);
        this.add(monstro2);
        Monstrinhos monstro3 = new Monstrinhos("roboVerde.png");
        monstro3.setPosicao(1, 0);
        this.add(monstro3);
        Monstrinhos monstro4 = new Monstrinhos("roboLaranja.png");
        monstro4.setPosicao(10, 9);
        this.add(monstro4);

        this.add(new Vermelho(new auxiliar.Posicao(1, 1)));
        this.add(new Vermelho(new auxiliar.Posicao(1, 3)));
        this.add(new Vermelho(new auxiliar.Posicao(1, 5)));
        this.add(new Vermelho(new auxiliar.Posicao(1, 7)));
        this.add(new Vermelho(new auxiliar.Posicao(1, 9)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 1)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 3)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 5)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 7)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 9)));
        this.add(new Vermelho(new auxiliar.Posicao(5, 1)));
        this.add(new Vermelho(new auxiliar.Posicao(5, 3)));
        this.add(new Vermelho(new auxiliar.Posicao(5, 5)));
        this.add(new Vermelho(new auxiliar.Posicao(5, 7)));
        this.add(new Vermelho(new auxiliar.Posicao(5, 9)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 1)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 3)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 5)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 7)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 9)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 1)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 3)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 5)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 7)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 9)));


        /*Blocos verdes imoveis e quebraveis*/
        VerdePreto v1 = new VerdePreto(new auxiliar.Posicao(0, 1));
        v1.setQuebravel(true);
        v1.setMovel(false);
        this.add(v1);
        VerdePreto v2 = new VerdePreto(new auxiliar.Posicao(1, 8));
        v2.setQuebravel(true);
        v2.setMovel(false);
        this.add(v2);
        VerdePreto v3 = new VerdePreto(new auxiliar.Posicao(1, 10));
        v3.setQuebravel(true);
        v3.setMovel(false);
        this.add(v3);
        VerdePreto v4 = new VerdePreto(new auxiliar.Posicao(2, 1));
        v4.setQuebravel(true);
        v4.setMovel(false);
        this.add(v4);
        VerdePreto v5 = new VerdePreto(new auxiliar.Posicao(3, 0));
        v5.setQuebravel(true);
        v5.setMovel(false);
        this.add(v5);
        VerdePreto v6 = new VerdePreto(new auxiliar.Posicao(7, 10));
        v6.setQuebravel(true);
        v6.setMovel(false);
        this.add(v6);
        VerdePreto v7 = new VerdePreto(new auxiliar.Posicao(8, 9));
        v7.setQuebravel(true);
        v7.setMovel(false);
        this.add(v7);
        VerdePreto v8 = new VerdePreto(new auxiliar.Posicao(9, 0));
        v8.setQuebravel(true);
        v8.setMovel(false);
        this.add(v8);
        VerdePreto v9 = new VerdePreto(new auxiliar.Posicao(9, 2));
        v9.setQuebravel(true);
        v9.setMovel(false);
        this.add(v9);
        VerdePreto v10 = new VerdePreto(new auxiliar.Posicao(9, 8));
        v10.setQuebravel(true);
        v10.setMovel(false);
        this.add(v10);
        VerdePreto v11 = new VerdePreto(new auxiliar.Posicao(10, 7));
        v11.setQuebravel(true);
        v11.setMovel(false);
        this.add(v11);

        this.add(new VerdePreto(new auxiliar.Posicao(0, 5)));
        this.add(new VerdePreto(new auxiliar.Posicao(1, 2)));
        this.add(new VerdePreto(new auxiliar.Posicao(2, 5)));
        this.add(new VerdePreto(new auxiliar.Posicao(3, 8)));
        this.add(new VerdePreto(new auxiliar.Posicao(4, 1)));
        this.add(new VerdePreto(new auxiliar.Posicao(4, 9)));
        this.add(new VerdePreto(new auxiliar.Posicao(5, 2)));
        this.add(new VerdePreto(new auxiliar.Posicao(5, 6)));
        this.add(new VerdePreto(new auxiliar.Posicao(6, 5)));
        this.add(new VerdePreto(new auxiliar.Posicao(6, 7)));
        this.add(new VerdePreto(new auxiliar.Posicao(7, 8)));
        this.add(new VerdePreto(new auxiliar.Posicao(8, 3)));
        this.add(new VerdePreto(new auxiliar.Posicao(9, 6)));

        Comida abacate = new Comida("abacate.png");
        abacate.setPosicao(0, 0);
        this.add(abacate);
        Comida melancia = new Comida("melancia.png");
        melancia.setPosicao(0,10);
        this.add(melancia);
        Comida morango = new Comida("morango.png");
        morango.setPosicao(10, 0);
        this.add(morango);
        Comida limao = new Comida("limao.png");
        limao.setPosicao(10, 10);
        this.add(limao);  
    }

    public void Fase2(Skoot skoot) {
        System.out.println("------------ Fase 2 ------------\n");

        this.clear();
        skoot.setVidas(3);
        skoot.setPosicao(5, 5);
        this.add(skoot);
        
        Monstrinhos monstro1 = new Monstrinhos("roboRosa.png");
        monstro1.setPosicao(0, 0);
        this.add(monstro1);
        Monstrinhos monstro2 = new Monstrinhos("roboAmarelo.png");
        monstro2.setPosicao(0, 10);
        this.add(monstro2);
        Monstrinhos monstro3 = new Monstrinhos("roboVerde.png");
        monstro3.setPosicao(10, 0);
        this.add(monstro3);
        Monstrinhos monstro4 = new Monstrinhos("roboLaranja.png");
        monstro4.setPosicao(10, 10);
        this.add(monstro4);
        
        this.add(new SetaDireita(new Posicao(0, 3)));
        this.add(new SetaDireita(new Posicao(0, 7)));
        this.add(new SetaDireita(new Posicao(2, 3)));
        this.add(new SetaDireita(new Posicao(4, 3)));
        this.add(new SetaDireita(new Posicao(4, 7)));
        this.add(new SetaDireita(new Posicao(6, 3)));
        this.add(new SetaDireita(new Posicao(8, 3)));
        this.add(new SetaDireita(new Posicao(8, 7)));
        this.add(new SetaDireita(new Posicao(10, 7)));

        this.add(new SetaEsquerda(new Posicao(2, 5)));
        this.add(new SetaEsquerda(new Posicao(2, 6)));
        this.add(new SetaEsquerda(new Posicao(2, 7)));
        this.add(new SetaEsquerda(new Posicao(4, 9)));
        this.add(new SetaEsquerda(new Posicao(4, 10)));
        this.add(new SetaEsquerda(new Posicao(6, 7)));
        this.add(new SetaEsquerda(new Posicao(10, 3)));

        this.add(new SetaCima(new Posicao(3, 0)));
        this.add(new SetaCima(new Posicao(3, 6)));
        this.add(new SetaCima(new Posicao(3, 8)));
        this.add(new SetaCima(new Posicao(4, 0)));
        this.add(new SetaCima(new Posicao(4, 8)));
        this.add(new SetaCima(new Posicao(5, 0)));
        this.add(new SetaCima(new Posicao(6, 0)));
        this.add(new SetaCima(new Posicao(7, 0)));
        this.add(new SetaCima(new Posicao(7, 6)));
        this.add(new SetaCima(new Posicao(7, 8)));
        this.add(new SetaCima(new Posicao(7, 10)));

        this.add(new SetaBaixo(new Posicao(2, 4)));
        this.add(new SetaBaixo(new Posicao(3, 2)));
        this.add(new SetaBaixo(new Posicao(3, 4)));
        this.add(new SetaBaixo(new Posicao(3, 10)));
        this.add(new SetaBaixo(new Posicao(7, 2)));
        this.add(new SetaBaixo(new Posicao(7, 4)));

        this.add(new Vermelho(new Posicao(1, 3)));
        this.add(new Vermelho(new Posicao(1, 7)));
        this.add(new Vermelho(new Posicao(3, 1)));
        this.add(new Vermelho(new Posicao(3, 3)));
        this.add(new Vermelho(new Posicao(3, 5)));
        this.add(new Vermelho(new Posicao(3, 7)));
        this.add(new Vermelho(new Posicao(3, 9)));
        this.add(new Vermelho(new Posicao(5, 3)));
        this.add(new Vermelho(new Posicao(5, 7)));
        this.add(new Vermelho(new Posicao(7, 1)));
        this.add(new Vermelho(new Posicao(7, 3)));
        this.add(new Vermelho(new Posicao(7, 5)));
        this.add(new Vermelho(new Posicao(7, 7)));
        this.add(new Vermelho(new Posicao(7, 9)));
        this.add(new Vermelho(new Posicao(9, 3)));
        this.add(new Vermelho(new Posicao(9, 7)));

        Comida hamburguer = new Comida("hamburguer.png");
        hamburguer.setPosicao(1, 5);
        this.add(hamburguer);
        Comida pizza = new Comida("pizza.png");
        pizza.setPosicao(5,1);
        this.add(pizza);
        Comida hotdog = new Comida("hotdog.png");
        hotdog.setPosicao(5, 9);
        this.add(hotdog);
        Comida batatas = new Comida("batatas.png");
        batatas.setPosicao(9, 5);
        this.add(batatas);

    }

    public void Fase3(Skoot skoot) {
        System.out.println("------------ Fase 3 ------------\n");
        this.clear();
        skoot.setVidas(3);
        skoot.setPosicao(5, 5);
        this.add(skoot);

        Monstrinhos monstro1 = new Monstrinhos("roboRosa.png");
        monstro1.setPosicao(0, 5);
        this.add(monstro1);
        Monstrinhos monstro2 = new Monstrinhos("roboAmarelo.png");
        monstro2.setPosicao(2, 5);
        this.add(monstro2);
        Monstrinhos monstro3 = new Monstrinhos("roboVerde.png");
        monstro3.setPosicao(8, 5);
        this.add(monstro3);
        Monstrinhos monstro4 = new Monstrinhos("roboLaranja.png");
        monstro4.setPosicao(10, 5);
        this.add(monstro4);

        this.add(new VermelhoPreto(new Posicao(1, 1)));
        this.add(new VermelhoPreto(new Posicao(1, 2)));
        this.add(new VermelhoPreto(new Posicao(1, 3)));
        this.add(new VermelhoPreto(new Posicao(1, 4)));
        this.add(new VermelhoPreto(new Posicao(1, 5)));
        this.add(new VermelhoPreto(new Posicao(1, 6)));
        this.add(new VermelhoPreto(new Posicao(1, 7)));
        this.add(new VermelhoPreto(new Posicao(1, 8)));
        this.add(new VermelhoPreto(new Posicao(1, 9)));
        this.add(new VermelhoPreto(new Posicao(2, 1)));
        this.add(new VermelhoPreto(new Posicao(2, 9)));
        this.add(new VermelhoPreto(new Posicao(3, 1)));
        this.add(new VermelhoPreto(new Posicao(3, 9)));
        this.add(new VermelhoPreto(new Posicao(3, 3)));
        this.add(new VermelhoPreto(new Posicao(3, 4)));
        this.add(new VermelhoPreto(new Posicao(3, 5)));
        this.add(new VermelhoPreto(new Posicao(3, 6)));
        this.add(new VermelhoPreto(new Posicao(3, 7)));
        this.add(new VermelhoPreto(new Posicao(4, 1)));
        this.add(new VermelhoPreto(new Posicao(4, 3)));
        this.add(new VermelhoPreto(new Posicao(4, 7)));
        this.add(new VermelhoPreto(new Posicao(4, 9)));
        this.add(new VermelhoPreto(new Posicao(5, 1)));
        this.add(new VermelhoPreto(new Posicao(5, 3)));
        this.add(new VermelhoPreto(new Posicao(5, 7)));
        this.add(new VermelhoPreto(new Posicao(5, 9)));
        this.add(new VermelhoPreto(new Posicao(6, 1)));
        this.add(new VermelhoPreto(new Posicao(6, 3)));
        this.add(new VermelhoPreto(new Posicao(6, 7)));
        this.add(new VermelhoPreto(new Posicao(6, 9)));
        this.add(new VermelhoPreto(new Posicao(7, 1)));
        this.add(new VermelhoPreto(new Posicao(7, 3)));
        this.add(new VermelhoPreto(new Posicao(7, 4)));
        this.add(new VermelhoPreto(new Posicao(7, 5)));
        this.add(new VermelhoPreto(new Posicao(7, 6)));
        this.add(new VermelhoPreto(new Posicao(7, 7)));
        this.add(new VermelhoPreto(new Posicao(7, 9)));
        this.add(new VermelhoPreto(new Posicao(8, 1)));
        this.add(new VermelhoPreto(new Posicao(8, 9)));
        this.add(new VermelhoPreto(new Posicao(9, 1)));
        this.add(new VermelhoPreto(new Posicao(9, 2)));
        this.add(new VermelhoPreto(new Posicao(9, 3)));
        this.add(new VermelhoPreto(new Posicao(9, 4)));
        this.add(new VermelhoPreto(new Posicao(9, 5)));
        this.add(new VermelhoPreto(new Posicao(9, 6)));
        this.add(new VermelhoPreto(new Posicao(9, 7)));
        this.add(new VermelhoPreto(new Posicao(9, 8)));
        this.add(new VermelhoPreto(new Posicao(9, 9)));

        Comida tomate = new Comida("tomate.png");
        tomate.setPosicao(5,0);
        this.add(tomate);
        Comida berinjela = new Comida("berinjela.png");
        berinjela.setPosicao(5,2);
        this.add(berinjela);
        Comida cenoura = new Comida("cenoura.png");
        cenoura.setPosicao(5, 8);
        this.add(cenoura);
        Comida pimentao = new Comida("pimentao.png");
        pimentao.setPosicao(5,10);
        this.add(pimentao);
    }

    public void Fase4(Skoot skoot) {
        System.out.println("------------ Fase 4 ------------\n");
        this.clear();
        skoot.setVidas(3);
        skoot.setPosicao(5, 5);
        this.add(skoot);

        Monstrinhos monstro1 = new Monstrinhos("roboVerde.png");
        monstro1.setPosicao(0, 5);
        this.add(monstro1);
        Monstrinhos monstro2 = new Monstrinhos("roboLaranja.png");
        monstro2.setPosicao(5, 0);
        this.add(monstro2);
        Monstrinhos monstro3 = new Monstrinhos("roboRosa.png");
        monstro3.setPosicao(5, 10);
        this.add(monstro3);
        Monstrinhos monstro4 = new Monstrinhos("roboAmarelo.png");
        monstro4.setPosicao(10, 5);
        this.add(monstro4);

        this.add(new Vermelho(new Posicao(0, 3)));
        this.add(new Vermelho(new Posicao(0, 7)));
        this.add(new Vermelho(new Posicao(1, 0)));
        this.add(new Vermelho(new Posicao(1, 8)));
        this.add(new Vermelho(new Posicao(2, 5)));
        this.add(new Vermelho(new Posicao(3, 2)));
        this.add(new Vermelho(new Posicao(3, 10)));
        this.add(new Vermelho(new Posicao(5, 2)));
        this.add(new Vermelho(new Posicao(5, 8)));
        this.add(new Vermelho(new Posicao(6, 3)));
        this.add(new Vermelho(new Posicao(7, 0)));
        this.add(new Vermelho(new Posicao(8, 1)));
        this.add(new Vermelho(new Posicao(8, 7)));
        this.add(new Vermelho(new Posicao(8, 10)));
        this.add(new Vermelho(new Posicao(10, 1)));

        this.add(new Verde(new Posicao(1, 1)));
        this.add(new Verde(new Posicao(1, 3)));
        this.add(new Verde(new Posicao(1, 5)));
        this.add(new Verde(new Posicao(1, 7)));
        this.add(new Verde(new Posicao(1, 9)));
        this.add(new Verde(new Posicao(2, 2)));
        this.add(new Verde(new Posicao(2, 4)));
        this.add(new Verde(new Posicao(2, 6)));
        this.add(new Verde(new Posicao(2, 8)));
        this.add(new Verde(new Posicao(3, 1)));
        this.add(new Verde(new Posicao(3, 3)));
        this.add(new Verde(new Posicao(3, 5)));
        this.add(new Verde(new Posicao(3, 7)));
        this.add(new Verde(new Posicao(3, 9)));
        this.add(new Verde(new Posicao(4, 2)));
        this.add(new Verde(new Posicao(4, 4)));
        this.add(new Verde(new Posicao(4, 6)));
        this.add(new Verde(new Posicao(4, 8)));
        this.add(new Verde(new Posicao(5, 1)));
        this.add(new Verde(new Posicao(5, 3)));
        this.add(new Verde(new Posicao(5, 7)));
        this.add(new Verde(new Posicao(5, 9)));
        this.add(new Verde(new Posicao(6, 2)));
        this.add(new Verde(new Posicao(6, 4)));
        this.add(new Verde(new Posicao(6, 6)));
        this.add(new Verde(new Posicao(6, 8)));
        this.add(new Verde(new Posicao(7, 1)));
        this.add(new Verde(new Posicao(7, 3)));
        this.add(new Verde(new Posicao(7, 5)));
        this.add(new Verde(new Posicao(7, 7)));
        this.add(new Verde(new Posicao(7, 9)));
        this.add(new Verde(new Posicao(8, 2)));
        this.add(new Verde(new Posicao(8, 4)));
        this.add(new Verde(new Posicao(8, 6)));
        this.add(new Verde(new Posicao(8, 8)));
        this.add(new Verde(new Posicao(9, 1)));
        this.add(new Verde(new Posicao(9, 3)));
        this.add(new Verde(new Posicao(9, 5)));
        this.add(new Verde(new Posicao(9, 7)));
        this.add(new Verde(new Posicao(9, 9)));

        Comida picole = new Comida("picole.png");
        picole.setPosicao(0,0);
        this.add(picole);
        Comida sundaMorango = new Comida("sundaeMorango.png");
        sundaMorango.setPosicao(0,10);
        this.add(sundaMorango);
        Comida sundaeChocolate = new Comida("sundaeChocolate.png");
        sundaeChocolate.setPosicao(10,0);
        this.add(sundaeChocolate);
        Comida sorvete = new Comida("sorvete.png");
        sorvete.setPosicao(10,10);
        this.add(sorvete);
    }

    public void Fase5(Skoot skoot) {
        System.out.println("------------ Fase 5 ------------\n");
        this.clear();
        skoot.setVidas(3);
        skoot.setPosicao(4, 5);
        this.add(skoot);

        Monstrinhos monstro1 = new Monstrinhos("roboAmarelo.png");
        monstro1.setPosicao(1, 1);
        this.add(monstro1);
        Monstrinhos monstro2 = new Monstrinhos("roboRosa.png");
        monstro2.setPosicao(1, 9);
        this.add(monstro2);
        Monstrinhos monstro3 = new Monstrinhos("roboVerde.png");
        monstro3.setPosicao(9, 1);
        this.add(monstro3);
        Monstrinhos monstro4= new Monstrinhos("roboLaranja.png");
        monstro4.setPosicao(9, 9);
        this.add(monstro4);

        Caveira caveira = new Caveira("caveira.png");
        caveira.setPosicao(5, 0);
        this.add(caveira);

        this.add(new Vermelho(new auxiliar.Posicao(1, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(1, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(2, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(2, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(3, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(4, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(4, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(6, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(6, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(7, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(8, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(8, 10)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 0)));
        this.add(new Vermelho(new auxiliar.Posicao(9, 10)));
        
        /*Blocos verdes imoveis e quebraveis*/
        VerdePreto v1 = new VerdePreto(new auxiliar.Posicao(0, 1));
        v1.setQuebravel(true);
        v1.setMovel(false);
        this.add(v1);
        VerdePreto v2 = new VerdePreto(new auxiliar.Posicao(0, 2));
        v2.setQuebravel(true);
        v2.setMovel(false);
        this.add(v2);
        VerdePreto v3 = new VerdePreto(new auxiliar.Posicao(0, 3));
        v3.setQuebravel(true);
        v3.setMovel(false);
        this.add(v3);
        VerdePreto v4 = new VerdePreto(new auxiliar.Posicao(0, 4));
        v4.setQuebravel(true);
        v4.setMovel(false);
        this.add(v4);
        VerdePreto v5 = new VerdePreto(new auxiliar.Posicao(0, 6));
        v5.setQuebravel(true);
        v5.setMovel(false);
        this.add(v5);
        VerdePreto v6 = new VerdePreto(new auxiliar.Posicao(0, 7));
        v6.setQuebravel(true);
        v6.setMovel(false);
        this.add(v6);
        VerdePreto v7 = new VerdePreto(new auxiliar.Posicao(0, 8));
        v7.setQuebravel(true);
        v7.setMovel(false);
        this.add(v7);
        VerdePreto v8 = new VerdePreto(new auxiliar.Posicao(0, 9));
        v8.setQuebravel(true);
        v8.setMovel(false);
        this.add(v8);
        VerdePreto v9 = new VerdePreto(new auxiliar.Posicao(10, 1));
        v9.setQuebravel(true);
        v9.setMovel(false);
        this.add(v9);
        VerdePreto v10 = new VerdePreto(new auxiliar.Posicao(10, 2));
        v10.setQuebravel(true);
        v10.setMovel(false);
        this.add(v10);
        VerdePreto v11 = new VerdePreto(new auxiliar.Posicao(10, 3));
        v11.setQuebravel(true);
        v11.setMovel(false);
        this.add(v11);
        VerdePreto v12 = new VerdePreto(new auxiliar.Posicao(10, 4));
        v12.setQuebravel(true);
        v12.setMovel(false);
        this.add(v12);
        VerdePreto v13 = new VerdePreto(new auxiliar.Posicao(10, 6));
        v13.setQuebravel(true);
        v13.setMovel(false);
        this.add(v13);
        VerdePreto v14 = new VerdePreto(new auxiliar.Posicao(10, 7));
        v14.setQuebravel(true);
        v14.setMovel(false);
        this.add(v14);
        VerdePreto v15 = new VerdePreto(new auxiliar.Posicao(10, 8));
        v15.setQuebravel(true);
        v15.setMovel(false);
        this.add(v15);
        VerdePreto v16 = new VerdePreto(new auxiliar.Posicao(10, 9));
        v16.setQuebravel(true);
        v16.setMovel(false);
        this.add(v16);

        this.add(new SetaCima(new Posicao(4, 1)));
        this.add(new SetaCima(new Posicao(4, 3)));
        this.add(new SetaCima(new Posicao(4, 6)));
        this.add(new SetaCima(new Posicao(4, 8)));
        this.add(new SetaCima(new Posicao(6, 1)));
        this.add(new SetaCima(new Posicao(6, 3)));
        this.add(new SetaCima(new Posicao(6, 6)));
        this.add(new SetaCima(new Posicao(6, 8)));

        this.add(new SetaBaixo(new Posicao(4, 2)));
        this.add(new SetaBaixo(new Posicao(4, 4)));
        this.add(new SetaBaixo(new Posicao(4, 7)));
        this.add(new SetaBaixo(new Posicao(4, 9)));
        this.add(new SetaBaixo(new Posicao(6, 2)));
        this.add(new SetaBaixo(new Posicao(6, 4)));
        this.add(new SetaBaixo(new Posicao(6, 7)));
        this.add(new SetaBaixo(new Posicao(6, 9)));

        this.add(new SetaDireita(new Posicao(0, 5)));
        this.add(new SetaDireita(new Posicao(2, 5)));
        this.add(new SetaDireita(new Posicao(7, 5)));
        this.add(new SetaDireita(new Posicao(9, 5)));

        this.add(new SetaEsquerda(new Posicao(1, 5)));
        this.add(new SetaEsquerda(new Posicao(3, 5)));
        this.add(new SetaEsquerda(new Posicao(8, 5)));
        this.add(new SetaEsquerda(new Posicao(10, 5)));

        Comida torta = new Comida("torta.png");
        torta.setPosicao(0, 0);
        this.add(torta);
        Comida donut = new Comida("donut.png");
        donut.setPosicao(0,10);
        this.add(donut);
        Comida cupcake = new Comida("cupcake.png");
        cupcake.setPosicao(10,0);
        this.add(cupcake);
        Comida bala = new Comida("bala.png");
        bala.setPosicao(10,10);
        this.add(bala);

        this.fase_atual = 0;
    }

    public void setFase_atual(int fase_atual) {
        this.fase_atual = fase_atual;
    }
    
        public int getFase_atual() {
        return fase_atual;
    }
 
    public void setFase_arquivo(int fase_arquivo) {
        this.fase_arquivo = fase_arquivo;
    }
    
    public int getFase_arquivo() {
        return fase_arquivo;
    }
}