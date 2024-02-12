package br.com.ServiceFinancial.constants;

import java.util.List;

public class Constants {

    public static final List<String> LIST_MONTHS = List.of("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
    public static final List<Long> LIST_YEARS = List.of(2019L,2020L,2021L,2022L,2023L,2024L,2025L);

    public static final String CONTENT_TYPE = "application/pdf";
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEADER_FILENAME_YEAR = "attachment; filename=Relatorio%s.pdf";
    public static final String HEADER_FILENAME_MONTHS = "attachment; filename=Relatorio_Referente_Mes_%s.pdf";
    public static final String TITLE_REPORT_YEAR = "Relatorio Referente ao Ano de %s";
    public static final String TITLE_REPORT_MONTHS = "Relatorio Referente ao Mes de %s";
    public static final String REPORT_DATE = "Report generated Date: %s";

    public static final String DESCRIPTION = "Descrição";
    public static final String EXPENSES_AND_INCOME = "Despesa / Receita";
    public static final String VALUE = "Valor";
    public static final String EXPENSES = "Despesa";
    public static final String REVENUES = "Receita";
    public static final String VALUE_FORMATTER = "R$: %s";
    public static final String EXPENSES_VALUE = "Total Valor Despesas";
    public static final String REVENUES_VALUE = "Total Valor Receitas";


}
