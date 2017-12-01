package com.example.inventoryMVP.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.inventoryMVP.pojo.Dependency;
import com.example.inventoryMVP.ui.dependency.ListDependencyContract;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {

    public static final String MESSAGE = "mensaje";
    public static final String TITLE = "titulo";


    public static Dialog showConfirmDialog(final Bundle b, Context context, final ListDependencyContract.Presenter presenter){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(b.getString(MESSAGE));
        builder.setTitle(b.getString(TITLE));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteDependency((Dependency)b.getParcelable("dependencia"));
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();

    }
}
