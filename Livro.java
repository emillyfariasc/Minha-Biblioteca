import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora atributos desnecessários no JSON
public class Livro {

    private int id;

    @JsonAlias("title") // Pega o campo "title" do JSON
    private String titulo;

    private List<Autor> authors;

    private List<String> languages;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<Autor> getAuthors() { return authors; }
    public void setAuthors(List<Autor> authors) { this.authors = authors; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    // toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("📘 Título: ").append(titulo).append("\n");

        if (authors != null) {
            for (Autor autor : authors) {
                sb.append("✍️ Autor: ").append(autor.getName()).append("\n");
            }
        }

        sb.append("🌍 Idiomas: ").append(languages).append("\n");
        return sb.toString();
    }
}

