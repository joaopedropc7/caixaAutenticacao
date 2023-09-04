package br.com.caixa.controller;

import br.com.caixa.data.vo.v1.ContaVO;
import br.com.caixa.domain.models.records.ContaRecord;
import br.com.caixa.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping
    public ContaVO create(@RequestBody ContaRecord contaRecord){
        return service.create(contaRecord);
    }

    @GetMapping
    public List<ContaVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ContaVO findById(@PathVariable(value = "id") Integer id){
        return service.findById(id);
    }

    @PutMapping
    public ContaVO update(@RequestBody ContaVO contaVO){
        return service.update(contaVO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
    }

}
