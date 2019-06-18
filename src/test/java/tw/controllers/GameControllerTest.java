package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    @Mock
    private GameView mockGameView;
    @Mock
    private InputCommand mockCommand;
    @Mock
    private AnswerGenerator mockGenerator;
    @Mock
    private Game game;

    private Answer correctAnswer;
    private Answer wrongAnswer;
    private GameController gameController;

    @Before
    public void setGameController() throws Exception {
        MockitoAnnotations.initMocks(this);

        correctAnswer = Answer.createAnswer("1 2 3 4");
        wrongAnswer = Answer.createAnswer("1 2 5 6");

        when(mockGenerator.generate()).thenReturn(correctAnswer);
//        game = new Game(mockGenerator);
        gameController = new GameController(game, mockGameView);
    }
    @Test
    public void display_test() throws IOException {
        when(mockCommand.input()).thenReturn(correctAnswer);
        when(game.guessHistory()).thenReturn(new ArrayList<>());
        when(game.checkStatus()).thenReturn("");
        when(game.checkCoutinue()).thenReturn(true, false);
        when(game.guess(wrongAnswer)).thenReturn(new GuessResult("", wrongAnswer));
        GameController gameController = new GameController(game, mockGameView);
        //give a proper environment


        gameController.play(mockCommand);


        verify(mockGameView).showGuessResult(any());
        verify(mockGameView).showGuessHistory(anyList());
        verify(mockGameView).showGameStatus(anyString());
        //methods above are referencing answer.md 
    }
}