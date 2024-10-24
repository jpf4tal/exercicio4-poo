public class MensagemParaAlguem extends mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonima, String emailDestinatario) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }


    public String getTextoCompletoAExibir() {
        if (isAnonima()) {
            return "Mensagem para " + emailDestinatario + ". Texto: " + getTexto();
        } else {
            return "Mensagem de: " + getEmailRemetente() + " para " + emailDestinatario + ". Texto: " + getTexto();
        }
    }
}