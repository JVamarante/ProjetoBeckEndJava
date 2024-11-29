package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportacaoAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }
}