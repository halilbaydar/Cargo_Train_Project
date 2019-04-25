package Util;
import java.io.*;
import java.util.*;
import CargoTrain.Train;
public class Station {

    PrintStream printStream;
    public Queue<Cargo> cargoQueue =new LinkedList<>();
    Queue<Cargo> temp=new LinkedList<>();
    Queue<Cargo> tempque=new LinkedList<>();
    ArrayList<Cargo> list=new ArrayList<>();
    public Station(int id , PrintStream printStream) throws FileNotFoundException {
       this.printStream=printStream;
        this.id=id;
    }
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void process(Train train) throws FileNotFoundException {





        //trendeki kargoları istasyona indir
        if(train.getHead()!=null) {
            cargoQueue=train.unload(cargoQueue);
        }


        while(cargoQueue.size()!=0) {
            list.add(cargoQueue.poll());
        }
        for(int i=0; i<list.size(); i++) {

            cargoQueue.offer(list.get(i));
        }



        //istasyondaki gerekli kargoları trene bindir
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getTargetStation()!=this.id) {
                temp.add(list.get(i));
            }else {
                tempque.add(list.get(i));
            }
        }
        train.load(temp);



       
        while(!tempque.isEmpty()){
            printStream.println(tempque.poll());
        }
        
        
        train.setLengt(train.finsizeoftrain());
        printStream.println(this.id +" " +train.getLengt());




    }
}
