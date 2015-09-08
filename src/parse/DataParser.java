package parse;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class DataParser{
    
    private CSVParser csvParser = null;
    
    public int appendCSV(String csv){
        try {
            createParser(csv);
            return size();
        } catch (IOException e) {
            System.out.println("Erro ao criar o CSV parser");
            e.printStackTrace();
        }
        return 0;
    }

    public int appendCSV(File csv){
        try {
            createParser(csv);
            return size();
        } catch (IOException e) {
            System.out.println("Erro ao criar o CSV parser");
            e.printStackTrace();
        }
        return 0;
    }
    
    protected int size() throws IOException{
        return getCsvParser().getRecords().size();
    }

    protected CSVParser getCsvParser(){
        return csvParser;
    }

    protected void createParser(String csv) throws IOException {
        CSVFormat format = getFormat();
        Reader reader = new StringReader(csv);
        csvParser = new CSVParser(reader, format);
    }
    
    protected void createParser(File csv) throws IOException {
        CSVFormat format = getFormat();
        Reader reader = new FileReader(csv);
        csvParser = new CSVParser(reader, format);
    }

    protected CSVFormat getFormat() {
        return CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator('\n');
    }
}
