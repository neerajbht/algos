package string;

public class AddString {
    /** considering no decimal */

    public String add(String a, String b) {

        String[] strA = a.split("\\.");
        String fractA = "";
        String wholeA = "";
        String wholeB = "";
        String fractB = "";
        if (strA.length > 1) {
            fractA = strA[0];
            wholeA = strA[1];

        } else {
            wholeA = a;
        }

        String[] strB = b.split("\\.");
        if (strB.length > 1) {
            fractB = strB[0];
            wholeB = strB[1];
        } else {
            wholeB = b;
        }

        String fractions = addString(fractA, fractB);
        if (fractions == null) {
            fractions = "";
        }
        String whole = addString(wholeA, wholeB);

        return addString(whole, fractions);

    }

    public String addString(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        if (i <= 0) {
            if (j <= 0)
                return null;
        }

        if (j <= 0) {
            if (i <= 0)
                return null;
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int total = digit1 + digit2 + carry;
            carry = total / 10;
            sb.append(total % 10);
            i--;
            j--;
        }

        return sb.reverse().toString();

    }

    public static void main(String[] ards) {
        String abc = "120.1";
        String n = "120";

        AddString ad = new AddString();
        System.out.println(ad.add(abc, n));

    }

}
