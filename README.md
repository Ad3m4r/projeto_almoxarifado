# Sistema de Controle de Empréstimo de Equipamentos

## Apresentação

Aplicação web demonstrativa para consultar e controlar o empréstimo e a devolução de um equipamento de almoxarifado. A tela exibe o código, o nome e a situação do item, oferecendo a ação correspondente: emprestar quando está disponível e devolver quando está emprestado.

## Descrição

O sistema disponibiliza um equipamento inicial — código `1234`, nome **Projetor** — e permite consultar ou alterar sua situação pela interface web ou pela API. A situação é mantida apenas na memória durante a execução: não há banco de dados, cadastro de múltiplos itens nem persistência entre reinicializações.

## Arquitetura do sistema

A aplicação segue uma arquitetura web em camadas simples, executada em um único processo:

- **Interface:** página HTML estática com CSS e JavaScript, servida pela própria aplicação. O JavaScript consulta a API e atualiza a tela após as operações.
- **API e controle:** `EquipamentoController` expõe os endpoints REST e coordena as operações sobre o equipamento.
- **Modelo de domínio:** `Equipamento` representa o item, seus dados e as operações de empréstimo e devolução.
- **Inicialização:** `AlmoxarifadoApplication` inicializa a aplicação Spring Boot.

### Endpoints

| Método | Rota | Ação |
|---|---|---|
| `GET` | `/equipamento` | Consulta os dados e a situação do equipamento. |
| `GET` | `/equipamento/emprestar` | Marca o equipamento como indisponível. |
| `GET` | `/equipamento/devolver` | Marca o equipamento como disponível. |

As respostas da API são retornadas em JSON. Como o estado é mantido em memória, as alterações são temporárias e reiniciar a aplicação restaura a situação inicial.

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4.1.1**
- **Spring MVC** para a API REST e o atendimento web
- **HTML5, CSS e JavaScript** para a interface
- **Maven** para gerenciamento e execução do projeto
- **JUnit 5 e Spring Boot Test** para o teste de inicialização da aplicação

## Como executar

Pré-requisitos: Java 21 ou superior e Maven instalados.

Na raiz do repositório, execute:

```sh
mvn spring-boot:run
```

Depois, acesse [http://localhost:8080](http://localhost:8080). Para consultar a API diretamente, acesse [http://localhost:8080/equipamento](http://localhost:8080/equipamento).
