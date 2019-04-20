package Util;
public class Cargo{
	private Cargo next;
	private Cargo prev;
	private int id;
	private int loadingStation;
	private int size;
	private int targetStation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoadingStation() {
		return loadingStation;
	}
	public void setLoadingStation(int loadingStation) {
		this.loadingStation = loadingStation;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTargetStation() {
		return targetStation;
	}
	public void setTargetStation(int targetStation) {
		this.targetStation = targetStation;
	}
	public Cargo() {
		this.setNext(this.setPrev(null));
		this.id=0;
		this.loadingStation=0;
		this.size=0;
		this.targetStation=0;
	}
	public String toString() {
		return null;
	}
	public Cargo getNext() {
		return next;
	}
	public void setNext(Cargo next) {
		this.next = next;
	}
	public Cargo getPrev() {
		return prev;
	}
	public Cargo setPrev(Cargo prev) {
		this.prev = prev;
		return prev;
	}
}