package tw.core;

import org.junit.Before;

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
}