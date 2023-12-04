package basic_Operations_with_BST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null) {
			root = new BNode<>(e);
		} else {
			root.add(e);
		}

	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E element : col) {
			add(element);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
        return depthHelper(root, node, 0);
    }

    private int depthHelper(BNode<E> current, E nodeValue, int currentDepth) {
        if (current == null) {
            return -1;
        }

        if (current.getData().compareTo(nodeValue) == 0) {
            return currentDepth;
        }

        if (nodeValue.compareTo(current.getData()) < 0) {
            return depthHelper(current.getLeft(), nodeValue, currentDepth + 1);
        } else {
            return depthHelper(current.getRight(), nodeValue, currentDepth + 1);
        }
    }

    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(BNode<E> current) {
        if (current == null) {
            return -1;
        }

        int leftHeight = heightHelper(current.getLeft());
        int rightHeight = heightHelper(current.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(BNode<E> current) {
        if (current == null) {
            return 0;
        }

        return sizeHelper(current.getLeft()) + 1 + sizeHelper(current.getRight());
    }

    public boolean contains(E e) {
        return containsRecursive(root, e);
    }
	

  private  boolean containsRecursive(BNode<E> current, E e) {
        if (current == null) {
            return false;
        }

        if (current.getData().compareTo(e) == 0) {
            return true;
        }

        if (e.compareTo(current.getData()) < 0) {
            return containsRecursive(current.getLeft(), e);
        } else {
            return containsRecursive(current.getRight(), e);
        }
    }
  public E findMin() {
      if (root == null) {
          return null;
      }

      BNode<E> current = root;
      while (current.getLeft() != null) {
          current = current.getLeft();
      }
      return current.getData();
  }

  public E findMax() {
      if (root == null) {
          return null;
      }

      BNode<E> current = root;
      while (current.getRight() != null) {
          current = current.getRight();
      }
      return current.getData();
  }

  public boolean remove(E e) {
      root = removeRecursive(root, e);
      return true; // Hoặc cần kiểm tra xem phần tử có tồn tại không để trả về kết quả thích hợp
  }

  public BNode<E> removeRecursive(BNode<E> current, E e) {
      if (current == null) {
          return null;
      }

      int compareResult = e.compareTo(current.getData());
      if (compareResult < 0) {
          current.left = removeRecursive(current.getLeft(), e);
      } else if (compareResult > 0) {
          current.right = removeRecursive(current.right, e);
      } else {
          // Nút có 0 hoặc 1 nút con
          if (current.left == null) {
              return current.right;
          } else if (current.right == null) {
              return current.left;
          }

          // Nút có 2 nút con
          current.data = findMin(current.right);
          current.right = removeRecursive(current.right, current.data);
      }
      return current;
  }

  private E findMin(BNode<E> current) {
      while (current.getLeft() != null) {
          current = current.getLeft();
      }
      return current.getData();
  }

  public List<E> descendants(E data) {
      BNode<E> node = findNode(root, data);
      List<E> descendantsList = new ArrayList<>();
      collectDescendants(node, descendantsList);
      return descendantsList;
  }

  public BNode<E> findNode(BNode<E> current, E data) {
	    if (current == null || current.getData().equals(data)) {
	        return current;
	    }

	    int compareResult = data.compareTo(current.getData());
	    if (compareResult < 0) {
	        return findNode(current.getLeft(), data);
	    } else {
	        return findNode(current.getRight(), data);
	    }
	}
  private void collectDescendants(BNode<E> node, List<E> descendantsList) {
      if (node != null) {
          if (node.getLeft() != null) {
              descendantsList.add(node.getLeft().getData());
              collectDescendants(node.getLeft(), descendantsList);
          }
          if (node.getRight() != null) {
              descendantsList.add(node.getRight().getData());
              collectDescendants(node.getRight(), descendantsList);
          }
      }
  }

  public List<E> ancestors(E data) {
      return ancestorsHelper(root, data);
  }

  private List<E> ancestorsHelper(BNode<E> current, E data) {
      if (current == null) {
          return new ArrayList<>();
      }

      if ((current.getLeft() != null && current.getLeft().getData().compareTo(data) == 0) ||
              (current.getRight() != null && current.getRight().getData().compareTo(data) == 0)) {
          List<E> result = new ArrayList<>();
          result.add(current.getData());
          return result;
      }

      List<E> leftAncestors = ancestorsHelper(current.getLeft(), data);
      List<E> rightAncestors = ancestorsHelper(current.getRight(), data);

      if (!leftAncestors.isEmpty()) {
          leftAncestors.add(current.getData());
          return leftAncestors;
      } else if (!rightAncestors.isEmpty()) {
          rightAncestors.add(current.getData());
          return rightAncestors;
      }

      return new ArrayList<>();
  }

  // Tùy chọn: Triển khai các phương thức duyệt cây (inorder, preorder, postorder) trong BST nếu cần thiết
}