package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Checkout.preload(getApplicationContext());

        final Activity activity = this;

        final Checkout co = new Checkout();

        try {
            String course = coursedatabase.name.get(com.example.uptoskills.course.vlog_position);
            String money = coursedatabase.price_rendered.get(com.example.uptoskills.course.vlog_position).substring(1);
            String m = money.substring(0,money.length()-3);
            String h = "";
            for (int i = 0; i < m.length(); i++) {
                if(m.charAt(i)<='9' && m.charAt(i)>='0'){
                    h = h + m.charAt(i);
                }
            }
            Log.d("oooo" , h+"");
            int x = Integer.parseInt(h);
            JSONObject options = new JSONObject();
            options.put("name", "Uptoskills");
            options.put("description", String.valueOf(course));
            options.put("send_sms_hash", true);
            options.put("allow_rotation", true);
            options.put("currency", "INR");
            options.put("amount", x*100);
            JSONObject preFill = new JSONObject();
            preFill.put("email", "hj9993019161@gmail.com");
            preFill.put("contact", "9993019161");
            options.put("prefill", preFill);
            co.open(activity, options);
        }
        catch(Exception e)
        {
            Log.d("error",e.getMessage());
        }

    }
    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(payment.this, "Course Enrolled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Unsuccessful", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(payment.this , courseview.class));

    }
}
