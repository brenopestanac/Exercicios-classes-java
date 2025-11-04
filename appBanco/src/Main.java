import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Depósito inicial: R$ ");
        double depositoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(titular, depositoInicial);

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();
                case 2 -> conta.consultarChequeEspecial();
                case 3 -> {
                    System.out.print("Valor do depósito: ");
                    conta.depositar(scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Valor do saque: ");
                    conta.sacar(scanner.nextDouble());
                }
                case 5 -> {
                    System.out.print("Valor do boleto: ");
                    conta.pagarBoleto(scanner.nextDouble());
                }
                case 6 -> conta.verificarUsoChequeEspecial();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
