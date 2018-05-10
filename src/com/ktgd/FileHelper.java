package com.ktgd;

import java.io.*;

public class FileHelper {
    private File inputFile;
    private File outputFile;

    private char axis;

    FileHelper(String _filePath, String _outPath)
    {

        inputFile = new File(_filePath);
        outputFile = new File(_outPath);

    }
    FileHelper(String _filePath, String _outPath, char _axis)
    {

        inputFile = new File(_filePath);
        outputFile = new File(_outPath);
        axis = _axis;

    }
    void parse()
    {
        try{

            FileReader rf = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(rf);

            FileOutputStream fos = new FileOutputStream(outputFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] words = line.split(" ");

                if(words[0].equals("G1"))
                {
                    for(int i=0; i<words.length;i++)
                    {
                        String word = words[i];

                        if(word.charAt(0) == 'Y')
                        {
                            String trimmed = word.substring(1);
                            double trimmedDouble = Double.parseDouble(trimmed);
                            trimmedDouble += 2.0;
                            String fixedY = "Y"+trimmedDouble;
                            bw.write(" ");
                            bw.write(fixedY);

                        }
                        else
                        {
                            bw.write(" ");
                            bw.write(word);
                        }
                    }
                }
                else{
                    //System.out.print("skipped..");
                    bw.write(line);

                }

                bw.newLine();
            }
            bw.close();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
