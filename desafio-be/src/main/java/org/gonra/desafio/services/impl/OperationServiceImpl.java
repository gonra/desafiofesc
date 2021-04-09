package org.gonra.desafio.services.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.entities.*;
import org.gonra.desafio.repository.*;
import org.gonra.desafio.services.IOperationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements IOperationService {

    private ModelMapper mapper;
    private final OperationRepository operationRepository;
    private final TypeOperationRepository typeOperationRepository;
    private final ProductRepository productRepository;
    private SimpleDateFormat dateFormat;

    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository,
            TypeOperationRepository typeOperationRepository, ProductRepository productRepository) {
        this.operationRepository = operationRepository;
        this.typeOperationRepository = typeOperationRepository;
        this.productRepository = productRepository;
        this.mapper = new ModelMapper();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public List<OperationDto> findByParam(HashMap<String, String> params) {
        List<Operation> operationList = operationRepository.findAll();
        if (operationList != null) {
            OperationDto[] dtoList = mapper.map(operationList, OperationDto[].class);
            return Arrays.asList(dtoList);
        }
        return null;
    }

    @Override
    public OperationDto getOperationDtoById(Long id) {
        Operation p = operationRepository.getOne(id);
        if (p != null) {
            OperationDto p1 = mapper.map(p, OperationDto.class);
            return p1;
        }
        return null;
    }

    @Override
    public ProductDto storeProduct(AddOperationDto p) {
        ProductDto result = new ProductDto();

        Product product = productRepository.getOne(p.getProductId());
        TypeOperation typeOperation = typeOperationRepository.getOne(p.getTypeOperationId());
        if ((product != null) && (typeOperation != null)) {
            int quantity = product.getStock() + p.getQuantity();
            if (quantity > 0) {
                product.setStock(quantity);
                productRepository.save(product);

                Operation op = new Operation();
                op.setProduct(product);
                op.setQuantity(p.getQuantity());
                op.setSalePrice(p.getSalePrice());
                op.setTypeOperation(typeOperation);
                op.setDatetime(dateFormat.format(new Date()));
                operationRepository.save(op);

                result = mapper.map(product, ProductDto.class);
            } else {
                result.setId(-1);
            }
        }
        return result;
    }

}
