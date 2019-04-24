package com.infosistemas.veiculo.service;

import com.infosistemas.veiculo.bean.Veiculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VeiculoService {

    private static final String CAMINHO_ARQUIVO_IMPRESSAO = "C:\\temp\\infosistemas.txt";
    static HashMap<Integer,Veiculo> veiculoIdMap = getVeiculoIdMap();

    public VeiculoService()
    {

        super();

        if(veiculoIdMap == null)
        {
            veiculoIdMap = new HashMap<>();

            Veiculo veiculo1 = new Veiculo(1998, "HLD-2546", "9BWZZZ377VT004251", "Ka", "Ford", 58594354775L);
            Veiculo veiculo2 = new Veiculo(2009, "RED-2546", "8BWZZZ377VT005241", "Gol", "VW", 25594354775L);
            Veiculo veiculo3 = new Veiculo(2018, "POP-7890", "1GTYUU377VT365214", "Uno", "Fiat", 60594354775L);
            Veiculo veiculo4 = new Veiculo(2015, "RED-2546", "7REAQW377VT521423", "Prisma", "GM", 95194354775L);

            addVeiculo(veiculo1);
            addVeiculo(veiculo2);
            addVeiculo(veiculo3);
            addVeiculo(veiculo4);
        }
    }

    public List<Veiculo> getVeiculos()
    {
        return new ArrayList<>(veiculoIdMap.values());
    }

    public Veiculo getVeiculo(int id)
    {
        return  veiculoIdMap.get(id);
    }

    public Veiculo addVeiculo(Veiculo veiculo)
    {
        int menorIdDisponivel = 1;

        for (int i=1; i<= veiculoIdMap.size()+1; i++) {

            if (!veiculoIdMap.containsKey(i)) {
                menorIdDisponivel = i;
                break;
            }
        }

        veiculo.setId(menorIdDisponivel);
        veiculoIdMap.put(veiculo.getId(), veiculo);
        imprime();

        return veiculo;
    }

    public Veiculo updateVeiculo(Veiculo veiculo)
    {

        if (!veiculoIdMap.containsKey(veiculo.getId())) {
            return null;
        }

        veiculoIdMap.put(veiculo.getId(), veiculo);
        imprime();

        return veiculo;
    }

    public void deleteVeiculo(int id)
    {
        if (!veiculoIdMap.containsKey(id)){
        return;
        }
        veiculoIdMap.remove(id);
        imprime();
    }

    public static HashMap<Integer, Veiculo> getVeiculoIdMap()
    {
        return veiculoIdMap;
    }

    protected void imprime()
    {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO_IMPRESSAO));

            for (Veiculo veiculo : getVeiculos()){
                writer.append(String.format("%d %d %s %s ", veiculo.getId(), veiculo.getAno(), veiculo.getPlaca(), veiculo.getChassi()));
                writer.append(String.format("%s %s %d %n", veiculo.getModelo(), veiculo.getMarca(), veiculo.getRenavam()));
            }

            writer.close();

            } catch (IOException e){

            System.out.println("Erro na leitura/escrita em arquivo");
        }
    }
}
