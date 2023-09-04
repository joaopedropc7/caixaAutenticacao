package br.com.caixa.service;

import br.com.caixa.data.vo.v1.ContaVO;
import br.com.caixa.mapper.DozerMapper;
import br.com.caixa.domain.models.Conta;
import br.com.caixa.domain.models.records.ContaRecord;
import br.com.caixa.repositories.ContaRepository;
import br.com.caixa.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private GrupoRepository grupoRepository;

    public ContaVO create(ContaRecord contaRecord){
        var grupo = grupoRepository.findById(contaRecord.idGrupo()).orElseThrow(() -> new RuntimeException(""));
        Conta conta = new Conta(contaRecord, grupo);
        var vo = DozerMapper.parseObject(repository.save(conta), ContaVO.class);
        return vo;
    }

    public List<ContaVO> findAll(){
        var entity = repository.findAll();
        var vo = DozerMapper.parseListObjects(entity, ContaVO.class);
        return vo;
    }

    public ContaVO findById(Integer id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException(""));
        var vo =  DozerMapper.parseObject(entity, ContaVO.class);
        return vo;
    }

    public ContaVO update(ContaVO contaVO){
        var entity = repository.findById(contaVO.getKey()).orElseThrow(() -> new RuntimeException(""));
        entity.setGrupo(contaVO.getGrupo());
        entity.setNomeConta(contaVO.getNomeConta());
        entity.setTipoConta(contaVO.getTipoConta());
        repository.save(entity);
        var vo = DozerMapper.parseObject(entity, ContaVO.class);
        return vo;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

}
