package nyc.c4q.whatismyaddress;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by c4q on 11/21/17.
 */

public class EmailsAdapter extends RecyclerView.Adapter<EmailViewHolder> {

    private List<Emails> emailList;

    public EmailsAdapter(List<Emails> emailList){
        this.emailList = emailList;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_itemview,parent,false);
        return new EmailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        Emails emails = emailList.get(position);
        holder.bind(emails);
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }
}
