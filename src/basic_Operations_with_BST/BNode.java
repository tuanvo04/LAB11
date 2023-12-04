package basic_Operations_with_BST;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	public E data;
	public BNode<E> left;
	public BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void add(E e) {
		if (e.compareTo(this.data) < 0) {
			if (this.left == null) {
				this.left = new BNode<>(e);
			}
		}
		if (e.compareTo(this.data) > 0) {
			if (this.right == null) {
				this.right = new BNode<>(e);
			}
		}
		if (e.compareTo(this.data) == 0) {
			System.out.println("Number is into data");
		}
	}

	
}
