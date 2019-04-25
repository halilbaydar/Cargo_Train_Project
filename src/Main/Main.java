package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import CargoTrain.Carriage;
import CargoTrain.Train;
import Util.Cargo;
import Util.Station;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        readAndInitialize(args);

    }
    public static void readAndInitialize(String[] args) throws FileNotFoundException {
        PrintStream printStream=new PrintStream(new File(args[1]));

        Train train;
        int numberofstations;
        Station[] stations;
        try (Scanner scanner = new Scanner(new File(args[0]))) {

            int numberofcarriages = scanner.nextInt();
            int sizecapofeachcarriage = scanner.nextInt();



            Carriage[] carriage = new Carriage[numberofcarriages];

            for (int k = 0; k < numberofcarriages; k++) {
                carriage[k] = new Carriage(sizecapofeachcarriage);
            }
            for (int c = 0; c < numberofcarriages; c++) {
                if (c + 1 == numberofcarriages)
                    break;
                else
                    carriage[c].setNext(carriage[c + 1]);
                    carriage[c+1].setPrev(carriage[c]);
            }

            train = new Train(numberofcarriages, sizecapofeachcarriage);

            train.setHead(carriage[0]);

            numberofstations = scanner.nextInt();

            int cargoid = 0;
            int loadingstationofcaargo = 0;
            int targetstationid = 0;
            int cargosize = 0;

            stations = new Station[numberofstations];

            for (int i = 0; i < numberofstations; i++) {
                stations[i] = new Station(i,printStream);
            }


            while (scanner.hasNextLine()) {
                cargoid = scanner.nextInt();
                loadingstationofcaargo = scanner.nextInt();
                targetstationid = scanner.nextInt();
                cargosize = scanner.nextInt();

                for (int j = 0; j < numberofstations; j++) {
                    if (stations[j].getId() == loadingstationofcaargo) {
                        stations[j].cargoQueue.add(new Cargo(cargoid,
                                loadingstationofcaargo, cargosize, targetstationid));
                    }
                }
            }
        }
        execute (  numberofstations,  train,  stations);
    }
    public static void execute (int numberofstations, Train train, Station[] stations)
            throws FileNotFoundException {

        for(int i=0; i<numberofstations; i++) {
            stations[i].process(train);

        }


    }
}
