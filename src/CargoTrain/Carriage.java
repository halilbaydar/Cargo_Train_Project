package CargoTrain;
import Util.Cargo;

import java.util.Stack;

public class Carriage{
    Stack<Cargo> cargos;
    int emptySlot;
    private Carriage next;
    private Carriage prev;
    public Carriage(int capacity) {
        cargos=new Stack<>();
        this.emptySlot=capacity;
        prev=next=null;
    }
    public boolean isFull() {
        if(this.emptySlot==0)
            return true;
        else
            return false;
    }
    public void push(Cargo cargo) {
       if(cargo!=null){
           cargos.push(cargo);
       }
    }
    public Cargo pop() {
       if(cargos.isEmpty()){
           return null;
       }else
       return cargos.pop();
    }
    public Carriage getNext() {
        return next;
    }
    public Carriage setNext(Carriage next) {
        this.next = next;
        return next;
    }
    public Carriage getPrev() {
        return prev;
    }
    public void setPrev(Carriage prev) {
        this.prev = prev;
    }
}