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
            @RequestParam(name = "typeOperationId", required = false) Long typeOperationId) {
        Long _productId = -1L;
        Long _typeOperationId = -1L;
        if (productId != null) {
            _productId = productId;
        }
        if (typeOperationId != null) {
            _typeOperationId = typeOperationId;
        }
        return operationService.findByParam(_productId, _typeOperationId);
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
