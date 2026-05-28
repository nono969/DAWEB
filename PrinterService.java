package servicos;

import modelo.Estudantes;
import modelo.Disciplina;
import java.util.ArrayList;

public class PrinterService {
    
    public void linha() {
        System.out.println("═══════════════════════════════════════════════════════════");
    }
    
    public void linhaDupla() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    
    public void titulo(String texto) {
        linha();
        System.out.println("           " + texto);
        linha();
    }
    
    public void subtitulo(String texto) {
        System.out.println("\n--- " + texto + " ---");
    }
    
    public void sucesso(String mensagem) {
        System.out.println("Sucesso: " + mensagem);
    }
    
    public void erro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }
    
    public void info(String mensagem) {
        System.out.println(" ATENÇÃO:" + mensagem);
    }
    
    public void aviso(String mensagem) {
        System.out.println("AVISO:" + mensagem);
    }
    
    public void imprimirEstudante(Estudantes estudante) {
        if(estudante == null) {
            erro("Estudante não encontrado!");
            return;
        }
        linhaDupla();
        System.out.println(" DADOS DO ESTUDANTE");
        linhaDupla();
        System.out.println("   Matrícula: " + estudante.getMatricula());
        System.out.println("   Nome: " + estudante.getNome());
        System.out.println("   Idade: " + estudante.getIdade());
        System.out.println("   Contato: " + estudante.getContato());
        if(estudante.getD() != null) {
            System.out.println("   Disciplina matriculada: " + estudante.getD().getNome());
        } else {
            System.out.println("   Disciplina matriculada: Nenhuma");
        }
        linhaDupla();
    }
    
    public void imprimirDisciplina(Disciplina disciplina) {
        if(disciplina == null) {
            erro("Disciplina não encontrada!");
            return;
        }
        linhaDupla();
        System.out.println(" DADOS DA DISCIPLINA");
        linhaDupla();
        System.out.println("   Código: " + disciplina.getCod());
        System.out.println("   Nome: " + disciplina.getNome());
        System.out.println("   Professor: " + disciplina.getProfessor());
        System.out.println("   Carga Horária: " + disciplina.getCargaHoraria());
        System.out.println("   Total de alunos: " + disciplina.getQuantidadeEstudantes());
        linhaDupla();
    }
    
    public void listarEstudantes(ArrayList<Estudantes> estudantes) {
        if(estudantes.isEmpty()) {
            aviso("Nenhum estudante cadastrado!");
            return;
        }
        titulo("LISTA DE ESTUDANTES");
        for(int i = 0; i < estudantes.size(); i++) {
            Estudantes e = estudantes.get(i);
            System.out.println("   " + (i+1) + ". " + e.getNome() + " | Mat: " + e.getMatricula() + " | Idade: " + e.getIdade());
        }
        System.out.println("\n   Total: " + estudantes.size() + " estudante(s)");
        linha();
    }
    
    public void listarDisciplinas(ArrayList<Disciplina> disciplinas) {
        if(disciplinas.isEmpty()) {
            aviso("Nenhuma disciplina cadastrada!");
            return;
        }
        titulo("LISTA DE DISCIPLINAS");
        for(int i = 0; i < disciplinas.size(); i++) {
            Disciplina d = disciplinas.get(i);
            System.out.println("   " + (i+1) + ". " + d.getNome() + " | Cód: " + d.getCod() + " | Professor: " + d.getProfessor());
            System.out.println("      Alunos matriculados: " + d.getQuantidadeEstudantes());
        }
        System.out.println("\n   Total: " + disciplinas.size() + " disciplina(s)");
        linha();
    }
    
    public void listarDisciplinaComAlunos(Disciplina disciplina) {
        if(disciplina == null) {
            erro("Disciplina não encontrada!");
            return;
        }
        linhaDupla();
        System.out.println(" DISCIPLINA: " + disciplina.getNome());
        System.out.println("   Professor: " + disciplina.getProfessor());
        System.out.println("   Código: " + disciplina.getCod());
        System.out.println("   Carga Horária: " + disciplina.getCargaHoraria());
        System.out.println("\n   ALUNOS MATRICULADOS:");
        if(disciplina.getEstudantes().isEmpty()) {
            System.out.println("      Nenhum aluno matriculado ainda.");
        } else {
            for(Estudantes e : disciplina.getEstudantes()) {
                System.out.println("      • " + e.getNome() + " (Mat: " + e.getMatricula() + ")");
            }
        }
        linhaDupla();
    }
    
    public void mostrarMenu() {
        titulo("SISTEMA ACADÊMICO");
        System.out.println("   1 - Cadastrar Disciplina");
        System.out.println("   2 - Cadastrar Estudante");
        System.out.println("   3 - Matricular Estudante em Disciplina");
        System.out.println("   4 - Listar Todos");
        System.out.println("   5 - Editar Disciplina");
        System.out.println("   6 - Editar Estudante");
        System.out.println("   7 - Buscar Disciplina");
        System.out.println("   8 - Buscar Estudante");
        System.out.println("   9 - Sair");
        linha();
        System.out.print("   Escolha uma opção: ");
    }
}


