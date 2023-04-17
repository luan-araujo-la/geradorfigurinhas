import java.io.IOException;
import java.util.List;

public class FilmeApi {

    /**
     * @throws IOException
     * 
     */
    
    protected String imdbKey = "k_uzyisavh";

    public void top10Filmes() throws IOException, InterruptedException {

        // fazer conexão via HTTP da api IMDb
        String url = "https://imdb-api.com/pt-br/API/Top250Movies/" + imdbKey;

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários (titulo, poster, avaliação)
        var extrator = new ExtratorImdb();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados        
        for (int i = 0; i < 10; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\u001b[1mAvaliação:\u001b[m " + conteudo.getVotos());
            if (conteudo.getVotos() != "") {
                double classificacao = Double.parseDouble(conteudo.getVotos());
                int numAvaliacao = (int) classificacao;
                for (int j = 0; j < numAvaliacao; j++) {
                    System.out.print("\u001b[33m* \u001b[m");
                }
            } else System.out.print("\u001b[31m X \u001b[m");
            System.out.println("\n\u001b[1mTotal de avaliação:\u001b[m " + conteudo.getQntVotos());
            System.out.println("\n");

            String imagem = "assets/img/default.png";

            if (i == 0) imagem = "assets/img/first.png";
            else if (i == 1) imagem = "assets/img/second.png";
            else if (i == 2) imagem = "assets/img/third.png";
            else imagem = "assets/img/default.png";

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();
            gerador.criar(urlImage, conteudo.getTitulo(), "😎 TOP 10 MAIS AVILADOS 😎", imagem, 0);

        }
    }

    /**
     * @throws IOException
     * @throws InterruptedException
     */
    public void top10Tvs() throws IOException, InterruptedException {

        // fazer conexão via HTTP da api IMDb
        String url = "https://imdb-api.com/pt-br/API/Top250TVs/" + imdbKey;
        

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários (titulo, poster, avaliação)
        var extrator = new ExtratorImdb();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados        
        for (int i = 0; i < 10; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\u001b[1mAvaliação:\u001b[m " + conteudo.getVotos());
            if (conteudo.getVotos() != "") {
                double classificacao = Double.parseDouble(conteudo.getVotos());
                int numAvaliacao = (int) classificacao;
                for (int j = 0; j < numAvaliacao; j++) {
                    System.out.print("\u001b[33m* \u001b[m");
                }
            } else System.out.print("\u001b[31m X \u001b[m");
            System.out.println("\n\u001b[1mTotal de avaliação:\u001b[m " + conteudo.getQntVotos());
            System.out.println("\n");

            String imagem = "assets/img/default.png";

            if (i == 0) imagem = "assets/img/first.png";
            else if (i == 1) imagem = "assets/img/second.png";
            else if (i == 2) imagem = "assets/img/third.png";
            else imagem = "assets/img/default.png";

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();
            gerador.criar(urlImage, conteudo.getTitulo(), "😎 TOP 10 MAIS AVILADOS 😎", imagem, 1);

        }
    }

    public void maisPopularFilme() throws IOException, InterruptedException {

        // fazer conexão via HTTP da api IMDb
        String url = "https://imdb-api.com/pt-br/API/MostPopularMovies/" + imdbKey;
        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários (titulo, poster, avaliação)
        var extrator = new ExtratorImdb();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados        
        for (int i = 0; i < 10; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\u001b[1mAvaliação:\u001b[m " + conteudo.getVotos());
            if (conteudo.getVotos() != "") {
                double classificacao = Double.parseDouble(conteudo.getVotos());
                int numAvaliacao = (int) classificacao;
                for (int j = 0; j < numAvaliacao; j++) {
                    System.out.print("\u001b[33m* \u001b[m");
                }
            } else System.out.print("\u001b[31m X \u001b[m");
            System.out.println("\n\u001b[1mTotal de avaliação:\u001b[m " + conteudo.getQntVotos());
            System.out.println("\n");

            String imagem = "assets/img/default.png";

            if (i == 0) imagem = "assets/img/first.png";
            else if (i == 1) imagem = "assets/img/second.png";
            else if (i == 2) imagem = "assets/img/third.png";
            else imagem = "assets/img/default.png";

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();
            gerador.criar(urlImage, conteudo.getTitulo(), "🔥 MAIS ASSISTIDO 🔥", imagem, 0);

        }
    }

    public void maisPopularTvs() throws IOException, InterruptedException {
        
        // fazer conexão via HTTP da api IMDb
        String url = "https://imdb-api.com/pt-br/API/MostPopularTVs/" + imdbKey;
        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários (titulo, poster, avaliação)
        var extrator = new ExtratorImdb();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados        
        for (int i = 0; i < 10; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\u001b[1mAvaliação:\u001b[m " + conteudo.getVotos());
            if (conteudo.getVotos() != "") {
                double classificacao = Double.parseDouble(conteudo.getVotos());
                int numAvaliacao = (int) classificacao;
                for (int j = 0; j < numAvaliacao; j++) {
                    System.out.print("\u001b[33m* \u001b[m");
                }
            } else System.out.print("\u001b[31m X \u001b[m");
            System.out.println("\n\u001b[1mTotal de avaliação:\u001b[m " + conteudo.getQntVotos());
            System.out.println("\n");

            String imagem = "assets/img/default.png";

            if (i == 0) imagem = "assets/img/first.png";
            else if (i == 1) imagem = "assets/img/second.png";
            else if (i == 2) imagem = "assets/img/third.png";
            else imagem = "assets/img/default.png";

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();
            gerador.criar(urlImage, conteudo.getTitulo(), "🔥 MAIS ASSISTIDO 🔥", imagem, 1);
        }
    }

}
