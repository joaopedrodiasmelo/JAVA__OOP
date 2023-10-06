package Modelo.Elementos;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class Personagem implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected int vidas;
    protected boolean colecionavel;
    protected boolean causaDano;
    protected boolean movel;
    protected boolean quebravel;
    protected boolean setaCima;
    protected boolean setaBaixo;
    protected boolean setaDireita;
    protected boolean setaEsquerda;
    protected boolean setaAux;

    protected Personagem(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.vidas = 1;
        this.movel = false;
        this.colecionavel = false;
        this.quebravel = false;
        this.setaCima = false;
        this.setaBaixo = false;
        this.setaEsquerda = false;
        this.setaDireita = false;
        this.causaDano = false;
        this.setaAux = false;

        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isSetaAux() {
        return this.setaAux;
    }

    public Posicao getPosicao() {
        return pPosicao;
    }

    public int getLinha() {
        return pPosicao.getLinha();
    }

    public int getColuna() {
        return pPosicao.getColuna();
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public void autoDesenho() {
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());
    }

    public void autoDesenhoMonstro(ArrayList<Personagem> umaFase, int linha, int coluna) {
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean isbMortal() {
        return bMortal;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isCausaDano() {
        return causaDano;
    }

    public boolean isSetaCima() {
        return setaCima;
    }

    public boolean isSetaBaixo() {
        return setaBaixo;
    }

    public boolean isSetaEsquerda() {
        return setaEsquerda;
    }

    public boolean isSetaDireita() {
        return setaDireita;
    }

    public void setQuebravel(boolean quebravel) {
        this.quebravel = quebravel;
    }

    public boolean isQuebravel() {
        return this.quebravel;
    }

    public boolean isColecionavel() {
        return this.colecionavel;
    }

    public void setMovel(boolean movel) {
        this.movel = movel;
    }

    public boolean isMovel() {
        return this.movel;
    }

    public boolean setPosicao(Posicao posicao) {
        return pPosicao.copia(posicao);
    }

    public boolean moveUp() {
        boolean movimento = this.pPosicao.moveUp();
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaPersonagem(this)) {
            this.getPosicao().volta();
            return false;
        }
        return movimento;
    }

    public boolean moveDown() {
        boolean movimento = this.pPosicao.moveDown();
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaPersonagem(this)) {
            this.getPosicao().volta();
            return false;
        }
        return movimento;
    }

    public boolean moveRight() {
        boolean movimento = this.pPosicao.moveRight();
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaPersonagem(this)) {
            this.getPosicao().volta();
            return false;
        }
        return movimento;
    }

    public boolean moveLeft() {
        boolean movimento = this.pPosicao.moveLeft();
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValidaPersonagem(this)) {
            this.getPosicao().volta();
            return false;
        }
        return movimento;
    }
}
