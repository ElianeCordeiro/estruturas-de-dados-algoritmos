package quickSort;

public class QuickSort {
	

	public static void main(String[] args) {
		int tamanho = 50000;
		int cont = 0;
		while(cont < 3) {
		
			int[] array = new int[tamanho];
			double[] tempo = new double[30];
			double mediaDeTempo = 0;
			
			for(int i = 0; i < array.length; i++) {
				int numero = (int) Math.floor(Math.random() * (10000 - 1) + 1);
				array[i] = numero;
			}
			
			
			
			for(int i = 0; i < 30; i++) {
				double tempoInicial = System.currentTimeMillis();
				quickSort(array, 0, array.length - 1);
				
				double tempoFinal = (System.currentTimeMillis() - tempoInicial)/ 1000.0;
				
				tempo[i] = tempoFinal;
			}
			
			for(double t: tempo) {
				mediaDeTempo +=t;
			}
			
			mediaDeTempo = mediaDeTempo / 30;

			System.out.println("QuickSort:"
					+ " 1. Tamanho = "+ tamanho 
					+ " 2. Tempo de execução = " + String.format("%.5f", mediaDeTempo));
			
			cont++;
			if(cont == 1) {
				tamanho = 100000;
			} else if (cont == 2) {
				tamanho = 200000;
			}
		}
	}
	
	public static int[] quickSort(int[] array, int esquerda, int direita) {
		if(esquerda < direita) {
			int p = particao(array, esquerda, direita);
			quickSort(array, esquerda, p);
			quickSort(array, p + 1, direita);
		}
		
		return array;
	}
	
	public static int particao(int[] lista, int esquerda, int direita) {
		int meio = (int) (esquerda + direita) / 2;
		int pivo = lista[meio];
		int i = esquerda - 1;
		int j = direita + 1;
		
		while(true) {
			do {
				i++;
			} while (lista[i] < pivo);
			do {
				j--;
			} while (lista[j] > pivo);
			
			if(i >= j) {
				return j;
			}
			
			int aux = lista[i];
			lista[i] = lista[j];
			lista[j] = aux;
		}
	}
}
