package servicos;

import java.util.Scanner;
import modelo.Disciplina;     
import modelo.Estudantes;     

public class ReaderService {
    private Scanner scanner;
    private PrinterService printer;
    
    public ReaderService() {
        this.scanner = new Scanner(System.in);
        this.printer = new PrinterService();
    }
    
    public int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            printer.erro("Digite um número válido!");
            System.out.print(mensagem);
            scanner.next(); 
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); 
        return valor;
    }
    
    public String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
    
    public String lerStringObrigatoria(String mensagem) {
        String texto;
        do {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                printer.aviso("Este campo não pode ficar vazio!");
            }
        } while (texto.isEmpty());
        return texto;
    }
    
    public String lerStringOpcional(String mensagem, String valorAtual) {
        System.out.print(mensagem + " [" + valorAtual + "]: ");
        String entrada = scanner.nextLine().trim();
        return entrada.isEmpty() ? valorAtual : entrada;
    }
    
    public int lerIntOpcional(String mensagem, int valorAtual) {
        System.out.print(mensagem + " [" + valorAtual + "]: ");
        String entrada = scanner.nextLine().trim();
        if (entrada.isEmpty()) {
            return valorAtual;
        }
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            printer.erro("Valor inválido! Mantendo valor atual: " + valorAtual);
            return valorAtual;
        }
    }
    
    public int lerCodigoDisciplina() {
        return lerInt("   Código da disciplina: ");
    }
    
    public int lerMatriculaEstudante() {
        return lerInt("   Matrícula do estudante: ");
    }
    
    public Disciplina lerNovaDisciplina() {
        printer.subtitulo("CADASTRO DE DISCIPLINA");
        int codigo = lerInt("   Código: ");
        String nome = lerStringObrigatoria("   Nome: ");
        String professor = lerStringObrigatoria("   Professor: ");
        String cargaHoraria = lerStringObrigatoria("   Carga Horária: ");
        return new Disciplina(codigo, nome, professor, cargaHoraria);
    }
    
    public Estudantes lerNovoEstudante() {
        printer.subtitulo("CADASTRO DE ESTUDANTE");
        int matricula = lerInt("   Matrícula: ");
        String nome = lerStringObrigatoria("   Nome: ");
        int idade = lerInt("   Idade: ");
        String contato = lerStringObrigatoria("   Contato: ");
        return new Estudantes(matricula, nome, idade, contato);
    }
    
    public void lerEdicaoDisciplina(Disciplina disciplina) {
        printer.info("Deixe em branco para manter o valor atual");
        String novoNome = lerStringOpcional("   Novo nome", disciplina.getNome());
        String novoProfessor = lerStringOpcional("   Novo professor", disciplina.getProfessor());
        String novaCarga = lerStringOpcional("   Nova carga horária", disciplina.getCargaHoraria());
        
        disciplina.setNome(novoNome);
        disciplina.setProfessor(novoProfessor);
        disciplina.setCargaHoraria(novaCarga);
    }
    
    public void lerEdicaoEstudante(Estudantes estudante) {
        printer.info("Deixe em branco para manter o valor atual");
        String novoNome = lerStringOpcional("   Novo nome", estudante.getNome());
        int novaIdade = lerIntOpcional("   Nova idade", estudante.getIdade());
        String novoContato = lerStringOpcional("   Novo contato", estudante.getContato());
        
        estudante.setNome(novoNome);
        estudante.setIdade(novaIdade);
        estudante.setContato(novoContato);
    }
    
    public void esperarEnter() {
        scanner.nextLine();  
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine(); 
    }
    
    public void fechar() {
        scanner.close();
    }
}