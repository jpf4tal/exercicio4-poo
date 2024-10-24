import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> mapaDeAmigos; // Usa o e-mail como chave
    private List<mensagem> listaDeMensagens;

    public SistemaAmigoMap() {
        this.mapaDeAmigos = new HashMap<>();
        this.listaDeMensagens = new ArrayList<>();
    }

    // Método para cadastrar amigos no sistema usando um HashMap
    public void cadastraAmigo(String nome, String email) {
        Amigo amigo = new Amigo(nome, email);
        mapaDeAmigos.put(email, amigo); // O e-mail será a chave no HashMap
    }

    // Método que pesquisa as mensagens anônimas e retorna uma lista com tais mensagens
    public List<mensagem> pesquisaMensagensAnonimas() {
        List<mensagem> mensagensAnonimas = new ArrayList<>();
        for (mensagem mensagem : listaDeMensagens) {
            if (mensagem.isAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    // Método que configura o amigo secreto sorteado para uma pessoa
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = mapaDeAmigos.get(emailDaPessoa); // Pesquisa pelo e-mail
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
        }
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    // Método que pesquisa todas as mensagens já enviadas
    public List<mensagem> pesquisaTodasAsMensagens() {
        return listaDeMensagens;
    }

    // Método que pesquisa o amigo secreto sorteado para uma pessoa
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = mapaDeAmigos.get(emailDaPessoa); // Pesquisa pelo e-mail
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
        }
        String emailAmigoSorteado = amigo.getEmailAmigoSorteado();
        if (emailAmigoSorteado == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return emailAmigoSorteado;
    }

    // Método para adicionar uma mensagem à lista de mensagens
    public void adicionarMensagem(mensagem mensagem) {
        listaDeMensagens.add(mensagem);
    }

    // Método auxiliar para verificar se um amigo existe no sistema
    public boolean existeAmigo(String email) {
        return mapaDeAmigos.containsKey(email);
    }
}