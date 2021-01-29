
public class ExtendsThread extends Thread {

	private int limiteSuperior;
	private int sleepTime;
	private boolean pares;

	public ExtendsThread(int msSleep, int max,boolean pares) {
		this.limiteSuperior = max;
		this.sleepTime = msSleep;
		this.pares=pares;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(pares)
			{
				pares();
			}
			else
			{
				impares();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Saliendo");
		}
	}

	private void impares() throws InterruptedException
	{
		for(int i=1;i<limiteSuperior;i=i+2)
		{
			System.out.println(i);
			Thread.sleep(sleepTime);
		}
	}

	private void pares() throws InterruptedException
	{
		for(int i=2;i<limiteSuperior;i=i+2)
		{
			System.out.println(i);
			Thread.sleep(sleepTime);
		}
	}
}
