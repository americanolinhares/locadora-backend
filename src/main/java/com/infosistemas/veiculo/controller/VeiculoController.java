package com.infosistemas.veiculo.controller;

import com.infosistemas.veiculo.bean.Veiculo;
import com.infosistemas.veiculo.service.VeiculoService;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/veiculos")
public class VeiculoController {
    
    VeiculoService serviceVeiculos = new VeiculoService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getVeiculos()
    {
        return  serviceVeiculos.getVeiculos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getVeiculoById(@PathParam("id") int id)
    {
        return serviceVeiculos.getVeiculo(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo addVeiculo(Veiculo veiculo)
    {
        return serviceVeiculos.addVeiculo(veiculo);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo updateVeiculo(Veiculo veiculo)
    {
        return serviceVeiculos.updateVeiculo(veiculo);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteVeiculo(@PathParam("id") int id)
    {
         serviceVeiculos.deleteVeiculo(id);
    }
}
