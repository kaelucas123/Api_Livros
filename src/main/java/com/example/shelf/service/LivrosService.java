package com.example.shelf.service;

import com.example.shelf.model.DTO.LivroDTO;
import com.example.shelf.model.LivroModel;
import com.example.shelf.model.Mensagem;
import com.example.shelf.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {
    private static LivroRepository livroRepository;
    @Autowired
    public LivrosService(LivroRepository livroRepository){
        LivrosService.livroRepository = livroRepository;
    }
    public static Mensagem findLivroById(Long id) {
        Optional<LivroModel> livroOptional = livroRepository.findById(id);


        if (livroOptional.isPresent()) {
             LivroModel livro = livroOptional.get();
             LivroDTO livroDTO = new LivroDTO();
             BeanUtils.copyProperties(livro, livroDTO);

            return new Mensagem("Livro encontrado",  livroDTO);
        } else {
            return new Mensagem("Livro não encontrado",  null);
        }
    }
    public static List<LivroDTO> findAll(){
        List<LivroModel> livroModels = livroRepository.findAll();
        List<LivroDTO> livroDTOS = new ArrayList<>();
        for(LivroModel lm : livroModels){
            LivroDTO livroDTO = new LivroDTO();
            BeanUtils.copyProperties(lm, livroDTO);
            livroDTOS.add(livroDTO);
        }
        return livroDTOS;
    }
    public static Mensagem create(LivroDTO  livroDTO){
        LivroModel livroModel = new LivroModel();
        LivroDTO novoLivroDTO = new LivroDTO();
        BeanUtils.copyProperties(livroDTO, livroModel);

        if (livroModel.getNome() != null && livroModel.getAutor() != null && livroModel.getData_publicacao() != null){
            livroRepository.save(livroModel);
            return new Mensagem("Livro registrado", livroDTO);
        }
        else {
            return new Mensagem("Não foi possível registrar o livro", livroDTO);
        }
    }
    public static Mensagem deletarLivro(Long id){
        Optional<LivroModel> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()){
            LivroModel livro = livroOptional.get();
            livroRepository.delete(livro);
            Mensagem mensagemRetorno = Mensagem.builder().build();


            return new Mensagem("Livro deletado", livro);
        } else {
            return new Mensagem("Livro deletado", null);
        }

    }
}
