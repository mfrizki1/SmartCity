package id.co.iconpln.smartcity.util;

import android.content.Context;
import android.widget.FrameLayout;
import id.co.iconpln.smartcity.R;
import id.co.iconpln.smartcity.widget.InputEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rizki Maulana on 11/03/18.
 * email : rizmaulana@live.com
 * Mobile App Developer
 */

public class ValidatorUtils {
    public static final int NOT_EMPTY = 1;

    private List<FrameLayout> formView      = new ArrayList<>();
    private List<FrameLayout> formViewError = new ArrayList<>();

    private OnValidationListener onValidationListener;
    private Context              context;


    public ValidatorUtils(Context context) {
        this.context = context;

    }

    public void registerView(FrameLayout view) {
        if (!(view instanceof InputEditText)) {
            throw new RuntimeException("Class must be InputEditText or InputEditTextIdr");
        }
        if (!formView.contains(view)) {
            formView.add(view);
        }
    }


    public void removeRuleFromView(FrameLayout view) {
        formView.remove(view);
    }

    public void validate() {
        formViewError.clear();
        for (FrameLayout view : formView) {
            if (view.isShown()) {
                if (view instanceof InputEditText) {
                    if (((InputEditText) view).getEditText().getText().toString().isEmpty()) {
                        formViewError.add(view);
                        ((InputEditText) view).getTextInputLayout().setError(context.getResources().getString(R.string.err_form_required, ((InputEditText) view).getHint()));
                    }
                }
            }


        }

        if (formViewError.size() == 0) {
            onValidationListener.onValid();
        }
    }

    public void setOnValidationListener(OnValidationListener onValidationListener) {
        this.onValidationListener = onValidationListener;
    }

    public interface OnValidationListener {
        void onValid();

    }


}
