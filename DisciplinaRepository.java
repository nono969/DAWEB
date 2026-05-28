package dados;

import java.util.ArrayList;
import modelo.Disciplina;

public class DisciplinaRepository {
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void salvar(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
    public ArrayList<Disciplina> listarTodos() {
        return disciplinas;
    }
    
    public Disciplina buscarPorCodigo(int codigo) {
        for(Disciplina d : disciplinas) {
            if(d.getCod() == codigo) {
                return d;
            }
        }
        return null;
    }
    
    public boolean atualizar(Disciplina disciplinaAtualizada) {
        for(int i = 0; i < disciplinas.size(); i++) {
            if(disciplinas.get(i).getCod() == disciplinaAtualizada.getCod()) {
                disciplinas.set(i, disciplinaAtualizada);
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty() {
        return disciplinas.isEmpty();
    }
}





