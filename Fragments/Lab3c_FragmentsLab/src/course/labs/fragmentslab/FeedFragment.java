package course.labs.fragmentslab;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {

	private static final String TAG = "Lab-Fragments/FeedFragment";

	private TextView mTextView;
	private static FeedFragmentData feedFragmentData;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreateView()");

		return inflater.inflate(R.layout.feed, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(TAG, "Entered onActivityCreated()");
		
		super.onActivityCreated(savedInstanceState);

		// Read in all Twitter feeds 
		if (null == feedFragmentData) { 
			
			feedFragmentData = new FeedFragmentData(getActivity());

		}
	}
	
	@Override 
	public void onStart() {
		Log.i(TAG, "Entered onStart()");
		
		super.onStart();
	}
	
	@Override 
	public void onResume() {
		Log.i(TAG, "Entered onResume()");
		
		super.onResume();
	}
	
	@Override 
	public void onPause() {
		Log.i(TAG, "Entered onPause()");
	
		super.onPause();
	}
	
	@Override 
	public void onStop() {
		Log.i(TAG, "Entered onStop()");
		
		super.onStop();
	}
	
	@Override 
	public void onDestroyView() {
		Log.i(TAG, "Entered onDestroyView()");
		
		super.onDestroyView();
	}
	
	@Override 
	public void onDestroy() {
		Log.i(TAG, "Entered onDestroy()");
		
		super.onDestroy();
	}
	
	@Override 
	public void onDetach() {
		Log.i(TAG, "Entered onDetach()");
		
		super.onDetach();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreate()");
		
		super.onCreate(savedInstanceState);
		
		setRetainInstance(true);
	}

	// Display Twitter feed for selected feed

	void updateFeedDisplay(int position) {

		Log.i(TAG, "Entered updateFeedDisplay()");
				
		mTextView = (TextView) getView().findViewById(R.id.feed_view);
		mTextView.setText(feedFragmentData.getFeed(position));

	}

}
