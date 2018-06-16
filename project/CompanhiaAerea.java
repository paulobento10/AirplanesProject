package edu.ufp.inf.aed2_1617.project;

import edu.princeton.cs.algs4.RedBlackBST;

public class CompanhiaAerea {

    private String nome;

    /**
     *
     * @element-type Aviao
     */
    private RedBlackBST<Integer, Aviao> aviaoST = new RedBlackBST<>();

    public CompanhiaAerea(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the aviaoST
     */
    public RedBlackBST<Integer, Aviao> getAviaoST() {
        return aviaoST;
    }

    /**
     * @param aAviaoST the aviaoST to set
     */
    public void setAviaoST(RedBlackBST<Integer, Aviao> aAviaoST) {
        aviaoST = aAviaoST;
    }

}
