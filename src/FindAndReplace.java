/**
 * Created by Hwang on 8/31/15.
 */

import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.io.FileNotFoundException;


public class FindAndReplace {

    ArrayList<String> keys = new ArrayList<>();
    ArrayList<String> values = new ArrayList<>();

    public void run(String pathToFindReplaceGiven, String pathToInputGiven, String pathToOutputGiven) {
        BufferedReader keyValueReader = createBufferedReaderForGetKeyValue(pathToFindReplaceGiven);
        getKeyValuePair(keyValueReader);
        closeBufferedReader(keyValueReader);
        BufferedReader inputTextReader = createBufferedReaderForReplace(pathToInputGiven);
        PrintWriter outputWriter = createPrintWriter(pathToOutputGiven);
        readToReplaceWords(inputTextReader, outputWriter);
        closeBufferedReader(inputTextReader);
    }

    public void closeBufferedReader(BufferedReader inputReader) {
        try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    public BufferedReader createBufferedReaderForGetKeyValue(String inputFilePathGiven) {

        BufferedReader inputReader = null;

        try {
            String inputFilePath = inputFilePathGiven;
            inputReader = new BufferedReader(new FileReader(inputFilePath));
            getKeyValuePair(inputReader);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            return inputReader;
        }
    }

    public BufferedReader createBufferedReaderForReplace(String inputFilePathGiven) {

        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(inputFilePathGiven));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
        return inputReader;
    }

    public PrintWriter createPrintWriter(String outputFilePathGiven) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePathGiven)));
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return writer;
    }

    public void readToReplaceWords(BufferedReader inputReader, PrintWriter writer) {

        String inputLine;
        try {
            while (inputReader.ready()) {
                inputLine = inputReader.readLine();
                String replacedLine = replaceWords(inputLine);
                writer.println(replacedLine);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public String replaceWords(String inputLine) {
        for (int i=0; i<keys.size(); i++) {
            inputLine = inputLine.replace(keys.get(i), values.get(i));
        }
        return inputLine;
    }

    public void getKeyValuePair(BufferedReader inputReader) {

        String inputLine;
        try {
            while (inputReader.ready()) {
                String[] tokensInCurrentLine;
                inputLine = inputReader.readLine();
                tokensInCurrentLine = inputLine.split(",");
                getKeyValueInCurrentLine(tokensInCurrentLine);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



    public void getKeyValueInCurrentLine(String[] pairsInCurrentLine) {

        for (String keyValue : pairsInCurrentLine) {
            String[] pair = keyValue.split(":");
            keys.add(pair[0]);
            values.add(pair[1]);
        }
    }

}
