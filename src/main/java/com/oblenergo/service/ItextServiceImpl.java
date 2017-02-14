package com.oblenergo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.oblenergo.model.Orders;

@Service
public class ItextServiceImpl implements ItextService {

  Logger LOGGER = Logger.getLogger(ItextServiceImpl.class);
  
  private static final String SUBSCRIPTION_ID="Перепустка для в'їзду на територію ";
  private static final String CUSTOMER="Замовник : ";
  private static final String TYPE_OF_ORDER="Вид послуги : ";
  private static final String CAR_NUM="Державний реєстраційний номер : ";
  private static final String DATE="Дата виконання послуги : ";
  private static final String TIME_START="Початок : ";
  private static final String TIME_END="Кінець : ";

  @Autowired
  private ServletContext context;
  
  /** This method get font(localization words in document)
   * 
   * @return Font */
  public Font getFont() {
    BaseFont baseFont = null;
    try {
      String path = context.getRealPath("/resources/ARIALUNI.TTF");
      baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, true);
    } catch (DocumentException | IOException e) {

      LOGGER.error("Unable to get font for document " + e);
    }
    return new Font(baseFont);
  }

  /** This method for create permit for entrance in territory company
   * 
   * @param Order
   * @return []byte */
  @Override
  public byte[] writePermit(Orders order) {

    byte[] pdf = null;
    Document document = new Document();
    document.setMargins(20, 50, 25, 2);

    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

      PdfWriter writer = PdfWriter.getInstance(document, baos);
      String pathImageLogo = context.getRealPath("/resources/oblenergoLogoColor.png");
      document.open();
      Image imgLogo = Image.getInstance(pathImageLogo);
      document.add(imgLogo);
      document.add(createTable(order));

      Paragraph paragraph = new Paragraph();
      paragraph.setSpacingBefore(25);

      document.add(paragraph);
      document.close();
      pdf = baos.toByteArray();
      writer.close();

    } catch (DocumentException | IOException e) {
      LOGGER.error("Unable to write data to document " + e);
    }
    return pdf;
  }

  public PdfPTable createTable(Orders order) throws DocumentException {
    // a table with three columns
    PdfPTable table = new PdfPTable(2);
    table.setWidthPercentage(100); // Width 100%
    // Set Column widths
    float[] columnWidths = { 5f, 5f };
    try {
      table.setWidths(columnWidths);
    } catch (DocumentException e) {
      LOGGER.error("Unable to write the table to document " + e);
      throw e;
    }

    PdfPCell cell;

    cell = new PdfPCell(
        new Phrase(SUBSCRIPTION_ID+ order.getId(), getFont()));
    cell.setColspan(2);
    cell.setBorderColor(BaseColor.WHITE);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase(CUSTOMER, getFont()));

    table.addCell(cell);

    table.addCell(new Phrase(order.getCustomer(), getFont()));

    cell = new PdfPCell(new Phrase(TYPE_OF_ORDER, getFont()));
    table.addCell(cell);
    table.addCell(new Phrase(order.getWorkType().getName(), getFont()));

    cell = new PdfPCell(new Phrase(CAR_NUM, getFont()));
    table.addCell(cell);
    table.addCell(new Phrase(order.getCar_number().toString(), getFont()));

    cell = new PdfPCell(new Phrase(DATE, getFont()));
    table.addCell(cell);
    table.addCell(new Phrase(order.getDate(), getFont()));

    cell = new PdfPCell(new Phrase(TIME_START, getFont()));
    table.addCell(cell);
    table.addCell(new Phrase(order.getTime(), getFont()));

    cell = new PdfPCell(new Phrase(TIME_END, getFont()));
    table.addCell(cell);

    table.addCell(new Phrase(order.getTime_end(), getFont()));

    return table;
  }
}
