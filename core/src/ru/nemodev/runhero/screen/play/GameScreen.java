package ru.nemodev.runhero.screen.play;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.nemodev.runhero.manager.GameManager;
import ru.nemodev.runhero.manager.GameStatus;
import ru.nemodev.runhero.scene.game.GameBackgroundScene;
import ru.nemodev.runhero.scene.game.GameScene;
import ru.nemodev.runhero.scene.game.ScoreScene;
import ru.nemodev.runhero.screen.common.BaseScreen;

import static ru.nemodev.runhero.constant.GameConstant.METERS_X;
import static ru.nemodev.runhero.constant.GameConstant.METERS_Y;

/**
 * created by NemoDev on 06.05.2018 - 19:31
 */
public class GameScreen extends BaseScreen
{
    private GameBackgroundScene gameBackgroundScene;
    private GameScene gameScene;
    private ScoreScene scoreScene;

    public GameScreen()
    {
        super();

        Batch batch = GameManager.getInstance().getSpriteBatch();

        initBackgroundScene(batch);
        initGameScene(batch);
        initScoreScene(batch);

        GameManager.getInstance().setGameStatus(GameStatus.RUNNING);
    }

    private void initBackgroundScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(METERS_X, METERS_Y);

        gameBackgroundScene = new GameBackgroundScene(new ExtendViewport(METERS_X, METERS_Y, METERS_X, METERS_Y, camera), batch);
        addScene(gameBackgroundScene);
    }

    private void initGameScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(METERS_X, METERS_Y);

        gameScene = new GameScene(
                new World(new Vector2(0.f, -9.81f), true),
                new ExtendViewport(METERS_X, METERS_Y, METERS_X, METERS_Y, camera),
                batch);

        addScene(gameScene);
    }

    private void initScoreScene(Batch batch)
    {
        scoreScene = new ScoreScene(new ScreenViewport(), batch);
        addScene(scoreScene);
    }
}
