import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> listaDeAmigos;
    private List<mensagem> listaDeMensagens;

    public SistemaAmigo() {
        this.listaDeAmigos = new ArrayList<>();
        this.listaDeMensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        listaDeAmigos.add(new Amigo(nome, email));
    }

    public List<mensagem> pesquisaMensagensAnonimas() {
        List<mensagem> mensagensAnonimas = new ArrayList<>();
        for (mensagem mensagem : listaDeMensagens) {
            if (mensagem.isAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
        }
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public List<mensagem> pesquisaTodasAsMensagens() {
        return listaDeMensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
        }
        String emailAmigoSorteado = amigo.getEmailAmigoSorteado();
        if (emailAmigoSorteado == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return emailAmigoSorteado;
    }

    private Amigo pesquisaAmigo(String email) {
        for (Amigo amigo : listaDeAmigos) {
            if (amigo.getEmail().equals(email)) {
                return amigo;
            }
        }
        return null;
    }
}
