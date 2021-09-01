import java.io.* ;
import com.opencsv.CSVWriter;

// it is not clear sum of record printed in csv as row or as column
// so i am assuming it is enter as column its value is sum of it row

class Csv {
    private static final String readFile = "C:\\sample.csv";
    private static final String writeFile = "C:\\output2.csv";
    private static final int sumOfAllREcord = 0;

    public static void main(String[] args) {

        System.out.println("Read Data Line by Line With Header \n");
        readCsv(readFile);
    }

    static void readCsv(String readFile) {
        try {
 
            FileReader filereader = new FileReader(readFile);
 
            CSVReader csvReader = new CSVReader(filereader);

            String[] Record;

            // we are going to read data line by line
            while ((Record = csvReader.readNext()) != null) {
                sumOfAllREcord += (Integer.parseInt(Record[0]) + Integer.parseInt(Record[1]) + Integer.parseInt(Record[2]));
                writeCsv(writeFile, new String[]{Record[0],Record[1],Record[2],sumOfAllREcord});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        csvReader.close();
    }

    static void writeCsv(String writeFile, String[] Record) {
        try {
            FileReader filereader = new FileReader(writeFile);

            CSVWriter csvWriter = new CSVWriter(filereader);
            
            csvWriter.writeNext(Record);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        csvWriter.close();
    }
}