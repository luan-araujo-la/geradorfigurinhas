import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        int opc = 0;
        var filmeSerie = new FilmeApi();
        var nasaApi = new NasaApi();
        var linguagensApi = new LinguagemApi();

        do {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Escolha uma opção!!! ~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println("\n1 - Filmes e Séries (IMDb)\n2 - Nasa Imagem (Nasa)\n3 - Linguagens\n4 - SAIR\n");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~ NOOBFLIX - FIGURINHAS ~~~~~~~~~~~~~~~~~~~~\n");
            opc = entrada.nextInt();
            if (opc <= 0 || opc > 4) {
                System.out.println("\nPor favor, selecione uma opção válida!!!\n");
            }
        } while (opc <= 0 || opc > 4);

        if (opc == 1) {
            do {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Escolha uma opção!!! ~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("\n1 - Top 10 melhores filmes\n2 - Top 10 melhores séries\n3 - Os filmes mais assistidos\n4 - As séires mias assistidas\n5 - SAIR\n");
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ NOOBFLIX - FIGURINHAS ~~~~~~~~~~~~~~~~~~~~\n");
                opc = entrada.nextInt();
                if (opc <= 0 || opc > 5) {
                    System.out.println("\nPor favor, selecione uma opção válida!!!\n");
                }
            } while (opc <= 0 || opc > 5);

            if (opc == 1) {
                filmeSerie.top10Filmes();
            } else if (opc == 2) {
                filmeSerie.top10Tvs();
            } else if (opc == 3) {
                filmeSerie.maisPopularFilme();
            } else if (opc == 4){
                filmeSerie.maisPopularTvs();
            } else if (opc == 5) {
                System.out.println("\nVOLTE SEMPRE - NOOBFLIX\n");
            } else System.out.println("Erro! Opção inválida!!!");

        } else if (opc == 2) {
            do {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Escolha uma opção!!! ~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("\n1 - Ver imagem de um determinado intervalor\n2 - SAIR\n");
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ NOOBFLIX - FIGURINHAS ~~~~~~~~~~~~~~~~~~~~\n");
                opc = entrada.nextInt();
                if (opc <= 0 || opc > 2) {
                    System.out.println("\nPor favor, selecione uma opção válida!!!\n");
                }
            } while (opc <= 0 || opc > 2);

            if (opc == 1) {
                System.out.println("\nDigite uma data inicial! (Ex: 22/11/2021)\n");
                String dataInicial = entrada.next();

                System.out.println("\nDigite uma data final! (Ex: 26/11/2021)\n");
                String dataFinal = entrada.next();

                nasaApi.ImagemDoDia(dataInicial, dataFinal);
            } else if (opc == 2) {
                System.out.println("\nVOLTE SEMPRE - NOOBFLIX\n");
            } else System.out.println("Erro! Opção inválida!!!");


        } else if(opc == 3){
            do {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Escolha uma opção!!! ~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("\n1 - Top 10 Linguagens do Mercado\n2 - SAIR\n");
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~ NOOBFLIX - FIGURINHAS ~~~~~~~~~~~~~~~~~~~~\n");
                opc = entrada.nextInt();
                if (opc <= 0 || opc > 2) {
                    System.out.println("\nPor favor, selecione uma opção válida!!!\n");
                }
            } while (opc <= 0 || opc > 2);

            if(opc == 1){
                linguagensApi.top10Linguagens();
            } else if (opc == 2){
                System.out.println("\nVOLTE SEMPRE - NOOBFLIX\n");
            } else System.out.println("Erro! Opção inválida!!!");

        } else if (opc == 4) {
            System.out.println("\nVOLTE SEMPRE - NOOBFLIX\n");
        } else System.out.println("Erro! Opção inválida!!!");


        entrada.close();
    }
}
