package taller1;
import java.util.concurrent.ThreadLocalRandom;

public class T1b_Matriz extends Thread {

	private final static int INT_MAX=105345;
	
	private final static int DIM=3;
	
	private static int[][] matriz = new int[DIM][DIM];
	
	private static int mayor = -1;
	
	private int mayorFila = -1;

	private int idThread;
			
	private int fila;
	
	public T1b_Matriz(int pIdThread,int pFila)
	{
		this.idThread=pIdThread;
		this.fila=pFila;
	}
	
	public static void crearMatriz()
	{
		for(int i =0;i<DIM;i++)
		{
			for(int j = 0;j<DIM;j++)
			{
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0,INT_MAX);
			}
		}
		
		System.out.println("Matriz:");
		System.out.println("======================================================");
		imprimirMatriz();
	}
	
	private static void imprimirMatriz()
	{
		for(int[] i :matriz)
		{
			for(int j:i)
			{
				System.out.append(j+"\t");
			}
			System.out.append("\n");
		}
	}
	
	public void run()
	{
		for(int j =0;j<DIM;j++)
		{
			if(this.mayorFila < matriz[this.fila][j])
			{
				this.mayorFila = matriz[this.fila][j];
			}
		}
		if(this.mayorFila>mayor)
		{
			try {
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			mayor=this.mayorFila;
			String warn = String.format(
					"====================== Nuevo maximo encontrado =======================\n"
					+ "ID Thread: %d - Maximo local actual: %d - Maximo Global: %d \n"
					+"\n"
					,this.idThread
					,mayor
					,this.mayorFila);
		System.out.println(warn);
		}
		
		String msg = String.format(
				
				"ID Thread: %d - Maximo local: %d - Maximo Global: %d"
				
				,this.idThread
				,this.mayorFila
				,mayor);
		System.out.println(msg);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Busqueda concurrente por una matriz");
		
		T1b_Matriz.crearMatriz();
		System.out.println();
		System.out.println("Iniciando la busqueda por la matriz \n");
		
		T1b_Matriz[] bThreads = new T1b_Matriz[DIM];	
		for(int i =0;i<DIM;i++)
		{
			bThreads[i]=new T1b_Matriz(i,i);
			bThreads[i].start();
		}
	}

}
