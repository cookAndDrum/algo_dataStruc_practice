
class DNode {
  private String element;
  private DNode next;
  private DNode prev;

  public DNode(String e, DNode n, DNode p) {
    element = e;
    next = n;
    prev = p;
  }

  public void setElement(String newEle) {
    element = newEle;
  }

  public void setPrev(Node newPrev) {
    prev = newPrev;
  }

  public void setNext(Node newNext) {
    next = newNext;
  }

  public DNode getNext() {
    return next;
  }

  public DNode getPrev() {
    return prev;
  }

  public String getElement() {
    return element;
  }
}
