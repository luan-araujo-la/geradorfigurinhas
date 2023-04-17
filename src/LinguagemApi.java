import java.io.IOException;
import java.util.List;

public class LinguagemApi {
    
    protected String linguagemKey = "";

    public void top10Linguagens() throws IOException{
        // fazer conexão via HTTP da api IMDb
        String url = "http://localhost:8080/linguagens";

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários (titulo, poster, avaliação)
        var extrator = new ExtratorLinguagens();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados        
        for (int i = 0; i < 2; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\u001b[1mRanking:\u001b[m " + conteudo.getVotos());
            System.out.println("\n");

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();
            gerador.criar(urlImage, conteudo.getTitulo(), "😎 TOP 10 LINGUAGENS 😎", 3);

        }
    }
}
