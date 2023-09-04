package br.com.caixa.controller;

import br.com.caixa.data.vo.v1.GrupoVO;
import br.com.caixa.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @PostMapping
    public GrupoVO create(@RequestBody GrupoVO grupoVO){
        return service.create(grupoVO);
    }

    @GetMapping
    public List<GrupoVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public GrupoVO findById(@PathVariable(value = "id") Integer id){
        return service.findById(id);
    }

    @PutMapping
    public GrupoVO update(@RequestBody GrupoVO grupoVO){
        return service.update(grupoVO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
    }
}
