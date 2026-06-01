package apresentacao;

import servicos.PrinterService;
import servicos.ReaderService;
import servicos.EstudanteService;
import servicos.DisciplinaService;
import servicos.EstudanteDTO;
import servicos.DisciplinaDTO;
import modelo.Estudantes;

public class MenuPrincipal {
    public static void main(String[] args) {
        PrinterService printer = new PrinterService();
        ReaderService reader = new ReaderService();
        EstudanteService estudanteService = new EstudanteService();
        DisciplinaService disciplinaService = new DisciplinaService();
        
        int opcao;
        
        do {
            printer.mostrarMenu();
            opcao = reader.lerInt("");
            
            switch(opcao) {
                case 1: // cadastrar disciplina
                    DisciplinaDTO novaDisciplina = reader.lerNovaDisciplina();
                    disciplinaService.cadastrar(novaDisciplina);
                    reader.esperarEnter();
                    break;
                    
                case 2: // cadastrar estudante
                    EstudanteDTO novoEstudante = reader.lerNovoEstudante();
                    estudanteService.cadastrar(novoEstudante);
                    reader.esperarEnter();
                    break;
                    
                case 3: // matricular 
                    printer.subtitulo("MATRICULAR ESTUDANTE EM DISCIPLINA");
                    int matricula = reader.lerMatriculaEstudante();
                    EstudanteDTO estudanteDTO = estudanteService.buscar(matricula);
                    
                    if(estudanteDTO == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    // Precisa do modelo para matricular (relacionamento)
                    Estudantes estudante = estudanteService.buscarModelo(matricula);
                    if(estudante == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    int codigo = reader.lerCodigoDisciplina();
                    disciplinaService.matricularEstudante(codigo, estudante);
                    reader.esperarEnter();
                    break;
                    
                case 4: // listar tudo
                    printer.titulo("LISTA COMPLETA");
                    disciplinaService.exibirLista();
                    estudanteService.exibirLista();
                    reader.esperarEnter();
                    break;
                    
                case 5: // editar disciplina
                    printer.subtitulo("EDITAR DISCIPLINA");
                    int codEditar = reader.lerCodigoDisciplina();
                    DisciplinaDTO disciplinaDTO = disciplinaService.buscar(codEditar);
                    
                    if(disciplinaDTO == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    printer.imprimirDisciplina(disciplinaDTO);
                    DisciplinaDTO disciplinaEditada = reader.lerEdicaoDisciplina(
                        codEditar,
                        disciplinaDTO.getNome(),
                        disciplinaDTO.getProfessor(),
                        disciplinaDTO.getCargaHoraria()
                    );
                    disciplinaService.editar(disciplinaEditada);
                    reader.esperarEnter();
                    break;
                    
                case 6: // editar estudante
                    printer.subtitulo("EDITAR ESTUDANTE");
                    int matEditar = reader.lerMatriculaEstudante();
                    EstudanteDTO estudanteEditarDTO = estudanteService.buscar(matEditar);
                    
                    if(estudanteEditarDTO == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    printer.imprimirEstudante(estudanteEditarDTO);
                    EstudanteDTO estudanteEditado = reader.lerEdicaoEstudante(
                        matEditar,
                        estudanteEditarDTO.getNome(),
                        estudanteEditarDTO.getIdade(),
                        estudanteEditarDTO.getContato()
                    );
                    estudanteService.editar(estudanteEditado);
                    reader.esperarEnter();
                    break;
                    
                case 7: // buscar disciplina
                    printer.subtitulo("BUSCAR DISCIPLINA");
                    int codBusca = reader.lerCodigoDisciplina();
                    disciplinaService.exibirDisciplinaComAlunos(codBusca);
                    reader.esperarEnter();
                    break;
                    
                case 8: // buscar estudante
                    printer.subtitulo("BUSCAR ESTUDANTE");
                    int matBusca = reader.lerMatriculaEstudante();
                    estudanteService.exibirEstudante(matBusca);
                    reader.esperarEnter();
                    break;
                    
                case 9: // sair
                    printer.titulo("ENCERRANDO O SISTEMA");
                    printer.sucesso("Volte sempre!");
                    break;
                    
                default:
                    printer.erro("Opção inválida! Digite um número de 1 a 9.");
                    reader.esperarEnter();
            }
            
        } while(opcao != 9);
        
        reader.fechar();
    }
}
