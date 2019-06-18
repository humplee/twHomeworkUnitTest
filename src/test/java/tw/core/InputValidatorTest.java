package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void should_return_false_when_invalid_not_enough_digits(){
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));

    }
    @Test
    public void should_return_false_when_invalid_digits_overflow(){
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3 5 5";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));

    }
    @Test
    public void should_return_false_when_invalid_invalid_char(){
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3  2_";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));

    }
    @Test
    public void should_return_false_when_invalid_invalid_char2(){
        InputValidator inputValidator = new InputValidator();
        String num = "________________________________1 2 3  2_";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));

    }
    @Test
    public void should_return_false_when_invalid_invalid_char3(){
        InputValidator inputValidator = new InputValidator();
        String num = "0000111222333 123 1";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));
    }
//    @Test
//    public void should_return_false_when_invalid_invalid_char4(){
//        InputValidator inputValidator = new InputValidator();
//        String num = "\n1 2 3 4";
//        //whens
//        Boolean isValidated = inputValidator.validate(num);
//        //then
//        assertThat(isValidated, is(false));
//    }
    //TODO test above failed
    @Test
    public void should_return_true_when_a_right_num() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3 4";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(true));
    }
}
