package iterator;

/**
 * @author Yugo
 */
public class Professor {

    private int id;
    private String nome; 
    private String dep;
    private String titulacao;
    private String tipo;

    public Professor(int id, String nome, String dep, String titulacao, String tipo) {
        this.id = id;
        this.nome = nome; 
        this.dep = dep;
        this.titulacao = titulacao;
        this.tipo = tipo;
    }

    
    public Professor() { 
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", nome=" + nome + ", dep=" + dep + ", titulacao=" + titulacao + ", tipo=" + tipo + '}';
    }
}
