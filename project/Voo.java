package edu.ufp.inf.aed2_1617.project;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Voo {

    private Aeroporto origem;

    private Aeroporto destino;

    private Aviao aviao;

    private Date data;

    /**
     *
     * @element-type Aeroporto
     */
    private RedBlackBST<Integer, Aviao> aviaoST = new RedBlackBST<>();
    private SeparateChainingHashST<String, Aeroporto> aeroportosST = new SeparateChainingHashST<>();

    /**
     * Constructor
     * 
     * @param origem
     * @param destino
     * @param aviao
     * @param data
     */
    public Voo(Aeroporto origem, Aeroporto destino, Aviao aviao, Date data) {
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.data = data;
    }

    
    /**
     * @param aero - aeroporto a pesquisar
     * @return - retorna o trafego
     */
    public int trafego(Aeroporto aero) {
        int traf = 0;
        RedBlackBST<Integer, Voo> voosAux = aero.getVoos();
        voosAux = aero.determinaVoosAero(voosAux, aero);
        for (Integer i : voosAux.keys()) {
            SeparateChainingHashST<String, Aeroporto> aeroportosAux = voosAux.get(i).getAeroportosST();
            for (String a : aeroportosAux.keys()) {
                if (aero.compareTo(aeroportosAux.get(a)) == 0) {
                    traf++;
                }
            }

        }
        return traf;
    }

    /**
     * Aeroporto com mais trafego
     * 
     * @param voosST - ST de voos
     * @param aeroportosST - ST de aeroportos
     * @return - Retorna o aeroporto com mais trafego
     */
    public Aeroporto maisTrafego(RedBlackBST<Integer, Voo> voosST, SeparateChainingHashST<String, Aeroporto> aeroportosST) {
        
        Aeroporto aero = null;
        
        int j = 0;
        int pos = 0;
        int[] trafarray = new int[200];
        String[] trafcod = new String[255];
        for (String a : aeroportosST.keys()) {

            for (Integer i : voosST.keys()) {
                if (aeroportosST.get(a).getCodigo_aeroporto().equals((voosST.get(i).getOrigem().getCodigo_aeroporto())) || (aeroportosST.get(a).getCodigo_aeroporto().equals((voosST.get(i).getDestino().getCodigo_aeroporto())))) {
                    j++;
                }
            }
            trafarray[pos] = j;
            trafcod[pos] = aeroportosST.get(a).getCodigo_aeroporto();
            //System.out.println( trafcod[pos] + trafarray[pos]);
            pos++;
        } 
        int maior = trafarray[0];
        int saveindex = 0;
        
        for (int c = 0; c < trafarray.length; c++) {
            if (trafarray[c] > maior) {
                maior = trafarray[c];
                saveindex = c;
            }
        }
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getCodigo_aeroporto().equals(trafcod[saveindex])) {
                return aero = aeroportosST.get(a);
            }
        }
        return null;
    }

    /**
     * Insere um Aeroporto
     *
     * @param aeroportosST - St de aeroportos
     * @param newA - Aeroporto a adicionar
     */
    public void insertAirport(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aeroporto newA) {
        aeroportosST.put(newA.getCodigo_aeroporto(), newA);
    }

    /**
     * Remove um Aeroporto
     *
     * @param aeroportosST - St de aeroportos
     * @param newA - Aeroporto a remover
     */
    public void removeAirport(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aeroporto newA) {
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(newA.getCodigo_aeroporto()) == 0) {
                aeroportosST.delete(a);
                return;
            }
        }
    }

    /**
     * Modifica um aeroporto
     * 
     * @param aeroportosST - ST com todos os Aeroportos
     * @param newA - Aeroporto existente pelo qual vamos pesquisar na ST
     * @param aer - Aeroporto com as caracteristicas que queremos mudar
     */
    public void modifyAirport(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aeroporto newA, Aeroporto aer) {
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getNome_aeroporto().compareTo(newA.getNome_aeroporto()) == 0 && aeroportosST.get(a).getCodigo_aeroporto().compareTo(newA.getCodigo_aeroporto()) == 0 && aeroportosST.get(a).getCidade().compareTo(newA.getCidade()) == 0 && aeroportosST.get(a).getPais().compareTo(newA.getPais()) == 0 && aeroportosST.get(a).getContinente().compareTo(newA.getContinente()) == 0 && aeroportosST.get(a).getClassificacao() == newA.getClassificacao()) {
                aeroportosST.get(a).setNome_aeroporto(aer.getNome_aeroporto());
                aeroportosST.get(a).setCodigo_aeroporto(aer.getCodigo_aeroporto());
                aeroportosST.get(a).setCidade(aer.getCidade());
                aeroportosST.get(a).setPais(aer.getPais());
                aeroportosST.get(a).setContinente(aer.getContinente());
                aeroportosST.get(a).setClassificacao(aer.getClassificacao());
                if (aeroportosST.get(a).compareTo(aer) == 0) {
                    aeroportosST.delete(a);
                }
            }
        }
    }

    /**
     * Inserir um aviao
     *
     * @param aero - Aeroporto a associar ao aviao
     * @param aviaoST - ST de avioes
     * @param newA - aeroporto a inserir
     */
    public void insertAirplane(Aeroporto aero, RedBlackBST<Integer, Aviao> aviaoST, Aviao newA) {
        aero.getAviaoST().put(newA.getId_aviao(), newA);
        aviaoST.put(newA.getId_aviao(), newA);
    }

    /**
     * Remover um aviao
     *
     * @param aeroportosST - ST com todos os Aeroportos
     * @param newA - aeroporto a inserir
     */
    public void removeAirplane(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aviao newA) {
        for (String a : aeroportosST.keys()) {
            RedBlackBST<Integer, Aviao> aviaoST = aeroportosST.get(a).getAviaoST();

            if (aviaoST.size() == 0) {
                System.out.println("\tSem Avioes");
            } else {
                for (Integer id : aviaoST.keys()) {
                    Aviao av = aviaoST.get(id);
                    if (av.getId_aviao() == newA.getId_aviao() && av.getModelo().compareTo(newA.getModelo()) == 0 && av.getPiloto().compareTo(newA.getPiloto()) == 0 && av.getCompanhia_aerea().compareTo(newA.getCompanhia_aerea()) == 0 && av.getVelocidade_cruzeiro() == newA.getVelocidade_cruzeiro() && av.getAltitude_cruzeiro() == newA.getAltitude_cruzeiro() && av.getDistancia_maxima() == newA.getDistancia_maxima() && av.getCod_aeroporto().compareTo(newA.getCod_aeroporto()) == 0 && av.getCapacidade_de_passageiros() == newA.getCapacidade_de_passageiros() && av.getCapacidade_do_deposito() == newA.getCapacidade_do_deposito()) {
                        aviaoST.delete(id);
                    }
                }
            }
        }
    }

    /**
     * Modificar um aviao
     *
     * @param aeroportosST - ST com todos os Aeroportos
     * @param newA - Aviao existente pelo qual vamos pesquisar na ST
     * @param air - Aviao com as caracteristicas que queremos mudar
     */
    public void modifyAirplane(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aviao newA, Aviao air) {
        for (String a : aeroportosST.keys()) {
            RedBlackBST<Integer, Aviao> aviaoST = aeroportosST.get(a).getAviaoST();

            if (aviaoST.size() == 0) {
                System.out.println("\tSem Avioes");
            } else {
                for (Integer id : aviaoST.keys()) {
                    Aviao av = aviaoST.get(id);
                    if (av.compareTo(newA) == 0) { 
                        av.setModelo(air.getModelo());
                        av.setPiloto(air.getPiloto());
                        av.setCompanhia_aerea(air.getCompanhia_aerea());
                        av.setVelocidade_cruzeiro(air.getVelocidade_cruzeiro());
                        av.setAltitude_cruzeiro(air.getAltitude_cruzeiro());
                        av.setDistancia_maxima(air.getDistancia_maxima());
                        av.setCod_aeroporto(air.getCod_aeroporto());
                        av.setCapacidade_de_passageiros(air.getCapacidade_de_passageiros());
                        av.setCapacidade_do_deposito(air.getCapacidade_do_deposito());
                        if (aviaoST.get(id).compareTo(air) == 0) {
                            aviaoST.delete(id);
                        }
                    }
                }
            }
        }
    }

    /**
     * Imprimir todas as viagens realizadas por um determinado avião
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param airplane - aviao a procurar
     */
    public void printAviaoSpecific(SeparateChainingHashST<String, Aeroporto> aeroportosST, Aviao airplane) {
        Aeroporto aeroAux = null;
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(airplane.getCod_aeroporto()) == 0) {
                aeroAux = aeroportosST.get(a);
                break;
            }
        }
        System.out.println("Nome do aeroporto: " + aeroAux.getNome_aeroporto());
        System.out.println("Codigo do aeroporto: " + aeroAux.getCodigo_aeroporto());
        System.out.println("Cidade do aeroporto: " + aeroAux.getCidade());
        System.out.println("Continente do aeroporto: " + aeroAux.getContinente());
        System.out.println("classificacao do aeroporto: " + aeroAux.getClassificacao());
        RedBlackBST<Integer, Aviao> avioesST = aeroAux.getAviaoST();

        if (avioesST.size() == 0) {
            System.out.println("\tSem Avioes");
            return;
        } else {
            System.out.println("\tAvioes:");
            for (Integer id : avioesST.keys()) {
                Aviao av = avioesST.get(id);
                if (av.getId_aviao().equals(airplane.getId_aviao())) {
                    System.out.println("\t\tId do aviao: " + av.getId_aviao());
                    System.out.println("\t\tModelo: " + av.getModelo());
                    System.out.println("\t\tPiloto: " + av.getPiloto());
                    System.out.println("\t\tCompanhia Aerea: " + av.getCompanhia_aerea());
                    System.out.println("\t\tVelocidade_cruzeiro: " + av.getVelocidade_cruzeiro());
                    System.out.println("\t\tAltitude_cruzeiro: " + av.getAltitude_cruzeiro());
                    System.out.println("\t\tDistancia_maxima: " + av.getDistancia_maxima());
                    System.out.println("\t\tCod_aeroporto: " + av.getCod_aeroporto());
                    System.out.println("\t\tCapacidade_de_passageiros: " + av.getCapacidade_de_passageiros());
                    System.out.println("\t\tCapacidade_do_deposito: " + av.getCapacidade_do_deposito());
                }
            }
        }
        System.out.println("");

    }

    /**
     * Imprimir toda a informação dos aeroportos
     *
     * @param aviaoST - ST com todos os avioes
     * @param aeroportosST - ST com todos os aeroportos
     */
    public void printAeroportos(RedBlackBST<Integer, Aviao> aviaoST, SeparateChainingHashST<String, Aeroporto> aeroportosST) {

        for (String a : aeroportosST.keys()) {
            System.out.println("Nome do aeroporto: " + aeroportosST.get(a).getNome_aeroporto());
            System.out.println("Codigo do aeroporto: " + aeroportosST.get(a).getCodigo_aeroporto());
            System.out.println("Cidade do aeroporto: " + aeroportosST.get(a).getCidade());
            System.out.println("Continente do aeroporto: " + aeroportosST.get(a).getContinente());
            System.out.println("classificacao do aeroporto: " + aeroportosST.get(a).getClassificacao());
            RedBlackBST<Integer, Aviao> avioesST = aeroportosST.get(a).getAviaoST();

            if (aviaoST.size() == 0) {
                System.out.println("\tSem Avioes");
                break;
            } else {
                System.out.println("\tAvioes:");
                for (Integer id : avioesST.keys()) {
                    Aviao av = avioesST.get(id);
                    if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(av.getCod_aeroporto()) == 0) {
                        System.out.println("\t\tId do aviao: " + av.getId_aviao());
                        System.out.println("\t\tModelo: " + av.getModelo());
                        System.out.println("\t\tPiloto: " + av.getPiloto());
                        System.out.println("\t\tCompanhia Aerea: " + av.getCompanhia_aerea());
                        System.out.println("\t\tVelocidade_cruzeiro: " + av.getVelocidade_cruzeiro());
                        System.out.println("\t\tAltitude_cruzeiro: " + av.getAltitude_cruzeiro());
                        System.out.println("\t\tDistancia_maxima: " + av.getDistancia_maxima());
                        System.out.println("\t\tCod_aeroporto: " + av.getCod_aeroporto());
                        System.out.println("\t\tCapacidade_de_passageiros: " + av.getCapacidade_de_passageiros());
                        System.out.println("\t\tCapacidade_do_deposito: " + av.getCapacidade_do_deposito());
                    }
                }
            }
            System.out.println("");
        }
    }

    /**
     * Imprimir toda a informação relativa a um determinado aeroporto
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param codAeroporto -código do aeroporto a porcurar
     */
    public void printAeroportoSpecific(SeparateChainingHashST<String, Aeroporto> aeroportosST, String codAeroporto) {
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(codAeroporto) == 0) {
                System.out.println("Nome do aeroporto: " + aeroportosST.get(a).getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + aeroportosST.get(a).getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + aeroportosST.get(a).getCidade());
                System.out.println("Continente do aeroporto: " + aeroportosST.get(a).getContinente());
                System.out.println("classificacao do aeroporto: " + aeroportosST.get(a).getClassificacao());
                RedBlackBST<Integer, Aviao> aviaoesST = aeroportosST.get(a).getAviaoST();

                if (aviaoesST.size() == 0) {
                    System.out.println("\tSem Avioes");
                } else {
                    System.out.println("\tAvioes:");
                    for (Integer id : aviaoesST.keys()) {
                        Aviao av = aviaoesST.get(id);
                        if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(av.getCod_aeroporto()) == 0) {
                            System.out.println("\t\tId do aviao: " + av.getId_aviao());
                            System.out.println("\t\tModelo: " + av.getModelo());
                            System.out.println("\t\tPiloto: " + av.getPiloto());
                            System.out.println("\t\tCompanhia Aerea: " + av.getCompanhia_aerea());
                            System.out.println("\t\tVelocidade_cruzeiro: " + av.getVelocidade_cruzeiro());
                            System.out.println("\t\tAltitude_cruzeiro: " + av.getAltitude_cruzeiro());
                            System.out.println("\t\tDistancia_maxima: " + av.getDistancia_maxima());
                            System.out.println("\t\tCod_aeroporto: " + av.getCod_aeroporto());
                            System.out.println("\t\tCapacidade_de_passageiros: " + av.getCapacidade_de_passageiros());
                            System.out.println("\t\tCapacidade_do_deposito: " + av.getCapacidade_do_deposito());
                        }
                    }
                }
                System.out.println("");
            }
        }
    }

    /**
     * Imprimir todos os aeroportos de um determinado país
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param pais - pais a pesquisar
     */
    public void printAeroportoPais(SeparateChainingHashST<String, Aeroporto> aeroportosST, String pais) {
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getPais().compareTo(pais) == 0) {
                System.out.println("Nome do aeroporto: " + aeroportosST.get(a).getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + aeroportosST.get(a).getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + aeroportosST.get(a).getCidade());
                System.out.println("Continente do aeroporto: " + aeroportosST.get(a).getContinente());
                System.out.println("classificacao do aeroporto: " + aeroportosST.get(a).getClassificacao());
                RedBlackBST<Integer, Aviao> aviaoST = aeroportosST.get(a).getAviaoST();

                if (aviaoST.size() == 0) {
                    System.out.println("\tSem Avioes");
                } else {
                    System.out.println("\tAvioes:");
                    for (Integer id : aviaoST.keys()) {
                        Aviao av = aviaoST.get(id);
                        if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(av.getCod_aeroporto()) == 0) {
                            System.out.println("\t\tId do aviao: " + av.getId_aviao());
                            System.out.println("\t\tModelo: " + av.getModelo());
                            System.out.println("\t\tPiloto: " + av.getPiloto());
                            System.out.println("\t\tCompanhia Aerea: " + av.getCompanhia_aerea());
                            System.out.println("\t\tVelocidade_cruzeiro: " + av.getVelocidade_cruzeiro());
                            System.out.println("\t\tAltitude_cruzeiro: " + av.getAltitude_cruzeiro());
                            System.out.println("\t\tDistancia_maxima: " + av.getDistancia_maxima());
                            System.out.println("\t\tCod_aeroporto: " + av.getCod_aeroporto());
                            System.out.println("\t\tCapacidade_de_passageiros: " + av.getCapacidade_de_passageiros());
                            System.out.println("\t\tCapacidade_do_deposito: " + av.getCapacidade_do_deposito());
                        }
                    }
                }
                System.out.println("");
            }
        }
    }

    /**
     * Imprimir todos os aeroportos de um determinado continente
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param continente - continete a pesquisar
     */
    public void printAeroportoContinente(SeparateChainingHashST<String, Aeroporto> aeroportosST, String continente) {
        for (String a : aeroportosST.keys()) {
            if (aeroportosST.get(a).getContinente().compareTo(continente) == 0) {
                System.out.println("Nome do aeroporto: " + aeroportosST.get(a).getNome_aeroporto());
                System.out.println("Codigo do aeroporto: " + aeroportosST.get(a).getCodigo_aeroporto());
                System.out.println("Cidade do aeroporto: " + aeroportosST.get(a).getCidade());
                System.out.println("Continente do aeroporto: " + aeroportosST.get(a).getContinente());
                System.out.println("classificacao do aeroporto: " + aeroportosST.get(a).getClassificacao());
                RedBlackBST<Integer, Aviao> aviaoST = aeroportosST.get(a).getAviaoST();

                if (aviaoST.size() == 0) {
                    System.out.println("\tSem Avioes");
                } else {
                    System.out.println("\tAvioes:");
                    for (Integer id : aviaoST.keys()) {
                        Aviao av = aviaoST.get(id);
                        if (aeroportosST.get(a).getCodigo_aeroporto().compareTo(av.getCod_aeroporto()) == 0) {
                            System.out.println("\t\tId do aviao: " + av.getId_aviao());
                            System.out.println("\t\tModelo: " + av.getModelo());
                            System.out.println("\t\tPiloto: " + av.getPiloto());
                            System.out.println("\t\tCompanhia Aerea: " + av.getCompanhia_aerea());
                            System.out.println("\t\tVelocidade_cruzeiro: " + av.getVelocidade_cruzeiro());
                            System.out.println("\t\tAltitude_cruzeiro: " + av.getAltitude_cruzeiro());
                            System.out.println("\t\tDistancia_maxima: " + av.getDistancia_maxima());
                            System.out.println("\t\tCod_aeroporto: " + av.getCod_aeroporto());
                            System.out.println("\t\tCapacidade_de_passageiros: " + av.getCapacidade_de_passageiros());
                            System.out.println("\t\tCapacidade_do_deposito: " + av.getCapacidade_do_deposito());
                        }
                    }
                }
                System.out.println("");
            }
        }
    }

    /**
     * @return the origem
     */
    public Aeroporto getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public Aeroporto getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    /**
     * @return the aviao
     */
    public Aviao getAviao() {
        return aviao;
    }

    /**
     * @param aviao the aviao to set
     */
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
     * @return the aeroportosST
     */
    public SeparateChainingHashST<String, Aeroporto> getAeroportosST() {
        return aeroportosST;
    }

    /**
     * @param aAeroportosST the aeroportosST to set
     */
    public void setAeroportosST(SeparateChainingHashST<String, Aeroporto> aAeroportosST) {
        aeroportosST = aAeroportosST;
    }

    @Override
    public String toString() {
        return "Voo{" + "origem=" + origem + ", destino=" + destino + ", aviao=" + aviao + ", data=" + data + '}';
    }

    public int compareTo(Voo v) {
        if ((this.origem.compareTo(v.getOrigem()) == 0)
                && (this.destino.compareTo(v.getDestino()) == 0)
                && (this.aviao.compareTo(v.getAviao()) == 0)
                && (this.data.compareTo(v.getData()) == 0)) {
            return 0;
        }

        return -1;
    }
}
