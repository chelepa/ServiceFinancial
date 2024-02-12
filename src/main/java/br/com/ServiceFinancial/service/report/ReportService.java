package br.com.ServiceFinancial.service.report;

import br.com.ServiceFinancial.entity.MonthsUserEntity;
import br.com.ServiceFinancial.entity.YearUserEntity;
import br.com.ServiceFinancial.service.base.BaseService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

import static br.com.ServiceFinancial.constants.Constants.*;

@Slf4j
@Service
public class ReportService extends BaseService {

    private static final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public void createReportYear(Long userId, Long year, HttpServletResponse response) throws DocumentException, IOException {
        log.info("ReportService.createReportYear - Start - UserId: [{}], Year: [{}]", userId, year);
        var find = this.searchYearByYearAndUserId(year, userId);
        response.setContentType(CONTENT_TYPE);
        response.setHeader(HEADER_CONTENT_DISPOSITION, String.format(HEADER_FILENAME_YEAR, find.getYear()));
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        addContentReportYear(document, find);
        document.close();
        log.info("ReportService.createReportYear - End - UserId: [{}], Year: [{}]", userId, year);
    }

    public void createReportMonths(Long userId, Long year, String months, HttpServletResponse response) throws IOException, DocumentException {
        log.info("ReportService.createReportMonths - Start - UserId: [{}], Year: [{}], Months: [{}]", userId, year, months);
        var find = this.searchMonthsByNameAndYearAndUserId(months, year, userId);
        response.setContentType(CONTENT_TYPE);
        response.setHeader(HEADER_CONTENT_DISPOSITION, String.format(HEADER_FILENAME_MONTHS, find.getName()));
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        addContentReportMonths(document, find);
        document.close();
        log.info("ReportService.createReportMonths - End - UserId: [{}], Year: [{}], Months: [{}]", userId, year, months);
    }

    private void addContentReportMonths(Document document, MonthsUserEntity find) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        Paragraph title = new Paragraph(String.format(TITLE_REPORT_MONTHS, find.getName()), catFont);
        title.setAlignment(Element.ALIGN_CENTER);
        preface.add(title);

        addEmptyLine(preface, 1);
        preface.add(new Paragraph(String.format(REPORT_DATE, new Date()), smallBold));
        addEmptyLine(preface, 2);
        document.add(preface);

        PdfPTable table = createPdfPTable(3);

        createCell(find.getName().toUpperCase(), table, Element.ALIGN_CENTER, BaseColor.RED, 3);
        createCell(DESCRIPTION, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);
        createCell(EXPENSES_AND_INCOME, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);
        createCell(VALUE, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);

        find.getExpensesAndIncome().forEach(expensesAndIncome-> {
            createCell(expensesAndIncome.getDescription(), table, Element.ALIGN_LEFT, BaseColor.WHITE, 0);
            createCell(expensesAndIncome.isExpenses() ? EXPENSES : REVENUES, table, Element.ALIGN_CENTER, BaseColor.WHITE, 0);
            createCell(String.format(VALUE_FORMATTER, expensesAndIncome.getValue()), table, Element.ALIGN_RIGHT, BaseColor.WHITE, 0);
        });

        createCell(EXPENSES_VALUE, table, Element.ALIGN_LEFT, BaseColor.LIGHT_GRAY, 2);
        createCell(String.format(VALUE_FORMATTER, find.getValueExpenses()), table, Element.ALIGN_RIGHT, BaseColor.LIGHT_GRAY, 0);
        createCell(REVENUES_VALUE, table, Element.ALIGN_LEFT, BaseColor.LIGHT_GRAY, 2);
        createCell(String.format(VALUE_FORMATTER, find.getValueRevenues()), table, Element.ALIGN_RIGHT, BaseColor.LIGHT_GRAY, 0);

        try {
            document.add(table);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addContentReportYear(Document document, YearUserEntity find) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);

        Paragraph title = new Paragraph(String.format(TITLE_REPORT_YEAR, find.getYear()), catFont);
        title.setAlignment(Element.ALIGN_CENTER);
        preface.add(title);

        addEmptyLine(preface, 1);
        preface.add(new Paragraph(String.format(REPORT_DATE, new Date()), smallBold));
        addEmptyLine(preface, 2);
        document.add(preface);

        find.getMonths().forEach(months -> {
            PdfPTable table = createPdfPTable(3);
            createCell(months.getName().toUpperCase(), table, Element.ALIGN_CENTER, BaseColor.RED, 3);
            createCell(DESCRIPTION, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);
            createCell(EXPENSES_AND_INCOME, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);
            createCell(VALUE, table, Element.ALIGN_CENTER, BaseColor.LIGHT_GRAY, 0);

            months.getExpensesAndIncome().forEach(expensesAndIncome-> {
                createCell(expensesAndIncome.getDescription(), table, Element.ALIGN_LEFT, BaseColor.WHITE, 0);
                createCell(expensesAndIncome.isExpenses() ? EXPENSES : REVENUES, table, Element.ALIGN_CENTER, BaseColor.WHITE, 0);
                createCell(String.format(VALUE_FORMATTER, expensesAndIncome.getValue()), table, Element.ALIGN_RIGHT, BaseColor.WHITE, 0);
            });

            createCell(EXPENSES_VALUE, table, Element.ALIGN_LEFT, BaseColor.LIGHT_GRAY, 2);
            createCell(String.format(VALUE_FORMATTER, months.getValueExpenses()), table, Element.ALIGN_RIGHT, BaseColor.LIGHT_GRAY, 0);
            createCell(REVENUES_VALUE, table, Element.ALIGN_LEFT, BaseColor.LIGHT_GRAY, 2);
            createCell(String.format(VALUE_FORMATTER, months.getValueRevenues()), table, Element.ALIGN_RIGHT, BaseColor.LIGHT_GRAY, 0);

            try {
                document.add(table);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static void createCell(String description, PdfPTable table, Integer horizontalAlignment, BaseColor backgroundColor, Integer colspan) {
        PdfPCell cell = new PdfPCell(new Phrase(description));
        cell.setHorizontalAlignment(horizontalAlignment);
        cell.setBackgroundColor(backgroundColor);
        cell.setColspan(colspan);
        table.addCell(cell);
    }

    private static PdfPTable createPdfPTable(Integer numberOfLines) {
        return new PdfPTable(numberOfLines);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
