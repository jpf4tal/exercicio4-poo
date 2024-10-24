public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    // Construtor
    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.emailAmigoSorteado = null; // Inicialmente, o amigo secreto não foi sorteado
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}
