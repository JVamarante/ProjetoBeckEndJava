package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void criaProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> listarTodosProfessores(){
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarProfessorPorId(Long id){
        return professorRepository.findById(id);
    }

    public void deletarProfessorPorId(Long id){
        professorRepository.deleteById(id);
    }

    public void atualizarProfessorPorId(Long id, Professor professor){
        // Verifica se o professor existe no banco de dados
        Optional<Professor> professorDoBancoDeDados = buscarProfessorPorId(id);

        // Se o professor não for encontrado, lança exceção
        if (professorDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado no banco de dados");
        }

        // Atualiza os dados do professor
        Professor professorEditado = professorDoBancoDeDados.get();
        professorEditado.setNome(professor.getNome());
        professorEditado.setCpf(professor.getCpf());
        professorEditado.setEmail(professor.getEmail());

        // Salva o professor atualizado no banco de dados
        professorRepository.save(professorEditado);
    }
}
