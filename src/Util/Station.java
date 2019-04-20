package Util;
import java.io.PrintStream;
import java.util.*;
import CargoTrain.Train;
public class Station{
	int id;
	PrintStream printStream;
	Queue<Cargo> cargoQueue;
	public void process(Train train) {
		cargoQueue=new LinkedList<>();
		printStream.println(train.getHead().toString());
		printStream.println(train.getLengt());
	}
}