package org.gonra.desafio.services;

import org.gonra.desafio.dto.*;
import org.gonra.desafio.entities.*;
import java.util.*;

public interface ITypeOperationService {
    public TypeOperation addTypeOperation(TypeOperation p);

    public TypeOperation getTypeOperationById(Long id);

    public List<TypeOperation> getList();

    public TypeOperation updateTypeOperation(TypeOperation p);

    public int deleteTypeOperation(TypeOperation p);

    public int deleteTypeOperationById(Long id);

    public TypeOperationDto addTypeOperationDto(TypeOperationDto p);

    public List<TypeOperationDto> getListDto();

}
