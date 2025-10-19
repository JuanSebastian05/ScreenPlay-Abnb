package com.SPAirbnb.utils;

import net.serenitybdd.screenplay.Actor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuardarEnExcel {

    private static final String DEFAULT_RELATIVE_DIR = "src/test/resources/data";
    private static final String DEFAULT_FILENAME = "infoAlojamientos.xlsx";


    public static void guardarDetallesEnExcel(Actor actor) {
        Path outputDir = Paths.get(System.getProperty("user.dir")).resolve(DEFAULT_RELATIVE_DIR);
        try {
            Files.createDirectories(outputDir);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear la carpeta de salida: " + outputDir, e);
        }
        Path filePath = outputDir.resolve(DEFAULT_FILENAME);
        guardarDetallesEnExcel(actor, filePath.toString());
    }


    public static void guardarDetallesEnExcel(Actor actor, String rutaArchivo) {
        String titulo = safeRecall(actor, "tituloAlojamiento");
        String anfitrion = safeRecall(actor, "nombreAnfitrion");
        String precio = safeRecall(actor, "precioAlojamiento");

        File file = new File(rutaArchivo);

        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                throw new RuntimeException("No se pudo crear la carpeta: " + parent.getAbsolutePath());
            }
        }

        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        boolean createdNewWorkbook = false;

        try {
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                }
                sheet = workbook.getNumberOfSheets() > 0 ? workbook.getSheetAt(0) : workbook.createSheet("Alojamientos");
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Alojamientos");
                // encabezados
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Titulo");
                header.createCell(1).setCellValue("Anfitrión");
                header.createCell(2).setCellValue("Precio");
                createdNewWorkbook = true;
            }

            int newRowNum;
            if (createdNewWorkbook) {
                newRowNum = 1;
            } else {
                newRowNum = sheet.getLastRowNum() + 1;
            }

            Row row = sheet.createRow(newRowNum);
            row.createCell(0).setCellValue(titulo);
            row.createCell(1).setCellValue(anfitrion);
            row.createCell(2).setCellValue(precio);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar datos en Excel: " + e.getMessage(), e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException ignored) {}
            }
        }
    }

    private static String safeRecall(Actor actor, String key) {
        Object value = actor.recall(key);
        return value != null ? String.valueOf(value) : "";
    }
}
