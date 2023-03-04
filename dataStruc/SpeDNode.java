
class SpeDNode {
  private String element;
  private Node next; // maybe change singlynode
  private SpeDNode down;

  public SpeDNode(String e) {
    element = e;
    next = null;
    down = null;
  }

  public SpeDNode(String e, Node n, SpeDNode p) {
    element = e;
    next = n;
    down = p;
  }

  public void setElement(String newEle) {
    element = newEle;
  }

  public void setDown(SpeDNode newDown) {
    down = newDown;
  }

  public void setNext(Node newNext) {
    next = newNext;
  }

  public Node getNext() {
    return next;
  }

  public SpeDNode getDown() {
    return down;
  }

  public String getElement() {
    return element;
  }
}
