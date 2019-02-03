package ru.nemodev.runhero.entity.play.background;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Pool;

import ru.nemodev.runhero.entity.common.BaseStaticActor;


/**
 * created by NemoDev on 08.05.2018 - 20:04
 */
public class BackgroundActor extends BaseStaticActor implements Pool.Poolable
{
    protected final Sprite background;

    public BackgroundActor(Sprite background)
    {
        this.background = background;
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        background.draw(batch);
    }

    @Override
    public void reset()
    {

    }
}