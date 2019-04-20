package CargoTrain;
import java.util.*;
import Util.Cargo;
public class Carriage{
	int emptySlot;
	Cargo cargos;
	Carriage next;
	Carriage prev;
	public Carriage(int capacity) {
		cargos=null;
		this.emptySlot=capacity;
		prev=next=null;	
	}
	public boolean isFull() {
		if(this.emptySlot==0)
		return true;
		else 
			return false;
	}
	public Cargo push(Cargo cargo) {
		if(cargos==null) {
			cargos.setNext(cargo);
			cargos.setPrev(null);
		}else {
			Cargo curr=this.cargos;
			while(!curr.getNext().equals(null)) {
				curr.setNext(curr.getNext());
			}
			if(curr.getNext().equals(null)) {
				 curr.getNext().setNext(cargo);
				 curr.getNext().setPrev(curr);
			}
		}
		return cargo;
	}
	public Cargo pop() {
		if(cargos.equals(null))
			return null;
		else {
			Cargo curr=this.cargos;
			while(!curr.getNext().equals(null)) {
				curr.setNext(curr.getNext());
			}
			if(curr.getNext().equals(null)) {
				curr=null;
			}
		}
		return cargos;
	}
}