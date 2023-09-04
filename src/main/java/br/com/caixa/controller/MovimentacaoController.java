package br.com.caixa.controller;

import br.com.caixa.data.vo.v1.MovimentacaoVO;
import br.com.caixa.domain.models.records.MovimentacaoRecord;
import br.com.caixa.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping
    public MovimentacaoVO create(@RequestBody MovimentacaoRecord movimentacaoRecord){
        return service.create(movimentacaoRecord);
    }

    @GetMapping
    public List<MovimentacaoVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public MovimentacaoVO findById(@PathVariable(value = "id") Integer id){
        return service.findById(id);
    }

    @PutMapping
    public MovimentacaoVO update(@RequestBody MovimentacaoVO movimentacaoVO){
        return service.update(movimentacaoVO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
    }
}
