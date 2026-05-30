# MarketFlow 
## Sistema de PDV e Gestão de Estoque Varejista
### Contextualização do Minimundo
A rede MarketFlow é uma rede de comércio varejista com três filiais localizadas nos bairros da
Tijuca, Barra da Tijuca e Botafogo, no Rio de Janeiro. Cada loja possui seu próprio estoque local
e realiza vendas diretamente ao consumidor final. O sistema integra o Ponto de Venda (PDV) ao
controle de estoque, processa vendas, aplica descontos por fidelidade, emite cupom fiscal
simplificado, controla reposição automática e gera relatórios de giro por loja. Relatórios
consolidados são gerados para a matriz acompanhar o desempenho geral da rede.

## Atores do Sistema

| Ator |  Descrição |
| :---: | :---: | 
| Atendente/Caixa |  Realiza as vendas, identifica clientes e opera o PDV | 
| Cliente | Efetua compras, pode possuir cadastro de fidelidade |
| Gerente de Loja |  Visualiza estoque e relatórios de giro da loja | 
| Matriz |Acessa relatórios consolidados de todas as lojas |
| Sistema |  Realiza reposição automática ao detectar estoque mínimo | 

## Classes do Sistema
### O sistema é composto pelas seguintes classes principais:
| Classe |  Responsabilidade |
| :---: | :---: | 
| Produto | Representa um produto com código, nome, preço, quantidade e quantidade mínima | 
| Cliente |  Representa o cliente com CPF, nome e status de fidelidade |
| ItemVenda |   Representa um item dentro de uma venda com produto, quantidade e subtotal | 
| Venda | Agrupa os itens vendidos, cliente, data e calcula o total |
| Estoque |   Controla a quantidade de produtos e gera relatório de estoque |
| Loja |   Representa uma filial com nome, endereço, estoque e vendas realizadas | 
| PDV |  Classe principal - opera o caixa com menu interativo via Scanner |
| ProdutoNaoEncontradoException |  Exceção customizada para produto não encontrado | 
| EstoqueInsuficienteException | Exceção customizada para quantidade insuficiente em estoque |

## Requisitos Funcionais (RF)

| ID |  Requisito |
| :---: | :---: | 
| RF01 | O sistema deve processar vendas registrando os itens e calculando o total | 
| RF02 | O sistema deve identificar clientes pelo CPF e verificar fidelidade |
| RF03 |  O sistema deve aplicar desconto de 15% para clientes com fidelidade | 
| RF04 | O sistema deve emitir cupom fiscal simplificado ao finalizar a venda |
| RF05 |  O sistema deve exibir o estoque disponível por loja | 
| RF06 |  O sistema deve alertar quando um produto atingir o estoque mínimo | 
| RF07 | O sistema deve gerar relatório de giro de produtos por loja |


## Requisitos Não Funcionais (RNF)

| ID |  Requisito |
| :---: | :---: | 
| RNF01 | O sistema deve ser desenvolvido em Java com Orientação a Objetos | 
| RNF02 | O sistema deve utilizar encapsulamento com getters e setters |
| RNF03 | O sistema deve utilizar exceções customizadas para tratamento de erros | 
| RNF04 | O sistema deve utilizar arrays para armazenamento de dados |
| RNF05 | A interface do sistema deve ser via terminal (Scanner) | 
| RNF06 | O sistema deve ser de fácil operação pelo atendente no caixa | 


## Stack Tecnológica
### Java 21 · Orientação a Objetos · UML · IntelliJ IDEA
#### MarketFlow — Projeto de Faculdade · 2026
