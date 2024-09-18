package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criaAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);

    }
    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);

    }
    public void atualizarAlunoPorId(Long id, Aluno aluno){
        // Primeiro passo: Verificar se o aluno existe no banco de dados
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        // Se o aluno não for encontrado, lança exceção
        if (alunoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }

        // Se o aluno existe, fazer a atualização
        Aluno alunoEditado = alunoDoBancoDeDados.get();

        // Aqui, todos os campos são atualizados com os valores fornecidos, mesmo que sejam null
        alunoEditado.setNome(aluno.getNome());
        alunoEditado.setCpf(aluno.getCpf());
        alunoEditado.setEmail(aluno.getEmail());

        // Persistir o aluno atualizado no banco de dados
        alunoRepository.save(alunoEditado);
    }


}
