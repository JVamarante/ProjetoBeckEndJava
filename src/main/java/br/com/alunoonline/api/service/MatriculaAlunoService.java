package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService  {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    //e aqui onde o aluno vai se matricular

    public void criaMatricula(MatriculaAluno matriculaAluno){
        matriculaAlunoRepository.save(matriculaAluno);
    }

}
