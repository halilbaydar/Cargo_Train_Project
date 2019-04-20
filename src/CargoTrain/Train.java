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
		if(head==null) {
			if(this.carCapacity>cargos.size()) {
				if(head.emptySlot>cargos.size()) {
					head.emptySlot-=cargos.peek().getSize();
					head.next.push(cargos.poll());
				}
			}
			else
				return;
		}else {
			Carriage curr=head;
			while(!curr.equals(null)) {
				if(this.carCapacity>curr.cargos.getSize()) {
					if(!curr.isFull()) {
						if(curr.emptySlot>curr.cargos.getSize() && !cargos.isEmpty()) {
							head.emptySlot-=cargos.peek().getSize();
							curr.push(cargos.poll());
							curr.prev.next=curr;
						}else if(cargos.isEmpty()) {
							curr.next=null;
							curr.prev.next=curr;
							tail=curr;
						}
					}
				}else {
					break;
				}
				curr=curr.next;
			}
		}
	}
	public void unload(Queue<Cargo> cargos) {
		if(head==null) {
			return;
		}else {
			Carriage curr=tail;
			while(!curr.equals(null)) {
				head.emptySlot+=cargos.peek().getSize();
				cargos.offer(curr.pop());
				curr=curr.prev;
			}
		}

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