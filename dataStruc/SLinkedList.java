public class SLinkedList {
  protected Node head;
  protected long size;

  public SLinkedList() {
    head = null;
    size = 0;
  }

  public void addFirst(Node newNode) {
    newNode.setNext(head);

    head = newNode;

    // for C, newNode = null;

    size += 1;
  }

  public void removeFirst() {
    Node temp = head;

    if (temp != null) {
      head = head.getNext();

      temp.setNext(null);

      size -= 1;
    }
  }

  // assume you have at least 1 node
  public void addLast(Node newNode) {
    Node walker = head;

    // Traverse to the last node
    while (walker.getNext() != null) {
      walker = walker.getNext();
    }

    walker.setNext(newNode);

    newNode.setNext(null);

    size++;
  }

  public void addAfter(Node nodeRef, Node newNode) {
    Node walker = head;

    while (walker != null && nodeRef.getElement() != walker.getElement()) {
      walker = walker.getNext();
    }

    // No node is found
    if (walker == null)
      return;

    newNode.setNext(walker.getNext());

    walker.setNext(newNode);

    size += 1;
  }

  // assume at least 1 node
  public void removeAfter(Node nodeRef) {
    Node walker = head;

    while (walker != null && nodeRef.getElement() != walker.getElement()) {
      walker = walker.getNext();
    }

    if (walker == null)
      return;

    Node temp = walker.getNext();

    walker.setNext(temp.getNext());

    temp.setNext(null);

    // for c : nodeRef = null; temp = null;

    size--;
  }

  public void removeLast() {
    if (head == null)
      return;

    // head is the only node, remove head
    if (head.getNext() == null) {
      head = null;
      size--;
      return;
    }

    Node walker = head;

    // Traverse until before n - 1
    while (walker.getNext().getNext() != null) {
      walker = walker.getNext();
    }

    walker.setNext(null);
    size--;
  }

}
