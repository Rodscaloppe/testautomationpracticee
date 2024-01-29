package com.automationpractice.steps;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.jetbrains.annotations.NotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraSteps {
    Playwright playwright;
    Browser browser;
    Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Defina como true para execução headless
        page = browser.newPage();
    }
    @After
    public void tearDown() {
        browser.close();
        playwright.close();
    }

    @Given("que estou na página de login do site")
    public void que_estou_na_pagina_de_login_do_site() {
        page.navigate("https://www.automationexercise.com/login?controller=authentication&back=my-account");
    }

    @When("eu faço login com {string} e {string}")
    public void eu_faco_login_com_e(String email, String senha) {
        page.locator("form:has-text('Login') input[placeholder='Email Address']").click();
        page.locator("form:has-text('Login') input[placeholder='Email Address']").fill("teste2021@teste.com.br");
        page.locator("input[placeholder='Password']").click();
        page.locator("input[placeholder='Password']").fill("teste");
        page.locator("button:has-text('Login')").click();
    }

    @And("eu busco por {string}")
    public void eu_busco_por(String produto) {
        page.click("a:has-text('Products')");
        page.click("[placeholder=\"Search Product\"]");
        page.fill("[placeholder=\"Search Product\"]", produto);
        page.click("#submit_search");
    }

    @And("eu adiciono um {string} ao carrinho")
    public void eu_adiciono_um_ao_carrinho(String produto) {
        page.click("text=" + produto);
        page.click("text=Add to cart");
        page.click("text=Continue Shopping");
    }

    @And("eu acesso o carrinho de compras")
    public void eu_acesso_o_carrinho_de_compras() {
        page.click("text=Cart");
    }

    @Then("eu devo ver o {string} listado no carrinho")
    public void eu_devo_ver_o_listado_no_carrinho(@NotNull String produto) {
        String textoElemento = page.textContent("text='" + produto + "'");
        boolean isProdutoListadoNoCarrinho = textoElemento.toLowerCase().contains(produto.toLowerCase());
        assertTrue("O produto " + produto + " não está listado no carrinho", isProdutoListadoNoCarrinho);
    }

    @And("o total do carrinho deve refletir o preço do {string}")
    public void verificarEManipularCarrinho(String produto) {
        page.click("text=Cart");
        boolean isCartEmpty = page.isVisible("text=Cart is empty! Click here to buy products.");
        if (!isCartEmpty) {
            // 7 e 8 - Verificar se o valor total do produto no carrinho é maior que o valor unitário e deletar se for verdadeiro
            String valorTotalTexto = page.textContent(":nth-match(:text('Rs. 500'), 2)");
            String valorProdutoTexto = page.textContent("text=Rs. 500");
            double valorTotal = Double.parseDouble(valorTotalTexto.replaceAll("[^\\d]", ""));
            double valorProduto = Double.parseDouble(valorProdutoTexto.replaceAll("[^\\d]", ""));
            if (valorTotal > valorProduto) {
                page.click(".fa-times");
            }
        }
        page.click("text=Products");
        // 4 - Realizar a busca pelo produto novamente
        page.fill("[placeholder='Search Product']", produto);
        page.click("#submit_search");
        // 5 - Adicionar o produto ao carrinho
        page.click("text=" + produto);
        page.click("text=Add to cart");
        page.click("text=Continue Shopping");
        // 6 - verificar se o produto foi adicionado ao carrinho
        page.click("text=Cart");
        boolean isProductInCart = page.isVisible("text='" + produto + "'");
        assertTrue("O produto não foi adicionado ao carrinho", isProductInCart);
    }
}

