# Projeto de Automação de Testes

Este projeto é uma suíte de automação de testes para a aplicação web [testautomationpracticee](https://www.automationexercise.com/), utilizando Playwright com Java e Cucumber.

## **Pré-requisitos**

Para configurar e executar este projeto, você precisará ter instalado:

- Java JDK (versão 11 ou superior)
- Maven (versão 3.6 ou superior)
- Google Chrome ou outro navegador compatível (para testes não headless)

## **Configuração do Ambiente**

1. **Instalar Java JDK**:
    - Faça o download e instale o Java JDK da página oficial da Oracle ou de outra fonte confiável.
    - Configure a variável de ambiente **`JAVA_HOME`** para apontar para o diretório de instalação do JDK.
    - Adicione o caminho do JDK ao **`PATH`** do sistema.
2. **Instalar Maven**:
    - Baixe e instale o Maven seguindo as instruções da página oficial do Maven.
    - Adicione o diretório **`bin`** do Maven ao **`PATH`** do sistema.
3. **Clonar o Repositório do Projeto**:
    - Utilize o comando **`git clone https://github.com/Rodscaloppe/testautomationpracticee`** para clonar o repositório do projeto em sua máquina local.
4. **Instalar Dependências**:
    - Navegue até o diretório do projeto clonado e execute **`mvn install`** para instalar todas as dependências necessárias.

## **Executando os Testes**

Para executar os testes, siga estas etapas:

1. **Abrir o Terminal ou Prompt de Comando**:
    - Navegue até o diretório do projeto.
2. **Executar os Testes**:
    - Execute o comando **`mvn test`** para iniciar a execução dos testes.
    - Os testes automatizados serão executados, e os resultados serão exibidos no terminal.

## **Estrutura do Projeto**

- **`src/main/java`**: Contém o código-fonte da suíte de testes.
- **`src/test/java`**: Contém os arquivos de step definitions do Cucumber e classes auxiliares.
- **`src/test/resources`**: Contém os arquivos **`.feature`** do Cucumber com os cenários de teste.
- **`pom.xml`**: Arquivo de configuração do Maven com as dependências e plugins do projeto.

```bash
testautomationpractice/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── automationpractice/
│   │               ├── ui/               # Código relacionado a testes de UI
│   │               └── api/              # Código relacionado a testes de API
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── automationpractice/
│   │   │           ├── steps/    
│   │   │           │   └── CompraSteps.java    # Step definitions para Cucumber
│   │   │           ├── ui/                    
│   │   │           ├── api/                    
│   │   │           │   └── ApiTest.java        # Testes de API com Rest-Assured
│   │   │           └── RunCucumberTest.java    # Classe de execução do Cucumber para testes de UI
│   │   └── resources/
│   │       ├── features/                       # Arquivos .feature do Cucumber
├── target/
│   └── index.html  # Relatório do projeto
└── pom.xml  # Arquivo de configuração do Maven
```

Obs: 
Por que não usar o Padrão Page Object Model (POM) 

Na escolha entre usar o Padrão Page Object Model (POM) ou uma estrutura mais simples depende do tamanho e a complexidade do projeto. O POM é mais apropriado para projetos de automação maiores e complexos, e na estrutura simplificada pode ser preferida para projetos menores e mais diretos, oferecendo maior flexibilidade e simplicidade.
