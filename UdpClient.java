public class UdpClient {
    public static final int port=11234;//porta del server
    
    public static void main(String[] args) throws SocketException, IOException {
        byte[] bufferIn=new byte[1024];//buffer dove inserire i dati ricevuti
         byte[] bufferOut=new byte[1024];//buffer dove inserire i dati da inviare 
        DatagramSocket socket = new  DatagramSocket();//si apre una socket da usare per inviare e ricevere dati
        InetAddress ip=InetAddress.getByName("localhost");//indirizzo ip del server sostituire localhost con l'indirizzo del server
       
        String messaggio="ciao ";//messaggio da inviare
      bufferOut=messaggio.getBytes();//il messaggio si inserisce nel buffer
          System.out.println("invio messaggio ");
        DatagramPacket  pacchetto=new DatagramPacket(bufferOut,bufferOut.length,ip,port);//si crea il pacchetto da inviare
        socket.send(pacchetto);//si invia il pacchetto
         pacchetto=new DatagramPacket(bufferOut,bufferOut.length);si prepara il pacchetto per la ricezione 
       socket.receive(pacchetto);//il client si mette in attesa 
         messaggio=new String(pacchetto.getData(),pacchetto.getOffset(),pacchetto.getLength());//si estraggono i dati dal pacchetto ricevuto
             System.out.println(messaggio +" ricevuto ");
              
        
    }
    
}
