package com.example.shelf.resource;

import com.example.shelf.model.DTO.LivroDTO;
import com.example.shelf.model.Mensagem;
import com.example.shelf.service.LivrosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController //Tipo de annoation que vai definir o comportamento da classe;
@RequestMapping("/livros") //Annotation onde a classe será acessada;
@AllArgsConstructor//cria um construtor com todos os atributos;
public class LivroResource {

    @GetMapping//Define um endpoint quando enviada uma requesição do tipo get, no caminho específicado;
    public ResponseEntity<List<LivroDTO>> findAll(){
        return ResponseEntity.ok().body(LivrosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> findById(@PathVariable long id){
        return ResponseEntity.ok().body(LivrosService.findLivroById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensagem> delete(@PathVariable long id){
        return ResponseEntity.ok().body(LivrosService.deletarLivro(id));
    }

    @PostMapping
    public ResponseEntity<Mensagem> create(@RequestBody LivroDTO livroDTO){
        return ResponseEntity.ok().body(LivrosService.create(livroDTO));
    }
}
