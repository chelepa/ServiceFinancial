package br.com.ServiceFinancial.service.months;

import br.com.ServiceFinancial.dto.months.MonthsRequestDTO;
import br.com.ServiceFinancial.dto.months.MonthsResponseDTO;
import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
import br.com.ServiceFinancial.entity.MonthsUserEntity;
import br.com.ServiceFinancial.entity.YearUserEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<MonthsResponseDTO> createAllMonths(List<MonthsRequestDTO> request) {
        log.info("MonthsService.createMonths - Start - MonthsRequestDTO: [{}]", request);
        List<MonthsResponseDTO> response = new ArrayList<>();
        request.forEach(item -> response.add(createMonths(item)));
        log.info("MonthsService.createMonths - End - Response: [{}]", response);
        return response;
    }

    public MonthsResponseDTO createMonths(MonthsRequestDTO request) {
        log.info("MonthsService.createMonths - Start - MonthsRequestDTO: [{}]", request);
        var entity = modelMapper.map(request, MonthsUserEntity.class);
            entity.setId(null);
            entity.setYear(this.searchYearById(request.getYear()));
        var newEntity = this.saveMonths(entity);
        var response = modelMapper.map(newEntity, MonthsResponseDTO.class);
        log.info("MonthsService.createMonths - End - YearDTOResponseDTO: [{}]", response);
        return response;
    }
}
