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
    
    public void cadastrar(EstudanteDTO dto) {
        if(repository.buscarPorMatricula(dto.getMatricula()) != null) {
            printer.erro("Já existe um estudante com esta matrícula!");
            return;
        }
        Estudantes estudante = new Estudantes(
            dto.getMatricula(),
            dto.getNome(),
            dto.getIdade(),
            dto.getContato()
        );
        repository.salvar(estudante);
        printer.sucesso("Estudante " + estudante.getNome() + " cadastrado com sucesso!");
    }
    
    public EstudanteDTO buscar(int matricula) {
        Estudantes estudante = repository.buscarPorMatricula(matricula);
        if(estudante == null) {
            printer.erro("Estudante com matrícula " + matricula + " não encontrado!");
            return null;
        }
        return new EstudanteDTO(
            estudante.getMatricula(),
            estudante.getNome(),
            estudante.getIdade(),
            estudante.getContato()
        );
    }
    
    public void exibirEstudante(int matricula) {
        EstudanteDTO dto = buscar(matricula);
        if(dto != null) {
            printer.imprimirEstudante(dto);
        }
    }
    
    
    public void editar(EstudanteDTO dto) {
        Estudantes estudanteExistente = repository.buscarPorMatricula(dto.getMatricula());
        if(estudanteExistente == null) {
            printer.erro("Estudante não encontrado!");
            return;
        }
        
        // cria um novo estudante com os dados atualizados
        Estudantes estudanteAtualizado = new Estudantes(
            dto.getMatricula(),
            dto.getNome(),
            dto.getIdade(),
            dto.getContato()
        );
        
        // Preservar a disciplina matriculada do estudante existente
        estudanteAtualizado.setD(estudanteExistente.getD());
        
        // tualiza no repositório
        if(repository.atualizar(estudanteAtualizado)) {
            printer.sucesso("Estudante atualizado com sucesso!");
            
                       if(estudanteExistente.getD() != null) {
                            }
        } else {
            printer.erro("Erro ao atualizar estudante!");
        }
    }
    
    public boolean existeEstudante(int matricula) {
        return repository.buscarPorMatricula(matricula) != null;
    }
    
    public Estudantes buscarModelo(int matricula) {
        return repository.buscarPorMatricula(matricula);
    }
    
    public void exibirLista() {
        printer.listarEstudantes(repository.listarTodos());
    }
}
