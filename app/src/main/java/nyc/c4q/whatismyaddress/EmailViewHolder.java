package nyc.c4q.whatismyaddress;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 11/21/17.
 */

public class EmailViewHolder extends RecyclerView.ViewHolder {
   private TextView addressValue;
    private final Context context;
    public EmailViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public void bind(Emails emails){
        String emailValue = emails.getEmails();
        addressValue = (TextView) itemView.findViewById(R.id.email_textview);
        addressValue.setText(emailValue);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(context,DisplayActivity.class);
              String send = addressValue.getText().toString();
              intent.putExtra("emailaddress",send);
              context.startActivity(intent);
            }
        });
    }
}
