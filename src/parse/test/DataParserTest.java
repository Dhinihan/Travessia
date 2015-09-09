package parse.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import data.PersonSample;
import parse.DataParser;

public class DataParserTest {
    
    private String csvExample;

    public DataParserTest(){
        this.csvExample = "0;1.17;2.67;4.51\n0;0;0;0\n0;1.32;2.08;3.91\n0;0;0;0\n0;1.63;3.01;4.4\n0;0;0;0\n0;1.42;2.72;4.34\n0;0;0;0\n0;1.58;3;4.53\n0;0;0;0\n1;1.37;2.61;3.41\n1;0;0;0\n1;1.78;2.45;3.37\n1;0;0;0\n1;1.71;2.56;3.53\n1;0;0;0\n1;1.71;2.78;3.25\n1;0;0;0\n1;1.5;2.54;3.01\n1;0;0;0\n";
    }
    
    public String getCsvExample() {
        return csvExample;
    }
    
    @Test
    public void appendCSVtest() {
        DataParser parser = new DataParser();
        Assert.assertEquals(20, parser.appendCSV(this.getCsvExample()));
        Assert.assertEquals(40, parser.appendCSV(this.getCsvExample().concat(this.getCsvExample())));
    }
    
    @Test
    public void getDataTest() throws IOException {
        DataParser parser = new DataParser();
        parser.appendCSV(this.getCsvExample());
        List<PersonSample> samples = parser.getSamples();
        Assert.assertEquals(2, samples.size());
        Assert.assertEquals(1.441, samples.get(0).getAverageVelocity(), 0.001);
        Assert.assertEquals(1.295, samples.get(1).getAverageAcceleration(), 0.001);
    }
}