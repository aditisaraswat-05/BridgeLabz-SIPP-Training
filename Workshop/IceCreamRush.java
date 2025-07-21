package Workshop;

import java.util.Scanner;

class icecream {
    String name;
    int sales;

    icecream(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }
}

public class IceCreamRush {
    public static void sales(icecream[] flavours) {
        int n = flavours.length;

        // bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flavours[j].sales < flavours[j + 1].sales) {
                    icecream temp = flavours[j];
                    flavours[j] = flavours[j + 1];
                    flavours[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = { "Chocolate", "Mango", "American Nuts", "Vanilla", "Buttersoch", "blueberry", "Kesar-Pista",
                "kaju-Pista" };
        icecream[] flavours = new icecream[8];
        System.out.println("Eneter the sale of each Flavour");
        for (int i = 0; i < 8; i++) {
            System.out.println(names[i] + " sale: ");
            int sales = sc.nextInt();
            flavours[i] = new icecream(names[i], sales);
        }
        sales(flavours);

        for (icecream flavour : flavours) {
            System.out.println(flavour.name + "-" + flavour.sales);
        }
        sc.close();
    }
}

// IceCreamRush- Sorting flavours by popularity
// Story:At "IceCreamRush", a small local vendor sells 8 different ice cream
// flavours. At the end of each week, the shopkeeper wants to sort these
// flavours based on how many times each was sold.
// Since the list is sort and he updates it manually, he prefers a simple
// sorting method- bubble sort- where he repeatedly compares adjacent sales
// figures and swap them if needed.
// concept involved:
// - bubble Sort
// -Small data size
// - repeated adjacent comparisons