package com.android.dwealthapp.view.adapter;

/*
 * Created by rishav on 25/1/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.dwealthapp.R;
import com.android.dwealthapp.model.QuestionaryModel;

import java.util.ArrayList;

public class QuestionaryAdapter extends RecyclerView.Adapter<QuestionaryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<QuestionaryModel> list;
    private int selectedPosition = 0;

    public QuestionaryAdapter(Context context, ArrayList<QuestionaryModel> list, int selectedPosition) {
        this.context = context;
        this.list = list;
        this.selectedPosition = selectedPosition;
    }

    public void customNotify(ArrayList<QuestionaryModel> list, int selectedPosition) {
        this.list = list;
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       /* switch (position) {

        }*/
        holder.questNo.setText(selectedPosition + 1 + " ");
        holder.quesTitle.setText(list.get(selectedPosition).getQuestions());
        if (!list.get(selectedPosition).getOptionsList().get(position).getOption1().isEmpty())
            holder.questionOption1.setText(list.get(selectedPosition).getOptionsList().get(position).getOption1());
        else
            holder.questionOption1.setVisibility(View.GONE);

        if (!list.get(selectedPosition).getOptionsList().get(position).getOption2().isEmpty())
            holder.questionOption2.setText(list.get(selectedPosition).getOptionsList().get(position).getOption2());
        else
            holder.questionOption2.setVisibility(View.GONE);

        if (!list.get(selectedPosition).getOptionsList().get(position).getOption3().isEmpty())
            holder.questionOption3.setText(list.get(selectedPosition).getOptionsList().get(position).getOption3());
        else
            holder.questionOption3.setVisibility(View.GONE);

        if (!list.get(selectedPosition).getOptionsList().get(position).getOption4().isEmpty())
            holder.questionOption4.setText(list.get(selectedPosition).getOptionsList().get(position).getOption4());
        else
            holder.questionOption4.setVisibility(View.GONE);

        if (selectedPosition==6){
            holder.chooseTitle.setText("Choose between A~E");
            holder.layoutquest_7.setVisibility(View.VISIBLE);
            holder.questionOption5.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView questNo, quesTitle, questionOption1, questionOption2, questionOption3,
                questionOption4,questionOption5,chooseTitle;
        private LinearLayout layoutquest_7;
        public ViewHolder(View itemView) {
            super(itemView);

            questNo = itemView.findViewById(R.id.questNo);
            quesTitle = itemView.findViewById(R.id.questTite);
            questionOption1 = itemView.findViewById(R.id.option1);
            questionOption2 = itemView.findViewById(R.id.option2);
            questionOption3 = itemView.findViewById(R.id.option3);
            questionOption4 = itemView.findViewById(R.id.option4);
            questionOption5 = itemView.findViewById(R.id.option5);
            layoutquest_7 = itemView.findViewById(R.id.layout7);
            chooseTitle = itemView.findViewById(R.id.chooseTitle);
        }
    }
}