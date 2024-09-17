package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ValidationTest {


    // BEGIN
    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    @Test
    void testAdvancedValidate() {
        String err1 = "length less than 4";
        String err2 = "can not be null";
        Map<String, List<String>> mustBe = new HashMap<>();
        List<String> strings;
        //1
        strings = new ArrayList<>(List.of(err1));
        mustBe.put("country", strings);
        strings = new ArrayList<>(List.of(err2));
        mustBe.put("street", strings);
        Address address1 = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields1 = Validator.advancedValidate(address1);
        assertThat(notValidFields1.equals(mustBe));

        //2
        mustBe.clear();
        mustBe.put("country", new ArrayList<>(List.of(err1, err2)));
        Address address2 = new Address("", "Dvachsk", "Ololoeva street", "1000", "");
        Map<String, List<String>> notValidFields2 = Validator.advancedValidate(address2);
        assertThat(notValidFields2.equals(mustBe));


    }

    // END
}
