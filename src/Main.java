import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{  


		// Leer la entrada estandar
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese el límite (exclusivo) superior");
		int max=Integer.parseInt(reader.readLine());
		System.out.println("Ingrese el tiempo en milisegundos de los threads");
		int millis=Integer.parseInt(reader.readLine());
		System.out.println("Escriba sin comillas '1' para extender de la clase Thread o '2' para usar la interfaz Runnable");
		String ans = reader.readLine();
		
		if(ans.equals("1"))
		{
			heredarThread(max,millis);
		}
		else if (ans.equals("2"))
		{
			implementarRunnable(max, millis);
		}
	}
	
	public static void heredarThread(int max, int millis)
	{
		ExtendsThread t1 = new ExtendsThread(millis, max, false);
		ExtendsThread t2 = new ExtendsThread(millis, max, true);
		
		t1.start();
		t2.start();
	}
	
	public static void implementarRunnable(int max, int millis)
	{
		Thread t1 = new Thread(new ImplementsRunnable(millis, max, false));
		Thread t2 = new Thread(new ImplementsRunnable(millis, max, true));
		
		t1.start();
		t2.start();
	}
}