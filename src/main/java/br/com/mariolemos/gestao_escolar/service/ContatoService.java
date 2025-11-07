package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.controller.ContatoController;
import br.com.mariolemos.gestao_escolar.model.Contato;
import br.com.mariolemos.gestao_escolar.repository.AlunoRepository;
import br.com.mariolemos.gestao_escolar.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.ListDataEvent;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> buscar(){
        return contatoRepository.findAll();
    }
}
