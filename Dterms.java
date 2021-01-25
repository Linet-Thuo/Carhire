package com.linet.carhire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dterms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dterms);

        TextView mTitleWindow = (TextView) findViewById(R.id.titleWindow);
        TextView mMessageWindow = (TextView) findViewById(R.id.messageWindow);

        mTitleWindow.setText("Terms and Condition Agreement.");

        StringBuilder stringBuilder =new StringBuilder();
        String termMessage = " Terms and conditions of Cartrst ride\n" +
                "\n" +
                "Requesting Procedure\n" +
                "\n" +
                "The following requesting conditions, \n" +
                "\n" +
                "In this contract a reference to “you” and “your” include the lead-named person on the confirmation (The driver has to be 18 years old and above)\n" +
                "\n" +
                "There are four rides that are offered \n" +
                "\n" +
                "Piki piki ride\n" +
                "\n" +
                "Mini ride\n" +
                "\n" +
                "Comfy ride\n" +
                "\n" +
                "Exclusive ride\n" +
                "\n" +
                "\n" +
                "If you make a ride request on behalf of others as well as yourself, we shall take it that you have the authority of each of those other people to enter into that contract and that you and they have agreed to be jointly and severally liable to us. You now accept personal liability for the acceptance and compliance of each of those people.\n" +
                "\n" +
                "For you to request a ride we require to give the required details \n" +
                "Your exact location and your final destination \n" +
                "\n" +
                "What is included in the estimated price of a cartrst ride?\n" +
                "\n" +
                "pickup and drop-off at the locations specified in your ride;\n" +
                "wait time of up to one hour at an additional cost;\n" +
                "\n" +
                "\n" +
                "Full payment is to be paid immediately the ride ends\n" +
                "\n" +
                "Surcharges\n" +
                "\n" +
                "The estimated prices are calculated at costs current at the time we fixed them\n" +
                "Factors that are considered are \n" +
                "Distance traveled \n" +
                "Traffic \n" +
                "Time travelled \n" +
                "\n" +
                "If we increase the price of your estimated price by more than 5%, you can send a complain \n" +
                "\n" +
                "Cancellations by us \n" +
                "\n" +
                "If you want the cancellation to be done by us one is required to call the driver and request a cancellation based on a valid reason\n" +
                "\n" +
                "\n" +
                "Cancellation by you\n" +
                "\n" +
                "We reserve the right to cancel a ride if the driver has delayed, In the event of our cancellation, one won't be required to pay \n" +
                "\n" +
                "Payment Type\n" +
                "\n" +
                "All payments to us may be made through the options provided in the application \n" +
                "Payments should be done at the end of the trip \n" +
                "\n" +
                "You agree that all these provisions are reasonable.\n" +
                "\n" +
                "Limitations on our liability\n" +
                "\n" +
                "We want you to enjoy your ride with Cartrst. We shall do our best to make your ride special and comfortable for you. Nonetheless, we must make clear the limitations in law. We are not liable to you for:\n" +
                "\n" +
                "any event which happens before you board our transport at the pickup location or after you leave our transport at the drop off location;\n" +
                "any problem arising from your failure to reach the pickup location on time, for whatever reason;\n" +
                "any problem that are out of our control to reach the drop off location on time;\n" +
                "medical problems or physical difficulties, even if you have told us about them in advance;\n" +
                "medical emergencies;\n" +
                "your own carelessness or negligence in any aspect of your behaviour whilst with us;\n" +
                "problems or issues which you have not raised during the transfer.\n" +
                "Help we need from you\n" +
                "\n" +
                "Proper conduct \n" +
                "\n" +
                "Smoking, drinking or eating are not permitted in the vehicle.\n" +
                "If at any time, it is our opinion (given by any of our driver ) that you are acting in a way which may cause accident, injury, discomfort or extreme displeasure to any other passengers or the driver, you may be asked to leave the vehicle. You will understand that this extreme action will not be taken lightly but may be necessary to protect the health, safety or enjoyment of other clients.\n" +
                "\n" +
                "Complaints\n" +
                "\n" +
                "We shall try our utmost to provide a happy and safe ride, but if we fail in any way, do please raise any issue with the driver. If your complaint cannot be satisfied it is not dealt with to your satisfaction at the time of reporting it to the driver, then you should give us full details in writing, immediately on your return.\n" +
                "\n" +
                "The validity, construction and performance of this agreement shall be governed by the laws of Kenya.Any dispute arising in connection with this agreement shall be subject to the exclusive jurisdiction of the courts.";

        mMessageWindow.setText(stringBuilder.toString());
    }
}
