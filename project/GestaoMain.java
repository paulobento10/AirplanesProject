package edu.ufp.inf.aed2_1617.project;





import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.Scanner;

/*
        Created By : Paulo Bento Nº 33959 Pedro Costa Nº 31179
*/


public class GestaoMain {

    public static void main(String[] args) {
        //Aeroporto a = new Aeroporto("Ben Gurion", "TLV", "Tel Aviv", "Israel", "Asia", (float) 10.0);
        //a.printAeroporto(a);
        /*int  alt=0;
            System.out.println("Bem vindo");
            System.out.println("O que pretende fazer\n");
            System.out.println("1-Adicionar");
            System.out.println("2-Remover");
            System.out.println("3-editar");
            
            Scanner scanIn = new Scanner(System.in);
            alt =  scanIn.nextInt();
            
            switch(alt)
            {
                case 1:
                        System.out.println("O que pretende fazer\n");
                        System.out.println("1-Adicionar voos");
                        System.out.println("2-Adicionar aeroportos");
                        System.out.println("1-Adicionar avioes");
                        alt =  scanIn.nextInt();
                        if(alt==1)
                        {
                             System.out.println("Atenção só pode adicionar um voo com aeroportos\n");
                             
                            
                            
                        }
                        if(alt==2)                            
                        {
                            System.out.println("Insira os dados do aeroporto\n");
                            System.out.println("Nome do aeroporto\n");
                            String nome = scanIn.nextLine();
                            System.out.println("codigo do aeroporto\n");
                            String code= scanIn.nextLine();
                            System.out.println("cidade do aeroporto\n");
                            String city= scanIn.nextLine();
                            System.out.println("pais do aeroporto\n");
                            String pais= scanIn.nextLine();
                            System.out.println("continente do aeroporto\n");
                            String continente= scanIn.nextLine();
                            System.out.println("classificação do aeroporto\n");
                            float classi = scanIn.nextFloat();
                            Aeroporto aero = new Aeroporto(nome, code, city, pais, continente, classi);
                        }
                        if(alt==3)
                        {
                            
                            
                            
                        }
            }*/

        System.out.println("A informação vai ser carregada do ficheiro");
        //writeFileAeroportos(aeroportosST,"C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\aeroportos.txt");
        //writeFileAvioes(aviaoST,"C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\avioes.txt");
        Aviao av = new Aviao(1, "Airbus A340", "Fernão Mendes Pinto", "TAP Air Portugal", 871, 8000, 16700, "OPO", 380, 274876);
        Aviao av1 = new Aviao(29, "ATR 72", "Apasara", "Thai Airways", 511, 5000, 1528, "KBP", 74, 5700);
        Aviao avi = new Aviao(38, "Airbus Z", "piloto", "Air", 0, 0, 0, "A", 0, 0);
        Aviao AV = new Aviao(39, "Airbus AV", "piloto AV", "Air", 10, 10, 10, "OPO", 10, 10);
        Aeroporto aero = new Aeroporto("Francisco Sá Carneiro", "OPO", "Porto", "Portugal", "Europe", (float) 9.8);
        Aeroporto aero1 = new Aeroporto("Frankfurt", "FRA", "Frankfurt", "Germany", "Europe", (float) 9.6);
        Aeroporto aero2 = new Aeroporto("A", "A", "A", "A", "A", (float) 0.0);
        Aeroporto aero3 = new Aeroporto("Boryspil", "KBP", "Kiev", "Ukraine", "Europe", (float) 8.0);
        Aeroporto aero4 = new Aeroporto("Beijing International", "PEK", "Beijing", "China", "Asia", (float) 9.8);
        //insertVoo(voosST, aero, aero1, av);
        //voosST.put(1, new Voo(aero, aero1, av, new Date()));
        Voo vvaux = new Voo(aero, aero1, av, new Date());
        Voo v = new Voo(aero1, aero, av, new Date());
        Voo v1 = new Voo(aero, aero3, av, new Date());
        Voo v2 = new Voo(aero4, aero, av, new Date());
        Voo v3 = new Voo(aero2, aero, av1, new Date());
        Voo vv = new Voo(aero3, aero4, av, new Date());

        loadFromFileAirports(v.getAeroportosST(), "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\airports.txt");
        loadFromFileAirplanes(v.getAeroportosST(), v.getAviaoST(), "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\airplanes.txt");
        //v.printAeroportoContinente(v.getAeroportosST(), "Europe");
        //v.printAeroportoPais(v.getAeroportosST(), "Portugal");
        //v.printAeroportoSpecific(v.getAeroportosST(), "OPO");
        //v.printAeroportos(v.getAviaoST(), v.getAeroportosST());
        //v1.printAeroportos(v1.getAviaoST(), v1.getAeroportosST());
        v.insertAirplane(aero, v.getAviaoST(), AV);
        v.insertAirplane(aero, v.getAviaoST(), avi);
        //v.printAviaoSpecific(v.getAeroportosST(), AV);
        //v.removeAirplane(v.getAeroportosST(), av);
        //v.modifyAirplane(v.getAeroportosST(), av,AV);
        v.printAviaoSpecific(v.getAeroportosST(), av);
        v.insertAirport(v.getAeroportosST(), aero2);
        //v.modifyAirport(v.getAeroportosST(), aero, aero2);
        //v.removeAirport(v.getAeroportosST(), aero2);
        //v.printAeroportoSpecific(v.getAeroportosST(), "FRA");
        //Aeroporto aeroAux = v.maisTrafego(aero.getVoos());

        //av.insertVoo(av.getVoos(), vvaux);
        //av.insertVoo(av.getVoos(), v);
        //av.insertVoo(av.getVoos(), vv);
        av.insertVoo(av.getVoos(), v);
        //av.insertVoo(av.getVoos(), v2);
        //av.insertVoo(av.getVoos(), v3);

        //av.modifyVoo(av.getVoos(), v, vv);
        //av.removeVoo(av.getVoos(), vv);
        //av.printTodasViagensAviao(av.getVoos(), av);
        //System.out.println(av.consumo(v, 200, 20));
        //aero.insertVoo(aero.getVoos(), v);
        //aero.insertVoo(aero.getVoos(), vvaux);
        //aero.insertVoo(aero.getVoos(), vv);
        aero.insertVoo(aero.getVoos(), v);
        //aero.insertVoo(aero.getVoos(), v2);
        //aero.insertVoo(aero.getVoos(), v3);
        //aero.modifyVoo(aero.getVoos(), v,vv);
        //aero.removeVoo(aero.getVoos(), vv);
        Date today = new Date();
        Date tomorrow = new Date(today.getSec() + 1, today.getMin() + 1, today.getHour() + 1, today.getDd() + 1, today.getMm() + 1, today.getYy() + 1);
        //aero.printTodasViagensIT(aero.getVoos(), today, tomorrow);
        //aero.printTodasViagensOrigemDestino(aero.getVoos(), aero, aero1);
        //RedBlackBST<Integer, Voo> voosAux = aero.determinaVoosAero(aero.getVoos(), aero);
        //aero.printTodasViagensOrigemDestino(voosAux, aero,aero1);
        //Voo vMax = aero.determinaVooMaisP(aero.getVoos(),aero.getAviaoST());
        //System.out.println("Voo  com mais passageiros: " + vMax.toString());
        //Aeroporto aeroMax = aero.determinaAeroMaisP(aero.getVoos());
        //System.out.println("Aeroporto com mais passageiros: " + aeroMax.toString());

        Aeroporto aeroAux = v.maisTrafego(aero.getVoos(), v.getAeroportosST());
        System.out.println("O aeroporto com mais trafego e: "+aeroAux.getNome_aeroporto());

        writeFileAeroportos(v.getAeroportosST(), "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\airports.txt");
        writeFileAvioes(v.getAviaoST(), "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\airplanes.txt");
        writeFileVoos(v.getAeroportosST(), v.getAviaoST(), aero.getVoos(), "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\aed2_1617\\src\\edu\\ufp\\inf\\aed2_1617\\project\\data\\voos.txt");
    }

    private static void loadFromFileVoos(RedBlackBST<Integer, Voo> voosST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
    }

    /**
     * Funcao que carrega os dados de um ficheiro de texto com informação de
     * aeroportos
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param path - Diretorio do ficheiro
     */
    public static void loadFromFileAirports(SeparateChainingHashST<String, Aeroporto> aeroportosST, String path) {

        In in = new In(path); // abertura do ficheiro/stream de entrada
        float classificacao = (float) 0.0;
        while (!in.isEmpty()) {

            String[] texto = in.readLine().split(";");
            //Integer id = Integer.parseInt(texto[0]);
            String nome_aeroporto = texto[0];
            String codigo_aeroporto = texto[1];
            String cidade = texto[2];
            String pais = texto[3];
            String continente = texto[4];
            try {
                String auxfloat = texto[5];
                auxfloat = auxfloat.trim();
                classificacao = Float.parseFloat(auxfloat);
            } catch (NumberFormatException ex) {
                classificacao = (float) 0.0;
            }

            Aeroporto a = new Aeroporto(nome_aeroporto, codigo_aeroporto, cidade, pais, continente, classificacao);

            aeroportosST.put(nome_aeroporto, a);
        }
    }

    /**
     * Funcao que carrega os dados de um ficheiro de texto com informação de
     * aviaoes
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param aviaoST - ST com todos os avioes
     * @param path - Diretorio do ficheiro
     */
    public static void loadFromFileAirplanes(SeparateChainingHashST<String, Aeroporto> aeroportosST, RedBlackBST<Integer, Aviao> aviaoST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
        Integer velocidade_cruzeiro = 0;
        Integer altitude_cruzeiro = 0;
        Integer distancia_maxima = 0;
        Integer capacidade_de_passageiros = 0;
        Integer capacidade_do_deposito = 0;
        Integer id_aviao = 0;
        while (!in.isEmpty()) {

            String[] texto = in.readLine().split(";");
            try {
                id_aviao = Integer.parseInt(texto[0]);
            } catch (NumberFormatException ex) {
                id_aviao = 0;
            }
            String modelo = texto[1];
            String piloto = texto[2];
            String companhia_aerea = texto[3];
            try {
                velocidade_cruzeiro = Integer.parseInt(texto[4]);
                altitude_cruzeiro = Integer.parseInt(texto[5]);
                distancia_maxima = Integer.parseInt(texto[6]);
            } catch (NumberFormatException ex) {
                velocidade_cruzeiro = 0;
                altitude_cruzeiro = 0;
                distancia_maxima = 0;
            }
            String cod_aeroporto = texto[7];
            try {
                capacidade_de_passageiros = Integer.parseInt(texto[8]);
                capacidade_do_deposito = Integer.parseInt(texto[9]);
            } catch (NumberFormatException ex) {
                capacidade_de_passageiros = 0;
                capacidade_do_deposito = 0;
            }
            Aviao av = new Aviao(id_aviao, modelo, piloto, companhia_aerea, velocidade_cruzeiro, altitude_cruzeiro, distancia_maxima, cod_aeroporto, capacidade_de_passageiros, capacidade_do_deposito);
            aviaoST.put(id_aviao, av);
            for (String a : aeroportosST.keys()) {
                Aeroporto aer = aeroportosST.get(a);
                aeroportosST.put(a, aer);
                for (Integer i : aviaoST.keys()) {
                    Aviao aaux = aviaoST.get(i);
                    if (aaux.getCod_aeroporto().equals(aer.getCodigo_aeroporto())) {
                        aeroportosST.get(a).getAviaoST().put(i, aaux);
                    }
                }
            }
        }
    }

    /**
     * Funcao que grava os dados para um ficheiro de texto com informação de
     * aeroportos
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param path - Diretorio do ficheiro
     */
    public static void writeFileAeroportos(SeparateChainingHashST<String, Aeroporto> aeroportosST, String path) {
        Out out = new Out(path);

        for (String a : aeroportosST.keys()) {
            out.print(aeroportosST.get(a).getNome_aeroporto() + ";");
            out.print(aeroportosST.get(a).getCodigo_aeroporto() + ";");
            out.print(aeroportosST.get(a).getCidade() + ";");
            out.print(aeroportosST.get(a).getPais() + ";");
            out.print(aeroportosST.get(a).getContinente() + ";");
            out.print(aeroportosST.get(a).getClassificacao() + ";");
            out.println();
        }
        out.close();
    }

    /**
     * Funcao que grava os dados para de um ficheiro de texto com informação de
     * aviaoes
     *
     * @param aviaoST - ST com todos os avioes
     * @param path - Diretorio do ficheiro
     */
    public static void writeFileAvioes(RedBlackBST<Integer, Aviao> aviaoST, String path) {
        Out out = new Out(path);

        for (Integer a : aviaoST.keys()) {
            out.print(aviaoST.get(a).getId_aviao() + ";");
            out.print(aviaoST.get(a).getModelo() + ";");
            out.print(aviaoST.get(a).getPiloto() + ";");
            out.print(aviaoST.get(a).getCompanhia_aerea() + ";");
            out.print(aviaoST.get(a).getVelocidade_cruzeiro() + ";");
            out.print(aviaoST.get(a).getAltitude_cruzeiro() + ";");
            out.print(aviaoST.get(a).getDistancia_maxima() + ";");
            out.print(aviaoST.get(a).getCod_aeroporto() + ";");
            out.print(aviaoST.get(a).getCapacidade_de_passageiros() + ";");
            out.print(aviaoST.get(a).getCapacidade_do_deposito() + ";");
            out.println();
        }
        out.close();
    }

    /**
     * Funcao que grava os dados para de um ficheiro de texto com informação de
     * voos
     *
     * @param aeroportosST - ST com todos os aeroportos
     * @param aviaoST - ST com todos os avioes
     * @param voosST - ST com todos os voos
     * @param path - Diretorio do ficheiro
     */
    public static void writeFileVoos(SeparateChainingHashST<String, Aeroporto> aeroportosST, RedBlackBST<Integer, Aviao> aviaoST, RedBlackBST<Integer, Voo> voosST, String path) {
        Out out = new Out(path);

        for (Integer a : voosST.keys()) {
            for (String b : aeroportosST.keys()) {

                if ((aeroportosST.get(b).compareTo(voosST.get(a).getDestino()) == 0) || (aeroportosST.get(b).compareTo(voosST.get(a).getOrigem()) == 0)) {
                    out.print(aeroportosST.get(b).getNome_aeroporto() + ";");
                    out.print(aeroportosST.get(b).getCodigo_aeroporto() + ";");
                    out.print(aeroportosST.get(b).getCidade() + ";");
                    out.print(aeroportosST.get(b).getPais() + ";");
                    out.print(aeroportosST.get(b).getContinente() + ";");
                    out.print(aeroportosST.get(b).getClassificacao() + ";");
                    out.println();
                    //RedBlackBST<Integer, Aviao> aviaoAuxST = aeroportosAuxST.get(b).getAviaoST();
                    for (Integer c : aviaoST.keys()) {
                        if (aeroportosST.get(b).getCodigo_aeroporto().compareTo(aviaoST.get(c).getCod_aeroporto()) == 0) {
                            out.print(aviaoST.get(c).getId_aviao() + ";");
                            out.print(aviaoST.get(c).getModelo() + ";");
                            out.print(aviaoST.get(c).getPiloto() + ";");
                            out.print(aviaoST.get(c).getCompanhia_aerea() + ";");
                            out.print(aviaoST.get(c).getVelocidade_cruzeiro() + ";");
                            out.print(aviaoST.get(c).getAltitude_cruzeiro() + ";");
                            out.print(aviaoST.get(c).getDistancia_maxima() + ";");
                            out.print(aviaoST.get(c).getCod_aeroporto() + ";");
                            out.print(aviaoST.get(c).getCapacidade_de_passageiros() + ";");
                            out.print(aviaoST.get(c).getCapacidade_do_deposito() + ";");
                            out.println();
                        }
                    }
                }
            }

            out.print(voosST.get(a).getData().getSec() + ";");
            out.print(voosST.get(a).getData().getMin() + ";");
            out.print(voosST.get(a).getData().getHour() + ";");
            out.print(voosST.get(a).getData().getDd() + ";");
            out.print(voosST.get(a).getData().getMm() + ";");
            out.print(voosST.get(a).getData().getYy() + ";");
            out.println();
        }
        out.close();
    }
}
