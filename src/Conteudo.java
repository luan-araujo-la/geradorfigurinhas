public class Conteudo {
    
    private final String titulo;
    private final String urlImage;
    private final String votos;
    private final String qntVotos;
    private final String data;


    public Conteudo(String titulo, String urlImage, String votos, String qntVotos, String data) {
        this.titulo = titulo;
        this.urlImage = urlImage;
        this.votos = votos;
        this.qntVotos = qntVotos;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getUrlImage() {
        return urlImage;
    }

    public String getVotos() {
        return votos;
    }

    public String getQntVotos() {
        return qntVotos;
    }

    public String getData() {
        return data;
    }
    
    
}
