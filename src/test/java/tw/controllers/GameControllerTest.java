package tw.controllers;

import org.mockito.Mock;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

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
    private Answer errorAnswer;
    private GameController gameController;
}