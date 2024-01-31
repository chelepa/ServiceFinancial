package br.com.ServiceFinancial.service.expenses_and_income;

import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeRequestDTO;
import br.com.ServiceFinancial.dto.expenses_and_income.ExpensesAndIncomeResponseDTO;
import br.com.ServiceFinancial.entity.ExpensesAndIncomeEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExpensesAndIncomeService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;


    public ExpensesAndIncomeResponseDTO createExpensesAndIncome(ExpensesAndIncomeRequestDTO request) {
        log.info("ExpensesAndIncomeService.createExpensesAndIncome - Start - ExpensesAndIncomeRequestDTO: [{}]", request);
        var map = modelMapper.map(request, ExpensesAndIncomeEntity.class);
            map.setSubCategory(this.searchSubCategory(request.getSubCategory()));
            map.setMonthsUser(this.searchMonthsById(request.getMonthsUser()));
        var entity = this.saveExpensesAndIncome(map);
        var response = modelMapper.map(entity, ExpensesAndIncomeResponseDTO.class);
        log.info("ExpensesAndIncomeService.createExpensesAndIncome - End - ExpensesAndIncomeResponseDTO: [{}]", response);
        return response;
    }

    public ExpensesAndIncomeResponseDTO getExpensesAndIncomeById(Long id) {
        log.info("ExpensesAndIncomeService.getExpensesAndIncomeById - Start - Id: [{}]", id);
        var entity = this.searchExpensesAndIncome(id);
        var response = modelMapper.map(entity, ExpensesAndIncomeResponseDTO.class);
        log.info("ExpensesAndIncomeService.getExpensesAndIncomeById - End - ExpensesAndIncomeResponseDTO: [{}]", response);
        return response;
    }

    public ExpensesAndIncomeResponseDTO updateExpensesAndIncomeById(Long id, ExpensesAndIncomeRequestDTO request) {
        log.info("ExpensesAndIncomeService.updateExpensesAndIncomeById - Start - Id: [{}], ExpensesAndIncomeRequestDTO: [{}]", id, request);
        var map = this.searchExpensesAndIncome(id);
        modelMapper.map(request, map);
            map.setSubCategory(this.searchSubCategory(request.getSubCategory()));
            map.setMonthsUser(this.searchMonthsById(request.getMonthsUser()));
        var entity = this.saveExpensesAndIncome(map);
        var response = modelMapper.map(entity, ExpensesAndIncomeResponseDTO.class);
        log.info("ExpensesAndIncomeService.updateExpensesAndIncomeById - End - ExpensesAndIncomeResponseDTO: [{}]", response);
        return response;
    }

    public void deleteExpensesAndIncome(Long id) {
        log.info("ExpensesAndIncomeService.deleteExpensesAndIncome - Start - Id: [{}]", id);
        var entity = this.searchExpensesAndIncome(id);
        this.removeExpensesAndIncome(entity);
        log.info("ExpensesAndIncomeService.deleteExpensesAndIncome - End - id: [{}] - Deleted", id);
    }
}
