package br.com.ServiceFinancial.service.months;

import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MonthsService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public MonthsResponseDTO getMonthsById(Long id) {
        log.info("MonthsService.getMonthsById - Start - Id: [{}]", id);
        var newEntity = this.searchMonthsById(id);
        var response = modelMapper.map(newEntity, MonthsResponseDTO.class);
        log.info("MonthsService.getMonthsById - End - YearResponseDTO: [{}]", response);
        return response;
    }

    public List<MonthsResponseDTO> getAllMonths() {
        log.info("MonthsService.getAllMonths - Start - ");
        var listMonths = this.searchAllMonths();
        var response = listMonths.stream().map(months -> modelMapper.map(months, MonthsResponseDTO.class)).toList();
        log.info("MonthsService.getAllMonths - End - ListMonths: [{}]", response);
        return response;
    }
}
