package CargoTrain;
import java.util.*;
import Util.Cargo;
public class Train{
	private int carCapacity;
	private int length;
	private Carriage head;
	private Carriage tail;
	public Train(int length, int carCapacity) {
		this.length=length;
		this.carCapacity=carCapacity;
		setTail(null);
		setHead(null);
	}
	public void  load(Queue<Cargo> cargos) {
		Carriage vagon=null;
		while (!cargos.isEmpty()){
			if(this.carCapacity>=cargos.peek().getSize()) {
				vagon =whichcarCarriage(cargos.peek());
				vagon.emptySlot-=cargos.peek().getSize();
				vagon.push(cargos.poll());
			}
		}
	}
	public Carriage whichcarCarriage(Cargo cargo) {
		if (head == null) {
			head.setNext(new Carriage(this.carCapacity));
			this.setLengt(this.getLengt() + 1);
			head.getNext().setPrev(head);
			return head.getNext();
		} else {
			Carriage temp = head;
			if(temp.emptySlot>=cargo.getSize())
				return temp;
			else {
				while (temp!= null) {
					if (temp.emptySlot >= cargo.getSize()) {
						return temp;
					} else {
						if (temp.getNext() != null){
							temp = temp.getNext();
							continue;
						}
						else {
							temp.setNext(new Carriage(this.carCapacity));
							temp.getNext().setPrev(temp);
							this.setLengt(this.length + 1);
							return temp.getNext();
						}
					}
				}
			}
		}
		return head;
	}
	public int findsizeoftrain() {
		int size=0;
		if(head!=null) {
			Carriage curr=head;
			while(curr!=null) {
				if(curr.cargos.isEmpty()) {
					curr=null;
				}else {
					size++;
				}
				if(curr!=null)
					curr=curr.getNext();
				else break;
			}
		}else return 0;
		return size;
	}

	public Queue<Cargo> unload(Queue<Cargo> cargos) {
		Cargo temp=null;
		if(head==null) {
			return cargos;
		}else {
			Carriage curr=head;
			while(curr!=null) {
				temp=curr.pop();
				while(temp!=null){
					curr.emptySlot+=temp.getSize();
					cargos.offer(temp);
					temp=curr.pop();
				}
				curr=curr.getNext();
			}
		}
		return cargos;
	}
	public int getCarCapacity() {
		return carCapacity;
	}
	public void setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
	}
	public int getLengt() {
		return length;
	}
	public void setLengt(int length) {
		if(this.length<0){
			this.length=0;
		}else
			this.length = length;
	}
	public Carriage getTail() {
		return tail;
	}
	public void setTail(Carriage tail) {
		this.tail = tail;
	}
	public Carriage getHead() {
		return head;
	}
	public void setHead(Carriage head) {
		this.head = head;
	}
}