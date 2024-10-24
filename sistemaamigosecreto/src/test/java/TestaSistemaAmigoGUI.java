import javax.swing.*;
import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        Scanner scanner = new Scanner(System.in);

        // b) Ler a quantidade total de amigos
        String input = JOptionPane.showInputDialog("Quantos amigos vão participar?");
        int quantidadeAmigos = Integer.parseInt(input);

        // c) Ler os dados e cadastrar os amigos
        for (int i = 0; i < quantidadeAmigos; i++) {
            String nome = JOptionPane.showInputDialog("Nome do amigo " + (i + 1));
            String email = JOptionPane.showInputDialog("Email do amigo " + (i + 1));
            sistema.cadastraAmigo(nome, email);
        }

        // d) Configurar o sorteio dos amigos secretos
        for (int i = 0; i < quantidadeAmigos; i++) {
            String emailPessoa = JOptionPane.showInputDialog("Informe o e-mail do amigo sorteado para " + (i + 1));
            String emailAmigoSorteado = JOptionPane.showInputDialog("Informe o e-mail do amigo secreto sorteado");
            try {
                sistema.configuraAmigoSecretoDe(emailPessoa, emailAmigoSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        // e) Enviar mensagem de algum amigo para todos
        String remetente = JOptionPane.showInputDialog("Informe o e-mail do remetente");
        String texto = JOptionPane.showInputDialog("Digite o texto da mensagem");
        String anonimaStr = JOptionPane.showInputDialog("A mensagem será anônima? (sim/não)");
        boolean anonima = anonimaStr.equalsIgnoreCase("sim");

        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, remetente, anonima, "todos");
        sistema.pesquisaTodasAsMensagens().add(mensagem);

        JOptionPane.showMessageDialog(null, "Mensagem enviada para todos!");
    }
}