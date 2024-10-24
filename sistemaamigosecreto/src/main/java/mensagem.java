public class mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto() {
        return texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public boolean isAnonima() {
        return anonima;
    }

    public String getTextoCompletoAExibir() {
        return ;
    }
}


