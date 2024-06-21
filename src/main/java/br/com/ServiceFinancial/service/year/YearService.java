package br.com.ServiceFinancial.service.year;

import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.entity.YearEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class YearService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public YearResponseDTO createYear(YearRequestDTO request) {
        log.info("YearService.CreateYear - Start - YearRequestDTO: [{}]", request);
        var requestEntity = modelMapper.map(request, YearEntity.class);
        var listMonths = this.searchAllMonths();
            requestEntity.setMonths(listMonths);
        var responseEntity = this.saveNewYear(requestEntity);
        var response = modelMapper.map(responseEntity, YearResponseDTO.class);
        log.info("YearService.CreateYear - End - YearRequestDTO: [{}], Response: [{}]", request, response);
        return response;
    }
}
