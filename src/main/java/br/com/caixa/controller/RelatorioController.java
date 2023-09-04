package br.com.caixa.controller;

import br.com.caixa.domain.models.Relatorio;
import br.com.caixa.domain.models.RelatorioResponse;
import br.com.caixa.domain.models.RelatorioResponseGrupo;
import br.com.caixa.domain.models.TipoReceita;
import br.com.caixa.domain.models.records.DataRequisicaoDTO;
import br.com.caixa.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping(value = "/{tipoReceita}")
    public List<Relatorio> relatorioTipoReceita(@PathVariable(value = "tipoReceita") TipoReceita tipoReceita){
        return service.findByTipoReceita(tipoReceita);
    }


    @GetMapping(value = "/conta/{ids}")
    public RelatorioResponse relatorioByConta(@PathVariable List<Integer> ids){
        return service.findByContaIds(ids);
    }

    @PostMapping("/data")
    public RelatorioResponse relatorioByPeriodo(@RequestBody DataRequisicaoDTO periodoRequest){
        LocalDateTime dataInicio = periodoRequest.dataInicio();
        LocalDateTime dataFim = periodoRequest.dataFim();
        System.out.println(dataInicio + " ---- " + dataFim);
        return service.findMovimentacoesEntreDatas(dataInicio, dataFim);
    }

    @GetMapping("/grupo/{id}")
    public RelatorioResponseGrupo relatorioByGrupo(@PathVariable(value = "id") Integer id){
        return service.findByMovimentacoesGrupo(id);
    }
}
