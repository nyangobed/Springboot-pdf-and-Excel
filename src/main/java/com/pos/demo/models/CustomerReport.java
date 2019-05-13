package com.pos.demo.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfTable;
import com.pos.demo.Entities.customer;
import com.pos.demo.Entities.pos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class CustomerReport {
    private final Collection<customer> list;

    Date date= new Date();

    public CustomerReport(Collection<customer> c) {
        list = new ArrayList<>(c);
    }

    public JasperPrint getReport() throws ColumnBuilderException, JRException, ClassNotFoundException {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        Style detailNumberStyle = createDetailNumberStyle();
        DynamicReport dynaReport = getReport(headerStyle, detailTextStyle, detailNumberStyle);

        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(),
                new JRBeanCollectionDataSource(list));
        return jp;
    }

    private Style createHeaderStyle() {
        return new StyleBuilder(true)
//                .setFont(Font.VERDANA_MEDIUM_BOLD)
                  .setBorder(Border.THIN())
//                .setBorderBottom(Border.PEN_2_POINT())
//                .setBorderColor(Color.BLACK)
//                .setBackgroundColor(Color.ORANGE)
//                .setTextColor(Color.BLACK)
//                .setHorizontalAlign(HorizontalAlign.CENTER)
//                .setVerticalAlign(VerticalAlign.MIDDLE)
//                .setTransparency(Transparency.OPAQUE)
                .build();
    }

    private Style createDetailTextStyle() {
        return new StyleBuilder(true)
//                .setFont(Font.VERDANA_MEDIUM)
               .setBorder(Border.THIN())
//                .setBorderColor(Color.BLACK)
//                .setTextColor(Color.BLACK)
//                .setHorizontalAlign(HorizontalAlign.LEFT)
//                .setVerticalAlign(VerticalAlign.MIDDLE)
//               .setPaddingLeft(15)
                .build();
    }

    private Style createDetailNumberStyle() {
       return new StyleBuilder(true)
//                .setFont(Font.VERDANA_MEDIUM)
                .setBorder(Border.THIN())
//                .setBorderColor(Color.BLACK)
//                .setTextColor(Color.BLACK)
//                .setHorizontalAlign(HorizontalAlign.RIGHT)
//                .setVerticalAlign(VerticalAlign.MIDDLE)
//                .setPaddingRight(15)

//                .setPattern("#,##0.00")
               .build();
    }

    private AbstractColumn createColumn(String property, Class<?> type, String title, int width, Style headerStyle, Style detailStyle)
            throws ColumnBuilderException {
        return ColumnBuilder.getNew()
                .setColumnProperty(property, type.getName())
                .setTitle(title)
                .setWidth(Integer.valueOf(width))
                .setStyle(detailStyle)
                .setHeaderStyle(headerStyle)
                .build();
    }

    public  DynamicReport getReport(Style headerStyle, Style detailTextStyle, Style detailNumStyle)
            throws ColumnBuilderException, ClassNotFoundException {

        DynamicReportBuilder report = new DynamicReportBuilder();

      AbstractColumn columid = createColumn("id", Long.class, "#", 30, headerStyle, detailTextStyle);
        AbstractColumn columname = createColumn("name", String.class, "NAME", 30, headerStyle, detailTextStyle);
        AbstractColumn columncode = createColumn("code", String.class, "CODE", 30, headerStyle, detailTextStyle);
        AbstractColumn columnregion = createColumn("region", String.class, "REGION", 30, headerStyle, detailNumStyle);
        AbstractColumn columnphone = createColumn("phone", Integer.class, "PHONE", 50, headerStyle, detailNumStyle);
        AbstractColumn columncompany = createColumn("company", String.class, "COMPANY", 30, headerStyle, detailNumStyle);
        AbstractColumn columnemail = createColumn("email", String.class, "EMAIL", 40, headerStyle, detailNumStyle);
        AbstractColumn columncontactPerson = createColumn("contactPerson", String.class, "CONTACT PERSON", 30, headerStyle, detailNumStyle);


        report.addColumn(columid).addColumn(columname).addColumn(columncode).addColumn(columnregion).addColumn(columnphone).addColumn(columncompany).addColumn(columnemail).addColumn(columncontactPerson);
           // styling of the title and subtitle of the report
        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, null, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, null, true));

        report.setTitle("Customer Report");
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle("Registered Customers");
        report.setSubtitleStyle(subTitleStyle.build());
        report.setTitleStyle(titleStyle.build());
        report.setSubtitle(""+new Date(System.currentTimeMillis()));
//        report.setColumnsPerPage(35);


        // waternmark report
        report.addWatermark("customers");
       report.setSubtitleStyle(subTitleStyle.build());
    // report.addImageBanner("\\uploadsQuestionnaire.PNG\\",'6','6', ImageBanner.Alignment.Center);

        //displays the length of the report across
        report.setUseFullPageWidth(true);
        return report.build();


    }}
