public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        // a) Cadastrar dois amigos José e Maria
        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");

        // b) Configurar o amigo secreto de José e Maria
        try {
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        // c) Enviar uma mensagem anônima de Maria para José
        MensagemParaAlguem mensagemAnonima = new MensagemParaAlguem("Oi José!", "maria@email.com", true, "jose@email.com");
        sistema.pesquisaTodasAsMensagens().add(mensagemAnonima);

        // d) Enviar uma mensagem anônima de Maria para todos
        MensagemParaAlguem mensagemParaTodos = new MensagemParaAlguem("Bom dia a todos!", "maria@email.com", true, "todos");
        sistema.pesquisaTodasAsMensagens().add(mensagemParaTodos);

        // e) Pesquisar as mensagens anônimas e imprimir
        for (mensagem msg : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(msg.getTextoCompletoAExibir());
        }

        // f) Pesquisar o amigo secreto de José
        try {
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if (amigoSecreto.equals("maria@email.com")) {
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}