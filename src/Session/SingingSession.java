package Session;

public class SingingSession {
    
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new LinkQueue<Integer>();
        
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(7);
        queue.addQueue(8);
        
        queue.InsertEntry(10, 2);
        //System.out.println(queue.RemoveEntry(3));
        //queue.removeFirst();
        
        System.out.println(queue.countEntry());
        
        int num = queue.countEntry();
        for (int i = 0; i < num; i++) {
            System.out.println(queue.peek());
        }
        
    }
}
