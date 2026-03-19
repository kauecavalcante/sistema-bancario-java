/**
 * Classe CalculadoraDeImposto
 * Responsável por calcular e acumular tributos de objetos tributáveis
 * Demonstra polimorfismo baseado em interfaces
 *
 * @author Kauê Cavalcante
 * @version 2.0
 */
public class CalculadoraDeImposto {
    // Total de tributos acumulados
    private double totalTributos;

    /**
     * Construtor da calculadora
     */
    public CalculadoraDeImposto() {
        this.totalTributos = 0.0;
    }

    /**
     * Registra um objeto tributável e acumula seu tributo
     * Este método demonstra polimorfismo - aceita qualquer objeto que implemente Tributavel
     * @param tributavel Objeto que implementa a interface Tributavel
     */
    public void registrar(Tributavel tributavel) {
        double tributo = tributavel.calcularTributo();
        totalTributos += tributo;
        System.out.println("Tributo calculado: R$ " + String.format("%.2f", tributo));
        System.out.println("Total acumulado: R$ " + String.format("%.2f", totalTributos));
    }

    /**
     * Retorna o total de tributos acumulados
     * @return valor total dos tributos
     */
    public double getTotalTributos() {
        return totalTributos;
    }

    /**
     * Exibe relatório de tributos
     */
    public void exibirRelatorio() {
        System.out.println("============================");
        System.out.println("RELATÓRIO DE TRIBUTOS");
        System.out.println("============================");
        System.out.println("Total de tributos: R$ " + String.format("%.2f", totalTributos));
        System.out.println("============================");
    }

    /**
     * Zera o contador de tributos
     */
    public void zerarTributos() {
        this.totalTributos = 0.0;
        System.out.println("Contador de tributos zerado.");
    }
}