import java.util.*;

public class Main {
    public static void main(String args[]) {

        String dates[] = {"12041996", "20101996", "05061997", "12041989", "11081987"};

        sortDates(dates);

        for(String e: dates) {
            System.out.println(e);
        }
    }

    static void sortDates(String dates[]) {
        // Date
        countSort(dates, 1000000, 100, 32);

        // Month
        countSort(dates, 10000, 100, 13);

        // Year
        countSort(dates, 1, 10000, 2501);
    }

    static void countSort(String dates[], int div, int mod, int range) {

        int n = dates.length;

        int freq[] = new int [range];

        for(int i=0; i<n; i++) {
            freq[Integer.parseInt(dates[i], 10) / div % mod]++;
        }

        for(int i=1; i<freq.length; i++) freq[i] += freq[i-1];

        String output[] = new String [n];

        for(int i=n-1; i>=0; i--) {
            output[--freq[Integer.parseInt(dates[i], 10) / div % mod]] = dates[i];
        }

        for(int i=0; i<n; i++) {
            dates[i] = output[i];
        }
    }
}
