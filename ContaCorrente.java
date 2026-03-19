// Classe que representa uma Conta Corrente
// Ela herda (extends) da classe Conta e implementa Tributavel
public class ContaCorrente extends Conta implements Tributavel {
    // Atributo específico da conta corrente
    private double taxaManutencao;

    // Construtor
    public ContaCorrente(String numeroConta, String titular) {
        super(numeroConta, titular); // chama o construtor da classe pai (Conta)
        this.taxaManutencao = 10.0; // taxa fixa de R$ 10,00
    }

    // Método para cobrar a taxa de manutenção
    public void cobrarTaxaManutencao() {
        if (saldo >= taxaManutencao) {
            saldo = saldo - taxaManutencao;
            System.out.println("Taxa de manutenção cobrada: R$ " + taxaManutencao);
            System.out.println("Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para cobrar taxa de manutenção.");
        }
    }

    // Sobrescreve o método da classe pai
    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    // Implementação do método da interface Tributavel
    @Override
    public double calcularTributo() {
        // Conta corrente paga 1% do saldo como tributo
        return saldo * 0.01;
    }
}
