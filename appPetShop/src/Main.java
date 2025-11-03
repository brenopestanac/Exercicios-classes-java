import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Escolha uma das opções ===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar a água da máquina");
            System.out.println("5 - Verificar o shampoo da máquina");
            System.out.println("6 - Verificar se há pet na máquina");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer do ENTER

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> petMachine.addWater();
                case 3 -> petMachine.addShampoo();
                case 4 -> System.out.println("A máquina está com " + petMachine.getWater() + "L de água.");
                case 5 -> System.out.println("A máquina está com " + petMachine.getShampoo() + "L de shampoo.");
                case 6 -> System.out.println(petMachine.hasPet() ? "Tem pet na máquina." : "Não tem pet na máquina.");
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> {
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void setPetInPetMachine() {
        System.out.print("Informe o nome do pet: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Nome inválido. Tente novamente.");
            return;
        }

        Pet pet = new Pet(name);
        petMachine.setPet(pet);
    }
}