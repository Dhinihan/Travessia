package parse.test;

import org.junit.Assert;
import org.junit.Test;

import parse.DataParser;

public class DataParserTest {
    
    private String csvExample;

    public DataParserTest(){
        this.csvExample = "0;1.4;2;3\n0;3;2;3\n0;1;3.23;3\n0;2;2;3\n0;1;2;1\n";
    }
    
    public String getCsvExample() {
        return csvExample;
    }
    
    @Test
    public void appendCSVtest() {
        DataParser parser = new DataParser();
        Assert.assertEquals(5, parser.appendCSV(this.getCsvExample()));
        Assert.assertEquals(10, parser.appendCSV(this.getCsvExample().concat(this.getCsvExample())));
    }
    
    @Test
    public void getDataTest() {
        DataParser parser = new DataParser();
        parser.appendCSV(this.getCsvExample());
    }
}