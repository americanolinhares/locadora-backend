package com.infosistemas.veiculo.controller;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import com.infosistemas.veiculo.bean.Veiculo;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;



public class VeiculoControllerTest {

    static Veiculo veiculo1;
    static Veiculo veiculo2;
    static Veiculo veiculo3;
    static Veiculo veiculo4;

    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void getVeiculoIdentificado_deveRetornarJsonCorretamenteEStatusOk()
    {
        get("/locadora/veiculos/2").then()
        .body("id", equalTo(2))
        .body("ano", equalTo(2009))
        .body("placa", equalTo("RED-2546"))
        .body("chassi", equalTo("8BWZZZ377VT005241"))
        .body("modelo", equalTo("Gol"))
        .body("marca", equalTo("VW"))
        .body("renavam", equalTo(25594354775L))
        .statusCode(200);
    }

    @Test
    public void getVeiculoInexistente_deveRetornarJsonCorretamenteEStatusNoContent()
    {
        get("/locadora/veiculos/6").then()
        .statusCode(204);
    }

    @Test
    public void getVeiculos_deveRetornarJsonCorretamenteEStatusOk()
    {
        given().when().get("/locadora/veiculos").then()
        .body(containsString("Ka"))
        .body(containsString("Gol"))
        .body(containsString("Uno"))
        .body(containsString("Prisma"))
        .statusCode(200);
    }

    @Test
    public void createVeiculo_deveCriarVeiculoCorretamenteERetornarStatusOk()
    {
        Veiculo veiculo = new Veiculo(1985, "HER-4424", "9AWZZZ377VT005965", "Corcel", "Ford", 30594354775L);

        int posicao = given()
        .contentType("application/json")
        .body(veiculo)
        .when().post("/locadora/veiculos").then()
        .body("ano",equalTo(1985))
        .body("placa", equalTo("HER-4424"))
        .body("chassi", equalTo("9AWZZZ377VT005965"))
        .body("modelo", equalTo("Corcel"))
        .body("marca", equalTo("Ford"))
        .body("renavam", equalTo(30594354775L))
        .statusCode(200)
        .extract().path("id");

         given().pathParam("id", posicao)
        .when().delete("/locadora/veiculos/{id}").then()
        .statusCode(204);
}

    @Test
    public void createVeiculoVazio_deveRetornarInternalServerError()
    {
        given()
        .contentType("application/json")
        .body("")
        .when().post("/locadora/veiculos").then()
        .statusCode(500);
    }  

    @Test
    public void updateVeiculo_deveAtualizaVeiculoCorretamenteERetornarStatusOk()
    {
        Veiculo veiculoOriginal = new Veiculo(1985, "HER-4424", "9AWZZZ377VT005965", "Corcel", "Ford", 30594354775L);

        int posicao = given()
                .contentType("application/json")
                .body(veiculoOriginal)
                .when().post("/locadora/veiculos").then()
                .statusCode(200)
                .extract().path("id");

        Veiculo veiculoAtualizado = new Veiculo(posicao, 1986, "HIS-4424", "8BWZZZ377VT005965", "Fusca", "VW", 40594354775L);

        given()
        .contentType("application/json")
        .body(veiculoAtualizado)
        .when().put("/locadora/veiculos").then()
        .body("id",equalTo(posicao))
        .body("ano",equalTo(1986))
        .body("placa", equalTo("HIS-4424"))
        .body("chassi", equalTo("8BWZZZ377VT005965"))
        .body("modelo", equalTo("Fusca"))
        .body("marca", equalTo("VW"))
        .body("renavam", equalTo(40594354775L))
        .statusCode(200);

        given().pathParam("id", posicao)
        .when().delete("/locadora/veiculos/{id}").then()
        .statusCode(204);
    }

    @Test
    public void deleteVeiculoIdentificado_deveDeletarVeiculoCorretamenteERetornarStatusNoContent()
    {
        Veiculo veiculo = new Veiculo(10, 1985, "HER-4424", "9AWZZZ377VT005965", "Corcel", "Ford", 30594354775L);

        int posicao = given()
                .contentType("application/json")
                .body(veiculo)
                .when().post("/locadora/veiculos").then()
                .body("ano",equalTo(1985))
                .extract().path("id");

        given().pathParam("id", posicao)
        .when().delete("/locadora/veiculos/{id}").then()
        .statusCode(204);
    }
}
