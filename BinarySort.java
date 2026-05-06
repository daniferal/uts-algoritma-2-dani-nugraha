public class BinarySort {
    // Helper function: Binary Search untuk mencari posisi sisip yang tepat
    static int binarySearch(int[] arr, int item, int low, int high) {
        if (high <= low) {
            return (item > arr[low]) ? (low + 1) : low;
        }

        int mid = (low + high) / 2;

        if (item == arr[mid]) return mid + 1;

        if (item > arr[mid]) {
            return binarySearch(arr, item, mid + 1, high);
        }
        
        return binarySearch(arr, item, low, mid - 1);
    }

    // 1. Kode Program Binary Insertion Sort
    static void binaryInsertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int selected = arr[i];

            // 3. OPTIMASI: Cari lokasi dimana elemen ini harus disisipkan menggunakan Binary Search
            int loc = binarySearch(arr, selected, 0, j);

            // Geser semua elemen ke kanan untuk memberikan ruang kosong
            while (j >= loc) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Sisipkan elemen pada lokasi yang tepat
            arr[j + 1] = selected;
        }
    }

    
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};
        System.out.print("Data sebelum Binary Sort: ");
        printArray(data);
        
        binaryInsertionSort(data);
        
        System.out.print("Data sesudah Binary Sort: ");
        printArray(data);
    }
}