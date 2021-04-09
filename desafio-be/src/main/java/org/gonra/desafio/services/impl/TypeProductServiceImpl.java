package org.gonra.desafio.services.impl;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.repository.*;
import org.gonra.desafio.entities.*;
import org.gonra.desafio.services.ITypeProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TypeProductServiceImpl implements ITypeProductService {

    private ModelMapper mapper;
    private TypeProductRepository typeProductRepository;

    @Autowired
    public TypeProductServiceImpl(TypeProductRepository typeProductRepository) {
        this.typeProductRepository = typeProductRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public TypeProduct addTypeProduct(TypeProduct p) {
        return typeProductRepository.save(p);
    }

    @Override
    public TypeProduct getTypeProductById(Long id) {
        TypeProduct p = typeProductRepository.getOne(id);
        return p;
    }

    @Override
    public TypeProduct updateTypeProduct(TypeProduct p) {
        return typeProductRepository.save(p);
    }

    @Override
    public int deleteTypeProduct(TypeProduct p) {
        typeProductRepository.delete(p);
        return 1;
    }

    @Override
    public int deleteTypeProductById(Long id) {
        typeProductRepository.deleteById(id);
        return 1;
    }

    @Override
    public List<TypeProduct> getList() {
        List<TypeProduct> result = typeProductRepository.findAll();
        return result;
    }

    @Override
    public TypeProductDto addTypeProductDto(TypeProductDto pDto) {
        TypeProduct p = new TypeProduct();
        p.setDescription(pDto.getDescription());

        TypeProduct r = typeProductRepository.save(p);
        TypeProductDto resp = mapper.map(r, TypeProductDto.class);
        return resp;
    }

    @Override
    public List<TypeProductDto> getListDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TypeProductDto updateTypeProductDto(TypeProductDto pDto) {
        // TODO Auto-generated method stub
        return null;
    }

}
