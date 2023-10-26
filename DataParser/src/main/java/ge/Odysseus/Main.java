package ge.Odysseus;
import com.google.gson.Gson;
import ge.Odysseus.utils.FileReader;
import ge.Odysseus.utils.SpaceShip;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        //ACE
        String FileName = "ace-data-2021.txt";
        SpaceShip ACE = new SpaceShip();

        FileReader ACE_Average = new FileReader(
                FileName,
                (String[] pervLine, String[] line) -> ACE.increaseValue(Double.parseDouble(line[7])));

        ACE_Average.readLines();
        double ace_averageFMA = ACE.getAverage();

        ArrayList<String[]> MRList = new ArrayList<>();
        ArrayList<Double> FMAs = new ArrayList<>();

        FileReader ACE_Calculation = new FileReader(

                FileName, (String[] pervLine, String[] line) -> {

            double FMAValue = Double.parseDouble(line[7]);
            double FieldMagnitudeAverage = Double.parseDouble(line[8]);
            double BZ_GSE_CoordinateSystem = Double.parseDouble(line[10]);
            double PlasmaProtondensity = Double.parseDouble(line[13]);

            if(
                    ace_averageFMA - abs(FMAValue) > 1.5
                            && PlasmaProtondensity >= 999.99
                            && ((FieldMagnitudeAverage > 0 && BZ_GSE_CoordinateSystem < 0) || (FieldMagnitudeAverage < 0 && BZ_GSE_CoordinateSystem > 0))
                            && (abs(Double.parseDouble(line[14]) - Double.parseDouble(pervLine[14]) )) > 700
            ){

                MRList.add(line);
                FMAs.add(FMAValue);
            }
        });

        ACE_Calculation.readLines();

        String Datajson = new Gson().toJson(MRList);

        Path MR_Data_Path = FileReader.dataAbsPath.resolve("MR-data.json");
        BufferedWriter writer = new BufferedWriter(new FileWriter(MR_Data_Path.toString()));

        writer.write(Datajson);
        writer.close();

        System.out.println("Created");
    }
}