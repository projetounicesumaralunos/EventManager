package br.com.gestao_eventos.gestao_eventos.modules.empresa.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao_eventos.gestao_eventos.modules.empresa.EmpresaEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
      @PostMapping("/")
      public void create(@Valid @RequestBody EmpresaEntity empresaEntity) {
            System.out.println("empresa");
            System.out.println(empresaEntity.getEmail());
      }
}
