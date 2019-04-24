package com.infosistemas.veiculo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.infosistemas.veiculo.bean.Veiculo;

import org.junit.Before;
import org.junit.Test;

public class VeiculoServiceTest {

    private VeiculoService veiculoService;
    
    @Before
    public void init()
    {
        veiculoService = new VeiculoService();
    }
    
    @Test
    public void getVeiculo_deveRetornarVeiculoIdentificadoCorretamente() {

         assertEquals("9BWZZZ377VT004251", veiculoService.getVeiculo(1).getChassi());
    }
    
    @Test
    public void getVeiculoInexistente_deveRetornarNulo()
    {
        assertNull(veiculoService.getVeiculo(7));
    }

    @Test
    public void deleteVeiculo_deveDeletarVeiculoCorretamente()
    {
        int tamanhoInicial = veiculoService.getVeiculos().size();
        veiculoService.deleteVeiculo(3);
        assertEquals(veiculoService.getVeiculos().size(), --tamanhoInicial);
    }
    
    @Test
    public void deleteVeiculoInexistente_deveManterListadeVeiculoCorreta()
    {
         int tamanhoInicial = veiculoService.getVeiculos().size();
         veiculoService.deleteVeiculo(1000);
         assertEquals(veiculoService.getVeiculos().size(), tamanhoInicial);
    }
    
    @Test
    public void addVeiculo_deveAdicionarVeiculoCorretamente()
    {
        int tamanhoInicial = veiculoService.getVeiculos().size();
        Veiculo veiculo = new Veiculo(1998, "HLD-2546", "9BWZZZ377VT004251", "Siena", "Fiat", 58594354775L);
        veiculoService.addVeiculo(veiculo);

        ++tamanhoInicial;
        assertEquals(veiculoService.getVeiculos().size(), tamanhoInicial);
        assertTrue(veiculoService.getVeiculos().contains(veiculo));    
    }
    
    @Test
    public void updateVeiculo_deveAtualizarVeiculoCorretamente()
    {
        int tamanhoInicial = veiculoService.getVeiculos().size();
        Veiculo veiculo = new Veiculo(2, 2007, "RID-9652", "1BWZZZ377VT004251", "Fiesta", "Ford", 96394354775L);
        veiculoService.updateVeiculo(veiculo);

        assertEquals(veiculoService.getVeiculos().size(), tamanhoInicial);
        assertTrue(veiculoService.getVeiculos().contains(veiculo));  
    }   

    @Test
    public void updateVeiculoInexistente_deveRetornarNulo()
    {
        Veiculo veiculo = new Veiculo(6, 1999, "SER-9652", "9BWZZZ377VT004251", "Fusca", "VW", 96594354775L);
        veiculoService.updateVeiculo(veiculo);

        assertNull(veiculoService.updateVeiculo(veiculo));  
    }
}