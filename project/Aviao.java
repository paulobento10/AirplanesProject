package edu.ufp.inf.aed2_1617.project;

import edu.princeton.cs.algs4.RedBlackBST;

public class Aviao implements Comparable<Aviao> {

    private Integer id_aviao;

    private String modelo;

    private String piloto;

    private String companhia_aerea;

    private int velocidade_cruzeiro;

    private int altitude_cruzeiro;

    private int distancia_maxima;

    private String cod_aeroporto;

    private int capacidade_de_passageiros;

    private int capacidade_do_deposito;

    /**
     *
     * @element-type Voo
     */
    private RedBlackBST<Integer, Voo> voos = new RedBlackBST<>();

    /**
     * Constructor
     * 
     * @param id_aviao
     * @param modelo
     * @param piloto
     * @param companhia_aerea
     * @param velocidade_cruzeiro
     * @param altitude_cruzeiro
     * @param distancia_maxima
     * @param cod_aeroporto
     * @param capacidade_de_passageiros
     * @param capacidade_do_deposito
     */
    public Aviao(Integer id_aviao, String modelo, String piloto, String companhia_aerea, int velocidade_cruzeiro, int altitude_cruzeiro, int distancia_maxima, String cod_aeroporto, int capacidade_de_passageiros, int capacidade_do_deposito) {
        this.id_aviao = id_aviao;
        this.modelo = modelo;
        this.piloto = piloto;
        this.companhia_aerea = companhia_aerea;
        this.velocidade_cruzeiro = velocidade_cruzeiro;
        this.altitude_cruzeiro = altitude_cruzeiro;
        this.distancia_maxima = distancia_maxima;
        this.cod_aeroporto = cod_aeroporto;
        this.capacidade_de_passageiros = capacidade_de_passageiros;
        this.capacidade_do_deposito = capacidade_do_deposito;
    }

    /**
     * Calcular o custo de uma viagem com determinada distância e numa
     * determinada altitude tendo em conta a velocidade do vento para um
     * determinado avião.
     *
     * @param v - voo
     * @param n - custo do combustivel
     * @param velocidadeVento - velocidade do vento\
     * @return - custo de uma viagem com determinada distância e numa
     * determinada altitude
     * @return consumo
     */
    public int consumo(Voo v, int n, int velocidadeVento) {
        int consumo = 0;
        if (v.getAviao().getAltitude_cruzeiro() > this.altitude_cruzeiro) {
            consumo += (n * (v.getAviao().getAltitude_cruzeiro() - this.altitude_cruzeiro));
        } else if (v.getAviao().getAltitude_cruzeiro() < this.altitude_cruzeiro) {
            consumo += (n * (this.altitude_cruzeiro - v.getAviao().getAltitude_cruzeiro()));
        }

        if (velocidadeVento < 0) {
            consumo -= 20;
        } else {
            consumo += 20;
        }
        return consumo;
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
                }
            }
        }
    }

    /**
     * Imprimir todas as viagens realizadas por um determinado avião
     *
     * @param voosST - ST de voos
     * @param av - Aviao a pesquisar
     */
    public void printTodasViagensAviao(RedBlackBST<Integer, Voo> voosST, Aviao av) {
        for (Integer a : voosST.keys()) {
            if ((voosST.get(a).getAviao().compareTo(av) == 0)) {
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
     * @return the id_aviao
     */
    public Integer getId_aviao() {
        return id_aviao;
    }

    /**
     * @param id_aviao the id_aviao to set
     */
    public void setId_aviao(Integer id_aviao) {
        this.id_aviao = id_aviao;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the piloto
     */
    public String getPiloto() {
        return piloto;
    }

    /**
     * @param piloto the piloto to set
     */
    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    /**
     * @return the companhia_aerea
     */
    public String getCompanhia_aerea() {
        return companhia_aerea;
    }

    /**
     * @param companhia_aerea the companhia_aerea to set
     */
    public void setCompanhia_aerea(String companhia_aerea) {
        this.companhia_aerea = companhia_aerea;
    }

    /**
     * @return the velocidade_cruzeiro
     */
    public int getVelocidade_cruzeiro() {
        return velocidade_cruzeiro;
    }

    /**
     * @param velocidade_cruzeiro the velocidade_cruzeiro to set
     */
    public void setVelocidade_cruzeiro(int velocidade_cruzeiro) {
        this.velocidade_cruzeiro = velocidade_cruzeiro;
    }

    /**
     * @return the altitude_cruzeiro
     */
    public int getAltitude_cruzeiro() {
        return altitude_cruzeiro;
    }

    /**
     * @param altitude_cruzeiro the altitude_cruzeiro to set
     */
    public void setAltitude_cruzeiro(int altitude_cruzeiro) {
        this.altitude_cruzeiro = altitude_cruzeiro;
    }

    /**
     * @return the distancia_maxima
     */
    public int getDistancia_maxima() {
        return distancia_maxima;
    }

    /**
     * @param distancia_maxima the distancia_maxima to set
     */
    public void setDistancia_maxima(int distancia_maxima) {
        this.distancia_maxima = distancia_maxima;
    }

    /**
     * @return the cod_aeroporto
     */
    public String getCod_aeroporto() {
        return cod_aeroporto;
    }

    /**
     * @param cod_aeroporto the cod_aeroporto to set
     */
    public void setCod_aeroporto(String cod_aeroporto) {
        this.cod_aeroporto = cod_aeroporto;
    }

    /**
     * @return the capacidade_de_passageiros
     */
    public int getCapacidade_de_passageiros() {
        return capacidade_de_passageiros;
    }

    /**
     * @param capacidade_de_passageiros the capacidade_de_passageiros to set
     */
    public void setCapacidade_de_passageiros(int capacidade_de_passageiros) {
        this.capacidade_de_passageiros = capacidade_de_passageiros;
    }

    /**
     * @return the capacidade_do_deposito
     */
    public int getCapacidade_do_deposito() {
        return capacidade_do_deposito;
    }

    /**
     * @param capacidade_do_deposito the capacidade_do_deposito to set
     */
    public void setCapacidade_do_deposito(int capacidade_do_deposito) {
        this.capacidade_do_deposito = capacidade_do_deposito;
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
    public int compareTo(Aviao o) {
        if ((this.id_aviao == o.getId_aviao())
                && (this.modelo.compareTo(o.getModelo()) == 0)
                && (this.piloto.compareTo(o.getPiloto()) == 0)
                && (this.companhia_aerea.compareTo(o.getCompanhia_aerea()) == 0)
                && (this.velocidade_cruzeiro == o.getVelocidade_cruzeiro())
                && (this.altitude_cruzeiro == o.getAltitude_cruzeiro())
                && (this.distancia_maxima == o.getDistancia_maxima())
                && (this.cod_aeroporto.compareTo(o.getCod_aeroporto()) == 0)
                && (this.capacidade_de_passageiros == o.getCapacidade_de_passageiros())
                && (this.capacidade_do_deposito == o.getCapacidade_do_deposito())) {
            return 0;
        }
        return -1;
    }

}
