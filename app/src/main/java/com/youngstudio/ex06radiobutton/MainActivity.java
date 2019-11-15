package com.youngstudio.ex06radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰들 참조변수 : 멤버변수
    TextView tv;
    RadioGroup rg;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        rg= findViewById(R.id.rg);

        //RadioButton은 버튼마다 리스너로 제어하지 않고..
        //RadioGroup으로 한번에 처리함
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //체크된 RadioButton 찾아오기
                RadioButton rb = findViewById(checkedId);
                tv.setText(rb.getText().toString());
            }
        });

        ratingBar= findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean byUser) {

                //2번쨰 파라미터 : 선택된 rating값
                //3번쨰 파라미터 : 사용자가 터치를 이용해서 값을 변경했는지 여부

                tv.setText(rating + "점");

            }
        });


    }

    //onClick속성이 부여된 View가 클릭되면
    //자동으로 호출되는 콜백메소드
    public void clickBtn(View v){
        //RadioGroup에게 체크된 RadioButton의 id값을 얻어오기
        int id= rg.getCheckedRadioButtonId();

        RadioButton rb= findViewById(id);
        tv.setText( rb.getText().toString() );

    }
}










