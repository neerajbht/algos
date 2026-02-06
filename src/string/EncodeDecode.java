package string;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EncodeDecode {
    final String DE_LIMITER = ";";

    public String encode(List<String> strs) {

        if (strs.size() == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            //
            sb.append((Base64.getEncoder().encodeToString(str.getBytes())));
            sb.append(DE_LIMITER);// user to seperate the string

        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        if (str == null)
            return null;

        String[] message = str.split(DE_LIMITER);
        List<String> value = new ArrayList<String>();
        for (String msg : message) {

            value.add(new String(Base64.getDecoder().decode(msg), StandardCharsets.UTF_8));
        }
        return value;

    }

    public static void main(String[] argds) {

        List<String> as = new ArrayList<>();
        as.add("Fist");
        as.add("Second");
        as.add("third");
        EncodeDecode es = new EncodeDecode();

        String encoded = es.encode(as);
        System.out.println("encoded String>>>>>>> " + encoded);
        List<String> decoded = es.decode(encoded);
        System.out.println("decoded back");

        for (String s : decoded) {
            System.out.println(s);
        }

    }

}
