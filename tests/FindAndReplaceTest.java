import java.io.*;
import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;

import java.lang.reflect.Array;
import java.util.*;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

/**
 * Created by Hwang on 9/21/15.
 */
public class FindAndReplaceTest {


    File tempFile;
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    FindAndReplace testInstance = new FindAndReplace();



    @Before
    public void setUp() throws Exception {
        tempFile = testFolder.newFile("file.txt");
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
        writer.println("<<COMPANY>><<USER>>,COMPANY,USER");
    }

    @Test
    public void testRun() throws Exception {

    }

    @Test
    public void testCloseBufferedReader() throws Exception {

    }

    @Test
    public void testCreateBufferedReaderForGetKeyValue() throws Exception {

    }

    @Test
    public void testCreateBufferedReaderForReplace() throws Exception {
        assertNotNull(testInstance.createBufferedReaderForReplace(tempFile.getPath()));

    }

    @Test(expected = FileNotFoundException.class)
    public void testExceptionForCreateBufferedReaderForReplace() {
        testInstance.createBufferedReaderForReplace(tempFile.getPath());
        fail("expected file not found exception");
    }
    @Test
    public void testCreatePrintWriter() throws Exception {

    }

    @Test
    public void testReadToReplaceWords() throws Exception {

    }

    @Test
    public void testReplaceWords() throws Exception {

    }

    @Test
    public void testGetKeyValuePair() throws Exception {

    }

    @Test
    public void testGetKeyValueInCurrentLine() throws Exception {

    }
}