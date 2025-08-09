package util;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Utlity {

    public static String getExcelData(int rowNum, int colNum, String sheetName) {
        XSSFWorkbook workBook = null;
        FileInputStream fileInputStream = null;
        String cellData = null;

        try {
            String projectPath = System.getProperty("user.dir");
            String filePath = Paths.get(projectPath, "src", "test", "resources", "data_driven", "testing.xlsx").toString();

            fileInputStream = new FileInputStream(filePath);
            workBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workBook.getSheet(sheetName);

            if (sheet != null) {
                Cell cell = sheet.getRow(rowNum).getCell(colNum);
                cellData = getCellValueAsString(cell);
            }

        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        } finally {
            try {
                if (workBook != null) {
                    workBook.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return cellData;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}