package org.gonra.desafio.services;

import org.gonra.desafio.dto.TypeProductDto;
import org.gonra.desafio.entities.*;
import java.util.*;

public interface ITypeProductService {

    public TypeProduct addTypeProduct(TypeProduct p);

    public TypeProduct getTypeProductById(Long id);

    public List<TypeProduct> getList();

    public List<TypeProductDto> getListDto();

    public TypeProduct updateTypeProduct(TypeProduct p);

    public int deleteTypeProduct(TypeProduct p);

    public int deleteTypeProductById(Long id);

    public TypeProductDto addTypeProductDto(TypeProductDto pDto);

    public TypeProductDto updateTypeProductDto(TypeProductDto pDto);

}
