package servicos;

import dados.DisciplinaRepository;
import modelo.Disciplina;
import modelo.Estudantes;
import java.util.ArrayList;

public class DisciplinaService {
    private DisciplinaRepository repository;
    private PrinterService printer;
    
    public DisciplinaService() {
        this.repository = new DisciplinaRepository();
        this.printer = new PrinterService();
    }
    
    public void cadastrar(DisciplinaDTO dto) {
        if(repository.buscarPorCodigo(dto.getCod()) != null) {
            printer.erro("Já existe uma disciplina com este código!");
            return;
        }
        Disciplina disciplina = new Disciplina(
            dto.getCod(), 
            dto.getNome(), 
            dto.getProfessor(), 
            dto.getCargaHoraria()
        );
        repository.salvar(disciplina);
        printer.sucesso("Disciplina " + disciplina.getNome() + " cadastrada com sucesso!");
    }

    public DisciplinaDTO buscar(int codigo) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if(disciplina == null) {
            printer.erro("Disciplina com código " + codigo + " não encontrada!");
            return null;
        }
        return new DisciplinaDTO(
            disciplina.getCod(),
            disciplina.getNome(),
            disciplina.getProfessor(),
            disciplina.getCargaHoraria()
        );
    }
    
    public void exibirDisciplina(int codigo) {
        DisciplinaDTO dto = buscar(codigo);
        if(dto != null) {
            printer.imprimirDisciplina(dto);
        }
    }
    
    public void exibirDisciplinaComAlunos(int codigo) {
        Disciplina disciplina = repository.buscarPorCodigo(codigo);
        if(disciplina != null) {
            printer.listarDisciplinaComAlunos(disciplina);
        }
    }
    
      public void editar(DisciplinaDTO dto) {
        Disciplina disciplinaExistente = repository.buscarPorCodigo(dto.getCod());
        if(disciplinaExistente == null) {
            printer.erro("Disciplina não encontrada!");
            return;
        }
        
        // cria uma nova disciplina com os dados atualizados
        Disciplina disciplinaAtualizada = new Disciplina(
            dto.getCod(),
            dto.getNome(),
            dto.getProfessor(),
            dto.getCargaHoraria()
        );
        
        // preserva a lista de estudantes da disciplina existente
        for(Estudantes estudante : disciplinaExistente.getEstudantes()) {
            disciplinaAtualizada.addEstudante(estudante);
        }
        
        // atualizar no repositório
        if(repository.atualizar(disciplinaAtualizada)) {
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
    
    public void exibirLista() {
        ArrayList<Disciplina> disciplinas = repository.listarTodos();
        printer.listarDisciplinas(disciplinas);
    }
}

