package com.example.weusthem_test.contactadd;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weusthem_test.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView contactview;
    private TextView firstname;
    private TextView lastname;
    private TextView email;
    private TextView phonenumber;

    public CustomViewHolder(@NonNull View customView) {
        super(customView);
        imageView = customView.findViewById(R.id.contact_view_image);
        contactview = customView.findViewById(R.id.contact_view_name);
        firstname = customView.findViewById(R.id.contact_view_FN);
        lastname=customView.findViewById(R.id.contact_view_LN);
        email=customView.findViewById(R.id.contact_view_email);
        phonenumber=customView.findViewById(R.id.contact_view_PHN);
    }
    public void bind(CustomData data){
        imageView.setImageResource(data.getImageID());
        contactview.setText(data.getContact());
        firstname.setText(data.getFirstname());
        lastname.setText(data.getLastname());
        email.setText(data.getEmail());
        phonenumber.setText(String.valueOf(data.getPhonenumber()));
    }
}
