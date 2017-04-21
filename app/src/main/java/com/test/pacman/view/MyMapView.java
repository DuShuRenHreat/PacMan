package com.test.pacman.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.test.pacman.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asdf on 2017/4/20.
 */

public class MyMapView extends View{
    public static final int[][] mFirst = {
            { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 },
            { 3, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 5, 0, 3 },
            { 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 3 },
            { 3, 0, 5, 0, 5, 0, 5, 0, 5, 5, 0, 5, 0, 3 },
            { 3, 0, 5, 0, 0, 0, 0, 5, 0, 5, 0, 5, 0, 3 },
            { 3, 0, 5, 0, 5, 0, 5, 0, 0, 5, 0, 0, 0, 3 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0 },
            { 0, 0, 0, 0, 5, 5, 0, 5, 5, 0, 0, 5, 0, 0 },
            { 3, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5, 0, 3 },
            { 3, 0, 5, 0, 5, 5, 5, 5, 5, 0, 5, 0, 0, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 },
            { 3, 0, 5, 5, 0, 5, 5, 5, 0, 5, 0, 5, 0, 3 },
            { 3, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 3 },
            { 3, 0, 5, 5, 0, 5, 0, 5, 5, 5, 0, 5, 0, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 }
    };
    public static final int[][] mSec = {
            { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
            { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
            { 5, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 5, 0, 5 },
            { 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 },
            { 5, 0, 5, 0, 5, 0, 5, 0, 5, 5, 0, 5, 0, 5 },
            { 5, 0, 5, 0, 0, 0, 0, 5, 0, 5, 0, 5, 0, 5 },
            { 5, 0, 5, 0, 5, 0, 5, 0, 0, 5, 0, 0, 0, 5 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0 },
            { 0, 0, 0, 0, 5, 5, 0, 5, 5, 0, 0, 5, 0, 0 },
            { 5, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5, 0, 5 },
            { 5, 0, 5, 0, 5, 5, 5, 5, 5, 0, 5, 0, 0, 5 },
            { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
            { 5, 0, 5, 5, 0, 5, 5, 5, 0, 5, 0, 5, 0, 5 },
            { 5, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 5 },
            { 5, 0, 5, 5, 0, 5, 0, 5, 5, 5, 0, 5, 0, 5 },
            { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
            { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }
    };
    public static final int[][] mThr = {
            { 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25 },
            { 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25 },
            { 25, 0, 25, 25, 25, 25, 25, 25, 25, 25, 0, 25, 0, 25 },
            { 25, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 25 },
            { 25, 0, 25, 0, 25, 0, 25, 0, 25, 25, 0, 25, 0, 25 },
            { 25, 0, 25, 0, 0, 0, 0, 25, 0, 25, 0, 25, 0, 25 },
            { 25, 0, 25, 0, 25, 0, 25, 0, 0, 25, 0, 0, 0, 25 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0 },
            { 0, 0, 0, 0, 25, 25, 0, 25, 25, 0, 0, 25, 0, 0 },
            { 25, 0, 25, 0, 25, 0, 0, 0, 25, 0, 0, 25, 0, 25 },
            { 25, 0, 25, 0, 25, 25, 25, 25, 25, 0, 25, 0, 0, 25 },
            { 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25 },
            { 25, 0, 25, 25, 0, 25, 25, 25, 0, 25, 0, 25, 0, 25 },
            { 25, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 0, 0, 25 },
            { 25, 0, 25, 25, 0, 25, 0, 25, 25, 25, 0, 25, 0, 25 },
            { 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25 },
            { 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25 }
    };
    public final static int TILE_WIDTH = 76;
    public final static int TILE_HEIGHT = 76;
    public final static int TILE_WIDTH_COUNT = 14;
    public final static int TILE_HEIGHT_COUNT = 17;
    public final static int TILE_NULL = 0;
    Bitmap bitmap = null;
    Paint paint = null;
    int widThleCount = 0;
    int heightTileCount = 0;
    int bitMapWidth = 0;
    int bitMapHeight = 0;
    public Canvas canvas;
    private PersonView man = null;

    public MyMapView(Context context) {
        super(context);
        initView(context);
    }
    public void addMan(PersonView view){
        this.man = view;
    }

    public MyMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MyMapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    public void initView(Context context){
        paint = new Paint();
        bitmap = ReadBitMap(context, R.drawable.pic);
        bitMapWidth = bitmap.getWidth();
        bitMapHeight = bitmap.getHeight();
        widThleCount = bitMapWidth / TILE_WIDTH;
        heightTileCount = bitMapHeight / TILE_HEIGHT;
    }
    public void raize(){
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.width  = 1064;
        lp.height = 1292;
        setLayoutParams(lp);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        DrawMap();
    }


    public void DrawMap(){
        int ViewID, ActorId,CollId;
        for(int i = 0 ; i < TILE_HEIGHT_COUNT; i++){
            for (int j = 0 ; j < TILE_WIDTH_COUNT;j++){
                ViewID = mFirst[i][j];
                ActorId = mSec[i][j];
                CollId = mThr[i][j];
                if(ViewID > TILE_NULL){
                    DrawMapTile(ViewID,j * TILE_WIDTH,i * TILE_HEIGHT);
                }
                if(ActorId > TILE_NULL){
                    DrawMapTile(ActorId,j * TILE_WIDTH,i * TILE_HEIGHT);
                }
                if(CollId > TILE_NULL){
                    DrawMapTile(CollId,j * TILE_WIDTH,i * TILE_HEIGHT);
                }
            }
        }

    }
    private void DrawMapTile(int id,int x,int y){
        id--;
        int count = id / widThleCount;
        int bitmapX = (id - (count * heightTileCount)) * TILE_WIDTH;
        int bitmapY = count * TILE_HEIGHT;
        DrawClipImage(x,y,bitmapX,bitmapY,TILE_WIDTH,TILE_HEIGHT);
    }
    private void DrawClipImage(int x,int y,int src_x,int src_y,int src_xp,int src_yp){
        canvas.save();
        canvas.clipRect(x,y, x + src_xp,y + src_yp);
        canvas.drawBitmap(bitmap,x - src_x,y - src_y,paint);
        canvas.restore();
    }

    public Bitmap ReadBitMap(Context context, int resId){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        Bitmap bitmap = BitmapFactory.decodeStream(is,null,options);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
