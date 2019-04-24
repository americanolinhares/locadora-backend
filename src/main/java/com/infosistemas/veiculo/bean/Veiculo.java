package com.infosistemas.veiculo.bean;

public class Veiculo {

    private int id;
    private int ano;
    private String placa;
    private String chassi;
    private String modelo;
    private String marca;
    private long renavam;

    private Veiculo() {

        super();

    }

    public Veiculo(int ano, String placa, String chassi, String modelo, String marca, long renavam)
    {

        super();

        this.ano = ano;
        this.placa = placa;
        this.chassi = chassi;
        this.modelo = modelo;
        this.marca = marca;
        this.renavam = renavam;
    }

    public Veiculo(int id, int ano, String placa, String chassi, String modelo, String marca, long renavam)
    {

        super();

        this.id = id;
        this.ano = ano;
        this.placa = placa;
        this.chassi = chassi;
        this.modelo = modelo;
        this.marca = marca;
        this.renavam = renavam;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public String getPlaca()
    {
        return placa;
    }

    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

    public String getChassi()
    {
        return chassi;
    }

    public void setChassi(String chassi)
    {
        this.chassi = chassi;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public long getRenavam()
    {
        return renavam;
    }

    public void setRenavam(long renavam)
    {
        this.renavam = renavam;
    }
}