package mytest0102;

public class TestLinkedList {

    private Node first;
    private Node last;
    private int size;

    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {

            node.privious = last;   //将node的前一个指针指向last
            node.next = null;       //将node的下一个指针指向空
            last.next = node;       //将last节点的下一个指针指向node
            last = node;            //将node赋值给last节点
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.obj + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();                       //调用sb自己类内的toString()方法
    }

    public static void main(String[] args) {
        TestLinkedList list = new TestLinkedList();
        list.add("aa");
        list.add("123");
        list.add("我");

        System.out.println(list.toString());        //调用自定义的类内方法，就近原则
    }

}
