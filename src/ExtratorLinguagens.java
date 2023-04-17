import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorLinguagens {
    
    /**
     * @param json
     * @return
     */
    public List<Conteudo> ExtraiConteudos (String json) {
        
        // extrair os dados necessários (titulo, poster, avaliação)
        var parser = new JsonParse();
        List<Map<String, String>> listaDeAtributo = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de coneduos

        for (Map<String, String> atributos : listaDeAtributo) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            String ranking = atributos.get("ranking");
            var conteudo = new Conteudo(titulo, urlImagem, ranking, "0", "0");

            conteudos.add(conteudo);
        }

        return conteudos;

    }
}
