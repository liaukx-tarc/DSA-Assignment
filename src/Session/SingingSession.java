package Session;

public class SingingSession {
    public static QueueInterface<Integer> queue = new LinkQueue<Integer>();

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SessionFrame().setVisible(true);
            }
        });
    }
    
    public class songQueue{
        String member;
        String song;
        
        songQueue(String member, String song){
           this.member = member;
           this.song = song;
        }
    }
}
