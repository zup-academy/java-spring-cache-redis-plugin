# **Java Spring Cache Redis Plugin**

Plugin Java Spring Cache Redis é um conjunto de técnologias e metodologia de desenvolvimento que juntos auxiliam na utilização do Redis como provedor de cache distribuído em Aplicações Java Spring Boot. 

Este Plugin possui suporte para projetos criados junto a Stack Java Spring Boot REST API. E Dado a isso também suporta projetos Java Spring Boot que utilizem **Maven** como gerenciador de dependencias e tenham suas configurações de properties no padrão **YAML**.


Nas proximas sessões você encontrará em detalhes informações sobre como utilizar Plugin Java Spring Cache Redis para habilitar a capacidade de utilizar Redis como Cache Distruído em seus projetos. 

Abaixo esta de forma sumariazada cada sessão desta documentação.

1. [Técnologias base da Plugin](#tecnologias-base-da-plugin)
2. [Capacidades Habilitadas ao uso da Plugin](#quais-são-as-capacidades-habilitadas)
3. [Beneficio de utilizar a Plugin](#quais-os-beneficios-de-utilizar-java-spring-cache-redis-plugin)
4. [Aplicando Java Spring Cache Redis Plugin](#aplicando-java-spring-cache-redis-plugin)


## **Tecnologias base da Plugin**

Objetivo desta sessão é informar quais são as técnologias que fazem parte do Java Spring Cache Redis Plugin.

Ao aplicar este plugin em um projeto Java Spring Boot, sua aplicação poderá se beneficiar de toda infraestrutura da ferramenta Spring Cache para prover caching de metodos, permitindo que fluxo de I/O e CPU bound sejam cacheados afim prover melhorias na performance do seu projeto.


### **Composição Técnologica**

A definição deste Plugin foi pensada visando as maiores dores no uso do Redis como cache de aplicativos Java.

Entendemos que a qualidade é inegociavel, e olhamos para as técnologias e metodologias como meio para obter a tão desejada qualidade no software. Essa premissa foi o guia para escolha de cada técnologia detalhada abaixo.


- Ambiente de produção
    - Spring Cache
    - Spring Data Redis
    - Lettuce Client
- Ambiente de testes
    - JUnit
    - Test Containers
- Ambiente de desenvolvimento
    - Docker Compose
        - Redis Container


## **Quais são as capacidades Habilitadas**

Ao aplicar em seu projeto Java Spring Boot, o Java Spring Cache Redis Plugin, seu projeto será capaz:

1. Utilizar caching distribuido do Redis em diversos pontos do Sistema
2. Definir configurações personalizadas para diversos Caches e
3. Criar uma suite de testes de integração automatizada junto a TestContainers 
4. Criar Testes Integrados afim de validar o comportamento do Cache 
5. Ambiente de desenvolvimento configurado junto ao Docker com Docker-compose.



## **Quais os Beneficios de Utilizar Java Spring Cache Redis Plugin**

1. Facilidade na Criação de caches no Redis em seu projeto através da StackSpot CLI.
2. Facilidade em definição de caching através das abstrações do Spring Boot.
3. Configuração default de comportamento do cache baseado em boas praticas.
4. Configuração personalizada para cada Cache.
5. Codigos de exemplo de como adicionar valores no Cache baseado em  boas praticas.
6. Codigos de exemplo de como invalidar valores no Cache baseado em  boas praticas.
7. Codigos de exemplo de Testes de integração para validar comportamento de consumo do cache.
8. Codigos de exemplo de Testes de integração para validar comportamento de invalidação do cache.
7. Configuração do ambiente de testes com JUnit e Test Containers.
8. DockerCompose para uso do Redis em ambiente de desenvolvimento.


[Assita este video para ver os beneficios de utilizar Java Spring Cache Redis Plugin em seu projeto](https://youtu.be/-2GJR3e4LDs)


## **Aplicando Java Spring Cache Redis Plugin**

Para Aplicar o Java Spring Cache Redis Plugin em  seus projetos e desfrutar de seus beneficios é necessário que você tenha a CLI da StackSpot instalada em sua maquina. [Caso você não tenha siga este tutorial para fazer a instalação](https://docs.stackspot.com/docs/stk-cli/installation/).

### 1. Importe a Stack em sua maquina

```sh
stk import stack https://github.com/zup-academy/java-springboot-restapi-stack
```

### 2. Agora verifique se a Stack foi importada com sucesso

```sh
stk list stack | grep java-springboot
```

### 3. Aplique o Plugin, no diretorio do seu projeto, execute

```sh
stk apply plugin java-springboot-restapi-stack/java-spring-cache-redis-plugin
```   

### 4. Verifque as modificações em seu projeto

```sh
git status
```   



## Suporte

Caso precise de ajuda, por favor abra uma [issue no repositorio do Github da Stack](https://github.com/zup-academy/java-spring-cache-redis-plugin/issues).