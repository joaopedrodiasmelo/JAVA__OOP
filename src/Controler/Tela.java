package Controler;

import Fases.FaseGeral;
import Modelo.Elementos.Personagem;
import Modelo.Elementos.Skoot;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    private Skoot skoot; 
    private ArrayList<Personagem> faseAtual; /*armazena os personagens de uma determinada fase*/
    private FaseGeral fases;
    private ControleDeJogo cj = new ControleDeJogo(); 
    private ArquivoFases arquivoFases = new ArquivoFases();/*armazena e salva as fases do jogo*/
    private Graphics g2;
    private boolean spaceKeyPressed = false;
    private boolean verifica_vidas = false;

    public Tela() {
        Desenho.setCenario(this); 
        initComponents(); 
        //this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        this.setTitle("Skooter - João Pedro e Rafaela");
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);


        faseAtual = new ArrayList<>(); /*armazena os elementos gráficos*/

        /*Cria os elementos e os adiciona no array*/
        skoot = new Skoot("skoot.png");
        this.addPersonagem(skoot);

        /*Inicializando o array de personagens de acordo com cada fase*/
        fases = new FaseGeral();
        fases.jogarFase(skoot, fases.getFase_atual());
        faseAtual = fases;
    }

    public boolean ehPosicaoValida(Posicao p) {
        return cj.ehPosicaoValida(this.faseAtual, p);
    }

    public boolean ehPosicaoValidaPersonagem(Personagem atual) {
        return cj.ehPosicaoValidaPersonagem(this.faseAtual, atual);
    }

    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }

    /*Atualiza as operacoes da tela em um periodo administrado pelo metodo go()*/
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "fundo.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);

            if (!this.cj.verificaComidas(faseAtual)) { //verificacao para a mudança de faze
                if (fases.getFase_atual() == 0) {
                    faseAtual.clear();
                    System.out.println("--------- FIM DE JOGO ----------");
                } else {
                    fases.jogarFase(skoot, fases.getFase_atual() + 1);
                    faseAtual = fases;
                }
            }

            if (skoot.getVidas() == 0) {//o jogador perdeu o jogo
                verifica_vidas = true;
                faseAtual.clear();
                System.out.println("--------- PERDEU O JOGO --------\n");
            }
        }

        if (faseAtual.isEmpty()) { //jogador chegou ao final do jogo
            String saida;
            if (verifica_vidas) {
                saida = "vocePerdeu.png";

            } else {
                saida = "voceVenceu.png";
            }
            try {
                for (int i = 0; i < 11; i++) {
                    for (int j = 0; j < 11; j++) {
                        try {
                            /*Linha para alterar o background*/
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "preto.png");
                            g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                        } catch (IOException ex) {
                            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                ImageIcon iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + saida);
                Desenho.desenhar(iImage, 0,0);
            } catch (Exception e) {
                System.out.println("Erro ao mostrar imagem");
            }
        }
        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }


    /*Administra o tempo de redesenhar a tela e seus elementos*/
    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint(); //chama a funcao paint()
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void keyPressed(KeyEvent e) {
        int direcao = 0;
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            skoot.moveUp();
            direcao = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            skoot.moveDown();
            direcao = 2;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            skoot.moveLeft();
            direcao = 3;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            skoot.moveRight();
            direcao = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.faseAtual.clear();
            verifica_vidas = false;
            skoot = new Skoot("skoot.png");
            this.addPersonagem(skoot);
            fases = new FaseGeral();
            fases.jogarFase(skoot, fases.getFase_atual());
            faseAtual = fases;

        } else if (e.getKeyCode() == KeyEvent.VK_S) { //salva a fase no arquivo para quando o jogador recarregar começar onde parou
            this.arquivoFases.salvaFaseArquivo(faseAtual);
            fases.setFase_arquivo(fases.getFase_atual());
            this.arquivoFases.salvaNumeroDaFase(fases.getFase_arquivo());
            System.out.println("---------- FASE SALVA ----------\n");
            
        } else if (e.getKeyCode() == KeyEvent.VK_R) { //recupera a fase no arquivo
            this.faseAtual.clear();
            faseAtual = this.arquivoFases.faseArquivo();
            skoot = new Skoot("skoot.png");
            skoot.setVidas(faseAtual.get(0).getVidas());
            skoot.setPosicao(faseAtual.get(0).getLinha(), faseAtual.get(0).getColuna());
            faseAtual.remove(faseAtual.get(0));
            faseAtual.add(0, skoot);
            fases.setFase_atual(this.arquivoFases.retornaNumeroDaFase());
            System.out.println("------- FASE RECARREGADA -------\n");           
        }

        Personagem sobreposto;
        sobreposto = cj.elementoIntransponivel(this.faseAtual, skoot.getPosicao());
        if (sobreposto != null) {

            if (sobreposto.isMovel()) {
                switch (direcao) {
                    case 1:
                        if (!sobreposto.moveUp())
                            skoot.voltaAUltimaPosicao();
                        break;
                    case 2:
                        if (!sobreposto.moveDown())
                            skoot.voltaAUltimaPosicao();
                        break;
                    case 3:
                        if (!sobreposto.moveLeft())
                            skoot.voltaAUltimaPosicao();
                        break;
                    case 4:
                        if (!sobreposto.moveRight())
                            skoot.voltaAUltimaPosicao();
                        break;
                }
            }
        }

        this.setTitle("Skooter - João Pedro e Rafaela");
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
        int x = e.getX();
        int y = e.getY();

        this.setTitle("X: " + x + ", Y: " + y +
                " -> Cell: " + (y / Consts.CELL_SIDE) + ", " + (x / Consts.CELL_SIDE));

        this.skoot.getPosicao().setPosicao(y / Consts.CELL_SIDE, x / Consts.CELL_SIDE);

        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}