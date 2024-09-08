public class CircularLinkedList<Object>
{
    class Node
    {
        Object data;
        Node next;
        Node(Object data)
        {
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    Node tail;

    public void insertAtBeginning(Object data)
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

    public void insertAtEnd(Object data)
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

    public void insert(Object data, int index)
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

    public Object deleteFirst()
    {
        if(head==null)
            return (Object) "List is Empty!!";
        Object data=head.data;
        Node temp=head.next;
        head.next=null;
        head=temp;
        tail.next=head;
        return data;
    }

    public Object deleteLast()
    {
        if(head==null)
            return (Object) "List is Empty!!";
        Node temp=head;
        while(temp.next!=tail)
        {
            temp=temp.next;
        }
        Object data=tail.data;
        temp.next=head;
        tail=temp;
        return data;
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
