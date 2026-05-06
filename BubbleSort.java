public class BubbleSort {
    // 1. Kode Program Bubble Sort dengan Optimasi
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped; // Penanda untuk optimasi
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset penanda setiap putaran baru
            
            for (int j = 0; j < n - i - 1; j++) {
                // Jika elemen saat ini lebih besar dari sebelahnya, tukar posisinya
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    swapped = true; // Tandai bahwa terjadi pertukaran
                }
            }
            
            // 3. OPTIMASI: Jika tidak ada pertukaran sama sekali di iterasi ini,
            // berarti array SUDAH urut. Hentikan proses lebih awal.
            if (!swapped) break;
        }
    }

    
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Data sebelum Bubble Sort: ");
        printArray(data);
        
        bubbleSort(data);
        
        System.out.print("Data sesudah Bubble Sort: ");
        printArray(data);
    }
}