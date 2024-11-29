package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportacaoProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> buscarTodosProfessores() {
        return professorRepository.findAll();
    }
}