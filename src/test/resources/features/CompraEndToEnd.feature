
Feature: Fluxo de Compra do Usuário
  Como um cliente
  Eu quero fazer login, buscar produtos, adicionar ao carrinho e validar meu carrinho
  Para completar minha compra no site

  Scenario: Fluxo completo de compra de um produto
    Given que estou na página de login do site
    When eu faço login com "teste2021@teste.com.br" e "teste"
    And eu busco por "blue top"
    And eu adiciono um "blue top" ao carrinho
    And eu acesso o carrinho de compras
    Then eu devo ver o "blue top" listado no carrinho
    And o total do carrinho deve refletir o preço do "blue top"
