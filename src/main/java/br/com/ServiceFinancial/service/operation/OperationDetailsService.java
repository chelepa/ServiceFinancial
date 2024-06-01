package br.com.ServiceFinancial.service.operation;

import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OperationDetailsService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

}
