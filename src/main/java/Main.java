import java.util.*;
public class Main {	
   static Scanner scanner = new Scanner(System.in);
	
	public static Node<Integer> buildList(int[] a) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		for (int i = 0; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return h.getNext();
	}
///////////////////////////////////////////////////////////
	
	public static int sum(Node<Integer> p) { //ex1
	int sumNum=0;
	while (p!=null) {
	sumNum= sumNum+p.getValue(); 
	p=p.getNext();
	}
	return sumNum;
	}
	
	public static void print(Node<Integer> p) {
	    while (p!=null) {
	        System.out.println(p.getValue());
	        p=p.getNext();
	    }
	}
	
	public static void arrToNode(int [] arr) {
	    Node<Integer> h = buildList(arr);
	}
	//////////////////////////////////////////////////////////////////
	   
	  public static void printR(Node<Integer> h) { //ex2 first
	    if (h==null) {
	        return;
	    }
	    System.out.println(h.getValue());
	    printR(h.getNext());
	}
	
	public static void printRback(Node<Integer> h) { //ex2 backwords
	    if (h==null) {
	        return;
	    }
	    printRback(h.getNext());
	    System.out.println(h.getValue());
	    
	}
	/////////////////////////////////////////////////////////////////////
	
	public static Node<Integer> listUntil() { //ex3
	    System.out.println("Enter number ");
	    int num = scanner.nextInt();
		Node<Integer> h = new Node<Integer>(num);
		Node<Integer> p = h;
		Node<Integer> x;
		while (num!=-1) {
		    
			x = new Node<Integer>(num);
			p.setNext(x);
			p = p.getNext();
		    System.out.println("Enter number ");
	        num = scanner.nextInt();	
		}
		return h.getNext();
	}
	//////////////////////////////////////////////////////////
	
	public static void evenNode(Node<Integer> a) { //ex4;
	    if (a==null)
	    return;
	    if ((a.getValue())%2==0) {
	        System.out.println(a.getValue());
	    }
	    a=a.getNext();
	    evenNode(a);
	}
	/////////////////////////////////////////////////////////////
	public static boolean ex5(Node<Integer> a, int num) { //ex5;
	    if (a==null)
	    return false; 
	    if ((a.getValue())==num) {
	        return true;
	    }
	    a=a.getNext();
	    return ex5(a,num);
	}
	
	//////////////////////////////////////////////////////////////
	
	public static void ex6(Node<Integer> p, int num) { //ex6
	    Node<Integer> d= new Node<>(-1,p);
	    while (p.hasNext()) {
	        if (p.getNext().getValue()==num)
	        p.setNext(p.getNext().getNext());
	    }
	    
	    }
	    

public static <T> Node<T> delete2(Node<T> list, int x){
   list = new Node<>(null, list);
   Node<T> p = list;
    
   while (p != null) {
      if(p.getNext().getValue().equals(x)){
         p.setNext(p.getNext().getNext());
         return list.getNext();
       }
      p = p.getNext();
   }
    return list.getNext();
  } 
  public static void ex6a(Node<Integer> p, int num) {
    Node<Integer> dummy = new Node<>(-1);  // צומת דמי כדי להימנע מבעיות עם הצומת הראשון
    dummy.setNext(p);
    Node<Integer> prev = dummy;

    while (p != null) {
        if (p.getValue() == num) {
            prev.setNext(p.getNext());  // הסרת הצומת
        } else {
            prev = p;  // אם הערך לא תואם, ממשיכים לצומת הבא
        }
        p = p.getNext();
    }

    // עכשיו, הרשימה המקורית עודכנה
}

//////////////////////////////////////////////////////////////
 
 
public static Node deleteAtPosition(Node head, int x) { //ex7
    // מחיקת החוליה הראשונה
    if (x == 1) {
        return head.getNext();
    }

    Node curr = head;
    int i = 1;

    while (curr != null && i < x - 1) {
        curr = curr.getNext();
        i++;
    }
 curr.setNext(curr.getNext().getNext());
    return head;
}
//////////////////////////////////////////////////////////////

public static boolean ex8(Node<Integer> L1, Node<Integer> L2) //ex8
{
    boolean b= false;
    
    if (L1==null) {
        return true;
    }
    if (!ex5(L2,L1.getValue())) {
        return false;
    }
    
    return ex8(L1.getNext(), L2);
}
//////////////////////////////////////////////////////////////
public static void ex9(Node<Integer> L1, Node<Integer> L2) //ex9
{
    while (L1!=null)
    {
    if (ex5(L2,L1.getValue())) {
       System.out.println(L1.getValue());
    }
    L1=L1.getNext();
    }
    
}
/////////////////////////////////////////////////////////////
public static Node<Integer> ex10(Node<Integer> L1, Node<Integer> L2) //ex10
{
    Node<Integer> head = new Node<Integer>(-1); 
    Node<Integer> p = head;

    while (L1 != null) {
        if (ex5(L2, L1.getValue())) {
            p.setNext(new Node<Integer>(L1.getValue()));
            p = p.getNext(); // advance the pointer
        }
        L1 = L1.getNext();
    }

    return head.getNext(); 
}
////////////////////////////////////////////////////////////////
public static Node<Integer> ex11(Node<Integer> L1, Node<Integer> L2) //ex11
{
    Node<Integer> dummy = new Node<Integer>(-1, L1);
    Node<Integer> curr = dummy;

    while (curr.getNext() != null) {

        if (ex5(L2, curr.getNext().getValue())) {
            curr.setNext(curr.getNext().getNext());
        } else {
            curr = curr.getNext();
        }
    }

    return dummy.getNext();
}
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
      if (head == null) {
        return null;
    }
    Node<Integer> current = head;
    Node<Integer> minNode = head;
    Node<Integer> previous = null;
    Node<Integer> prevMinNode = null;  

    while (current != null) {
        if (current.getValue() < minNode.getValue()) {
            minNode = current;
            prevMinNode = previous;
        }
         previous = current;
        current = current.getNext();
    }

    return prevMinNode; 
}
/////
public static Node<Integer> sortMin(Node<Integer> list) {
    Node<Integer> h = new Node<Integer>(-1);    
    Node<Integer> p = h;

    while (list != null) {
        Node<Integer> minNodePrev = previousMin(list);

        if (minNodePrev == null) {
            return h.getNext(); 
        }

        Node<Integer> minNode = minNodePrev.getNext();   
        p.setNext(minNode);
        p = p.getNext();  //    

        minNodePrev.setNext(minNode.getNext());    

    }

    return h.getNext();     
}




//////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
	int [] a={18,2,15,10,11};
    //System.out.println(sum(buildList(a)));
    Node<Integer> p= buildList(a);
    arrToNode(a);
    //printR(p);
    //printRback(p);
    //listUntil();
    //Node<Integer> h= listUntil();
    //evenNode(p);
    int [] b={18,2,3,15,10,3};
    //System.out.println(sum(buildList(a1)));
    Node<Integer> t= buildList(b);
    //System.out.println(ex8(p,t));
    //ex9(p,t);
  //System.out.println(ex10(p,t));
  //System.out.println(ex11(p,t));
  //System.out.println(allDifferent(t));
  int[] arr = {3, 7, 3, 2, 7, 5};
Node<Integer> list = buildList(arr);
int [] m1={1,3,4,7,7,10};
int [] m2={2,3,4,5,1,7,7,11,12};
Node<Integer> l1= buildList(m1);
Node<Integer> l2= buildList(m2);
Node<Integer> noDup = unique(list);
 //System.out.println(unique(t));
//System.out.println(ex1(l1,l2));
System.out.println(sortMin(l2));
}
}
