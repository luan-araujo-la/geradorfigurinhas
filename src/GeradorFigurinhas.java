import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {
    
    /**
     * @throws IOException
     * 
     */
    public void criar(String inputStream, String nomeArquivo, String legenda, String imagem, int opc) throws IOException {

        var diretorio = new File("figurinhas/"); // pegando a diretorio
        diretorio.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioFilme = new File("figurinhas/filmes/"); // pegando a diretorio
        diretorioFilme.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioSerie = new File("figurinhas/series/"); // pegando a diretorio
        diretorioSerie.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioNasa = new File("figurinhas/nasa/"); // pegando a diretorio
        diretorioNasa.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioLinguagem = new File("figurinhas/linguagens/"); // pegando a diretorio
        diretorioLinguagem.mkdir(); // criando o diretorio, caso não houver diretorio
        
        nomeArquivo = nomeArquivo.replaceAll("\\:", "-"); // substituindo o : por - do nome do arquivo
        nomeArquivo = nomeArquivo.replaceAll("\\/", "-"); // substituindo o / por - do nome do arquivo
        if (opc == 0){
            nomeArquivo = diretorioFilme + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 1){
            nomeArquivo = diretorioSerie + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 2){
            nomeArquivo = diretorioNasa + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 3){
            nomeArquivo = diretorioLinguagem + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else {
            System.out.println("\nO Diretório escolhido é inválido!!! escolha 0 para Filmes, 1 para Séries, 2 para Nasa ou 3 para Linguagens");
        }

        inputStream = inputStream.replaceAll("(@+)(.*).jpg$", "$1.jpg"); // substituindo a prorpiadade por vazio, assim pegando a imagem maior da api

        InputStream url = new URL(inputStream).openStream(); // criando inputStream
        // // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(url); // pegando a imagem da url
        BufferedImage imagemLegenda = ImageIO.read(new File(imagem));

        // criar nova imagem em memória com transparência e com tamanho novo
        int width = imagemOriginal.getWidth(); // pegando a largura da imagem
        int height = imagemOriginal.getHeight(); // pegando a altura da imagem
        int newHeight = 0; // adicionando uma nova altura

        if (height > 1100) newHeight = height + 400; // adicionando uma nova altura
        else newHeight = height + 200; // adicionando uma nova altura

        BufferedImage imagemNova = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT); // criando uma nova imagem

        // copiar a imagem original para nova imagem (em memória)
        int heightLegendaFundo = newHeight - height;
        Graphics2D graphics = (Graphics2D) imagemNova.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);
        graphics.drawImage(imagemLegenda, 0, height, width, heightLegendaFundo, null);

        int tamanhoFont = 0;

        if (width < 450) tamanhoFont = (width - newHeight) / 15;
        else tamanhoFont = (width - newHeight) / 10;

        if (tamanhoFont < 0) tamanhoFont = tamanhoFont * (-1);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFont);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem 
        FontMetrics fontMetrics = graphics.getFontMetrics(); // variavel para pegar as metricas de uma fonte
        Rectangle2D margemLegenda = fontMetrics.getStringBounds(legenda, graphics); // pegando as propriedades de tamanho da legenda
        int larguraLegenda = (int) margemLegenda.getWidth(); // pegando a largura da fonte
        int posicaoInicial = (width - larguraLegenda) / 2;  // calculo para pegar a posição inicial para escrever a legenda
        int posicaoFinal = newHeight - 150; // calculo para posição final
        graphics.drawString(legenda, posicaoInicial, posicaoFinal); // desenhando a legenda na imagem

        // escrever a nova imagem em arquivo
        ImageIO.write(imagemNova, "png", new File(nomeArquivo));
    }


    

    public void criar(String inputStream, String nomeArquivo, String legenda, int opc) throws IOException {

        var diretorio = new File("figurinhas/"); // pegando a diretorio
        diretorio.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioFilme = new File("figurinhas/filmes/"); // pegando a diretorio
        diretorioFilme.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioSerie = new File("figurinhas/series/"); // pegando a diretorio
        diretorioSerie.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioNasa = new File("figurinhas/nasa/"); // pegando a diretorio
        diretorioNasa.mkdir(); // criando o diretorio, caso não houver diretorio
        var diretorioLinguagem = new File("figurinhas/linguagens/"); // pegando a diretorio
        diretorioLinguagem.mkdir(); // criando o diretorio, caso não houver diretorio
        
        nomeArquivo = nomeArquivo.replaceAll("\\:", "-"); // substituindo o : por - do nome do arquivo
        nomeArquivo = nomeArquivo.replaceAll("\\/", "-"); // substituindo o / por - do nome do arquivo
        if (opc == 0){
            nomeArquivo = diretorioFilme + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 1){
            nomeArquivo = diretorioSerie + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 2){
            nomeArquivo = diretorioNasa + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else if (opc == 3){
            nomeArquivo = diretorioLinguagem + "/" +nomeArquivo + ".png"; // adicionando o diretorio completo para o nomeArquivo
        } else {
            System.out.println("\nO Diretório escolhido é inválido!!! escolha 0 para Filmes, 1 para Séries, 2 para Nasa ou 3 para Linguagens");
        }

        inputStream = inputStream.replaceAll("(@+)(.*).jpg$", "$1.jpg"); // substituindo a prorpiadade por vazio, assim pegando a imagem maior da api

        InputStream url = new URL(inputStream).openStream(); // criando inputStream
        // // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(url); // pegando a imagem da url

        // criar nova imagem em memória com transparência e com tamanho novo
        int width = imagemOriginal.getWidth(); // pegando a largura da imagem
        int height = imagemOriginal.getHeight(); // pegando a altura da imagem
        int newHeight = 0; // adicionando uma nova altura

        if (height > 1100) newHeight = height + 400; // adicionando uma nova altura
        else newHeight = height + 200; // adicionando uma nova altura

        BufferedImage imagemNova = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT); // criando uma nova imagem

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) imagemNova.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        int tamanhoFont = 0;

        if (width < 450) tamanhoFont = (width - newHeight) / 15;
        else tamanhoFont = (width - newHeight) / 10;

        if (tamanhoFont < 0) tamanhoFont = tamanhoFont * (-1);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFont);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem 
        FontMetrics fontMetrics = graphics.getFontMetrics(); // variavel para pegar as metricas de uma fonte
        Rectangle2D margemLegenda = fontMetrics.getStringBounds(legenda, graphics); // pegando as propriedades de tamanho da legenda
        int larguraLegenda = (int) margemLegenda.getWidth(); // pegando a largura da fonte
        int posicaoInicial = (width - larguraLegenda) / 2;  // calculo para pegar a posição inicial para escrever a legenda
        int posicaoFinal = newHeight - 150; // calculo para posição final
        graphics.drawString(legenda, posicaoInicial, posicaoFinal); // desenhando a legenda na imagem

        // escrever a nova imagem em arquivo
        ImageIO.write(imagemNova, "png", new File(nomeArquivo));
    }
}
