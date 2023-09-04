import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo de Luta!");

        System.out.print("Informe o nome do seu personagem: ");
        String nomePersonagem = scanner.nextLine();

        System.out.print("Informe a energia inicial do seu personagem: ");
        int energiaInicial = scanner.nextInt();

        System.out.print("Informe a vida inicial do seu personagem: ");
        int vidaInicial = scanner.nextInt();

        try {
            Personagem jogador = new Personagem(nomePersonagem, energiaInicial, vidaInicial);
            Personagem adversario = new Personagem("Adversário", energiaInicial, vidaInicial);

            System.out.println("\nInformações iniciais dos personagens:");
            System.out.println("Seu personagem:\n" + jogador);
            System.out.println("Adversário:\n" + adversario);

            while (jogador.getVida() > 0 && adversario.getVida() > 0) {
                System.out.println("\nEscolha um golpe para atacar o adversário:");
                System.out.println("1. Ataque Rápido (10 de dano)");
                System.out.println("2. Ataque Poderoso (20 de dano)");
                System.out.println("3. Ataque Especial (30 de dano)");
                System.out.println("4. Desistir do Jogo");
                System.out.print("Digite o número do golpe: ");
                int escolha = scanner.nextInt();

                int danoAtaque = 0;

                switch (escolha) {
                    case 1:
                        danoAtaque = 10;
                        break;
                    case 2:
                        danoAtaque = 20;
                        break;
                    case 3:
                        danoAtaque = 30;
                        break;
                    case 4:
                        System.out.println("Você desistiu do jogo. Fim de jogo.");
                        return;
                    default:
                        System.out.println("Golpe inválido. Tente novamente.");
                        continue;
                }

                // Simula o adversário causando dano aleatório entre 10 e 30.
                int danoAdversario = (int) (Math.random() * 21) + 10;
                System.out.println("Seu personagem ataca com um golpe de " + danoAtaque + " de dano!");
                System.out.println("Adversário ataca com um golpe de " + danoAdversario + " de dano!");

                jogador.tomarDano(danoAdversario);
                adversario.tomarDano(danoAtaque);

                System.out.println("\nInformações atualizadas dos personagens:");
                System.out.println("Seu personagem:\n" + jogador);
                System.out.println("Adversário:\n" + adversario);
            }

            if (jogador.getVida() <= 0 && adversario.getVida() <= 0) {
                System.out.println("A luta terminou em empate!");
            } else if (jogador.getVida() <= 0) {
                System.out.println("Você foi derrotado! Fim de jogo. Adversário venceu.");
            } else {
                System.out.println("Parabéns! Você derrotou o adversário e venceu o jogo.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
