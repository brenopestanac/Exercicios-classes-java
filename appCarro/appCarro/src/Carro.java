public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;
    private final int VELOCIDADE_MAX = 120;
    private final int VELOCIDADE_MIN = 0;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
        } else {
            ligado = true;
            System.out.println("O carro foi ligado");
        }
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
            return;
        }
        if (velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("O carro foi desligado com sucesso!");
        } else {
            System.out.println("Não é possivel desligar o carro em movimento ou com a marcha engatada!");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado! Ligue o carro primeiro.");
            return;
        }
        if (marcha == 0) {
            System.out.println("O carro está em ponto morto, não é possivel acelerar!");
            return;
        }

        if (velocidade >= VELOCIDADE_MAX) {
            System.out.println("Velocidade máxima atingida!");
            return;
        }
        if (podeAcelerar()) {
            velocidade++;
            System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Velocidade incompativel com a marcha atuala!");
        }
    }

    public void diminuirVelocidade() {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        if (velocidade > VELOCIDADE_MIN) {
            velocidade--;
            System.out.println("Diminuindo volicade... Agora está em " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado!");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }

        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Velocidade incompatível com a marcha desejada!");
            return;
        }
        marcha = novaMarcha;

        System.out.println("Marcha trocada para: " + marcha);
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado!");
            return;
        }
        if (velocidade >= 1 && velocidade <= 40) {
            if (direcao.equalsIgnoreCase("esquerda") || direcao.equalsIgnoreCase("direita")) {
                System.out.println("Virando para " + direcao + "...");
            } else {
                System.out.println("Direção inválida! Use 'esquerda ou 'direita'.");
            }
        } else {
            System.out.println("Só é possivel virar entre 1km/h e 40km/h!");
        }
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h | Marcha: " + marcha);
    }

    private boolean podeAcelerar() {
        switch (marcha) {
            case 1:
                return velocidade < 20;
            case 2:
                return velocidade >= 20 && velocidade < 40;
            case 3:
                return velocidade >= 40 && velocidade < 60;
            case 4:
                return velocidade >= 60 && velocidade < 80;
            case 5:
                return velocidade >= 80 && velocidade < 100;
            case 6:
                return velocidade >= 100 && velocidade < 120;
            default:
                return false;
        }
    }

    private boolean velocidadeCompativelComMarcha(int m) {
        switch (m) {
            case 0:
                return velocidade == 0;
            case 1:
                return velocidade >= 0 && velocidade <= 20;
            case 2:
                return velocidade >= 21 && velocidade <= 40;
            case 3:
                return velocidade >= 41 && velocidade <= 60;
            case 4:
                return velocidade >= 61 && velocidade <= 80;
            case 5:
                return velocidade >= 81 && velocidade <= 100;
            case 6:
                return velocidade >= 101 && velocidade <= 120;
            default:
                return false;
        }
    }
}
