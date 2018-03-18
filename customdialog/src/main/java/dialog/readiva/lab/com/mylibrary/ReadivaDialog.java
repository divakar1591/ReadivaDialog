package dialog.readiva.lab.com.mylibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by divakar on 18/03/18.
 */

public class ReadivaDialog {

    private static final String TAG = ReadivaDialog.class.getSimpleName();
    private static ReadivaDialog instance = null;
    private Dialog dialog = null;
    @LayoutRes int layoutResID;
    @IdRes int viewResId;
    boolean isCancellable = true;

    private ReadivaDialog(){

    }

    public static ReadivaDialog dialog(){

        if(instance == null){
            synchronized (ReadivaDialog.class){
                if(instance == null){

                    instance = new ReadivaDialog();
                }
            }
        }
        return instance;
    }

    public ReadivaDialog setLayout(@LayoutRes int layoutResID){
        this.layoutResID = layoutResID;
        return this;
    }

    public ReadivaDialog setOkButtonId(@IdRes int viewResId){
        this.viewResId = viewResId;
        return this;
    }

    public ReadivaDialog setCanceble(boolean isCancellable){
        this.isCancellable = isCancellable;
        return  this;
    }



    public ReadivaDialog show(Activity activity){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(isCancellable);
        dialog.setContentView(layoutResID);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        try {
            Button dialogBtn_okay = (Button) dialog.findViewById(viewResId);
            dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });
        }catch (NullPointerException npe){
         //   Log.e(TAG, " # Error : "+npe, npe);
        }

        dialog.show();
        return this;
    }

    public ReadivaDialog show(Context activity){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(layoutResID);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        Button dialogBtn_okay = (Button) dialog.findViewById(viewResId);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
        return this;
    }




}
