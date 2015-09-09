package parse;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import data.PersonSample;
import data.SampleWalk;

public class DataParser{
    
    List<CSVRecord> records;
    
    public int appendCSV(String csv){
        try {
            createRecords(csv);
            return size();
        } catch (IOException e) {
            System.out.println("Erro ao criar o CSV parser");
            e.printStackTrace();
        }
        return 0;
    }

    public int appendCSV(File csv){
        try {
            createRecords(csv);
            return size();
        } catch (IOException e) {
            System.out.println("Erro ao criar o CSV parser");
            e.printStackTrace();
        }
        return 0;
    }
    
    protected int size() throws IOException{
        return getRecords().size();
    }

    private List<CSVRecord> getRecords() {
        return records;
    }

    protected void createRecords(String csv) throws IOException {
        CSVFormat format = getFormat();
        Reader reader = new StringReader(csv);
        CSVParser csvParser = new CSVParser(reader, format);
        records = csvParser.getRecords();
        csvParser.close();
    }
    
    protected void createRecords(File csv) throws IOException {
        CSVFormat format = getFormat();
        Reader reader = new FileReader(csv);
        CSVParser csvParser = new CSVParser(reader, format);
        records = csvParser.getRecords();
        csvParser.close();
    }

    protected CSVFormat getFormat() {
        return CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator('\n');
    }

    public List<PersonSample> getSamples() throws IOException {
        List<PersonSample> samples = new ArrayList<PersonSample>();
        
        for (int row = 0; row < getRecords().size(); row += 10)
            samples.add(new PersonSample(getPersonSample(row)));
        
        return samples;
    }

    private List<SampleWalk> getPersonSample(int rowOffset) {
        List<SampleWalk> walks = new ArrayList<SampleWalk>();
        
        for (int i = rowOffset; i < rowOffset+10; i+=2) 
            walks.add(new SampleWalk( getWalkData(i)));
        
        return walks;
    }

    private List<Double> getWalkData(int row) {
        List<Double> data = new ArrayList<Double>();
        for (String value : getRecords().get(row)) {
            data.add(Double.parseDouble(value));
        }
        return data;
    }
}
