package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;
    @Before
    public void setGame() throws OutOfRangeAnswerException {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }
    
    @Test
    public void Game_State_Test_Success() throws OutOfRangeAnswerException {
        game.guess(Answer.createAnswer("1 3 4 5"));
        game.guess(Answer.createAnswer("2 5 8 0"));
        game.guess(Answer.createAnswer("2 5 8 1"));
        String gameState = game.checkStatus();
        assertThat(gameState,is("continue"));
        Boolean continueFlag = game.checkCoutinue();
        assertThat(continueFlag,is(true));
        game.guess(Answer.createAnswer("1 2 3 4"));
        gameState = game.checkStatus();
        assertThat(gameState,is("success"));
    }
    @Test
    public void Game_State_Test_Fail() throws OutOfRangeAnswerException {
        game.guess(Answer.createAnswer("1 3 4 5"));
        game.guess(Answer.createAnswer("2 5 8 0"));
        game.guess(Answer.createAnswer("2 5 8 1"));
        game.guess(Answer.createAnswer("1 2 3 5"));
        game.guess(Answer.createAnswer("1 2 3 5"));
        game.guess(Answer.createAnswer("1 2 3 5"));
        String gameState = game.checkStatus();
        assertThat(gameState,is("fail"));
        Boolean continueFlag = game.checkCoutinue();
        assertThat(continueFlag,is(false));
    }
}
