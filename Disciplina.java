
package modelo;

import java.util.ArrayList;

public class Disciplina {
    private int codigo;
    private String nome;
    private String professor;
    private String cargaHoraria;
    private ArrayList<Estudantes> listaEstudantes;

    public Disciplina(int codigo, String nome, String professor, String cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
        this.listaEstudantes = new ArrayList<>();
    }

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

    public ArrayList<Estudantes> getEstudantes() {
        return listaEstudantes;
    }

    public void addEstudante(Estudantes estudante) {
        this.listaEstudantes.add(estudante);
        estudante.setD(this);
    }
    
    public int getQuantidadeEstudantes() {
        return listaEstudantes.size();
    }
}
