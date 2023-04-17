import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorImdb {
    public List<Conteudo> ExtraiConteudos (String json) {
        
        // extrair os dados necessários (titulo, poster, avaliação)
        var parser = new JsonParse();
        List<Map<String, String>> listaDeAtributo = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de coneduos
        for (Map<String, String> atributos : listaDeAtributo) {
            String titulo = atributos.get("fullTitle");
            String urlImagem = atributos.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String votos = atributos.get("imDbRating");
            String qntVotos = atributos.get("imDbRatingCount");
            var conteudo = new Conteudo(titulo, urlImagem, votos, qntVotos, "0");

            conteudos.add(conteudo);
        }

        return conteudos;

    }
}
