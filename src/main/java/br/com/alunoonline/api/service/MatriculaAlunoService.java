package br.com.alunoonline.api.service;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaAlunoService  {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    //e aqui onde o aluno vai se matricular

    public void criaMatricula(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }
    //Aqui o aluno traca a matricula

    public void trancarMatricula(Long matriculaAlunoId){
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow( () ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matricula Aluno não encontrada!"));

        if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())){
            // Lancar o erro se o status não for matriculado
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "So e possivel trancar uma matricula com status MATRICULADO");
        }

        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);

        matriculaAlunoRepository.save(matriculaAluno);

    }

}
