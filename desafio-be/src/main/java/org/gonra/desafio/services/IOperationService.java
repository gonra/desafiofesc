package org.gonra.desafio.services;

import org.gonra.desafio.dto.*;
import java.util.*;

public interface IOperationService {

    public List<OperationDto> findByParam(HashMap<String, String> params);

    public OperationDto getOperationDtoById(Long id);

    public ProductDto storeProduct(AddOperationDto p);

}
