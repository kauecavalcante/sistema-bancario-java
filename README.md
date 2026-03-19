# Sistema Bancário em Java - Versão 2.0

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/POO-Avan%C3%A7ado-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-success?style=for-the-badge)
![Version](https://img.shields.io/badge/Vers%C3%A3o-2.0-purple?style=for-the-badge)

> Sistema bancário avançado desenvolvido em Java utilizando conceitos avançados de Programação Orientada a Objetos (POO)

## IDENTIFICAÇÃO

**Nome:** Kauê Cavalcante
**Matrícula:** 1231501747
**Disciplina:** PROJETO DE PROGRAMAÇÃO
**Professor:** Amaury
**Versão:** 2.0 - Evolução Arquitetural

---

## EXPLICAÇÃO DA ARQUITETURA

### Por que `Conta` é abstrata?

A classe `Conta` foi transformada em abstrata porque:
- **Conceito genérico:** Representa um conceito abstrato de conta bancária que não deve ser instanciado diretamente
- **Força especialização:** Obriga a criação de tipos específicos de conta (ContaCorrente, ContaPoupanca)
- **Base comum:** Define comportamentos e atributos comuns que são herdados por todas as especializações
- **Design pattern:** Segue o padrão Template Method, fornecendo implementações padrão que podem ser sobrescritas
- **Mundo real:** No mundo real, não existe uma "conta genérica", apenas tipos específicos de conta

### Por que `Tributavel` é interface?

A interface `Tributavel` foi escolhida porque:
- **Contrato:** Define um contrato que qualquer classe pode implementar, não apenas contas
- **Flexibilidade:** Permite que diferentes tipos de objetos sejam tributáveis (contas, investimentos, etc.)
- **Herança múltipla:** Java não permite herança múltipla de classes, mas permite implementar múltiplas interfaces
- **Separação de responsabilidades:** Separa a lógica de tributação da hierarquia de contas
- **Opcional:** Nem todas as contas são tributáveis (ContaPoupanca é isenta)

### Como ocorre o polimorfismo no cálculo de imposto?

O polimorfismo no cálculo de imposto funciona assim:

1. **Interface comum:** A `CalculadoraDeImposto` aceita qualquer objeto que implemente `Tributavel`
2. **Método polimórfico:** O método `registrar(Tributavel t)` não conhece o tipo específico do objeto
3. **Binding dinâmico:** Em tempo de execução, o Java chama o método `calcularTributo()` correto
4. **Implementações diferentes:** Cada classe tributável pode ter sua própria fórmula de cálculo
5. **Extensibilidade:** Novos tipos tributáveis podem ser adicionados sem modificar a calculadora

**Exemplo prático:**
```java
Tributavel obj = new ContaCorrente(...);  // Polimorfismo
calculadora.registrar(obj);  // Chama calcularTributo() de ContaCorrente
```

---

## COMO EXECUTAR

### Compilação

```bash
# Navegue até o diretório do projeto
cd atividade-banco-java

# Compile todos os arquivos Java
javac *.java
```

### Execução

```bash
# Execute o programa principal
java Main
```

---

## EXEMPLO DE EXECUÇÃO

```
===== BANCO JAVA - VERSÃO 2.0 =====
1 - Criar conta
2 - Listar contas
3 - Depositar
4 - Sacar
5 - Transferir
6 - Consultar saldo
7 - Calcular tributos
8 - Autenticar gerente
0 - Sair
====================================
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

===== BANCO JAVA - VERSÃO 2.0 =====
Escolha uma opção: 3

----- DEPOSITAR -----
Digite o número da conta: 1001
Digite o valor do depósito: R$ 5000
Depósito realizado com sucesso!
Novo saldo: R$ 5000.0

===== BANCO JAVA - VERSÃO 2.0 =====
Escolha uma opção: 7

----- CALCULAR TRIBUTOS -----
Contador de tributos zerado.

----- Calculando tributo -----
Conta: 1001 - Titular: João Silva
Saldo: R$ 5000,00
Tributo calculado: R$ 50,00
Total acumulado: R$ 50,00
============================
RELATÓRIO DE TRIBUTOS
============================
Total de tributos: R$ 50,00
============================

===== BANCO JAVA - VERSÃO 2.0 =====
Escolha uma opção: 8

----- AUTENTICAÇÃO DE GERENTE -----
Gerente: João Silva
Departamento: Operações
Digite a senha: senha123
Funcionário João Silva autenticado com sucesso!
Gerente do departamento Operações tem acesso total ao sistema.

----- MENU DO GERENTE -----
1 - Exibir informações do gerente
2 - Exibir relatório gerencial
3 - Aprovar operação
0 - Voltar ao menu principal
Escolha uma opção: 3

Descreva a operação a aprovar: Liberação de crédito especial
============================
APROVAÇÃO DE OPERAÇÃO
============================
Gerente: João Silva
Operação: Liberação de crédito especial
Status: APROVADA
============================

===== BANCO JAVA - VERSÃO 2.0 =====
Escolha uma opção: 0
Encerrando o sistema... Até logo!
```

---

## ESTRUTURA DO PROJETO

### Diagrama de Classes

```
                    ┌─────────────────────┐
                    │ <<interface>>       │
                    │   Tributavel        │
                    ├─────────────────────┤
                    │ +calcularTributo()  │
                    └──────────┬──────────┘
                               │implements
                    ┌──────────▼──────────┐
     ┌──────────────┤  <<abstract>>       │
     │              │      Conta          │
     │              ├─────────────────────┤
     │              │ -numeroConta        │
     │              │ -titular            │
     │              │ #saldo              │
     │              └──────────┬──────────┘
     │                         │extends
     │              ┌──────────┴──────────┐
     │              │                     │
┌────▼────────┐ ┌──▼──────────┐
│ContaCorrente│ │ContaPoupanca│
├─────────────┤ ├─────────────┤
│-taxaManut.  │ │-taxaRend.   │
├─────────────┤ ├─────────────┤
│+calcularTrib│ │+aplicarRend.│
└─────────────┘ └─────────────┘

     ┌─────────────────────┐
     │ <<interface>>       │
     │   Autenticavel      │
     ├─────────────────────┤
     │ +autenticar()       │
     └──────────┬──────────┘
                │implements
     ┌──────────▼──────────┐
     │    Funcionario      │
     ├─────────────────────┤
     │ -nome,-cpf,-senha   │
     └──────────┬──────────┘
                │extends
     ┌──────────▼──────────┐
     │      Gerente        │
     ├─────────────────────┤
     │ -departamento       │
     │ +aprovarOperacao()  │
     └─────────────────────┘
```

### Arquivos do Projeto

- **Conta.java** - Classe abstrata base para todas as contas
- **ContaCorrente.java** - Conta que implementa Tributavel (paga 1% de tributo)
- **ContaPoupanca.java** - Conta isenta de tributos
- **Banco.java** - Gerenciador de contas com ArrayList
- **Main.java** - Interface CLI com menu interativo
- **Tributavel.java** - Interface para objetos tributáveis
- **CalculadoraDeImposto.java** - Calcula e acumula tributos
- **Autenticavel.java** - Interface para autenticação
- **Funcionario.java** - Classe base de funcionários autenticáveis
- **Gerente.java** - Especialização de funcionário com poderes especiais

---

## FUNCIONALIDADES IMPLEMENTADAS

### Funcionalidades Básicas (v1.0)
1. ✅ Criar conta (Corrente ou Poupança)
2. ✅ Listar contas existentes
3. ✅ Depositar valores
4. ✅ Sacar valores
5. ✅ Transferir entre contas
6. ✅ Consultar saldo

### Novas Funcionalidades (v2.0)
7. ✅ **Calcular tributos de contas correntes**
   - ContaCorrente paga 1% do saldo
   - ContaPoupanca é isenta
   - Relatório consolidado de tributos

8. ✅ **Autenticar gerente**
   - Sistema de login com senha
   - Menu exclusivo do gerente
   - Aprovar operações especiais
   - Visualizar relatórios gerenciais

---

## CONCEITOS DE POO DEMONSTRADOS

| Conceito | Onde Aparece | Descrição |
|----------|--------------|-----------|
| **Abstração** | Classe `Conta` | Define estrutura base sem permitir instanciação direta |
| **Herança** | `ContaCorrente`, `ContaPoupanca`, `Gerente` | Reutilização e especialização de código |
| **Polimorfismo** | Uso de `Tributavel` | Diferentes implementações para calcularTributo() |
| **Interfaces** | `Tributavel` e `Autenticavel` | Contratos que definem comportamentos obrigatórios |
| **Reutilização** | Lógica de saldo na classe `Conta` | Código compartilhado entre todas as subclasses |
| **Estruturas Dinâmicas** | `ArrayList<Conta>` | Gerenciamento dinâmico e ilimitado de contas |
| **Encapsulamento** | Atributos privados | Proteção de dados com acesso controlado |
| **Composição** | `Banco` contém `ArrayList<Conta>` | Relacionamento "tem-um" |

---

## DETALHES TÉCNICOS

### Sistema de Tributos
- **Taxa:** ContaCorrente paga 1% do saldo como tributo
- **Isenção:** ContaPoupanca não implementa Tributavel (isenta)
- **Acumulação:** CalculadoraDeImposto soma todos os tributos
- **Relatório:** Exibe total consolidado de impostos

### Sistema de Autenticação
- **Senha padrão:** senha123
- **Gerente padrão:** João Silva (criado automaticamente)
- **Departamento:** Operações
- **Poderes especiais:** Aprovar operações, visualizar relatórios

### Validações Implementadas
- ✅ Valores positivos para depósitos e saques
- ✅ Verificação de saldo insuficiente
- ✅ Autenticação por senha
- ✅ Existência de conta antes de operações
- ✅ Tipo de conta na criação (1 ou 2)

---

## OBSERVAÇÕES FINAIS

- **Compatibilidade:** Mantém todas as funcionalidades da versão 1.0
- **Extensibilidade:** Arquitetura preparada para novos tipos de conta e funcionários
- **Demonstração:** Gerente padrão criado para facilitar testes
- **Educacional:** Código comentado para fins didáticos
- **Evolução:** Sistema evoluiu de básico para arquitetura robusta

---

## AUTOR

Desenvolvido por **Kauê Cavalcante** como trabalho acadêmico para a disciplina de Projeto de Programação, sob orientação do Professor Amaury.

---

*Versão 2.0 - Evolução Arquitetural do Sistema Bancário*