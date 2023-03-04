public class SLinkedList {
  protected Node head;
  protected Node tail;
  protected long size;

  public SLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public void addFirst(Node newNode) {
    newNode.setNext(head);

    head = newNode;

    // for C, newNode = null;

    size += 1;
  }

  public Node removeFirst() {
    Node temp = head;

    if (temp != null) {
      head = head.getNext();

      temp.setNext(null);

      size -= 1;
    }

    return temp;
  }

  public void addLast(Node newNode) {
    newNode.setNext(null);

    tail.setNext(newNode);

    tail = newNode;

    size++;
  }

  public void addAfter(Node nodeRef, Node newNode) {
    newNode.setNext(nodeRef.getNext());

    nodeRef.setNext(newNode);

    size += 1;
  }

  public Node removeAfter(Node nodeRef) {
    Node temp = nodeRef.getNext();

    nodeRef.setNext(temp.getNext());

    temp.setNext(null);

    // for c : nodeRef = null; temp = null;

    size--;

    return temp;
  }

  // how to implement walker

  public Node removeLast() {

  }

}
