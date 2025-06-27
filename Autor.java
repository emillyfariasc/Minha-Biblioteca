import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {

    @JsonAlias("name")
    private String name;

    @JsonAlias("birth_year")
    private int nascimento;

    @JsonAlias("death_year")
    private int falecimento;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNascimento() { return nascimento; }
    public void setNascimento(int nascimento) { this.nascimento = nascimento; }

    public int getFalecimento() { return falecimento; }
    public void setFalecimento(int falecimento) { this.falecimento = falecimento; }

    @Override
    public String toString() {
        return name + " (" + nascimento + " - " + falecimento + ")";
    }
}
