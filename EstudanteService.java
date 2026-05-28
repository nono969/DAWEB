package servicos;

import dados.EstudanteRepository;
import modelo.Estudantes;

public class EstudanteService {
    private EstudanteRepository repository;
    private PrinterService printer;
    
    public EstudanteService() {
        this.repository = new EstudanteRepository();
        this.printer = new PrinterService();
    }
    
    public void cadastrar(Estudantes estudante) {
        if(repository.buscarPorMatricula(estudante.getMatricula()) != null) {
            printer.erro("Já existe um estudante com esta matrícula!");
            return;
        }
        repository.salvar(estudante);
        printer.sucesso("Estudante " + estudante.getNome() + " cadastrado com sucesso!");
    }
    

    
    public Estudantes buscar(int matricula) {
        Estudantes estudante = repository.buscarPorMatricula(matricula);
        if(estudante == null) {
            printer.erro("Estudante com matrícula " + matricula + " não encontrado!");
        }
        return estudante;
    }
    
    public void exibirEstudante(int matricula) {
        Estudantes estudante = buscar(matricula);
        if(estudante != null) {
            printer.imprimirEstudante(estudante);
        }
    }
    
    public void editar(Estudantes estudante) {
        if(repository.atualizar(estudante)) {
            printer.sucesso("Estudante atualizado com sucesso!");
        } else {
            printer.erro("Erro ao atualizar estudante!");
        }
    }
    
    public boolean existeEstudante(int matricula) {
        return repository.buscarPorMatricula(matricula) != null;
    }
}

