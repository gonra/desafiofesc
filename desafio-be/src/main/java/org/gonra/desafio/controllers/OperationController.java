package org.gonra.desafio.controllers;

import java.util.*;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/operation")
public class OperationController {

    private IOperationService operationService;
    private ITypeOperationService typeOperationService;

    @Autowired
    public void setOperationService(IOperationService operationService) {
        this.operationService = operationService;
    }

    @Autowired
    public void setTypeOperationService(ITypeOperationService typeOperationService) {
        this.typeOperationService = typeOperationService;
    }

    @GetMapping(value = "/")
    public List<OperationDto> getOperationList(@RequestParam(name = "productId", required = false) Long productId,
            @RequestParam(name = "typeId", required = false) Long typeId) {
        HashMap<String, String> pars = new HashMap<>();
        if (productId != null) {
            pars.put("productId", "" + productId);
        }
        if (typeId != null) {
            pars.put("typeId", "" + typeId);
        }
        return operationService.findByParam(pars);
    }

    @PostMapping(value = "/")
    public ProductDto stockProduct(@RequestBody AddOperationDto operationDto) {
        return operationService.storeProduct(operationDto);
    }

    @GetMapping(value = "/types")
    public List<TypeOperationDto> getTypeOperationList() {
        return typeOperationService.getListDto();
    }

    @PostMapping(value = "/types")
    public TypeOperationDto addTypeOperation(@RequestBody TypeOperationDto p) {
        return typeOperationService.addTypeOperationDto(p);
    }

    @DeleteMapping(value = "/types/{id}")
    public int deleteTypeOperation(@PathVariable Long id) {
        return typeOperationService.deleteTypeOperationById(id);
    }

}
