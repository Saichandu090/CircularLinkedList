public class MainCircular
{
    public static void main(String[] args)
    {

        CircularLinkedList<Integer> cl=new CircularLinkedList<Integer>();
        System.out.println(cl);
        System.out.println(cl.deleteLast());
        System.out.println(cl.deleteFirst());
        cl.insertAtBeginning(85);
        System.out.println(cl);
        cl.insertAtBeginning(82);
        cl.insertAtEnd(100);
        cl.insertAtBeginning(108);
        cl.insertAtEnd(8960);
        cl.insert(456,6); //Need to work on this
        System.out.println(cl);
        System.out.println(cl.delete(4));
        System.out.println(cl);

    }
}
