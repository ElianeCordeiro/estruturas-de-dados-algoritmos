package mergeSort;

public class MergeSort {
	
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
				long tempoInicial = System.currentTimeMillis();
				mergeSort(array);
				
				double tempoFinal = (System.currentTimeMillis() - tempoInicial)/ 1000.0;
				
				tempo[i] = tempoFinal;
			}
			
			for(double t: tempo) {
				mediaDeTempo +=t;
			}
			
			mediaDeTempo = mediaDeTempo / 30;

			System.out.println("MergeSort:"
					+ " 1. Tamanho = "+ array.length 
					+ " 2. Tempo de execução = " + String.format("%.5f", mediaDeTempo));
			
			cont++;
			if(cont == 1) {
				tamanho = 100000;
			} else if (cont == 2) {
				tamanho = 200000;
			}
		}
	}
	
	public static void mergeSort(int[] array) {
		int arrayTamanho = array.length;
		
		if(arrayTamanho < 2) {
			return;
		}
		
		int meio = arrayTamanho/2;
		int[] metadeEsquerda = new int[meio];
		int[] metadeDireita = new int[arrayTamanho - meio];
		
		for(int i = 0; i < meio; i++) {
			metadeEsquerda[i] = array[i];
		}
		
		for(int i = meio; i < arrayTamanho; i++) {
			metadeDireita[i - meio] = array[i];
		}
		
		mergeSort(metadeEsquerda);
		mergeSort(metadeDireita);

		merge(array, metadeEsquerda, metadeDireita);
	}
	
	public static void merge(int[] array, int[] metadeEsquerda, int[] metadeDireita) {
		int ladoEsquerdo = metadeEsquerda.length;
		int ladoDireito = metadeDireita.length;
		
		int i = 0;
		int j= 0;
		int k = 0;
		
		while(i < ladoEsquerdo && j < ladoDireito) {
			if(metadeEsquerda[i] <= metadeDireita[j]) {
				array[k] = metadeEsquerda[i];
				i++;
			
			} else {
				array[k] = metadeDireita[j];
				j++;
			}
			k++;
		}
		
		while(i < ladoEsquerdo) {
			array[k] = metadeEsquerda[i];
			i++;
			k++;
		}
		
		while(j < ladoDireito) {
			array[k] = metadeDireita[j];
			j++;
			k++;
		}
	}
	
	
	
}
