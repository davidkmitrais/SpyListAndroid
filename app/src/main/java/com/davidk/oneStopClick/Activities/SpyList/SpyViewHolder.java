package com.davidk.oneStopClick.Activities.SpyList;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidk.oneStopClick.Helpers.Helper;
import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.R;

public class SpyViewHolder extends RecyclerView.ViewHolder {
    Context context;
    CardView cv;
    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    public SpyViewHolder(View itemView) {
        super(itemView);

        this.context = itemView.getContext();
        this.cv = (CardView) itemView.findViewById(R.id.card_view);
        this.personName = (TextView) itemView.findViewById(R.id.person_name);
        this.personAge = (TextView) itemView.findViewById(R.id.person_age);
        this.personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
    }

    public void configureWith(SpyDTO spy) {
        int imageId = Helper.resourceIdWith(context, spy.imageName);
        String age = String.valueOf(spy.age);

        personName.setText(spy.name);
        personAge.setText(age);
        personPhoto.setImageResource(imageId);
    }

}
