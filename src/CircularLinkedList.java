public class CircularLinkedList<T>
{
    class Node
    {
        T data;
        Node next;
        Node(T data)
        {
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    Node tail;

    public void insertAtBeginning(T data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head= tail =n;
            n.next=n;
            return;
        }
        n.next=head;
        head=n;
        tail.next=head;
    }

    public void insertAtEnd(T data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            insertAtBeginning(data);
            return;
        }
        tail.next=n;
        n.next=head;
        tail=n;
    }

    public void insert(T data, int index)
    {
        Node n=new Node(data);
        if(index==0)
        {
            insertAtBeginning(data);
            return;
        }
        Node temp=head;
        while(temp!=tail&&index>1)
        {
            temp=temp.next;
            index--;
        }
        if(temp.next==tail)
        {
            insertAtEnd(data);
            return;
        }
        else if(temp!=tail)
        {
            n.next=temp.next;
            temp.next=n;
        }
        else
            System.out.println("Index out of Range!!");
    }

    public T deleteFirst()
    {
        if(head==null)
            return (T) "List is Empty!!";
        T data=head.data;
        Node temp=head.next;
        head.next=null;
        head=temp;
        tail.next=head;
        return data;
    }

    public T deleteLast()
    {
        if(head==null)
            return (T) "List is Empty!!";
        Node temp=head;
        while(temp.next!=tail)
        {
            temp=temp.next;
        }
        T data=tail.data;
        temp.next=head;
        tail=temp;
        return data;
    }

    public T delete(T data)
    {
        if(head.data.equals(data))
        {
            return deleteFirst();
        }
        else if(tail.data.equals(data))
        {
            return deleteLast();
        }
        Node temp=head.next;
        Node prev=head;
        while(temp.next!=head)
        {
            if(temp.data.equals(data))
                break;
            prev=temp;
            temp=temp.next;
        }
        T var=temp.data;
        if(temp.next!=head)
        {
            prev.next=temp.next;
            temp.next=null;
        }
        else
            return (T) (data+" is not present inside linked list");
        return var;
    }

    public void display()
    {
        if(head==null)
            return;
        System.out.println(head.data);
        display(head.next);
    }

    public void display(Node start)
    {
        if(start==head)
        {
            return;
        }
        System.out.println(start.data);
        display(start.next);
    }

    public void displayReverse()
    {
        if(head==null)
            return;
        displayReverse(head);
    }

    public void displayReverse(Node start)
    {
        if(start.next!=head)
            displayReverse(start.next);
        System.out.println(start.data);
    }

    public boolean isEmpty()
    {
        if(head==null)
            return true;
        return false;
    }

    public void clear()
    {
        head=tail=null;
    }

    public int size()
    {
        return size(head);
    }

    public int size(Node start)
    {
        if(start==null)
            return 0;
        if(start==tail)
            return 1;
        return 1+size(start.next);
    }

    @Override
    public String toString()
    {
        String st="[";
        Node temp=head;
        while(temp!=tail)
        {
            st=st+temp.data;
            if(temp.next!=null)
                st=st+"->";
            temp=temp.next;
        }
        if(tail!=null)
           return st+tail.data+"]";
        else
            return st+"]";
    }
}
