public class timer {
    private long start;
    private long end;
    private boolean running;

    public void Start(){
        start=System.currentTimeMillis();
        running=true;
    }


    public void Stop(){
        end=System.currentTimeMillis();
        running=false;
    }

    public long Duration(){
            if(running){
                return System.currentTimeMillis()-start;
            }
            return end-start;
    }
}
