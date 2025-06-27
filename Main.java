
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.List;


@SpringBootApplication
public class Main implements CommandLineRunner {

    private final ApiClient apiClient = new ApiClient();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        exibirMenu();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n📚 CATÁLOGO DE LIVROS - MENU");
            System.out.println("1. Buscar livros por título");
            System.out.println("2. Buscar livros por autor");
            System.out.println("3. Listar livros em inglês");
            System.out.println("4. Listar livros em português");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o título ou parte dele: ");
                        String titulo = scanner.nextLine();
                        mostrarLivros(apiClient.buscarLivros(titulo).getResults());
                    }
                    case 2 -> {
                        System.out.print("Digite o nome do autor: ");
                        String autor = scanner.nextLine();
                        mostrarLivros(apiClient.buscarLivros(autor).getResults());
                    }
                    case 3 -> {
                        System.out.println("📚 Livros em inglês:");
                        mostrarLivrosFiltrandoPorIdioma("en");
                    }
                    case 4 -> {
                        System.out.println("📚 Livros em português:");
                        mostrarLivrosFiltrandoPorIdioma("pt");
                    }
                    case 0 -> System.out.println("Encerrando o programa...");
                    default -> System.out.println("⚠️ Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("❌ Erro: entrada inválida. Digite apenas números.");
            }
        }
    }

    private void mostrarLivros(List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            System.out.println("🔍 Nenhum livro encontrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro); // usa o toString()
                System.out.println("--------------------");
            }
        }
    }

    private void mostrarLivrosFiltrandoPorIdioma(String idioma) throws Exception {
        List<Livro> livros = apiClient.buscarLivros("").getResults();
        livros.stream()
                .filter(l -> l.getLanguages() != null && l.getLanguages().contains(idioma))
                .limit(10)
                .forEach(l -> {
                    System.out.println(l);
                    System.out.println("--------------------");
                });
    }
}
