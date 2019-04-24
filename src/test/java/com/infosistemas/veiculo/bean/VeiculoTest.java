package com.infosistemas.veiculo.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeiculoTest {

    private Veiculo veiculo;

    @Before
    public void init()
    {
        veiculo = new Veiculo(1, 1998, "HLD-2546", "9BWZZZ377VT004251", "Ka", "Ford", 58594354775L);
    }  

    @Test
    public void getId_deveRetornarIdCorretamente()
    {
        assertEquals(1, veiculo.getId());
    }

    @Test
    public void getAno_deveRetornarAnoCorretamente()
    {
        assertEquals(1998, veiculo.getAno());
    }

    @Test
    public void getPlaca_deveRetornarPlacaCorretamente()
    {
        assertEquals("HLD-2546", veiculo.getPlaca());
    }

    @Test
    public void getChassi_deveRetornarChassiCorretamente()
    {
        assertEquals("9BWZZZ377VT004251", veiculo.getChassi());
    }

    @Test
    public void getModelo_deveRetornarModeloCorretamente()
    {
        assertEquals("Ka", veiculo.getModelo());
    }

    @Test
    public void getMarca_deveRetornarMarcaCorretamente()
    {
        assertEquals("Ford", veiculo.getMarca());
    }

    @Test
    public void getRenavam_deveRetornarRenavamCorretamente()
    {
        assertEquals(58594354775L, veiculo.getRenavam());
    }

    @Test
    public void setId_deveColocarIdCorretamente()
    {
        veiculo.setId(2);
        assertEquals(2, veiculo.getId());
    }

    @Test
    public void setAno_deveColocarAnoCorretamente()
    {
        veiculo.setAno(2000);
        assertEquals(2000, veiculo.getAno());
    }

    @Test
    public void setPlaca_deveColocarPlacaCorretamente()
    {
        veiculo.setPlaca("SYD-5263");
        assertEquals("SYD-5263", veiculo.getPlaca());
    }

    @Test
    public void setChassi_deveColocarChassiCorretamente()
    {
        veiculo.setChassi("8EFGHV377VT004251");
        assertEquals("8EFGHV377VT004251", veiculo.getChassi());
    }

    @Test
    public void setModelo_deveColocarModeloCorretamente()
    {
        veiculo.setModelo("Uno");
        assertEquals("Uno", veiculo.getModelo());
    }

    @Test
    public void setMarca_deveColocarMarcaCorretamente()
    {
        veiculo.setMarca("Fiat");
        assertEquals("Fiat", veiculo.getMarca());
    }

    @Test
    public void setRenavam_deveColocarRenavamCorretamente()
    {
        veiculo.setRenavam(30144354775L);
        assertEquals(30144354775L, veiculo.getRenavam());
    }   

    @Test
    public void construtorComPlacaChassiModeloMarcaNulos_deveCriarVeiculoComValoresNulos()
    {    
        veiculo = new Veiculo(1998, null, null, null, null, 58594354775L);
        assertNotNull(veiculo);
        assertEquals(58594354775L, veiculo.getRenavam());
    }
}