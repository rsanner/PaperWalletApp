package com.deetsquad.paperwalletapp;

import java.io.File;
import java.io.IOException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class CreatePDF {
    public static final String DEST = "E:/Documents/PaperWalletApp/sample.pdf";

    public static void main(String args[]) throws IOException {
        // Creating a PdfWriter
        PdfWriter writer = new PdfWriter(DEST);

        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document
        Document document = new Document(pdf);

        //Create base layer
        //PdfLayer baseLayer = new PdfLayer("baseLayer", pdf);

        // Creating an ImageData object
        String imFile = "E:/Documents/PaperWalletApp/front-300dpi-alt-dogecoin.jpg/";
        ImageData data = ImageDataFactory.create(imFile);
        String codeImFile = "E:/Documents/PaperWalletApp/publicCode.png/";
        ImageData codeImData  = ImageDataFactory.create(codeImFile);

        // Creating an Image object
        Image image = new Image(data);
        Image pubCodeImage = new Image(codeImData);

        ///Set public code position
        pubCodeImage.setHeight(73);
        pubCodeImage.setWidth(73);
        pubCodeImage.setFixedPosition(79,685);

        // Adding image to the document
        document.add(image);
        document.add(pubCodeImage);

        // Closing the document
        document.close();

        System.out.println("Image added");
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));

        //Close document
        document.close();
    }
}
