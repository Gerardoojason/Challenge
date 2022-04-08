package id.ac.umn.app.challenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




class DialogFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }
}




//        Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
//        mShowDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
//                View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
//                final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
//                final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
//                Button mLogin = (Button) mView.findViewById(R.id.btnLogin);
//
//
////                mBuilder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                });
////
////                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        dialogInterface.dismiss();
////                    }
////                });
//                mBuilder.setView(mView);
//                final AlertDialog dialog = mBuilder.create();
//                dialog.show();
//                mLogin.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
//                            Toast.makeText(MainActivity.this,
//                                R.string.success_login_msg,
//                                Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//                        }else{
//                            Toast.makeText(MainActivity.this,
//                                R.string.error_login_msg,
//                                Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
////                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View view) {
////                        if (!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()) {
////                            Toast.makeText(MainActivity.this,
////                                    R.string.success_login_msg,
////                                    Toast.LENGTH_SHORT).show();
////                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
////                            dialog.dismiss();
////                        } else {
////                            Toast.makeText(MainActivity.this,
////                                    R.string.error_login_msg,
////                                    Toast.LENGTH_SHORT).show();
////                        }
////                    }
////                });
//            }
//        });
//    }
//}
//
//}