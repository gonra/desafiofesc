package org.gonra.desafio.services.impl;

import java.util.*;

import org.gonra.desafio.dto.TypeOperationDto;
import org.gonra.desafio.entities.TypeOperation;
import org.gonra.desafio.repository.TypeOperationRepository;
import org.gonra.desafio.services.ITypeOperationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOperationServiceImpl implements ITypeOperationService {

    private ModelMapper mapper;
    private final TypeOperationRepository typeOperationRepository;

    @Autowired
    public TypeOperationServiceImpl(TypeOperationRepository repo) {
        typeOperationRepository = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public TypeOperation addTypeOperation(TypeOperation p) {
        return typeOperationRepository.save(p);
    }

    @Override
    public TypeOperation getTypeOperationById(Long id) {
        return typeOperationRepository.getOne(id);
    }

    @Override
    public List<TypeOperation> getList() {
        List<TypeOperation> result = typeOperationRepository.findAll();
        return result;
    }

    @Override
    public TypeOperation updateTypeOperation(TypeOperation p) {
        return typeOperationRepository.save(p);
    }

    @Override
    public int deleteTypeOperation(TypeOperation p) {
        typeOperationRepository.delete(p);
        return 1;
    }

    @Override
    public int deleteTypeOperationById(Long id) {
        typeOperationRepository.deleteById(id);
        return 0;
    }

    @Override
    public TypeOperationDto addTypeOperationDto(TypeOperationDto p) {
        TypeOperation p1 = new TypeOperation();
        p1.setDescription(p.getDescription());
        TypeOperation p2 = typeOperationRepository.save(p1);
        if (p2 != null) {
            return mapper.map(p2, TypeOperationDto.class);
        }
        return null;
    }

    @Override
    public List<TypeOperationDto> getListDto() {
        List<TypeOperation> p = typeOperationRepository.findAll();
        List<TypeOperationDto> result = new ArrayList<>();
        if (p != null) {
            TypeOperationDto[] p2 = mapper.map(p, TypeOperationDto[].class);
            result.addAll(Arrays.asList(p2));
        }
        return result;
    }

}
