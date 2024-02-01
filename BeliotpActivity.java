package com.anseltsm.viadigital;

import android.animation.*;
import android.app.*;
import android.content.*;
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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BeliotpActivity extends AppCompatActivity {
	
	private HashMap<String, Object> Map = new HashMap<>();
	private HashMap<String, Object> Map2 = new HashMap<>();
	private String status = "";
	private String data = "";
	
	private ArrayList<String> negaraa = new ArrayList<>();
	private ArrayList<String> operatorr = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> get_servicee = new ArrayList<>();
	
	private LinearLayout linear1;
	private CardView cardview1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private LinearLayout linear9;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private Spinner negara;
	private Spinner operator;
	private Spinner layanan_otp;
	private MaterialButton materialbutton1;
	
	private RequestNetwork get_service;
	private RequestNetwork.RequestListener _get_service_request_listener;
	private RequestNetwork beli;
	private RequestNetwork.RequestListener _beli_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.beliotp);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		cardview1 = findViewById(R.id.cardview1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		linear9 = findViewById(R.id.linear9);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear10 = findViewById(R.id.linear10);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		negara = findViewById(R.id.negara);
		operator = findViewById(R.id.operator);
		layanan_otp = findViewById(R.id.layanan_otp);
		materialbutton1 = findViewById(R.id.materialbutton1);
		get_service = new RequestNetwork(this);
		beli = new RequestNetwork(this);
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_get_service_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					Map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
					status = (new Gson()).toJson(Map2.get("key"), new TypeToken<HashMap<String, Object>>(){}.getType());
					Map2 = new Gson().fromJson(status, new TypeToken<HashMap<String, Object>>(){}.getType());
					data = (new Gson()).toJson(Map.get("data"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					get_servicee = new Gson().fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					layanan_otp.setAdapter(new Layanan_otpAdapter(get_servicee));
					((BaseAdapter)layanan_otp.getAdapter()).notifyDataSetChanged();
				} catch (Exception e) {}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_beli_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		_Negara();
		_Operator();
		get_service.startRequestNetwork(RequestNetworkController.GET, "https://otpweb.com/api?api_key=396120fcd989ddefb5f8b63e0da5c8ca32ffecdf&action=get_service&country_id=6", "", _get_service_request_listener);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		get_service.startRequestNetwork(RequestNetworkController.GET, "https://otpweb.com/api?api_key=396120fcd989ddefb5f8b63e0da5c8ca32ffecdf&action=get_service&country_id=6", "", _get_service_request_listener);
	}
	public void _Negara() {
		negaraa.add("INDONESIA");
		negara.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, negaraa));
		((ArrayAdapter)negara.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _Operator() {
		operatorr.add("RANDOM");
		operator.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, operatorr));
		((ArrayAdapter)layanan_otp.getAdapter()).notifyDataSetChanged();
	}
	
	public class Layanan_otpAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Layanan_otpAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.otp, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView id_produk = _view.findViewById(R.id.id_produk);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout layar_status = _view.findViewById(R.id.layar_status);
			final TextView harga = _view.findViewById(R.id.harga);
			final TextView stok = _view.findViewById(R.id.stok);
			final TextView teks_status = _view.findViewById(R.id.teks_status);
			
			id_produk.setText(_data.get((int)_position).get("service_name").toString());
			harga.setText(_data.get((int)_position).get("cost").toString());
			
			return _view;
		}
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