package Documentation;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Pdf {
    public static final String path = ".Documentation/Evidence.pdf";
    public static final String QA = "./QA.jpg";

    public static java.util.List<ArchivoTexto> listaPdf = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        File file = new File(path);
        file.getParentFile().mkdirs();

        ArchivoTexto caso0 = new ArchivoTexto("", "");
        listaPdf.add(caso0);

        ArchivoTexto caso1 = new ArchivoTexto("Prueba 1 de app", "1DWwv bgf");
        listaPdf.add(caso1);

        ArchivoTexto caso2 = new ArchivoTexto("Execucion 2 de app", "2");
        listaPdf.add(caso2);

        ArchivoTexto caso3 = new ArchivoTexto("Execucion 3 de app", "2ref45rtcf");
        listaPdf.add(caso3);

        ArchivoTexto caso4 = new ArchivoTexto("Execucion 4 de app", "2cadfv ");
        listaPdf.add(caso4);

        ArchivoTexto caso5 = new ArchivoTexto("Execucion 5 de app", "22315rtfcq3 ");
        listaPdf.add(caso5);

        //Getting Iterator
        Iterator itr=listaPdf.iterator();
        //traversing elements of ArrayList object
        while(((Iterator<?>) itr).hasNext()){
            ArchivoTexto st=(ArchivoTexto) ((Iterator<?>) itr).next();
            System.out.println(st.getDescription()+" "+st.getExpected());
        }

        System.out.println("Hay " + listaPdf.size() + " renglones");

        Documentation(path);
    }

    public static void Documentation(String dest) throws Exception {


        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdfDoc);

        //Header
        Table tableHeader = new Table(UnitValue.createPercentArray(2));

        Cell company = new Cell(1,2)
                .add(new Image(ImageDataFactory.create(QA)).scaleToFit(150, 150))
                .add(new Paragraph("Company:")).setTextAlignment(TextAlignment.JUSTIFIED);
        tableHeader.addCell(company);

        Cell Date = new Cell().add(new Paragraph("Date:"));
        tableHeader.addCell(Date);

        Cell Time = new Cell().add(new Paragraph("Time:"));
        tableHeader.addCell(Time);

        Cell Order = new Cell().add(new Paragraph("Order:"));
        tableHeader.addCell(Order);

        Cell noTest = new Cell().add(new Paragraph("Test:"));
        tableHeader.addCell(noTest);

        Cell descriptionTest = new Cell().add(new Paragraph("Description: Se probara un nuevo sistema para un portal web generado en 'algunLugar.com'"));
        tableHeader.addCell(descriptionTest);

        Cell testerName = new Cell().add(new Paragraph("Tester: "));
        tableHeader.addCell(testerName);

        document.add(tableHeader);

        // Tables separation
        Cell space = new Cell();
        new Cell().add(new Paragraph().add(""));
        document.add(space);

        //Static name tableHeader
        float[] columnWidths = {1, 5, 2, 10};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));

        PdfFont f = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        Cell cell = new Cell(1, 4)
                .add(new Paragraph("Steps documentation"))
                .setFont(f)
                .setFontSize(13)
                .setFontColor(DeviceGray.WHITE)
                .setBackgroundColor(DeviceGray.BLACK)
                .setTextAlignment(TextAlignment.CENTER);

        table.addHeaderCell(cell);

        for (int i = 0; i < 1; i++) {
            Cell[] headerFooter = new Cell[]{
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Step").setTextAlignment(TextAlignment.CENTER)),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Description").setTextAlignment(TextAlignment.CENTER)),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Expected").setTextAlignment(TextAlignment.CENTER)),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Real").setTextAlignment(TextAlignment.CENTER))
            };

            for (Cell hfCell : headerFooter) {
                table.addHeaderCell(hfCell);
            }
        }

        for (int i = 1; i < listaPdf.size(); i++) {
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(String.valueOf(i))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(String.valueOf(listaPdf.get(i).getDescription()))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(String.valueOf(listaPdf.get(i).getExpected()))));
            table.addCell(new Cell().add(new Image(ImageDataFactory.create(QA)).scaleToFit(280, 280)));

        }

        //Number of pages
        int numberOfPages = pdfDoc.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            // Write aligned text to the specified by parameters point
            document.showTextAligned(new Paragraph(String.format("Page %s of %s", i, numberOfPages)),
                    559, 806, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);
        }

        document.add(table);

        document.close();
    }
}