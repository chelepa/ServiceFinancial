package br.com.ServiceFinancial.service.year;

import br.com.ServiceFinancial.dto.year.YearRequestDTO;
import br.com.ServiceFinancial.dto.year.YearResponseDTO;
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
public class YearService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public YearResponseDTO createYear(YearRequestDTO request) {
        log.info("YearService.createYear - Start - YearDTO: [{}]", request);
        var entity = modelMapper.map(request, YearUserEntity.class);
            entity.setId(null);
        var newEntity = this.saveYear(entity);
        var response = modelMapper.map(newEntity, YearResponseDTO.class);
        log.info("YearService.createYear - End - YearDTOResponseDTO: [{}]", response);
        return response;
    }

    public List<YearResponseDTO> createAllYear(List<YearRequestDTO> request) {
        log.info("YearService.createAllYear - Start - ListYearRequestDTO: [{}]", request);
        List<YearResponseDTO> response = new ArrayList<>();
        request.forEach(item -> response.add(createYear(item)));
        log.info("YearService.createAllYear - End - YearDTOResponseDTO: [{}]", response);
        return response;
    }

    public YearResponseDTO getYearById(Long id) {
        log.info("YearService.getYearById - Start - Id: [{}]", id);
        var newEntity = this.searchYearById(id);
        var response = modelMapper.map(newEntity, YearResponseDTO.class);
        log.info("YearService.getYearById - End - YearResponseDTO: [{}]", response);
        return response;
    }

    public List<YearResponseDTO> getAllYear() {
        log.info("YearService.getAllYear - Start - ");
        var listYear = this.searchAllYear();
        var response = listYear.stream().map(year -> modelMapper.map(year, YearResponseDTO.class)).toList();
        log.info("YearService.getYearById - End - ListResponse: [{}]", response);
        return response;
    }

    public void deleteYearById(Long id) {
        log.info("YearService.deleteYearById - Start - Id: [{}]", id);
        var entity = this.searchYearById(id);
        this.removeYear(entity);
        log.info("YearService.deleteYearById - End - id: [{}] - Deleted", id);
    }
}
