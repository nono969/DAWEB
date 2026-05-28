package modelo;

public class Estudantes {
    private int matricula;
    private String nome;
    private int idade;
    private String contato;
    private Disciplina disciplinaMatriculada;

    public Estudantes(int matricula, String nome, int idade, String contato) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.disciplinaMatriculada = null;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Disciplina getD() {
        return disciplinaMatriculada;
    }

    public void setD(Disciplina disciplina) {
        this.disciplinaMatriculada = disciplina;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | Idade: " + idade + " | Contato: " + contato;
    }
}
