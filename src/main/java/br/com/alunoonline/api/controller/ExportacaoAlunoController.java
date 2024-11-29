package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.ExportacaoAlunoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/exportar")
public class ExportacaoAlunoController {

    @Autowired
    private ExportacaoAlunoService exportacaoAlunoService;

    @GetMapping("/aluno/csv")
    public void exportarAlunoCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=alunos.csv");

        List<Aluno> alunos = exportacaoAlunoService.buscarTodosAlunos();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("ID,Nome,Email");

            for (Aluno aluno : alunos) {
                writer.println(aluno.getId() + "," + aluno.getNome() + "," + aluno.getEmail());
            }
        }
    }
}