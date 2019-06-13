import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumericalPossibilities {

    private List<Integer> result;

    public Integer[] get() {
        return result.toArray(new Integer[0]);
    }

    public NumericalPossibilities(String arg) {
        this.validate(arg);
        this.result = asNumber(new TextPossibilities().generate(arg));
    }

    private List<Integer> asNumber(Set<String> generated) {
        List<Integer> newSet = new ArrayList<>();
        generated
                .stream()
                .filter(s -> !s.startsWith("0"))
                .forEach(item -> newSet.add(Integer.valueOf(item)));
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
        return text.isEmpty()
                ? Sets.newHashSet(new String())
                : this.generate(text, new HashSet<>());
    }

    private Set<String> generate(String text, Set<String> allText) {
        char firstChar = text.charAt(0);

        this.generate(text.substring(1))
                .forEach(partial -> this.addAll(allText, firstChar, partial));

        return allText;
    }

    private void addAll(Set<String> set, char firstChar, String item) {
        for (int index = 0; index <= item.length(); index++){
            StringBuilder builder = new StringBuilder();
            builder.append(item, 0, index).append(firstChar).append(item.substring(index));
            set.add(builder.toString());
        }
    }
}