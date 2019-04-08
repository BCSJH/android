import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.techtown.mission9.R;

public class userItemView extends LinearLayout {
    TextView textView2;
    Button buttonView;
    EditText nameView;
    EditText yearView;
    EditText telView;
    public userItemView(Context context, AttributeSet attrs){
        super(context);
        init(context);
    }

    private void init(Context context) {
        LinearLayout inflater = (LinearLayout)context.getSystemService((context.LAYOUT_INFLATER_SERVICE));
        inflater.inflate(R.layout.activity_main,this,true);
        buttonView = findViewById(R.id.add);
        nameView = findViewById(R.id.name);
        yearView = findViewById(R.id.birthday);
        telView = findViewById(R.id.tel);
    }

    public void setName(String name){
        nameView.setText(name);
    }

    public void setButtonView(Button buttonView) {
        buttonView = setText();
    }
}
