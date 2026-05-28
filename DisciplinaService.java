package servicos;

import dados.DisciplinaRepository;
import modelo.Disciplina;
import modelo.Estudantes;


public class DisciplinaService {
    private DisciplinaRepository repository;
    private PrinterService printer;
    
    public DisciplinaService() {
        this.repository = new DisciplinaRepository();
        this.printer = new PrinterService();
    }
    
    public void cadastrar(Disciplina disciplina) {
        if(repository.buscarPorCodigo(disciplina.getCod()) != null) {
            printer.erro("Já existe uma disciplina com este código!");
            return;
        }
        repository.salvar(disciplina);
        printer.sucesso("Disciplina " + disciplina.getNome() + " cadastrada com sucesso!");
    }

    public Disciplina buscar(int codigo) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if(disciplina == null) {
            printer.erro("Disciplina com código " + codigo + " não encontrada!");
        }
        return disciplina;
    }
    
    public void exibirDisciplina(int codigo) {
        Disciplina disciplina = buscar(codigo);
        if(disciplina != null) {
            printer.imprimirDisciplina(disciplina);
        }
    }
    
    public void exibirDisciplinaComAlunos(int codigo) {
        Disciplina disciplina = buscar(codigo);
        if(disciplina != null) {
            printer.listarDisciplinaComAlunos(disciplina);
        }
    }
    
    public void editar(Disciplina disciplina) {
        if(repository.atualizar(disciplina)) {
            printer.sucesso("Disciplina atualizada com sucesso!");
        } else {
            printer.erro("Erro ao atualizar disciplina!");
        }
    }
    
    public void matricularEstudante(int codigoDisciplina, Estudantes estudante) {
        Disciplina disciplina = repository.buscarPorCodigo(codigoDisciplina);
        if(disciplina == null) {
            printer.erro("Disciplina não encontrada!");
            return;
        }
        if(estudante == null) {
            printer.erro("Estudante não encontrado!");
            return;
        }
        disciplina.addEstudante(estudante);
        printer.sucesso(estudante.getNome() + " matriculado em " + disciplina.getNome() + " com sucesso!");
    }
    
    public boolean existeDisciplina(int codigo) {
        return repository.buscarPorCodigo(codigo) != null;
    }
}
