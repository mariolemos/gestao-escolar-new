package br.com.mariolemos.gestao_escolar.service;

import br.com.mariolemos.gestao_escolar.model.Colegio;
import br.com.mariolemos.gestao_escolar.model.Contato;
import br.com.mariolemos.gestao_escolar.model.Endereco;
import br.com.mariolemos.gestao_escolar.repository.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;
    @Autowired
    private ContatoService contatoService;

    public List<Colegio> buscar(){
        List<Colegio> colegios = colegioRepository.findAll();
        return colegios;
    }
    public Colegio buscarPorId(Long id){
        return colegioRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
    }

    public Colegio incluir(Colegio colegio){
        return colegioRepository.save(colegio);
    }
    public Colegio atualizar(Colegio colegio, Long id){

        Colegio colegio1 = buscarPorId(id);
        colegio1.setNome(colegio.getNome());
        colegio1.setHorario(colegio.getHorario());

        List<Contato> contatos = colegio1.getContatos();
        contatoService.deleteAll(contatos);
        colegio1.setContatos(colegio.getContatos());

        if(colegio.getEndereco() != null) {
//
            colegio1.getEndereco().setCep(colegio.getEndereco().getCep());
            colegio1.getEndereco().setNumero(colegio.getEndereco().getNumero());
            colegio1.getEndereco().setComplemento(colegio.getEndereco().getComplemento());
            colegio1.getEndereco().setLogradouro(colegio.getEndereco().getLogradouro());
            colegio1.getEndereco().setBairro(colegio.getEndereco().getBairro());
            colegio1.getEndereco().setCidade(colegio.getEndereco().getCidade());
            colegio1.getEndereco().setEstado(colegio.getEndereco().getEstado());
        }


        return colegioRepository.save(colegio1);
    }
    public void excluir(Long id){
        colegioRepository.deleteById(id);
    }
}
