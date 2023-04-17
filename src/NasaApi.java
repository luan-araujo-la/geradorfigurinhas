import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NasaApi {

    protected String nasakey = "c3lmldYeOJlxGzsM7wFVlK91nA6BPS7enaWXJyyr";

 /**   public void ImagemDoDia() throws IOException {

        // fazer conexão via HTTP da api NASA
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + nasakey;

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários
        var extrator = new ExtratorNasa();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados 
            for (int i = 0; i < 1; i++) {
                Conteudo conteudo = conteudos.get(i);
                System.out.println("\n");
                System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
                System.out.println("\n");

                String urlImage = conteudo.getUrlImage();
                var gerador = new GeradorFigurinhas();

                String legenda = "FOTO DO DIA " + conteudo.getData();

                gerador.criar(urlImage, conteudo.getTitulo(), legenda, 2);

            }
    }*/

    public void ImagemDoDia(String dataInicial, String dataFinal) throws IOException {

        // fazer conexão via HTTP da api NASA
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataI = LocalDate.parse(dataInicial, formato); 
        LocalDate dataF = LocalDate.parse(dataFinal, formato);
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + nasakey + "&start_date=" + dataI + "&end_date=" + dataF;

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários
        var extrator = new ExtratorNasa();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados 

        for (int i = 0; i < conteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\n");

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();

            String legenda = "FOTO DO DIA " + conteudo.getData();

            gerador.criar(urlImage, conteudo.getTitulo(), legenda, 2);

        }
    }

 /**   public void ImagemDoDia(String data) throws IOException {

        // fazer conexão via HTTP da api NASA
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataFinal = LocalDate.parse(data, formato);
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + nasakey + "&date=" + dataFinal;

        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        // extrair os dados necessários
        var extrator = new ExtratorNasa();
        List<Conteudo> conteudos = extrator.ExtraiConteudos(json);

        // exibir e manipular os dados 

        for (int i = 0; i < 1; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\n");
            System.out.println("\u001b[1mTítulo:\u001b[m \u001b[34m" + conteudo.getTitulo() + "\u001b[m");
            System.out.println("\n");

            String urlImage = conteudo.getUrlImage();
            var gerador = new GeradorFigurinhas();

            String legenda = "FOTO DO DIA " + conteudo.getData();

            gerador.criar(urlImage, conteudo.getTitulo(), legenda, 2);

        }
    }*/
}
