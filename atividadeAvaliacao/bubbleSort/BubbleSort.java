package bubbleSort;


public class BubbleSort {
	
	
	public static void main(String[] args) {
		int tamanho = 50000;
		int cont = 0;
		while(cont !=3) {
			
			int[] array = new int[tamanho];
			double[] tempo = new double[30];
			double mediaDeTempo = 0;
			
			
			for(int i=0; i < array.length; i++) {
				int numero = (int) Math.floor(Math.random() * (10000 -1) + 1);
				array[i] = numero;
			}
			

			for(int i = 0; i < 30; i++) {
				long tempoInicial = System.currentTimeMillis();
				bubbleSort(array);
				
				double tempoFinal = (System.currentTimeMillis() - tempoInicial)/1000.0;
				
				tempo[i] = tempoFinal;
				
			}
			
			for(double t: tempo) {
				mediaDeTempo+=t;
			}
			
			mediaDeTempo = mediaDeTempo / 30;
			
			System.out.println("Bubble:"
					+ " 1. Tamanho = "+ tamanho 
					+ " "
					+ "2. Tempo de execução = " + String.format("%.5f", mediaDeTempo));
			
			cont ++;
			if(cont == 1) {
				tamanho = 100000;
			} else if(cont == 2) {
				tamanho = 200000;
			}
		}
	}
	
	
	public static int[] bubbleSort(int[] vetor) {
		int auxiliar;
		
		for(int i = 0; i < vetor.length; i++) {
			boolean mudarPosicao = false;
			
			for(int j = 0; j < vetor.length - 1; j++) {
				if(vetor[j] > vetor[j + 1]){
					auxiliar = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = auxiliar;
					mudarPosicao = true;
				}
			}
			
			if(!mudarPosicao) {
				break;
			}
		}
		return vetor;
	}
}
