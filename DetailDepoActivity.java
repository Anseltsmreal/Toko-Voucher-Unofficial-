package com.anseltsm.viadigital;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class DetailDepoActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String dana = "";
	private String bca = "";
	private String bri = "";
	
	private LinearLayout linear1;
	private CardView cardview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout qris;
	private LinearLayout bank;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private TextView textview1;
	private TextView textview2;
	private TextView nominal;
	private TextView kode;
	private ImageView imageview2;
	private TextView textview5;
	private TextView metode;
	private ImageView imageview1;
	private TextView textview9;
	private TextView norek;
	private ImageView imageview3;
	private TextView textview7;
	private TextView id_depo;
	private ImageView imageview4;
	private TextView textview10;
	private TextView tgl;
	private TextView jam;
	
	private DatabaseReference kon = _firebase.getReference("pengaturan/koneksi");
	private ChildEventListener _kon_child_listener;
	private RequestNetwork tg;
	private RequestNetwork.RequestListener _tg_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.detail_depo);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		cardview1 = findViewById(R.id.cardview1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		qris = findViewById(R.id.qris);
		bank = findViewById(R.id.bank);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		nominal = findViewById(R.id.nominal);
		kode = findViewById(R.id.kode);
		imageview2 = findViewById(R.id.imageview2);
		textview5 = findViewById(R.id.textview5);
		metode = findViewById(R.id.metode);
		imageview1 = findViewById(R.id.imageview1);
		textview9 = findViewById(R.id.textview9);
		norek = findViewById(R.id.norek);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		id_depo = findViewById(R.id.id_depo);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		tgl = findViewById(R.id.tgl);
		jam = findViewById(R.id.jam);
		tg = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", nominal.getText().toString().concat(kode.getText().toString())));
				SketchwareUtil.showMessage(getApplicationContext(), "Disalin");
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", norek.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Disalin");
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", id_depo.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Disalin");
			}
		});
		
		_kon_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("qris").toString())).into(imageview1);
					dana = _childValue.get("dana").toString();
					bca = _childValue.get("bca").toString();
					bri = _childValue.get("bri").toString();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		kon.addChildEventListener(_kon_child_listener);
		
		_tg_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), _response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
	}
	
	private void initializeLogic() {
		nominal.setText(new DecimalFormat("#,###").format(Double.parseDouble(getIntent().getStringExtra("total").replace("000", ""))));
		kode.setText(getIntent().getStringExtra("kode"));
		metode.setText(getIntent().getStringExtra("metode"));
		id_depo.setText(getIntent().getStringExtra("id"));
		tgl.setText(getIntent().getStringExtra("tgl"));
		jam.setText(getIntent().getStringExtra("jam"));
		if (getIntent().getStringExtra("metode").equals("QRIS")) {
			bank.setVisibility(View.GONE);
		}
		else {
			bank.setVisibility(View.VISIBLE);
			qris.setVisibility(View.GONE);
			if (getIntent().getStringExtra("metode").equals("DANA")) {
				norek.setText(getIntent().getStringExtra("dana"));
			}
			else {
				if (getIntent().getStringExtra("metode").equals("BCA")) {
					norek.setText(getIntent().getStringExtra("bca"));
				}
				else {
					if (getIntent().getStringExtra("metode").equals("BRI")) {
						norek.setText(getIntent().getStringExtra("bri"));
					}
					else {
						
					}
				}
			}
		}
		textview11.setText("🔔MEMBER KAMU MELAKUKAN DEPOSIT SALDO, SILAHKAN PERIKSA DAN KONFIRMASI. \n\n              ".concat("             💸Total Deposit: ".concat(nominal.getText().toString().concat("".concat(kode.getText().toString().concat(" \n\n                    🪙Metode Deposit: ".concat(metode.getText().toString().concat("\n\n                             🕛Tgl / Jam: ".concat(tgl.getText().toString().concat("  ".concat(jam.getText().toString().concat("\n\n                   🆔ID Deposit: ".concat(id_depo.getText().toString().concat("\n\n                                                     📌Silahkan Periksa Dan Konfirmasi. Informasi Lengkap Periksa Aplikasi."))))))))))))));
		tg.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat(textview12.getText().toString().concat("/sendMessage?chat_id=".concat(textview13.getText().toString().concat("&text=".concat(textview11.getText().toString()))))), "EGSKETCHWARE", _tg_request_listener);
		textview11.setVisibility(View.GONE);
		textview12.setVisibility(View.GONE);
		textview13.setVisibility(View.GONE);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}