package dados;

import java.util.ArrayList;
import modelo.Estudantes;

public class EstudanteRepository {
    private ArrayList<Estudantes> estudantes = new ArrayList<>();

    public void salvar(Estudantes estudante) {
        estudantes.add(estudante);
    }
    
    public ArrayList<Estudantes> listarTodos() {
        return estudantes;
    }
    
    public Estudantes buscarPorMatricula(int matricula) {
        for(Estudantes e : estudantes) {
            if(e.getMatricula() == matricula) {
                return e;
            }
        }
        return null;
    }
    
    public boolean atualizar(Estudantes estudanteAtualizado) {
        for(int i = 0; i < estudantes.size(); i++) {
            if(estudantes.get(i).getMatricula() == estudanteAtualizado.getMatricula()) {
                estudantes.set(i, estudanteAtualizado);
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty() {
        return estudantes.isEmpty();
    }
}

