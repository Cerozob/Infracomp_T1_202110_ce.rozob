package taller1;

public class T1b_Thread extends Thread {

	private static int contador = 0;

	public void run()
	{
		for(int i =0;i<10000;i++)
		{
			contador++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int j=1;j<=5;j++){
			contador=0;
			T1b_Thread[] t = new T1b_Thread[1000];

			for(int i =0;i<t.length;i++)
			{
				t[i] = new T1b_Thread();
				t[i].start();
			}

			System.out.println("Ejecución #"+j+": "+contador);
		}
	}

}
