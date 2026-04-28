# Personal Finance Analyzer
___
Um analisador de finanças pessoais desenvolvido em Java, criado para demonstrar o uso avançado de **Programação Funcional**, **Streams API** e processamento eficiente de arquivos (I/O).

Este projeto lê um arquivo CSV contendo transações financeiras, processa os dados utilizando expressões Lambda e exporta um relatório consolidado em texto.

## Funcionalidades

* **Leitura Eficiente de Arquivos:** Utiliza `java.nio.file.Files` e *Lazy Evaluation* para ler arquivos CSV sem sobrecarregar a memória.
* **Processamento de Dados:** Filtra receitas e despesas, calcula saldo total e agrupa gastos por categoria.
* **Exportação de Relatórios:** Gera um arquivo `.txt` formatado com o resumo financeiro.
* **Arquitetura Limpa:** Código organizado por responsabilidades (Model, Service, I/O) seguindo boas práticas de design de software.

## Tecnologias e Conceitos Utilizados

* **Java 14+**: Uso de `record` para modelagem de dados imutáveis.
* **Programação Funcional**: Expressões Lambda, `Predicate`, `Consumer`.
* **Streams API**: `filter`, `mapToDouble`, `collect`, `Collectors.groupingBy`.
* **NIO.2 API**: Manipulação moderna de arquivos (`Path`, `Files.lines`, `Files.write`).

## Estrutura do Projeto

```text
--personal-finance-analyzer--
┣ src/main/java/finance
┃ ┣ model
┃ ┃ ┣ Transaction.java
┃ ┃ ┗ Type.java
┃ ┣ service
┃ ┃ ┗ FinanceAnalyzer.java
┃ ┣ io
┃ ┃ ┣ TransactionParser.java
┃ ┃ ┗ ReportExporter.java
┃ ┗ Main.java
┣ transactions.csv  
┗ README.md
```

## Como Executar

1. Certifique-se de ter o **Java JDK 14** (ou superior) instalado.
2. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/personal-finance-analyzer.git
   ```
3. Navegue até a pasta do projeto:
   ```bash
   cd personal-finance-analyzer
   ```
4. Compile os arquivos Java:
   ```bash
   javac -d bin src/main/java/finance/**/*.java src/main/java/finance/*.java
   ```
5. Execute o programa:
   ```bash
   java -cp bin finance.Main
   ```

## Exemplo de Uso

**Entrada (`transactions.csv`):**
```csv
description,amount,category,type,date
Salario,5000.0,Salario,INCOME,2023-10-01
Supermercado,450.0,Alimentacao,EXPENSE,2023-10-07
Uber,80.0,Transporte,EXPENSE,2023-10-12
```

**Saída Gerada (`resumo_financeiro.txt`):**
```text
=== RELATÓRIO FINANCEIRO ===
Saldo Total: R$ 4470.00

Gastos por Categoria:
- Transporte: R$ 80.00
- Alimentacao: R$ 450.00
```
