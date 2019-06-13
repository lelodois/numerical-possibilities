import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumericalPossibilitiesTest {

    @Test
    @DisplayName("Testar o parametro de unico valor")
    public void whenNumberIsUnity() {
        int[] values = {2};
        assertThat(values, Matchers.is(new NumericalPossibilities("2").get()));
    }

    @Test
    @DisplayName("Testar o parametro com numero igual")
    public void whenNumberIsEqual() {
        int[] values = {44};
        assertThat(values, Matchers.is(new NumericalPossibilities("44").get()));
    }

    @Test
    @DisplayName("Testar o parametro que contenha zero")
    public void whenNumberContainsZeroTest() {
        int[] values = {210, 102, 201, 120};
        assertThat(values, Matchers.is(new NumericalPossibilities("120").get()));
    }

    @Test
    @DisplayName("Testar todas as possibilidades")
    public void whenFullCombinationsTest() {
        int[] values = {243, 342, 234, 432, 423, 324};
        assertThat(values, Matchers.is(new NumericalPossibilities("432").get()));
    }

    @DisplayName("Testar com caracter invalido")
    @Test
    public void whenInvalidParameter() {
        assertThrows(IllegalArgumentException.class, () -> new NumericalPossibilities("123@").get());
    }

    @DisplayName("Testar com texto")
    @Test
    public void whenTextParameter() {
        assertThrows(IllegalArgumentException.class, () -> new NumericalPossibilities("teste").get());
    }
}
