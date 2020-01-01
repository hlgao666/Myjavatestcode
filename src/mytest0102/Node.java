package mytest0102;

public class Node {

    public Node privious;       //上一个节点
    public Node next;           //下一个节点
    public Object obj;          //元素数据

    public Node(Node privious, Node next, Object obj) {
        super();
        this.privious = privious;
        this.next = next;
        this.obj = obj;
    }

    public Node(Object obj) {
        super();
        this.obj = obj;
    }
}
