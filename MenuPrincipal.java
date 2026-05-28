package apresentacao;

import servicos.PrinterService;
import servicos.ReaderService;
import modelo.Estudantes;
import modelo.Disciplina;

public class MenuPrincipal {
    public static void main(String[] args) {
        PrinterService printer = new PrinterService();
        ReaderService reader = new ReaderService();
        EstudantesService estudanteService = new EstudantesService();
        DisciplinaService disciplinaService = new DisciplinaService();
        
        int opcao;
        
        do {
            printer.mostrarMenu();
            opcao = reader.lerInt("");
            
            switch(opcao) {
                case 1: // cadastrar disciplina
                    Disciplina novaDisciplina = reader.lerNovaDisciplina();
                    disciplinaService.cadastrar(novaDisciplina);
                    reader.esperarEnter();
                    break;
                    
                case 2: // cadastrar estudante
                    Estudantes novoEstudante = reader.lerNovoEstudante();
                    estudanteService.cadastrar(novoEstudante);
                    reader.esperarEnter();
                    break;
                    
                case 3: // matricular 
                    printer.subtitulo("MATRICULAR ESTUDANTE EM DISCIPLINA");
                    int matricula = reader.lerMatriculaEstudante();
                    Estudantes estudante = estudanteService.buscar(matricula);
                    
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
                    Disciplina disciplina = disciplinaService.buscar(codEditar);
                    
                    if(disciplina == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    printer.imprimirDisciplina(disciplina);
                    reader.lerEdicaoDisciplina(disciplina);
                    disciplinaService.editar(disciplina);
                    reader.esperarEnter();
                    break;
                    
                case 6: // editar estudante
                    printer.subtitulo("EDITAR ESTUDANTE");
                    int matEditar = reader.lerMatriculaEstudante();
                    Estudantes estudanteEditar = estudanteService.buscar(matEditar);
                    
                    if(estudanteEditar == null) {
                        reader.esperarEnter();
                        break;
                    }
                    
                    printer.imprimirEstudante(estudanteEditar);
                    reader.lerEdicaoEstudante(estudanteEditar);
                    estudanteService.editar(estudanteEditar);
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

    private static class DisciplinaService {
        void cadastrar(Disciplina disciplina) {}
        void matricularEstudante(int codigo, Estudantes estudante) {}
        void exibirLista() {}
        Disciplina buscar(int codigo) { return null; }
        void editar(Disciplina disciplina) {}
        void exibirDisciplinaComAlunos(int codigo) {}
    }

    private static class EstudantesService {
        void cadastrar(Estudantes estudante) {}
        Estudantes buscar(int matricula) { return null; }
        void exibirLista() {}
        void editar(Estudantes estudante) {}
        void exibirEstudante(int matricula) {}
    }
}