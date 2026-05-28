package servicos;


public class DisciplinaDTO { 
    private int codigo;
    private String nome;
    private String professor;
    private String cargaHoraria;
    public DisciplinaDTO(int codigo, String nome, String professor, String cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;    }

    public int getCod() {
        return codigo;
    }

    public void setCod(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Professor: " + professor + " | Carga Horária: " + cargaHoraria;
    }
}

