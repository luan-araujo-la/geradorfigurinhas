import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa {
    
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
            String urlImagem = atributos.get("url");
            String data = atributos.get("date");
            var conteudo = new Conteudo(titulo, urlImagem, "0", "0", data);

            conteudos.add(conteudo);
        }

        return conteudos;

    }
}
