public class PetMachine {

    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;

    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho.");
            return;
        }

        if (this.water < 10 || this.shampoo < 2) {
            System.out.println("A máquina não tem água ou shampoo suficiente!");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo!");
    }

    public void addWater() {
        if (water >= MAX_WATER) {
            System.out.println("A capacidade de água da máquina está no máximo.");
            return;
        }
        water = Math.min(water + 2, MAX_WATER);
        System.out.println("Adicionando água... agora há " + water + "L na máquina.");
    }

    public void addShampoo() {
        if (shampoo >= MAX_SHAMPOO) {
            System.out.println("A capacidade de shampoo da máquina está no máximo.");
            return;
        }
        shampoo = Math.min(shampoo + 2, MAX_SHAMPOO);
        System.out.println("Adicionando shampoo... agora há " + shampoo + "L na máquina.");
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja. É necessário limpá-la antes de colocar um novo pet.");
            return;
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " já está na máquina.");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void removePet() {
        if (this.pet == null) {
            System.out.println("Não há pet na máquina para remover.");
            return;
        }
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi retirado da máquina.");
        this.pet = null;
    }

    public void wash() {
        if (this.water < 3 || this.shampoo < 1) {
            System.out.println("A máquina não tem recursos suficientes para a limpeza.");
            return;
        }
        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("A máquina foi limpa.");
    }
}