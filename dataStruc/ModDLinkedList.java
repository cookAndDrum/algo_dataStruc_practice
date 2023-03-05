// Encapsulation is not implemented.
class ModDLinkedList {
  private SpeDNode head;
  private int size;

  public ModDLinkedList() {
    head = null;
    size = 0;
  }

  public void addSpeDNodeFirst(SpeDNode newNode) {
    newNode.setDown(head);
    head = newNode;
    size++;
  }

  // list traversal is required
  public void addSpeDNodeAfter(SpeDNode nodeRef, SpeDNode newNode) {
    if (head == null) {
      head = newNode;
      size++;
      return;
    }

    SpeDNode walker = head;

    while (walker != null && nodeRef.getElement() != walker.getElement()) {
      walker = walker.getDown();
    }

    if (walker == null)
      return;

    SpeDNode temp = walker;
    newNode.setDown(temp.getDown());
    walker.setDown(newNode);

    size++;
  }

  // Main node walker down traversal
  public SpeDNode mainNodeTraversal(SpeDNode targetMainNode) {
    SpeDNode mainWalker = head;

    while (mainWalker != null && mainWalker != targetMainNode) {
      mainWalker = mainWalker.getDown();
    }

    if (mainWalker == null)
      return null;

    return mainWalker;
  }

  // Sub node right walker traversal to target
  public Node subNodeTraversal(SpeDNode mainNode, Node target) {
    Node subWalker = mainNode.getNext(); // mainNode.next is head of subNode

    while (subWalker != null && subWalker != target) {
      subWalker = subWalker.getNext();
    }

    if (subWalker == null)
      return null;

    return subWalker;
  }

  public void addSubNodeFirst(Node newSubNode, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);
    // System.out.println("mainwalker = " + mainWalker.getElement());

    // mainWalker.next == head of subnode list
    newSubNode.setNext(mainWalker.getNext());

    // head = newSubnode
    mainWalker.setNext(newSubNode);
  }

  public void removeSubNodeFirst(SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    if (mainWalker.getNext() == null)
      return;

    Node temp = mainWalker.getNext(); // head

    mainWalker.setNext(temp.getNext());

    temp.setNext(null);
  }

  public void addSubNodeLast(Node newNode, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = mainWalker.getNext();

    if (subWalker == null) {
      newNode.setNext(null);
      mainWalker.setNext(newNode);
      return;
    }

    // Traverse to the last node
    while (subWalker.getNext() != null) {
      subWalker = subWalker.getNext();
    }

    newNode.setNext(null);
    subWalker.setNext(newNode);
  }

  public void addSubNodeAfter(Node nodeRef, Node newNode, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = subNodeTraversal(mainWalker, nodeRef);

    newNode.setNext(subWalker.getNext());

    subWalker.setNext(newNode);
  }

  public void addSubNodeBefore(Node nodeRef, Node newNode, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    // Subwalker to before nodeRef
    Node subWalker = mainWalker.getNext();

    while (subWalker != null && subWalker.getNext().getElement() != nodeRef.getElement()) {
      subWalker = subWalker.getNext();
    }

    if (subWalker == null) {
      mainWalker.setNext(newNode);
      return;
    }

    Node temp = subWalker.getNext();

    newNode.setNext(temp);

    subWalker.setNext(newNode);
  }

  public void removeSubNodeAfter(Node nodeRef, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = subNodeTraversal(mainWalker, nodeRef);

    Node temp = subWalker.getNext();

    subWalker.setNext(temp.getNext());

    temp.setNext(null);
  }

  public void removeSubNodeLast(SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = mainWalker.getNext();

    // Total 3 conditions
    // If no nodes
    if (subWalker == null)
      return;

    // the only item is head, thus delete head
    if (subWalker.getNext() == null) {
      mainWalker.setNext(null);
    }

    // Traverse to exactly n - 1 node as there is no tail to use normal traversal
    while (subWalker.getNext().getNext() != null) {
      subWalker = subWalker.getNext();
    }

    subWalker.setNext(null);
  }

  public void removeSubNode(Node nodeRef, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = mainWalker.getNext();

    // Traverse to before the node to be deleted
    while (subWalker != null && subWalker.getNext().getElement() != nodeRef.getElement()) {
      subWalker = subWalker.getNext();
    }

    if (subWalker == null) {
      return;
    }

    Node temp = subWalker.getNext();

    subWalker.setNext(temp.getNext());

    temp.setNext(null);
  }

  public void removeSubNodeBefore(Node nodeRef, SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = mainWalker.getNext();

    // Need to traverse to nodeRef - 2, in order to delete nodeRef - 1
    // Four conditions:
    // 1. NodeRef not found
    // 2. NodeRef and To be deleted in total of 2 nodes
    // 3. At least 3 nodes, with to be deleted and nodeRef at least index >= 1
    // 4. No item before nodeRef

    // 2nd condition
    if (subWalker.getNext().getElement() == nodeRef.getElement()) {
      mainWalker.setNext(subWalker.getNext());

      subWalker.setNext(null);

      return;
    }

    while (subWalker != null && subWalker.getNext().getNext().getElement() != nodeRef.getElement()) {
      subWalker = subWalker.getNext();
    }

    // 1st and 4th
    if (subWalker == null)
      return;

    // 3rd
    Node temp = subWalker.getNext(); // to be deleted

    subWalker.setNext(temp.getNext());

    temp.setNext(null);
  }

  public void printlistD() {
    SpeDNode walker = head;

    while (walker != null) {
      System.out.printf("%s ", walker.getElement());
      walker = walker.getDown();
    }

    System.out.println();
    System.out.printf("The size: %d%n", size);
  }

  public void printSubNode(SpeDNode mainNode) {
    SpeDNode mainWalker = mainNodeTraversal(mainNode);

    Node subWalker = mainWalker.getNext();

    int counter = 0;
    while (subWalker != null) {
      System.out.printf("SubNode : %s%n", subWalker.getElement());
      subWalker = subWalker.getNext();
      counter++;
    }

    System.out.println();
    System.out.printf("The size: %d%n", counter);
  }

  public static void main(String[] args) {
    ModDLinkedList list = new ModDLinkedList();

    SpeDNode n1 = new SpeDNode("A");
    list.addSpeDNodeFirst(n1);

    SpeDNode n2 = new SpeDNode("B");
    SpeDNode n3 = new SpeDNode("C");
    SpeDNode n4 = new SpeDNode("D");

    list.addSpeDNodeAfter(n1, n2);
    list.addSpeDNodeAfter(n2, n3);
    list.addSpeDNodeAfter(n3, n4);

    list.printlistD();

    // n1
    Node a1 = new Node("A1");
    list.addSubNodeFirst(a1, n1);
    Node a2 = new Node("A2");
    list.addSubNodeFirst(a2, n1);
    Node a3 = new Node("A3");
    list.addSubNodeFirst(a3, n1);
    Node a4 = new Node("A4");
    list.addSubNodeFirst(a4, n1);

    list.removeSubNodeFirst(n1);

    Node a5 = new Node("A5");
    list.addSubNodeLast(a5, n1);

    Node a6 = new Node("A6");
    list.addSubNodeAfter(a2, a6, n1);

    // list.removeSubNodeAfter(a6, n1);

    // list.removeSubNodeLast(n1);

    Node a7 = new Node("A7");
    list.addSubNodeBefore(a2, a7, n1);

    // list.removeSubNode(a1, n1);

    list.removeSubNodeBefore(a6, n1);

    list.printSubNode(n1);

  }
}
