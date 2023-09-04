package br.com.caixa.service;

import br.com.caixa.data.vo.v1.GrupoVO;
import br.com.caixa.mapper.DozerMapper;
import br.com.caixa.domain.models.Grupo;
import br.com.caixa.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;


    public GrupoVO create(GrupoVO grupoVO){
        var entity = DozerMapper.parseObject(grupoVO, Grupo.class);
        var vo = DozerMapper.parseObject(repository.save(entity), GrupoVO.class);
        return vo;
    }

    public GrupoVO findById(Integer id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException(""));
        var vo = DozerMapper.parseObject(entity, GrupoVO.class);
        return vo;
    }

    public List<GrupoVO> findAll(){
        var entity = repository.findAll();
        var vo = DozerMapper.parseListObjects(entity, GrupoVO.class);
        return vo;
    }

    public GrupoVO update(GrupoVO grupoVO){
        var entity = repository.findById(grupoVO.getKey()).orElseThrow(() -> new RuntimeException(""));
        entity.setName(grupoVO.getName());
        repository.save(entity);
        var vo = DozerMapper.parseObject(entity, GrupoVO.class);
        return vo;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }


}
