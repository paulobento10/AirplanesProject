package edu.ufp.inf.aed2_1617.project;

import edu.princeton.cs.algs4.RedBlackBST;

public class Aeroporto implements Comparable<Aeroporto> {

    private String nome_aeroporto;

    private String codigo_aeroporto;

    private String cidade;

    private String pais;

    private String continente;

    private float classificacao;

    /**
     *
     * @element-type Aviao
     */
    private RedBlackBST<Integer, Aviao> aviaoST = new RedBlackBST<>();
    /**
     *
     * @element-type Voo
     */
    private RedBlackBST<Integer, Voo> voos = new RedBlackBST<>(); //reblack

    /**
     * Constructor
     * 
     * @param nome_aeroporto
     * @param codigo_aeroporto
     * @param cidade
     * @param pais
     * @param continente
     * @param classificacao
     */
    public Aeroporto(String nome_aeroporto, String codigo_aeroporto, String cidade, String pais, String continente, float classificacao) {
        this.nome_aeroporto = nome_aeroporto;
        this.codigo_aeroporto = codigo_aeroporto;
        this.cidade = cidade;
        this.pais = pais;
        this.continente = continente;
        this.classificacao = classificacao;
    }

    /**
     * Imprime um aeroporto
     * 
     * @param a - Aeroporto
     */
    public void printAeroporto(Aeroporto a) {
        System.out.println(a.getNome_aeroporto());
        System.out.println(a.getCodigo_aeroporto());
        System.out.println(a.getCidade());
        System.out.println(a.getPais());
        System.out.println(a.getContinente());
        System.out.println(a.getClassificacao());
    }

    /**
     * Procura um aviao se encontrar retorna true
     *
     * @param av
     * @return true
     */
    public boolean getAviao(Aviao av) {
        for (int i = 0; i < aviaoST.size(); i++) {
            if (aviaoST.get(i).compareTo(av) == 0) {
                return true;
            }
        }
        return false;
    }



    /**
     * Determinar os voos que tiveram como origem ou destino um determinado
     * aeroporto
     *
     * @param voosST - ST de voos
     * @param aero - Aeroporto a pesquisar
     * @return RedBlackBST com o resultado da pesquisa
     */
    public RedBlackBST<Integer, Voo> determinaVoosAero(RedBlackBST<Integer, Voo> voosST, Aeroporto aero) {

        RedBlackBST<Integer, Voo> voosAux = new RedBlackBST<>();
        for (Integer a : voosST.keys()) {
            Voo vaux = voosST.get(a);
            if ((vaux.getDestino().compareTo(aero) == 0)) {
                voosAux.put(a, vaux);
            } else if ((voosST.get(a).getOrigem().compareTo(aero) == 0)) {
                voosAux.put(a, vaux);
            }
        }
        return voosAux;
    }

    /**
     * Determinar qual o aeroporto que transportou o maior número de passageiros
     *
     * @param voosST - ST com todos os Voos
     * @return uma aeroporto
     */
    public Aeroporto determinaAeroMaisP(RedBlackBST<Integer, Voo> voosST) { //, SeparateChainingHashST<String, Aeroporto> aeroportosST
        Aeroporto aAux = null;
        voosST = this.voos;
        int nP = 0;//voosST.get(i).getAviao().getCapacidade_de_passageiros();
        for (Integer a : voosST.keys()) {
            aAux = voosST.get(a).getDestino();
            for (Integer b : aAux.getAviaoST().keys()) {
                if ((aAux.getAviaoST().get(a).getCapacidade_de_passageiros() > nP)) {
                    nP = aAux.getAviaoST().get(a).getCapacidade_de_passageiros();
                }
            }

        }
        return aAux;
    }

    /**
     * Determinar qual o voo que transportou mais passageiros
     *
     * @param voosST - ST de voos
     * @param aviaoST - ST de voos
     * @return RedBlackBST com o resultado da pesquisa
     */
    public Voo determinaVooMaisP(RedBlackBST<Integer, Voo> voosST, RedBlackBST<Integer, Aviao> aviaoST) {
        Voo vaux = null;
        int nP;
        nP = 0;//voosST.get(i).getAviao().getCapacidade_de_passageiros();
        for (Integer a : voosST.keys()) {
            vaux = voosST.get(a);
            for (Integer b : vaux.getDestino().getAviaoST().keys()) {
                //aplicar for nos aeroportos e avioes
                if ((vaux.getDestino().getAviaoST().get(b).getCapacidade_de_passageiros() > nP)) {
                    nP = vaux.getDestino().getAviaoST().get(b).getCapacidade_de_passageiros();
                }
            }

        }
        return vaux;
    }

    /**
     * Inserir um voo
     *
     * @param voosST - ST de voos
     * @param v - voo a inserir
     *
     */
    public void insertVoo(RedBlackBST<Integer, Voo> voosST, Voo v) { //Aeroporto newA, Aeroporto newB, Aviao av, Date d
        Voo vv;
        int i = voosST.size() + 1;
        vv = new Voo(v.getOrigem(), v.getDestino(), v.getAviao(), v.getData());
        voosST.put(i, vv);
    }

    /**
     * Remove um voo
     *
     * @param voosST - ST de voos
     * @param v - voo a pesquisar
     * @return - retorna o voo removido
     */
    public Voo removeVoo(RedBlackBST<Integer, Voo> voosST, Voo v) {
        for (Integer a : voosST.keys()) {
            Voo vaux = voosST.get(a);
            if (vaux.compareTo(v) == 0) {
                voosST.delete(a);
                return vaux;
            }
        }
        return null;
    }

    /**
     * Modifica um voo
     *
     * @param voosST - ST de voos
     * @param v - voo a modificar
     * @param newV - novo voo
     */
    public void modifyVoo(RedBlackBST<Integer, Voo> voosST, Voo v, Voo newV) {
        if (v.compareTo(newV) != 0) {
            for (Integer a : voosST.keys()) {
                Voo vaux = voosST.get(a);
                if (vaux.compareTo(v) == 0) {
                    vaux.setOrigem(newV.getOrigem());
                    vaux.setDestino(newV.getDestino());
                    vaux.setAviao(newV.getAviao());
                    vaux.setData(newV.getData());
                    //removeVoo(voosST,v);
                    //return;
                    if (vaux.compareTo(newV) == 0) {
                        voosST.delete(a);
                    }
                }
            }
        }
    }

    /**
     * Imprimir todas as viagens com origem/destino num determinado aeroporto
     *
     * @param voosST - ST de voos
     * @param aero - Aeroporto de origem
     * @param aero1 - Aeroporto de destino
     */
    public void printTodasViagensOrigemDestino(RedBlackBST<Integer, Voo> voosST, Aeroporto aero, Aeroporto aero1) {
        for (Integer a : voosST.keys()) {
            if ((voosST.get(a).getOrigem().compareTo(aero) == 0) && (voosST.get(a).getDestino().compareTo(aero1) == 0)) {
                System.out.println("Viagem origem: ");
                System.out.println("Nome do aeroporto: " + voosST.get(a).getOrigem().getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + voosST.get(a).getOrigem().getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + voosST.get(a).getOrigem().getCidade());
                System.out.println("Continente do aeroporto: " + voosST.get(a).getOrigem().getContinente());
                System.out.println("classificacao do aeroporto: " + voosST.get(a).getOrigem().getClassificacao());
                System.out.println("Viagem Destino: ");
                System.out.println("Nome do aeroporto: " + voosST.get(a).getDestino().getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + voosST.get(a).getDestino().getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + voosST.get(a).getDestino().getCidade());
                System.out.println("Continente do aeroporto: " + voosST.get(a).getDestino().getContinente());
                System.out.println("classificacao do aeroporto: " + voosST.get(a).getDestino().getClassificacao());
            }
        }
    }

    /**
     * Imprime todas as viagens num dado intervalo de tempo
     *
     * @param voosST
     * @param d1 - data mais antiga
     * @param d2 - data mais recente
     */
    public void printTodasViagensIT(RedBlackBST<Integer, Voo> voosST, Date d1, Date d2) {
        for (Integer a : voosST.keys()) {
            Voo vaux = voosST.get(a);
            if ((d1.getSec() <= vaux.getData().getSec() && d2.getSec() >= vaux.getData().getSec()) || (d1.getMin() <= vaux.getData().getMin() && d2.getMin() >= vaux.getData().getMin()) || (d1.getHour() <= vaux.getData().getHour() && d2.getHour() >= vaux.getData().getHour()) || (d1.getDd() <= vaux.getData().getDd() && d2.getDd() >= vaux.getData().getDd()) || (d1.getDd() <= vaux.getData().getMm() && d2.getDd() >= vaux.getData().getMm()) || (d1.getDd() <= vaux.getData().getYy() && d2.getDd() >= vaux.getData().getYy())) {
                System.out.println("Viagem origem: ");
                System.out.println("Nome do aeroporto: " + voosST.get(a).getOrigem().getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + voosST.get(a).getOrigem().getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + voosST.get(a).getOrigem().getCidade());
                System.out.println("Continente do aeroporto: " + voosST.get(a).getOrigem().getContinente());
                System.out.println("classificacao do aeroporto: " + voosST.get(a).getOrigem().getClassificacao());
                System.out.println("Viagem destino: ");
                System.out.println("Nome do aeroporto: " + voosST.get(a).getDestino().getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + voosST.get(a).getDestino().getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + voosST.get(a).getDestino().getCidade());
                System.out.println("Continente do aeroporto: " + voosST.get(a).getDestino().getContinente());
                System.out.println("classificacao do aeroporto: " + voosST.get(a).getDestino().getClassificacao());
            }
        }
    }

    /**
     * @return the nome_aeroporto
     */
    public String getNome_aeroporto() {
        return nome_aeroporto;
    }

    /**
     * @param nome_aeroporto the nome_aeroporto to set
     */
    public void setNome_aeroporto(String nome_aeroporto) {
        this.nome_aeroporto = nome_aeroporto;
    }

    /**
     * @return the codigo_aeroporto
     */
    public String getCodigo_aeroporto() {
        return codigo_aeroporto;
    }

    /**
     * @param codigo_aeroporto the codigo_aeroporto to set
     */
    public void setCodigo_aeroporto(String codigo_aeroporto) {
        this.codigo_aeroporto = codigo_aeroporto;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the continente
     */
    public String getContinente() {
        return continente;
    }

    /**
     * @param continente the continente to set
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }

    /**
     * @return the classificacao
     */
    public float getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
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

    /**
     * @return the voos
     */
    public RedBlackBST<Integer, Voo> getVoos() {
        return voos;
    }

    /**
     * @param voos the voos to set
     */
    public void setVoos(RedBlackBST<Integer, Voo> voos) {
        this.voos = voos;
    }

    @Override
    public int compareTo(Aeroporto aero) {
        if ((this.nome_aeroporto.compareTo(aero.getNome_aeroporto()) == 0)
                && (this.codigo_aeroporto.compareTo(aero.getCodigo_aeroporto()) == 0)
                && (this.cidade.compareTo(aero.getCidade()) == 0)
                && (this.continente.compareTo(aero.getContinente()) == 0)
                && (this.classificacao == aero.getClassificacao())) {
            return 0;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "nome_aeroporto=" + nome_aeroporto + ", codigo_aeroporto=" + codigo_aeroporto + ", cidade=" + cidade + ", pais=" + pais + ", continente=" + continente + ", classificacao=" + classificacao + ", voos=" + voos + '}';
    }

}
