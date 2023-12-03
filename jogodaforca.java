import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        String palavra = "Java";
        int tentativas = 6;
        boolean[] acertos = new boolean[palavra.length()];
        Scanner scanner = new Scanner(System.in);

        while (tentativas > 0 && palavra.indexOf('_') != -1) {
            System.out.println("Palavra: " + exibirPalavra(palavra, acertos));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);

            if (tentativaValida(letra, palavra, acertos)) {
                System.out.println("Letra correta!");
            } else {
                System.out.println("Letra incorreta. Tente novamente.");
                tentativas--;
            }
        }

        scanner.close();

        if (palavra.indexOf('_') == -1) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavra);
        } else {
            System.out.println("Você perdeu. A palavra correta era: " + palavra);
        }
    }

    private static String exibirPalavra(String palavra, boolean[] acertos) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palavra.length(); i++) {
            resultado.append(acertos[i] ? palavra.charAt(i) : "_");
            resultado.append(" ");
        }
        return resultado.toString();
    }

    private static boolean tentativaValida(char letra, String palavra, boolean[] acertos) {
        boolean letraCorreta = false;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                acertos[i] = true;
                letraCorreta = true;
            }
        }

        return letraCorreta;
    }
}
