package a168;

class Sender
{
	public void send(String msg)
	{
		System.out.println("Sending "+msg);
		System.out.println(msg+" Sent");
	}
}

class Threadsend extends Thread
{
	Sender sender;
	String msg;
	public Threadsend(Sender sender,String msg)
	{
		// TODO Auto-generated constructor stub
		
		this.sender=sender;
		this.msg=msg;
	}
	public void run()
	{
		synchronized (sender)
		{
			sender.send(msg);
		}
	}
}


public class SyncronizeThreadEx
{
	public static void main(String[] args)
	{
		Sender sender=new Sender();
		Threadsend t1=new Threadsend(sender, "Hi");
		Threadsend t2=new Threadsend(sender, "Bye");
		t1.start();
		t2.start();
	}
}
