package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ExportacaoProfessorService;
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
public class ExportacaoProfessorController {

    @Autowired
    private ExportacaoProfessorService exportacaoProfessorService;

    @GetMapping("/professor/csv")
    public void exportarProfessorCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=professores.csv");

        List<Professor> professores = exportacaoProfessorService.buscarTodosProfessores();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("ID,Nome,Email");

            for (Professor professor : professores) {
                writer.println(professor.getId() + "," + professor.getNome() + "," + professor.getEmail());
            }
        }
    }
}