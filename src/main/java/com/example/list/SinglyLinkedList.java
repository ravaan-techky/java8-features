package com.example.list;

class Node {
	private Integer value;
	private Node next = null;
	
	public Node(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public class SinglyLinkedList {
	
	public static Node head, tail;
	
	public static void add(Node node) {
		if(head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	public static void displayList() {
		Node node = head;
		while(node != null) {
			System.out.println(node.getValue());
			node = node.getNext();
		}
	}
	
	public static void delete(Node node) {
		Node tempNode = head;
		Node previous = null;
		while(tempNode != null) {
			if(tempNode.getValue() == node.getValue()) {
				previous.setNext(tempNode.getNext());
				break;
			}
			previous = tempNode;
			tempNode = tempNode.getNext();
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(3);
		Node node3 = new Node(10);
		Node node4 = new Node(5);
		add(node1);
		add(node2);
		add(node3);
		add(node4);
		System.out.println("node from list....");
		displayList();
		delete(node3);
		System.out.println("After deleting node from list....");
		displayList();
	}
}
