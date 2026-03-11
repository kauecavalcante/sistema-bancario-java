# Sistema Bancário em Java

## IDENTIFICAÇÃO
**Nome:** Kauê Cavalcante
**Matrícula:** 1231501747
**Disciplina:** PROJETO DE PROGRAMAÇÃO
**Professor:** Amaury

---

## COMO EXECUTAR

Para executar o sistema, abra o terminal na pasta do projeto e execute os seguintes comandos:

```bash
javac *.java
java Main
```

O programa iniciará e exibirá o menu principal com as opções disponíveis.

---

## FUNCIONALIDADES IMPLEMENTADAS

- Criar conta (Corrente ou Poupança)
- Listar contas existentes
- Depositar dinheiro em uma conta
- Sacar dinheiro de uma conta
- Transferir dinheiro entre contas
- Consultar saldo de uma conta
- Validação de saldo insuficiente
- Herança e Polimorfismo (Conta, ContaCorrente, ContaPoupanca)
- Encapsulamento de atributos
- Lista de objetos com ArrayList

---

## EXEMPLO DE EXECUÇÃO

```
===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 1

----- CRIAR CONTA -----
Tipo de conta:
1 - Corrente
2 - Poupança
Escolha o tipo: 1
Digite o nome do titular: João Silva
Conta Corrente criada com sucesso!
Número da conta: 1001
Titular: João Silva

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 1

----- CRIAR CONTA -----
Tipo de conta:
1 - Corrente
2 - Poupança
Escolha o tipo: 2
Digite o nome do titular: Maria Santos
Conta Poupança criada com sucesso!
Número da conta: 1002
Titular: Maria Santos

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 2

===== LISTA DE CONTAS =====
1 - Conta: 1001 | Titular: João Silva | Tipo: Conta Corrente | Saldo: R$ 0.0
2 - Conta: 1002 | Titular: Maria Santos | Tipo: Conta Poupança | Saldo: R$ 0.0
===========================

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 3

----- DEPOSITAR -----
Digite o número da conta: 1001
Digite o valor do depósito: R$ 1000
Depósito realizado com sucesso!
Novo saldo: R$ 1000.0

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 6

----- CONSULTAR SALDO -----
Digite o número da conta: 1001
===== EXTRATO =====
Conta: 1001
Titular: João Silva
Saldo: R$ 1000.0
===================

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 5

----- TRANSFERIR -----
Digite o número da conta de origem: 1001
Digite o número da conta de destino: 1002
Digite o valor da transferência: R$ 300
Saque realizado com sucesso!
Novo saldo: R$ 700.0
Depósito realizado com sucesso!
Novo saldo: R$ 300.0
Transferência realizada com sucesso!

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 4

----- SACAR -----
Digite o número da conta: 1001
Digite o valor do saque: R$ 1000
Saldo insuficiente!

===== BANCO JAVA =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
0 - Sair
======================
Escolha uma opção: 0
Encerrando o sistema... Até logo!
```

---

## ESTRUTURA DO PROJETO

- **Conta.java** - Classe base que representa uma conta bancária genérica
- **ContaCorrente.java** - Classe que herda de Conta e representa uma conta corrente
- **ContaPoupanca.java** - Classe que herda de Conta e representa uma conta poupança
- **Banco.java** - Classe que gerencia todas as contas (usa ArrayList)
- **Main.java** - Classe principal com menu interativo

---

## CONCEITOS DE POO UTILIZADOS

1. **Herança:** ContaCorrente e ContaPoupanca herdam de Conta
2. **Polimorfismo:** Método getTipoConta() sobrescrito nas classes filhas
3. **Encapsulamento:** Atributos privados com getters
4. **ArrayList:** Usado para armazenar lista de contas
5. **Scanner:** Para ler entrada do usuário
6. **Loop while:** Menu interativo que roda até o usuário sair

---

## OBSERVAÇÕES

- As contas são numeradas automaticamente a partir de 1001
- O sistema valida saldo insuficiente em saques e transferências
- Todos os métodos têm comentários explicativos para facilitar o entendimento

