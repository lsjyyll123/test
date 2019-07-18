package com.fish.fileparser.product.png;

import com.fish.fileparser.product.html.ExcelHtml;
import com.fish.fileparser.utils.FileHelper;
import com.fish.fileparser.utils.ItextUtils;

import org.apache.log4j.Logger;

public class ExcelPng implements AbstractPng {

  private static final Logger log = Logger.getLogger(ExcelPng.class);

  @Override
  public void createPng(String inputFile, String outputFile) throws Exception {
    ExcelHtml excelHtml = new ExcelHtml();
    excelHtml.createHtml(inputFile, outputFile);

    FileHelper.mergeTable(outputFile + ".html");
    FileHelper.checkHtmlEndTag(outputFile + ".html");

    ItextUtils.createPdf(outputFile + ".html", outputFile + ".pdf");

    PdfPng pdfPng = new PdfPng();
    pdfPng.createPng(outputFile + ".pdf", outputFile);

  }

}

