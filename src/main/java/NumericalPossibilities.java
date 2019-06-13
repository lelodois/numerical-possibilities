import java.util.*;

public class NumericalPossibilities {

    private List<Integer> result;

    public static void main(String args[]) {
        if (args == null || args.length != 1) throw new IllegalArgumentException("Deve possuir apenas um argumento");

        System.out.println(Arrays.toString(new NumericalPossibilities(args[0]).get()));
    }

    public Integer[] get() {
        return result.toArray(new Integer[0]);
    }

    public NumericalPossibilities(String arg) {
        this.validate(arg);
        this.result = asNumber(new TextPossibilities().generate(arg));
    }

    private List<Integer> asNumber(Set<String> generated) {
        List<Integer> newSet = new ArrayList<>();
        generated.stream().filter(s -> !s.startsWith("0")).forEach(item -> newSet.add(Integer.valueOf(item)));
        return newSet;
    }

    private void validate(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException("Deve receber um argumento numérico");
        }
    }
}

class TextPossibilities {

    public Set<String> generate(String text) {
        Set<String> emptySet = new HashSet<>();
        emptySet.add(new String());
        return text.isEmpty() ? emptySet : this.generate(text, new HashSet<>());
    }

    private Set<String> generate(String text, Set<String> allText) {
        char firstChar = text.charAt(0);

        this.generate(text.substring(1)).forEach(partial -> this.addAll(allText, firstChar, partial));

        return allText;
    }

    private void addAll(Set<String> set, char firstChar, String item) {
        for (int index = 0; index <= item.length(); index++) {
            StringBuilder builder = new StringBuilder();
            builder.append(item, 0, index).append(firstChar).append(item.substring(index));
            set.add(builder.toString());
        }
    }
}