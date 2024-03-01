public class SetThread extends java.lang.Thread {
    private int id;
   private Time time;

   public SetThread(int id, Time time){
       this.time = time;
       this.id = id;
   }
    public void run() {
        while (true) {
            System.out.println("Thread " + id + ": " + time);
            time.subtractSecond();
            if (time.isEnd()) {
                break;
            }
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Time getTime() {
        return time;
    }

    public static void main(String[] args) {
        Time time = new Time("23:59:59");
        SetThread nhanDu = new SetThread(1, time);
        nhanDu.start();
    }
}