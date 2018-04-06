package ndseeg.goodhabits.profile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import ndseeg.goodhabits.R;

/**
 * Created by ndseeg on 12/26/17.
 */

public class ConfirmOverwriteDialogFragment extends ConfirmDialogFragment {
    private String titleMessage = "Overwrite Item?";

    public static ConfirmOverwriteDialogFragment newInstance(@Nullable String titleMessage) {
        Bundle args = new Bundle();
        args.putString("titleMessage", titleMessage);
        ConfirmOverwriteDialogFragment fragment = new ConfirmOverwriteDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
