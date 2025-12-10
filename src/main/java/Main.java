/////////////////////////////////////////////////////////////
//level 2 //////////////////////////////////////////////////
public static boolean allDifferent(Node<Integer> head) { //ex4 level 2
    for (Node<Integer> p1 = head; p1 != null; p1 = p1.getNext()) { 
        for (Node<Integer> p2 = p1.getNext(); p2 != null; p2 = p2.getNext()) {

            if (p1.getValue().equals(p2.getValue())) {
                return false; 
            }

        }
    }

    return true;
}
///////////////////////////////////////////////////
public static boolean exists(Node<Integer> h, int v) { //עזר
    while (h != null) {
        if (h.getValue() == v)
            return true;
        h = h.getNext();
    }
    return false;
}

public static Node<Integer> unique(Node<Integer> head) { ///ex5 level 2
    Node<Integer> newHead = null;
    Node<Integer> tail = null;

    while (head != null) {

        if (!exists(newHead, head.getValue())) {

            Node<Integer> x = new Node<Integer>(head.getValue());

            if (newHead == null) {
                newHead = x;
                tail = x;
            } else {
                tail.setNext(x);
                tail = x;
            }
        }

        head = head.getNext();
    }

    return newHead;
}
/////////////////////////////////////////////////////////
public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) { //level 2 ex1
 Node<Integer> h = new Node<Integer>(-1);
 Node<Integer> p = h;
 Node<Integer> a = l1;
 Node<Integer> b = l2;
 while (a.getNext()!=null&&b.getNext()!=null) {
     if (a.getValue()>b.getValue()) {
         p.setNext(b);
         b=b.getNext();
         p=p.getNext();
     }
     else {
         p.setNext(a);
         a=a.getNext();
         p=p.getNext(); 
     }
 }
 
 if (a.getNext()!=null) {
         p.setNext(a);
     }
 
 if (b.getNext()!=null) {
         p.setNext(b);
     }
 
 return h.getNext();
}
//////////////////////////////////////////////////////////////

public static Node<Integer> previousMin(Node<Integer> head) {
    if (head == null || head.getNext() == null) return null;

    Node<Integer> curr = head;
    Node<Integer> minPrev = null;
    Node<Integer> minNode = head;

    while (curr.getNext() != null) {
        if (curr.getNext().getValue() < minNode.getValue()) {
            minNode = curr.getNext();
            minPrev = curr;
        }
        curr = curr.getNext();
    }
    return minPrev;
}

////
public static Node<Integer> sortMin(Node<Integer> list) {
    Node<Integer> dummy = new Node<Integer>(-1); 

    while (list != null) {
        Node<Integer> minPrev = previousMin(list);
        Node<Integer> minNode;

        if (minPrev == null) {
            minNode = list;
            list = list.getNext();
        } else {
            minNode = minPrev.getNext();
            minPrev.setNext(minNode.getNext());
        }

        Node<Integer> q = dummy;
        while (q.getNext() != null) {
            q = q.getNext();
        }
        q.setNext(minNode);
        minNode.setNext(null);
    }

    return dummy.getNext();
}


