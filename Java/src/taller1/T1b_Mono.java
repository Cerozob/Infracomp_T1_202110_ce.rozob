package taller1;
public final class T1b_Mono {
	private int contador=0;
	
	public void incrementar() {
		for(int i =0;i<10000;i++)
		{
			contador++;
		}
	}

	public int getContador()
	{
		return contador;
	}

	public static void main(String[] args)
	{
		T1b_Mono c = new T1b_Mono();

		for(int i =0;i<1000;i++)
		{
			c.incrementar();
		}
		System.out.println(c.getContador());
	}
}
