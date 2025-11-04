public class ContaBancaria {

    private static final double TAXA_CHEQUE_ESPECIAL = 0.20;

    private String titular;
    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialUsado = 0;

    public ContaBancaria(String titular, double depositoInicial) {
        this.titular = titular;
        this.saldo = depositoInicial;
        definirLimiteChequeEspecial(depositoInicial);
        System.out.println("Conta criada para " + titular + " com saldo inicial de R$ " + saldo);
        System.out.println("Cheque especial disponível: R$ " + limiteChequeEspecial);
    }

    
    private void definirLimiteChequeEspecial(double valor) {
        if (valor <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = valor * 0.5;
        }
    }

    
    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite de cheque especial: R$ %.2f | Usado: R$ %.2f%n", limiteChequeEspecial, chequeEspecialUsado);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser maior que zero.");
            return;
        }

        
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * TAXA_CHEQUE_ESPECIAL;
            double totalDivida = chequeEspecialUsado + taxa;

            if (valor >= totalDivida) {
                valor -= totalDivida;
                chequeEspecialUsado = 0;
                System.out.printf("Cheque especial quitado com taxa de R$ %.2f. Valor restante adicionado ao saldo.%n", taxa);
            } else {
                chequeEspecialUsado -= valor / (1 + TAXA_CHEQUE_ESPECIAL);
                System.out.printf("Parte do cheque especial foi quitada. Ainda restam R$ %.2f de uso.%n", chequeEspecialUsado);
                return;
            }
        }

        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado. Novo saldo: R$ %.2f%n", valor, saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        double totalDisponivel = saldo + (limiteChequeEspecial - chequeEspecialUsado);

        if (valor > totalDisponivel) {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialUsado += restante;
            System.out.printf("Você usou R$ %.2f do cheque especial.%n", restante);
        }

        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public void pagarBoleto(double valor) {
        System.out.println("Tentando pagar boleto no valor de R$ " + valor + "...");
        sacar(valor);
    }

    public void verificarUsoChequeEspecial() {
        if (chequeEspecialUsado > 0) {
            System.out.printf("Você está usando R$ %.2f do cheque especial.%n", chequeEspecialUsado);
        } else {
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

    
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getChequeEspecialUsado() {
        return chequeEspecialUsado;
    }
}