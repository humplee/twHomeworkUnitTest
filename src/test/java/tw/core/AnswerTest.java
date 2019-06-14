package tw.core;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    Answer answer;
    @Before
    public void setAnswer(){
        answer=Answer.createAnswer("1 3 5 6");
    }
    //answer presetting
    @Test
    public void should_the_number_be_judged_correctly_one(){
        assertThat(answer.check(Answer.createAnswer("1 2 3 4")).getValue(),is("1A1B"));
    }
    @Test
    public void should_the_number_be_judged_correctly_two(){
        assertThat(answer.check(Answer.createAnswer("1 3 5 6")).getValue(),is("4A0B"));
    }
    @Test
    public void should_the_number_be_judged_correctly_three(){
        assertThat(answer.check(Answer.createAnswer("7 8 9 0")).getValue(),is("0A0B"));
    }

}